# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 16:40:15 2021

@author: eunse
"""

class CalcParent:
    def plus(self, x, y):
        print("CalcParent, plus() 호출")
        return x + y
    
    def minus(self, x, y):
        print("CalcParent, minus() 호출")
        return x - y
    
class CalcChild(CalcParent):
    
    def plus(self, x, y):
        print("CalcChild, plus() 호출")
        return x + y
    
    def minus(self, x, y):
        print("CalcChild, minus() 호출")
        return x - y
    
    def multiply(self, x, y):
        print("CalcChild, multiply() 호출")
        return x * y
    
    def divide(self, x, y):
        print("CalcChild, divide() 호출")
        return x / y
    
parent = CalcParent()
print(parent.plus(5, 7))
print(parent.minus(5, 7))
print('-' * 20)

child = CalcChild()
print(child.plus(5, 7))
print(child.minus(5, 7))
print(child.multiply(5, 7))
print(child.divide(5, 7))
print('-' * 20)