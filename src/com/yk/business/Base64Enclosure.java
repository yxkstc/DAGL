package com.yk.business;


import java.io.*;

public class Base64Enclosure {
    public byte[] ObjectToByte(java.lang.Object obj) {
        byte[] bytes = null;
        try {
            //object to bytearray
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
            bo.close();
            oo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (bytes);
    }

    /**
     * 将文件转成字节
     *
     * @param path 文件路径
     * @return *
     * @throws Exception
     */

    public static byte[] encodeByteFile(String path) {
        byte[] buffer=null;
        try {
            File file = new File(path);
            FileInputStream inputFile = new FileInputStream(file);
            if (file.length() > 20971520) {

            } else {
                buffer = new byte[(int) file.length()];
                inputFile.read(buffer);
                inputFile.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 将字节解码保存文件
     *
     * @param byteFile
     * @param targetPath
     * @throws Exception
     */

    public static void decoderByteFile(byte[] byteFile, String targetPath) {
        try {
            FileOutputStream out = new FileOutputStream(targetPath);
            out.write(byteFile);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
