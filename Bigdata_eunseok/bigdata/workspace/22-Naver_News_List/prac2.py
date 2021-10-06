import requests
import sys
from bs4 import BeautifulSoup
# 한글 분석 모듈과 wordcloud 모듈
from wordcloud import WordCloud
from collections import Counter
from konlpy.tag import Okt

user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38'
headers = {'User-Agent':user_agent, 'Referer':None}

index_url = 'https://sports.news.naver.com/ranking/index'

r = requests.get(index_url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

soup = BeautifulSoup(r.text, 'html.parser')

selector = soup.select('.newscenter a.title')
#print(selector)
print('-' * 40)

url_list = []
for item in selector[:10]:
    if 'href' in item.attrs:
        url_list.append(item.attrs['href'])

#print(url_list)
print('-' * 40)

###################################
import os
import datetime as dt

date_str = dt.datetime.now().strftime('%y%m%d_%H%M%S')
dir_name = '스포츠뉴스기사_' + date_str

if not os.path.exists(dir_name):
    os.mkdir(dir_name)
    
content_merge = ''

for i, url in enumerate(url_list):
    print('%d번째 뉴스기사 수집중... >> ' %(i+1), end='')
    
    temp_url = 'https://sports.news.naver.com'
    r = requests.get(temp_url + url, headers=headers)
    
    if r.status_code != 200:
        print('[Error]', r.status_code)
        sys.exit()
        
    # 기사 본문 추출
    soup = BeautifulSoup(r.text, 'html.parser')
    
    title = soup.select('.content_area .title')[0].text
    
    content = soup.select('#newsEndContents')
    
    for target in content[0].select('p'): target.extract()
    for target in content[0].select('br'): target.replace_with('\n')
    
    for target in content[0].select('.reporter_area'): target.extract()
    for target in content[0].select('.copyright'): target.extract()
    for target in content[0].select('.categorize'): target.extract()
    for target in content[0].select('.promotion'): target.extract()
    content_str = content[0].text.strip()
    
    print()
    #print(title)
    #print(content_str)
    print('-' * 40)
    
    content_merge += content_str

print(content_merge)
print('-' * 40)

# 워드 클라우드 시각화
# 기사 내용에서 명사만 추출
# konlpy 모듈로, 형태소 분석, 명사만 추출
nlp = Okt()

nouns = nlp.nouns(content_merge)

# 단어 100개만 확인
print(nouns[:100])
print('-' * 40)
print(len(nouns))
print('-' * 40)

for i, v in enumerate(nouns):
    if len(v) < 2 : del(nouns[i])
    
print(len(nouns))
print('-' * 40)

# 단어별 빈도수 검사
count = Counter(nouns)

print(count)
print('-' * 40)

print(len(count))
print('-' * 40)

most = count.most_common(20) # 가장 빈도수가 높은 20개 단어 추출

print(most)
print('-' * 40)

print(len(most))
print('-' * 40)

tags = {}

for n, c in most:
    tags[n] = c
    
print(tags)
print('-' * 40)

wc = WordCloud(font_path='data/NanumBarunGothic.ttf',
               width=1200, height=600, background_color='white')
# 워드 클라우드 그래프 생성
wc.generate_from_frequencies(tags)

wc.to_file('news.png')

import matplotlib.pyplot as plt

fig = plt.figure(figsize=(10, 10))
plt.imshow(wc)
plt.axis('off')
plt.show()