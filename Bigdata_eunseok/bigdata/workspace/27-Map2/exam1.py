import folium
from pandas import read_csv

df = read_csv('data/한국교원대학교_초중등학교위치.csv', encoding='euc-kr')

print(df)
print('-' * 40)

df = df.filter(['학교명', '학교급구분', '소재지도로명주소', '위도', '경도'])

print(df)
print('-' * 40)

print(df.isna().sum())
print('-' * 40)

df = df.dropna()

print(df.isna().sum())
print('-' * 40)

print(df)
print('-' * 40)

location = [37.56632078593349, 126.97797278911634]

map_osm = folium.Map(location=location, zoom_start=12)

for i in range(len(df)):
    try:
        location = [df.loc[i]['위도'], df.loc[i]['경도']]
        txt = df.loc[i]['학교명']
        school_class = df.loc[i]['학교급구분']
        school_loc = df.loc[i]['소재지도로명주소']
        
        if '서울특별시' in school_loc:
            if school_class == '초등학교':
                marker = folium.Marker(location, popup=txt,
                                   icon=folium.Icon(color='red'))
            elif school_class == '중학교':
                marker = folium.Marker(location, popup=txt,
                                   icon=folium.Icon(color='blue'))
            elif school_class == '고등학교':
                marker = folium.Marker(location, popup=txt,
                                   icon=folium.Icon(color='green'))
            
        marker.add_to(map_osm)
    except Exception as e:
        print(e)
        pass

map_osm.save('map_osm.html')
print('저장 완료')