# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 14:43:53 2021

@author: eunse
"""

from pandas import read_csv
import matplotlib.pyplot as plt

df = read_csv('data/grade.csv', encoding='euc-kr')
df = df.set_index('이름')
print(df)
print('-' * 20)

df['평균'] = df.mean(axis=1)
print(df)
print('-' * 20)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 16
plt.rcParams['figure.figsize'] = (8, 6)

n, bins, patches = plt.hist(df['평균'], bins=5)
plt.show()

print(n)
print(bins)
print(patches)
print('-' * 20)