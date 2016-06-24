接口约定及安全操作
1	全局约定：
接口数据形式为JSON格式的数据。http post请求，Content-Type: application/x-www-form-urlencoded
正式环境所有请求带上头：Authorization，值为获取到的token
2	登录注册
2.1	登录
接口名称	登录
接口说明	用户登录。密码采用MD5加密
接口地址	/user/login

图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"phone":"18600084079","password":"123456"}
正常返回：
{"success":true,"code":0,"message":"登录成功","result":
{"id":"KtOOCUHz",用户id
"levelId":2,等级
"type":0,身份（0平台管理员，1机构管理员，2教师，3学生）
"name":"骞冲彴",昵称
"phone":"000",手机号码
"password":"c6f057b86584942e415435ffb1fa93d4",密码
"photo":null,头像
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,地址
"sex":null, 性别（1男，2女）
"birthday":null,生日（long型）
"regionId":null, 地区id（2.0废弃）
"loginDayCount":45,登录天数
"createTime":1454521372000,
"realName":null,真实姓名
"interest":null,兴趣
"shortIntroduction":null简介
}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
	
2.2	验证手机是否存在
接口名称	验证手机是否存在
接口说明	
接口地址	/user/check/phone 
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"phone":"13520383733"}
正常返回：
{"success":true,"code":0,"message":"手机号已注册","result":true}
{"success":false,"code":906,"message":"手机号未注册","result":false}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 


2.3	发送短信验证码
接口名称	发送短信验证码
接口说明	
接口地址	/sms/send 
图片地址	无
参数名称	参数类型	输入/输出	说明
sms	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：sms={"phone":"13552261484","templeteId":"sms_regist_templateId"}
templeteId里的值目前固定传sms_regist_templateId
正常返回：
{"success":true,"code":0,"message":"成功","result":”786251”}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 


2.4	QQ登录
接口名称	QQ登录
接口说明	登录成功返回user bean
接口地址	/user/qq/login 
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"qqOpenId":"18600084079"}
正常返回：
{"success":true,"code":0,"message":"登录成功","result":
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
 }
{"success":false,"code":900,"message":"没有该用户","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
	

2.5	sina登录
接口名称	sina登录
接口说明	登录成功返回user bean
接口地址	/user/sina/login
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"sinaOpenId":"18600084079"}
正常返回：
{"success":true,"code":0,"message":"登录成功","result":
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
 }
{"success":false,"code":900,"message":"没有该用户","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
	
2.6	weixin登录
接口名称	weixin登录
接口说明	登录成功返回user bean
接口地址	/user/weixin/login
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"weixinOpenId":"18600084079"}
正常返回：
{"success":true,"code":0,"message":"登录成功","result":
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
 }
{"success":false,"code":900,"message":"没有该用户","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
	

2.7	QQ绑定
接口名称	QQ绑定
接口说明	
接口地址	/user/qq/bind
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"qqOpenId":"18600084079","id":""}
Id是用户id
正常返回：
{"success":true,"code":0,"message":"绑定成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
	
2.8	sina绑定
接口名称	sina绑定
接口说明	
接口地址	/user/sina/bind
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"sinaOpenId":"18600084079","id":""}
Id是用户id
正常返回：
{"success":true,"code":0,"message":"绑定成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
	
2.9	weixin绑定
接口名称	weixin绑定
接口说明	
接口地址	/user/weixin/bind
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"sinaOpenId":"18600084079","id":""}
Id是用户id
正常返回：
{"success":true,"code":0,"message":"绑定成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
	

2.10	机构注册
接口名称	机构注册
接口说明	
接口地址	/institution/add
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：institution={"name":"","summary":"","phone":"","password":"","regionId":11}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 

2.11	上传机构logo
接口名称	上传机构logo
接口说明	
接口地址	/institution/update/logo
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：institution={"id":"","logo":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":log地址}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 






2.12	个人注册
接口名称	个人注册
接口说明	
接口地址	/user/add
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"phone":"18600084079","password":"123456","type":3}
正常返回：
{"success":true,"code":0,"message":"登录成功","result":
{"id":"KtOOCUHz","levelId":2,"type":0,"name":"骞冲彴","phone":"000",
"password":"c6f057b86584942e415435ffb1fa93d4","photo":null,"qqOpenId":null,
"sinaOpenId":null,"weixinOpenId":null,"address":null,"sex":null,"birthday":null,
"regionId":null,"loginDayCount":45,"createTime":1454521372000,"realName":null,
"interest":null,"shortIntroduction":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 

2.13	修改密码
接口名称	修改密码
接口说明	
接口地址	/user/change/password
图片地址	无
参数名称	参数类型	输入/输出	说明
user	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：user={"phone":"13520383733","password":"hd7fdfdf8dfdf7fd9f"}
正常返回：
{"success":true,"code":0,"message":"登录成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 

2.14	首页获取地区
接口名称	获取地区
接口说明	
接口地址	/region/get
图片地址	无
参数名称	参数类型	输入/输出	说明
region	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：region={"parentId":0}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":1,"name":"北京","location":"116.395645,39.929986","parentId":0}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 

2.15	获取单个地区信息
接口名称	获取单个地区信息
接口说明	
接口地址	/region/id
图片地址	无
参数名称	参数类型	输入/输出	说明
region	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：region={"id":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":1,"name":"北京","location":"116.395645,39.929986","parentId":0}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 
3	亲子活动
3.1	查询亲子活动根据活动id
接口名称	查询亲子活动根据活动id
接口说明	
接口地址	/childActivity/get
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"id":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":25,
"institutionId":null,
"ticketType":null,
"activityType":0,
"title":"活动标题",
"name":"活动名称",
"price":1,
"oldPrice":2,
"saleCount":0,
"thumbImg":"http://egg-cloud-test.oss-cn-beijing.aliyuncs.com/activity/324c2b60c5224cf5a861a25ce7a48617.jpg",
"adverImg":"http://egg-cloud-test.oss-cn-beijing.aliyuncs.com/activity/324c2b60c5224cf5a861a25ce7a48617.jpg",
"shortDetail":"活动简介",
"detail":"活动详细",
"url":null,
"shareCount":0, 被分享数量
"loveCount":0,被点赞次数
"commentCount":0,收藏次数
"createTime":1453420800000,
"beginDate":1453420800000,开始时间
"endDate":1453680000000,结束时间
"reserveBeginDate":1453766400000,预约开始时间
"reserveEndDate":1453852800000,预约结束时间
"activityCollectId":null,收藏id
"activityLoveId":null,点赞id
"activityReserveId":null报名id
}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 


3.2	获得全部的亲子活动列表
接口名称	获得全部的亲子活动列表
接口说明	
接口地址	/childActivity/list
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":
[{"id":29,
"institutionId":null,
"ticketType":null,
"activityType":0,
"title":"",
"name":"小马采摘园",
"price":800,
"oldPrice":100,
"saleCount":0,
"thumbImg":"http://egg-cloud-test.oss-cn-beijing.aliyuncs.com/activity/0d7dac24c7aa415ba9850c3188e699aa.jpg","adverImg":"http://egg-cloud-test.oss-cn-beijing.aliyuncs.com/activity/0d7dac24c7aa415ba9850c3188e699aa.jpg",
"shortDetail":"免费楼",
"detail":null,
"url":null,
"shareCount":0,
"loveCount":0,
"commentCount":0,
"createTime":null,
"beginDate":null,
"endDate":null,
"reserveBeginDate":null,
"reserveEndDate":null,
"activityCollectId":null,
"activityLoveId":null,
"activityReserveId":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : null} 

3.3	亲子活动-是否已报名亲子活动
接口名称	亲子活动-是否已报名亲子活动
接口说明	
接口地址	/childActivity/isReserveChildActivity
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"childActivityId":1,"userId":"2"}
正常返回：
{"success":true,"code":0,"message":"成功","result":true}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.4	亲子活动-预约报名
接口名称	亲子活动-预约报名
接口说明	
接口地址	/childActivity/reserve
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"childActivityId":1,"userId":"1","reserveCount":10,"realname":"王二","phone":"12345678901","price":总价}
正常返回：(此处问金帅，他写的)
{"success":true,"code":0,"message":"成功","result":{"id":null,
"orderNumber":null,
"childActivityId":null,
"userId":null,
"realname":null,
"phone":null,
"reserveCount":null,
"price":null,
"state":null,
"cancelCode":null,
"cancelRemark":null,
"createTime":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.5	亲子活动-修改亲子活动报名
接口名称	亲子活动-修改亲子活动报名
接口说明	
接口地址	/childActivity/updateReservationInfo
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"id":3,"realName":"","phone":"13655161319"
	 * ,"price":33,"reserveCount":3}
正常返回：(此处问金帅，他写的)
{"success":true,"code":0,"message":"成功","result":}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.6	亲子活动-预约报名删除
接口名称	亲子活动-预约报名删除
接口说明	
接口地址	/childActivity/cancelReservation
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"id":12,"cancelCode":2,"cancelRemark"："用户自定义取消原因"}
正常返回：(此处问金帅，他写的)
{"success":true,"code":0,"message":"成功","result":}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.7	亲子活动-预约报名查询接口，根据活动id
接口名称	亲子活动-预约报名查询接口，根据活动id
接口说明	
接口地址	/childActivity/listReservation/childActivity
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"childActivityId":1,"pageNo":0,"pageSize":10}
正常返回：(此处问金帅，他写的)
{"success":true,"code":0,"message":"成功","result":[{"id":null,"orderNumber":null,"childActivityId":null,"userId":null,"realname":null,"phone":null,"reserveCount":null,"price":null,"state":null,"cancelCode":null,"cancelRemark":null,"createTime":null}]
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.8	亲子活动-预约报名查询接口，根据用户id
接口名称	亲子活动-预约报名查询接口，根据用户id
接口说明	
接口地址	/childActivity/listReservation/user
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"userId":1,"pageNo":0,"pageSize":10}
正常返回：(此处问金帅，他写的)
{"success":true,"code":0,"message":"成功","result":[{"id":null,"orderNumber":null,"childActivityId":null,"userId":null,"realname":null,"phone":null,"reserveCount":null,"price":null,"state":null,"cancelCode":null,"cancelRemark":null,"createTime":null}]
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


3.9	亲子活动-预约报名详情查询接口，根据id
接口名称	亲子活动-预约报名详情查询接口，根据id
接口说明	
接口地址	/childActivity/reservationDetail
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"id":1}
正常返回：(此处问金帅，他写的)
{"success":true,"code":0,"message":"成功","result":{"id":null,"orderNumber":null,"childActivityId":null,"userId":null,"realname":null,"phone":null,"reserveCount":null,"price":null,"state":null,"cancelCode":null,"cancelRemark":null,"createTime":null}
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.10	获得全部取消原因
接口名称	获得全部取消原因
接口说明	
接口地址	/childActivity/getAllCancelReason
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={}
正常返回：(此处问金帅，他写的)
{"success":true,"code":0,"message":"成功","result":[{"id":null,"name":null,"state":null,"createTime":null}]
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
3.11	亲子活动-收藏活动
接口名称	亲子活动-收藏活动
接口说明	
接口地址	/childActivity/collect/add
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"userId":"","activityId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,收藏id
"userId":null,
"activityId":null,
"createTime":null}
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
3.12	亲子活动-评论活动
接口名称	亲子活动-评论活动
接口说明	
接口地址	/childActivity/comment/add
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"userId":"","activityId":1,"context":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.13	取消收藏此活动
接口名称	取消收藏此活动
接口说明	
接口地址	/childActivity/collect/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"activityCollectId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.14	获取活动的评论
接口名称	获取活动的评论
接口说明	
接口地址	/childActivity/comment/list
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"activityId":1,"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,评论id
"userId":null,
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"context":null,
"isPublic":true,是否公开
"isOriginal":true,
"parentId":null,如果这个评论是对评论A的评论，此处为评论A的id
"voidePaths":null,评论视频的路径，支持多个
"imagePaths":null,评论图片路径,支持多个
"commentChilds":null,下级评论列表
"loveCount":0,此评论的点赞次数
"commentCount":0,此评论的评论次数
"createTime":null,
"myloveId":null,当前用户对此评论的点赞id
"public":true,
"original":true
}
]}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
3.15	对活动点赞
接口名称	对活动点赞
接口说明	
接口地址	/childActivity/love/add
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"activityId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"userId":null,"activityId":null,"createTime":null}
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.16	取消对活动点赞
接口名称	取消对活动点赞
接口说明	
接口地址	/childActivity/love/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"activityId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.17	增加活动咨询
接口名称	增加活动咨询
接口说明	
接口地址	/childActivity/ask/add
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"activityId":1,"userId":"","context":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"userId":null,"userName":null,"userPhoto":null,"sex":0,"context":null,"activityId":null,"createTime":null,"answer":null}
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.18	查询活动咨询
接口名称	查询活动咨询
接口说明	
接口地址	/childActivity/my/ask/list
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"activityId":1,"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"userId":null,
"userName":null,
"userPhoto":null,
"sex":0,
"context":null,
"activityId":null,
"createTime":null,
"answer":null管理员的回复是一个对象,同它
}]
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


3.19	删除单个活动咨询
接口名称	删除活动咨询
接口说明	
接口地址	/childActivity/my/ask/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"askId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

3.20	删除某个人对某个活动的全部活动咨询
接口名称	删除某个人对某个活动的全部活动咨询
接口说明	
接口地址	/childActivity/my/ask/all/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
childActivity	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：childActivity={"userId":"","activityId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

4	评论
4.1	获取下级评论列表
接口名称	获取下级评论列表
接口说明	
接口地址	/comment/child/list
图片地址	无
参数名称	参数类型	输入/输出	说明
comment	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：comment={"id":1,"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,评论id
"userId":null,
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"context":null,
"isPublic":true,是否公开
"isOriginal":true,
"parentId":null,如果这个评论是对评论A的评论，此处为评论A的id
"voidePaths":null,评论视频的路径，支持多个
"imagePaths":null,评论图片路径,支持多个
"commentChilds":null,下级评论列表
"loveCount":0,此评论的点赞次数
"commentCount":0,此评论的评论次数
"createTime":null,
"myloveId":null,当前用户对此评论的点赞id
"public":true,
"original":true
}
]}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

4.2	对评论进行评论
接口名称	增加一条下级评论
接口说明	
接口地址	/comment/child/add
图片地址	无
参数名称	参数类型	输入/输出	说明
comment	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：comment={"parentId":1,"userId":"","context":"内容","isPublic":true,
"videoPaths":["",""],"imagePaths":["",""]}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,
"userId":null,
"context":null,
"isPublic":true,
"isOriginal":true,
"parentId":null,
"createTime":null}}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

4.3	点赞一条评论

接口名称	点赞一条评论
接口说明	
接口地址	/comment/love/add
图片地址	无
参数名称	参数类型	输入/输出	说明
comment	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：comment={"commentId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,"userId":null,"commentId":null,"createTime":null}}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

4.4	取消点赞一条评论
接口名称	取消点赞一条评论
接口说明	
接口地址	/comment/love/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
comment	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：comment={"commentId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
4.5	获取跟评
接口名称	获取跟评
接口说明	
接口地址	/comment/child/get
图片地址	无
参数名称	参数类型	输入/输出	说明
comment	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：comment={"commentId":1,"pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"sendUserId":null,
"senderName":null,
"receiveName":null,
"context":null,
"createTime":null}]}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

4.6	删除评论
接口名称	删除评论,只有自己的评论才可以删除
接口说明	
接口地址	/comment/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
comment	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：comment={"id":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 



4.7	获取评论详情
接口名称	获取评论详情
接口说明	
接口地址	/comment/detail
图片地址	无
参数名称	参数类型	输入/输出	说明
comment	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：comment={"id":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,
"userId":null,
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"context":null,
"isPublic":true,
"isOriginal":true,
"parentId":null,
"voidePaths":null,
"imagePaths":null,
"commentChilds":null,
"loveCount":0,
"commentCount":0,
"createTime":null,
"myloveId":null,"public":true,"original":true}

}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
5	最新资讯
5.1	获取最新资讯
接口名称	获取最新资讯
接口说明	
接口地址	/information/list
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":null,"userId":null,"title":null,"context":null,"createTime":null,"loveCount":0,"collectCount":0,"commentCount":0,"loveId":null,"collectId":null,"imgUrls":null}]
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.2	查看资讯详情
接口名称	查看资讯详情
接口说明	
接口地址	/information/get
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"userId":"","infoId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"userId":null,"title":null,"context":null,"createTime":null,"loveCount":0,"collectCount":0,"commentCount":0,"loveId":null,"collectId":null,"imgUrls":null}
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.3	资讯点赞
接口名称	资讯点赞
接口说明	
接口地址	/information/love/add
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"userId":"","infoId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.4	资讯取消点赞
接口名称	资讯取消点赞
接口说明	
接口地址	/information/love/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"userId":"","infoId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.5	收藏资讯
接口名称	收藏资讯
接口说明	
接口地址	/information/collect/add
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"userId":"","infoId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.6	取消收藏资讯
接口名称	取消收藏资讯
接口说明	
接口地址	/information/collect/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"userId":"","infoId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.7	评论资讯
接口名称	评论资讯
接口说明	
接口地址	/information/comment/add
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"userId":"","infoId":1,"context":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.8	删除评论资讯
接口名称	删除评论资讯
接口说明	
接口地址	/information/comment/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"infoId":1,"commentId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

5.9	获取资讯评论列表
接口名称	获取评论列表
接口说明	
接口地址	/information/comment/list
图片地址	无
参数名称	参数类型	输入/输出	说明
information	string	输入	不能为空。
返回值	String	输出	统一格式
接口描述	请求：information={"infoId":1,"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{上面有}]
}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
6	轮播图
6.1	获取轮播图列表
接口名称	获取轮播图列表
接口说明	
接口地址	/carousel/list
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Void	输入	无参数
返回值	String	输出	Json格式
接口描述	请求：carousel={}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":89,
"path":"http://egg-cloud-test.oss-cn-beijing.aliyuncs.com/carousel/1464338287537.jpg",
"val":"", 预留字段
"title":null, 
"context":"呵呵", 轮播图描述
"institutionName":null,  预留字段
"createTime":1464338293000}] }  
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

6.2	获取轮播图详情
接口名称	获取轮播图详情
接口说明	
接口地址	/carousel/get
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Integer	输入	轮播图id
返回值	String	输出	Json格式
接口描述	请求：carousel={"id":38}
正常返回：
{"success":true,"code":0,"message":"成功","result":{
"id":38,
"path":"http://egg-cloud-test.oss-cn-beijing.aliyuncs.com/carousel/1464338206839.jpg",
"val":"",
"title":null,
"context":"傻逼",
"institutionName":null,
"createTime":1454564741000,
"commentCount":2,  （对轮播图，下同）评论数
"loveCount":2, 点赞数
"loveId":null,  点赞id（不为null则表示已点赞，下同）
"collectId":null  收藏的id
}} 
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

6.3	获取轮播图评论列表
接口名称	获取轮播图评论列表
接口说明	
接口地址	/carousel/comment/list
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Integer	输入	轮播图id，页数、页容量
返回值	String	输出	Json格式
接口描述	请求：carousel={"carouselId":38,"pageNo":0,"pageSize":20}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":228,"
userId":"UrV7ZuSw","userLevelId":"2","userName":"赵大爷","userPhoto":"/image/photo/1461823745729.jpg","sex":null,
"context":"呵呵","isPublic":true,"isOriginal":false,"parentId":null,
"voidePaths":[],"imagePaths":[],
"commentChilds":[{"id":229,
"sendUserId":"hADbBd00","senderName":"林蛋大","receiveName":"赵大爷","context":"狗","createTime":1464602944000}],
"loveCount":0,  点赞数，针对本条评论
"commentCount":1, 评论数
"createTime":1464602894000,
"myloveId":null,  本人点赞id，针对本条评论，注意区别于轮播图里的loveId
"original":false,"public":true}]}
（说明：commentChilds字段是跟评列表，其中sendXXX字段是跟评者，receiveXXX是被跟评者）
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

6.4	 对轮播图评论
接口名称	对轮播图评论
接口说明	
接口地址	/carousel/comment/add
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Integer\String	输入	轮播图id，用户id，评论内容
返回值	String	输出	Json格式
接口描述	请求：carousel={"carouselId":38,"userId":"DVfuDmQS","context":"鸡鸡"}
正常返回：{"success":true,"code":0,"message":"成功","result":null} {"success":true,"code":0,"message":"成功","result":null}
（说明：评论后需要reload列表，更新相关数据）
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


6.5	收藏轮播图
接口名称	收藏轮播图
接口说明	
接口地址	/carousel/collect/add
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Integer\String	输入	轮播图id，用户id 
返回值	String	输出	Json格式
接口描述	请求：carousel={"carouselId":38,"userId":"DVfuDmQS"}  
正常返回：{"success":true,"code":0,"message":"成功","result":{"id":20,"userId":"DVfuDmQS","carouselId":38,"createTime":1465304709291}}  
（说明： 返回的id即轮播图详情中的collectId，在取消收藏时用到）
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


6.6	取消收藏轮播图
接口名称	取消收藏轮播图
接口说明	
接口地址	/carousel/collect/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Integer\String	输入	轮播图id，用户id 
返回值	String	输出	Json格式
接口描述	请求：carousel={"carouselId":38,"userId":"DVfuDmQS"}  
正常返回：{"success":true,"code":0,"message":"成功","result":null}
（说明： 自行将collectId设置成null）
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	



6.7	点赞轮播图
接口名称	点赞轮播图
接口说明	
接口地址	/carousel/love/add
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Integer\String	输入	轮播图id，用户id 
返回值	String	输出	Json格式
接口描述	请求：carousel={"carouselId":38,"userId":"DVfuDmQS"}  
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":40,"userId":"DVfuDmQS","carouselId":38,"createTime":1465305562533}}
（说明： 操作同收藏）
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

6.8	取消点赞轮播图
接口名称	取消点赞轮播图
接口说明	
接口地址	/carousel/love/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
carousel	Integer\String	输入	轮播图id，用户id 
返回值	String	输出	Json格式
接口描述	请求：carousel={"carouselId":38,"userId":"DVfuDmQS"}  
正常返回：{"success":true,"code":0,"message":"成功","result":null}
（说明： 自行将loveId设置成null）
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7	机构信息
7.1	上传机构主页图片
接口名称	上传机构主页图片
接口说明	
接口地址	/institution/update/face
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"id":"","face":""}  
正常返回：{"success":true,"code":0,"message":"成功","result":”地址”}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

机构基本信息维护
接口名称	机构基本信息维护
接口说明	
接口地址	/institution/update/info
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	修改哪个字段传哪个，可以都传
返回值	String	输出	Json格式
接口描述	请求：institution={"id":"","name":"","summary":"","address":"","tel":"" ,"parentId":"" ,"regionId":1,"logo":"","courseType":"","teacherCount":0} 
正常返回：{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.2	获取机构列表(更多机构)
接口名称	获取机构列表
接口说明	
接口地址	/institution/list
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"regionId":1,"pageNo":0,"pageSize":10}
reginId传的是省份id也就是1级地址id,例如北京，上海，安徽的id,也可以不传
正常返回：{"success":true,"code":0,"message":"成功","result":
{"id":null,
"name":null,
"summary":null,
"logo":null,
"face":null,主页图片
"tel":null,
"address":null,
"parentId":null,父机构id
"regionId":null,
"propaCount":0,相片数量
"commentCount":0,
"courseName":null,不用管
"createTime":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.3	增加机构相册
接口名称	增加机构相册
接口说明	
接口地址	/propa/add
图片地址	无
参数名称	参数类型	输入/输出	说明
propa	String	输入	不能为空propagate为相册路径
返回值	String	输出	Json格式
接口描述	请求： propa={"institutionId":"","title":"","propagate":""}
正常返回：{"success":true,"code":0,"message":"成功","result":
{"id":null,"institutionId":null,"title":null,"propagate":null,"createTime":null} }
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.4	修改机构相册
接口名称	修改机构相册
接口说明	
接口地址	/propa/update
图片地址	无
参数名称	参数类型	输入/输出	说明
propa	String	输入	不能为空propagate为相册路径
返回值	String	输出	Json格式
接口描述	请求： propa={"id":1,"title":"","propagate":""}
正常返回：{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.5	删除机构相册
接口名称	删除机构相册
接口说明	
接口地址	/propa/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
propa	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求： propa={"id":1}
正常返回：{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.6	获取机构相册列表
接口名称	获取机构相册列表
接口说明	
接口地址	/propa/list
图片地址	无
参数名称	参数类型	输入/输出	说明
propa	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求: propa={"institutionId":"","pageNo":0,"pageSize":10}
正常返回：{"success":true,"code":0,"message":"成功","result":[ {"id":null,"institutionId":null,"title":null,"propagate":null,"createTime":null}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.7	机构主页
接口名称	机构主页
接口说明	
接口地址	/institution/face/get
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求: institution={"institutionId":"","userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,
"name":null,
"fatherInstitution":null,
"summary":null,
"logo":null,
"face":null,
"tel":null,
"address":null,
"parentId":null,
"regionId":null,
"createTime":null,
"visitCount":0,访问量
"commentCount":0,
"fansCount":0,粉丝数
"loveCount":0,点赞数
"fansId":null,粉丝id
"loveId":null,点赞id
"courseName":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


7.8	获取机构评论列表
接口名称	获取机构评论列表
接口说明	
接口地址	/institution/comment/list
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":所有评论列表都是一样，如上}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


7.9	对机构点赞
接口名称	对机构点赞
接口说明	
接口地址	/institution/love/add
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"InstitutionId":null,"userId":null,"createTime":null,"institutionId":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.10	取消机构点赞
接口名称	取消机构点赞
接口说明	
接口地址	/institution/love/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"loveId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


7.11	关注机构
接口名称	关注机构
接口说明	
接口地址	/institution/fans/add
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"institutionId":null,"userId":null,"createTime":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.12	取消关注机构
接口名称	取消关注机构
接口说明	
接口地址	/institution/fans/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"fansId":11}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.13	上传机构logo
接口名称	上传机构logo
接口说明	
接口地址	/institution/update/logo
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"id":"","logo":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":logo路径}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
7.14	机构基本信息维护
接口名称	机构基本信息维护
接口说明	
接口地址	/institution/update/info
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"id":"","name":"","summary":"","address":"","tel":"","parentId":"" ,"regionId":1,"logo":"","courseType":"","teacherCount":0,"sign":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
7.15	机构所属管理员
接口名称	机构所属管理员
接口说明	
接口地址	/institution/manager/list
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","key":""}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":
[{"id":null,
"levelId":null,
"type":null,0:平台管理员,1:机构管理员,2:老师，3：学生
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,登录多少天
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


7.16	机构所属非管理员用户
接口名称	机构所属非管理员用户
接口说明	
接口地址	/institution/unmanager/list
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","key":""}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":
[{"id":null,
"levelId":null,
"type":null,0:平台管理员,1:机构管理员,2:老师，3：学生
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,登录多少天
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
7.17	添加管理员
接口名称	添加管理员
接口说明	
接口地址	/institution/manager/batch/add
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","userIds":[“”]}
userIds用户id集合
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.18	删除管理员
接口名称	删除管理员
接口说明	
接口地址	/institution/manager/batch/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","userIds":[“”]}
userIds用户id集合
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


7.19	机构获取下面的教师
接口名称	机构获取下面的教师
接口说明	返回用户bean
接口地址	/user/manage/teacher/search
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.20	机构获取不是自己下面的教师
接口名称	机构获取不是自己下面的教师
接口说明	返回用户bean
接口地址	/user/institution/teacher/search/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.21	机构管理员批量添加教师
接口名称	机构管理员批量添加教师
接口说明	
接口地址	/user/institution/user/batch/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"institutionId":"6Fk31iKT","userIds":["",""]}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.22	机构管理员批量删除教师
接口名称	机构批量删除自己下面的教师
接口说明	
接口地址	/user/institution/user/batch/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"institutionId":"6Fk31iKT","userIds":["",""]}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

7.23	报名管理
接口名称	报名管理
接口说明	
接口地址	/course/class/order/manage/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"institutionId":"","date":12132444400}
Date默认今天
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,报名id
"code":null,编码
"classId":null,课程id
"className":null,
"userId":null,报名用户
"userName":null,
"userPhone":null,
"userPhoto":null,
"institutionId":null,所属机构
"institutionName":null,
"userCount":1,报名时填的人数
"price":null,报名时的价格
"createTime":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

8	机构管理
8.1	获取机构课程列表
接口名称	获取机构课程列表
接口说明	
接口地址	/course/class/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"institutionId":"","date":1232310000,"pageNo":0,"pageSize":10}
date可以不传默认是今天
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"cover":null,封面图片
"name":null,
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"userId":null,老师id
"userName":null,
"planCount":0,计划上课次数
"studentCount":0,计划学生人数
"price":null,价格
"institutionName":null,
"imgUrls":null //这里此参数无用
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
8.2	机构获取下面的学生
接口名称	机构获取下面的学生
接口说明	
接口地址	/user/manage/student/search
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


9	帖子相关
9.1	机构动态列表
接口名称	机构动态列表
接口说明	
接口地址	/community/institution/post/list
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"institutionId":"","userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":{“count”:0,”posts”:[{"id":null,
"userId":null,管理员的信息
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"circleId":null,圈子id
"context":null,
"type":null, 帖子类型:1-公开,2朋友圈可见,3自己可见
"topicId":null,话题id
"createTime":null,
"loveCount":0,点赞次数
"collectCount":0,收藏次数
"commentCount":0,评论次数
"loveId":null,
"collectId":null,
"imgUrls":null,帖子里的图片
"voideUrls":null}帖子里的视屏
]}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

9.2	机构圈子列表
接口名称	机构圈子列表
接口说明	
接口地址	/community/institution/circle/post/list
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"institutionId":"","userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":{“count”:0,”posts”:[{"id":null,
"userId":null,管理员的信息
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"circleId":null,圈子id
"context":null,
"type":null, 帖子类型:1-公开,2朋友圈可见,3自己可见
"topicId":null,话题id
"createTime":null,
"loveCount":0,点赞次数
"collectCount":0,收藏次数
"commentCount":0,评论次数
"loveId":null,
"collectId":null,
"imgUrls":null,帖子里的图片
"voideUrls":null}帖子里的视屏
]}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
9.3	帖子详情
接口名称	帖子详情
接口说明	
接口地址	/community/post/detail
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"userId":"","postId":0}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,
"userId":null,发帖人
"userLevelId":null,
"userName":null
,"userPhoto":null,
"sex":null,
"circleId":null
,"context":null,
"type":null,
"topicId":null,
"createTime":null,
"loveCount":0,
"collectCount":0,
"commentCount":0,
"loveId":null,
"collectId":null,
"imgUrls":null,复数
"voideUrls":null}复数

}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
9.4	帖子增加评论
接口名称	帖子增加评论
接口说明	
接口地址	/community/post/comment/add
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"userId":"","postId":0,"context":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null

}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
9.5	获取帖子评论列表
接口名称	获取帖子评论列表
接口说明	
接口地址	/community/post/comment/list
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"userId":"","postId":1,"pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":如上
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
9.6	点赞一个帖子
接口名称	点赞一个帖子
接口说明	
接口地址	/community/post/love/add
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"postId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"postId":null,"userId":null,"createTime":null}
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
9.7	取消点赞一个帖子
接口名称	取消点赞一个帖子
接口说明	
接口地址	/community/post/love/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"postLoveId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
9.8	收藏一个帖子
接口名称	收藏一个帖子
接口说明	
接口地址	/community/post/collect/add
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"postId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"userId":null,"postId":null,"createTime":null}
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
9.9	取消收藏一个帖子
接口名称	取消收藏一个帖子
接口说明	
接口地址	/community/post/collect/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"postCollectId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	



9.10	热门的帖子列表
接口名称	热门的帖子列表
接口说明	
接口地址	/community/post/activity/list
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"userId":null,
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"circleId":null,圈子id
"context":null,
"type":null, 帖子类型:1-公开,2朋友圈可见,3自己可见
"topicId":null,
"createTime":null,
"loveCount":0,
"collectCount":0,
"commentCount":0,
"loveId":null,
"collectId":null,
"imgUrls":[“”],
"voideUrls":[“”]}
]
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


9.11	圈子里帖子列表
接口名称	圈子里帖子列表
接口说明	
接口地址	/community/post/circle/list
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"circleId":1,"userId":"","pageNo":0,"pageSize":10}
circleId圈子id
页面圈子列表是写死的，全部是0，其他一次递增
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"userId":null,
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"circleId":null,圈子id
"context":null,
"type":null, 帖子类型:1-公开,2朋友圈可见,3自己可见
"topicId":null,
"createTime":null,
"loveCount":0,
"collectCount":0,
"commentCount":0,
"loveId":null,
"collectId":null,
"imgUrls":[“”],
"voideUrls":[“”]}
]
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

9.12	发布帖子
接口名称	发布帖子
接口说明	
接口地址	/community/post/add
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"userId":"","circleId":1,"context":"","type":"","topicId":"","imgUrls":["www.aaa.com","www.bbb.com"],"voideUrls":["www.ccc.com","www.ccc.com"]}
circleId圈子id
页面圈子列表是写死的，全部是0，其他一次递增
正常返回：
{"success":true,"code":0,"message":"成功","result": 
{"id":null,帖子id
"userId":null,
"circleId":null,
"context":null,
"type":null,
"topicId":null,
"createTime":null}

}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

9.13	删除一个帖子
接口名称	删除一个帖子
接口说明	
接口地址	/community/post/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"id":1}
Id帖子id
正常返回：
{"success":true,"code":0,"message":"成功","result": 
{"id":null,帖子id
"userId":null,
"circleId":null,
"context":null,
"type":null,
"topicId":null,
"createTime":null}

}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

9.14	个人帖子列表（最新动态）
接口名称	个人帖子列表
接口说明	
接口地址	/community/user/post/list
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"visitorId":"","userId":"","pageNo":0,"pageSize":10}
visitorId:当前登录用户id
userId：帖子所属用户id
正常返回：
{"success":true,"code":0,"message":"成功","result": {“count”:0,”posts”:[{"id":null,
"userId":null,管理员的信息
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"circleId":null,圈子id
"context":null,
"type":null, 帖子类型:1-公开,2朋友圈可见,3自己可见
"topicId":null,话题id
"createTime":null,
"loveCount":0,点赞次数
"collectCount":0,收藏次数
"commentCount":0,评论次数
"loveId":null,
"collectId":null,
"imgUrls":null,帖子里的图片
"voideUrls":null}帖子里的视屏
]}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

9.15	个人主页圈子
接口名称	个人主页圈子
接口说明	
接口地址	/community/user/circle/post/list
图片地址	无
参数名称	参数类型	输入/输出	说明
community	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：community={"visitorId":"","userId":"","pageNo":0,"pageSize":10}
visitorId:当前登录用户id
userId：帖子所属用户id
正常返回：
{"success":true,"code":0,"message":"成功","result":{“count”:0,”posts”:[{"id":null,
"userId":null,管理员的信息
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"circleId":null,圈子id
"context":null,
"type":null, 帖子类型:1-公开,2朋友圈可见,3自己可见
"topicId":null,话题id
"createTime":null,
"loveCount":0,点赞次数
"collectCount":0,收藏次数
"commentCount":0,评论次数
"loveId":null,
"collectId":null,
"imgUrls":null,帖子里的图片
"voideUrls":null}帖子里的视屏
]}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


10	机构主页课程
10.1	获取机构课程列表
接口名称	获取机构课程列表
接口说明	
接口地址	/course/class/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"institutionId":"","date":1232310000,"pageNo":0,"pageSize":10}
date可以不传
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"cover":null,课程封面
"name":null,
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"userId":null,老师id
"userName":null,老师名字
"planCount":0,上课次数
"studentCount":0,计划学生数量
"price":null,
"institutionName":null,机构名称
"imgUrls":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
11	课程相关
11.1	获取课程详情
接口名称	获取课程详情
接口说明	
接口地址	/course/class/info/get/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,
"cover":null,封面图片
"institutionId":null,
"courseTypeId":null,
"courseId":null,
"userId":null,老师id
"userName":null,老师名称
"userPhoto":null,
"institutionName":null,
"interest":null,
"shortIntroduction":null,
"name":null,
"summary":null,
"price":null,
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"address":null,
"studentCount":0,
"signCount":0,签到次数
"planCount":0,
"createTime":null,
"collectId":null,
"imgUrls":null,
"commentCount":0,
"loveCount":0,
"loveId":null,
"fansId":null}
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

11.2	评论课程
接口名称	评论课程
接口说明	
接口地址	/course/class/comment/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":1,"userId":"","context":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
11.3	删除课程评论
接口名称	删除课程评论
接口说明	
接口地址	/course/class/comment/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":1,"commentId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
11.4	课程评论列表
接口名称	课程评论列表
接口说明	
接口地址	/course/class/comment/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":1,"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":如上}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
11.5	点赞课程
接口名称	点赞课程
接口说明	
接口地址	/course/class/love/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":1,"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"classId":null,"userId":null,"createTime":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

11.6	课程类型列表
接口名称	课程类型列表
接口说明	
接口地址	/course/class/type/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,一级类别id
"name":null,
"courses":[
{"id":null,二级类别id
"name":null}
]
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

11.7	根据类型查询课程列表
接口名称	根据类型查询课程列表
接口说明	
接口地址	/course/class/list/by/type/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"regionId":2,"courseId":1,"pageNo":0,"pageSize":10}
regionId传的是省份id也就是1级地址id,可以不传
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,课程id
"cover":null, 课程封面
"name":null, 课程名称
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"userId":null,老师id
"userName":null
,"planCount":0,
"studentCount":0,
"price":null,
"institutionName":null,
"imgUrls":[]
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


11.8	取消点赞课程
接口名称	取消点赞课程
接口说明	
接口地址	/course/class/love/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"loveId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
11.9	收藏课程
接口名称	收藏课程
接口说明	
接口地址	/course/class/fans/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":1,"userId":"}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":null,"classId":null,"userId":null,"createTime":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
11.10	取消收藏课程
接口名称	取消收藏课程
接口说明	
接口地址	/course/class/fans/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"fansId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
11.11	课程报名
接口名称	课程报名
接口说明	
接口地址	/course/class/order/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"code":"","userId":"","userName":"","userPhone":"","institutionId":"","institutionName":"","classId":1,"classNmae":"","price":20.00,"userCount":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,报名id 
"code":null,字段基本是报名时候填的数据
"classId":null,
"className":null,
"userId":null,
"userName":null,
"userPhone":null,
"userPhoto":null,
"institutionId":null,
"institutionName":null,
"userCount":1,
"price":null,
"createTime":null}
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
12	分支机构
12.1	分机构列表
接口名称	分机构列表
接口说明	
接口地址	/institution/child/list
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","key":""}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":
[{"institutionId":null,"institutionName":null,"courseType":null,"logo":null,"address":null}]
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
12.2	获取非分机构列表
接口名称	获取非分机构列表
接口说明	
接口地址	/institution/unchild/list
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","key":""}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":
[{"institutionId":null,"institutionName":null,"courseType":null,"logo":null,"address":null}]
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
12.3	添加分机构
接口名称	添加分机构
接口说明	
接口地址	/institution/child/batch/add
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","children":["",""]}
Children分机构id
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	
12.4	删除分机构
接口名称	删除分机构
接口说明	
接口地址	/institution/child/batch/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
institution	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：institution={"institutionId":"","children":["",""]}
Children分机构id
正常返回：
{"success":true,"code":0,"message":"成功","result":null
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

13	阿里云oss
13.1	获取oss签名
接口名称	获取oss签名
接口说明	
接口地址	/oss/sign
图片地址	无
参数名称	参数类型	输入/输出	说明
oss	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：oss={"content":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":签名}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

14	首页搜索
14.1	首页搜索
接口名称	/search
接口说明	
接口地址	/search
图片地址	无
参数名称	参数类型	输入/输出	说明
search	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：search={"userId":"","key":"","type":2,"pageNo":0,"pageSize":20}
单独搜课程type传2,此参数可以不传
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"type":null,//1: 机构，2:课程 ，3：帖子，4：活动,5:好友
"institutionId":null,机构id
"institutionName":null,机构名称
"institutionLogo":null,机构logo
"institutionCourseType":null,机构的一个属性
"institutionCommentCount":0,机构评论次数
"institutionAddress":null,机构地址
"classId":null,课程id
"classCover":null,课程图片
"className":null,课程名称
"classPlanCount":null,课程属性上课次数
"classStudentCount":null,课程里计划学生人数
"classStartDate":null,课程开始日期
"classEndDate":null,课程结束日期
"classStartTime":null,课程开始时间
"classEndTime":null,课程结束时间
"classTeacherName":null,课程老师名称
"classPrice":null,课程价格
"activityId":null,活动id
"activityAdverImg":null,活动图片
"activityTitle":null,活动标题
"activityOldPrice":null,活动老价格
"activityPrice":null,活动价格
"activitySaleCount":null,活动已卖
"postId":null,帖子id
"postUserPhoto":null,发帖人照片
"postUserSex":null,
"postCreateTime":null,发帖时间
"postContext":null,
"postUserName":null,
"postImgUrls":[“”],
"postLoveCount":0,帖子点赞次数
"postCollectCount":0,帖子收藏次数
"postCommentCount":0, 帖子评论次数
"postLoveId":null,帖子点赞id
"postCollectId":null,帖子收藏id
"friendId":null,
"friendPhoto":null,
"friendName":null,
"friendPhone":null,
"friendSex":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

15	数据统计
15.1	机构老师考勤统计
接口名称	机构老师考勤统计
接口说明	
接口地址	/census/timing/user/list
图片地址	无
参数名称	参数类型	输入/输出	说明
census	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：census={"institutionId":"","date":178465211000,"pageNo":0,"pageSize":10}
date必传,默认传今天
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"userId":null,老师id
"name":null,老师名称
"phone":null,老师手机号
"photo":null,老师照片
"signCount":0签到次数
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

15.2	机构获取老师当日签到记录
接口名称	机构获取老师当日签到记录
接口说明	
接口地址	/psign/teacher/plan/today/sign/list
图片地址	无
参数名称	参数类型	输入/输出	说明
psign	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：psign={"userId":"","date":1213323200000}
date非必传,默认传今天
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"institutionId":null,
"institutionName":null,
"logo":null,
"type":null,  字符串,上午:before,下午:after
"address":null,签到地址
"createTime":null 签到时间
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

15.3	机构获取下面的学生
接口名称	机构获取下面的学生
接口说明	
接口地址	/user/manage/student/search
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"institutionId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
key非必传,用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"institutionId":null,
"institutionName":null,
"logo":null,
"type":null,  字符串,上午:before,下午:after
"address":null,签到地址
"createTime":null 签到时间
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

15.4	机构按课程类型查看学生数
接口名称	机构按课程类型查看学生数
接口说明	
接口地址	/census/user/by/course/type
图片地址	无
参数名称	参数类型	输入/输出	说明
census	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：census={"institutionId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"courseTypeName":null,课程类型名称
"userCount":0学生人数
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

15.5	机构按子机构查看学生数
接口名称	机构按子机构查看学生数
接口说明	
接口地址	/census/user/by/child/institution
图片地址	无
参数名称	参数类型	输入/输出	说明
census	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：census={"institutionId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"institutionName":null,分机构名称
"userCount":0 人数
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

15.6	机构获取咨询统计
接口名称	机构获取咨询统计
接口说明	
接口地址	/user/ask/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"institutionId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16	个人信息
16.1	上传头像
接口名称	上传头像
接口说明	
接口地址	/user/update/photo
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"id":"Wdsd2dsd","photo":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":photo路径}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16.2	用户基本信息维护
接口名称	用户基本信息维护
接口说明	
接口地址	/user/update/info
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"id":"W3Dff3w3","name":"name",,"address":"address","sex":1,"birthday":12232434,"regionId":88,"realName":"","interest":"","shortIntroduction":"","sign":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16.3	我的关注列表
接口名称	我的关注列表
接口说明	
接口地址	/user/fans/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"6Fk31iKT"}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"fansId":null,关注id
"name":null,  个人名称或者机构名称
"photo":null,  个人照片或者机构logo
"type":null  1:关注机构,2:关注的是个人
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


16.4	我的关注取消关注
接口名称	我的关注取消关注
接口说明	
接口地址	/user/fans/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"fansId":1,"type":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16.5	我的收藏列表
接口名称	我的收藏列表
接口说明	
接口地址	/user/collect/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"6Fk31iKT"}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"collectId":null, 收藏id
"type":null,  1:代表课程收藏 2:活动收藏,3:帖子收藏
"createTime":null, 收藏时间
"classId":null, 课程id
"logo":null, 课程图片
"name":null, 课程名称
"planCount":0, 计划上课次数
"studentCount":0, 计划学生人数
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"teacherName":null, 老师名称
"price":null, 课程价格
"activityId":null, 活动id
"adverImg":null, 活动图片
"title":null, 活动标题
"oldPrice":null, 活动老价格
"postId":null, 帖子id
"context":null, 帖子内容
"userName":null, 发帖人名称
"imgUrls":[“”]} 帖子图片
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


16.6	我的收藏取消
接口名称	我的收藏取消
接口说明	
接口地址	/user/collect/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"collectId":1,"type":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16.7	我的好友列表
接口名称	我的好友列表
接口说明	
接口地址	/user/firend/search/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"key":"","ids":[""]}
key用户搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


16.8	我的非好友列表
接口名称	我的非好友列表
接口说明	
接口地址	/user/unfirend/search/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"key":"","ids":[""],"pageNo":0,"pageSize":20}
key用户搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"password":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"loginDayCount":0,
"createTime":null,
"realName":null,
"interest":null,
"shortIntroduction":null,
"sign":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


16.9	个人主页
接口名称	个人主页
接口说明	
接口地址	/user/face/get
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"","beenUserId":""}
userId  当前登录人
beenUserId 被查看人
key用户搜索
正常返回：
{"success":true,"code":0,"message":"成功","result": 
{"id":null,
"levelId":null,
"type":null,
"name":null,
"phone":null,
"photo":null,
"qqOpenId":null,
"sinaOpenId":null,
"weixinOpenId":null,
"address":null,
"sex":null,
"birthday":null,
"regionId":null,
"createTime":null,
"visitCount":0,浏览量
"fansCount":0,粉丝数
"fansId":null,  关注id 
"interest":null,
"shortIntroduction":null,
"sign":null
} }
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16.10	个人关注
接口名称	个人关注
接口说明	
接口地址	/user/fans/add
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"","beenUserId":""}
userId 关注者，当前登录者
beenUserId 被关注者
正常返回：
{"success":true,"code":0,"message":"成功","result": 
{"id":null,关注id
"userId":null,
"beenUserId":null,
"createTime":null} }
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16.11	个人取消关注
接口名称	个人取消关注
接口说明	
接口地址	/user/fans/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"fansId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result": null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


16.12	学生主页课程列表
接口名称	学生主页课程列表
接口说明	
接口地址	/course/class/student/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"cover":null,课程封面
"name":null,
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"userId":null,老师id
"userName":null,老师名字
"planCount":0,上课次数
"studentCount":0,计划学生数量
"price":null,
"institutionName":null,机构名称
"imgUrls":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	

16.13	老师主页课程列表
接口名称	老师主页课程列表
接口说明	
接口地址	/course/class/teacher/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,
"cover":null,课程封面
"name":null,
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"userId":null,老师id
"userName":null,老师名字
"planCount":0,上课次数
"studentCount":0,计划学生数量
"price":null,
"institutionName":null,机构名称
"imgUrls":null}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


16.14	老师相册列表
接口名称	老师相册列表
接口说明	
接口地址	/user/photo/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,相册id
"userId":null,用户id
"url":null,照片地址
"createTime":null
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
	


16.15	老师添加相册
接口名称	老师添加相册
接口说明	
接口地址	/user/photo/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"","urls":[""]}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

16.16	老师删除相册
接口名称	老师删除相册
接口说明	
接口地址	/user/photo/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user=[1,2,3]
相册id集合
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 




17	个人学习管理
17.1	学生要签到的课程列表
接口名称	学生要签到的课程列表
接口说明	签到统计也是用的这个接口
接口地址	/course/class/sign/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"","date":19922302002000}
date必填,默认传今天
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,课程id
"cover":null,
"name":null,
"startDate":null,
"endDate":null,
"startTime":null,
"endTime":null,
"userId":null,老师id
"userName":null,
"planCount":0, 计划上课次数
"studentCount":0, 计划学生人数
"price":null, 课程价格
"institutionName":null, 课程所属机构
"address":null,
"signId":null,  签到id
"totalSignCount":0,  已签多少次
"totalCount":0  共多少次
}
]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


17.2	学生签到
接口名称	学生签到
接口说明	
接口地址	/course/class/sign/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"","classId":1,"address":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,  签到id
"institutionId":null,
"classId":null,
"classPlanId":null,
"userId":null,
"address":null,
"createTime":null
}
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


17.3	个人机构列表
接口名称	个人机构列表
接口说明	
接口地址	/user/student/my/institution/search/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":
{
"count":10,
"list":[
{"id":null,
"name":null,
"summary":null,
"logo":null,
"face":null,
"tel":null,
"address":null,
"parentId":null,
"regionId":null,
"propaCount":0,  机构相册数量
"commentCount":0,  评论次数
"courseType":null,
"courseName":null,
"createTime":null}
]
}
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


17.4	个人添加我的机构
接口名称	个人添加我的机构
接口说明	
接口地址	/user/student/my/institution/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"6Fk31iKT","institutionIds":["",""]}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


17.5	 非个人机构列表
接口名称	非个人机构列表
接口说明	
接口地址	/user/student/not/institution/search/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"6Fk31iKT","key":"","pageNo":0,"pageSize":10}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":
{
"count":10,
"list":[
{"id":null,
"name":null,
"summary":null,
"logo":null,
"face":null,
"tel":null,
"address":null,
"parentId":null,
"regionId":null,
"propaCount":0,  机构相册数量
"commentCount":0,  评论次数
"courseType":null,
"courseName":null,
"createTime":null}
]
}
}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


17.6	个人删除我的机构
接口名称	个人删除我的机构
接口说明	
接口地址	/user/student/my/institution/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
user	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：user={"userId":"6Fk31iKT","institutionIds":["",""]}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 




19.1 教师－签到
接口名称	教师签到
接口说明	
接口地址	/psign/teacher/sign/do
图片地址	无
参数名称	参数类型	输入/输出	说明
psign	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：psign={"userId":"f9lJS0P5","address":"中国北京市海淀区知春路6号-西门\t在锦秋国际大厦附近","institutionId":"KjeNmRKe"}
正常返回：
{"success":true,"code":0,"message":"成功","result":{"id":184,"institutionId":"KjeNmRKe","classId":null,"classPlanId":null,"userId":"f9lJS0P5","address":"中国北京市海淀区知春路6号-西门\t在锦秋国际大厦附近","createTime":1465871690631}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


19.2 教师－签到列表
接口名称	教师签到列表
接口说明	
接口地址	/psign/teacher/plan/today/sign/list
图片地址	无
参数名称	参数类型	输入/输出	说明
psign	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：psign={"userId":"f9lJS0P5","date":1465871692131}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"institutionId":"KjeNmRKe","institutionName":"轻舞飞扬舞蹈工作室","logo":"/image/logo/1456395997334.jpg","type":"before","address":"中国北京市海淀区知春路6号-西门\t在锦秋国际大厦附近","createTime":1465871691000}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 




19.4 教师－我的课表
接口名称	老师我的课表
接口说明	
接口地址	/course/class/teacher/plan/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"","date":19922302002000}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"classId":null,
"institutionName":null,
"className":null,
"startTime":null,
"endTime":null,
"address":null,
"cover":null,
"studentCount":0,
"signCount":0
}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


20.1 教师－教学管理列表
接口名称	教学管理列表
接口说明	
接口地址	/course/class/manage/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"f9lJS0P5","date":1465872290581}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":30,"cover":null,"name":"开心","planCount":6,"studentCount":0,"institutionName":"1000机构"}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 



20.2 教师－一个课程的学生列表（学生管理）
接口名称	学生管理列表（Android用的都是20.3的搜索接口，key传人null，其他雷同处都是如此做法）
接口说明	
接口地址	/course/class/manage/student/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":30}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":"0VIQO26m","name":null,"photo":null,"phone":"299","sex":null}]}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


20.3 教师－搜索一个课程的学生列表(学生管理)
接口名称	搜索学生列表
接口说明	
接口地址	/course/class/manage/student/search/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":30,"key":"299"}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":"0VIQO26m","name":null,"photo":null,"phone":"299","sex":null}]}  异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


20.4 教师－获取不属于课程的学生列表(学生管理)
接口名称	搜索非课程学生列表
接口说明	
接口地址	/course/class/manage/not/student/search/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":1,"key":"","pageNo":0,"pageSize":20}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"id":"0BwghpPR","name":"我是138","photo":"/image/photo/1455616646833.jpg","phone":"138","sex":null},{"id":"1EdNGxpK","name":null,"photo":null,"phone":"313","sex":null},…]}
  异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 





20.5 教师－学生管理删除学生
接口名称	删除学生
接口说明	
接口地址	/course/class/manage/student/delete/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":30,"userIds":["0VIQO26m"]}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 



20.6 教师－学生管理添加学生
接口名称	添加学生
接口说明	
接口地址	/course/class/manage/student/add/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":30,"userIds":["0VIQO26m"]}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 



20.7 教师－上课情况
接口名称	上课情况列表
接口说明	
接口地址	/course/class/sign/info/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"f9lJS0P5","date":1465873630740}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"classId":30,"institutionName":"1000机构","className":"开心","startTime":"18:58:00","endTime":"21:45:00","address":"家","cover":null,"studentCount":123,"signCount":0}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


20.8 教师－上课情况－未签到
接口名称	未签到
接口说明	
接口地址	/course/class/student/unsign/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":30,"date":1465874083572}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"userId":"0VIQO26m","photo":null,"name":null,"phone":"299"}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


20.8 教师－上课情况－已签到
接口名称	已签到列表
接口说明	
接口地址	/course/class/student/sign/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"classId":30,"date":1465874083547}
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"userId":"0VIQO26m","photo":null,"name":null,"phone":"299"}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

17.7	教师—我的学生
接口名称	我的学生
接口说明	
接口地址	/course/teacher/student/list/2_0
图片地址	无
参数名称	参数类型	输入/输出	说明
course	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：course={"userId":"","key":""}
Key用于搜索
正常返回：
{"success":true,"code":0,"message":"成功","result":[{"userId":null,"photo":null,"name":null,"phone":null}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

18	公告相关
18.1	增加一个公告
接口名称	增加一个公告
接口说明	
接口地址	/announcement/add
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：announcement={"title":"","content":"","typeId":1,"belong":0,"institutionId":"","userId":"","annoImage":""}
typeId:1欢迎公告，2普通公告
belong机构发布公告统一传1
正常返回：
{"success":true,"code":0,"message":"成功","result": 
{"id":null,
"institutionId":null,
"userId":null,
"typeId":null,
"belong":null,
"title":null,
"content":null,
"annoImage":null,公告图片
"createTime":null} }
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

18.2	修改一个公告
接口名称	修改一个公告
接口说明	
接口地址	/announcement/update
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：announcement={"id":1,"title":"","content":"","typeId":1,"belong":0,"institutionId":"","userId":"","annoImage":""}
typeId:1欢迎公告，2普通公告
belong机构发布公告统一传1
正常返回：
{"success":true,"code":0,"message":"成功","result": 
null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

18.3	删除公告
接口名称	删除公告
接口说明	
接口地址	/announcement/delete
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：announcement={"ids":[1,2]}
typeId:1欢迎公告，2普通公告
belong机构发布公告统一传1
正常返回：
{"success":true,"code":0,"message":"成功","result": 
null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

18.4	用户获取所有公告
接口名称	用户获取所有公告
接口说明	
接口地址	/announcement/list
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：announcement={"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result": [
{"id":162,
"institutionId":null,
"institutionName":null,
"userId":"KtOOCUHz",发布者
"typeId":1,
"belong":0,
"title":"新学校2",
"content":"小朋友们2",
"annoImage":"http://egg-cloud-test.oss-cn-beijing.aliyuncs.com/announcement/85941e00e6f94758aa534d4c7cae9342.jpg",
"createTime":1464413352000,
"isNew":0,此参数2.0无用
"readId":617公告已读id
}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


18.5	读公告
接口名称	读公告
接口说明	
接口地址	/announcement/read
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：announcement={"announcementId":1,"userId":"","institutionId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,读id
"userId":null,
"announcementId":null,
"institutionId":null,
"createTime":null}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

18.6	公告详情
接口名称	公告详情
接口说明	
接口地址	/announcement/get
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：announcement={"id":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":
{"id":null,
"institutionId":null,
"userId":null,
"typeId":null,
"belong":null,
"title":null,
"content":null,
"annoImage":null,
"createTime":null}}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 


19	消息
19.1	用户获取未读公告消息数量
接口名称	用户获取未读公告数量
接口说明	
接口地址	/announcement/new/count
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：announcement={"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":0}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

19.2	获取评论消息
接口名称	获取评论消息
接口说明	
接口地址	/comment/message/list
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：comment={"userId":"","pageNo":0,"pageSize":10}
正常返回：
{"success":true,"code":0,"message":"成功","result":[
{"id":null,消息id
"commentId":null,对方评论
"userId":null,对方id
"userLevelId":null,
"userName":null,
"userPhoto":null,
"sex":null,
"context":null,
"isPublic":true,
"isOriginal":true,
"parentId":null,我发布的评论id
"voidePaths":null,
"imagePaths":null,
"commentChilds":null,
"loveCount":0,
"commentCount":0,
"readId":null,
"myloveId":null,
"createTime":null,
"public":true,
"original":true
}]}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
19.3	获取新评论消息个数
接口名称	获取新评论消息个数
接口说明	
接口地址	/comment/message/new/count
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：comment={"userId":""}
正常返回：
{"success":true,"code":0,"message":"成功","result":0}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 
19.4	读评论消息
接口名称	读评论消息
接口说明	
接口地址	/comment/message/read
图片地址	无
参数名称	参数类型	输入/输出	说明
announcement	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：comment={"messageId":1}
正常返回：
{"success":true,"code":0,"message":"成功","result":null}
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

20	系统安全
20.1	获取后台token
接口名称	获取后台token
接口说明	
接口地址	/sys/token
图片地址	无
参数名称	参数类型	输入/输出	说明
无	String	输入	不能为空
返回值	String	输出	Json格式
接口描述	请求：
正常返回：
{"success":true,"code":0,"message":"成功","result":{"token":"Yzg1NDMxMzEtOTc5OC00NzE0LWIxZTYtZjdiYjgzZmIyN2Qz","expires_in":1466509777083}}
expires_in:token到期时间
异常返回：
{  "success" : false,  "code" : 911,  "message" : "错误信息",  "result" : false} 

