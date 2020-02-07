package com.ZERO.Tools;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;


    static {


        try {
            String path = "configuration.properties";
            FileInputStream read = new FileInputStream(path);
            properties = new Properties();
            properties.load(read);
            read.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getKey(String KeyName){
       return properties.getProperty(KeyName);
    }
}
