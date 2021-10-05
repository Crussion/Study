
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
    
#print(r.text)
print('-' * 40)

soup = BeautifulSoup(r.text, 'html.parser')

selector = soup.select('.hdline_flick_item > a, .hdline_article_tit > a, '
                       + '.mtype_list_wide > .mlist2 > li > a, '
                       + '.mtype_img > dt > a')
print(selector)
print('-' * 40)

print(len(selector))
print('-' * 40)

# a 태그의 url 만 추출
# item.attrs
# {'href' : 'url'} 형태의 딕셔너리로 추출, 클래스등의 다른 정보도 추출

url_list = []

for item in selector:
    if 'href' in item.attrs:
        print(item.attrs)
        url_list.append(item['href'])
        print('-' * 40)
        
print(url_list)
print('-' * 40)

for i, v in enumerate(url_list):
    if content_url not in v:
        url_list[i] = content_url + v

print(url_list)
print('-' * 40)

