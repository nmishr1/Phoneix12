package com.taobao.nacos.unit;

import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;

import java.util.List;

public class NacosDiscoveryEndpointTest {
    public List<EndPointServiceInfo> subscribe;
    public NacosDiscoveryProperties nacosDiscoveryProperties;

    public List<EndPointServiceInfo> getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(List<EndPointServiceInfo> subscribe) {
        this.subscribe = subscribe;
    }

    public NacosDiscoveryProperties getNacosDiscoveryProperties() {
        return nacosDiscoveryProperties;
    }

    public void setNacosDiscoveryProperties(NacosDiscoveryProperties nacosDiscoveryProperties) {
        this.nacosDiscoveryProperties = nacosDiscoveryProperties;
    }
}
