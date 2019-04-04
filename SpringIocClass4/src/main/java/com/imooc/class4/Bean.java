package com.imooc.class4;

public class Bean {
    private SubBean subBean;

    public SubBean getSubBean() {
        return subBean;
    }

    public void setSubBean(SubBean subBean) {
        this.subBean = subBean;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "subBean=" + subBean +
                '}';
    }
}
