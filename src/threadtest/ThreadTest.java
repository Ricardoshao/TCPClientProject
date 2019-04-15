package threadtest;

public class ThreadTest implements Runnable {




    @Override
    public void run(){
    //    for (int j=0; j<10; j++){
            synchronized (Util.arr){
                Util.arr[0] = Util.arr[0]+"1111";
                System.out.println(Thread.currentThread().getName() + "     " + Util.arr[0]);
                int i=Util.map.get("1");
                Util.map.put("1", ++i);
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"     "+Util.map.get("1"));

            }

            try {
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }
     //   }

    }
}
