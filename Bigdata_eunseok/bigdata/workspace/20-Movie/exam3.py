import requests
import sys
import datetime as dt
import matplotlib.pyplot as plt
from pandas import DataFrame
import pandas as pd

user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36 Edg/94.0.992.31'
headers = {'User-Agent':user_agent, 'Referer':None}

url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json'
param = '?key={key}&targetDt={date}'
api_key = '909f25dde2b2eab558d0adcd8df14d77'

df = DataFrame()

print('진행중', end='')
for i in range(-7, 0):
    today = dt.datetime.now()
    delta = dt.timedelta(days = i)
    yesterday = today + delta
    date_str = yesterday.strftime('%Y%m%d')

    api_url = url + param.format(key=api_key, date=date_str)

    r = requests.get(api_url, headers=headers)

    if r.status_code != 200:
        print('[Error]', r.status_code)
        sys.exit()
        
    daily_boxoffice_df = DataFrame(r.json()['boxOfficeResult']['dailyBoxOfficeList'])
    #print(daily_boxoffice_df)
    
    tmp_df = daily_boxoffice_df.filter(['movieNm', 'audiCnt']).\
        rename(index=daily_boxoffice_df['movieNm'], columns={'audiCnt':date_str}).\
        drop('movieNm', axis=1)
    #print(tmp_df)
    
    df = pd.concat([df, tmp_df], axis=1)
    
    df = df.fillna(0)
    print('=', end='')
    
print()
df = df.astype(int)
print(df.dtypes)
print('-' * 20)

print(df.sort_values('20211003'))
print('-' * 20)

df = df.sort_values('20211003').tail(5)
print(df)
print('-' * 20)
    
df.plot.bar()
plt.grid()
plt.show()

df.T.plot()
plt.grid()
plt.show()