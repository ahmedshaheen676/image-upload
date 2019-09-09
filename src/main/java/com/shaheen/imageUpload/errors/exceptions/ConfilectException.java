/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.imageUpload.errors.exceptions;

import com.shaheen.imageUpload.errors.BaseException;
import org.springframework.http.HttpStatus;

/**
 *
 * @author lts
 */
public class ConfilectException extends BaseException {

    public ConfilectException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }

}
