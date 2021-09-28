# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 13:03:50 2021

@author: eunse
"""

from pandas import read_csv
import matplotlib.pyplot as plt

df = read_csv('data/grade.csv', encoding='euc-kr')
df = df.set_index('이름')
print(df)
print('-' * 20)

result = df.describe()
print(result)
print('-' * 20)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 16
plt.rcParams['figure.figsize'] = (8, 6)

df.boxplot()
plt.show()

result = df['국어'].describe()
print(result)
print('-' * 20)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 16
plt.rcParams['figure.figsize'] = (8, 6)

df.boxplot(['국어'])
plt.show()