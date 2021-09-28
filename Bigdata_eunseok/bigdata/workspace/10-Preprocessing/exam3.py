# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 10:07:01 2021

@author: eunse
"""

from pandas import DataFrame, merge

df_first = DataFrame({'아이디':['hello', 'world', 'python', 'hello'],
                      '결재금액':[14000, 13000, 15000, 13000]})

df_second = DataFrame({'아이디':['hello', 'python', 'python', 'world'],
                      '적립금':[300, 500, 100, 200]})

print(df_first)
print(df_second)
print('-' * 20)

df = merge(df_first, df_second)
print(df)
print('-' * 20)