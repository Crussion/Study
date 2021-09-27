# -*- coding: utf-8 -*-
"""
Created on Fri Sep 24 17:43:27 2021

@author: eunse
"""

from pandas import ExcelFile
from pandas import read_excel

xls = ExcelFile('data/children_house.xlsx')
df = xls.parse(xls.sheet_names[0])
print(df)
print('-'*20)

df1 = read_excel('data/children_house.xlsx')
print(df1)