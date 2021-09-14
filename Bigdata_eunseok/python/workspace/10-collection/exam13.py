# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 16:46:36 2021

@author: eunse
"""

dic1 = {'a':1, 'b':2, 'c':'hello', 'd':'파이썬'}
print(dic1)
print('-' * 20)

dic1 = {1.1: 1, 2.2:2, 3.3:'hello', 4.4: '파이썬'}
print(dic1)
print('-' * 20)

#키값이 중복되면 마지막 데이터가 저장
dic1 = {'a':1, 'b':2, 'a':'hello', 'd':'파이썬'}
print(dic1)
print('-' * 20)

print(dic1['a'])
print(dic1['b'])
print(dic1['d'])
print('-' * 20)

dic1['전화번호'] = '010-1234-5678'
print(dic1)
print('-' * 20)

dic1['전화번호'] = '010-5555-5678'
print(dic1)
print('-' * 20)

del(dic1['전화번호'])
print(dic1)
print('-' * 20)

dic1.clear()
print(dic1)
print('-' * 20)
