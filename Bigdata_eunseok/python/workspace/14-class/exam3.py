# -*- coding: utf-8 -*-
"""
Created on Thu Sep 16 16:11:56 2021

@author: eunse
"""

class HelloWorld:
    message = 'Python!!!'
    
    def setEng(self):
        self.message = 'Hello Python'
    
    def setKor(self):
        self.message = '안녕하세요, 파이썬'
        
    def setKor(self):
        message = '파이썬 파이팅!!'
        
    def sayHello(self):
        print(HelloWorld.message)
        print(self.message)

print(HelloWorld.message)

hello = HelloWorld()
hello.setEng()
hello.sayHello()