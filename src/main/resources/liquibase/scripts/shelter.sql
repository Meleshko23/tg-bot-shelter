-- liquebase formatted sql
-- changeset abdullinru:1
create table volunteers(
        id      bigint primary key,
        chat_id bigint not null,
        name    varchar not null
);
-- changeset abdullinru:2
create table pets(
        id      bigint primary key,
        name    varchar not null,
        age     integer check (age > 0)
);
-- changeset abdullinru:3
create table pet_owner(
        id      bigint primary key,
        chat_id bigint not null,
        name    varchar not null,
        mail    varchar not null,
        phone   varchar not null,
        pet_id  bigint REFERENCES pets (id)
);
-- changeset abdullinru:4
create table photo_pet(
        id          bigint primary key,
        file_path    varchar not null,
        file_size    BIGINT not null,
        media_type   varchar not null,
        data        oid     not null,
        pet_id      bigint REFERENCES pets (id)
);
-- changeset abdullinru:5
create table keeping_pet(
        id              bigint primary key,
        chat_id         bigint     not null,
        info_pet         text        not null,
        date            DATE   not null,
        photo_pet_id     bigint REFERENCES photo_pet (id),
        pet_owner_id     bigint REFERENCES pet_owner (id)
);
-- changeset abdullinru:6
create table info(
        name    varchar primary key,
        details text not null
);