package org.csip.bigData.util;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by bun@csip.org.cn on 2016/9/12.
 */
public enum ParamsConfigurationUtil {
    instance;
    private  CompositeConfiguration config;
    static {
        instance.config=new CompositeConfiguration();
        //外部读取配置文件的方法
        try {
            String filePath=System.getProperty("user.dir")+"/config/params.properties";
            instance.config.addConfiguration(new PropertiesConfiguration(filePath));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
    public String getParamString(String param){

//        String host=
        return instance.config.getString(param);
    }

    public int getParamInteger(String param){

        return instance.config.getInt(param);

    }


}
