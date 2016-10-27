package org.csip.bigData.exception;

import org.csip.bigData.entity.Results;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by bun@csip.org.cn on 2016/9/13.
 */
@Provider
public class DateException  extends WebApplicationException {

    public DateException(String message)
    {
        super(Response.status(Response.Status.BAD_REQUEST).entity(new Results(1,message,null)).type(MediaType.APPLICATION_JSON_TYPE).build());
    }
}
