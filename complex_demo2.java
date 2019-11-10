调用 interrupt() 方法来通知

public class ThreadDemo {
	private static class MyRunnable implements Runnable {
        @Override public void run() {
            // 两种方法均可以
            while (!Thread.interrupted()) {
            // while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + ": 别管我，我忙着转账呢!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + ": 有内鬼，终止交易！");
                break;
            }

    }
    System.out.println(Thread.currentThread().getName() + ": 啊！险些误了大事");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName() + ": 让李四开始转账。");
        thread.start(); Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName() + ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        thread.interrupt();
    }
}

运行结果：
main: 让李四开始转账。
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
李四: 别管我，我忙着转账呢!
main: 老板来电话了，得赶紧通知李四对方是个骗子！
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep(Native Method)
	at interrupted.ThreadDemo$MyRunnable.run(ThreadDemo.java:36)
	at java.base/java.lang.Thread.run(Thread.java:835)
李四: 有内鬼，终止交易！
李四: 啊！险些误了大事
