# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 09:59:34 2021

@author: eunse
"""

dict1 = {'a':1, 'b':2, 'c':'hello', 'd':'파이썬'}
print(dict1)
print('-' * 20)

if 'c' in dict1:
    print('key가 존재함')
    
print('-' * 20)

print(dict1.keys())
print('-' * 20)

print(dict1.values())
print('-' * 20)

print(dict1.items())
print('-' * 20)

for k, v in dict1.items():
    print(k, v)

print('-' * 20)

print(dict1['b'])
print('-' * 20)

print(dict1.get('b'))
print('-' * 20)

print(dict1.get('e'))
print('-' * 20)

d1 = sorted(dict1)
print(d1)
print('-' * 20)

print(len(dict1))
print('-' * 20)

dict2 = {'e': '빅데이터', 'f':'딥러닝'}

dict1['g'] = dict2

print(dict1)
print('-' * 20)

dict1.update(dict2)
print(dict1)
print('-' * 20)