# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 09:38:49 2021

@author: eunse
"""

from pandas import DataFrame
from pandas import concat

df_top = DataFrame({'국어':[88, 91], '영어':[90, 95]}, index=['철수', '영희'])
print(df_top)
print('-' * 20)

df_middle = DataFrame({'국어':[85, 11], '영어':[80, 55]}, index=['영민', '정수'])
print(df_middle)
print('-' * 20)

df_bottom = DataFrame({'영어':[98, 90], '과학':[70, 75]}, index=['민철', '태영'])
print(df_bottom)
print('-' * 20)

df1 = df_top.append([df_middle, df_bottom])
print(df1)
print('-' * 20)

df2 = concat([df_top, df_middle, df_bottom])
print(df2)
print('-' * 20)