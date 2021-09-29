# -*- coding: utf-8 -*-
"""
Created on Wed Sep 29 09:57:59 2021

@author: eunse
"""

from pandas import read_excel
import pandas as pd

df = read_excel('data/시도별_교통사고.xlsx')
print(df)
print('-' * 20)

col_list = list(df.columns)
print(col_list)
print('-' * 20)

df = df.filter(['시도별(1)', '2019. 01', '2019. 02', '2019. 03', '2019. 04', '2019. 05', '2019. 06',
                '2019. 07', '2019. 08', '2019. 09', '2019. 10', '2019. 11', '2019. 12'])
print(df)
print('-' * 20)

print(pd.get_option('display.max_rows'))
print(pd.get_option('display.max_columns'))
print('-' * 20)

row, col = df.shape

pd.set_option('display.max_columns', col)
print(df)
print('-' * 20)

df = df.drop(0)
print(df)
print('-' * 20)

df = df.set_index('시도별(1)')
print(df)
print('-' * 20)

col_list = list(df.columns)
print(col_list)
print('-' * 20)

month_dict = {'2019. 01':'1월', '2019. 02':'2월', '2019. 03':'3월', 
              '2019. 04':'4월', '2019. 05':'5월', '2019. 06':'6월', 
              '2019. 07':'7월', '2019. 08':'8월', '2019. 09':'9월', 
              '2019. 10':'10월', '2019. 11':'11월', '2019. 12':'12월'}

df = df.rename(columns=month_dict)
print(df)
print('-' * 20)

df = df.T
print(df)
print('-' * 20)

df = df.filter(['서울', '부산', '대구', '인천'])
print(df)
print('-' * 20)