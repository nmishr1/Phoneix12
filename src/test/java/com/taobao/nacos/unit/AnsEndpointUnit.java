package com.taobao.nacos.unit;

import org.springframework.cloud.alicloud.context.ans.AnsProperties;

public class AnsEndpointUnit<T> {
    T subscribes;
    AnsProperties ansProperties;

    public T getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(T subscribes) {
        this.subscribes = subscribes;
    }

    public AnsProperties getAnsProperties() {
        return ansProperties;
    }

    public void setAnsProperties(AnsProperties ansProperties) {
        this.ansProperties = ansProperties;
    }
}
