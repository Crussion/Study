# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 13:05:56 2021

@author: eunse
"""

from pandas import DataFrame
from pandas import read_csv

df = DataFrame(read_csv("data/grade.csv", encoding='euc-kr'))
print(df.query('국어 >= 90'))