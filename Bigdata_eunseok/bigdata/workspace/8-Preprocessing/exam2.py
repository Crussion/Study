# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 11:41:04 2021

@author: eunse
"""

from pandas import DataFrame

grade_dict = [{'국어':98, '영어':88, '수학':92, '과학':63},
              {'국어':None, '영어':90, '수학':70, '과학':60},
              {'국어':88, '영어':62, '수학':None, '과학':31},
              {'국어':64, '영어':72, '수학':None, '과학':70},
              {'국어':120, '영어':50,'수학':None, '과학':88}]

df = DataFrame(grade_dict, index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-' * 20)

result = df.filter(['국어'])
print(result)
print('-' * 20)

result = df.filter(['국어', '수학'])
print(result)
print('-' * 20)

r1 = df[['국어','수학']]
print(r1)
print('-' * 20)

result = df.columns[df.loc['철수'] > 80]
result = df.loc['영희'][df.loc['영희'] < 70]
print(result)
print('-' * 20)

df_T = df.T
result = df_T.filter(['영희']).query('영희 < 70')
print(result)
print(type(result))
print('-' * 20)