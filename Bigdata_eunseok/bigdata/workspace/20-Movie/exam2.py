import requests
import sys
import json
import datetime as dt
import matplotlib.pyplot as plt
from pandas import DataFrame

user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36 Edg/94.0.992.31'
headers = {'User-Agent':user_agent, 'Referer':None}

url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json'
param = '?key={key}&targetDt={date}'
api_key = '909f25dde2b2eab558d0adcd8df14d77'

date = dt.date(2021, 2, 9)
date_str = date.strftime('%Y%m%d')

#today = dt.datetime.now()
#delta = dt.timedelta(days = -1)
#yesterday = today + delta
#date_str = yesterday.strftime('%Y%m%d')

api_url = url + param.format(key=api_key, date=date_str)

r = requests.get(api_url, headers=headers)

if r.status_code != 200:
    print('[Error]', r.status_code)
    sys.exit()

boxoffice_dict = r.json()

#boxoffice_dict = json.loads(r.text)

daily_boxoffice_df = DataFrame(boxoffice_dict['boxOfficeResult']['dailyBoxOfficeList'])
print(daily_boxoffice_df)
print('-' * 20)

tmp_df = daily_boxoffice_df.filter(['movieNm', 'audiCnt'])
print(tmp_df)
print('-' * 20)

daily_rank_df = tmp_df.rename(index=tmp_df['movieNm'], columns={'audiCnt':'관람객'}).drop('movieNm', axis=1)
#daily_rank_df = tmp_df.set_index('movieNm').rename(columns={'audiCnt':'관람객'})
print(daily_rank_df)
print('-' * 20)

print(daily_rank_df.dtypes)
print('-' * 20)

daily_rank_df = daily_rank_df.astype(int)

print(daily_rank_df.dtypes)
print('-' * 20)

daily_rank_df_sort = daily_rank_df.sort_values('관람객')
print(daily_rank_df_sort)
print('-' * 20)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 12
plt.rcParams['figure.figsize'] = (14, 8)
plt.rcParams['axes.unicode_minus'] = False

daily_rank_df_sort.plot.barh(rot=45)
plt.grid()
plt.title('20210209 박스오피스 순위')
plt.legend(loc='lower right')
#plt.ylabel(None)
#plt.yticks(rotation=45)
plt.show()