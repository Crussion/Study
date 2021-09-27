# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 10:31:48 2021

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

# 1) column 1개
print(df['국어'])
print('-' * 20)

print(type(df['국어']))
print('-' * 20)

# 1-1) column 1개 인덱스명을 리스트로
print(df[['국어']])
print('-' * 20)

print(type(df[['국어']]))
print('-' * 20)


# 2) column 여러개
print(df[['국어', '영어']])
print('-' * 20)

print(type(df[['국어', '영어']]))
print('-' * 20)

print(df[df.columns[1:3]])
print('-' * 20)