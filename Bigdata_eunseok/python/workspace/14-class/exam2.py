# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

class Car :
    maker = 'Benz'
    def set(self):
        self.model = 'E-Class'
        self.color = 'blue'
        self.speed = 10
    
    def drive(self):
        self.speed = 20
        
    def output(self):
        print('모델 :', self.model)
        print('색상 :', self.color)
        print('속도 :', self.speed)
        
    def output1(self):
        print('모델 :', self.model)
        print('색상 :', self.color)
        print('속도 :', self.speed)
        print('회사 :', self.maker)
        
print(Car.maker)
print("-" * 20)
