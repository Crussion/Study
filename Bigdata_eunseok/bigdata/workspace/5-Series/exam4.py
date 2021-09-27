# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 15:50:23 2021

@author: eunse
"""

from pandas import Series

week1 = Series([290000, 310000])
print(week1)
print('-'*20)

week1 = Series([290000, 310000], index=['토','일'])
print(week1)
print('-'*20)

print(week1[0])
print('-'*20)

print(week1['일'])
print('-'*20)

week2 = Series([190000, 210000], index=['일', '토'])

result = week1 + week2
print(result)
print('-'*20)
