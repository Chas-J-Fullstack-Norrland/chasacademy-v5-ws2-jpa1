
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
    title varchar(64) not null,
    comment text not null,
    comment_date timestamp default now()
);


create table post_comments (
    comment_id int not null references comment(comment_id),
    post_id int not null references post(post_id),
    primary key(comment_id, post_id)
);

insert into post values(1,'Första inlägget', 'I en enkel bloggdatabas.','Admin', now(), now() - INTERVAL '2 days');