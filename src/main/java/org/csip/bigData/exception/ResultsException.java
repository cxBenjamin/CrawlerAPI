package org.csip.bigData.exception;

import org.csip.bigData.entity.Article;
import org.csip.bigData.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by bun@csip.org.cn on 2016/9/16.
 */
public class ResultsException {

    public void HandleDateException(String firstDate, String secondDate) {
        Date startDate = null;
        Date endDate = null;
        DateUtil dateUtil = new DateUtil();
        if (dateUtil.isValidDate(firstDate) && dateUtil.isValidDate(secondDate)) {
            try {
                startDate = dateUtil.validDate(firstDate);
                System.out.println(startDate);
                endDate = dateUtil.validDate(secondDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else {
            throw new DateException("Error,wrong date format!");
        }


        Date currentDate = new Date();
        if (startDate.after(currentDate) || endDate.after(currentDate)) {
            throw new DateException("Error,ether first date or second date is after current date!");
        }
        if (startDate.after(endDate)) {
            throw new DateException("Error,first date is after second date!");

        }
    }

    public void HandleArticlesException(List<Article> articleList)
    {

        if(articleList.size()==0)
        {
            throw new ArticlesException("Data not found!");
        }
    }
}
