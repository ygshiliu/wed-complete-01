
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