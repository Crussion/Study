# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 16:00:57 2021

@author: eunse
"""

def sumAndMul(n, m):
    tot = n+m
    mul = n*m
    return tot, mul

result = sumAndMul(5,7)
print(result)
print(type(result))

tot, mul = sumAndMul(10, 20)
print(tot)
print(mul)