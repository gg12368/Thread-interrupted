 通过共享的标记来进行沟通
 
public class ThreadDemo {
    private static class MyRunnable implements Runnable {
        public volatile boolean isQuit = false;
        @Override public void run() { while (!isQuit) {
            System.out.println(Thread.currentThread().getName() + ": 别管我，我忙着转账呢!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": 啊！险些误了大事");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName() + ": 让李四开始转账。");
        thread.start();
        Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName() + ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        target.isQuit = true;
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
李四: 啊！险些误了大事
