import numpy as np
import matplotlib.pyplot as plt

width = 16
height = 16

def generate_dataset(samples):
    ds_x = []
    ds_y = []
    
    for i in range(samples):
        point_num = np.random.randint(0, width * height)
        img = generate_image(point_num)
        ds_x.append(img)
        ds_y.append(point_num)
    
    x_train = np.array(ds_x)
    y_train = np.array(ds_y).reshape(samples, 1)
    return x_train, y_train
        
def generate_image(point_num):
    img = np.zeros((width, height))
    points = np.random.random((point_num, 2))
    
    for point in points:
        img[int(point[0] * width), int(point[1] * height)] = 1
        
    return img.reshape(width, height, 1)

img = generate_image(3)

plt.imshow(img.reshape(width, height))
plt.show()

x_train, y_train = generate_dataset(10)

print(x_train.shape)
print(y_train.shape)
print(x_train[0])

plt.imshow(x_train[0])
plt.show()