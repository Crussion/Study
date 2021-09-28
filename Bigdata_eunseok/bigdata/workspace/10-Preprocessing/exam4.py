# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 10:16:44 2021

@author: eunse
"""

from pandas import DataFrame, merge

df_a = DataFrame({'고객명':['민수', '수영'],
                  '데이터':[20000, 10000 ],
                  '날짜':['2021-01-01', '2021-01-01']})

df_b = DataFrame({'고객명':['민수', '수영'],
                  '데이터':['21세','20세']})

print(df_a)
print(df_b)
print('-' * 20)

# on : 양쪽의 똑같은 이름의 컬럼을 기준열로 설정
# left_on : 왼쪽 데이터 프레임의 기준열 설정
# right_on : 오른쪽 데이터 프레임의 기준열 설

df = merge(df_a, df_b, on='고객명')
print(df)
print('-' * 20)

df1 = merge(df_a, df_b, left_on='고객명', right_on='고객명')
print(df1)
print('-' * 20)

df1 = df1.rename(columns={'데이터_x':'금액', '데이터_y':'나이'})
print(df1)
print('-' * 20)