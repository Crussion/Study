# -*- coding: utf-8 -*-
"""
Created on Fri Sep 10 16:54:31 2021

@author: eunse
"""

str = "abcdefg"
print(str)
print('----------------')

print(str[3])
print(str[-3])
print('----------------')


print(str[1:5:2])
print('----------------')
print(str[1:5:1])
print(str[1:5])
print('----------------')
print(str[:5])
print('----------------')
print(str[1:])
print('----------------')
print(str[:])
print('----------------')
print(str[::-1])
print('----------------')
print(str[::-2])
print('----------------')

str1 = "abc"
str2 = "xyz"
str3 = str1 + str2
print(str1)
print(str2)
print(str3)
print('----------------')

str4 = str1 * 5
print(str4)
print('----------------')
print('-' * 20)

print(len(str4))
print('-' * 20)

print("이름 %s" %'홍길동')
print("이름 %s, 나이 %d" %('홍길동', 24))