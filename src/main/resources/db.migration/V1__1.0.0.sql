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

    FOREIGN KEY (owner_pet_id) REFERENCES owner_pet(id),
    primary key (id)
);

create table if not exists appointment (
    id uuid,
    pet_id uuid,
    create_date_time timestamp not null,

    FOREIGN KEY (pet_id) REFERENCES pet(id),
    primary key (id)
);



