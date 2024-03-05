use therapyv2;

drop table if exists `numbers`;
drop table if exists `users`;
drop table if exists `addresses`;
drop table if exists `emergency_contacts`;

drop table if exists `user_types`;


create table `user_types` (
	`id` int auto_increment,
    `description` varchar(50),
    
    primary key (`id`)
);

create table `addresses`(
	`id` int auto_increment,
    `address_line_1` varchar(100),
    `address_line_2` varchar(100),
    `city` varchar(50),
    `state` varchar(50),
    `zipcode` varchar(15),
    
    primary key(`id`)
);

create table `emergency_contacts`(
	`id` int auto_increment,
    `first_name` varchar(50),
    `last_name` varchar(50),
    `phone_number` varchar(15),
    
    primary key(`id`)
);

create table `users`(

	`id` int auto_increment,
    `first_name` varchar(50),
    `last_name` varchar(50),
    `email_address` varchar(100),
    `Date_of_Birth` date,
    `phone_number` varchar(15),
    `username` varchar(68),
    `password` varchar(68),
    `user_type_id` int default null,
    `address_id` int default null,
    `emergency_contact_id` int default null,
    `therapist_id` int default null,
    `enable` tinyint,
    
    primary key(`id`),
    constraint `users_user_type_id_fk` foreign key (`user_type_id`) references `user_types`(`id`),
    constraint `users_address_id_fk` foreign key(`address_id`) references `addresses`(`id`),
    constraint `users_emergency_contact_id` foreign key(`emergency_contact_id`) references `emergency_contacts`(`id`)
);

create table `numbers`(
	`id` int auto_increment,
    `user_id` int default null,
    `anxiety` int,
    `depression` int,
    `self_harm` int,
    `energy_level` int,
	`craving` int,
    `impulse` int,
    `physical_harm` tinyint,
    `date` date,
    
    primary key(`id`),
    constraint `numbers_user_id_fk` foreign key (`user_id`) references `users`(`id`) 

);



insert into `user_types`(`description`)
values("Client");
insert into `user_types`(`description`)
values("Therapist");
insert into `user_types`(`description`)
values("Developer");



