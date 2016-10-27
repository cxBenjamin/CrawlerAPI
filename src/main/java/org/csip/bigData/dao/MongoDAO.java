package org.csip.bigData.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.bson.Document;
import org.csip.bigData.entity.Article;
import org.csip.bigData.util.MongoDBConnectUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

/**
 * Created by bun@csip.org.cn on 2016/9/12.
 */
public class MongoDAO {
    private MongoCollection coll=null;
    private Article article=null;
    private MongoCursor<Document> cursor=null;
    private Document document=null;
    private List<Article> articleList=null;
    private ArrayList<String> collections=null;

    private ArrayList<String> getMongoCollections()
    {
        //读取外部的collections文件。不再读取jar内的资源文件
        String filePath=System.getProperty("user.dir")+"/config/collections.txt";
        File keywordFile= FileUtils.getFile(filePath);
        ArrayList<String> mongoCollectionList=new ArrayList<>();
        try {
            LineIterator lineIterator=FileUtils.lineIterator(keywordFile);
            while(lineIterator.hasNext())
            {
                mongoCollectionList.add(lineIterator.nextLine().trim());
//                System.out.println("---------------------collec");
//                System.out.println(lineIterator.nextLine().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mongoCollectionList;
    }

    private String getNotNull(Document d,String key)
    {
        Object o=d.get(key);
        if(o!=null)
        {
            return o.toString();
        }
        //指定为空还是有问题的，具体应该怎么处理还没想明白。
        else
        {
            return "";
        }
    }

    public List<Article> queryByPublishDate(String startDate, String endDate) {
//        System.out.println("queryByPublishDate");
        articleList = new ArrayList<>();
        collections=getMongoCollections();
//        System.out.println("collections size:"+collections.size());

//        String[] colls = {"BjeitGov", "KukaRobot", "MiitGov", "MostGov", "OFweek", "RobotChina", "RobotCn", "RobotCnOrg"};
        //"CriaMei",这个数据库有问题。
        for (int i = 0; i < collections.size(); i++) {
//            System.out.println("i==" + i);
            coll= MongoDBConnectUtil.instance.getCollection(collections.get(i));
            //System.out.println("get collection:"+collections.get(i));
            cursor= coll.find(and(gt("publish_time", startDate), lt("publish_time", endDate))).iterator();
            //System.out.println(cursor.toString());

                while (cursor.hasNext()) {
//                    System.out.println(collections.get(i));
                    article = new Article();
                    document = cursor.tryNext();

                    if(!document.isEmpty()) {

                        article.setAuthor(getNotNull(document,"author"));
                        article.setCategory(getNotNull(document,"category"));
                        article.setContent(getNotNull(document,"content"));
                        article.setCrawler_time(getNotNull(document,"crawler_time"));
                        article.setDigest(getNotNull(document,"digest"));
                        article.setPublish_time(getNotNull(document,"publish_time"));
                        article.setId(getNotNull(document,"id"));
                        article.setTitle(getNotNull(document,"title"));
                        article.setImages(getNotNull(document,"images"));
                        article.setSource_tag(getNotNull(document,"source_tag"));
                        article.setSource_url(getNotNull(document,"source_url"));
                        article.setSource(getNotNull(document,"source"));
                        article.setTag(getNotNull(document,"tag"));
//                        System.out.println("atta begin");
                        article.setAttachments(getNotNull(document,"attachments"));

                        if (article != null) {
                            articleList.add(article);
                        }
                    }
                }

        }
//        System.out.println("article size:"+articleList.size());
//        MongoDBConnectUtil.instance.close();
        return articleList;
    }

}
