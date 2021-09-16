# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 16:07:59 2021

@author: eunse
"""

def calc_area(radius):
    global area
    area = 3.14 * radius**2

area = 0

r = float(input("원의 반지름 : "))
calc_area(r)
print("원의 넓이 :", area)