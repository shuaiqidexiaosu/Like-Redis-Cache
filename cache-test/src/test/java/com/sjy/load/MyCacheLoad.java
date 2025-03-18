package com.sjy.load;

import com.sjy.api.ICache;
import com.sjy.api.ICacheLoad;

/**
 * @author binbin.hou
 * @since 0.0.7
 */
public class MyCacheLoad implements ICacheLoad<String,String> {

    @Override
    public void load(ICache<String, String> cache) {
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
    }

}