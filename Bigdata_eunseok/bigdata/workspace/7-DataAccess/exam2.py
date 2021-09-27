# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 18:12:01 2021

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

idx = df.index
print(idx)
print('-' * 20)

idx = list(df.index)
print(idx)
print('-' * 20)

col = df.columns
print(col)
print('-' * 20)

col = list(df.columns)
print(col)
print('-' * 20)

value = df.values
print(value)
print(type(value))
print('-' * 20)

df_T = df.T
print(df_T)
print('-' * 20)