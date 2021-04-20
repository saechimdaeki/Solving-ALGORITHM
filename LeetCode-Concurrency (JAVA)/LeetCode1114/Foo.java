package LeetCode_Concurrency1114;

// Discussion 풀이.
//class Foo {
//
//    private boolean one;
//    private boolean two;
//    private boolean three;
//
//    public Foo() {
//
//    }
//
//    public synchronized void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        one=true;
//        notifyAll();
//
//    }
//
//    public synchronized void second(Runnable printSecond) throws InterruptedException {
//        while (!one){
//            wait();
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        two=true;
//        notifyAll();
//    }
//
//    public synchronized void third(Runnable printThird) throws InterruptedException {
//
//        while (!two){
//            wait();
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}

import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore two=new Semaphore(0);
    private Semaphore three=new Semaphore(0);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}