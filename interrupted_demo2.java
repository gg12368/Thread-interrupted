class MyThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<100000;i++){
            System.out.println("i="+(i+1));
        }
    }
}
public class Demo2{
    public static void main(String[] args) {
        try {
            MyThread mythread=new MyThread8();
            mythread.start();
            Thread.sleep(100);
           	Thread.currentThread().interrupt();
            System.out.println("是否停止1？："+Thread.interrupted());
            System.out.println("是否停止2？："+Thread.interrupted());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

运行结果：
是否停止1？：true
是否停止2？：flase

解释：这里main线程具有中断效果。
调用Thread.currentThread().interrupt();，然后这里判断mythread所代表的线程是否停止，
从控制台输出的结果来看，线程已经停止，但是第二个布尔值为false，这是因为interrupt()有清除状态的功能。

注意：
测试代码中使用mythread.interrupt();来判断currentThread()是否被中断，也可以使用代码Thread.interrupted()判断，这是因为在Thread.java类中调用静态方法时，大多数数是针对currentThread()线程来操作的。
