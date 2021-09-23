# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 15:01:55 2021

@author: eunse
"""

import numpy as np

data1 = [1,2,3,4,5]
data2 = [1.7, 2, 5.5, 7, 9.9]
data3 = [1.7, 2, 'hello', 7, 9.9, True]
data4 = [1.7, 2, 7, 9.9, True, False]

arr1 = np.array(data1)
print(data1)
print(arr1)
print('-' * 20)

print(type(arr1))
print(arr1.dtype)
print(arr1.shape)
print(len(arr1))
print('-' * 20)

arr2 = np.array(data2)
print(data2)
print(arr2)
print('-' * 20)

print(type(arr2))
print(arr2.dtype)
print(arr2.shape)
print(len(arr2))
print('-' * 20)

arr3 = np.array(data3)
print(data3)
print(arr3)
print('-' * 20)

print(type(arr3))
print(arr3.dtype)
print(arr3.shape)
print(len(arr3))
print('-' * 20)

arr4 = np.array(data4)
print(data4)
print(arr4)
print('-' * 20)

print(type(arr4))
print(arr4.dtype)
print(arr4.shape)
print(len(arr4))
print('-' * 20)