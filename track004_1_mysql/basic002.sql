[실습-연습문제1~6]
---
create table coffee(
    cno int not null auto_increment primary key,
    cname varchar(50) not null,
    cprice int not null
);

create table milk(
    mno int not null auto_increment primary key,
    mname    varchar(50)  not null,
    mprice int not null,
    mnum int not null,
    mtotla int not null
);

create table score(
    sno int(11) not null auto_increment primary key,
    sname varchar(20) not null,
    sjava int(11) not null,
    sjsp int(11) not null,
    sspring int(11) not null,
    sproject int(11) not null,
    sstotal int(11),
    ssavg int(11),
    semail varchar(50)
);

create table emp(
    empno int(11) auto_increment primary key,
    ename varchar(50),
    job varchar(20),
    mgr int(11),
    hiredate date,
    sal int(11),
    comm int(11),
    deptno int(11)
);

create table dept(
    deptno int(11) not null primary key auto_increment,
    dname varchar(20) not null,
    loc varchar(20) not null
);

create table salagrade(
    grade int(11) not null auto_increment primary key,
    losal int(11),
    hisal int(11)
);
---
create table userinfo(
    no int primary key  not null auto_increment,
    name varchar(50) not null,
    age int not null
);
