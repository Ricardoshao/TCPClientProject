package client;

import aa.Student;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientSocketClass {

    public static void main(String[] args){
        Socket socket = null;
    //    List<String> localnetList = new ArrayList<>();


        try{
      //      socket = new Socket(InetAddress.getByName("127.0.0.1"),7073);
            socket = new Socket("127.0.0.1",7073);
        //   ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

           for(int i=1;i<3;i++){
                Student student = new Student();
                student.setAge(1);
                student.setName("wjw");
                student.setScore(100);

                oos.writeObject(student);
                os.flush();

           }
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Student student2 = (Student) ois.readObject();
            System.out.println(student2);

            ArrayList<String> list = new ArrayList<>();
            list.add("222");
            list.add("333");
            oos.writeObject(list);
            os.flush();



        }catch(Exception e){
            e.printStackTrace();
        }finally{

            try {
                if(socket != null){
                    socket.close();
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}


