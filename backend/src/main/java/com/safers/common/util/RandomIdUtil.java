package com.safers.common.util;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomIdUtil {

    public static String makeRandomId(int length) {
        //'0' 부터  'z'까지의 범위
        int leftLimit = 48;
        int rightLimit = 122;

        //생성할 id 길이
        Random random = new Random();

        String id = random.ints(leftLimit,rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return id;
    }

}
