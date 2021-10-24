package com.gaofan.mqreids.exception;

/**
 * @author gaofan
 * @create 2021-09-07 21:27
 */
public class BusinessException extends Exception{
    public BusinessException() {
        super();
    }
    public BusinessException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        String str = null;
        try {
            if (str.getBytes().length > 10) {
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            System.out.println("+++++++++++++++++++++++===");
            e.printStackTrace();
        }
    }
}
