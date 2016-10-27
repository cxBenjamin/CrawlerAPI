package org.csip.bigData.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bun@csip.org.cn on 2016/9/8.
 */

public class Article {

    String id;

    String source_url;

    String title;

    String publish_time;

    String crawler_time;

    String source;

    String author;

    String digest;

    String content;

    String source_tag;

    String category;

    String images;
    String tag;
    String attachments;

    @JsonProperty("attachments")
    public String getAttachments(){
        return attachments;
    }

    public void setAttachments(String attachments){
        this.attachments = attachments;
    }

    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("source_url")
    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("publish_time")
    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }
    @JsonProperty("crawler_time")
    public String getCrawler_time() {
        return crawler_time;
    }

    public void setCrawler_time(String crawler_time) {
        this.crawler_time = crawler_time;
    }
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @JsonProperty("source_tag")
    public String getSource_tag() {
        return source_tag;
    }

    public void setSource_tag(String source_tag) {
        this.source_tag = source_tag;
    }
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @JsonProperty("images")
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }




}
