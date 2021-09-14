# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 15:49:50 2021

@author: eunse
"""

tup1 = (10,20,30,50,30)
tup2 = ('C언어', 'Python', 'Java', 'JSP')
print(tup1)
print(tup2)
print('-' * 20)

tup3 = tup1 + tup2
print(tup3)
print('-' * 20)

tup4 = tup1 * 3
print(tup4)
print('-' * 20)

print(30 in tup1)
print(300 in tup1)
print('-' * 20)

print(tup1.count(30))
print('-' * 20)

print(tup1.index(20))
print(tup1.index(30))
print(tup1.index(30, 3))
print('-' * 20)

offset = 0
for i in range(len(tup1)):
    if offset < len(tup1):
        pos = tup1.index(30, offset)
        offset = pos+1
        print(pos, end=' ')
print()
print('-' * 20)

print(len(tup1))
print('-' * 20)