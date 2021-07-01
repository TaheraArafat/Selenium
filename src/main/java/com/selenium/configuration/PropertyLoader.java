package com.selenium.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
   public static void loadProperties() throws IOException {
       load("./properties/test.properties");
       if(null == System.getProperty("browser.name")) {
           load(("./properties/browser/" + System.getProperty("browser.default") + ".properties"));
       } else{
           load("./properties/browser/" + System.getProperty("browser.name"));
       }
       load("./properties/user/user.properties");
       load(("./properties/payment/payment.properties"));
       load(("./properties/product/product.properties"));
       load(("./properties/env/env.properties"));

   }

    public static void load(final String propertyPath) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(propertyPath)));
        for (String key : properties.stringPropertyNames()) {
            System.setProperty(key, properties.getProperty(key));
        }
    }

    public static String getValue(final String key){
        return System.getProperty(key);
    }
}
