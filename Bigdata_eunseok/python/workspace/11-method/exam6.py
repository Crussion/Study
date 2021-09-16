# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 13:01:07 2021

@author: eunse
"""

def inputNum(n):
    cnt = len(n) + 1
    num = int(input("%d번째 숫자 입력 : " %cnt))
    n.append(num)

def outputNum(n):
    print("*** 출력 ***")
    for i in n:
        print(i, end=" ")

n = []

inputNum(n)
inputNum(n)
inputNum(n)
inputNum(n)
inputNum(n)

outputNum(n)