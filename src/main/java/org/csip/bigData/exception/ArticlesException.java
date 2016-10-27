package org.csip.bigData.exception;

import org.csip.bigData.entity.Results;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by bun@csip.org.cn on 2016/9/16.
 */
public class ArticlesException extends WebApplicationException{
    public ArticlesException(String message)
    {
        super(Response.status(Response.Status.BAD_REQUEST).entity(new Results(2,message,null)).type(MediaType.APPLICATION_JSON_TYPE).build());
    }
}
