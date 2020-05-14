insert into Blogger (age, name) VALUES (38, 'Zoltan');
insert into Blogger (age, name) VALUES (21, 'John');
insert into stories (title, content, posted, blogger_id) values ('First title', 'First content', '2020-05-07', 1);
insert into stories (title, content, posted, blogger_id) values ('Second title2', 'Second content from SQL file', '2020-05-08', 2);
insert into stories (title, content, posted, blogger_id) values ('Test title', 'Test content from SQL file', '2020-05-3', (select id from blogger where name = 'Zoltan'));
insert into stories (title, content, posted, blogger_id) values ('Test title2', 'Test content2', '2020-05-4', (select id from blogger where name = 'John'));
insert into stories (title, content, posted, blogger_id) values ('Hi', 'Some content', CURRENT_DATE(), (select id from blogger where name = 'Zoltan'));
