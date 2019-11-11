# Springboot-Framework-Practice


![](https://img.shields.io/github/last-commit/YagoToasa/Springboot-Framework-Practice)

## 进度

- [x] Maven
- [x] Mybatis
- [x] Redis
- [ ] JPA
- [ ] Shiro
- [x] Mysql



## 目录结构

```
.
├── HELP.md
├── learning.iml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── learning
    │   │       ├── LearningApplication.java: 启动类
    │   │       ├── config: 配置类 Config
    │   │       ├── controller: 前端控制层 
    │   │       ├── dto: 数据传输对象 Data Transfer Object: 用于封装多个实体类(domain)之间的关系, 而不破坏实体类的结构
    │   │       ├── pojo: mybatis 实体类 Domain (domain jpa)
    │   │       ├── mapper: mybatis 数据接口访问层 Dao (repository jpa)
    │   │       ├── service: 数据服务接口层 Service
    │   │       │   └── impl: 数据服务实现层 Service Implements
    │   │       ├── utils: 工具类库 Utilities
    │   │       └── vo: 视图包装对象 View Object: 用于封装客户端请求，防暑数据泄露，保证数据安全，不破坏实体类结构
    │   └── resources
    │       ├── application.yml: 项目配置文件
    │       ├── mapper: mybatis 映射文件 
    │       │   └── config: mybatis 配置文件
    │       ├── static: 静态资源目录: html, css, js
    │       └── templates: 视图模版目录: jsp, thymeleaf
    └── test 
        └── java
            └── learning: 单元测试目录
                └── LearningApplicationTests.java
```

