# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 11:31:00 2021

@author: eunse
"""

a = {1,2,3,4,5}
b = {4,5,6,7,8,9,10}
print(a)
print(b)
print('-' * 20)

r = a.union(b)
print(r)
print('-' * 20)

r = a.intersection(b)
print(r)
print('-' * 20)

r = a.difference(b)
print(r)
print('-' * 20)