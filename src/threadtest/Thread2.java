package threadtest;

public class Thread2 implements Runnable {


    @Override
    public void run(){
        for (int j=0; j<10; j++) {
            Util.arr[1] = Util.arr[1]+"222222222";
            System.out.println(Thread.currentThread().getName() + "     " + Util.arr[1]);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
