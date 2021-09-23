# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 17:19:29 2021

@author: eunse
"""

import numpy as np

data1 = ['people', 'boy', 'girl', 'man', 'woman']
data2 = ['1.5', '2.5', '3.5', '4.5', '5.5']
data3 = ['10', '20', '30', '40', '50']

arr1 = np.array(data1)
arr2 = np.array(data2)
arr3 = np.array(data3)

print(arr1, arr1.dtype)
print(arr2, arr2.dtype)
print(arr3, arr3.dtype)
print('-' * 20)

arr_f = arr2.astype(float)
print(arr_f, arr_f.dtype)
print('-' * 20)

arr_f = arr2.astype('float32')
print(arr_f, arr_f.dtype)
print('-' * 20)

arr_i = arr3.astype(int)
print(arr_i, arr_i.dtype)
print('-' * 20)

arr_i = arr3.astype('int64')
print(arr_i, arr_i.dtype)
print('-' * 20)

arr_s = arr_i.astype(str)
print(arr_s, arr_s.dtype)
print('-' * 20)

arr7 = np.arange(10, 100, 10)
print(arr7)
print('-' * 20)

arr8 = arr7.reshape(3, 3)
print(arr8)
print('-' * 20)

arr9 = arr8.reshape(9)
print(arr9)
print('-' * 20)

arr8 = arr7.reshape(3, 3, 1)
print(arr8)
print('-' * 20)

arr9 = arr8.reshape(9)
print(arr9)
print('-' * 20)