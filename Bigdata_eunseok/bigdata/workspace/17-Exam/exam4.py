import numpy as np
import pandas as pd
from pandas import DataFrame
from pandas import read_excel
import matplotlib.pyplot as plt
import datetime as dt

print(df)
print('-' * 20)

df_y = df.filter(['h12_g4']).rename(columns={'h12_g4':'출생년도'})
print(df_y)
print('-' * 20)

year = dt.datetime.now().year

df_y['나이'] = year - df_y['출생년도'] + 1
print(df_y)
print('-' * 20)

cnt = df_y['나이'].value_counts()
print(cnt)
print('-' * 20)

######################################################

df_c = DataFrame(cnt).rename(columns={'나이':'연령대'})
print(df_c)
print('-' * 20)

df_c = df_c.sort_index()
print(df_c)
print('-' * 20)

dic = {}
for i in range(10, df_c.index.max() + 10, 10):
    tmp = df_c.query('index < ' + str(i) + 'and index >= ' + str(i - 10)).sum()
    print(i)
    print(tmp)
    print('-' * 20)
    dic['%d대' %(i - 10)] = tmp
    
df_s = DataFrame(dic).T
print(df_s)
print('-' * 20)

df_s.plot.bar(rot=0)
plt.title('연령대 분포')
plt.xlabel('연령대')
plt.ylabel('명')
plt.grid()

for i, v in enumerate(df_s['연령대']):
    txt = '%d명' %v
    plt.text(i, v + 20, txt, color='blue',
             horizontalalignment='center')
    
plt.show()

######################################################

df_y = df.filter(['h12_g4']).rename(columns={'h12_g4':'출생년도'})
print(df_y)
print('-' * 20)

year = dt.datetime.now().year

df_y['나이'] = year - df_y['출생년도'] + 1
print(df_y)
print('-' * 20)

df_y['연령대'] = (df_y['나이'] // 10) * 10
print(df_y)
print('-' * 20)

df_y = df_y['연령대'].value_counts().sort_index()
print(df_y)
print('-' * 20)

for i in df_y.index:
    df_y = df_y.rename({i:'%d대' %i})
print(df_y)
print('-' * 20)

df_y = DataFrame(df_y)
print(df_y)
print('-' * 20)

df_s.plot.bar(rot=0)
plt.title('연령대 분포')
plt.xlabel('연령대')
plt.ylabel('명')
plt.grid()

for i, v in enumerate(df_s['연령대']):
    txt = '%d명' %v
    plt.text(i, v + 20, txt, color='blue',
             horizontalalignment='center')
    
plt.show()