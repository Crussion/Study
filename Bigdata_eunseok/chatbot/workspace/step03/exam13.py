import socket

print(socket.gethostbyname('www.naver.com'))
print('-' * 40)

print(socket.gethostname())
print('-' * 40)

print(socket.gethostbyname(socket.gethostname()))
print('-' * 40)