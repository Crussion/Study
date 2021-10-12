from pandas import read_csv
from bs4 import BeautifulSoup

df = read_csv('data/한국교원대학교_초중등학교위치.csv', encoding='euc-kr')

print(df)
print('-' * 40)

df = df.filter(['학교명','학교급구분','소재지도로명주소'])

print(df)
print('-' * 40)

df = df.dropna()

print(df)
print('-' * 40)

for i in df.index:
    df.loc[i, '지역'] = df.loc[i, '소재지도로명주소'].split(' ')[0]

df = df.drop('소재지도로명주소', axis=1)

print(df)
print('-' * 40) 

df = df.groupby(['지역', '학교급구분']).count()
df = df.rename(columns={'학교명':'학교수'})

print(df)
print('-' * 40)

dict_school = {}
for index in df.index:
    loc = index[0]
    clas = index[1]
    if clas == '고등학교':
        dict_school[loc] = df.loc[index, '학교수']
        
print(dict_school)
print('-' * 40)

map_svg = None
with open('data/Korea.svg', 'r', encoding='utf-8') as f:
    map_svg = f.read()
    
#print(map_svg)
print('-' * 20)

colors = ['#E4F7BA','#CEF279','#BCE55C','#9FC93C','#6B9900','#476600']

soup = BeautifulSoup(map_svg, 'lxml')

glist = soup.select('svg > g[id],svg > path[id]')
print(len(glist))
print('-' * 20)

for item in glist:
    if item['id'] not in dict_school:
        continue
    
    count = dict_school[item['id']]
    
    if count > 300 : color_index = 5
    elif count > 240 : color_index = 4
    elif count > 180 : color_index = 3
    elif count > 120 : color_index = 2
    elif count > 60 : color_index = 1
    else : color_index = 0
    
    for p in item.select('g,path'):
        p['fill'] = colors[color_index]
    
    if item['id'] == '세종특별자치시':
        item['fill'] = colors[color_index]
        
elementry_svg = soup.prettify()

with open('elementry.svg', 'w', encoding='utf-8') as f:
    f.write(elementry_svg)
    print('저장 성공')
    
import os
os.system('elementry.svg')