 class MyThread extends Thread{
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
            mythread.interrupt();
            System.out.println("是否停止1？："+mythread.interrupted());
            System.out.println("是否停止2？："+mythread.interrupted());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}



运行结果：
是否停止1？：flase
是否停止2？：flase
解释：
调用mythread.interrupt();，然后这里判断mythread所代表的线程是否停止，
但从控制台输出的结果来看，线程并未停止，这也证明了：interrupted()方法判断当前线程是否已经中断。而当前线程为main线程。
