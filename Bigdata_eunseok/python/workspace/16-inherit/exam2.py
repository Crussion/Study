# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 16:49:20 2021

@author: eunse
"""

class CalcParent1:
    def __init__(self, a=5, b=5):
        self.a = a
        self.b = b
        
    def plus1(self, x, y):
        print("CalcParent1, plus() 호출")
        return x + y
    
    def minus(self, x, y):
        print("CalcParent, minus() 호출")
        return x - y
    
class CalcParent2:
    def __init__(self, a=7, b=7):
        self.a = a
        self.b = b
        
    def plus1(self, x, y):
        print("CalcParent2, plus() 호출")
        return x + y
    
    def minus(self, x, y):
        print("CalcParent, minus() 호출")
        return x - y
    
class CalcChild(CalcParent1, CalcParent2):
    
    def output(self):
        print(self.a, self.b)
    
    def plus(self, x, y):
        # 부모클래스 super()
        super().plus1(5, 5)
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
    
child = CalcChild()
child.output()
child.plus1(5, 7)