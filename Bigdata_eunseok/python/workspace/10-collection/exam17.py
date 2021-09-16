# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 10:59:31 2021

@author: eunse
"""

a = {1,2,3}
b = {1,2,3,3,3}
print(a, len(a))
print(b, len(b))
print('-' * 20)

c = {}
d = set()
print(c, type(c))
print(d, type(d))
print('-' * 20)

a.add(4)
print(a)
print('-' * 20)

for v in a:
    print(v)
    
print('-' * 20)

list_a = list(a)
print(list_a[1])
print('-' * 20)

s1 = sorted(a)
print(s1)
print('-' * 20)

if 2 in a :
    print('데이터 존재')
    
print(a)
print('-' * 20)

r1 = a.pop()
print(r1)
print(a)
print('-' * 20)

a.remove(2)
print(a)
print('-' * 20)