# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 13:18:59 2021

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