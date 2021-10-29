import socket
import json
import sys

host = 'localhost'
port = 5050

while True:
    query = input('질문 (종료: exit): ')
    if query == 'exit':
        sys.exit()
        
    mySocket = socket.socket()
    mySocket.connect((host, port))
    
    json_data = {
            'Query': query,
            'BotType': 'MyService'
        }
    
    message = json.dumps(json_data)
    
    mySocket.send(message.encode())
    
    data = mySocket.recv(2048).decode()
    
    ret_data = json.loads(data)