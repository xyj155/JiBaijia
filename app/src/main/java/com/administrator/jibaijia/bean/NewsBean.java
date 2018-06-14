package com.administrator.jibaijia.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class NewsBean {

    /**
     * status : 200
     * issuccess : true
     * data : {"total":4,"per_page":8,"current_page":1,"last_page":1,"data":[{"id":1,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"},{"id":2,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"},{"id":3,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"},{"id":4,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"}]}
     */

    private int status;
    private boolean issuccess;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 4
         * per_page : 8
         * current_page : 1
         * last_page : 1
         * data : [{"id":1,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"},{"id":2,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"},{"id":3,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"},{"id":4,"newstitle":"我的我的","newscontents":"我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的","zhaopaitupian":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3"}]
         */

        private int total;
        private int per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
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
             * newstitle : 我的我的
             * newscontents : 我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的我的
             * zhaopaitupian : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528946853838&di=f6c949ede0df506aa22fd965813fcda4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad3
             */

            private int id;
            private String newstitle;
            private String newscontents;
            private String zhaopaitupian;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNewstitle() {
                return newstitle;
            }

            public void setNewstitle(String newstitle) {
                this.newstitle = newstitle;
            }

            public String getNewscontents() {
                return newscontents;
            }

            public void setNewscontents(String newscontents) {
                this.newscontents = newscontents;
            }

            public String getZhaopaitupian() {
                return zhaopaitupian;
            }

            public void setZhaopaitupian(String zhaopaitupian) {
                this.zhaopaitupian = zhaopaitupian;
            }
        }
    }
}
