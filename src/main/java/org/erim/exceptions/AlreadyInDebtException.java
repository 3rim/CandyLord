package org.erim.exceptions;

public class AlreadyInDebtException extends RuntimeException{

    AlreadyInDebtException(){
        super();
    }
    public AlreadyInDebtException(String msg) {
        super(msg);
    }
}
