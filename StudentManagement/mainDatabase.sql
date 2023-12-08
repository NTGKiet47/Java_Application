create database studentsmanagement;
use studentsmanagement;

drop table class;
drop table student;
drop table mark;
drop table study;
drop table admins;

create table admins(
	teacherName varchar(50) not null,
    email varchar(50) not null,
    teacherID varchar(5) not null,
    adminName varchar(50) primary key not null,
    adminPassword varchar(50) not null
);
create table student(
	student_id int primary key auto_increment,
    maSV varchar(8) not null,
    name varchar(50) not null,
    date_of_birth varchar(10) not null,
    gender varchar(10) not null,
    phoneNumber varchar(10) not null,
    email varchar(50) not null,
    address varchar(50) not null
);
create table class(
	class_id int primary key auto_increment,
    maLop varchar(5) not null,
    className varchar(50) not null,
    credit int not null
);
CREATE TABLE study (
  maLop VARCHAR(5) NOT NULL REFERENCES class(maLop) ON DELETE CASCADE,
  maSV VARCHAR(8) NOT NULL REFERENCES student(maSV) ON DELETE CASCADE,
  semester INT NOT NULL,
  schoolYear VARCHAR(9),
  PRIMARY KEY (maLop, maSV)
);
create table mark(
	maSV varchar(8) not null references student(maSV) ON DELETE CASCADE,
    maLop varchar(5) not null references class(maLop) ON DELETE CASCADE,
    mark varchar(2) not null,
    schoolYear varchar(9) not null references study(schoolYear) ON DELETE CASCADE, 
    primary key (maSV, maLop)
);

insert into student(maSV, name, date_of_birth, gender, phoneNumber, email, address)
values ("B2110037", "Le Nguyen Cong Thanh", "03-07-2003", "Male", "0898023564", "thanhB2110037@student.ctu.edu.vn", "Tan Phu, Cai Rang"),
("B2110098", "Le Hoang Khanh", "12-05-2003", "Male", "0889366340", "khanhB2110098@student.ctu.edu.vn", "Hem 51 Can Tho"),
("B2110064", "Le Long Dinh", "14-04-2003", "Male", "0775691943", "dinhB2110064@student.ctu.edu.vn", "Hung Phu, Cai Rang, Can Tho"),
("B2108829", "Tang Thien Dat", "20-09-2002", "Male", "0774049019", "datB2108829@student.ctu.edu.vn", "An Hoa, Ninh Kieu"),
("B2006891", "Ngo Phuoc Loi", "01-01-2001", "Male", "0967123456", "loiB2006891@student.ctu.edu.vn", "An Hoa, Ninh Kieu"),
("B2103456","Phan Quoc Sang", "16-02-2003", "Male", "0775957415", "sangB2103456@student.ctu.edu.vn", "Hung Loi, Cai Rang"),
("B2300182", "Nguyen Ngoc Ngan", "28-02-2005", "Female", "0939026433", "nganB2300182@student.ctu.edu.vn", "Cai Khe, Ninh Kieu, Can Tho");


insert into class (maLop, className, credit) 
values ("ct276", "Lap trinh Java", 3),
("ct175", "Ly thuyet do thi", 3),
("ct188", "Nhap mon lap trinh web", 3),
("ct174", "Phan tich va thiet ke thuat toan", 3),
("tn010", "Xac suat thong ke", 3),
("ct178", "Nguyen ly he dieu hanh", 3),
("ct177", "Cau truc du lieu", 3),
("ct241", "Phan tich yeu cau phan mem", 3),
("ct173", "Kien truc may tinh", 3),
("ct182", "Ngon ngu mo hinh hoa", 3),
("ml014", "Triet hoc Mac-Lenin", 3),
("ct176", "Lap trinh huong doi tuong", 3),
("ct179", "Quan tri he thong", 3),
("ct113", "Nhap mon cong nghe phan mem", 3),
("ct112", "Mang may tinh", 3),
("ml021", "Tu tuong Ho Chi Minh", 3);

insert into study(maLop, maSV, semester, schoolYear)
values("ct177", "B2110084", 1, "2021-2022"),
("tn010", "B2110084", 1, "2021-2022"),
("ml014", "B2110084", 1, "2021-2022"),
("ct173", "B2110084", 1, "2021-2022"),
("ct175", "B2110084", 1, "2021-2022"),
("ct182", "B2110084", 2, "2021-2022"),
("ct178", "B2110084", 2, "2021-2022"),
("ct188", "B2110084", 2, "2021-2022"),
("ct241", "B2110084", 2, "2021-2022"),
("ct276", "B2110084", 2, "2021-2022");

insert into study(maLop, maSV, semester, schoolYear)
values("ct177", "B2110001", 1, "2021-2022"),
("tn010", "B2110001", 1, "2021-2022"),
("ml014", "B2110001", 1, "2021-2022"),
("ct173", "B2110001", 1, "2021-2022"),
("ct175", "B2110001", 1, "2021-2022"),
("ct182", "B2110001", 2, "2021-2022"),
("ct178", "B2110001", 2, "2021-2022"),
("ct188", "B2110001", 2, "2021-2022"),
("ct241", "B2110001", 2, "2021-2022"),
("ct276", "B2110001", 2, "2021-2022");

insert into mark
values("B2110084", "tn010", 'A', "2021-2022"),
("B2110084", "ml014", 'D',  "2021-2022"),
("B2110084", "ct177", 'C+',  "2021-2022"),
("B2110084", "ct173", 'A',  "2021-2022"),
("B2110084", "ct175", 'A',  "2021-2022"),
("B2110084", "ct182", 'B+', "2021-2022"),
("B2110084", "ct178", 'B+', "2021-2022"),
("B2110084", "ct241", 'A', "2021-2022"),
("B2110084", "ct188", 'A', "2021-2022"),
("B2110084", "ct276", 'A', "2021-2022");

insert into mark
values("B2110001", "tn010", 'A', "2021-2022"),
("B2110001", "ml014", 'D',  "2021-2022"),
("B2110001", "ct177", 'C+',  "2021-2022"),
("B2110001", "ct173", 'A',  "2021-2022"),
("B2110001", "ct175", 'A',  "2021-2022"),
("B2110001", "ct182", 'B+', "2021-2022"),
("B2110001", "ct178", 'B+', "2021-2022"),
("B2110001", "ct241", 'A', "2021-2022"),
("B2110001", "ct188", 'A', "2021-2022"),
("B2110001", "ct276", 'A', "2021-2022");

insert into admins
values("Kiet","nguyentrangiakiet47@gmail.com","GV123","admin1",  "4703");

select * from student;
select * from class;
select * from study order by maSV;
select * from  mark order by maSV;
select * from admins;
