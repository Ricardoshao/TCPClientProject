package threadtest;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class RWFile {



    /***
     * 替换指定文件中的指定内容
     * @param filepath  文件路径
     * @param map key文件需要被替换的内容,value为替换后的内容
     * @return 替换成功返回true，否则返回false
     */

    public boolean replaceFileStr(String filepath, Map<String, String> map) {
        try {
            FileReader fis = new FileReader(filepath);  // 创建文件输入流
            BufferedReader br = new BufferedReader(fis);
            char[] data = new char[1024];               // 创建缓冲字符数组
            int rn = 0;
            StringBuilder sb = new StringBuilder();       // 创建字符串构建器
            //fis.read(data)：将字符读入数组。在某个输入可用、发生 I/O 错误或者已到达流的末尾前，此方法一直阻塞。读取的字符数，如果已到达流的末尾，则返回 -1
            while ((rn = fis.read(data)) > 0) {// 读取文件内容到字符串构建器
                String str = String.valueOf(data, 0, rn);//把数组转换成字符串
                System.out.println(str);
                sb.append(str);
            }
            fis.close();// 关闭输入流
            // 从构建器中生成字符串，并替换搜索文本
            String str = sb.toString();
            for(String temp : map.keySet()){
                str.replace(temp, map.get(temp));
            }

            FileWriter fout = new FileWriter(filepath);// 创建文件输出流
            fout.write(str.toCharArray());// 把替换完成的字符串写入文件内
            fout.close();// 关闭输出流
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /*
    @param filePath 文件路径
    @return  返回list，每个元素是文件里的一行
     */
    public List<String> readFile(String filePath){
        //     String filePath = "/home/mutimapping/test.conf";
        File file = new File(filePath);
        File fileParent = file.getParentFile();
        List<String> list = new ArrayList<>();

        fileParentExist(fileParent);
        fileExist(file);

        try{
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String temp = "";
            while ((temp = br.readLine()) != null){
                list.add(temp.trim());
            }

            br.close();
            isr.close();
            fis.close();
        }catch (IOException e){
            System.out.println("config file has problem");
        }


        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        return list;




    }


    /*
    @param filePath 文件路径
    @param  list 写入文件的内容，每个元素是文件里的一行
 */
    public void writeFile(String filePath, List<String> list){
        // String filePath = "/home/mutimapping/test.conf";
        File file = new File(filePath);
        File fileParent = file.getParentFile();
        fileParentExist(fileParent);
        fileExist(file);

        try {
            FileWriter fw= new FileWriter (file, true);
            BufferedWriter bw= new BufferedWriter(fw);
            for(int i=0; i<list.size(); i++){
                bw.write(list.get(i));
                bw.newLine();
            }
            //   bw.write("192.168.0.11");
            //  bw.newLine();
            //  bw.write("192.168.0.12");
            bw.flush();
            bw.close();
            fw.close();

        }catch (IOException e){
            System.out.println("Write config file error");
        }
    }

    /*
@param filePath 文件路径
@param  list 写入文件的内容，每个元素是文件里的一行
*/
    public void coverWriteFile(String filePath, List<String> list){
        // String filePath = "/home/mutimapping/test.conf";
        File file = new File(filePath);
        File fileParent = file.getParentFile();
        fileParentExist(fileParent);
        fileExist(file);

        try {
            FileWriter fw= new FileWriter (file, false);
            BufferedWriter bw= new BufferedWriter(fw);
            for(int i=0; i<list.size(); i++){
                bw.write(list.get(i));
                bw.newLine();
            }
            //   bw.write("192.168.0.11");
            //  bw.newLine();
            //  bw.write("192.168.0.12");
            bw.flush();
            bw.close();
            fw.close();

        }catch (IOException e){
            System.out.println("Write config file error");
        }
    }

    public void fileParentExist(File path){
        File fileParent = path;
        if(!fileParent.exists()){
            fileParent.mkdirs();
        }

    }

    public void fileExist(File file){
        File file1 = file;
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                System.out.println("cerate configfile error");
            }
        }
    }
}

public class ttt1 {
    public static void main(String[] args){

        RWFile rwFile = new RWFile();
        List<String> list = new ArrayList<>();
      //  list.add("123");
        rwFile.writeFile("/etc/network/interfaces", list);

    }
}
