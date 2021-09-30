import numpy as np
import pandas as pd
from pandas import DataFrame
from pandas import read_excel
import matplotlib.pyplot as plt

print(df)
print('-' * 20)

df_g = df.filter(['h12_g3', 'p1202_8aq1'])
print(df_g)
print('-' * 20)

df_g = df_g.rename(columns={'h12_g3':'성별', 'p1202_8aq1':'월급'})
print(df_g)
print('-' * 20)

#df_g['월급'] = np.where(df_g['월급'].isna(), 0, df_g['월급'])
df_g['월급'] = np.where((df_g['월급'] < 0) | (df_g['월급'] > 1500),
                      np.nan, df_g['월급'])
df_g = df_g.dropna()
print(df_g)
print('-' * 20)

df_g['성별'] = np.where(df_g['성별'] == 1, '남자', '여자')
print(df_g)
print('-' * 20)

df_m = df_g.query('성별 == "남자"')
print(df_m)
print('-' * 20)

df_w = df_g.query('성별 == "여자"')
print(df_w)
print('-' * 20)

df_m_avg = df_m.mean()
df_w_avg = df_w.mean()
print(df_m_avg)
print(df_w_avg)
print('-' * 20)

df_s = DataFrame([df_m_avg, df_w_avg], index=['남자', '여자'])
print(df_s)
print('-' * 20)

df_s.plot.bar(rot=0)
plt.title('성별에 따른 평균 월급 차이 분석')
plt.xlabel('성별')
plt.ylabel('월급')
plt.grid()

for i, v in enumerate(df_s['월급']):
    txt = '%.1f만원' %v
    plt.text(i, v + 1, txt, color='blue',
             horizontalalignment='center')
    
plt.show()