class MyThread8 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<100000;i++){
            System.out.println("i="+(i+1));
        }
    }
}
public class Demo1 {
    public static void main(String[] args) {
        try {
            MyThread mythread=new MyThread8();
            mythread.start();
            Thread.sleep(100);
           	Thread.currentThread().interrupt();
            System.out.println("是否停止1？："+Thread.isInterrupted());
            System.out.println("是否停止2？："+Thread.isInterrupted());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

注意：
public boolean isInterrupted();
从声明中可以看出isInterrupted()方法不是静态方法，作用于调用这个方法的对象。



运行结果：
是否停止1？：true
是否停止2？：true
解释：
从运行结果可以看出，两个结果都为true。并无清除状态的功能。


综上所述，两个方法的区别如下：
1>interrupted()：测试当前线程是否为中断状态，执行后具有清除状态标志值为false的功能。
2>isInterrupted()：测试线程Thread对象是否已经中断，不清除状态标志。
