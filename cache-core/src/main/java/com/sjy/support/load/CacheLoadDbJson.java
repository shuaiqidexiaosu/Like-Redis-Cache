package com.sjy.support.load;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sjy.api.ICache;
import com.sjy.api.ICacheLoad;
import com.sjy.model.PersistRdbEntry;
import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;

import java.util.List;

/**
 * 加载策略-文件路径
 *
 * @author binbin.hou
 * @since 0.0.8
 */
public class CacheLoadDbJson<K, V> implements ICacheLoad<K, V> {

    private static final Log log = LogFactory.getLog(CacheLoadDbJson.class);

    /**
     * 文件路径
     *
     * @since 0.0.8
     */
    private final String dbPath;

    public CacheLoadDbJson(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    public void load(ICache<K, V> cache) {
        List<String> lines = FileUtil.readAllLines(dbPath);
        log.info("[load] 开始处理 path: {}", dbPath);
        if (CollectionUtil.isEmpty(lines)) {
            log.info("[load] path: {} 文件内容为空，直接返回", dbPath);
            return;
        }

        for (String line : lines) {
            if (StringUtil.isEmpty(line)) {
                continue;
            }

            // 执行
            // 简单的类型还行，复杂的这种反序列化会失败
            try {
                PersistRdbEntry<K, V> entry = JSON.parseObject(line, new TypeReference<PersistRdbEntry<K, V>>() {
                });
                K key = entry.getKey();
                V value = entry.getValue();
                Long expire = entry.getExpire();
                cache.put(key, value);
                if (ObjectUtil.isNotNull(expire)) {
                    cache.expireAt(key, expire);
                }
            } catch (Exception e) {
                log.error("[load] 反序列化失败，line: {}", line, e);
            }

        }
        //nothing...
    }
}