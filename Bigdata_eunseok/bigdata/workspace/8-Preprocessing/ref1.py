# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 14:44:13 2021

@author: eunse
"""

import numpy as np
from pandas import DataFrame

x = np.arange(5) + 1
print(x)
print('-' * 20)

print(x[2])
print('-' * 20)

print(x[[2,4]])
print('-' * 20)

print(x[[False, False, False, True, True]])
print('-' * 20)

print(x[x>=4])
print('-' * 20)

print(x>=4)
print('-' * 20)

conditionList = [x<3, x>4]
print(conditionList)
print('-' * 20)

choiceList = [x, x**2]
print(choiceList)
print('-' * 20)

print(np.select(conditionList,choiceList))

grade_dict = [{'국어':98, '영어':88, '수학':92, '과학':63},
              {'국어':None, '영어':90, '수학':70, '과학':60},
              {'국어':88, '영어':62, '수학':None, '과학':31},
              {'국어':64, '영어':72, '수학':None, '과학':70},
              {'국어':120, '영어':50,'수학':None, '과학':88}]

df = DataFrame(grade_dict, index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-' * 20)

conditionList = [df['영어']>=90,
                 df['영어']>=80,
                 df['영어']>=70,
                 df['영어']>=60,
                 df['영어']<60,
                 np.isnan(df['영어'])]

print(conditionList)
print('-' * 20)

grade = ['A','B','C','D','F','F']
result = np.select(conditionList, grade)
print(result)
print('-' * 20)