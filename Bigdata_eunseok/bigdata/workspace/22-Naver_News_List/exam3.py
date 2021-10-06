import requests
import sys
from bs4 import BeautifulSoup
# 한글 분석 모듈과 wordcloud 모듈
from wordcloud import WordCloud
from collections import Counter
from konlpy.tag import Okt

user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38"
headers = {'User-Agent':user_agent, 'Referer':None}

content_url = 'https://news.naver.com'

r = requests.get(content_url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()
    
#print(r.text)
print('-' * 40)

soup = BeautifulSoup(r.text, 'html.parser')

selector = soup.select('.hdline_flick_item > a, .hdline_article_tit > a,'
                       + '.mtype_list_wide > .mlist2 > li > a,'
                       + '.mtype_img > dt > a')

if not selector:
    print('크롤링 실패')
    sys.exit()
    
#print(selector)
print('-' * 40)

url_list = []

for item in selector:
    if 'href' in item.attrs:
        url_list.append(item['href'])
        
for i, v in enumerate(url_list):
    if content_url not in v:
        url_list[i] = content_url + v

for i, v in enumerate(url_list):
    if 'clusterArticles' in v:
        del(url_list[i])
        
print(url_list)
print(len(url_list))
print('-' * 40)

content_merge = ''

for i, url in enumerate(url_list):
    print('%d번째 뉴스기사 수집중... >> ' %(i+1), end='')
    
    r = requests.get(url, headers=headers)
    
    if r.status_code != 200:
        print('[Error]', r.status_code)
        sys.exit()
        
    # 기사 본문 추출
    soup = BeautifulSoup(r.text, 'html.parser')
    
    # 본문 기사 태그 선택
    # soup.select(태그 선택자) : 리스트에 태그 내용을 저장한 후 리턴
    main_content = soup.select('#main_content')
    
    title = main_content[0].select('#articleTitle')
    
    if len(title) != 0:
        #print(title)
        #print('-' * 40)
    
        title_str = title[0].text.strip()
        print(title_str)
        print('-' * 40)
        
         # 기사 제목에서 파일이름으로 사용할 수 없는 특수문자 제거
        title_str = title_str.replace('"', '')   # 큰따옴표
        title_str = title_str.replace('\\', '')   # 역슬래시
        title_str = title_str.replace('?', '')   # 물음표
        title_str = title_str.replace('/', '')   # 슬래시
        title_str = title_str.replace('>', '')   # 꺽기 괄호
        title_str = title_str.replace('<', '')   # 꺽기 괄호
        title_str = title_str.replace('*', '')   # 별문자
        title_str = title_str.replace('|', '')   # 세로줄
        title_str = title_str.replace(':', '')   # 콜롱
        
        article = main_content[0].select('#articleBodyContents')
        
        for target in article[0].select('script'): target.extract()
        for target in article[0].select('a'): target.extract()
        for target in article[0].select('span'): target.extract()
        for target in article[0].select('div'): target.extract()
        for target in article[0].select('br'): target.replace_with('\n')
        for target in article[0].select('.reporter_area'): target.extract()
        for target in article[0].select('.copyright'): target.extract()
        for target in article[0].select('.categorize'): target.extract()
        for target in article[0].select('.promotion'): target.extract()
        #print(article)
        #print('-' * 40)
        
        article_str = article[0].text.strip()
        #print(article_str)
        print('-' * 40)
        
        content_merge += article_str
        
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

most = count.most_common(100) # 가장 빈도수가 높은 100개 단어 추출

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