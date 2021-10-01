import requests
import sys
import json
from pandas import DataFrame

#url = 'https://naver.com/'
url = 'https://news.naver.com'

user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36 Edg/94.0.992.31'
headers = {'User-Agent':user_agent, 'Referer':None}

r = requests.get(url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

print(r.text)
print('-' * 20)

with open('naver_news.html', 'w') as f:
    f.write(r.text)
    print('저장 성공')