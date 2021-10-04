from pandas import read_excel
import matplotlib.pyplot as plt

df = read_excel('주요도시인구밀도_2017_문제A.xls')

df = df.rename(index=df['도시명']).drop('도시명', axis=1)
print(df)

plt.rcParams['font.family'] = 'Malgun Gothic'
plt.rcParams['font.size'] = 14
plt.rcParams['figure.figsize'] = (12, 8)

colors = ['red', 'skyblue', 'lightgreen', 'cyan', 'yellow', 'magenta', 'orange']
for i in range(7):    
    plt.scatter(df['경도'][i], df['위도'][i], df['인구밀도'][i] / 2,
                c=colors[i])
plt.ylim(35, 38)

for i, v in enumerate(df.index):
    plt.text(df['경도'][i], df['위도'][i], v,
             horizontalalignment='center')
    
plt.xlabel('경도')
plt.ylabel('위도')
plt.title('주요도시 인구밀도')
plt.show()