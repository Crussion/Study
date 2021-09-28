# -*- coding: utf-8 -*-
"""
Created on Tue Sep 28 11:51:32 2021

@author: eunse
"""
from pandas import DataFrame

# 서울, 부산, 인천의 5년 단위 인구 분포
city_people = {
    "도시": ["서울", "서울", "서울", "부산", "부산", "부산", "인천", "인천"],
    "연도": ["2015", "2010", "2005", "2015", "2010", "2005", "2015", "2010"],
    "인구": [9904312, 9631482, 9762546, 3448737, 3393191, 3512547, 2890451, 2632035],
    "지역": ["수도권", "수도권", "수도권", "경상권", "경상권", "경상권", "수도권", "수도권"]
}

df = DataFrame(city_people)
print(df)
print('-' * 20)

df1 = df.filter(['도시', '인구'])
print(df1)
print('-' * 20)

result = df1.groupby('도시').max()
print(result)
print('-' * 20)
