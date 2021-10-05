import requests
import sys
from bs4 import BeautifulSoup

#user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36 Edg/94.0.992.38"
#headers = {'User-Agent':user_agent, 'Referer':None}

url = 'https://news.v.daum.net/v/20211005094302241'

r = requests.get(url) #headers=headers

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

soup = BeautifulSoup(r.text, 'html.parser')

selector = soup.select('#harmonyContainer')
print(selector)
print('-' * 20)

for target in selector[0].select('figure'):
    target.extract()

print(selector)
print('-' * 20)

for target in selector[0].select('.article_view > p'):
    target.extract()
    
print(selector)
print('-' * 20)

news = selector[0].text.strip()
print(news)
print('-' * 20)

with open('다음뉴스.txt', 'w') as f:
    f.write(news)
    print('저장 완료')