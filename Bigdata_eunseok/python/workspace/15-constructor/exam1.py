# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 12:55:45 2021

@author: eunse
"""

class Car:
    def __init__(self, speed, color, model):
        print("*** 생성자 호출 ***")
        self.speed = speed
        self.color = color
        self.model = model
    
    def drive(self, speed):
        self.speed = speed
        
    def output(self):
        print('속도 :', self.speed)
        print('색상 :', self.color)
        print('모델 :', self.model)
        
myCar = Car(0, 'blue', 'E-Class')

myCar.output()
myCar.drive(30)
myCar.output()
print('-' * 20)

