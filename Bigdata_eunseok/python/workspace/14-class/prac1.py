# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 17:12:40 2021

@author: eunse
"""

class Triangle:
    def setTriangle(self, width, height):
        self.width = width
        self.height = height
    def getArea(self):
        return self.width * self.height / 2
    
b = int(input("밑변 : "))
h = int(input("높이 : "))

t = Triangle()
t.setTriangle(b, h)

print(t.getArea())