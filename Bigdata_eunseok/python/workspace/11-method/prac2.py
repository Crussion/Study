# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 14:46:11 2021

@author: eunse
"""

def grade(avg):
    if avg >= 90 :
        return 'A'
    elif avg >= 80:
        return 'B'
    elif avg >= 70:
        return 'C'
    elif avg >= 60:
        return 'D'
    else:
        return 'F'

kor = int(input("국어 점수 입력 : "))
eng = int(input("영어 정수 입력 : "))

tot = kor + eng
avg = tot / 2

print(grade(avg), "학점입니다.")