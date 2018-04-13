package com.halsey.netty.mutilthread;

import java.util.concurrent.locks.StampedLock;

/**
 * create by zhangyaohai
 * 2018-03-26 14:30
 **/
public class StampedLockDemo {
    private StampedLock  stampedLock = new StampedLock();

    public static void main(String[] args) {

    }
    //写排他锁
    public void puls(){
        int x = 1,y = 3;
        long temp =  stampedLock.writeLock();
        int z = x + y ;
        stampedLock.unlockWrite(temp);
    }

    //读锁
    public void dis(){
        long temp = stampedLock.tryOptimisticRead();
        if(stampedLock.validate(temp)){
            long stemp = stampedLock.readLock();

            try{

            }catch (Exception e){
                stampedLock.unlockRead(stemp);
            }
        }
    }

    //读写锁转换
    public void move() {
        long stemp = stampedLock.readLock();
        try {
            while (true) {
                long ws = stampedLock.tryConvertToWriteLock(stemp);
                if (ws != 0L) {
                    stemp = ws;
                    //执行
                    break;
                } else {
                    stampedLock.unlockRead(stemp);
                    stemp = stampedLock.writeLock();
                }
            }
        } catch (Exception e) {
            stampedLock.unlockWrite(stemp);
        }
    }
}
