# -*- coding: utf-8 -*-
"""
Created on Mon Sep 27 17:04:30 2021

@author: eunse
"""

from pandas import DataFrame

grade_dict = [{'국어':98, '영어':88, '수학':92, '과학':63},
              {'국어':None, '영어':90, '수학':70, '과학':60},
              {'국어':88, '영어':62, '수학':None, '과학':31},
              {'국어':64, '영어':72, '수학':None, '과학':70},
              {'국어':120, '영어':50,'수학':None, '과학':88}]

df = DataFrame(grade_dict, index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-' * 20)

# 1) 컬럼명 변경
# => 딕셔너리 사용 {'기존이름': '새이름'}

df1 = df.rename(columns={'국어':'kor','영어':'eng','수학':'mat','과학':'sci'})
print(df1)
print('-' * 20)

# 2) 인덱스명 변경
# => 딕셔너리 사용 {'기존이름': '새이름'}

df1 = df.rename(index={'철수':'cs','영희':'yh','민철':'mc','수현':'sh','호영':'hy'})
print(df1)
print('-' * 20)

# 3) 컬럼, 인덱스명 변경

df1 = df.rename(index={'철수':'cs','영희':'yh','민철':'mc','수현':'sh','호영':'hy'},
                columns={'국어':'kor','영어':'eng','수학':'mat','과학':'sci'})
print(df1)
print('-' * 20)
