package client;

import threadtest.BeanTest;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Synctestclient {
    public static void main(String[] args) {

        Socket socket = null;

    //    InputStream is = null;

   //     OutputStream os = null;
        ObjectOutputStream os =null;
        ObjectInputStream is = null;
        List<String> localnetList = new ArrayList<>();

        //服务器端IP地址

     //   String serverIP = "39.105.114.132";

        String serverIP = "127.0.0.1";
        //服务器端端口号

        int port = 7073;

        byte[] recvarray = new byte[1024];
        int len = 0;
        String temp = null;
        localnetList.add("1");
        localnetList.add("2");
        localnetList.add("3");
        localnetList.add("4");

        try {

            //建立连接

            socket = new Socket(serverIP,port);

       //     is = socket.getInputStream();
       //     os = socket.getOutputStream();
            is=new ObjectInputStream(socket.getInputStream());
            os=new ObjectOutputStream(socket.getOutputStream());
            for (int i=1;i<3;i++){
                os.writeObject(new BeanTest("ddd",i));
                os.flush();
            }
     //       os.write("switch".getBytes());
            os.writeObject(localnetList);
            os.flush();
            len = is.read(recvarray);
            temp = new String(recvarray, 0, len);
   /*         System.out.println(temp);
            for(int i=0; i<localnetList.size(); i++){
                os.write(localnetList.get(i).getBytes());
                System.out.println(localnetList.get(i));
                os.flush();
            }
            */

            len = is.read(recvarray);
            temp = new String(recvarray, 0, len);
            System.out.println(temp);



        } catch (Exception e) {

        e.printStackTrace(); //打印异常信息

         }finally{

            try {

            //关闭流和连接

            is.close();

            os.close();

            socket.close();

             } catch (Exception e2) {}

    }

}
}
