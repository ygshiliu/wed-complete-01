
mysql> use bookstore_web;
mysql> create table bs_users(
    -> id int(11) primary key auto_increment,
    -> username varchar(50) not null,
    -> password varchar(50) not null,
    -> email varchar(50)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> desc bs_users;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
| username | varchar(50) | NO   | UNI | NULL    |                |
| password | varchar(50) | NO   |     | NULL    |                |
| email    | varchar(50) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
4 rows in set (0.01 sec)

mysql> alter table bs_users add unique(username);

-------------------------------------------------------------------------------
mysql> create table bs_books(
    -> id int(11) primary key auto_increment,
    -> title varchar(50),
    -> author varchar(50),
    -> price double(11,2),
    -> sales int(11),
    -> stock int(11),
    -> img_path varchar(100)
    -> );
    
---------------------------------------------------------------------------------------
    mysql> create table bs_orders(
    -> id varchar(100) primary key,
    -> create_date datetime,
    -> state int(11),
    -> total_count int(11),
    -> total_amount double(11,2),
    -> user_id int(11)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> desc bs_orders;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| id           | varchar(100) | NO   | PRI | NULL    |       |
| create_date  | datetime     | YES  |     | NULL    |       |
| state        | int(11)      | YES  |     | NULL    |       |
| total_count  | int(11)      | YES  |     | NULL    |       |
| total_amount | double(11,2) | YES  |     | NULL    |       |
| user_id      | int(11)      | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
6 rows in set (0.01 sec)

mysql>
-------------------------------------------------------------

mysql> create table bs_orderItems(
    -> id int(11) primary key auto_increment,
    -> title varchar(100),
    -> author varchar(50),
    -> price double(11,2),
    -> img_path varchar(200),
    -> total_count int(11),
    -> total_amount double(11,2),
    -> order_id varchar(100)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> desc bs_orderItems;
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | int(11)      | NO   | PRI | NULL    | auto_increment |
| title        | varchar(100) | YES  |     | NULL    |                |
| author       | varchar(50)  | YES  |     | NULL    |                |
| price        | double(11,2) | YES  |     | NULL    |                |
| img_path     | varchar(200) | YES  |     | NULL    |                |
| total_count  | int(11)      | YES  |     | NULL    |                |
| total_amount | double(11,2) | YES  |     | NULL    |                |
| order_id     | varchar(100) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
8 rows in set (0.01 sec)

mysql>