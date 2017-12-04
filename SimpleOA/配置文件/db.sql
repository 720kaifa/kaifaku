create table s_user(
	id bigint primary key AUTO_INCREMENT,
	numid varchar(20) not null,
	relname varchar(50) not null,
	account varchar(50) not null,
	password varchar(50) not null,
	age decimal(3,0),
	gender decimal(1,0),
	role decimal(2,0),
	interest varchar(50),
	mphone decimal(15,0),
	address varchar(100),
	email varchar(50),
	qq varchar(50),
	wx varchar(50),
	birthday date
	)engine=InnoDB default charset=utf8;

insert into t_user (numid,relname,account,password,age,gender,role,interest,mphone,address,email,qq,wx,birthday)
		values('SA-001','管理员','admin','123456',20,1,1,'编程',12345666666,'银河系太阳','123654789@SA.com','895856854','forlove','1997-7-1');



create table s_worklog(
	id bigint primary key AUTO_INCREMENT,
	relname varchar(50) not null,
	account varchar(50) not null,
	userid bigint,
	createtime datetime,
	worktime decimal(2,0),
	jcontent varchar(500),
	cdescribe varchar(1000),
	summary varchar(500)
	)engine=InnoDB default charset=utf8;

insert into s_worklog(relname,account,userid,createtime,worktime,jcontent,cdescribe,summary)
		values('应锴','yk','3','2017-12-4 10:10:00',2,'SimpleOA的开发','SimpleOA的开发工作','SimpleOA的开发工作');

create table s_loginlog(
	id bigint primary key AUTO_INCREMENT,
	relname varchar(50) not null,
	account varchar(50) not null,
	userid bigint,
	loginip varchar(20),
	logintime datetime
	)engine=InnoDB default charset=utf8;

