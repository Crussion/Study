from flask import Flask
# 딕셔너리를 json응답으로 변환해주는 함수
from flask import jsonify
# 클라이언트로부터 전달된 데이터를 처리하는 객체
from flask import request

app = Flask(__name__)

# 서버 리소스
resource = []

@app.route('/user/<int:user_id>', methods=['GET'])
def get_user(user_id):
    for user in resource:
        if user['user_id'] is user_id:
            return jsonify(user)
    return jsonify(None)

@app.route('/user', methods=['POST'])
def add_user():
    # POST 방식으로 HTML <form> 데이터가 전달되었을 때
    user = {}
    user['user_id'] = int(request.form['user_id'])
    user['name'] = request.form['name']
    user['age'] = int(request.form['age'])
    print(user)
    
    resource.append(user)
    return jsonify(resource)

if __name__ == '__main__':
    app.run()