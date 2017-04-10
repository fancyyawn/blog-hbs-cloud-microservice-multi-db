# blog-hbs-cloud-microservice-multi-db
> 基于SpringCloud的微服务化多人博客，每个服务可根据业务需要使用的不同的数据库。

* blog-common： 提供Paging得公共类
* blog-discovery：基于Eureka提供服务注册和发现功能
* blog-hbs-web：整个博客应用的gateway，对外提供页面， 其利用各微服务模块的api来提供数据和操作。
* blog-service-user：用户服务，在内网环境中提供rest api， 数据库为mysql(blog-microservice)
* blog-service-post：博客服务，在内网环境中提供rest api，数据库为mongodb（blog-microservice）
* blog-service-comment: 评价服务，在内网环境中提供rest api，数据库为mongodb（blog-microservice）
