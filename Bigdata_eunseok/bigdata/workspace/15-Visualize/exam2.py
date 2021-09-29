from pandas import read_excel
import pandas as pd
import matplotlib.pyplot as plt

df = read_excel('data/시도별_교통사고.xlsx')

col_list = list(df.columns)
df = df.filter(['시도별(1)', '2019. 01', '2019. 02', '2019. 03', '2019. 04', '2019. 05', '2019. 06',
                '2019. 07', '2019. 08', '2019. 09', '2019. 10', '2019. 11', '2019. 12'])

row, col = df.shape

pd.set_option('display.max_columns', col)

df = df.drop(0)

df = df.set_index('시도별(1)')

col_list = list(df.columns)

month_dict = {'2019. 01':'1월', '2019. 02':'2월', '2019. 03':'3월', 
              '2019. 04':'4월', '2019. 05':'5월', '2019. 06':'6월', 
              '2019. 07':'7월', '2019. 08':'8월', '2019. 09':'9월', 
              '2019. 10':'10월', '2019. 11':'11월', '2019. 12':'12월'}

df = df.rename(columns=month_dict)

df = df.T

df = df.filter(['서울', '부산', '대구', '인천'])
print(df)
print('-' * 20)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 12
plt.rcParams['figure.figsize'] = (8, 6)

import numpy as np
xpos = np.arange(len(df['서울']))
xtext = list(df.index)

df['서울'].plot(color='red')
plt.grid()
plt.legend() # 컬럼명으로 설정
plt.title('2019년 서울의 월별 교통사고')
plt.xlabel('월')
plt.ylabel('교통사고수')
plt.xticks(xpos, xtext)
plt.show()

df.plot()
plt.grid()
plt.legend() # 컬럼명으로 설정
plt.title('2019년 서울의 월별 교통사고')
plt.xlabel('월')
plt.ylabel('교통사고수')
plt.xticks(xpos, xtext)
plt.show()