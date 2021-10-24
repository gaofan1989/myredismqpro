package com.gaofan.mqreids.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @author gaofan
 * @create 2021-09-07 21:58
 */
public class TestException {

    public static String getExc(String name) throws BusinessException {
        if (StringUtils.isBlank(name)) {
            throw new BusinessException("name is not Empty");
        }
        return String.format("hello, %s", name);
    }

    public static String gexUncheck(String name) {
        if (StringUtils.isBlank(name)) {
            throw new UnCheckedException("name is not Empty");
        }
        return String.format("%80d", name);
    }

    public static void main(String[] args) {
        try {
            TestException.gexUncheck(null);
        } catch (Exception e) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            e.printStackTrace();
        }
        System.out.println("++++++++++++++++++++++");


        System.out.println("-----------------------");
        try {
            TestException.getExc(null);
        } catch (BusinessException e) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            e.printStackTrace();
        }
        System.out.println("-----------------------");
    }

}
