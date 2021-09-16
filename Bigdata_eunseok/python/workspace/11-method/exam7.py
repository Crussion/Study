# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 15:56:43 2021

@author: eunse
"""

def total(*args):
    tot = 0
    for a in args:
        tot += a
    
    return tot

print(total(2,4,6,8,10))
print(total(2,4,6,8,10,12,14,16))