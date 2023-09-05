create table appointments (id  bigserial not null, start_time timestamp not null, doctor_id int8, patient_id int8, primary key (id));
create table doctors (id  bigserial not null, age int4 not null, full_name varchar(255) not null, uuid varchar(255) not null, primary key (id));
create table patients (id  bigserial not null, birth_date date not null, full_name varchar(255) not null, uuid varchar(255) not null, primary key (id));

