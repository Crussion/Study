import matplotlib.pyplot as plt
import datetime as dt

print(df)
print('-' * 20)

df_ys = df.filter(['h12_g4', 'p1202_8aq1'])
print(df_ys)
print('-' * 20)

df_ys = df_ys.rename(columns={'h12_g4':'출생년도', 'p1202_8aq1':'월급'})
print(df_ys)
print('-' * 20)

year = dt.datetime.now().year
print(year)
print('-' * 20)

df_ys['나이'] = year - df_ys['출생년도'] + 1
print(df_ys)
print('-' * 20)

df_ys = df_ys.dropna()
print(df_ys)
print('-' * 20)

result = df_ys.filter(['나이', '월급']).groupby('나이').mean()
print(result)
print('-' * 20)

result.plot()
plt.title('나이에 따른 평균 월급 변화')
plt.grid()
plt.xlabel('나이')
plt.ylabel('평균월급(만원)')
plt.show()