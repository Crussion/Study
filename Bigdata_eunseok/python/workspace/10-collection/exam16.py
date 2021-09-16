# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 10:48:32 2021

@author: eunse
"""

dict1 = {101:'사과', 102:'복숭아', 103:'감', 104:'바나나'}
print(dict1)
print('-' * 20)

list_keys = list(dict1.keys())
list_values = list(dict1.values())
list_items = list(dict1.items())

print(list_keys)
print(list_values)
print(list_items)
print('-' * 20)

print(list(dict1))
print('-' * 20)