package com.dskj.user.controll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.user.entity.Role;
import com.dskj.user.service.RoleService;

@Controller
public class RoleControll extends Base {
    @Autowired
    private RoleService roleService;

    /*
     * 获取角色列表
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/role/list")
    public void getRoleList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Role> list = roleService.getList();
            write(response, null, null, null, list);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获取单个角色
     * role={"id":1}
     * @param request
     *
     * @param response
     */
    @RequestMapping("/role/get")
    public void getRole(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("role");
            logger.info(jsonString);
            Role role = roleService.get(readTreeAsInt(jsonString, "id"));
            write(response, null, null, null, role);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 增加单个角色
     * role={"name":"学生"}
     * @param request
     *
     * @param response
     */
    @RequestMapping("/role/add")
    public void addRole(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("role");
            logger.info(jsonString);
            Role role = new Role();
            role.setName(readTree(jsonString, "name"));
            role.setCreateTime(new Date());
            roleService.add(role);
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 修改单个角色
     * role={"id":1,"name":"学生"}
     * @param request
     *
     * @param response
     */
    @RequestMapping("/role/update")
    public void updateRole(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("role");
            logger.info(jsonString);
            Role role = stringToObj(jsonString, Role.class);
            roleService.update(role);
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 删除单个角色
     * role={"id":1}
     * @param request
     *
     * @param response
     */
    @RequestMapping("/role/delete")
    public void deleteRole(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("role");
            logger.info(jsonString);
            roleService.delete(readTreeAsInt(jsonString, "id"));
            write(response, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }
}
