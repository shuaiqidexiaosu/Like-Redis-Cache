package com.sjy.support.evict;

import com.sjy.api.ICacheEntry;
import com.sjy.api.ICacheEvictContext;

/**
 * 丢弃策略
 * @author binbin.hou
 * @since 0.0.2
 */
public class CacheEvictNone<K,V> extends AbstractCacheEvict<K,V> {

    @Override
    protected ICacheEntry<K, V> doEvict(ICacheEvictContext<K, V> context) {
        return null;
    }

}