# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 11:45:07 2021

@author: eunse
"""

name = ['홍길동', '김철수', '이영희']
score = [[] for i in range(3)]
print(score)
print('-' * 20)

score[0].append(75)
score[0].append(82)
score[0].append(95)

score[1].append(88)
score[1].append(64)
score[1].append(70)

score[2].append(100)
score[2].append(95)
score[2].append(90)

print(score)
print('-' * 20)

tot = []
for i in range(3):
    tot.append(sum(score[i]))
    
print(tot)
print('-' * 20)

for i in range(3):
    print('%s, 총점=%s, 평균=%.1f' %(name[i], tot[i], tot[i]/3))