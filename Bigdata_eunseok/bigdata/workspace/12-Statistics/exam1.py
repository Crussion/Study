# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 12:57:40 2021

@author: eunse
"""

from pandas import read_csv

df = read_csv('data/grade.csv', encoding='euc-kr')
print(df)
print('-' * 20)

df = df.set_index('이름')
print(df)
print('-' * 20)

print(df.shape)
print('-' * 20)

print(df.head())
print('-' * 20)

print(df.tail())
print('-' * 20)