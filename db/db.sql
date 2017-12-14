create table s_user(
	id bigint primary key AUTO_INCREMENT,
	numid varchar(20) not null,
	relname varchar(50) not null,
	account varchar(50) not null,
	password varchar(50) not null,
	age decimal(3,0),
	gender decimal(1,0),
	role varchar(20),
	interest varchar(50),
	mphone decimal(15,0),
	address varchar(100),
	email varchar(50),
	qq varchar(50),
	wx varchar(50),
	birthday varchar(50),
	IS_DELETE DECIMAL(5,0),
	CREATE_TIME VARCHAR(50) not null,
	CREATE_USER VARCHAR(50) not null,
	UPDATE_TIME VARCHAR(50),
	UPDATE_USER VARCHAR(50)
	)engine=InnoDB default charset=utf8;

insert into s_user (numid,relname,account,password,age,gender,role,interest,mphone,address,email,qq,wx,birthday,CREATE_TIME,CREATE_USER)
		values('SA-001','超级管理员','admin','123456',20,1,'Super','编程',12345666666,'银河系太阳','123654789@SA.com','895856854','forlove','1993-10-01','1949-10-01','SYSTEM');



create table s_worklog(
	id bigint primary key AUTO_INCREMENT,
	relname varchar(50) not null,
	account varchar(50) not null,
	userid bigint,
	worktime decimal(2,0),
	jcontent varchar(500),
	cdescribe varchar(1000),
	summary varchar(500),
	projectname varchar(255),
	projectid BIGINT,
	workdate varchar(50),
	IS_DELETE DECIMAL(5,0),
	CREATE_TIME VARCHAR(50) not null,
	CREATE_USER VARCHAR(50) not null,
	UPDATE_TIME VARCHAR(50),
	UPDATE_USER VARCHAR(50)
	)engine=InnoDB default charset=utf8;

insert into s_worklog(relname,account,userid,worktime,jcontent,cdescribe,summary,projectname,projectid,workdate,CREATE_TIME,CREATE_USER)
		values('应锴','yk','3',2,'SimpleOA的开发','SimpleOA的开发工作','SimpleOA的开发工作',SimpleOA系统开发,1,2017-12-03,'2017-12-03 15:00:00','SYSTEM');

create table s_loginlog(
	id bigint primary key AUTO_INCREMENT,
	relname varchar(50) not null,
	account varchar(50) not null,
	userid bigint,
	loginip varchar(20),
	logintime varchar(50),
	IS_DELETE DECIMAL(5,0),
	CREATE_TIME VARCHAR(50) not null,
	CREATE_USER VARCHAR(50) not null,
	UPDATE_TIME VARCHAR(50),
	UPDATE_USER VARCHAR(50)
	)engine=InnoDB default charset=utf8;

create table s_project(
	id bigint primary key AUTO_INCREMENT,
	projectname varchar(255) not null,
	projectdec varchar(1000),
	starttime varchar(50),
	endtime varchar(50),
	estimated varchar(50),
	projectstatus decimal(2,0),
	IS_DELETE DECIMAL(5,0),
	CREATE_TIME VARCHAR(50) not null,
	CREATE_USER VARCHAR(50) not null,
	UPDATE_TIME VARCHAR(50),
	UPDATE_USER VARCHAR(50)
	)engine=InnoDB default charset=utf8;

insert into s_project(projectname,projectdec,starttime,endtime,projectstatus,CREATE_TIME,CREATE_USER)
		values('SimpleOA系统开发','SimpleOA系统开发','2017-11-25','2017-12-09',1,'2017-12-03 15:00:00','admin');


create table s_menu(
	id bigint primary key AUTO_INCREMENT,
	url varchar(50) not null,
	icon varchar(50),
	lid varchar(50),
	title varchar(100) not null,
	authority decimal(2,0),
	IS_DELETE DECIMAL(5,0),
	CREATE_TIME VARCHAR(50) not null,
	CREATE_USER VARCHAR(50) not null,
	UPDATE_TIME VARCHAR(50),
	UPDATE_USER VARCHAR(50)
	)engine=InnoDB default charset=utf8;

