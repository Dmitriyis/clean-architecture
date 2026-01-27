create table if not exists owner_pet (
    id uuid,
    name varchar(255) not null,
    city varchar(255) not null,
    street varchar(255) not null,
    number_house varchar(255) not null,
    registration_date timestamp not null,
    phone text not null,

    primary key (id)
);

create table if not exists medical_card (
    id uuid,
    update_time timestamp not null,

    primary key (id)
);

create table if not exists pet (
    id uuid,
    owner_pet_id uuid,
    age integer not null,
    weight integer not null,
    name varchar(255) not null,
    registration_date timestamp not null,
    medical_card_id uuid,

    foreign key (owner_pet_id) references owner_pet(id),
    foreign key (medical_card_id) references medical_card(id),
    primary key (id)
);


create table if not exists doctor (
    id uuid,
    name varchar(255) not null,
    profession varchar(255) not null,
    work_experience integer not null,

    primary key (id)
);

create table if not exists reception (
    id uuid,
    medical_card_id uuid,
    doctor_id uuid,
    conclusions text not null,
    start_reception timestamp not null,
    end_reception timestamp not null,
    analyses text[],

    foreign key (medical_card_id) references medical_card(id),
    foreign key (doctor_id) references doctor(id),
    primary key (id)
);

create table if not exists outbox (
    id uuid,
    event_type text not null,
    aggregate_id varchar(255) not null,
    aggregate_type text not null,
    payload text not null,
    occurred_on_utc timestamp not null,
    processed_on_utc timestamp,
    primary key (id)
);

create table if not exists analysis (
    id uuid,
    name varchar(255),
    description varchar(255),
    execution_time integer,
    medical_card_id UUID,
    create_date timestamp,

    foreign key (medical_card_id) references medical_card(id),
    primary key (id)
);







create table if not exists users (
    email varchar(255) not null primary key,
    password varchar(255) not null,
    user_type varchar(255) not null
);

create table if not exists permission (
    id uuid primary KEY,
    permission varchar(255) NOT NULL
);

create table if not exists user_permission (
    user_email VARCHAR(255) NOT NULL,
    permission_id UUID NOT NULL,
    PRIMARY KEY (user_email, permission_id),
    FOREIGN KEY (user_email) REFERENCES users(email),
    FOREIGN KEY (permission_id) REFERENCES permission(id)
);
