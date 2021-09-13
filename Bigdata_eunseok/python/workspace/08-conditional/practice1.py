# -*- coding: utf-8 -*-
"""
Created on Mon Sep 13 13:04:31 2021

@author: eunse
"""

n = input("첫 번째 수 : ")
m = input("두 번째 수 : ")
oper = input("연산자 : ")
print(n, oper, m, "=", eval(n + oper + m))