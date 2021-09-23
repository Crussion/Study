# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 10:18:22 2021

@author: eunse
"""

st1 = 'He likes apples, she likes too'
print(st1)
print('-' * 20)

print(st1.count('like'))
print('-' * 20)

print(st1.find('like'))
print('-' * 20)

print(st1.rfind('like'))
print('-' * 20)

print(st1.index('like')) # 없으면 에러
print('-' * 20)

print(st1.rindex('like')) # 없으면 에러
print('-' * 20)

print(st1.startswith('H'))
print('-' * 20)

print(st1.endswith('H'))
print('-' * 20)