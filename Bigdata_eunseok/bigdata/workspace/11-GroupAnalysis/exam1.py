# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 11:16:35 2021

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

# 총점
result = df.sum()
print(result)
print('-' * 20)

# 평균
result = df.mean()
print(result)
print('-' * 20)

result_kor = df['국어'].sum()
print(result_kor)
print('-' * 20)

result_kor = df['국어'].mean()
print(result_kor)
print('-' * 20)

result_kor = df['국어'].min()
print(result_kor)
print('-' * 20)

result_kor = df['국어'].max()
print(result_kor)
print('-' * 20)

tot = df.sum(axis=1)
print(result)
print('-' * 20)

avg = df.mean(axis=1)
print(result)
print('-' * 20)

df['총점'] = tot
df['평균'] = avg
print(df)
print('-' * 20)
