package com.cloud.mp.utils;

import java.util.HashMap;

/**
 * @Author: wxj
 * @Date: 2021-02-02 16:00
 */
public class MapUtils extends HashMap<String, Object> {

        @Override
        public MapUtils put(String key, Object value) {
            super.put(key, value);
            return this;
        }
    }
