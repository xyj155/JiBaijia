package com.administrator.jibaijia.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/13.
 */

public class BannerBean {

    /**
     * status : 200
     * issuccess : true
     * data : [{"bannerurl":"https://edu-image.nosdn.127.net/fafbe728-5758-4033-85ac-42f08107f7b7.jpg?imageView&thumbnail=860y380&quality=100"},{"bannerurl":"https://edu-image.nosdn.127.net/783e0f2a-dade-451c-92cf-d97714504b80.jpg?imageView&thumbnail=860y380&quality=100"},{"bannerurl":"https://edu-image.nosdn.127.net/f90bf114-5b0a-4689-b854-5431a4585e5d.jpg?imageView&thumbnail=860y380&quality=100"},{"bannerurl":"https://edu-image.nosdn.127.net/9a83725a-c515-40cb-b075-5092cdc3c21b.jpg?imageView&thumbnail=860y380&quality=100"},{"bannerurl":"https://edu-image.nosdn.127.net/7d3142d0-3a72-4dda-af22-5cd23e3a97eb.jpg?imageView&thumbnail=860y380&quality=100"}]
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
         * bannerurl : https://edu-image.nosdn.127.net/fafbe728-5758-4033-85ac-42f08107f7b7.jpg?imageView&thumbnail=860y380&quality=100
         */

        private String bannerurl;

        public String getBannerurl() {
            return bannerurl;
        }

        public void setBannerurl(String bannerurl) {
            this.bannerurl = bannerurl;
        }
    }
}
