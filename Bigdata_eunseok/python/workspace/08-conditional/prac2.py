kor =  int(input('국어점수 입력: '))
eng =  int(input('영어점수 입력: '))
   
total = kor + eng
avg = total / 2
print('-'*20)
print('-'*20)

print(' 총점 =', total)
print(' 평균 =', avg)

if avg >= 90 :
    print(' 학점 = A ')
elif avg < 90 and avg >=80:
    print(' 학점 = B')
elif avg < 80 and avg >=70:
    print(' 학점 = C')
elif avg < 70 and avg >=60:
    print(' 학점 = D')
else : 
    print(' 학점 = F')
    

