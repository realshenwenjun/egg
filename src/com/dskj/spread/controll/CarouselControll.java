package com.dskj.spread.controll;

import com.dskj.base.Base;
import com.dskj.spread.entity.Carousel;
import com.dskj.spread.entity.CarouselCollect;
import com.dskj.spread.entity.CarouselDetail;
import com.dskj.spread.entity.CarouselLove;
import com.dskj.spread.service.CarouselService;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CarouselControll extends Base {
    @Autowired
    private CarouselService carouselService;

    /*
     * 上传轮播图carousel={"path":"","val":"","context":"","title":""}
     */
    @RequestMapping("/carousel/add")
    public void uploadCoursel(HttpServletRequest request,
                              HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("carousel");
            logger.info(jsonString);
            Carousel carousel = stringToObj(jsonString, Carousel.class);
            carousel.setCreateTime(new Date());
            carouselService.add(carousel);
            write(response, null, null, null, carousel.getPath());
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 修改轮播图carousel={"id":1,"path":"","val":"","context":"","title":""}
     */
    @RequestMapping("/carousel/update")
    public void updateCoursel(HttpServletRequest request,
                              HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("carousel");
            logger.info(jsonString);
            Carousel carousel = new Carousel();
            carousel.setId(readTreeAsInt(jsonString, "id"));
            carousel.setContext(readTree(jsonString, "context"));
            carousel.setPath(readTree(jsonString, "path"));
            carousel.setVal(readTree(jsonString, "val"));
            carousel.setTitle(readTree(jsonString, "title"));
            carouselService.updateCarousel(carousel);
            write(response, null, null, null, carousel.getPath());
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获取轮播图
     */
    @RequestMapping("/carousel/list")
    public void getCourselList(HttpServletRequest request,
                               HttpServletResponse response) {
        try {
            List<Carousel> list = carouselService.getList();
            write(response, null, null, null, list);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 批量删除轮播图 carousel=[1,2,3]
     */
    @RequestMapping("/carousel/delete")
    public void delCourselFecth(HttpServletRequest request,
                                HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            List<Integer> carList = jsonToList(jsoString, ArrayList.class,
                    Integer.class);
            for (Integer id : carList) {
                carouselService.deleteById(id);
            }
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 关注此轮播图 carousel={"carouselId":1,"userId":""}
     */
    @RequestMapping("/carousel/love/add")
    public void addCourselLove(HttpServletRequest request,
                               HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            CarouselLove carouselLove = stringToObj(jsoString,
                    CarouselLove.class);
            carouselLove.setCreateTime(new Date());
            carouselService.addCarouselLove(carouselLove);
            write(response, null, null, null, carouselLove);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 取消关注此轮播图 carousel={"carouselId":1,"userId":""}
     */
    @RequestMapping("/carousel/love/delete")
    public void deleteCourselLove(HttpServletRequest request,
                                  HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            carouselService.deleteCarouselLove(
                    readTreeAsInt(jsoString, "carouselId"),
                    readTree(jsoString, "userId"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 收藏此轮播图 carousel={"carouselId":1,"userId":""}
     */
    @RequestMapping("/carousel/collect/add")
    public void addCourselCollect(HttpServletRequest request,
                                  HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            CarouselCollect carouselCollect = stringToObj(jsoString,
                    CarouselCollect.class);
            carouselCollect.setCreateTime(new Date());
            carouselService.addCarouselCollect(carouselCollect);
            write(response, null, null, null, carouselCollect);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 取消收藏此轮播图 carousel={"carouselId":1,"userId":""}
     */
    @RequestMapping("/carousel/collect/delete")
    public void deleteCourselCollect(HttpServletRequest request,
                                     HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            carouselService.deleteCarouselCollect(
                    readTreeAsInt(jsoString, "carouselId"),
                    readTree(jsoString, "userId"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 对轮播图评论 carousel={"carouselId":1,"userId":"","context":""}
     */
    @RequestMapping("/carousel/comment/add")
    public void addCourselComment(HttpServletRequest request,
                                  HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            carouselService.addCarouselCommet(
                    readTreeAsInt(jsoString, "carouselId"),
                    readTree(jsoString, "userId"),
                    readTree(jsoString, "context"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获取轮播图的详细 carousel={"id":1,"userId":""}
     */
    @RequestMapping("/carousel/get")
    public void getCourselDetail(HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            CarouselDetail carouselDetail = carouselService.getDetailById(
                    readTreeAsInt(jsoString, "id"),
                    readTree(jsoString, "userId"));
            write(response, null, null, null, carouselDetail);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获取轮播图的评论 carousel={"carouselId":1,"userId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/carousel/comment/list")
    public void getCourselCommentList(HttpServletRequest request,
                                      HttpServletResponse response) {
        try {
            String jsoString = request.getParameter("carousel");
            logger.info(jsoString);
            Page page = new Page();
            page.setPageNo(readTreeAsInt(jsoString, "pageNo"));
            page.setPageSize(readTreeAsInt(jsoString, "pageSize"));
            Object o = carouselService.getCarouselComments(
                    readTreeAsInt(jsoString, "carouselId"),
                    readTree(jsoString, "userId"), page);
            write(response, null, null, null, o);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }
}
