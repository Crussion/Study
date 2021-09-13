# -*- coding: utf-8 -*-
"""
Created on Mon Sep 13 16:31:26 2021

@author: eunse
"""

while True:
    n = int(input("몇 단을 출력할지 입력하시오 : "))
    for i in range(1, 10):
        print(n, '*', i, '=', n * i)
    c = input("선택하시오(y:계속): ")
    if(c != 'y'):
        break