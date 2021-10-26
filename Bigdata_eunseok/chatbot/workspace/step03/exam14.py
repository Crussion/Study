import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # IPv4, TCP 소켓
address = ('localhost', 5000)
sock.bind(address)
sock.listen(5)
print('Waiting for requests...')

while True:
    client, addr = sock.accept()
    print('Connection requested from', addr)
    
    r_msg = client.recv(1024)
    print('[Client]', r_msg.decode())
    
    if r_msg:
        client.send(r_msg)
        client.close()
        sock.close()
        break