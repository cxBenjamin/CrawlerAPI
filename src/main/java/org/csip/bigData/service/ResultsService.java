package org.csip.bigData.service;

import org.csip.bigData.dao.MongoDAO;
import org.csip.bigData.entity.Article;
import org.csip.bigData.entity.Results;
import org.csip.bigData.exception.ResultsException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;

//ArrayList<String> imgList=new ArrayList<>( );
//        imgList.add("1");
//        imgList.add("2");
//new Articles2("1","1","1","1","1","1","1","1","1","1","1",imgList,"1","1")
@Path("articles")
public class ResultsService {
    private Results results =null;
    private  ResultsException resultsException=null;
    private StringBuilder sb=null;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Results query(@QueryParam("dateBegin") String dateBegin, @QueryParam("dateEnd") String dateEnd) throws ParseException {
        //System.out.println("data=================================");

//        System.out.println("dateb:"+dateBegin);
//        System.out.println("dateE"+dateEnd);
//        System.out.println("--------------------");
//        String start=dateBegin+" 00:00:00";
//        String end=dateEnd+" 00:00:00";
        resultsException=new ResultsException();
        resultsException.HandleDateException(dateBegin,dateEnd);
        //System.out.println("_______________________________");
        String startTime=dateBegin.replace("_"," ");
        String endTime=dateEnd.replace("_"," ");
//        System.out.println("mongostart");
//        System.out.println(startTime);
//        System.out.println(endTime);
        System.out.println("article ");
        List<Article> articleList =new MongoDAO().queryByPublishDate(startTime,endTime);
        System.out.println("mongo");
//        List<Article> articleList=null;
//        System.out.println("articleList");
        resultsException.HandleArticlesException(articleList);
        System.out.println("handle");
        results =new Results();
        results.setResult(articleList);
        results.setStatus(0);
        results.setErrorMessage("OK");

        return results;
    }
}