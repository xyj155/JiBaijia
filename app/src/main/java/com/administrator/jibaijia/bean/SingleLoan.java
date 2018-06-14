package com.administrator.jibaijia.bean;

/**
 * Created by Administrator on 2018/6/14.
 */

public class SingleLoan {

    /**
     * status : 200
     * issuccess : true
     * data : {"id":1,"tubiao":"http://task.toidea.com/upload/opusfile/7/60375/1282038112_0.jpg","daikuanmc":"恒昌-车贷","zuigaoedu":"20","yuelixi":"1.5","huankuanfangshi":"等额本息","fangkuangshijian":"三天","zhengduirenqun":"低收入人群","huankuangqixian":"1","tuijianshipin":"视频","kefudianhua":"110","kefufuwushijian":"8:00am-18:00pm","zhonglei":"设备贷","edufanwei":"2.0-50.0万","qixianfanwei":"12个月-36个月","shenqintiaojian":null,"shengqincailiao":null,"daikuan":8,"lixijine":2641,"feiyong":2,"yicixin":24}
     */

    private int status;
    private boolean issuccess;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

        public String getShenqintiaojian() {
            return shenqintiaojian;
        }

        public void setShenqintiaojian(String shenqintiaojian) {
            this.shenqintiaojian = shenqintiaojian;
        }

        public void setShengqincailiao(String shengqincailiao) {
            this.shengqincailiao = shengqincailiao;
        }

        public String getShengqincailiao() {
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
