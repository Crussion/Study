import tensorflow.compat.v1 as tf

tf.disable_eager_execution() # tf v2에서 tf v1을 사용하기 위한 설정

input1 = tf.placeholder(tf.float32)
input2 = tf.placeholder(tf.float32)

output = input1 + input2

with tf.Session() as sess:
    print(sess.run(output, feed_dict={input1: [7.0, 8.0], input2: [2.0, 3.0]}))