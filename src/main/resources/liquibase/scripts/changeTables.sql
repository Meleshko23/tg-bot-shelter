-- liquebase formatted sql
-- changeset abdullinru:7
Alter table pet_owner add column start_trial_period DATE;
Alter table pet_owner add column end_trial_period DATE;
Alter table pet_owner add column status_trial INTEGER;

-- changeset abdullinru:8
Alter table pet_owner RENAME TO dog_owners;

-- changeset abdullinru:9
Alter table pets ADD COLUMN type INTEGER;

-- changeset abdullinru:10
create table cat_owners
(
    id                 bigint primary key,
    chat_id            bigint  not null,
    name               varchar not null,
    mail               varchar not null,
    phone              varchar not null,
    start_trial_period DATE,
    end_trial_period   DATE,
    status_trial       INTEGER,
    pet_id             bigint REFERENCES pets (id)
);
-- changeset abdullinru:11
ALTER table keeping_pet DROP COLUMN pet_owner_id;
ALTER table keeping_pet ADD COLUMN dog_owner_id bigint REFERENCES dog_owners (id);
ALTER table keeping_pet ADD COLUMN cat_owner_id bigint REFERENCES cat_owners (id);

-- changeset abdullinru:12
ALTER TABLE photo_pet DROP COLUMN data;