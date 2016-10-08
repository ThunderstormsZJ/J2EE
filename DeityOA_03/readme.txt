搭建坏境
	(1).Hibernate-4.3.10
		a.将Hibernate的jar文件导入项目当中
		b.配置hibernate.cfg.xml文件
	(2).Spring-4.1.6
		a.将Spring的jar文件导入项目当中
		b.配置applicationContext.xml文件
	(3).整合Hibernate和Spring
		a.使用c3p0连接池配置dataSource(通过加载外部有jdbc.proerties文件)
		b.配置SessionFactory,可以省去hibernate.cfg.xml文件
		c.配置声明式事务管理(使用annotation的方式)
	(4).Struts2.3.20
		a.将struts的jar文件导入项目当中
		b.引入struts.xml文件
		c.配置web.xml文件的
	(5).整合Struts和Spring
		a.在web.xml文件中配置监听器,和contextConfigLocation的参数
		b.导入struts2-spring-plugin-2.3.20.1.jar文件

系统管理模块：
1.设计实体
	(1).
		实体名称: 	部门(Department)    	 		用户(User)                岗位(Role)
		属性名称:	id,name,					id,loginName,password	 id,name,discription
				discription					name,gender,phone,
											email,discription,
		关系属性:	
				parent:Department			department:Department	 users:Set<User>
				children:Set<Department>	roles:Set<Role>
				users:Set<User>
		
	(2).设计实体与表的映射关系
		a.上级部门与下级部门之间的双向关联(树状结构)
		b.部门与员工之间的双向关联
		c.员工与岗位之间的双向关联
		
2.设计Dao的结构
					implements				extends
	(C)UserDaoImpl------------->UserDao(I)————————————>BaiscDao(I)
           |                                   	           ↑           	
           |_________________BasicDaoImpl(C)_______________|
				extends				              extends
	命名:UserDao,RoleDao,DeptDao
	
3.分别给用户管理,部门管理,岗位管理增加基本的操作(CURD)

4.为各个管理模块设计Service
	命名:UserService,RoleService,DeptService
	
5.编写Action
	命名:UserAction,RoleAction,DeptAction
	(1)给Action配置好命名规范(*_*):
		如(Actionname:userAction_list class:userAction method:list resultname:list)
	(2)通过Action转到固定的jsp页面:
		每个Action都对应一组jsp
		
DeityOA_02版本
	改进:将服务层和数据库层相结合;省去Dao层,让Service直接继承BasicDao。
	1、Service的接口继承BasicDao的接口,Service的先继承BasicDaoImpl再实现Service的接口
	2、将用户,岗位和部门的Action抽取出一个公共的Action,让他们都继承一个公共的Action

权限设定的模块:
1.设计实体
	(1).实体名
	实体名:	用户(User)           				权限(Priviledge)
	属性名称	id,loginName,password			id,name,url,ioc
			name,gender,phone,
			email,discription,
		
	管理属性	
			department:Department	 		users:Set<User>
			roles:Set<Role>					priviledge:Priviledge
			priviledges:Set<Priviledge>		priviledges:Set<Priviledge>
	(2).设计实体与表的映射关系
		a.用户和权限的多对多的关系
		b.权限自身之间一对多的关系	

	(3).初始化数据
		a.使用批处理的方式初始化程序.
		b.可以再程序中插入数据,或者通过.sql文件将数据插入进去
		
	(4).在页面中根据会先的所有的权限消息利用js转换成树状的结构,并利用jQuery实现联动效果
	
	(5).实现对岗位的权限的分配和权限的回显功能
	
	(7).使用监听器准备好显示在首页菜单的所有信息
	
	(8).对用户的访问权限设置：
		在显示级别的权限访问限制的设置
			a.对没有权限的主菜单不进行显示
			b.对没有权限的操作不进行显示(通过重写<s:a/>的自定义标签)
		在url级别的拦截的权限访问限制
			a.通过自定义的拦截器来限制地址栏的URL访问
	//TODO	
	(9).使用jQuery来完成基本的客户端的数据验证
【注：】
	1.在服务器重启的后会产生一个session文件(用于服务器停止的时候保存Session的信息);
	      被保存在session中的类需要实现序列化接口,否则不能保存到磁盘当中
	2.在session过期之后会出现窗口嵌套的问题,使用自动的窗口刷新来解决
	       如:window.parent.location.reload(true);

DeityOA_02版本:
论坛模块:
	(1).设计实体
		Forum(板块)           Topic(主题)             Reply(回复)
		
	(2).版块管理:
		a.对版块实现增加,删除,修改操作;
		b.实现板块的上移和下移的功能;
