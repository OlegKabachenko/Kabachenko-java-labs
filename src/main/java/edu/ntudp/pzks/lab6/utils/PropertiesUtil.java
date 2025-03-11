package edu.ntudp.pzks.lab6.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private final Properties PROPERTIES = new Properties();
    private final String PATH = "src/main/java/edu/ntudp/pzks/lab6/resources/database.properties";

    public PropertiesUtil(){
        loadProperties();
    }

    public String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private void loadProperties(){
        try(InputStream resourceAsStream = new FileInputStream(PATH)){
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
