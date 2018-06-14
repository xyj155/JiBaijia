package com.administrator.jibaijia.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/13.
 */

public class LoanListBean {

    /**
     * status : 200
     * issuccess : true
     * data : {"total":16,"per_page":8,"current_page":1,"last_page":2,"data":[{"id":1,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"20","yuelixi":"1.5","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"1","tuijianshipin":"视频","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"设备贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":8,"lixijine":2641,"feiyong":2,"yicixin":24},{"id":2,"tubiao":"http://www.toidea.com/upload/opusfile/9/80406/1292322716_1.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"50","yuelixi":"2.5","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"2","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"车贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":9,"lixijine":21321,"feiyong":12,"yicixin":2},{"id":3,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"20","yuelixi":"0.5","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"3","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"保单贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":5,"lixijine":42131,"feiyong":42,"yicixin":24},{"id":4,"tubiao":"http://task.toidea.com/upload/opusfile/9/80406/1292322622_2.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"20","yuelixi":"2.6","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"4","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"月供贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":56,"lixijine":5435,"feiyong":1,"yicixin":87},{"id":5,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"5","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":2,"lixijine":34242,"feiyong":24,"yicixin":24},{"id":6,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"6","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":2,"lixijine":1231,"feiyong":24,"yicixin":45},{"id":7,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"7","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":2,"lixijine":2313,"feiyong":24,"yicixin":24},{"id":8,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"8","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":1,"lixijine":21,"feiyong":1,"yicixin":24}]}
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
         * total : 16
         * per_page : 8
         * current_page : 1
         * last_page : 2
         * data : [{"id":1,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"20","yuelixi":"1.5","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"1","tuijianshipin":"视频","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"设备贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":8,"lixijine":2641,"feiyong":2,"yicixin":24},{"id":2,"tubiao":"http://www.toidea.com/upload/opusfile/9/80406/1292322716_1.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"50","yuelixi":"2.5","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"2","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"车贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":9,"lixijine":21321,"feiyong":12,"yicixin":2},{"id":3,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"20","yuelixi":"0.5","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"3","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"保单贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":5,"lixijine":42131,"feiyong":42,"yicixin":24},{"id":4,"tubiao":"http://task.toidea.com/upload/opusfile/9/80406/1292322622_2.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"20","yuelixi":"2.6","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"4","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"月供贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":56,"lixijine":5435,"feiyong":1,"yicixin":87},{"id":5,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"5","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":2,"lixijine":34242,"feiyong":24,"yicixin":24},{"id":6,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"6","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":2,"lixijine":1231,"feiyong":24,"yicixin":45},{"id":7,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"7","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":2,"lixijine":2313,"feiyong":24,"yicixin":24},{"id":8,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"100","yuelixi":"2.3","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"8","tuijianshipin":"","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"业主贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":1,"lixijine":21,"feiyong":1,"yicixin":24}]
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
             * tubiao : http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg
             * daikuanmc : 恒昌-车贷
             * zuigaoedu : 20
             * yuelixi : 1.5
             * huankuanfangshi : 等额本息
             * fangkuangshijian : 三天
             * zhengduirenqun : 低收入人群
             * huankuangqixian : 1
             * tuijianshipin : 视频
             * kefudianhua : 110
             * kefufuwushijian : 8:00am-18:00pm
             * zhonglei : 设备贷
             * edufanwei : 2.0-50.0万
             * qixianfanwei : 12个月-36个月
             * shenqintiaojian : null
             * shengqincailiao : null
             * daikuan : 8
             * lixijine : 2641
             * feiyong : 2
             * yicixin : 24
             */

            private int id;
            private String tubiao;
            private String daikuanmc;
            private String zuigaoedu;
            private String yuelixi;
            private String huankuanfangshi;
            private String fangkuangshijian;
            private String zhengduirenqun;
            private String huankuangqixian;
            private String tuijianshipin;
            private String kefudianhua;
            private String kefufuwushijian;
            private String zhonglei;
            private String edufanwei;
            private String qixianfanwei;
            private String shenqintiaojian;
            private String shengqincailiao;
            private int daikuan;
            private int lixijine;

            public void setShenqintiaojian(String shenqintiaojian) {
                this.shenqintiaojian = shenqintiaojian;
            }

            public void setShengqincailiao(String shengqincailiao) {
                this.shengqincailiao = shengqincailiao;
            }

            private int feiyong;
            private int yicixin;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTubiao() {
                return tubiao;
            }

            public void setTubiao(String tubiao) {
                this.tubiao = tubiao;
            }

            public String getDaikuanmc() {
                return daikuanmc;
            }

            public void setDaikuanmc(String daikuanmc) {
                this.daikuanmc = daikuanmc;
            }

            public String getZuigaoedu() {
                return zuigaoedu;
            }

            public void setZuigaoedu(String zuigaoedu) {
                this.zuigaoedu = zuigaoedu;
            }

            public String getYuelixi() {
                return yuelixi;
            }

            public void setYuelixi(String yuelixi) {
                this.yuelixi = yuelixi;
            }

            public String getHuankuanfangshi() {
                return huankuanfangshi;
            }

            public void setHuankuanfangshi(String huankuanfangshi) {
                this.huankuanfangshi = huankuanfangshi;
            }

            public String getFangkuangshijian() {
                return fangkuangshijian;
            }

            public void setFangkuangshijian(String fangkuangshijian) {
                this.fangkuangshijian = fangkuangshijian;
            }

            public String getZhengduirenqun() {
                return zhengduirenqun;
            }

            public void setZhengduirenqun(String zhengduirenqun) {
                this.zhengduirenqun = zhengduirenqun;
            }

            public String getHuankuangqixian() {
                return huankuangqixian;
            }

            public void setHuankuangqixian(String huankuangqixian) {
                this.huankuangqixian = huankuangqixian;
            }

            public String getTuijianshipin() {
                return tuijianshipin;
            }

            public void setTuijianshipin(String tuijianshipin) {
                this.tuijianshipin = tuijianshipin;
            }

            public String getKefudianhua() {
                return kefudianhua;
            }

            public void setKefudianhua(String kefudianhua) {
                this.kefudianhua = kefudianhua;
            }

            public String getKefufuwushijian() {
                return kefufuwushijian;
            }

            public void setKefufuwushijian(String kefufuwushijian) {
                this.kefufuwushijian = kefufuwushijian;
            }

            public String getZhonglei() {
                return zhonglei;
            }

            public void setZhonglei(String zhonglei) {
                this.zhonglei = zhonglei;
            }

            public String getEdufanwei() {
                return edufanwei;
            }

            public void setEdufanwei(String edufanwei) {
                this.edufanwei = edufanwei;
            }

            public String getQixianfanwei() {
                return qixianfanwei;
            }

            public void setQixianfanwei(String qixianfanwei) {
                this.qixianfanwei = qixianfanwei;
            }

            public Object getShenqintiaojian() {
                return shenqintiaojian;
            }


            public Object getShengqincailiao() {
                return shengqincailiao;
            }


            public int getDaikuan() {
                return daikuan;
            }

            public void setDaikuan(int daikuan) {
                this.daikuan = daikuan;
            }

            public int getLixijine() {
                return lixijine;
            }

            public void setLixijine(int lixijine) {
                this.lixijine = lixijine;
            }

            public int getFeiyong() {
                return feiyong;
            }

            public void setFeiyong(int feiyong) {
                this.feiyong = feiyong;
            }

            public int getYicixin() {
                return yicixin;
            }

            public void setYicixin(int yicixin) {
                this.yicixin = yicixin;
            }
        }
    }
}
