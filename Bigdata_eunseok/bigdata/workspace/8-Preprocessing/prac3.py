# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 15:53:56 2021

@author: eunse
"""

import numpy as np
from pandas import DataFrame
from pandas import read_csv

df = DataFrame(read_csv("data/grade.csv", encoding='euc-kr'))

df['국어'] = np.where(np.isnan(df['국어']), 0, df['국어'])
df['영어'] = np.where(np.isnan(df['영어']), 0, df['영어'])
df['수학'] = np.where(np.isnan(df['수학']), 0, df['수학'])
df['과학'] = np.where(np.isnan(df['과학']), 0, df['과학'])

print(df)
print('-'*20)

df['평균'] = (df['국어'] + df['영어'] + df['수학'] + df['과학']) / 4
conditionList = [df['평균']>=90,
                 df['평균']>=80,
                 df['평균']>=70,
                 df['평균']>=60,
                 df['평균']<60,
                 np.isnan(df['평균'])]
grade = ['A','B','C','D','F','F']

df['학점'] = np.select(conditionList, grade)
print(df)
print('-'*20)