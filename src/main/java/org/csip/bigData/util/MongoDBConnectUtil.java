package org.csip.bigData.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;

import java.util.Arrays;

/**
 * Created by bun@csip.org.cn on 2016/9/12.
 */
public enum MongoDBConnectUtil {
    instance;
    private MongoClient mongoClient;
    private static String ip=ParamsConfigurationUtil.instance.getParamString("mongodb.host");
//    private static String ip="172.16.21.165";
    private static int port=ParamsConfigurationUtil.instance.getParamInteger("mongodb.port");
    private static String userName=ParamsConfigurationUtil.instance.getParamString("mongodb.userName");
    private static  String password=ParamsConfigurationUtil.instance.getParamString("mongodb.passwd");
    private static  String database=ParamsConfigurationUtil.instance.getParamString("mongodb.database");
    static {
        System.out.println("ip:"+ip);
        System.out.println("userName:"+userName);
        System.out.println("dataBase:"+database);
        System.out.println("passwd:"+password);
        MongoCredential credential = MongoCredential.createCredential(userName, database, password.toCharArray());
        instance.mongoClient = new MongoClient(new ServerAddress(ip, port), Arrays.asList(credential));
//        instance.mongoClient = new MongoClient(new ServerAddress(ip, port));
//        System.out.println("connect ok");
//        MongoClientOptions.Builder options = new MongoClientOptions.Builder();
//        options.connectionsPerHost(300);// 连接池设置为300个连接,默认为100
//        options.connectTimeout(15000);// 连接超时，推荐>3000毫秒
//        options.maxWaitTime(5000); //
//        options.socketTimeout(0);// 套接字超时时间，0无限制
//        options.threadsAllowedToBlockForConnectionMultiplier(5000);// 线程队列数，如果连接线程排满了队列就会抛出“Out of semaphores to get db”错误。
//        options.writeConcern(WriteConcern.SAFE);//
//        options.build();

    }

    public MongoCollection getCollection(String collectionName)
    {
        return mongoClient.getDatabase(database).getCollection(collectionName);
    }
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
