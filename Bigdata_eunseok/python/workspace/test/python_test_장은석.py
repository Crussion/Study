emp_lst = []

def menu():
    c = int(input('    1. 등록\
                 \n    2. 출력\
                 \n    3. 종료\
                 \n----------------\
                 \n    번호 : '))
    return c

def input_emp():
    if len(emp_lst) < 20:
        emp_data = {}
        emp_data['이름'] = input("이름 : ")
        emp_data['직급'] = input("직급 : ")
        emp_data['기본급'] = int(input("기본급 : "))
        emp_data['수당'] = int(input("수당 : "))
        salary = emp_data['기본급'] + emp_data['수당']
        if salary <= 2000000:
            emp_data['세율'] = 0.01
        elif salary <= 4000000:
            emp_data['세율'] = 0.02
        else:
            emp_data['세율'] = 0.03
        emp_data['월급'] = salary - salary * emp_data['세율']
        emp_lst.append(emp_data)
    else:
        print('입력가능한 사원 수를 초과 하였습니다.')
    
def output_emp():
    print("이름       직급        기본급         수당        세율        월급")
    for lst in emp_lst:
        print('{: <8}{: <8}{: 8}{: 12}{: 12}{: 12}'.format(\
                lst['이름'], lst['직급'], lst['기본급'], lst['수당'], lst['세율'], lst['월급']))
        

while True:
    c = menu()
    if c == 1:
        input_emp()
    elif c == 2:
        output_emp()
    elif c == 3:
        print("프로그램을 종료합니다.")
        break
    else:
        print("잘못된 입력 입니다.")
        