package com.dskj.activity.controll;

import com.dskj.activity.entity.*;
import com.dskj.activity.service.CancelResonService;
import com.dskj.activity.service.ChildActivityReservationService;
import com.dskj.activity.service.ChildActivityService;
import com.dskj.base.Base;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ChildActivtiyControll extends Base {

    @Autowired
    private ChildActivityService childActivityService;

    @Autowired
    private ChildActivityReservationService childActivityReservationService;

    @Autowired
    private CancelResonService cancelResonService;

    private DateFormat sdfYMdHmssss = new SimpleDateFormat("yyyyMMddHHmmssSS");

    /*
     * 管理员增加一个亲子活动
     * childActivity={"title":"","activityType":1,"ticketType":"","name"
     * :"","price"
     * :1.0,"oldPrice":2.0,"saleCount":0,"thumb_img":"","adver_img":""
     * ,"shortDetail"
     * :"","detail":"","url":"","shareCount":0,"commentCount":0,"beginDate"
     * :"2016-04-27","endDate":"2016-08-27"}
     */
    @RequestMapping(value = "/childActivity/add", method = RequestMethod.POST)
    public void addChildActivity(HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            ChildActivity childActivity = stringToObj(jsonString,
                    ChildActivity.class);
            childActivity.setCreateTime(new Date());
            // if(childActivity.getInstitutionId()==null||"".equals(childActivity.getInstitutionId())){
            // write(response, false, 500, "参数不完整", null);
            // }else {
            childActivityService.add(childActivity);
            write(response, null, null, null, childActivity);
            // }
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 上传亲子活动图片 childActivity={"id":22,"thumbImg":"","adverImg":""}
     */
    @RequestMapping(value = "/childActivity/image", method = RequestMethod.POST)
    public void uploadAnnoImage(HttpServletRequest request,
                                HttpServletResponse response) {
        String realpath = request.getSession().getServletContext()
                .getRealPath("");
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            int id = readTreeAsInt(jsonString, "id");
            ChildActivity childActivity = childActivityService.get(id, "");
            // 1.如果已经存在图片则为修改，此时先要将原图片删除
            if (childActivity.getThumbImg() != null
                    && childActivity.getAdverImg() != null) {
                // TODO 删除oss上的原来的图片
            }
            // String thumbImg = fileUpload.transferTo(tempFile1, realpath,
            // BusinessFileType.CHILDACTIVITY.getType());
            // String adverImg = fileUpload.transferTo(tempFile2, realpath,
            // BusinessFileType.CHILDACTIVITY.getType());
            // if ("图片不存在".equals(thumbImg)) {
            // write(response, false, 911, "图片不存在", tempFile1);
            // return;
            // }
            // if ("图片不存在".equals(adverImg)) {
            // write(response, false, 911, "图片不存在", tempFile2);
            // return;
            // }
            childActivity.setThumbImg(readTree(jsonString, "thumbImg"));
            childActivity.setAdverImg(readTree(jsonString, "adverImg"));
            childActivityService.update(childActivity);
            write(response, null, null, "修改成功", childActivity);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 管理员删除亲子活动接口 childActivity={"ids":[1,2]}
     */
    @RequestMapping(value = "/childActivity/delete", method = RequestMethod.POST)
    public void deleteChildActivity(HttpServletRequest request,
                                    HttpServletResponse response) {
        String realpath = request.getSession().getServletContext()
                .getRealPath("");
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            List<Integer> ids = jsonToList(readTree(jsonString, "ids"),
                    ArrayList.class, Integer.class);
            for (int id : ids) {
                ChildActivity childActivity = childActivityService.get(id, "");
                if (childActivity != null) {
                    if (childActivity.getThumbImg() != null
                            && !"".equals(childActivity.getThumbImg())) {
                        // TODO 删除oss缩略图
                    }
                    if (childActivity.getAdverImg() != null
                            && !"".equals(childActivity.getAdverImg())) {
                        // TODO 删除oss大图
                    }
                }
            }
            childActivityService.delete(ids);
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 管理员修改一个亲子活动
     * childActivity={"id":4,"activityType":1,"ticketType":"票种","title"
     * :"","name"
     * :"","price":1.0,"oldPrice":2.0,"saleCount":0,"thumb_img":"","adver_img"
     * :""
     * ,"shortDetail":"","detail":"","url":"","shareCount":0,"commentCount":0,
     * "beginDate"
     * :"2016-04-27","endDate":"2016-08-27","reserveBeginDate":"2016-04-28"
     * ,"reserveEndDate":"2016-02-27"}
     */
    @RequestMapping(value = "/childActivity/update", method = RequestMethod.POST)
    public void updateChildActivtty(HttpServletRequest request,
                                    HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            ChildActivity childActivity = stringToObj(jsonString,
                    ChildActivity.class);
            childActivityService.update(childActivity);
            write(response, null, null, null, null);
        } catch (Exception e) {
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 查询亲子活动根据活动id， childActivity={"id":1,"userId":""}
     */
    @RequestMapping(value = "/childActivity/get", method = RequestMethod.POST)
    public void getChildActivityById(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            int id = readTreeAsInt(jsonString, "id");
            ChildActivity childActivity = childActivityService.get(id,
                    readTree(jsonString, "userId"));
            if (childActivity != null) {
                write(response, null, null, null, childActivity);
                return;
            } else {
                write(response, null, null, null, null);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 获得全部的亲子活动列表 childActivity={"pageNo":0,"pageSize":10}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/list", method = RequestMethod.POST)
    public void getChildActivityList(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            Page page = stringToObj(jsonString, Page.class);
            List<ChildActivity> list = childActivityService.getList(page);
            write(response, null, null, null, list);
        } catch (Exception e) {
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 获得全部的亲子活动数量
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/count", method = RequestMethod.POST)
    public void getChildActivityCount(HttpServletRequest request,
                                      HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            write(response, null, null, null,
                    childActivityService.getChildActivityCount());
        } catch (Exception e) {
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 查询 符合条件的亲子活动列表 childActivity={"searchItem":"条件","pageNo":0,"pageSize":10}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/list/search", method = RequestMethod.POST)
    public void searchChildActivity(HttpServletRequest request,
                                    HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            Page page = stringToObj(jsonString, Page.class);
            String searchItem = readTree(jsonString, "searchItem");
            List<ChildActivity> list = childActivityService.getListBySearch(
                    searchItem, page);
            write(response, null, null, null, list);
        } catch (Exception e) {
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-是否已报名亲子活动接口 参数：childActivity={"childActivityId":1,"userId":"2"}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/isReserveChildActivity", method = RequestMethod.POST)
    public void isReserveChildActivity(HttpServletRequest request,
                                       HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            int childActivityId = readTreeAsInt(jsonString, "childActivityId");
            String userId = readTree(jsonString, "userId");
            if (childActivityId < 0 || userId == null || "".equals(userId)) {
                write(response, false, 911, "userId或者childActivityId为空", null);
            } else {
                boolean reserveFlag = childActivityReservationService
                        .isReserveChildActivity(userId, childActivityId);
                write(response, null, null, null, reserveFlag);
            }
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-修改亲子活动报名信息接口 参数：
     * childActivity={"id":3,"realName":"","phone":"13655161319"
     * ,"price":33,"reserveCount":3}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/updateReservationInfo", method = RequestMethod.POST)
    public void updateReservationInfo(HttpServletRequest request,
                                      HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            ChildActivityReservation childActivityReservation = stringToObj(
                    jsonString, ChildActivityReservation.class);
            childActivityReservationService.update(childActivityReservation);
            write(response, null, null, null, null);
        } catch (Exception e) {
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-预约报名接口 参数：
     * childActivity={"childActivityId":1,"userId":"1","reserveCount"
     * :10,"realname":"王二","phone":"12345678901","price":总价}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/reserve", method = RequestMethod.POST)
    public void reserve(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            ChildActivityReservation childActivityReservation = stringToObj(
                    jsonString, ChildActivityReservation.class);
            boolean reserveFlag = childActivityReservationService
                    .isReserveChildActivity(childActivityReservation.getUserId(), childActivityReservation.getChildActivityId());
            if (reserveFlag) {
                write(response, false, 911, "重复报名", null);
                return;
            }
            childActivityReservation.setOrderNumber(sdfYMdHmssss
                    .format(new Date()));
            childActivityReservation.setCreateTime(new Date());
            childActivityReservation.setState(1); // 设置为有效状态
            childActivityReservationService.add(childActivityReservation);
            write(response, null, null, null, childActivityReservation);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-预约报名删除接口 参数：
     * childActivity={"id":12,"cancelCode":2,"cancelRemark"："用户自定义取消原因"}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/cancelReservation", method = RequestMethod.POST)
    public void cancel(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            int id = readTreeAsInt(jsonString, "id");
            int cancelCode = readTreeAsInt(jsonString, "cancelCode");
            String cancelRemark = readTree(jsonString, "cancelRemark");
            ChildActivityReservation cancel = new ChildActivityReservation();
            cancel.setId(id);
            cancel.setCancelCode(cancelCode);
            cancel.setCancelRemark(cancelRemark);
            cancel.setState(0); // 置失效
            childActivityReservationService.update(cancel);
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-预约报名查询接口，根据活动id 参数：
     * childActivity={"childActivityId":1,"pageNo":0,"pageSize":10}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/listReservation/childActivity", method = RequestMethod.POST)
    public void listReservationByChildActivity(HttpServletRequest request,
                                               HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            Page page = stringToObj(jsonString, Page.class);
            int childActivityId = readTreeAsInt(jsonString, "childActivityId");
            ChildActivityReservation record = new ChildActivityReservation();
            record.setChildActivityId(childActivityId);
            List<ChildActivityReservation> list = childActivityReservationService
                    .getList(record, page);
            write(response, null, null, null, list);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-预约报名查询接口，根据用户id 参数：
     * childActivity={"userId":1,"pageNo":0,"pageSize":10}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/listReservation/user", method = RequestMethod.POST)
    public void listReservationByUser(HttpServletRequest request,
                                      HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            Page page = stringToObj(jsonString, Page.class);
            String userId = readTree(jsonString, "userId");
            ChildActivityReservation record = new ChildActivityReservation();
            record.setUserId(userId);
            List<ChildActivityReservation> list = childActivityReservationService
                    .getList(record, page);
            write(response, null, null, null, list);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-预约报名详情查询接口，根据id 参数： childActivity={"id":1}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/reservationDetail", method = RequestMethod.POST)
    public void reservationDetail(HttpServletRequest request,
                                  HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            int id = readTreeAsInt(jsonString, "id");
            ChildActivityReservation record = childActivityReservationService
                    .get(id);
            write(response, null, null, null, record);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 获得全部取消原因 childActivity={}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/getAllCancelReason", method = RequestMethod.POST)
    public void getAllCancelReason(HttpServletRequest request,
                                   HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            List<CancelReason> list = cancelResonService.getAll();
            write(response, null, null, null, list);
        } catch (Exception e) {
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 管理员增加一个亲子活动取消原因接口 childActivity={"name":"取消原因"}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/addCancelReason", method = RequestMethod.POST)
    public void addCancelReson(HttpServletRequest request,
                               HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            CancelReason cancelReason = stringToObj(jsonString,
                    CancelReason.class);
            cancelReason.setCreateTime(new Date());
            cancelResonService.add(cancelReason);
            write(response, null, null, null, cancelReason);
        } catch (Exception e) {
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-收藏活动 参数： childActivity={"userId":"","activityId":1}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/collect/add", method = RequestMethod.POST)
    public void addChildActivityCollect(HttpServletRequest request,
                                        HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            ChildActivityCollect childActivityCollect = stringToObj(jsonString,
                    ChildActivityCollect.class);
            childActivityCollect.setCreateTime(new Date());
            childActivityService.addChildActivityCollect(childActivityCollect);
            write(response, null, null, null, childActivityCollect);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /**
     * 亲子活动-评论活动 参数： childActivity={"userId":"","activityId":1,"context":""}
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/childActivity/comment/add", method = RequestMethod.POST)
    public void addChildActivityComment(HttpServletRequest request,
                                        HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            childActivityService.addChildActivityComment(
                    readTreeAsInt(jsonString, "activityId"),
                    readTree(jsonString, "userId"),
                    readTree(jsonString, "context"));
            write(response, null, null, null, null);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 取消收藏此活动 childActivity={"activityCollectId":1}
     */
    @RequestMapping("/childActivity/collect/delete")
    public void deleteChildActivityCollect(HttpServletRequest request,
                                           HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            childActivityService.deleteChildActivityCollect(readTreeAsInt(
                    jsoString, "activityCollectId"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获取活动的评论
     * childActivity={"activityId":1,"userId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/childActivity/comment/list")
    public void getChildActivityCommentList(HttpServletRequest request,
                                            HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            Page page = new Page();
            page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
            page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
            Object o = childActivityService.getActivityComments(
                    readTreeAsInt(jsoString, "activityId"),
                    readTree(jsoString, "userId"), page);
            write(response, null, null, null, o);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 对活动点赞 childActivity={"activityId":1,"userId":""}
     */
    @RequestMapping("/childActivity/love/add")
    public void addChildActivityLove(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            ChildActivityLove childActivityLove = stringToObj(jsoString,
                    ChildActivityLove.class);
            childActivityLove.setCreateTime(new Date());
            childActivityService.addActivityLove(childActivityLove);
            write(response, null, null, null, childActivityLove);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 取消对活动点赞 childActivity={"activityId":1,"userId":""}
     */
    @RequestMapping("/childActivity/love/delete")
    public void deleteChildActivityLove(HttpServletRequest request,
                                        HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            childActivityService.deleteActivityLove(
                    readTreeAsInt(jsoString, "activityId"),
                    readTree(jsoString, "userId"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 增加活动现场图片 childActivity={"activityId":1,"imgs":["",""]}
     */
    @RequestMapping("/childActivity/local/img/add")
    public void addActivityLocalImgs(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            Integer activityId = readTreeAsInt(jsoString, "activityId");
            List<String> urls = jsonToList(readTree(jsoString, "imgs"),
                    ArrayList.class, String.class);
            List<ChildActivityImg> childActivityImgs = new ArrayList<ChildActivityImg>();
            if (urls != null && urls.size() != 0) {
                for (String url : urls) {
                    ChildActivityImg childActivityImg = new ChildActivityImg();
                    childActivityImg.setActivityId(activityId);
                    childActivityImg.setCreateTime(new Date());
                    childActivityImg.setUrl(url);
                    childActivityImgs.add(childActivityImg);
                }
                childActivityService.addActivityImg(childActivityImgs);
            }
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 删除活动现场图片 childActivity={"id":1}
     */
    @RequestMapping("/childActivity/local/img/delete")
    public void deleteActivityLocalImg(HttpServletRequest request,
                                       HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            childActivityService.deleteActivityImg(readTreeAsInt(jsoString,
                    "id"));
            // TODO 删除oss上活动现场图片
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获取活动现场图片 childActivity={"activityId":1,"pageNo":0,"pageSize":10}
     */
    @RequestMapping("/childActivity/local/img/list")
    public void getActivityLocalImgs(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            Page page = new Page();
            page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
            page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
            Object o = childActivityService.getActivityImgList(
                    readTreeAsInt(jsoString, "activityId"), page);
            write(response, null, null, null, o);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 增加活动咨询 childActivity={"activityId":1,"userId":"","context":""}
     */
    @RequestMapping("/childActivity/ask/add")
    public void addActivityAsk(HttpServletRequest request,
                               HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            ChildActivityAsk childActivityAsk = stringToObj(jsoString,
                    ChildActivityAsk.class);
            childActivityService.addChildActivityAsk(childActivityAsk);
            write(response, null, null, null, childActivityAsk);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 管理员回复活动咨询 childActivity={"askId":1,"userId":"","context":""}
     */
    @RequestMapping("/childActivity/ask/answer/add")
    public void addActivityAskAnswer(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            childActivityService.addChildActivityAskAnswer(
                    readTreeAsInt(jsoString, "askId"),
                    readTree(jsoString, "userId"),
                    readTree(jsoString, "context"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 查询活动咨询
     * childActivity={"activityId":1,"userId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/childActivity/my/ask/list")
    public void getActivityMyAsk(HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            Page page = new Page();
            page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
            page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
            Object o = childActivityService.getActivityMyAsk(
                    readTreeAsInt(jsoString, "activityId"),
                    readTree(jsoString, "userId"), page);
            write(response, null, null, null, o);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 删除活动咨询
     * childActivity={"askId":1}
     */
    @RequestMapping("/childActivity/my/ask/delete")
    public void deleteActivityMyAsk(HttpServletRequest request,
                                    HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            childActivityService.deleteActivityMyAsk(readTreeAsInt(jsoString, "askId"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 删除某个人对某个活动的全部活动咨询
     * childActivity={"userId":"","activityId":1}
     */
    @RequestMapping("/childActivity/my/ask/all/delete")
    public void deleteAllActivityMyAsk(HttpServletRequest request,
                                       HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            childActivityService.deleteAllActivityMyAsk(readTree(jsoString, "userId"), readTreeAsInt(jsoString, "activityId"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 查询活动咨询数目 childActivity={"activityId":1,"userId":""}
     */
    @RequestMapping("/childActivity/my/ask/count")
    public void getActivityMyAskCount(HttpServletRequest request,
                                      HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            Integer activityId = null;
            String userId = null;
            try {
                activityId = readTreeAsInt(jsoString, "activityId");
                userId = readTree(jsoString, "userId");
            } catch (Exception e) {
            }
            write(response, null, null, null,
                    childActivityService.getActivityMyAskCount(activityId,
                            userId));
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 查询活动反馈 childActivity={"pageNo":0,"pageSize":5}
     */
    @RequestMapping("/childActivity/feedback/list")
    public void getActivityFeedbackList(HttpServletRequest request,
                                        HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            Page page = new Page();
            page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
            page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
            Object o = childActivityService.getActivityFeedbackList(page);
            write(response, null, null, null, o);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 查询活动反馈数目 childActivity={}
     */
    @RequestMapping("/childActivity/feedback/count")
    public void getActivityFeedbackCount(HttpServletRequest request,
                                         HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            write(response, null, null, null, childActivityService.getActivityFeedbackCount());
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 查询活动反馈统计 childActivity={}
     */
    @RequestMapping("/childActivity/feedback/census")
    public void getActivityFeedbackCensus(HttpServletRequest request,
                                          HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("childActivity");
            logger.info(jsoString);
            write(response, null, null, null, childActivityService.getCancelCensus());
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 我的活动列表 childActivity={"userId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/childActivity/my/list")
    public void getMyActivityList(HttpServletRequest request,
                                  HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            Page page = stringToObj(jsonString, Page.class);
            List<ChildActivity> list = childActivityService.getMyActivityList(readTree(jsonString, "userId"), page);
            write(response, null, null, null, list);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 活动报名列表 childActivity={"activityId":0,"pageNo":0,"pageSize":10}
     */
    @RequestMapping("/childActivity/sign/user/list")
    public void getActivityUserSign(HttpServletRequest request,
                                    HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            Page page = stringToObj(jsonString, Page.class);
            List<UserActivitySign> list = childActivityService.getActivityUserSign(readTreeAsInt(jsonString, "activityId"), page);
            write(response, null, null, null, list);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }
    /*
     * 活动报名数量 childActivity={"activityId":0}
     */
    @RequestMapping("/childActivity/sign/user/count")
    public void getActivityUserSignCount(HttpServletRequest request,
                                    HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("childActivity");
            logger.info(jsonString);
            int count = childActivityService.getActivityUserSignCount(readTreeAsInt(jsonString, "activityId"));
            write(response, null, null, null, count);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }
}