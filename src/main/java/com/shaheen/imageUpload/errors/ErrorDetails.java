/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.imageUpload.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 * @author lts
 */
public class ErrorDetails {

    private String message;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-YYYY hh:mm:ss")
    private Date timestamp;

    public ErrorDetails() {
        this.timestamp = new Date();
    }

    public ErrorDetails(String message, String uri) {
        this();
        this.message = message;
        this.uri = uri;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
