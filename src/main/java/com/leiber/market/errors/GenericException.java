package com.leiber.market.errors;

/**
 * Generic exception class for handling generic errors
 *
 * Created on 09/10/2024 at 11:49 pm
 *
 * @author Leiber Bertel
 *
 */
public class GenericException extends RuntimeException {
    public GenericException(String msgError, Exception e){
        super(msgError, e);
    }
}
