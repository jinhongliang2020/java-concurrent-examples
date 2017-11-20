


##Java 并发包相关实例.



sleep 和wait 区别：

1.sleep 是Thread 类的方法 ，wait 是所有Object类方法
2.sleep 不会释放锁，wait 会释放锁，并且会把它加入到Object wait queue
3.使用sleep 不需要在synchronized中，而wait 需要。
4.使用wait 需要主动唤醒（wait(time)除外），而sleep 只需要等待对应休眠时间