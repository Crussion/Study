# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 12:17:06 2021

@author: eunse
"""

f = open('test.txt', 'r')
text = f.read()
print(text)

f.close()
print('-' * 20)

f = open('test.txt', 'r')
text = f.readline()
print(text)

f.close()
print('-' * 20)

f = open('test.txt', 'r')
while True :
    text = f.readline()
    if not text : break
    print(text)

f.close()
print('-' * 20)

f = open('test.txt', 'r')
list1 = f.readlines()
print(list1)

f.close()
print('-' * 20)