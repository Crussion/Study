# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 16:37:18 2021

@author: eunse
"""

def plus1(x, y):
    print("함수 plus() 호출")
    return x + y
    
class Calc:
    #@staticmethod
    def plus2(x, y):
        print("스테틱 plus() 호출")
        return x + y
    
    def plus(self, x, y):
        print("메소드 plus() 호출")
        return x + y
    
    def minus(self, x, y):
        print("메소드 minus() 호출")
        return x - y
    
    def f(self, x, y):
        result1 = plus1(x, y)
        result2 = self.plus(x, y)
        result3 = Calc.plus2(x, y)
        result4 = result1 + result2 + result3
        return result4
    
print(Calc.plus2(5, 7))

cc = Calc()

print(cc.plus(5, 7))

print(cc.f(5, 7))