# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 16:40:12 2021

@author: eunse
"""

from pandas import DataFrame

grade_list = [[98, None, 88, 64],
              [88, 90, 62, 72],
              [92, 70, None, None],
              [63, 60, 31, 70],
              [120, 50, None, 88]]

df = DataFrame(grade_list)
print(df)
print('-'*20)

df = DataFrame(grade_list, columns=['국어', '영어', '수학', '과학'])
print(df)
print('-'*20)

df = DataFrame(grade_list, columns=['국어', '영어', '수학', '과학'],
               index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-'*20)