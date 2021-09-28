from pandas import DataFrame

grade_dict = [{'국어':98, '영어':88, '수학':92, '과학':63},
              {'국어':None, '영어':90, '수학':70, '과학':60},
              {'국어':88, '영어':62, '수학':None, '과학':31},
              {'국어':64, '영어':72, '수학':None, '과학':70},
              {'국어':120, '영어':50,'수학':None, '과학':88}]

df = DataFrame(grade_dict, index=['철수', '영희', '민철', '수현', '호영'])
print(df)
print('-' * 20)

print(df.isna())
print('-' * 20)

print(df.isna().sum())
print('-' * 20)