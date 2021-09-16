# -*- coding: utf-8 -*-
"""
Created on Wed Sep 15 14:57:19 2021

@author: eunse
"""
student_list = []

def menu():
    return input('성적 관리 프로그램\
              \n-------------------\
              \n1. 입력\
              \n2. 출력\
              \n3. 종료\
              \n-------------------\
              \n번호 : ')

def input_jumsu(list):
    student_data = {}
    student_data['이름'] = input("이름 : ")
    student_data['국어'] = int(input("국어 : "))
    student_data['영어'] = int(input("영어 : "))
    student_data['수학'] = int(input("수학 : "))
    student_data['총점'] = student_data['국어'] + student_data['영어'] + student_data['수학']
    student_data['평균'] = student_data['총점'] / 3
    list.append(student_data)
    
def output_jumsu(list):
    for i in list:
        print(i)
        
while True:
    c = menu()
    if c == '1':
        input_jumsu(student_list)
    elif c == '2':
        output_jumsu(student_list)
    elif c == '3':
        break