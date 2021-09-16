# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 12:40:44 2021

@author: eunse
"""

def total(n, m):
    tot = 0
    for i in range(n, m + 1):
        tot += i
    return tot

print(total(1,10))
print(total(5, 8))