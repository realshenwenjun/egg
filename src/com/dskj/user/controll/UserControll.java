package com.dskj.user.controll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.user.entity.Collect;
import com.dskj.user.entity.CollectInstitution;
import com.dskj.user.entity.InstitutionEntity;
import com.dskj.user.entity.InstitutionUserEntity;
import com.dskj.user.entity.UserCircle;
import com.dskj.user.entity.UserEntity;
import com.dskj.user.entity.UserFans;
import com.dskj.user.entity2_0.UserAsk;
import com.dskj.user.entity2_0.UserGroup;
import com.dskj.user.service.UserService;
import com.dskj.util.HttpUtil;
import com.dskj.util.Page;
import com.dskj.util.StringUtil;

@Controller
public class UserControll extends Base {
	@Autowired
	private UserService userService;

	/*
	 * 验证手机是否存在
	 * 
	 * @param user={"phone":"13520383733"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/check/phone")
	public void checkPhone(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(readTree(jsonString, "phone"));
			Boolean object = userService.getCheckPhone(readTree(jsonString,
					"phone"));
			if (object) {
				write(response, null, null, "手机号已注册", true);
			} else {
				write(response, false, 906, "手机号未注册", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 个人注册
	 * 
	 * @param user={"phone":"18600084079","password":"123456","type":3}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/add")
	public void addUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity userEntity = stringToObj(jsonString, UserEntity.class);
			Boolean boo = userService.getCheckPhone(userEntity.getPhone());
			if (boo) {
				write(response, false, 910, "该手机号已注册", null);
				return;
			}
			userEntity.setId(StringUtil.generateUUID8());
			Object obj = userService.addUser(userEntity);
			if ("too fast".equals(obj)) {
				write(response, false, 896, "该手机号正在注册中！", null);
				return;
			}
			userLogin(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 用户登录
	 * 
	 * @param user={"phone":"18600084079","password":"123456"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/login")
	public void userLogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity userEntity = stringToObj(jsonString, UserEntity.class);
			if (userEntity == null || userEntity.getPhone() == null
					|| userEntity.getPassword() == null) {
				write(response, false, 908, "用户名或密码不能为空", null);
				return;
			}
			userEntity = userService.getUserLogin(userEntity.getPhone(),
					userEntity.getPassword());
			if (userEntity == null) {
				write(response, false, 908, "用户名或密码错误", null);
			} else {
				userService.addUserLoginLog(userEntity);
				write(response, null, null, "登录成功", userEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * QQ登录
	 * 
	 * @param user={"qqOpenId":"18600084079"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/qq/login")
	public void userQQLogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity userEntity = userService.getUserQQLogin(readTree(
					jsonString, "qqOpenId"));
			if (userEntity == null)
				write(response, false, 900, "没有该用户", null);
			else {
				userService.addUserLoginLog(userEntity);
				write(response, null, null, "登录成功", userEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * sina登录
	 * 
	 * @param user={"sinaOpenId":"18600084079"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/sina/login")
	public void userSinaLogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity userEntity = userService.getUserSinaLogin(readTree(
					jsonString, "sinaOpenId"));
			if (userEntity == null)
				write(response, false, 900, "没有该用户", null);
			else
				userService.addUserLoginLog(userEntity);
			write(response, null, null, "登录成功", userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * weixin登录
	 * 
	 * @param user={"weixinOpenId":"18600084079"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/weixin/login")
	public void userWeiXinLogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity userEntity = userService.getUserWeiXinLogin(readTree(
					jsonString, "weixinOpenId"));
			if (userEntity == null)
				write(response, false, 900, "没有该用户", null);
			else
				userService.addUserLoginLog(userEntity);
			write(response, null, null, "登录成功", userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * QQ绑定
	 * 
	 * @param user={"qqOpenId":"18600084079","id":""}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/qq/bind")
	public void userQQBind(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.updateUserBindQQ(readTree(jsonString, "qqOpenId"),
					readTree(jsonString, "id"));
			write(response, null, null, "绑定成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * sina绑定
	 * 
	 * @param user={"sinaOpenId":"18600084079","id":""}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/sina/bind")
	public void userSinaBind(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.updateUserBindSina(readTree(jsonString, "sinaOpenId"),
					readTree(jsonString, "id"));
			write(response, null, null, "绑定成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * weixin绑定
	 * 
	 * @param user={"weixinOpenId":"18600084079","id":""}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/weixin/bind")
	public void userWeiXinBind(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.updateUserBindWeiXin(
					readTree(jsonString, "weixinOpenId"),
					readTree(jsonString, "id"));
			write(response, null, null, "绑定成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 修改密码
	 * 
	 * @param user={"phone":"13520383733","password":"hd7fdfdf8dfdf7fd9f"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/change/password")
	public void changePassword(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity userEntity = stringToObj(jsonString, UserEntity.class);
			userService.updatePassword(userEntity.getPhone(),
					userEntity.getPassword());
			write(response, null, null, "修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 上传头像
	 * 
	 * @param user={"id":"Wdsd2dsd","photo":""}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/update/photo")
	public void updateUserPhoto(HttpServletRequest request,
			HttpServletResponse response) {
		UserEntity user = null;
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			user = stringToObj(jsonString, UserEntity.class);
			userService.updateUserPhoto(user.getId(), user.getPhoto());
			write(response, null, null, "修改成功", user.getPhoto());
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 用户基本信息维护
	 * 
	 * @param user={"id":"W3Dff3w3","name":"name","levelId":1
	 * ,"type":1,"address":"address","sex":1,"birthday":12232434
	 * ,"regionId":88,"realName":"","interest":"","shortIntroduction":"","sign":""}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/update/info")
	public void updateUserInfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity userEntity = stringToObj(jsonString, UserEntity.class);
			userService.updateUserInfo(userEntity);
			write(response, null, null, "修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取用户关联的机构
	 * 
	 * @param user={"id":"W3Dff3w3"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/my/institutions")
	public void getMyInstitutions(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object object = userService.getMyInstitutionWithCurrent(readTree(
					jsonString, "id"));
			write(response, null, null, null, object);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取用户未关联的机构
	 * 
	 * @param user={"id":"W3Dff3w3","pageNo":0,"pageSize":10}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/other/institutions")
	public void getOtherInstitutions(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object object = userService.getOtherInstitution(
					readTree(jsonString, "id"), page);
			write(response, null, null, null, object);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 用户选择机构
	 * 
	 * @param user={"id":"","institutionIds":["Qfo2cddf"]}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/regist/institutions")
	public void registInstitutions(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			String id = readTree(jsonString, "id");
			String institutionIdString = readTree(jsonString, "institutionIds");
			List<String> institutionIds = jsonToList(institutionIdString,
					ArrayList.class, String.class);
			if (institutionIds == null || institutionIds.size() == 0)
				throw new Exception();
			List<InstitutionUserEntity> institutionUserEntities = new ArrayList<InstitutionUserEntity>();
			for (String institutionId : institutionIds) {
				InstitutionUserEntity entity = new InstitutionUserEntity();
				entity.setInstitutionId(institutionId);
				entity.setUserId(id);
				entity.setCreateTime(new Date());
				institutionUserEntities.add(entity);
			}
			userService.addRegistInstitutions(institutionUserEntities, id);
			/** 刷新所有缓存 ***/
			String host = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath()
					+ "/sys/cache/clear?cache=all";
			HttpUtil.get(host, null);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 用户删除自己所选机构
	 * 
	 * @param user={"userId":"","institutionId":"Qfo2cddf"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/delete/institution")
	public void deleteMyInstitution(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			// 查询自己已经选择的机构下报名的班级数
			if (userService.getMyClassCountByInstitution(
					readTree(jsonString, "userId"),
					readTree(jsonString, "institutionId")) == 0) {
				userService.deleteMyInstitution(readTree(jsonString, "userId"),
						readTree(jsonString, "institutionId"));
				/** 刷新所有缓存 ***/
				String host = "http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/sys/cache/clear?cache=all";
				HttpUtil.get(host, null);
				write(response, null, null, null, null);
			} else {
				write(response, false, 800, "您已在该机构下班级报名，不能删除！", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 选择已注册的手机号
	 * 
	 * @param user=["11111111"]
	 * 
	 * @param response
	 */
	@RequestMapping("/user/registed/phones")
	public void getRegistedPhones(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object object = userService.getRegistedPhones(jsonString);
			write(response, null, null, "成功", object);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 平台管理员获取用户列表
	 * 
	 * @param user={"pageNo":0,"pageSize":10}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/list")
	public void getUserList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = stringToObj(jsonString, Page.class);
			Object object = userService.getUserListPage(page);
			write(response, null, null, null, object);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 机构管理员获取下面的教师
	 * 
	 * @param user={"institutionId":"6Fk31iKT"}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/manage/teacher/list")
	public void getManageTeacherList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<UserEntity> teachers = userService
					.getManageTeacherList(readTree(jsonString, "institutionId"));
			write(response, null, null, null, teachers);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 5 机构管理员根据名字或手机号搜索下面的教师
	 * 
	 * @param
	 * user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/manage/teacher/search")
	public void getManageTeacherSearch(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<UserEntity> teachers = userService.getManageTeacherSearch(
					readTree(jsonString, "institutionId"),
					readTree(jsonString, "key"), page);
			write(response, null, null, null, teachers);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 24 机构管理员根据名字或手机号搜索下面的学生
	 * 
	 * @param
	 * user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/manage/student/search")
	public void getManageStudentSearch(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<UserEntity> teachers = userService.getManageStudentSearch(
					readTree(jsonString, "institutionId"),
					readTree(jsonString, "key"), page);
			write(response, null, null, null, teachers);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 23 机构管理根据名字或手机号搜索机构下面的用户
	 * 
	 * @param
	 * user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/manage/user/search")
	public void getManageUserSearch(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<UserEntity> teachers = userService.getManageUserSearch(
					readTree(jsonString, "institutionId"),
					readTree(jsonString, "key"), page);
			write(response, null, null, null, teachers);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 根据名字和手机号搜索平台下的用户(没有选择机构的用户)
	 * 
	 * @param user={"key":"","pageNo":0,"pageSize":10}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/system/search/key")
	public void getSystemUser(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<UserEntity> users = userService.getSystemUser(
					readTree(jsonString, "key"), page);
			write(response, null, null, null, users);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 根据名字和手机号搜索平台下的用户(没有限制)
	 * 
	 * @param user={"key":"","pageNo":0,"pageSize":10}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/all/search/key")
	public void getSystemUserAll(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<UserEntity> users = userService.getSystemUserAll(
					readTree(jsonString, "key"), page);
			write(response, null, null, null, users);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 根据id搜索平台下的用户
	 * 
	 * @param user={"id":""}
	 * 
	 * @param response
	 */
	@RequestMapping("/user/system/search/id")
	public void getSystemUserById(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserEntity user = userService
					.getUserById(readTree(jsonString, "id"));
			write(response, null, null, null, user);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取所有注册用户数量
	 */
	@RequestMapping("/user/all/count")
	public void getAllUserCount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			int count = userService.getAllUserCount();
			write(response, null, null, null, count);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取好友列表 user=[""]
	 */
	@RequestMapping("/user/friend/list")
	public void getFriendList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<String> ids = jsonToList(jsonString, ArrayList.class,
					String.class);
			List<UserEntity> list = userService.getFriendList(ids);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 收藏机构user={"userId":"","institutionId":""}
	 */
	@RequestMapping("/user/collect/add")
	public void addCollect(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Collect collect = stringToObj(jsonString, Collect.class);
			collect.setCreateTime(new Date());
			userService.addCollect(collect);
			write(response, null, null, null, collect);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 查看机构收藏user={"userId":"","pageNo":1,"pageSize":10} type
	 * 为可选,可以为null，institution，course，class,user
	 */
	@RequestMapping("/user/collect/list")
	public void getCollectList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<CollectInstitution> list = userService.getCollectList(
					readTree(jsonString, "userId"),
					readTree(jsonString, "type"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 搜索机构用于收藏user={"userId":"","key":"","pageNo":1,"pageSize":10}
	 */
	@RequestMapping("/user/collect/institution/search")
	public void getCollectInstitutionSearch(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<InstitutionEntity> list = userService
					.getCollectInstitutionSearch(
							readTree(jsonString, "userId"),
							readTree(jsonString, "key"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 搜索用户未关联的机构 user={"id":"","key":""}
	 */
	@RequestMapping("/user/other/institution/search")
	public void getOtherInstitutionSearch(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<InstitutionEntity> list = userService
					.getOtherInstitutionSearch(readTree(jsonString, "id"),
							readTree(jsonString, "key"));
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除收藏 user={"id":9}
	 */
	@RequestMapping("/user/collect/delete")
	public void deleteCollect(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.deleteCollect(readTreeAsInt(jsonString, "id"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 设为当前机构 user={"userId":"","institutionId":""}
	 */
	@RequestMapping("/user/institution/current/add")
	public void addCurrentInstitution(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			InstitutionUserEntity institutionUserEntity = stringToObj(
					jsonString, InstitutionUserEntity.class);
			userService.addCurrentInstitution(institutionUserEntity);
			/** 刷新所有缓存 ***/
			String host = "http://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath()
					+ "/sys/cache/clear?cache=all";
			HttpUtil.get(host, null);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取平台管理员列表 user={"userId":"","key":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/supper/admin/list")
	public void getSupperAdminList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<UserEntity> list = userService.getSupperAdminList(
					readTree(jsonString, "userId"),readTree(jsonString, "key"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 获取平台管理员个数 user={"userId":"","key":""}
	 */
	@RequestMapping("/user/supper/admin/count")
	public void getSupperAdminCount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			write(response, null, null, null, userService.getSupperAdminCount(readTree(jsonString, "userId"),readTree(jsonString, "key")));
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 搜索平台用户用于添加平台管理员 user={"key":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/nomal/search")
	public void getNomalUserSearch(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<UserEntity> list = userService.getNomalUserSearch(
					readTree(jsonString, "key"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 搜索平台用户用于添加平台管理员的个数 user={"key":""}
	 */
	@RequestMapping("/user/nomal/search/count")
	public void getNomalUserSearchCount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			write(response, null, null, null, userService.getNomalUserSearchCount(readTree(jsonString, "key")));
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 添加我的一个圈子 user={"userId":"","circleId":1}
	 */
	@RequestMapping("/user/circle/add")
	public void addUserCircle(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserCircle userCircle = new UserCircle();
			userCircle.setCircleId(readTreeAsInt(jsonString, "circleId"));
			userCircle.setCreateTime(new Date());
			userCircle.setUserId(readTree(jsonString, "userId"));
			userService.addUserCircle(userCircle);
			write(response, null, null, null, userCircle);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除我的一个圈子 user={"userCircleId":1}
	 */
	@RequestMapping("/user/circle/delete")
	public void deleteUserCircle(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.deleteUserCircle(readTreeAsInt(jsonString,
					"userCircleId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取我的圈子 user={"userId":""}
	 */
	@RequestMapping("/user/circle/list")
	public void getUserCircleList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object o = userService.getMyCircle(readTree(jsonString, "userId"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取个人主页 user={"userId":"","beenUserId":""}
	 */
	@RequestMapping("/user/face/get")
	public void getUserFace(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object o = userService.updateGetUserFace(
					readTree(jsonString, "userId"),
					readTree(jsonString, "beenUserId"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 关注个人user={"userId":"","beenUserId":""}
	 */
	@RequestMapping("/user/fans/add")
	public void addBeenUserFans(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserFans userFans = stringToObj(jsonString, UserFans.class);
			userFans.setCreateTime(new Date());
			userService.addBeenUserFans(userFans);
			write(response, null, null, null, userFans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 取消关注个人user={"fansId":1}
	 */
	@RequestMapping("/user/fans/delete")
	public void deleteBeenUserFans(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.deleteBeenUserFans(readTreeAsInt(jsonString, "fansId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 收藏课程user={"userId":"","classId":1}
	 */
	@RequestMapping("/user/collect/class/add")
	public void addCollectClass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Collect collect = stringToObj(jsonString, Collect.class);
			collect.setCreateTime(new Date());
			userService.addCollect(collect);
			write(response, null, null, null, collect);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 取消收藏课程user={"collectId":1}
	 */
	@RequestMapping("/user/collect/class/delete")
	public void deleteCollectClass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.deleteCollect(readTreeAsInt(jsonString, "collectId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 机构管理员获取根据名称或手机号搜索不是自己下面的教师user={"institutionId":"6Fk31iKT","key":"","pageNo"
	 * :0,"pageSize":10}
	 */
	@RequestMapping("/user/institution/teacher/search/2_0")
	public void getInstitutionTeacherSearch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getInstitutionTeacherSearch2_0(
					readTree(jsonString, "institutionId"),
					readTree(jsonString, "key"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 机构管理员批量删除自己下面的教师或学生user={"institutionId":"6Fk31iKT","userIds":["",""]}
	 */
	@RequestMapping("/user/institution/user/batch/delete/2_0")
	public void deleteInstitutionTeacherSearchBatch2_0(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<String> teacherIds = jsonToList(
					readTree(jsonString, "userIds"), ArrayList.class,
					String.class);
			userService.deleteInstitutionTeacherSearchBatch2_0(
					readTree(jsonString, "institutionId"), teacherIds);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 机构管理员批量添加教师或学生user={"institutionId":"6Fk31iKT","userIds":["",""]}
	 */
	@RequestMapping("/user/institution/user/batch/add/2_0")
	public void addInstitutionTeacherSearchBatch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<String> teacherIds = jsonToList(
					readTree(jsonString, "userIds"), ArrayList.class,
					String.class);
			userService.addInstitutionTeacherSearchBatch2_0(
					readTree(jsonString, "institutionId"), teacherIds);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 搜索非本机构的学生user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10
	 * }
	 */
	@RequestMapping("/user/institution/student/search/2_0")
	public void getInstitutionStudentSearch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getInstitutionStudentSearch2_0(
					readTree(jsonString, "institutionId"),
					readTree(jsonString, "key"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 机构下的学生user={"institutionId":"6Fk31iKT","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/institution/student/all/2_0")
	public void getInstitutionStudentAll2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getInstitutionStudentAll2_0(
					readTree(jsonString, "institutionId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0学生获取我的机构列表user={"userId":"6Fk31iKT","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/student/my/institution/2_0")
	public void getUserMyInstitution2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getUserMyInstitution2_0(
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0学生搜索我的机构列表user={"userId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/student/my/institution/search/2_0")
	public void getUserMyInstitutionSearch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getUserMyInstitutionSearch2_0(
					readTree(jsonString, "userId"),
					readTree(jsonString, "key"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0学生添加我的机构user={"userId":"6Fk31iKT","institutionIds":["",""]}
	 */
	@RequestMapping("/user/student/my/institution/add/2_0")
	public void addUserMyInstitution2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<String> institutionIds = jsonToList(
					readTree(jsonString, "institutionIds"), ArrayList.class,
					String.class);
			userService.addUserMyInstitution2_0(readTree(jsonString, "userId"),
					institutionIds);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0学生搜索非我的机构列表user={"userId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/student/not/institution/search/2_0")
	public void getUserNotInstitutionSearch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getUserNotInstitutionSearch2_0(
					readTree(jsonString, "userId"),
					readTree(jsonString, "key"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0学生删除我的机构user={"userId":"6Fk31iKT","institutionIds":["",""]}
	 */
	@RequestMapping("/user/student/my/institution/delete/2_0")
	public void deleteUserMyInstitution2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<String> institutionIds = jsonToList(
					readTree(jsonString, "institutionIds"), ArrayList.class,
					String.class);
			userService.deleteUserMyInstitution2_0(
					readTree(jsonString, "userId"), institutionIds);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0我的关注列表user={"userId":"6Fk31iKT"}
	 */
	@RequestMapping("/user/fans/list/2_0")
	public void getUserFansList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object o = userService.getUserFansList2_0(readTree(jsonString,
					"userId"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0我的关注取消关注user={"fansId":1,"type":1}
	 */
	@RequestMapping("/user/fans/delete/2_0")
	public void deleteUserFans2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.deleteUserFans2_0(readTreeAsInt(jsonString, "fansId"),
					readTreeAsInt(jsonString, "type"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0我的收藏列表user={"userId":"6Fk31iKT"}
	 */
	@RequestMapping("/user/collect/list/2_0")
	public void getUserCollectList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object o = userService.getUserCollectList2_0(readTree(jsonString,
					"userId"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0我的取消收藏user={"collectId":1,"type":1}
	 */
	@RequestMapping("/user/collect/delete/2_0")
	public void deleteUserCollectList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			userService.deleteUserCollectList2_0(
					readTreeAsInt(jsonString, "collectId"),
					readTreeAsInt(jsonString, "type"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0查询非好友用户user={"key":"","ids":[""],"pageNo":0,"pageSize":20} 参数是好友id
	 */
	@RequestMapping("/user/unfirend/search/2_0")
	public void getUnfirendSearch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<String> ids = jsonToList(readTree(jsonString, "ids"),
					ArrayList.class, String.class);
			Object o = userService.getUnfirendSearch2_0(
					readTree(jsonString, "key"), ids,page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0查询好友用户user={"key":"","ids":[""]}
	 */
	@RequestMapping("/user/firend/search/2_0")
	public void getFirendSearch2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<String> ids = jsonToList(readTree(jsonString, "ids"),
					ArrayList.class, String.class);
			Object o = userService.getFirendSearch2_0(
					readTree(jsonString, "key"), ids);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0用户添加相册user={"userId":"","urls":[""]}
	 */
	@RequestMapping("/user/photo/add/2_0")
	public void addUserPhoto2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<String> urls = jsonToList(readTree(jsonString, "urls"),
					ArrayList.class, String.class);
			userService.addUserPhoto(urls, readTree(jsonString, "userId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0用户删除相册user=[1,2,3]
	 */
	@RequestMapping("/user/photo/delete/2_0")
	public void deleteUserPhoto2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			List<Integer> ids = jsonToList(jsonString, ArrayList.class,
					Integer.class);
			userService.deleteUserPhoto(ids);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0获取用户相册user={"userId":""}
	 */
	@RequestMapping("/user/photo/list/2_0")
	public void getUserPhotoList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object o = userService.getUserPhotot2_0(readTree(jsonString,
					"userId"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0添加一条咨询记录user={"userId":"","institutionId":""}
	 */
	@RequestMapping("/user/ask/add/2_0")
	public void addUserAsk2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserAsk userAsk = stringToObj(jsonString, UserAsk.class);
			userAsk.setCreateTime(new Date());
			userService.addUserAsk(userAsk);
			write(response, null, null, null, userAsk);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2.0获取咨询记录user={"institutionId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/ask/list/2_0")
	public void getUserAskList2_0(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getUserAskList2_0(
					readTree(jsonString, "institutionId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 添加群图片user={"uid":"","url":}
	 */
	@RequestMapping("/user/group/add")
	public void addUserGroup(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			UserGroup userGroup = stringToObj(jsonString, UserGroup.class);
			userGroup.setCreateTime(new Date());
			userService.addUserGroup(userGroup);
			write(response, null, null, null, userGroup);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取群图片user={"uid":""}
	 */
	@RequestMapping("/user/group/get")
	public void getUserGroup(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Object o = userService.getUserGroup(readTree(jsonString, "uid"));
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 获取平台学生列表user={"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/user/platforms/list")
	public void getplatformsList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = userService.getplatformsList(page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 获取平台学生数量user={}
	 */
	@RequestMapping("/user/platforms/count")
	public void getplatformsCount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			write(response, null, null, null, userService.getplatformsCount());
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 添加平台管理员user={"userId":""}
	 */
	@RequestMapping("/user/platforms/admin/add")
	public void addPlatformsAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			write(response, null, null, null, userService.addPlatformsAdmin(readTree(jsonString, "userId")));
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 删除平台管理员user={"userId":""}
	 */
	@RequestMapping("/user/platforms/admin/delete")
	public void deletePlatformsAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("user");
			logger.info(jsonString);
			write(response, null, null, null, userService.deletePlatformsAdmin(readTree(jsonString, "userId")));
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
