# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 12:35:28 2021

@author: eunse
"""

mon = [31,28,31,30,31,30,31,31,30,31,30,31]

print("*** 일수 구하기 ***")
m = int(input("월 : "))
d = int(input("일 : "))

day = 0
for i in range(1, m):
    day += mon[i]
day += d

print("1월 1일부터 %d월 %d일까지는 %d일 입니다." %(m, d, day))