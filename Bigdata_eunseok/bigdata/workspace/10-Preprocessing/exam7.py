# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 11:00:00 2021

@author: eunse
"""

from pandas import DataFrame, merge

score_khistory = DataFrame({'한국사':[87, 91]}, index=['영희', '철수'])
score_whistory = DataFrame({'세계사':[90, 82], '이름':['영희', '철수']})

print(score_khistory)
print(score_whistory)
print('-' * 20)

df = merge(score_khistory, score_whistory, left_index=True, right_on='이름')
print(df)
print('-' * 20)

df = df.set_index('이름')
print(df)
print('-' * 20)