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
print('-' * 20)

df['서울'].plot.barh(color='purple')
plt.grid()
plt.legend()
plt.title('2019년 서울의 월별 교통사고')
plt.ylabel('월')
plt.xlabel('교통사고수')
plt.xlim([2300, 4000])

for i, v in enumerate(df['서울']):
    txt = '%d건' %v
    plt.text(v, i, txt, fontsize=14, color='red')
    
plt.show()

df.plot.barh()
plt.grid()
plt.legend(bbox_to_anchor=(1, 0.3))
plt.title('2019년 서울의 월별 교통사고')
plt.ylabel('월')
plt.xlabel('교통사고수')

# y축 데이터의 순서를 반대로 출력
plt.gca().invert_yaxis()
plt.show()