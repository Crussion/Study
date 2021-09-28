
from pandas import DataFrame
import numpy as np
from sklearn.impute import SimpleImputer
import matplotlib.pyplot as plt
'''
grade_dict = [{'국어':98, '영어':None, '수학':92, '과학':63},
              {'국어':88, '영어':90, '수학':70, '과학':60},
              {'국어':92, '영어':62, '수학':None, '과학':None},
              {'국어':63, '영어':72, '수학':31, '과학':70},
              {'국어':120, '영어':50,'수학':None, '과학':88}]

df = DataFrame(grade_dict, index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-' * 20)

df.boxplot()
plt.show()

# 이상치 처리
# => 이상치를 결측치로 변경 -> 결측치를 대표값 또는 통계치로 변경

df1 = df.query('국어 > 100')
print(df1)
print('-' * 20)

idx = list(df1.index)
print(idx)
print('-' * 20)

for i in idx:
    df1.loc[i, '국어'] = np.nan
    
print(df1)
print('-' * 20)

df1 = df1.fillna(0)
print(df1)
print('-' * 20)

print(df1.isna().sum())
print('-' * 20)

    
simple_imp = SimpleImputer()
result_imp = simple_imp.fit_transform(df1.values)
print(result_imp)
print('-' * 20)
'''

from pandas import read_csv

df = read_csv('data/grade.csv', encoding='euc-kr')
df = df.set_index('이름')
print(df)
print('-' * 20)

df.boxplot()
plt.show()

df1 = df.query('국어 > 97')
print(df1)
print('-' * 20)

idx = list(df1.index)

for i in idx:
    df.loc[i, '국어'] = np.nan
    
simple_imp = SimpleImputer()
result_imp = simple_imp.fit_transform(df.values)
df = DataFrame(result_imp, index=df.index, columns=df.columns)
df = np.round(df, 1)
print(df)
print('-' * 20)