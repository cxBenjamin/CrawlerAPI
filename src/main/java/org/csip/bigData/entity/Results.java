package org.csip.bigData.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by bun@csip.org.cn on 2016/9/8.
 */
public class Results {
    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    @JsonProperty("result")
    public List<Article> getResult() {
        return result;
    }

    public void setResult(List<Article> result) {
        this.result = result;
    }

    //0:正常返回。1：请求参数出错。2：系统响应出错。
    private int status;
    private String errorMessage;
    private List<Article> result;

    public Results() {

    }

    public Results(int status, String errorMessage, List<Article> result) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.result = result;
    }
}
