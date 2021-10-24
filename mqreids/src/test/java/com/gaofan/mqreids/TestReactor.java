package com.gaofan.mqreids;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * @author gaofan
 * @create 2021-05-13 23:51
 */
public class TestReactor {

    @Test
    public void testflux() {
        Flux<String> stringFlux = Flux.fromArray(new String[]{"afea", "abd", "afe"});
        stringFlux.subscribe(t -> System.out.println(t));
        Flux<Object> error = Flux.error(new Exception(""));

    }
}
