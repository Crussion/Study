# -*- coding: utf-8 -*-
"""
Created on Mon Sep 13 15:43:45 2021

@author: eunse
"""

for i in range(0, 91, 10):
    n = 0
    for j in range(i + 1, i + 11):
        n += j
    print(i+1, '~', i+10, '=', n)