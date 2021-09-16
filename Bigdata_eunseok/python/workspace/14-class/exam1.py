# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

class Car :
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
        
car = Car()
car.set()
print("-" * 20)

car.output()
print("-" * 20)
car.drive()
car.output()
print("-" * 20)

car.maker = 'Benz'
car.output1()
print("-" * 20)