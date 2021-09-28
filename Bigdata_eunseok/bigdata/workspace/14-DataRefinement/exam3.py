
from pandas import DataFrame
import numpy as np
from sklearn.impute import SimpleImputer

grade_dict = [{'국어':98, '영어':None, '수학':92, '과학':63},
              {'국어':88, '영어':90, '수학':70, '과학':60},
              {'국어':92, '영어':62, '수학':None, '과학':None},
              {'국어':63, '영어':72, '수학':31, '과학':70},
              {'국어':120, '영어':50,'수학':None, '과학':88}]

df = DataFrame(grade_dict, index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-' * 20)

# 대표 값으로 대체
result = df.fillna(0)
print(result)
print('-' * 20)

# missing_values : 결측치 설정
# strategy : 대체값 설정, mean : 평균값
simple_imp = SimpleImputer(missing_values=np.nan, strategy='mean')

result_imp = simple_imp.fit_transform(df.values)
print(result_imp)
print('-' * 20)

df_result = DataFrame(result_imp, index=df.index, columns=df.columns)
print(df_result)
print('-' * 20)

# median : 최소값
simple_imp = SimpleImputer(missing_values=np.nan, strategy='median')

result_imp = simple_imp.fit_transform(df.values)
print(result_imp)
print('-' * 20)

for i, arr in enumerate(result_imp):
    for j, v in enumerate(arr):
        result_imp[i][j] = round(v, 1)

df_result = DataFrame(result_imp, index=df.index, columns=df.columns)
print(df_result)
print('-' * 20)
print('#' * 20)

from pandas import read_csv

df = read_csv('data/grade.csv', encoding='euc-kr')
df = df.set_index('이름')
print(df)
print('-' * 20)

simple_imp = SimpleImputer(missing_values=np.nan, strategy='mean')

result_imp = simple_imp.fit_transform(df.values)
print(result_imp)
print('-' * 20)

result_imp = np.round(result_imp, 1)

df_result = DataFrame(result_imp, index=df.index, columns=df.columns)
print(df_result)
print('-' * 20)