# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 15:11:37 2021

@author: eunse
"""

from random import *

# 0.0 <= x < 1.0 사이의 임의 실수값
print(random())
print('-' * 20)

# n~m 사이의 임의의 정수
print(randint(0, 9))
print('-' * 20)

# n~m 사이의 임의의 정수 : step 설정 가능
print(randrange(5, 10))
print('-' * 20)

print(chr(65))
print('-' * 20)

print(chr(randint(65, 90)))
print('-' * 20)

print(sample([1,2,3,4,5], 2))
print('-' * 20)