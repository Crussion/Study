# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 16:57:08 2021

@author: eunse
"""

import numpy as np

data1 = [10,20,30,40,50,60]
arr1 = np.array(data1)
print(arr1)
print('-' * 20)

print(arr1[1:5:2])
print('-' * 20)

print(arr1[1:5])
print('-' * 20)

print(arr1[:5])
print('-' * 20)

print(arr1[:])
print('-' * 20)

print(arr1[::-2])
print('-' * 20)

print(arr1[::-1])
print('-' * 20)

data2 = [[1,2,3],
         [4,5,6],
         [7,8,9]]

arr2 = np.array(data2)
print(arr2)
print('-' * 20)

print(arr2[1:3, 1:3])
print('-' * 20)

arr2[1:3, 1:3] = [10,20], [30,40]
print(arr2)
print('-' * 20)

arr2[1:3, 1:3] = 20
print(arr2)
print('-' * 20)