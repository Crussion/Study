# -*- coding: utf-8 -*-
"""
Created on Thu Sep 30 09:48:00 2021

@author: eunse
"""

import numpy as np
import pandas as pd
from pandas import DataFrame
from pandas import read_excel
import matplotlib.pyplot as plt

##df = read_excel('data/dataset2017.xlsx')
print(df)
print('-' * 20)

df_g = df.filter(['h12_g3'])
print(df_g)
print('-' * 20)

df_g = df_g.rename(columns={'h12_g3':'성별'})
print(df_g)
print('-' * 20)

print(df_g.isna().sum())
print('-' * 20)

df_g['성별'] = np.where(df_g['성별'] == 1, '남자', '여자')
print(df_g)
print('-' * 20)

cnt = df_g['성별'].value_counts()
print(cnt)
print('-' * 20)

df_c = DataFrame(cnt)
print(df_c)
print('-' * 20)

df_c = df_c.rename(columns={'성별':'총인원'})
print(df_c)
print('-' * 20)

df_c = df_c.sort_index()
print(df_c)
print('-' * 20)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 16
plt.rcParams['figure.figsize'] = (10, 8)
plt.rcParams['axes.unicode_minus'] = False

df_c.plot.bar(rot=0)
plt.title('조사대상들에 대한 성별 분포')
plt.grid()
plt.xlabel('성별')
plt.ylabel('명')

for i, v in enumerate(df_c['총인원']):
    txt = '%d명' %v
    plt.text(i, v + 100, txt, color='blue',
             horizontalalignment='center')
plt.show()