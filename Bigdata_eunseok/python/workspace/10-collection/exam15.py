# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 10:31:23 2021

@author: eunse
"""

dict1 = {'a':1, 'b':2, 'c':'hello', 'd':'파이썬'}
print(dict1)
print('-' * 20)

s1 = "{} {} {} {}".format(*dict1)
print(s1)
print('-' * 20)

s1 = "{a} {b} {c} {d}".format(**dict1)
print(s1)
print('-' * 20)

s1 = "{}:{a} {}:{b} {}:{c} {}:{d}".format(*dict1, **dict1)
print(s1)
print('-' * 20)