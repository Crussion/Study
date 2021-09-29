
from pandas import read_excel
import pandas as pd
import matplotlib.pyplot as plt

df = read_excel('data/시도별_교통사고.xlsx')

col_list = list(df.columns)
df = df.filter(['시도별(1)', '2019. 01', '2019. 02', '2019. 03', '2019. 04', '2019. 05', '2019. 06',
                '2019. 07', '2019. 08', '2019. 09', '2019. 10', '2019. 11', '2019. 12'])

row, col = df.shape

pd.set_option('display.max_columns', col)

df = df.drop(0)

df = df.set_index('시도별(1)')

col_list = list(df.columns)

month_dict = {'2019. 01':'1월', '2019. 02':'2월', '2019. 03':'3월', 
              '2019. 04':'4월', '2019. 05':'5월', '2019. 06':'6월', 
              '2019. 07':'7월', '2019. 08':'8월', '2019. 09':'9월', 
              '2019. 10':'10월', '2019. 11':'11월', '2019. 12':'12월'}

df = df.rename(columns=month_dict)

df = df.T

df = df.filter(['서울', '부산', '대구', '인천'])
print(df)
print(df.dtypes)
print('-' * 20)

df = df.astype(int)

fig = plt.figure()
fig.suptitle('2019년 교통사고 현황', color='green')

ax1 = fig.add_subplot(2, 2, 1)
ax2 = fig.add_subplot(2, 2, 2)
ax3 = fig.add_subplot(2, 2, 3)
ax4 = fig.add_subplot(2, 2, 4)

fig.subplots_adjust(wspace=0.5, hspace=0.5)

plt.subplots_adjust(left=0.1,
                    bottom=0.1,
                    right=0.9,
                    top=0.9,
                    wspace=0.5,
                    hspace=0.5)

df.plot(ax=ax1, fontsize=8)
df.plot.bar(ax=ax2, fontsize=8)
df.plot.pie(ax=ax3, y='서울', autopct='%.1f%%')
df.plot.scatter('서울', '부산', ax=ax4, color='orange', fontsize=8)

ax1.title.set_text('서울, 부산, 대구, 인천의 2019년 교통사고 변화')
ax1.title.set_color('red')
ax1.title.set_fontsize(12)

ax1.grid()
ax1.set_xticks(list(range(12)))
ax1.set_xticklabels(df.index, fontsize=8, color='red')
ax1.set_xlim(-0.5, 11.5)
ax1.set_ylim(0, 4000)
ax1.set(xlabel='월', ylabel='교통사고')
ax1.legend(loc='center left', fontsize=10)

ax2.title.set_text('서울, 부산, 대구, 인천의 2019년 교통사고 빈도')
ax2.title.set_color('blue')
ax2.title.set_fontsize(12)
ax2.grid()
ax2.set(xlabel='월', ylabel='교통사고')
ax2.set_xticklabels(df.index, fontsize=8, color='blue')
ax2.legend(loc='upper right', fontsize=10)

ax3.title.set_text('서울의 월별 교통사고 비율')
ax3.legend(bbox_to_anchor=(1.1, 1), fontsize=10, title='범주')
ax3.set(ylabel='')

ax4.title.set_text('서울과 부산의 교통사고 관계')
ax4.title.set_fontsize(12)
ax4.legend(['교통사고'], loc='upper left', fontsize=10)
ax4.grid()
ax4.set_xlim(2300, 4000)
ax4.set_ylim(900, 1300)

plt.show()