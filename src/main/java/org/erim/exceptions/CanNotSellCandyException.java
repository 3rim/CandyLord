package org.erim.exceptions;

public class CanNotSellCandyException extends RuntimeException {

    public CanNotSellCandyException(){super();}
    public CanNotSellCandyException(String string) {
        super(string);
    }
}
