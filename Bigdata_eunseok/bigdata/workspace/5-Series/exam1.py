# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 15:15:31 2021

@author: eunse
"""

from pandas import Series
import numpy as np

items = [10,30,50,70,90]
column = Series(items)
print(column)
print(type(column))
print('-'*20)

arr1 = np.arange(10, 100, 20)
col = Series(arr1)
print(col)
print(type(col))
print('-'*20)

idx = column.index
print(idx)
print('-'*20)

idx = list(column.index)
print(idx)
print('-'*20)

val = column.values
print(val)
print(type(val))
print('-'*20)

