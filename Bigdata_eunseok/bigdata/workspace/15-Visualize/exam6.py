from pandas import DataFrame
import matplotlib.pyplot as plt

data = {'기온':[23, 25, 26, 27, 28, 29, 30, 31, 33],
        '판매량':[2100, 2300, 2500, 2800, 3300, 3500, 3600, 3700, 3900]}

df = DataFrame(data)

df.plot.scatter('기온', '판매량', color='orange')
plt.title('기온과 아이스크림 판매량의 상관관계')
plt.grid()
plt.legend(['판매수량'])
plt.xlabel('기온')
plt.ylabel('아이스크림 판매수량')
plt.show()