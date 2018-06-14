package com.administrator.jibaijia.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MarqueenBean {

    /**
     * status : 200
     * issuccess : true
     * data : [{"id":1,"text1":"王女士获取200万"},{"id":2,"text1":"王女士获取200万"},{"id":3,"text1":"王女士获取200万"},{"id":4,"text1":"王女士获取200万"},{"id":5,"text1":"王女士获取200万"},{"id":6,"text1":"王女士获取200万"},{"id":7,"text1":"王女士获取200万"},{"id":8,"text1":"王女士获取200万"}]
     */

    private int status;
    private boolean issuccess;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isIssuccess() {
        return issuccess;
    }

    public void setIssuccess(boolean issuccess) {
        this.issuccess = issuccess;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * text1 : 王女士获取200万
         */

        private int id;
        private String text1;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getText1() {
            return text1;
        }

        public void setText1(String text1) {
            this.text1 = text1;
        }
    }
}
