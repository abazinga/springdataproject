mysql -uroot -p123456;

CREATE database spring_data;

create table student(
  id INT NOT NULL auto_increment,
  name VARCHAR (20) NOT NULL ,
  age INT NOT  NULL ,
  PRIMARY KEY (id)
);

INSERT INTO student (name, age) VALUES ("zhangsan", 20);
INSERT INTO student (name, age) VALUES ("lisi", 30);
INSERT INTO student (name, age) VALUES ("wangwu", 25);

--3) 开发JDBCUtil工具类
获取Connection，关闭Connection，Statement, Resultest
