package com.ua.sutty.lab4;

import interfaces.task4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsImpl implements MapUtils {

    @Override
    public Map<String, Integer> findThrees(String s) {


        if (s == null) {
            throw new NullPointerException();
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 2; i++) {
            String substring = s.substring(i, i + 3);
            if (substring.matches("[0-9A-Za-z]{3}")) {
                if (map.containsKey(substring)) {
                    map.put(substring,map.get(substring) + 1);
                } else {
                    map.put(substring, 1);
                }
            }
        }
        return map;
    }

}
