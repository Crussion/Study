import socket

port = 5000
address = ('localhost', port)
BUFSIZE = 1024

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect(address)

while True:
    msg = input('Message to send : ')
    sock.send(msg.encode())
    r_msg = sock.recv(BUFSIZE)
    print('[Server]', r_msg.decode())

    if r_msg:
        sock.close()
        break