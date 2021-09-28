from pandas import DataFrame, merge

df_left = DataFrame({'고객번호':[1001, 1002, 1003, 1004], 
                     '이름':['둘리', '도우너', '포치', '길동']})

df_right = DataFrame({'고객번호':[1001, 1002, 1003, 1005],
                      '금액':[10000, 20000, 15000, 5000]})

print(df_left)
print(df_right)
print('-' * 20)


df = merge(df_left, df_right)
print(df)
print('-' * 20)

df = merge(df_left, df_right, how='left')
print(df)
print('-' * 20)

df = merge(df_left, df_right, how='right')
print(df)
print('-' * 20)

df = merge(df_left, df_right, how='outer')
print(df)
print('-' * 20)