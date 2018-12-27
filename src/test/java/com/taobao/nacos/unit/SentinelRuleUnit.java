package com.taobao.nacos.unit;

import java.util.List;

public class SentinelRuleUnit {
    int code;
    String msg;
    boolean success;
    List<Rule> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Rule> getData() {
        return data;
    }

    public void setData(List<Rule> data) {
        this.data = data;
    }

    public class Rule {
        long id;
        String app;
        String ip;
        int port;
        String resource;
        double count;
        long grade;
        String limitApp;
        int strategy;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public double getCount() {
            return count;
        }

        public void setCount(double count) {
            this.count = count;
        }

        public long getGrade() {
            return grade;
        }

        public void setGrade(long grade) {
            this.grade = grade;
        }

        public String getLimitApp() {
            return limitApp;
        }

        public void setLimitApp(String limitApp) {
            this.limitApp = limitApp;
        }

        public int getStrategy() {
            return strategy;
        }

        public void setStrategy(int strategy) {
            this.strategy = strategy;
        }
    }
}
