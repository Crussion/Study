# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 15:35:24 2021

@author: eunse
"""
import numpy as np
from pandas import DataFrame
from pandas import Series

grade_dict = [{'국어':98, '영어':88, '수학':92, '과학':63},
              {'국어':None, '영어':90, '수학':70, '과학':60},
              {'국어':88, '영어':62, '수학':None, '과학':31},
              {'국어':64, '영어':72, '수학':None, '과학':70},
              {'국어':120, '영어':50,'수학':None, '과학':88}]

df = DataFrame(grade_dict, index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-' * 20)

df['세계사'] = 100
print(df)
print('-' * 20)

df['한국사'] = [92, 83, 72, None, 80]
print(df)
print('-' * 20)

df['사회'] = Series([82, 90, 92, 64], index=['철수','영희','민철','수현'])
print(df)
print('-' * 20)

df['국어결과'] = np.where(df['국어'] > 70, '합격', '불합격')
print(df)
print('-' * 20)

conditionList = [df['영어']>=90,
                 df['영어']>=80,
                 df['영어']>=70,
                 df['영어']>=60,
                 df['영어']<60,
                 np.isnan(df['영어'])]
grade = ['A','B','C','D','F','F']

df['영어학점'] = np.select(conditionList, grade)
print(df)
print('-' * 20)