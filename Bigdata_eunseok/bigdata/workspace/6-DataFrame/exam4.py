# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 17:15:20 2021

@author: eunse
"""

from pandas import read_csv

df = read_csv("data/grade.csv", encoding='euc-kr')
print(df)
print('-'*20)