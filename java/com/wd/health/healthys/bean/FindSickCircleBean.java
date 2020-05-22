package com.wd.health.healthys.bean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/19
 * Time: 16:14
 * 2.2.1、病友圈列表展示Bean类
 */
public class FindSickCircleBean {

    /**
     * result : [{"amount":10,"collectionNum":1,"commentNum":1,"detail":"啊啊啊啊","releaseTime":1582041600000,"sickCircleId":78,"title":"啊啊啊啊"},{"amount":10,"collectionNum":0,"commentNum":0,"detail":"28358","releaseTime":1571760000000,"sickCircleId":64,"title":"111"},{"amount":0,"collectionNum":0,"commentNum":2,"detail":"112","releaseTime":1570550400000,"sickCircleId":42,"title":"11111"},{"amount":20,"collectionNum":0,"commentNum":1,"detail":"实在太多了，，，","releaseTime":1569600000000,"sickCircleId":38,"title":"我的颈椎病中午治好了"},{"amount":20,"collectionNum":1,"commentNum":1,"detail":"靠枕  颈椎病又犯了","releaseTime":1569254400000,"sickCircleId":35,"title":"治疗颈椎病"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 10
         * collectionNum : 1
         * commentNum : 1
         * detail : 啊啊啊啊
         * releaseTime : 1582041600000
         * sickCircleId : 78
         * title : 啊啊啊啊
         */

        private int amount;
        private int collectionNum;
        private int commentNum;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
