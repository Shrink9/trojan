create table if not exists my_default.domain (
    id int auto_increment comment 'id' primary key,
    value varchar(100) not null comment '域名',
    constraint value_uk unique (value)
) comment '域名表';
