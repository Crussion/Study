# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 15:54:43 2021

@author: eunse
"""

class Triangle:
    def __init__(self, w = 0, h = 0):
        self.w = w
        self.h = h
        
    def setTriangle(self, w, h):
        self.w = w
        self.h = h
        
    def getArea(self):
        return self.w * self.h / 2
    
t1 = Triangle(45, 7)
print("삼각형의 넓이 :", t1.getArea())

t2 = Triangle()
t2.setTriangle(5, 12)
print("삼각형의 넓이 :", t2.getArea())