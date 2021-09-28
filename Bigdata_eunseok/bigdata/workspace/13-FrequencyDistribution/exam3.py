# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 14:52:27 2021

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
plt.rcParams['figure.figsize'] = (12, 8)

n, bins, patches = plt.hist(df['평균'], bins=5, color='blue')
print(n)
print(bins)
print(patches)

plt.grid()
plt.xlabel('점수 구간')
plt.ylabel('평균점수 구간별 학생 수')
plt.title('평균점수 히스토그램')
plt.xticks(bins)
for i in range(len(n)):
    plt.text(x=bins[i], y=n[i]+50, s=str(int(n[i])) + '명', color='red')
plt.show()