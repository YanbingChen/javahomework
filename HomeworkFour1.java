package vanilla.demo;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;


public class HomeworkFour1 {
    public static void main(String args[]) throws Exception {
        //文件路径设置了一个我电脑上的路径，检验过几次运行hash值不会变
        String filepath="E:\\零碎艺术\\伴奏";
        //创造一个CalcDirHash的对象，通过构造函数，此时已经完成了哈希值计算
        CalcDirHash calculate = new CalcDirHash(filepath);
        //打印出最终的哈希值
        System.out.println(calculate.getHashString());
    }
}

class CalcDirHash{
    //一个计算只用到一个MessageDigest对象，也只有一个最终的哈希值
    private MessageDigest complete;
    private byte[] hash;

    //在构造函数中对成员变量初始化，并且对该文件夹路径下文件进行遍历，遍历方法中同时完成了哈希值计算，这个时候得到的哈希值就是最终结果
    public CalcDirHash(String filepath){
        //使用SHA1哈希/摘要算法
        try{
            complete = MessageDigest.getInstance("SHA-1");
            dfs(filepath);
        } catch (Exception e){
            e.printStackTrace();
        }
        hash = complete.digest();
    }

    public byte[] getHash() {
        return hash;
    }

    //遍历文件夹
    public void dfs(String path) throws Exception {
        File dir = new File(path);
        File[] fs = dir.listFiles();
        //对listFiles()的结果进行排序
        SortbyFilesize(fs);
        //依次把文件内容取出，并更新hash值，遇到文件就直接算hash值，遇到文件夹就继续找其中的文件
        for (int i = 0; i< fs.length; i++){
            if(fs[i].isFile()){
                addFiletoHash(fs[i]);
            }
            if(fs[i].isDirectory()){
                dfs(path + File.separator + fs[i].getName());
            }
        }
    }
    //用自带的compareTo排序
    public void SortbyFilesize(File [] fs){
        File temp;
        for (int i = 0; i < fs.length -1; i++) {
            for (int j = 0; j < fs.length - i -1; j++) {
                if (fs[j].compareTo(fs[j + 1])>0) {
                    temp = fs[j];
                    fs[j] = fs[j + 1];
                    fs[j + 1] = temp;
                }
            }
        }
    }
    //计算单个文件哈希值，直接update进总的哈希值
    public void addFiletoHash(File f) throws Exception{
        try {
            FileInputStream is = new FileInputStream(f);
            //用于计算hash值的文件缓冲区
            byte[] buffer = new byte[1024];
            int numRead = 0;
            do {
                //读出numRead字节到buffer中
                numRead = is.read(buffer);
                if (numRead > 0) {
                    //根据buffer[0:numRead]的内容更新总的hash值
                    complete.update(buffer, 0, numRead);
                }
                //文件已读完，退出循环
            } while (numRead != -1);
            //关闭输入流
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //打印哈希值的方法
    public String getHashString(){
        String result = "";
        for (int i = 0; i < hash.length; i++) {
            result += Integer.toString(hash[i] &0xFF, 16);
        }
        return result;
    }

}