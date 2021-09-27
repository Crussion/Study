# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 11:15:09 2021

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

result = df.query('국어 > 80')
print(result)
print(type(result))
print('-' * 20)

r1 = df[df['국어'] > 80]
print(r1)
print(type(r1))
print('-' * 20)

result = df.query('국어 > 80 and 수학 > 80')
print(result)
print(type(result))
print('-' * 20)

result = df.query('국어 > 80 or 수학 > 80')
print(result)
print(type(result))
print('-' * 20)