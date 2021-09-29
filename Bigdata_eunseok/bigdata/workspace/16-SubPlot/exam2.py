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

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 16
plt.rcParams['figure.figsize'] = (10, 8)
plt.rcParams['axes.unicode_minus'] = False

fig = plt.figure()
ax1 = fig.add_subplot(1, 4, 1)
ax2 = fig.add_subplot(1, 4, 2)
ax3 = fig.add_subplot(1, 4, 3)
ax4 = fig.add_subplot(1, 4, 4)

fig.subplots_adjust(wspace=0.5, hspace=0.5)

df.boxplot('서울', ax=ax1)
df.boxplot('부산', ax=ax2)
df.boxplot('대구', ax=ax3)
df.boxplot('인천', ax=ax4)
plt.show()