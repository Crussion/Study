# -*- coding: utf-8 -*-
"""
Created on Thu Sep 23 12:01:18 2021

@author: eunse
"""

import my_module1
my_module1.my_func()
print('-' * 20)

import my_module1 as my_m
my_m.my_func()
print('-' * 20)

from my_module1 import my_func
my_func()
print('-' * 20)

from my_module1 import my_func as my
my()
print('-' * 20)
