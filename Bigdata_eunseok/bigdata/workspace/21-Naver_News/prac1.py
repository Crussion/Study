import requests
import sys
from bs4 import BeautifulSoup

user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38"
headers = {'User-Agent':user_agent, 'Referer':None}

url = 'https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=105&oid=011&aid=0003969034'

r = requests.get(url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()
    
soup = BeautifulSoup(r.text, 'html.parser')

selector = soup.select('#articleBodyContents')
print(selector)
print('-' * 20)

for target in selector[0].find_all('script'):
    target.extract()
    
print(selector)
print('-' * 20)

for target in selector[0].find_all('br'):
    target.replace_with('\n')
    
print(selector)
print('-' * 20)

news_content = selector[0].text.strip()
print(news_content)
print('-' * 20)

with open('뉴스.txt', 'w') as f:
    f.write(news_content)
    print('파일 저장')