package com.gaofan.mqreids.exception;

import java.io.UncheckedIOException;

/**
 * @author gaofan
 * @create 2021-09-07 22:02
 */
public class UnCheckedException extends RuntimeException{
    public UnCheckedException() {
        super();
    }

    public UnCheckedException(String message) {
        super(message);
    }
}
