# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 18:03:12 2021

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

df1 = df.sort_values('국어')
print(df1)
print('-' * 20)

df1 = df.sort_values('국어', ascending=False)
print(df1)
print('-' * 20)

# 첫번째 값이 같을때 두번째를 기준으로 오름차순
df1 = df.sort_values(['국어', '영어'])
print(df1)
print('-' * 20)

# 첫번째 값이 같을때 두번째를 기준으로 내림차순
df1 = df.sort_values(['국어', '영어'], ascending=[True, False])
print(df1)
print('-' * 20)

df1 = df.sort_index()
print(df1)
print('-' * 20)

df1 = df.sort_index(ascending=False)
print(df1)
print('-' * 20)

df_T = df.T
df_T = df_T.sort_index()
df_T = df_T.T
print(df_T)
print('-' * 20)

df_T = df.T
df_T = df_T.sort_index(ascending=False)
df_T = df_T.T
print(df_T)
print('-' * 20)