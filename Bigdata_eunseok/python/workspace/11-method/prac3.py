# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 16:58:34 2021

@author: eunse
"""

def add(n=1, m=100):
    tot = 0
    for i in range(n, m + 1):
        tot += i
    return tot

print(add())
print(add(30))
print(add(20,200))