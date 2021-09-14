# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 12:56:32 2021

@author: eunse
"""

score_list = []
rank_list = []
for i in range(5):
    score = int(input("%d번 학생의 점수를 입력 : " %(i+1)))
    score_list.append(score)
    rank_list.append(1)

'''
sort_list = sorted(score_list, reverse=True)

for i in range(5):
    n = score_list.index(sort_list[i])
    rank_list[n] = i + 1
    
print("*** 결과 ***")
for i in range(5):
    print("%d점 : %d등" %(score_list[i], rank_list[i]))
'''
    


for i in range(len(score_list)):
    for j in range(5):
        if(i != j):
            if(score_list[i] <= score_list[j]):
                rank_list[i] += 1
                
print("*** 결과 ***")
for i in range(5):
    print("%d점 : %d등" %(score_list[i], rank_list[i]))