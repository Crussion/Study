# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 18:08:56 2021

@author: eunse
"""

class Salary:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
        
    def viewInfomation(self):
        print('이름 :', self.name)
        print('월급 :', self.salary)
        
class Department(Salary):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.department = department
        
    def viewInfomation(self):
        print('이름 :', self.name)
        print('월급 :', self.salary)
        print('부서 :', self.department)
        
ob = Department('강호동', 85000000, '개발부')
ob.viewInfomation()