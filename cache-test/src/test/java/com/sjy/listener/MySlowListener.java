package com.sjy.listener;

import com.sjy.api.ICacheSlowListener;
import com.sjy.api.ICacheSlowListenerContext;

/**
 * @author binbin.hou
 * @since 0.0.9
 */
public class MySlowListener implements ICacheSlowListener {

    @Override
    public void listen(ICacheSlowListenerContext context) {
        System.out.println("【慢日志】name: " + context.methodName());
    }

    /**
     *  设置超过多少秒算慢日志
     * @since: 0.0.1
     * @author: 智慧的苏苏
     * @date: 2025/3/18 下午4:55
     * @return: long
     */
    @Override
    public long slowerThanMills() {
        return 0;
    }

}