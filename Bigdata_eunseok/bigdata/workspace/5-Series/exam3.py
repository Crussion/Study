# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 15:41:30 2021

@author: eunse
"""

from pandas import Series
import numpy as np

items = [10,30,50,70,90]

column = Series(items)

col1 = column[column > 30]
print(col1)
print('-'*20)

col1 = column[(column > 10) & (column < 70)]
print(col1)
print('-'*20)

col1 = column[(column < 20) | (column > 70)]
print(col1)
print('-'*20)
