from tensorflow.keras.datasets import mnist
import matplotlib.pyplot as plt

width = 28
height = 28

(x_train, y_train), (x_test, y_test) = mnist.load_data()

# Dense 사용
x_train = x_train.reshape(60000, width * height).astype('float32') / 255
x_test = x_test.reshape(10000, width * height).astype('float32') / 255

'''
# Conv2D 사용
x_train = x_train.reshape(60000, width, height, 1).astype('float32') / 255
x_test = x_test.reshape(10000, width, height, 1).astype('float32') / 255
'''

x_val = x_train[50000:]
y_val = y_train[50000:]
x_train = x_train[:50000]
y_train = y_train[:50000]

y_train = y_train % 2
y_val = y_val % 2
y_test = y_test % 2

plt.rcParams['figure.figsize'] = (12, 12)
fig, axarr = plt.subplots(5, 5)

for i in range(25) :
    sub_plt = axarr[i//5, i%5]
    sub_plt.axis('off')
    sub_plt.imshow(x_train[i].reshape(width, height))
    
    sub_plt_title = 'R: '
    
    if y_train[i]:
        sub_plt_title += 'odd'
    else:
        sub_plt_title += 'even'
        
    sub_plt.set_title(sub_plt_title)
    
plt.show()