# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 15:38:31 2021

@author: eunse
"""

from pandas import read_csv
from pandas import DataFrame
import matplotlib.pyplot as plt

df = read_csv('data/grade.csv', encoding='euc-kr')
df = df.set_index('이름')
print(df)
print('-' * 20)

df['평균'] = df.mean(axis=1)
print(df)
print('-' * 20)

n, bins, patches = plt.hist(df['평균'], bins=5, color='blue')

print(n)
print(bins)

lst = []
for i in range(1, len(bins)):
    lst.append('%.1f~%.1f' %(bins[i-1], bins[i]))

df1 = DataFrame({'빈도':n}, index=lst)
print(df1)
print('-' * 20)