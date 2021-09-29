from pandas import read_excel
from pandas import DataFrame
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

df_sum = df.sum()
print(df_sum)
print(type(df_sum))
print('-' * 20)

df_total = DataFrame(df_sum, columns=['교통사고'])
print(df_total)
print('-' * 20)

df_total.plot.pie(subplots=True)
plt.show()

explode = [0, 0, 0.1, 0]
color = ['orange', 'magenta', 'yellow', 'cyan']
df_total.plot.pie(subplots=True, autopct='%.2f%%',
                  startangle=90, explode=explode, colors=color,
                  shadow=True, fontsize=16)
plt.show()