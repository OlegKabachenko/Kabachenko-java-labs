package edu.ntudp.pzks.lab6.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();
    private static final String PATH = "src/main/java/edu/ntudp/pzks/lab6/resources/database.properties";

    static {
        loadProperties();
    }

    private PropertiesUtil(){
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties(){
        try(InputStream resourceAsStream = new FileInputStream(PATH)){
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
