create table if not exists owner_pet (
    id uuid,
    name varchar(255) not null,
    city varchar(255) not null,
    street varchar(255) not null,
    number_house varchar(255) not null,
    registration_date timestamp not null,

    primary key (id)
);

create table if not exists pet (
    id uuid,
    owner_pet_id uuid,
    age integer not null,
    weight integer not null,
    name varchar(255) not null,
    registration_date timestamp not null,
    old_owner text [],

    foreign key (owner_pet_id) references owner_pet(id),
    primary key (id)
);

create table if not exists appointment (
    id uuid,
    pet_id uuid,
    create_date_time timestamp not null,

    foreign key (pet_id) references pet(id),
    primary key (id)
);

create table users (
    email varchar(255) not null primary key,
    password varchar(255) not null,
    user_type varchar(255) not null
);

create table permission (
    id uuid primary KEY,
    permission varchar(255) NOT NULL
);

create table user_permission (
    user_email VARCHAR(255) NOT NULL,
    permission_id UUID NOT NULL,
    PRIMARY KEY (user_email, permission_id),
    FOREIGN KEY (user_email) REFERENCES users(email),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
);
