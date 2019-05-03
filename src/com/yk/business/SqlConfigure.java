package com.yk.business;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class SqlConfigure {
    /*
     * Properties类中的setProtertity()方法
     */
    public static void setGetProperties(String IP, String Port, String DataBase, String Login, String PassWord) throws IOException {
        Properties p = new Properties();
        FileWriter fw;

        p.setProperty("IP", IP);//设定Properties类中存放的键值对
        p.setProperty("Port", Port);
        p.setProperty("DataBase", DataBase);
        p.setProperty("Login", Login);
        p.setProperty("PassWord", PassWord);

        fw = new FileWriter("lib/SqlConfigure.properties");
        p.store(fw, "DataBase connection");//将Properties中的信息存储到文件中
    }

    /*
     * Properties类中的getProtertity()
     */
    public static Properties getGetProperties() throws IOException {
        Properties p = new Properties();
        FileReader fr;
        fr = new FileReader("lib/SqlConfigure.properties");
        p.load(fr);//load()方法可通过字符流直接加载文件
        return p;
    }

}
