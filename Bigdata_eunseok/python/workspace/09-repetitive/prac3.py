while True:
    num = int(input("몇 단을 출력할지 입력하시오 : "))
    
    for i in range(1, 10):  # 1~9
        print("%d * %d = %d" %(num, i, num * i))
    
    cont = input("선택하시오 (y : 계속) : ")
    
    if cont=='y' or cont=='Y':
        continue
    else:
        print('종료')
        break

