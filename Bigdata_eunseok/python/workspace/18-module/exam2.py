# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 12:13:00 2021

@author: eunse
"""

from datetime import datetime

print(datetime.now())
print('-' * 20)

# 년, 월, 일, 시, 분, 초 설정
d1 = datetime(2021, 10, 4, 10, 10, 10)
print(d1)
print('-' * 20)

st1 = '{}/{}/{}'.format(d1.year, d1.month, d1.day)
print(st1)
print('-' * 20)

st1 = '{}:{}:{}'.format(d1.hour, d1.minute, d1.second)
print(st1)
print('-' * 20)

st2 = '{}'.format(d1)
print(st2)
print('-' * 20)

st2 = '{:%Y/%M/%d}'.format(d1)
print(st2)
print('-' * 20)

st2 = '{:%H:%M:%S}'.format(d1)
print(st2)
print('-' * 20)

day1 = datetime(2021, 1, 1)
day2 = datetime.now()
day_num = day2 - day1
print(day_num)
print('-' * 20)

print(day_num.days)
print('-' * 20)
