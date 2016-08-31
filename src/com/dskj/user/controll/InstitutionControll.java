package com.dskj.user.controll;

import com.dskj.base.Base;
import com.dskj.user.entity.*;
import com.dskj.user.exception.UserExistException;
import com.dskj.user.service.InstitutionService;
import com.dskj.util.Page;
import com.dskj.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class InstitutionControll extends Base {
    @Autowired
    private InstitutionService institutionService;

    /*
     * 增加机构 institution={"name":"","summary":"","phone":"","password":"","regionId":11}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/add")
    public void addInstitution(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        try {
            String jsonString = request.getParameter("institution");
            logger.info(jsonString);
            InstitutionEntity institutionEntity = new InstitutionEntity();
            institutionEntity.setId(StringUtil.generateUUID8());
            institutionEntity.setName(readTree(jsonString, "name"));
            institutionEntity.setSummary(readTree(jsonString, "summary"));
            institutionEntity.setRegionId(readTree(jsonString, "regionId"));
            institutionEntity.setCreateTime(new Date());
            UserEntity userEntity = new UserEntity();
            userEntity.setId(StringUtil.generateUUID8());
            userEntity.setPhone(readTree(jsonString, "phone"));
            userEntity.setPassword(readTree(jsonString, "password"));
            userEntity.setType(1);
            userEntity.setCreateTime(new Date());
            Object object = institutionService.addInstitution(
                    institutionEntity, userEntity);
            if ("name been used".equals(object))
                write(response, false, 900, "该名称已被使用", null);
            else if ("too fast".equals(object))
                write(response, false, 896, "该手机号正在注册中！", null);
            else if ("success".equals(object))
                write(response, null, null, null, null);
            else
                write(response, false, 888, "添加失败", null);
        } catch (Exception e) {
            if (e instanceof UserExistException)
                write(response, false, 900, "该手机号已被使用", null);
            throw e;
        }
    }

    /*
     * 上传机构logo institution={"id":"","logo":""}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/update/logo")
    public void updateInstitutionLogo(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        InstitutionEntity institutionEntity = null;
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        institutionEntity = stringToObj(jsonString, InstitutionEntity.class);
        institutionService.updateInstitutionLogo(
                institutionEntity.getLogo(), institutionEntity.getId());
        write(response, null, null, "修改成功", institutionEntity.getLogo());
    }

    /*
     * 上传机构主页图片 institution={"id":"","face":""}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/update/face")
    public void updateInstitutionFace(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        InstitutionEntity institutionEntity = null;
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        institutionEntity = stringToObj(jsonString, InstitutionEntity.class);
        institutionService.updateInstitutionFace(institutionEntity.getId(),
                institutionEntity.getFace());
        write(response, null, null, "修改成功", institutionEntity.getFace());
    }

    /*
     * 机构基本信息维护
     * institution={"id":"","name":"","summary":"","address":"","tel":""
     * ,"parentId":"" ,"regionId":1,"logo":"","courseType":"","teacherCount":0,"sign":""}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/update/info")
    public void updateInstitutionInfo(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        InstitutionEntity institutionEntity = stringToObj(jsonString,
                InstitutionEntity.class);
        InstitutionEntity institutionEntityOld = institutionService
                .getInstitutionById(institutionEntity.getId());
        if (institutionEntityOld.getName() != null
                && !institutionEntityOld.getName().equals(
                institutionEntity.getName())) {
            InstitutionEntity institutionEntity2 = institutionService
                    .getInstitutionByName(institutionEntity.getName());
            if (institutionEntity2 != null) {
                write(response, false, 900, "该名称已被使用", null);
                return;
            }
        }
        institutionService.updateInstitutionInfo(institutionEntity);
        write(response, null, null, "修改成功", null);
    }

    /*
     * 获取机构列表 institution={"key":"","regionId":1,"pageNo":0,"pageSize":10}
     * reginId传的是省份id也就是1级地址id,可以不传
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/list")
    public void getInstitutionList(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Page page = stringToObj(jsonString, Page.class);
        Object object = institutionService
                .getInstitutionWithPropaListPage(readTree(jsonString, "key"), readTreeAsInt(jsonString, "regionId"), page);
        write(response, null, null, null, object);
    }

    /*
     * 获取机构数目 institution={"key":""}
     */
    @RequestMapping("/institution/count")
    public void getInstitutionCount(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        int o = institutionService.getInstitutionCount(readTree(jsonString, "key"));
        write(response, null, null, null, o);
    }

    /*
     * 获取单个机构 institution={"id":""}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/get")
    public void getInstitution(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Object object = institutionService.getInstitutionById(readTree(
                jsonString, "id"));
        write(response, null, null, null, object);
    }

    /*
     * 根据机构名称查询 institution={"name":"","pageNo":0,"pageSize":10}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/list/by/name")
    public void getInstitutionListByName(HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
        Object object = institutionService.getInstitutionListByName(
                readTree(jsonString, "name"), page);
        write(response, null, null, null, object);
    }

    /*
     * 增加子机构 institution={"name":"","summary":"","parentId":""}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/child/add")
    public void addChildInstitution(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        String parentId = readTree(jsonString, "parentId");
        if (parentId == null || "".equals(parentId)) {
            write(response, false, 901, "父机构不能为空", null);
            return;
        }
        InstitutionEntity institutionEntity = new InstitutionEntity();
        institutionEntity.setId(StringUtil.generateUUID8());
        institutionEntity.setName(readTree(jsonString, "name"));
        institutionEntity.setSummary(readTree(jsonString, "summary"));
        institutionEntity.setParentId(parentId);
        institutionEntity.setCreateTime(new Date());
        UserEntity userEntity = new UserEntity();
        Object object = institutionService.addInstitution(
                institutionEntity, userEntity);
        if ("name been used".equals(object))
            write(response, false, 900, "该名称已被使用", null);
        else if ("success".equals(object))
            write(response, null, null, null, institutionEntity.getId());
        else
            write(response, false, 888, "添加失败", null);
    }

    /*
     * 机构管理员统计中查看自己的分机构列表 institution={"institutionId":"","key":""}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/child/list")
    public void getMyChildInstitution(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        List<ChildInstitutionList> list = institutionService
                .getMyChildInstitution(
                        readTree(jsonString, "institutionId"),
                        readTree(jsonString, "key"));
        write(response, null, null, null, list);
    }

    /*
     * 机构管理员统计中查看分机构的管理员 institution={"institutionId":""}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/institution/child/admin")
    public void getMyChildInstitutionAdmin(HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        List<UserEntity> list = institutionService
                .getMyChildInstitutionAdmin(readTree(jsonString,
                        "institutionId"));
        write(response, null, null, null, list);
    }

    /*
     * 对机构评论 institution={"institutionId":"","userId":"","context":""}
     */
    @RequestMapping("/institution/comment/add")
    public void addInstitutionComment(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        institutionService.addComment(readTree(jsonString, "userId"),
                readTree(jsonString, "institutionId"),
                readTree(jsonString, "context"));
        write(response, null, null, null, null);
    }

    /*
     * 获取机构评论列表
     * institution={"institutionId":"","userId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/institution/comment/list")
    public void getInstitutionComments(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
        Object o = institutionService.getInstitutionComments(
                readTree(jsonString, "institutionId"),
                readTree(jsonString, "userId"), page);
        write(response, null, null, null, o);
    }

    /*
     * 对机构点赞 institution={"institutionId":"","userId":""}
     */
    @RequestMapping("/institution/love/add")
    public void addInstitutionLove(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        InstitutionLove institutionLove = stringToObj(jsonString,
                InstitutionLove.class);
        institutionLove.setCreateTime(new Date());
        institutionService.addInstitutionLove(institutionLove);
        write(response, null, null, null, institutionLove);
    }

    /*
     * 取消机构点赞 institution={"loveId":1}
     */
    @RequestMapping("/institution/love/delete")
    public void deleteInstitutionLove(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        institutionService.deleteInstitutionLove(readTreeAsInt(jsonString,
                "loveId"));
        write(response, null, null, null, null);
    }

    /*
     * 机构主页 institution={"institutionId":"","userId":""}
     */
    @RequestMapping("/institution/face/get")
    public void getInstitutionFaceById(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Object o = institutionService.updateAndGetInstitutionFaceById(
                readTree(jsonString, "institutionId"),
                readTree(jsonString, "userId"));
        write(response, null, null, null, o);
    }

    /*
     * 关注机构 institution={"institutionId":"","userId":""}
     */
    @RequestMapping("/institution/fans/add")
    public void addInstitutionFans(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        InstitutionFans institutionFans = stringToObj(jsonString,
                InstitutionFans.class);
        institutionService.addInstitutionFans(institutionFans);
        write(response, null, null, null, institutionFans);
    }

    /*
     * 取消关注机构 institution={"fansId":11}
     */
    @RequestMapping("/institution/fans/delete")
    public void deleteInstitutionFans(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        institutionService.deleteInstitutionFans(readTreeAsInt(jsonString,
                "fansId"));
        write(response, null, null, null, null);
    }

    /*
     * 通过机构id获取机构所属管理员 institution={"institutionId":"","key":""}
     */
    @RequestMapping("/institution/manager/list")
    public void getInstitutionManagerList(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Object o = institutionService.getInstitutionManagerList(
                readTree(jsonString, "institutionId"),
                readTree(jsonString, "key"));
        write(response, null, null, null, o);
    }

    /*
     * 通过机构id获取机构所属非管理员用户 institution={"institutionId":"","key":""}
     */
    @RequestMapping("/institution/unmanager/list")
    public void getInstitutionUnManagerList(HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Object o = institutionService.getInstitutionUnManagerList(
                readTree(jsonString, "institutionId"),
                readTree(jsonString, "key"));
        write(response, null, null, null, o);
    }

    /*
     * 添加管理员 institution={"institutionId":"","userIds":[]}
     */
    @RequestMapping("/institution/manager/batch/add")
    public void addInstitutionManagerBatch(HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        List<String> userIds = jsonToList(readTree(jsonString, "userIds"),
                ArrayList.class, String.class);
        String m = institutionService.addInstitutionManagerBatch(
                readTree(jsonString, "institutionId"), userIds);
        if (!"".equals(m))
            m = "选择多个机构的用户无法成为管理员";
        if ("".equals(m))
            write(response, true, null, null, null);
        else
            write(response, false, null, m, null);
    }

    /*
     * 删除管理员 institution={"institutionId":"","userIds":[]}
     */
    @RequestMapping("/institution/manager/batch/delete")
    public void deleteInstitutionManagerBatch(HttpServletRequest request,
                                              HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        List<String> userIds = jsonToList(readTree(jsonString, "userIds"),
                ArrayList.class, String.class);
        String m = institutionService.deleteInstitutionManagerBatch(
                readTree(jsonString, "institutionId"), userIds);
        if (m == null)
            write(response, true, null, null, null);
        else
            write(response, false, null, m, null);
    }

    /*
     * 获取非分机构列表 institution={"institutionId":"","key":""}
     */
    @RequestMapping("/institution/unchild/list")
    public void getUnMyChildInstitution(HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        Object o = institutionService.getUnMyChildInstitution(
                readTree(jsonString, "institutionId"),
                readTree(jsonString, "key"));
        write(response, null, null, null, o);
    }

    /*
     * 添加分机构 institution={"institutionId":"","children":["",""],"credence":""}
     */
    @RequestMapping("/institution/child/batch/add")
    public void addBatchMyChildInstitution(HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        List<String> childIds = jsonToList(
                readTree(jsonString, "children"), ArrayList.class,
                String.class);
        if (childIds != null && childIds.size() != 1) {
            write(response, false, 711, "请一个一个添加", null);
            return;
        }
        String result = institutionService.addBatchMyChildInstitution(
                readTree(jsonString, "institutionId"), childIds, readTree(jsonString, "credence"));
        if (result == null) {
            write(response, null, null, null, null);
            return;
        } else {
            write(response, false, 711, result, null);
            return;
        }
    }

    /*
     * 删除分机构 institution={"institutionId":"","children":["",""]}
     */
    @RequestMapping("/institution/child/batch/delete")
    public void deleteBatchMyChildInstitution(HttpServletRequest request,
                                              HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        List<String> childIds = jsonToList(
                readTree(jsonString, "children"), ArrayList.class,
                String.class);
        institutionService.deleteBatchMyChildInstitution(
                readTree(jsonString, "institutionId"), childIds);
        write(response, null, null, null, null);
    }

    /*
     * 删除机构 institution={"institutionId":""}
     */
    @RequestMapping("/institution/delete")
    public void deleteInstitution(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("institution");
        logger.info(jsonString);
        institutionService.deleteInstitution(readTree(jsonString, "institutionId"));
        write(response, null, null, null, null);
    }
}
