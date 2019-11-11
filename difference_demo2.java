public class ThreadDemo {
	private static class MyRunnable implements Runnable {
        @Override public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.interrupted());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        thread.start(); thread.interrupt();
    }
}



运行结果：
true
false
false
false
false
false
false
false
false
false



