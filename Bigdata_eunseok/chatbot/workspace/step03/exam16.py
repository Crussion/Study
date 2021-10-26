import json

json_string = '''{
    "id": 1,
    "username": "홍길동",
    "address" : {
        "street": "강남대로",
        "suite": "Apt.556",
        "city": "서울특별시",
        "zipcode": "12345"
    },
    "admin": false,
    "hobbies": null
}'''

print(json_string)
print('=' * 40)

# 문자열을 json 딕셔너리로 전환
json_dict = json.loads(json_string)
print(json_dict)
print('=' * 40)

json_dict2 = {'id': 1, 
              'username': '홍길동', 
              'email': 'hong@april.biz',
              'address': {'street': '강남대로', 
                          'suite': 'Apt.556', 
                          'city': '서울특별시', 
                          'zipcode': '12345'}, 
              'admin': False, 
              'hobbies': None}

print(json_dict2)
print('=' * 40)

# 딕셔너리를 json 문자열로 전환
json_string2 = json.dumps(json_dict2, indent=4)
print(json_string2)
print('=' * 40)

# 딕셔너리를 json 파일로 저장
with open('data.json', 'w') as f:
    json.dump(json_dict2, f, indent=4)
    
print('=' * 40)

# json 파일을 익어와 딕셔너리로 리턴
with open('data.json', 'r') as f:
    json_dict = json.load(f)
    
print(json_dict)
print('=' * 40)