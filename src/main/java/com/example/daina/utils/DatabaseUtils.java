package com.example.daina.utils;

import java.util.UUID;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:09 2019/4/8
 */
public class DatabaseUtils {
    public static String generateUniqueKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
