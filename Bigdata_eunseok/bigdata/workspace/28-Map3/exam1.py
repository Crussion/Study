from bs4 import BeautifulSoup
from pandas import read_excel
import os

df = read_excel('data/senior_lsf.xlsx')
print(df)
print('-' * 40)

map_svg = None
with open('data/Seoul.svg', 'r') as f:
    map_svg = f.read()

soup = BeautifulSoup(map_svg)

paths = soup.select('path[id]')
print(len(paths))
print('-' * 40)

colors = ['#FFD9FA', '#FFB2F5', '#F361DC', '#D941C5', '#990085', '#660058']

data_dict = {}

for i in df.index :
    data_dict[df.loc[i, 'COUNTY']] = df.loc[i, 'NUMBER']
    
print(data_dict)
print('-' * 40)

for p in paths:
    if p['id'] == 'Yeongdeungpo-gu_1_':
        p['id'] = 'Yeongdeungpo-gu'
    
    count = data_dict[p['id']]
    
    if count > 250 : color_index = 5
    elif count > 200 : color_index = 4
    elif count > 150 : color_index = 3
    elif count > 100 : color_index = 2
    elif count > 50 : color_index = 1
    else : color_index = 0
    
    p['fill'] = colors[color_index]
    
new_svg = soup.prettify()

with open('new_Seoul.svg', 'w') as f:
    f.write(new_svg)
    print('저장 완료')
    
os.system('new_Seoul.svg')