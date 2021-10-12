import tensorflow.compat.v1 as tf

tf.disable_eager_execution() # tf v2에서 tf v1을 사용하기 위한 설정

matrix1 = tf.constant([[3, 3]])
matrix2 = tf.constant([[2], [2]])

product1 = tf.matmul(matrix1, matrix2)
print(product1)
print('-' * 40)

product2 = tf.matmul(matrix2, matrix1)
print(product1)
print('-' * 40)

sess = tf.Session()
data1 = sess.run(product1)
print(data1)
print('-' * 40)

sess = tf.Session()
data2 = sess.run(product1)
print(data2)
print('-' * 40)