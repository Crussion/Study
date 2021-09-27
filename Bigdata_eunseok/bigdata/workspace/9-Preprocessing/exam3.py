# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 17:17:09 2021

@author: eunse
"""

from pandas import read_excel

df = read_excel('data/children_house.xlsx')
print(df)
print('-' * 20)

dic = {}
for i in range(len(df)):
    dic[i] = df.loc[i]['지역']
    
# for i, v in enumerate(list(df['지역'])):
#   dic[i] = v
#
   
print(dic)
print('-' * 20)

#df.set_index('지역')
#df = df.rename(index=df['지역'])
df1 = df.rename(index=dic)
print(df1)
print('-' * 20)

df2 = df1.drop('지역', axis=1)
print(df2)
print('-' * 20)
