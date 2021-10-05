import requests
import sys
from bs4 import BeautifulSoup

user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38"
headers = {'User-Agent':user_agent, 'Referer':None}

content_url = 'https://news.naver.com'

r = requests.get(content_url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

soup = BeautifulSoup(r.text, 'html.parser')

selector = soup.select('.hdline_flick_item > a, .hdline_article_tit > a, '
                       + '.mtype_list_wide > .mlist2 > li > a, '
                       + '.mtype_img > dt > a')

# a 태그의 url 만 추출
# item.attrs
# {'href' : 'url'} 형태의 딕셔너리로 추출, 클래스등의 다른 정보도 추출

url_list = []

for item in selector:
    if 'href' in item.attrs:
        url_list.append(item['href'])

for i, v in enumerate(url_list):
    if content_url not in v:
        url_list[i] = content_url + v

print(url_list)
print('-' * 40)

###################################
import os
import datetime as dt

date_str = dt.datetime.now().strftime('%y%m%d_%H%M%S')
dir_name = '뉴스기사_' + date_str

if not os.path.exists(dir_name):
    os.mkdir(dir_name)

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
        #print(title_str)
        #print('-' * 40)
        
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
        
        #print(article)
        #print('-' * 40)
        
        article_str = article[0].text
        #print(article_str)
        #print('-' * 40)
        
    if title_str and article_str:
        fname = dir_name + '/' + str(i+1) + '_' + title_str + '.txt'
        with open(fname, 'w', encoding='utf-8') as f:
            f.write(article_str)
            print(str(i+1), '번째 기사 저장 성공')
            print('=' * 40)