-- liquebase formatted sql
-- changeset abdullinru:14
Create TABLE users (
    id          bigint primary key,
    chat_id     bigint not null,
    shelter     varchar
);