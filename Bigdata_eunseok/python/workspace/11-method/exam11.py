# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 11:32:32 2021

@author: eunse
"""

def square1(x):
    return x**2

def test():
    print('test')
    return

print(square1(5))
print('-' * 20)

print(test())
print('-' * 20)

square2 = lambda x : x**2
print(square2(5))
print('-' * 20)

test1 = lambda : print('test1')
print(test1())
print('-' * 20)

print((lambda x : x**2)(5))
print('-' * 20)

print((lambda : print('test2'))())
print('-' * 20)

lst1 = [a for a in range(5)]
print(lst1)
print('-' * 20)

lst2 = [(lambda a : a**2)(n) for n in range(5)]
print(lst2)
print('-' * 20)