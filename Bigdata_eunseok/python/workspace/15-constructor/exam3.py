# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 14:45:38 2021

@author: eunse
"""

class Member:
    def __init__(self, name='none', age=0, tel="010-1111-1111"):
        self.__name = name
        self.__age = age
        self.tel = tel
        
    def output(self):
        print('name :', self.__name)
        print('age :', self.__age)
        print('tel :', self.tel)
        
    def setName(self, name):
        self.__name = name
        
    def getName(self):
        return self.__name
    
    def setAge(self, age):
        self.__age = age
        
    def getAge(self):
        return self.__age
        
mem = Member()
print(mem.tel)

mem.output()