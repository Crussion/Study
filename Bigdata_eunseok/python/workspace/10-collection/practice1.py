# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 12:02:17 2021

@author: eunse
"""

stu_list = []
for i in range(5):
    score = int(input("%d번 학생의 점수를 입력 : " %(i+1)))
    stu_list.append(score)

print("총점 :", sum(stu_list), "평균 :", sum(stu_list)/len(stu_list))