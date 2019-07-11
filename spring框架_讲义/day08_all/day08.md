# 1.Spring集成MyBatis (方式一　使用Mapper映射器)
	step1.导包。
		spring-webmvc,mybatis,mybatis-spring,spring-jdbc
		ojdbc,dbcp,junit。
	step2.添加Spring配置文件
		注: MyBatis配置文件的内容变成了一个bean
			(SqlSessionFactoryBean)
	step3.实体类
	step4.映射文件
	step5.Mapper映射器
	step6.配置MapperScannerConfigurer
		注：该bean会扫描指定包及其子包下面的所有的
			Mapper映射器（接口）,会调用SqlSession的
			getMapper方法返回Mapper映射器的实现对象，
			并且将这些对象添加到Spring容器里面。（默认的
			id是首字母小写之后的接口名）。
	
# 2.只扫描带有特定注解的Mapper映射器
	step1.开发一个注解。
	step2.将注解添加到Mapper映射器上面。
	step3.配置MapperScannerConfigurer。

# 3.Spring集成MyBatis　(方式二　不使用Mapper映射器)
	step1.导包。
		spring-webmvc,mybatis,mybatis-spring,spring-jdbc
		ojdbc,dbcp,junit。
	step2.添加Spring配置文件
		注: MyBatis配置文件的内容变成了一个bean
			(SqlSessionFactoryBean)
	step3.实体类
	step4.映射文件
		注：namespace可以自定义。
	step5.DAO接口
		注：方法名等不做要求。
	step6.DAO实现类。
	step7.配置SqlSessionTemplate
		可以将SqlSessionTemplate注入到DAO,然后
		调用SqlSessionTemplate提供的方法即可。
		注：SqlSessionTemplate封装了SqlSession,
			我们不用去考虑如何获得SqlSession,如何关闭
			SqlSession。
	
				
	

	