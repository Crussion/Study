from pandas import DataFrame

hero_list = ['아이언맨', '아이언맨', '아이언맨', '캡틴아메리카',
             '캡틴아메리카', '캡틴아메리카', '캡틴아메리카', '캡틴아메리카', 
             '블랙위도우', '블랙위도우', '토르', '헐크', '헐크']

df = DataFrame(hero_list, columns=['이름'])
print(df)
print('-' * 20)

cnt_str = df['이름'].value_counts()
print(cnt_str)
print('-' * 20)

df1 = DataFrame(cnt_str)
print(df1)
print('-' * 20)

df1 = df1.rename(columns={'이름':'득표수'})
print(df1)
print('-' * 20)

df1 = df1.sort_index()
print(df1)
print('-' * 20)

df1 = df1.sort_values('득표수')
print(df1)
print('-' * 20)

df1 = df1.sort_values('득표수', ascending=False)
print(df1)
print('-' * 20)