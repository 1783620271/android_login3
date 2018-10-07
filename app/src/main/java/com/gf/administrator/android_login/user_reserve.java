package com.gf.administrator.android_login;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class  user_reserve {
    public  static  boolean reserve(String name,String pwd){
        try {
            String result=name+"##"+pwd;
            //指定文件的存放位置
            String sd_path=Environment.getExternalStorageDirectory().getPath();
            File file=new File(sd_path,"info.txt");
            //文件的输出流
            FileOutputStream out=new FileOutputStream(file);
            //存放的数据
            out.write(result.getBytes());
            //关闭流
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static Map<String,String> info() {
        try {
            Map<String,String> map=new HashMap<String, String>();
            String sd_path=Environment.getExternalStorageDirectory().getPath();
            File file=new File(sd_path,"info.txt");
            FileInputStream input=new FileInputStream(file);
            BufferedReader buffer=new BufferedReader(new InputStreamReader(input));
            String value=buffer.readLine();
            String[] split = value.split("##");
            String name=split[0];
            String pwd=split[1];
            map.put("name",name);
            map.put("pwd",pwd);
            input.close();
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
