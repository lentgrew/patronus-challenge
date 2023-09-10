set search_path to patronus;

create table if not exists users (
    id                      VARCHAR PRIMARY KEY not null,
    created_at              timestamp not null,
    modified_at             timestamp not null,
    first_name              VARCHAR,
    last_name               VARCHAR,
    birthday                date,
    address                 VARCHAR
);

create index if not exists users_id on users using btree (id);

create table if not exists device (
    uuid                    VARCHAR PRIMARY KEY not null,
    created_at              timestamp not null,
    modified_at             timestamp not null,
    serial_number           VARCHAR,
    phone_number            VARCHAR,
    model                   VARCHAR,
    user_id                 VARCHAR
);

create index if not exists device_uuid on device using btree (uuid);
create index if not exists device_user_id on device using btree (user_id);