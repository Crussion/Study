# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 10:36:55 2021

@author: eunse
"""

list1 = [0 for a in range(5)]
print(list1)
print('-' * 20)

list1 = [a for a in range(5)]
print(list1)
print('-' * 20)

list2 = []
for a in range(5):
    list2.append(a)
    
print(list2)
print('-' * 20)

list3 = [num*3 for num in range(1,5) if num%2 == 0]

print(list3)
print('-' * 20)

list4 = ['foo', 'bar', 'baz']
for i, v in enumerate(list4):
    print(i, v)

print('-' * 20)

list5 = ['one', 'two', 'three']
for a, b in zip(list4, list5):
    print(a, b)
    
print('-' * 20)


for a, b, c in zip(list4, list5, range(5)):
    print(a, b, c)