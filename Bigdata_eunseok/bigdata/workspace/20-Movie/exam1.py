import requests
import sys
import json
import datetime as dt
from pandas import DataFrame

user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36 Edg/94.0.992.31'
headers = {'User-Agent':user_agent, 'Referer':None}

url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json'
param = '?key={key}&targetDt={date}'
api_key = '909f25dde2b2eab558d0adcd8df14d77'

today = dt.datetime.now()
delta = dt.timedelta(days = -1)
yesterday = today + delta
print(yesterday)
print('-' * 20)

yesterday_str = yesterday.strftime('%Y%m%d')
print(yesterday_str)
print('-' * 20)

api_url = url + param.format(key=api_key, date=yesterday_str)
print(api_url)
print('-' * 20)

r = requests.get(api_url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

print(r.text)
print('-' * 20)

boxoffice_dict = json.loads(r.text)
print(boxoffice_dict)
print('-' * 20)

df = DataFrame(boxoffice_dict['boxOfficeResult']['dailyBoxOfficeList'])
print(df)
print('-' * 20)