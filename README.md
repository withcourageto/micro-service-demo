## 运行
请保证至少有空闲6gb的内存

### 准备条件
* 安装 Docker 和 Docker Compose
* 设置环境变量: 
* 构建项目: mvn clean package -Dmaven.test.skip=true

### 启动
* docker-compose -f docker-compose.yml up -d

### 测试访问
* 客户端安装类似 Postman 的http工具
* 访问 http://localhost:8080/uaa/oauth/token 获取token
    - 访问方式:POST
    - header:  
      - Authorization:Basic YnJvd3Nlcjpicm93c2Vy
    - 参数 :
      - username: admin
      - password: admin
      - grant_type: password

* 访问 http:localhost:8080/blog/blogs?access_token={{access_token}} 新增博客
    - 访问方式:  POST
    - header:
        - Content-Type: application/json
    - 参数:
        - access_token : 刚才获取到的token
        - 博客内容:{
          	"title":"ccc",
          	"content": "...."
          }
* 访问 http:localhost:8080/blog/blogs/{id}?access_token={{access_token_client}} 获取博客内容
    - 访问方式: GET
    - 参数:
        - 路径参数: id,博客的id
        - access_token: 刚才获取到的token 
        

## 服务:
- 核心服务
    * user-service : 用户注册
    * blog-service: 博客相关功能
- 基础服务
  * auth-service : 认证中心
  * config : 配置中心
  * service-registry : 服务注册中心
  * dashboard : 监控面板

## 数据库
  * mysql-blog-db : 博客数据库
  * mysql-user-db : 用户数据库


## 端口
开发调试对外暴露端口如下表:


   服务    |   映射主机端口	|  远程调试端口 | 说明   
------------ |----------|-------------| -------
user-service |  8021    |    8025     |  用户服务,保存获取用户信息
config	     |  9001    |    9005     |  配置中心
blog-service |   8031   |	 8035	  |  博客服务
service-registry| 8701  |    8705     |  服务注册中心
auth-service| 8051      |    8055     |  认证服务
gateway     | 8080      |   ---       |  网关
dashboard   | 8040      |   ---       |  监控

## api

### user-service

   path             |   method |  parameter | 说明   
------------------- |----------|------------| -------
/users/{id}          |  GET    |            | 通过Id获取用户详细信息
/users/info/{username}|  GET   |            | 通过用户名获取用户详细信息
/users              | POST     |{<br>  username: "用户名", <br> password: "密码"<br>} | 用户注册

### blog-service
   path             |   method |  parameter | 说明   
------------------- |----------|------------| -------
/blogs/{id}         |   GET    |            |  博客详情
/blogs              |   POST   |{<br>  title: "标题", <br> content: "内容",<br>authorId:1 // 作者<br> } | 添加博客

## 服务架构
![图片](https://github.com//withcourageto/images/blob/master/mico-service-blog/360%E6%88%AA%E5%9B%BE167204027396113.png?raw=true)
