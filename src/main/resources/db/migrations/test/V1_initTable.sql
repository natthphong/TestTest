IF NOT EXISTS (SELECT *
               FROM sys.schemas
               WHERE name = 'iam2')
BEGIN
    EXEC('CREATE SCHEMA iam2');
END


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'iam2'
                 AND t.name = 'iam2_ms_user')
create table iam2.iam2_ms_user
(
    user_id int identity constraint iam_ms_user_pk primary key,
    mobile_no varchar(10),
    user_code varchar(255) not null,
    first_name_th varchar(255),
    middle_name_th varchar(255),
    last_name_th varchar(255),
    first_name_en varchar(255),
    middle_name_en varchar(255),
    last_name_en varchar(255),
    no_of_fail_time int,
    status varchar(50) ,
    life_license_no varchar(255),
    life_license_expired_date date,
    non_life_license_no varchar(255),
    non_life_license_expired_date date,
    department_code varchar(10),
    is_admin varchar(1) not null,
    is_deleted varchar(1) not null,
    created_date datetime not null,
    created_by varchar(50),
    updated_date datetime,
    updated_by varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'iam_ms_user_ui01')
create unique index iam_ms_user_ui01 on iam2.iam2_ms_user(user_code)
    where
    is_deleted = 'N';
    USE autar_sale;


