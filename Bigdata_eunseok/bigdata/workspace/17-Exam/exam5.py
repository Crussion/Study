import numpy as np
import pandas as pd
from pandas import DataFrame
from pandas import read_excel
from pandas import merge
import matplotlib.pyplot as plt
import datetime as dt

print(df)
print('-' * 20)

# 출생년도, 지역코
df_yl = df.filter(['h12_g4', 'h12_reg7'])
print(df_yl)
print('-' * 20)

df_yl = df_yl.rename(columns={'h12_g4':'출생년도', 'h12_reg7':'지역코드'})
print(df_yl)
print('-' * 20)

df_yl['나이'] = dt.datetime.now().year - df_yl['출생년도'] - 1
print(df_yl)
print('-' * 20)

df_yl = df_yl.drop('출생년도', axis=1)
print(df_yl)
print('-' * 20)

df_localcode = DataFrame({'지역코드':[i for i in range(1, 8)],
                          '지역':['서울', '인천, 경기', '부산, 경남, 울산',
                                '대구, 경북', '대전, 충남', '강원, 충북',
                                '광주, 전남, 전북, 제주']})
print(df_localcode)
print('-' * 20)

df_yl = merge(df_yl, df_localcode)
print(df_yl)
print('-' * 20)

df_yl = df_yl.drop('지역코드',axis=1)
print(df_yl)
print('-' * 20)

conditionList = [df_yl['나이'] < 30,
                df_yl['나이'] < 60,
                df_yl['나이'] >= 60]
level = ['청년층', '중년층', '노년층']

df_yl['연령층'] = np.select(conditionList, level)
print(df_yl)
print('-' * 20)

print(df_yl.isna().sum())
print('-' * 20)

result = df_yl.groupby(['지역', '연령층'], as_index=False).count()
print(result)
print('-' * 20)

result = result.rename(columns={'나이':'조사인원'})
print(result)
print('-' * 20)

pv = result.pivot('지역', '연령층', '조사인원')
print(pv)
print('-' * 20)

pv = pv.sort_index(ascending=False, axis=1)

pv.plot.bar(rot=0, fontsize=10)
plt.title('지역별 연령층 분포')
plt.xlabel('지역')
plt.ylabel('조사인원(명)')
plt.grid()
plt.show()

fig = plt.figure()

ax1 = fig.add_subplot(1, 3, 1)
ax2 = fig.add_subplot(1, 3, 2)
ax3 = fig.add_subplot(1, 3, 3)

fig.subplots_adjust(wspace=0.5)

pv['청년층'].plot.pie(autopct='%.1f%%', ax=ax1, fontsize=8)
pv['중년층'].plot.pie(autopct='%.1f%%', ax=ax2, fontsize=8)
pv['노년층'].plot.pie(autopct='%.1f%%', ax=ax3, fontsize=8)

ax1.set(ylabel=None)
ax2.set(ylabel=None)
ax3.set(ylabel=None)

ax1.title.set_text('청년층')
ax1.title.set_fontsize(10)

ax2.title.set_text('중년층')
ax2.title.set_fontsize(10)

ax3.title.set_text('노년층')
ax3.title.set_fontsize(10)

plt.show()