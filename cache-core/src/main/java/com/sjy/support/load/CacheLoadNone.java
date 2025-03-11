package com.sjy.support.load;

import com.sjy.api.ICache;
import com.sjy.api.ICacheLoad;

/**
 * 加载策略-无
 * @author binbin.hou
 * @since 0.0.7
 */
public class CacheLoadNone<K,V> implements ICacheLoad<K,V> {

    @Override
    public void load(ICache<K, V> cache) {
        //nothing...
    }

}