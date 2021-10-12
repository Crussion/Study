from pandas import read_csv
from bs4 import BeautifulSoup

# 1. 엑셀파일 읽기
#df = read_csv('data/한국교원대학교_초중등학교위치.csv', encoding='euc-kr')
print(df)
print('-' * 20)

# 2. 데이터 전처리
# 1) 필요한 컬럼 추출
df2 = df.filter(['학교명','학교급구분','소재지도로명주소'])
print(df2)
print('-' * 20)

# 2) 결측치 확인
print(df2.isna().sum())
print('-' * 20)

# 3) 결측치 제거
df2 = df2.dropna()

print(df2.isna().sum())
print('-' * 20)

# 4) 소재지도로명주소에서 시,도 이름만 추출
# 시,도 다음에 나타나는 공백문자 위치 저장
df2['idx'] = df2['소재지도로명주소'].str.find(' ')
print(df2)
print('-' * 20)

# 시도 컬럼 추가
# => 1~2분 정도 시간이 걸림
for i in df2.index :
    addr = df2.loc[i, '소재지도로명주소']
    idx = df2.loc[i, 'idx']
    city = addr[:idx]
    df2.loc[i, '시도'] = city

print(df2)
print('-' * 20)

# 3. 데이터 분석
# 지역별, 학교별 집계
# \ : 한줄 명령이 아직 끝나지 않음을 나타내는 기호
df_result = df2.filter(['시도','학교급구분','학교명'])\
            .groupby(['시도','학교급구분']).count()
print(df_result)
print('-' * 20)

df_result = df_result.rename(columns={'학교명':'학교수'})
print(df_result)
print('-' * 20)

dict_elementry = {}
for idx in df_result.index:
    a = idx[0] #시도
    b = idx[1] #학교급구분
    if b == '초등학교' :
        dict_elementry[a] = df_result.loc[idx, '학교수']

print(dict_elementry)
print('-' * 20)

dict_elementry['경기도'] += dict_elementry['경기']
dict_elementry['대전광역시'] += dict_elementry['대전']
del(dict_elementry['경기'])
del(dict_elementry['대전'])

print(dict_elementry)
print('-' * 20)

# 4. 데이터 시각화

map_svg = None
with open('data/Korea.svg', 'r', encoding='utf-8') as f:
    map_svg = f.read()
    
print(map_svg)
print('-' * 20)

colors = ['#E4F7BA','#CEF279','#BCE55C','#9FC93C','#6B9900','#476600']

soup = BeautifulSoup(map_svg)

glist = soup.select('svg > g[id],svg > path[id]')
print(len(glist))
print('-' * 20)

for item in glist:
    if item['id'] not in dict_elementry:
        continue
    
    count = dict_elementry[item['id']]
    
    if count > 500 : color_index = 5
    elif count > 600 : color_index = 4
    elif count > 450 : color_index = 3
    elif count > 300 : color_index = 2
    elif count > 150 : color_index = 1
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