# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 12:42:35 2021

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

df.loc['정호'] = [90, 80, 70, 60]
print(df)
print('-' * 20)

df.loc['길동'] = 100
print(df)
print('-' * 20)

df.loc['민정'] = {'국어':95, '영어':None, '수학':85, '과학':None}
print(df)
print('-' * 20)

df.loc['철민'] = df.loc['철수']
print(df)
print('-' * 20)

tmp = DataFrame({'국어':81, '영어':84, '과학':90}, index=['상호'])
print(tmp)
print('-' * 20)

df = df.append(tmp)
print(df)
print('-' * 20)