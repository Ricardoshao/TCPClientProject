package threadtest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args){

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println(dateTimeFormat.format(new Date()));
        long time = System.currentTimeMillis();
        System.out.println(time);
        String te = "18.020/19.514/22.904/1.776";
        String[] tearr = te.split("/");
        for (int i=0; i<tearr.length; i++){
            System.out.println(tearr[i]);
        }
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list2.add("ccc");
        list2.add("ddd");

        String str = "abc";
        int x=5;
        str = str+x;
        System.out.println(str);
        Util.SMRinSARmap.put("1", list1);
        Util.SMRinSARmap.put("2", list2);
     //   Util.SMRinSAR.add(list1);
     //   Util.SMRinSAR.add(list2);
     //   for (int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                System.out.println(Util.SMRinSARmap.get("1").get(j));
            }
       // }
        List<String> list3 = new ArrayList<>();
     //   list3.addAll(Util.SMRinSAR.get(0));
        list3 = Util.SMRinSARmap.get("1");
        List<String> list4 = list3;
        list4.remove(0);
        list4.add("efhsf");

     //   for (int i=1; i<3; i++){
            for(int j=0; j<2; j++){
                System.out.println(Util.SMRinSARmap.get("1").get(j));
            }
      //  }
/*        System.out.println(list3.get(0));
        System.out.println(list3.get(1));
        System.out.println(list3.size());
        System.out.println(list4.size());*/




        Util.map.put("1", 0);
        Util.map.put("2", 0);
        Util.arr[0]="1";
        Util.arr[1]="2";

        Thread thread1 = new Thread(new ThreadTest());
        Thread thread2 = new Thread(new ThreadTest());
        Thread thread3 = new Thread(new ThreadTest());
      //  Thread thread4 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
        thread3.start();
      //  thread4.start();

    }
}
