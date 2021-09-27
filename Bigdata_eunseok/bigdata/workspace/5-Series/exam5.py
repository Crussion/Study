# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 16:00:06 2021

@author: eunse
"""

import pandas as pd

s1 = pd.date_range(start='2021-01-01', end='2021-01-04')
print(s1)
print('-'*20)

print(s1.strftime('%y%m%d'))
print(s1.strftime('%y%m%d_%h%M%s'))
print(s1.strftime('%y-%m-%d_%h:%M:%s'))
print('-'*20)

s1 = pd.date_range(start='2021/01/01', end='2021/01/04')
print(s1)
print('-'*20)

s1 = pd.date_range(start='2021-01-01', periods=4) # periods = 총 갯수
print(s1)
print('-'*20)

s1 = pd.date_range(start='2021-01-01', periods=4, freq='2d')
print(s1)
print('-'*20)

s1 = pd.date_range(start='2021-01-01', periods=4, freq='w')
print(s1)
print('-'*20)

s1 = pd.date_range(start='2021-01-01', periods=4, freq='w-mon')
print(s1)
print('-'*20)