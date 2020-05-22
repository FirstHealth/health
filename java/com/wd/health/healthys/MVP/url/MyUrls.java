package com.wd.health.healthys.MVP.url;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/18
 * Time: 19:39
 */
public interface MyUrls {
    String BASE_URL = "http://mobile.bwstudent.com/health/";
    //2.2.1、病友圈列表展示
    String findSickCircleList_URL = "user/sickCircle/v1/findSickCircleList";
    //2.2.2、查询病友圈详情
    String findSickCircleInfo_URL = "user/sickCircle/v1/findSickCircleInfo";
    //2.2.3、根据关键词查询病友圈
    String searchSickCircle_URL = "user/sickCircle/v1/searchSickCircle";
    //2.2.4、病友圈发表评论
    String publishComment_URL = "user/sickCircle/verify/v1/publishComment";
    //2.2.5、查询病友圈评论列表
    String findSickCircleCommentList_URL = "user/sickCircle/v1/findSickCircleCommentList";
    //2.2.6、采纳病友圈优秀的评论
    String adoptionProposal_URL = "user/sickCircle/verify/v1/adoptionProposal";
    //2.2.7、发表观点
    String expressOpinion_URL = "user/sickCircle/verify/v1/expressOpinion";
    //2.2.8、查看病友的病友圈发帖列表
    String findPatientSickCircleList_URL = "user/sickCircle/v1/findPatientSickCircleList";
    //2.2.9、查看我的病友圈发帖列表
    String findMySickCircleList_URL = "user/sickCircle/verify/v1/findMySickCircleList";
    //2.2.10、查询我的病友圈帖子的评论列表
    String findMySickCircleCommentList_URL = "user/sickCircle/verify/v1/findMySickCircleCommentList";
    //2.2.11、发布病友圈
    String publishSickCircle_URL = "user/sickCircle/verify/v1/publishSickCircle";
    //2.2.12、上传用户病友圈相关图片
    String uploadSickCirclePicture_URL = "user/sickCircle/verify/v1/uploadSickCirclePicture";
}
