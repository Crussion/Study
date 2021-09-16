# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 11:53:48 2021

@author: eunse
"""

def star(n):
    for i in range(n):
        for j in range(i + 1):
            print('*', end='')
        print()

n = int(input("정수 입력 : "))        
star(n)