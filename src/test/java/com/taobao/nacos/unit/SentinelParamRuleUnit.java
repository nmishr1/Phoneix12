package com.taobao.nacos.unit;

import java.util.List;
import java.util.Map;

public class SentinelParamRuleUnit {
    int code;

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    String msg;
    boolean success;
    List<Data> data;

    public class Data<T> {
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

        public T getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(T gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public T getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(T gmtModified) {
            this.gmtModified = gmtModified;
        }


        long id;
        String app;
        String ip;
        int port;
        T gmtCreate;
        T gmtModified;

        public T getRule() {
            return rule;
        }

        public void setRule(T rule) {
            this.rule = rule;
        }

        T rule;
    }

    public class ParamRule{
        public List<RuleDetail> getRuleDetail() {
            return ruleDetail;
        }

        public void setRuleDetail(List<RuleDetail> ruleDetail) {
            this.ruleDetail = ruleDetail;
        }

        List<RuleDetail> ruleDetail;
    }

    public class RuleDetail{
        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public double getCount() {
            return count;
        }

        public void setCount(double count) {
            this.count = count;
        }

        public String getClassType() {
            return classType;
        }

        public void setClassType(String classType) {
            this.classType = classType;
        }

        String object;
        double count;
        String classType;
    }

}
