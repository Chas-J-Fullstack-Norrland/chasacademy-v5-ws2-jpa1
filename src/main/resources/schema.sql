Drop table if exists comment;
drop table if exists post;


create table post (
    post_id serial primary key,
    title varchar(128) not null,
    posttext text not null,
    author varchar(32) not null,
    publish_date timestamp default now(),
    create_date timestamp default now()
);

create table comment (
    comment_id serial primary key,
    post_id int references post(post_id),
    flag boolean default false,
    title varchar(64) not null,
    comment text not null,
    comment_date timestamp default now()
);


insert into post values(1,'Första inlägget', 'I en enkel bloggdatabas.','Admin', now(), now() - INTERVAL '2 days');