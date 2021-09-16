# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 13:19:24 2021

@author: eunse
"""

def doubleNum(n, m):
    if n % m == 0:
        return 1
    else:
        return 0
    
a = int(input("정수 입력 : "))
b = int(input("정수 입력 : "))

if doubleNum(a, b):
    print(str(a) + '(은)는 ' + str(b) + "의 배수입니다.")
else:
    print(str(a) + '(은)는 ' + str(b) + "의 배수가 아닙니다.")