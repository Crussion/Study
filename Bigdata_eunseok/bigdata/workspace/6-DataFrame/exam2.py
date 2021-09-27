# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 16:57:36 2021

@author: eunse
"""

from pandas import DataFrame

grade_dict = {'국어':[98, 88, 92, 63, 120],
              '영어':[None, 90, 70, 60, 50],
              '수학':[88, 62, None, 31, None],
              '과학':[64, 72, None, 70, 88]}

df = DataFrame(grade_dict)
print(df)

df = DataFrame(grade_dict,
               index=['철수', '영희', '민철', '수현', '호영'])
print(df)