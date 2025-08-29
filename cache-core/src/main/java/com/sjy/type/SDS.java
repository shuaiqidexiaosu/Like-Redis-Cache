package com.sjy.type;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @program: SDS
 * @description:
 * @author: 智慧的苏苏
 * @create: 2025-08-28 19:20
 **/
public final class SDS {
    private byte[] buf;
    private int len;
    private int alloc;

    private final Charset charset;

    private static final int ONE_MB = 1024 * 1024;


    private SDS(int capacity, Charset charset)  {
        if (capacity < 0) {
            throw new IllegalAccessException("capacity < 0");
        }
        this.buf = new byte[capacity];
        this.len = 0;
        this.alloc = capacity;
        this.charset = charset == null ? Charset.defaultCharset() : charset;
    }

    public static SDS create(int capacity) {
        return new SDS(capacity, StandardCharsets.UTF_8);
    }


    public static SDS create(int initialCapacity, Charset cs) {
        return new SDS(initialCapacity, cs);
    }

    public static SDS wrap(byte[] data) {
        SDS s = new SDS(data.length, StandardCharsets.UTF_8);
        System.arraycopy(data, 0, s.buf, 0, data.length);
        s.len = data.length;
        return s;
    }




}
