package com.taobao.nacos.unit;

import java.util.HashMap;
import java.util.Map;

public class ServiceName {
    public final static Map<String, String> map = new HashMap<>();

    static {
        map.put("OpensourceServiceConsumer", "opensource-service-consumer");
        map.put("OpensourceServiceConsumer2", "opensource-service-consumer2");
        map.put("OpensourceZuul", "opensource-zuul");
        map.put("OpensourceServiceProvider", "opensource-service-provider");
        map.put("OpensourceServiceProvider3", "opensource-service-provider3");
        map.put("AdminServer", "admin-server");
        map.put("alicloudServiceConsumer2","alicloud-service-consumer2");
        map.put("alicloudServiceConsumer","alicloud-service-consumer");
    }
}
