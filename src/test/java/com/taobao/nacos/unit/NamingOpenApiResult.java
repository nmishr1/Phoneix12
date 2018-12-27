package com.taobao.nacos.unit;

import java.util.List;

public class NamingOpenApiResult<T> {
    private T metadata;
    String dom;
    Long cacheMillis;
    Boolean useSpecifiedURL;
    String checksum;
    long lastRefTime;
    String env;
    String clusters;
    List<IpAddress> hosts;

    public T getMetadata() {
        return metadata;
    }

    public void setMetadata(T metadata) {
        this.metadata = metadata;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public Long getCacheMillis() {
        return cacheMillis;
    }

    public void setCacheMillis(Long cacheMillis) {
        this.cacheMillis = cacheMillis;
    }

    public Boolean getUseSpecifiedURL() {
        return useSpecifiedURL;
    }

    public void setUseSpecifiedURL(Boolean useSpecifiedURL) {
        this.useSpecifiedURL = useSpecifiedURL;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public long getLastRefTime() {
        return lastRefTime;
    }

    public void setLastRefTime(long lastRefTime) {
        this.lastRefTime = lastRefTime;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getClusters() {
        return clusters;
    }

    public void setClusters(String clusters) {
        this.clusters = clusters;
    }

    public List<IpAddress> getHosts() {
        return hosts;
    }

    public void setHosts(List<IpAddress> hosts) {
        this.hosts = hosts;
    }
}
