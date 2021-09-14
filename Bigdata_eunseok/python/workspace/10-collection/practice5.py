# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 17:00:04 2021

@author: eunse
"""

student = {}
student['이름'] = input('이름 입력 : ')
student['국어'] = int(input('국어 점수 : '))
student['영어'] = int(input('영어 점수 : '))
student['수학'] = int(input('수학 점수 : '))
student['총점'] = student['국어'] + student['영어'] + student['수학']
student['평균'] = student['총점'] / 3

print(student)