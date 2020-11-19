CREATE DATABASE QUANLIBANHANG
GO 
USE QUANLIBANHANG
GO
CREATE TABLE USERNAME
    (
      id INT IDENTITY NOT NULL ,
      username NVARCHAR(50) NOT NULL ,
      password NVARCHAR(50) NOT NULL ,
      fullname NVARCHAR(50) NOT NULL ,
      email NVARCHAR(50) NOT NULL ,
      phone NCHAR(10) NOT NULL ,
      role INT NOT NULL ,
      PRIMARY KEY ( id )
    )
	GO
	CREATE TABLE Categories(
	id INT NOT NULL,
	name NVARCHAR(50) NOT NULL,
	note NVARCHAR(200) NOT NULL,
   PRIMARY KEY(id)
   )
	GO

CREATE TABLE PRODUCT
( id INT IDENTITY NOT NULL,
name NVARCHAR(200) NOT NULL,
price INT NOT NULL,
note NVARCHAR(200) NOT NULL,
image NVARCHAR(200) NOT NULL,
category_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (category_id) REFERENCES dbo.Categories (id)
)
GO
INSERT INTO dbo.Categories
        ( id, name, note )
VALUES  ( 1, -- id - int
          N'DienThoai', -- name - nvarchar(50)
          N''  -- note - nvarchar(200)
          ), ( 2, -- id - int
          N'Maytinhbang', -- name - nvarchar(50)
          N''  -- note - nvarchar(200)
          ), ( 3, -- id - int
          N'Laptop', -- name - nvarchar(50)
          N''  -- note - nvarchar(200)
          )
GO
 INSERT INTO dbo.PRODUCT
         (
           name ,
           price ,
           note ,
           image ,
           category_id
         )
 VALUES  (  -- id - int
           N'Iphone X' , -- name - nvarchar(200)
           12000000 , -- price - int
           N'Hàng Chất Lượng Cao' , -- note - nvarchar(200)
           N'iphone.jpg' , -- image - nvarchar(200)
           1  -- category_id - int
         ),
		  (  -- id - int
           N'Samsung Note 10' , -- name - nvarchar(200)
           22000000 , -- price - int
           N'Hàng Chất Lượng Cao' , -- note - nvarchar(200)
           N'SamsungNote10.png' , -- image - nvarchar(200)
           1  -- category_id - int
         )

INSERT  INTO dbo.USERNAME
        (  username, password, fullname, email, phone, role )
VALUES  (  N'Teo', -- USERNAME - nvarchar(50)
          N'123', -- PASSWORD - nvarchar(50)
          N'Nguyen Van Teo', -- FULLNAME - nvarchar(50)
          N'Teonv@gmail.com', -- EMAIL - nvarchar(50)
          N'0796551414', -- PHONE - nchar(10)
          0  -- ROLE - int
          ),
        (  N'Tuan', -- USERNAME - nvarchar(50)
          N'123456', -- PASSWORD - nvarchar(50)
          N'Nguyen Van Tuan', -- FULLNAME - nvarchar(50)
          N'Tuannv@gmail.com', -- EMAIL - nvarchar(50)
          N'0798991015', -- PHONE - nchar(10)
          0  -- ROLE - int
          ),
        (  N'Linh', -- USERNAME - nvarchar(50)
          N'123456', -- PASSWORD - nvarchar(50)
          N'Nguyen Thi Truc Linh', -- FULLNAME - nvarchar(50)
          N'Linhntt@gmail.com', -- EMAIL - nvarchar(50)
          N'0767541232', -- PHONE - nchar(10)
          1  -- ROLE - int
          )