import numpy as np
import pandas as pd
from pandas import DataFrame
from pandas import read_excel
import matplotlib.pyplot as plt
import datetime as dt

print(df)
print('-' * 20)

df1 = df.filter(['h12_g3', 'h12_g4']).rename(columns={'h12_g3':'성별',
                                                      'h12_g4':'출생년도'})
print(df1)
print('-' * 20)

year = dt.datetime.now().year

df1['나이'] = year - df1['출생년도'] + 1
print(df1)
print('-' * 20)

df1['연령대'] = (df1['나이'] // 10) * 10
print(df1)
print('-' * 20)

df1 = df1.filter(['성별', '연령대'])
print(df1)
print('-' * 20)

df1_m = df1.query('성별 == 1')['연령대'].value_counts().sort_index()
df1_w = df1.query('성별 == 2')['연령대'].value_counts().sort_index()
print(df1_m)
print(df1_w)
print('-' * 20)

df1 = DataFrame([df1_m, df1_w], index=['남자', '여자']).T
print(df1)
print('-' * 20)

for i in df1.index:
    df1 = df1.rename(index={i:'%d대' %i})
print(df1)
print('-' * 20)

df1 = df1.fillna(0)
print(df1)
print('-' * 20)

df1.plot.bar(rot=0)
plt.title('성별과 연령대별 분포')
plt.xlabel('연령대')
plt.ylabel('명')
plt.grid()
plt.show()