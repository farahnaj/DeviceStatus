-- Creation of device status's table
CREATE TABLE IF NOT EXISTS device_user (
  id SERIAL NOT NULL,
  user_login varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  created_on timestamp NOT NULL DEFAULT NOW(),
  PRIMARY KEY (user_login)
);

CREATE TABLE IF NOT EXISTS device(
  id SERIAL NOT NULL,
  user_login varchar(100) REFERENCES device_user(user_login),
  name varchar(100) NOT NULL,
  description varchar(100),
  created_on timestamp NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS device_status (
  id SERIAL NOT NULL,
  message varchar(250) NOT NULL,
  health varchar(100) NOT NULL,
  device_id int8 REFERENCES device(id),
  created_on timestamp NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
--FOREIGN KEY (device_id) REFERENCES device(id)
--  CONSTRAINT fk_id
--   FOREIGN KEY(device_id)
--     REFERENCES device(id)
);


-- Setting up some Dummy data for development
insert into device_user values(1,'farah','farah@abc.com',default);
insert into device_user values(2,'rohit','rohit@abc.com',default);
insert into device values(1,'farah','phone','mobile',default);
insert into device values(2,'rohit','phone','mobile',default);
insert into device values(3,'farah','laptop','system',default);
insert into device values(4,'rohit','earthquake sensor','detector',default);
insert into device_status values(DEFAULT, 'FOO device_status','OK',1,DEFAULT);
insert into device_status values(DEFAULT, 'FOO device_status','WARNING',3,DEFAULT);
insert into device_status values(DEFAULT, 'FOO device_status','OK',1,DEFAULT);
insert into device_status values(DEFAULT, 'FOO device_status','OK',3,DEFAULT);
insert into device_status values(DEFAULT, 'FOO device_status','WARNING',1,DEFAULT);
insert into device_status values(DEFAULT, 'FOO device_status','OK',3,DEFAULT);
insert into device_status values(DEFAULT, 'FOO device_status','OK',1,DEFAULT);
insert into device_status values(DEFAULT,'BAR device_status','OK',2,DEFAULT);
insert into device_status values(DEFAULT,'DOO device_status','OK',4,DEFAULT);
insert into device_status values(DEFAULT,'BoR device_status','OK',2,DEFAULT);
insert into device_status values(DEFAULT,'DOo device_status','WARNING',4,DEFAULT);
insert into device_status values(DEFAULT,'BAr device_status','OK',2,DEFAULT);
insert into device_status values(DEFAULT,'DdO device_status','OK',4,DEFAULT);
insert into device_status values(DEFAULT,'DOo device_status','OK',4,DEFAULT);
insert into device_status values(DEFAULT,'DOo device_status','WARNING',4,DEFAULT);
insert into device_status values(DEFAULT,'BAr device_status','OK',2,DEFAULT);
insert into device_status values(DEFAULT,'BAr device_status','OK',2,DEFAULT);
insert into device_status values(DEFAULT,'DOo device_status','OK',4,DEFAULT);
insert into device_status values(DEFAULT,'DOo device_status','ERROR',4,DEFAULT);
insert into device_status values(DEFAULT,'BAr device_status','OK',2,DEFAULT);
insert into device_status values(DEFAULT,'BAr device_status','OK',2,DEFAULT);

--SELECT * FROM DEVICE_STATUS;
--SELECT * FROM device;
--SELECT * FROM device_user;
