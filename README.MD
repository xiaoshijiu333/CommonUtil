#### 说明
*   2019.12.20正式开始进入2.0.0版本
*   以后小改动升级一个小版本，1.0或者0.1，大改动升级一个大版本1.0.0


#### 2.0.0改动：
*   com.fei.common.exception.MyRuntimeException类更名为com.fei.common.exception.CommonException
*   com.fei.common.server.iputil.ServerConstant类更名为com.fei.common.server.iputil.AgentServerConstant
*   com.fei.common.cookie包移入com.fei.common.server包中
*   com.fei.common.data.ApiResult类移入com.fei.common.server.model包中
*   com.fei.common.data包更名为com.fei.common.model
*   改变org.projectlombok.lombok的依赖作用范围为compile，默认值
*   将com.fei.common.constant.server.StatusConstant类移入com.fei.common.constant包下
*   com.fei.common.exception.NotAuthException修改继承，继承com.fei.common.exception.CommonException
*   修改com.fei.common.exception包下类的 "魔法数字" 
*   在com.fei.common.constant.StatusConstant中添加常量FAILTURE_MESSAGE_PARAMETER_ERROR

#### 2.1.0：
*   修改org.apache.tomcat.embed.tomcat-embed-core版本为9.0.35
*   添加json相关处理工具类，提供fastjson和jackjson两种处理方式
*   为了避免依赖冲突，该工具类里面大部分依赖都被设定为了provide
*   添加文件命名特殊字符处理工具类
*   将所有的工具类都设置成了只有一个私有的构造器，即不可以被实例化
*   添加判断文件名是否符合规范的工具类

#### 2.2.0：
*   删除json相关处理工具类，提供fastjson和jackjson两种处理方式
*   删除json相关依赖
*   创建类FileContant，添加文件相关常量
*   修改文件工具类名为FileUtils，并添加下载文件方法