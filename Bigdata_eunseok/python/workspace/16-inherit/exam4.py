# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 17:50:44 2021

@author: eunse
"""

class Area:
    def setArea(self, w, h):
        self.w = w
        self.h = h
        
class Rectangle(Area):
    def getArea(self):
        return self.w * self.h
    
class Triangle(Area):
    def getArea(self):
        return self.w * self.h / 2
    
r = Rectangle()
t = Triangle()

r.setArea(10.5, 20.5)
t.setArea(5.0, 9.0)
print("사각형의 넓이 :", r.getArea())
print("삼각형의 넓이 :", t.getArea())