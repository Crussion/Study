# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 10:51:40 2021

@author: eunse
"""

st1 = '        He likes apples, she likes too      '
print(st1)
print('-' * 20)

print(st1.strip() + 'ttt')
print('-' * 20)

print(st1.rstrip() + 'ttt')
print('-' * 20)

print(st1.lstrip() + 'ttt')
print('-' * 20)

print(st1.replace('like', 'love'))
print('-' * 20)