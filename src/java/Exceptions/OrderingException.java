package Exceptions;

public class OrderingException extends RuntimeException{
    
    public OrderingException(String msg){
        super(msg);
    }
    
    public OrderingException(String msg, Throwable cause){
        super(msg, cause);
    }
    
}
