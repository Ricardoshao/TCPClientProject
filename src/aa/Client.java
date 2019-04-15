package aa;



import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        ObjectInputStream objInputStream = null;
        ObjectOutputStream objOutputStream = null;
        InputStream is = null;
        OutputStream os = null;
        byte[] recvarray = new byte[1024];
        String temp = null;
        int len = 0;
        Socket socket =null;
        List<String> localnetList = new ArrayList<>();

        try {
            socket = new Socket("127.0.0.1",7073);
            is = socket.getInputStream();
            os = socket.getOutputStream();

            localnetList.add("1");
            localnetList.add("2");
            localnetList.add("3");
            localnetList.add("4");
            os.write("switchup".getBytes());
            os.flush();
            len = is.read(recvarray);
            temp = new String(recvarray, 0, len);
            if("ack".equals(temp)){

              /*  for (int i=0;i<4;i++){
                    os.write(localnetList.get(i).getBytes());
                    os.flush();
                }*/
                os.write(localnetList.get(0).getBytes());
                os.flush();
                len = is.read(recvarray);
                temp = new String(recvarray, 0, len);

                    os.write(localnetList.get(1).getBytes());
                    os.flush();
                len = is.read(recvarray);
                temp = new String(recvarray, 0, len);


                os.write(localnetList.get(2).getBytes());
                os.flush();
                len = is.read(recvarray);
                temp = new String(recvarray, 0, len);

                os.write(localnetList.get(3).getBytes());
                os.flush();


                len = is.read(recvarray);
                temp = new String(recvarray, 0, len);
               if("config".equals(temp)){
                /*    for(int i=0;i<4;i++){
                        len = is.read(recvarray);
                        temp = new String(recvarray, 0, len);
                        localnetList.add(temp);
                    }*/
                       len = is.read(recvarray);
                        temp = new String(recvarray, 0, len);
                        localnetList.add(temp);
                        os.write("a".getBytes());

                    len = is.read(recvarray);
                    temp = new String(recvarray, 0, len);
                    localnetList.add(temp);


                    os.write("success".getBytes());
                    os.flush();
                }

            }





        }catch (Exception e){

        }finally {
            try {
                is.close();
                os.close();
                socket.close();
            }catch (Exception e){

            }

        }

    }
}
