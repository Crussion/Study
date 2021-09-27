# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 14:35:17 2021

@author: eunse
"""

from pandas import DataFrame
from pandas import read_csv

df = DataFrame(read_csv("data/grade.csv", encoding='euc-kr'))
df1 = df.drop(df.query('영어 == 90').index)
print(df)
print(df1)