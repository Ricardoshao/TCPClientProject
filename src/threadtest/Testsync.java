package threadtest;

public class Testsync {
    public static void main(String[] args){

        Util.map.put("1", 0);
        Util.map.put("2", 0);
        Util.arr[0]="1";
        Util.arr[1]="2";
        new Thread(new ThreadTest()).start();
        try {
            Thread.sleep(10000);
        }catch (Exception e){

        }

        new Thread(new ThreadTest()).start();
    }
}
