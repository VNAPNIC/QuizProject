--create database
create database QuizDB
go
use QuizDB
go

--create tables
create table [Admin]
(
	username nvarchar(100) primary key,
	[password] nvarchar(200),
	full_name nvarchar(200),
	birthday datetime,
	email nvarchar(100)
)
go

create table Question
(
	question_id int primary key identity,
	content text
)
go

create table Answer
(
	answer_id int primary key identity,
	content text,
	question_id int,
	[status] bit,
	constraint FK_Answer_Question
	FOREIGN KEY (question_id)
	REFERENCES Question(question_id)
)
go

create table [User]
(
	[user_id] int primary key identity,
	username nvarchar(100) unique,
	[password] nvarchar(200),
	email nvarchar(100),
	birthday datetime,
	[address] nvarchar(500)
)
go

create table Quiz
(
	quiz_id int primary key identity,
	date_change datetime,
	[money] int,
	[user_id] int,
	constraint FK_Quiz_User
	FOREIGN KEY ([user_id])
	REFERENCES [User]([user_id])
)
go

create table QuizDetail
(
	quiz_id int,
	question_id int,
	[status] bit,
	constraint FK_QuizDetail_Quiz
	FOREIGN KEY (quiz_id)
	REFERENCES Quiz(quiz_id),
	constraint FK_QuizDetail_Question
	FOREIGN KEY (question_id)
	REFERENCES Question(question_id)
)
go

--insert data
insert into [User](username, [password], email, birthday, [address]) values ('test', 'test', 'test@gmail.com', '5/10/1992', N'Ha Noi');
insert into [Admin] values ('admin', 'admin', 'Nguyen Van A', '5/10/1991', 'admin@gmail.com')


insert into Question([content]) values ('In the United States the television broadcast standard is ... ?')
insert into Answer(content, question_id, [status]) values ('PAL', 1, 0)
insert into Answer(content, question_id, [status]) values ('NSTC', 1, 0)
insert into Answer(content, question_id, [status]) values ('SECAM', 1, 0)
insert into Answer(content, question_id, [status]) values ('RGB', 1, 1)

insert into Question([content]) values ('In the UK, what type of installation requires a firemans switch ?')
insert into Answer(content, question_id, [status]) values ('High Pressure Sodium Lighting', 2, 0)
insert into Answer(content, question_id, [status]) values ('Water', 2, 1)
insert into Answer(content, question_id, [status]) values ('Water Features', 2, 0)
insert into Answer(content, question_id, [status]) values ('Neon Lighting', 2, 0)

insert into Question([content]) values ('Which countrys Antarctic claim covers the greatest swath of longitude ?')
insert into Answer(content, question_id, [status]) values ('Neon Lighting', 3, 0)
insert into Answer(content, question_id, [status]) values ('New Zealand', 3, 1)
insert into Answer(content, question_id, [status]) values ('Australia', 3, 0)
insert into Answer(content, question_id, [status]) values ('Argentina', 3, 0)

insert into Question([content]) values ('1 + 1 = ?')
insert into Answer(content, question_id, [status]) values ('1', 4, 0)
insert into Answer(content, question_id, [status]) values ('3', 4, 0)
insert into Answer(content, question_id, [status]) values ('2', 4, 1)
insert into Answer(content, question_id, [status]) values ('4', 4, 0)

insert into Question([content]) values ('8 / 0 = ?')
insert into Answer(content, question_id, [status]) values ('1', 5, 0)
insert into Answer(content, question_id, [status]) values ('8', 5, 0)
insert into Answer(content, question_id, [status]) values ('0', 5, 0)
insert into Answer(content, question_id, [status]) values ('Orther', 5, 1)

insert into Question([content]) values ('100 x 1 = ?')
insert into Answer(content, question_id, [status]) values ('100', 6, 1)
insert into Answer(content, question_id, [status]) values ('1', 6, 0)
insert into Answer(content, question_id, [status]) values ('1000', 6, 0)
insert into Answer(content, question_id, [status]) values ('10', 6, 0)

insert into Question([content]) values ('1000 - 0 = ?')
insert into Answer(content, question_id, [status]) values ('10', 7, 0)
insert into Answer(content, question_id, [status]) values ('1000', 7, 1)
insert into Answer(content, question_id, [status]) values ('100', 7, 0)
insert into Answer(content, question_id, [status]) values ('10000', 7, 0)

insert into Question([content]) values ('Ham is meat from ?')
insert into Answer(content, question_id, [status]) values ('A cow', 8, 0)
insert into Answer(content, question_id, [status]) values ('A pig', 8, 1)
insert into Answer(content, question_id, [status]) values ('A hamster', 8, 0)
insert into Answer(content, question_id, [status]) values ('A monkey', 8, 0)

insert into Question([content]) values ('West is the opposite direction to ?')
insert into Answer(content, question_id, [status]) values ('East', 9, 1)
insert into Answer(content, question_id, [status]) values ('North', 9, 0)
insert into Answer(content, question_id, [status]) values ('South', 9, 0)
insert into Answer(content, question_id, [status]) values ('No correct answer', 9, 0)

insert into Question([content]) values ('To present in a condensed form to list the main points in a brief and comprehensive manner ?')
insert into Answer(content, question_id, [status]) values ('Summarize', 10, 1)
insert into Answer(content, question_id, [status]) values ('Stall', 10, 0)
insert into Answer(content, question_id, [status]) values ('Pocket', 10, 0)
insert into Answer(content, question_id, [status]) values ('Loop', 10, 0)

insert into Question([content]) values ('Which Indian city, famous for its lagoons, is known as the Venice of the East ?')
insert into Answer(content, question_id, [status]) values ('Hyderabad', 11, 0)
insert into Answer(content, question_id, [status]) values ('Jaipur', 11, 0)
insert into Answer(content, question_id, [status]) values ('Mumbai', 11, 0)
insert into Answer(content, question_id, [status]) values ('Alleppey', 11, 1)

select * from Question
select * from Answer

select * from Quiz
select * from QuizDetail
