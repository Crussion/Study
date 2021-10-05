import requests
import sys
from bs4 import BeautifulSoup

user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38'
headers = {'User-Agent':user_agent, 'Referer':None}

index_url = 'https://sports.news.naver.com/ranking/index'

r = requests.get(index_url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

soup = BeautifulSoup(r.text, 'html.parser')

selector = soup.select('.newscenter a.title')
print(selector)
print('-' * 40)

url_list = []
for item in selector[:10]:
    if 'href' in item.attrs:
        url_list.append(item.attrs['href'])

print(url_list)
print('-' * 40)

###################################
import os
import datetime as dt

date_str = dt.datetime.now().strftime('%y%m%d_%H%M%S')
dir_name = '스포츠뉴스기사_' + date_str

if not os.path.exists(dir_name):
    os.mkdir(dir_name)

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
    print(title)
    print(content_str)
    print('-' * 40)
    
    # 기사 제목에서 파일이름으로 사용할 수 없는 특수문자 제거
    title = title.replace('"', '')   # 큰따옴표
    title = title.replace('\\', '')   # 역슬래시
    title = title.replace('?', '')   # 물음표
    title = title.replace('/', '')   # 슬래시
    title = title.replace('>', '')   # 꺽기 괄호
    title = title.replace('<', '')   # 꺽기 괄호
    title = title.replace('*', '')   # 별문자
    title = title.replace('|', '')   # 세로줄
    title = title.replace(':', '')   # 콜롱
    
    title_str = dir_name + '/' + str(i+1) + '_' + title + '.txt'
    
    if title and content_str:
        with open(title_str, 'w', encoding='utf-8') as f:
            f.write(content_str)
            print(str(i+1), '번째 기사 저장 완료')
            print('-' * 40)
    else:
        print(str(i+1), '번째 기사 저장 실패')
        print('-' * 40)