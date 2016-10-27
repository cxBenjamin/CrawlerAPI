package org.csip.bigData.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.csip.bigData.util.MongoDBConnectUtil;
import org.junit.Test;

/**
 * Created by bun@csip.org.cn on 2016/9/12.
 */
public class MongoDBConnectUtilTest {
    @Test
    public void getCollecttionTest()
    {
        String collName="OFweek";
        MongoCollection<Document> coll = MongoDBConnectUtil.instance.getCollection(collName);
        String startTime="2016-08-29 00:00:00";
        String endTime="2016-09-09 00:00:00";
        MongoCursor<Document> cursor = coll.find().iterator();
        System.out.println("jao;jfios");
        while(cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
    }
}
