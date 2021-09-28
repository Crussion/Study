# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 10:40:19 2021

@author: eunse
"""

from pandas import DataFrame, merge

score_kor = DataFrame({'이름':['영희', '철수'],
                       '국어':[87, 91 ]})

score_eng = DataFrame({'성명':['영희', '철수'],
                       '영어':[90, 82 ]})

print(score_kor)
print(score_eng)
print('-' * 20)

df = merge(score_kor, score_eng, left_on='이름', right_on='성명')
print(df)
print('-' * 20)

df = df.drop('성명', axis=1)
print(df)
print('-' * 20)

df = df.set_index('이름')
print(df)
print('-' * 20)