# -*- coding: utf-8 -*-
"""
Created on Mon Sep 13 15:32:12 2021

@author: eunse
"""

n = int(input("1~100 사이의 배수를 구할 숫자 입력 : "))

cnt = 0
for i in range(0, 101, n):
    if(i != 0):
        print(i, end=" ")
        cnt += 1
print()
print("1~100 사이의 %d의 배수 = %d" %(n, cnt))