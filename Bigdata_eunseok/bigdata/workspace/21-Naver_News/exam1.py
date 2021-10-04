import requests
import sys
from bs4 import BeautifulSoup

user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38"
headers = {'User-Agent':user_agent, 'Referer':None}

url = 'https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=103&oid=081&aid=0003219994'

r = requests.get(url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()
    
print(r.text)
print('-' * 20)

with open('naver뉴스.html', 'w') as f:
    f.write(r.text)
    print('저장 성공')
    
# 기사 본문 추출
soup = BeautifulSoup(r.text, 'html.parser')

# 본문 기사 태그 선택
# soup.select(태그 선택자) : 리스트에 태그 내용을 저장한 후 리턴
selector = soup.select('#articleBodyContents')
print(selector)
print('-' * 20)