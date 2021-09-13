# -*- coding: utf-8 -*-
"""
Created on Mon Sep 13 13:56:59 2021

@author: eunse
"""

kor = int(input("국어 점수 입력: "))
eng = int(input("영어 점수 입력: "))
tot =  kor + eng
avg = (kor + eng) / 2

print("총점 = ", kor + eng)
print("평균 = ", (kor + eng) / 2)
if(avg >= 90):
    print("학점 = A")
elif(avg >= 80):
    print("학점 = B")
elif(avg >= 70):
    print("학점 = C")
elif(avg >= 60):
    print("학점 = D")
else:
    print("학점 = F")