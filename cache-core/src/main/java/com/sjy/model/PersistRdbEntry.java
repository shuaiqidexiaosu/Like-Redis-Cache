package com.sjy.model;

import lombok.Setter;
import lombok.Getter;

/**
 * 持久化明细
 *
 * @author binbin.hou
 * @since 0.0.8
 */
@Getter
@Setter
public class PersistRdbEntry<K, V> {

    /**
     * key
     *
     * @since 0.0.8
     */
    private K key;

    /**
     * value
     *
     * @since 0.0.8
     */
    private V value;

    /**
     * expire
     *
     * @since 0.0.8
     */
    private Long expire;
}