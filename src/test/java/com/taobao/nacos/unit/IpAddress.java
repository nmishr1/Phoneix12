package com.taobao.nacos.unit;

import com.alibaba.nacos.api.naming.pojo.Instance;

public class IpAddress extends Instance {
    boolean marked;

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
