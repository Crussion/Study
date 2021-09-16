# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 11:39:12 2021

@author: eunse
"""

list1 = [1,2,3,4,5,5,5,5]
print(list1, type(list1))
print('-' * 20)

tup1 = tuple(list1)
print(tup1, type(tup1))
print('-' * 20)

set1 = set(list1)
print(set1, type(set1))
print('-' * 20)

list2 = list(tup1)
list3 = list(set1)
print(list2, type(list2))
print(list3, type(list3))
print('-' * 20)