from flask import Flask, request, jsonify, abort
import socket
import json

host = 'localhost'
port = 5050

app = Flask(__name__)

# 챗봇 엔진 서버와 통신
def get_anser_from_engine(bottype, query):
    # 챗봇 엔전 서버 연결
    mySocket = socket.socket()
    mySocket.connect((host, port))
    
    # 챗봇 엔진 질의 요청
    json_data = {
            'Query': query,
            'BotType': bottype
        }
    
    # 딕셔너리를 json 문자열로 변환
    message = json.dumps(json_data)
    mySocket.send(message.encode())
    
    # 챗봇 엔진 답변 출력
    data = mySocket.recv(2048).decode()
    
    # json 문자열을 딕셔너리로 변환
    ret_data = json.loads(data)
    
    mySocket.close()
    return ret_data

@app.route('/')
def index():
    print('hello')
    return 'hello'
    
@app.route('/query/<bot_type>', methods=['GET'])
def query(bot_type):
    req_dict = request.args.to_dict()
    # body = {}
    # body['query'] = request.form['query']
    
    try:
        if bot_type == 'TEST':
            print('TEST')
            ret = get_anser_from_engine(bottype=bot_type, query=req_dict['query'])
            print('ret:', ret)
            return jsonify(ret)
        else:
            abort(404)
    except Exception as e:
        print('[Error]', e)
        # 오류발생시 500 오류
        abort(500)
         
if __name__ == '__main__':
    app.run()