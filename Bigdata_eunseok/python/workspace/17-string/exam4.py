# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 11:03:34 2021

@author: eunse
"""

st1 = 'He likes apples, she likes too'
print(st1)
print('-' * 20)

print(st1.split(' ', 2))
print('-' * 20)

print(st1.rsplit(' ', 2))
print('-' * 20)

st3 = '''\
첫번째줄
두번째줄
세번째줄'''
print(st3.splitlines())
print('-' * 20)

st2 = ['He', 'likes', 'apples', 'she', 'likes', 'too']
print(st2)
print('-' * 20)

print('#'.join(st2))
print('-' * 20)