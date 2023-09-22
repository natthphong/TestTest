if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_organization')
create table temp.temp_ms_organization
(
    org_id       int identity
        constraint temp_ms_organization_pk primary key,
    org_code     nvarchar(50)  not null,
    org_name     nvarchar(255) collate Latin1_General_CI_AS not null,
    parent_id    int,
    is_deleted   nvarchar(1)   not null,
    created_date datetime     not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'temp_ms_organization_ui01')
create unique index temp_ms_organization_ui01 on temp.temp_ms_organization (org_code) where
        is_deleted = 'N';



if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_user')
create table temp.temp_ms_user
(
    user_id int identity constraint temp_ms_user_pk primary key,
    mobile_no nvarchar(10),
    user_code nvarchar(255) not null,
    first_name_th nvarchar(255) collate Latin1_General_CI_AS,
    middle_name_th nvarchar(255) collate Latin1_General_CI_AS,
    last_name_th nvarchar(255) collate Latin1_General_CI_AS,
    first_name_en nvarchar(255) not null,
    middle_name_en nvarchar(255),
    last_name_en nvarchar(255) not null,
    no_of_fail_time int,
    status nvarchar(50) ,
    life_license_no nvarchar(255),
    life_license_expired_date date,
    non_life_license_no nvarchar(255),
    non_life_license_expired_date date,
    department_code nvarchar(50),
    customer_level_id int not null,
    supervisor_code nvarchar(50),
    branch_id int,
    email nvarchar(100) not null,
    active_date date,
    is_admin nvarchar(1) not null,
    is_deleted nvarchar(1) not null,
    created_date datetime not null,
    created_by varchar(50),
    updated_date datetime,
    updated_by varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'temp_ms_user_ui01')
create unique index temp_ms_user_ui01 on temp.temp_ms_user(user_code)
    where
    is_deleted = 'N';
if not exists(select *
              from sys.indexes
              where name = 'temp_ms_user_ui02')
create unique index temp_ms_user_ui02 on temp.temp_ms_user(email)
    where
    is_deleted = 'N';



if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_system')
create table temp.temp_ms_system
(
    system_id    int identity
        constraint temp_ms_system_pk primary key,
    system_code  nvarchar(50)  not null,
    system_name  nvarchar(255) not null,
    system_icon  nvarchar(500),
    is_deleted   nvarchar(1)   not null,
    created_date datetime     not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'temp_ms_system_ui01')
create unique index temp_ms_system_ui01 on temp.temp_ms_system (system_code) where
        is_deleted = 'N';


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_role')
create table temp.temp_ms_role
(
    role_id      int identity
        constraint temp_ms_role_pk primary key,
    role_code    nvarchar(50)  not null,
    role_name    nvarchar(255) not null,
    role_icon    nvarchar(500),
    system_id    int          not null
        constraint temp_ms_role_fk01 references temp.temp_ms_system,
    is_deleted   nvarchar(1)   not null,
    created_date datetime     not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'temp_ms_role_ui01')
create unique index temp_ms_role_ui01 on temp.temp_ms_role (role_code, system_id) where
        is_deleted = 'N';


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_user_role')
create table temp.temp_ms_user_role
(
    user_role_id int identity
        constraint temp_ms_user_role_pk primary key,
    role_id      int        not null
        constraint temp_ms_user_role_fk01 references temp.temp_ms_role,
    user_id      int        not null
        constraint temp_ms_user_role_fk02 references temp.temp_ms_user,
    system_id    int        not null
        constraint temp_ms_user_role_fk03 references temp.temp_ms_system,
    is_deleted   nvarchar(1) not null,
    created_date datetime   not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)

if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_object')
create table temp.temp_ms_object
(
    object_id    int identity
        constraint temp_ms_object_pk primary key,
    object_code  nvarchar(50)  not null,
    object_name  nvarchar(255) not null,
    system_id    int          not null
        constraint temp_ms_object_fk01 references temp.temp_ms_system,
    parent_id    int,
    is_deleted   nvarchar(1)   not null,
    created_date datetime     not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'temp_ms_object_uk01')
create unique index temp_ms_object_uk01 on temp.temp_ms_object (object_code, system_id) where
        is_deleted = 'N';



if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_role_object')
create table temp.temp_ms_role_object
(
    role_object_id int identity
        constraint temp_ms_role_object_pk primary key,
    object_id      int        not null
        constraint temp_ms_role_object_fk01 references temp.temp_ms_object,
    role_id        int        not null
        constraint temp_ms_role_object_fk02 references temp.temp_ms_role,
    system_id      int        not null
        constraint temp_ms_role_object_fk03 references temp.temp_ms_system,
    is_deleted     nvarchar(1) not null,
    created_date   datetime   not null,
    created_by     varchar(50),
    updated_date   datetime,
    updated_by     varchar(50)
)




    if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_branch')
create table temp.temp_ms_branch
(
    branch_id    int identity constraint ms_branch_pk primary key,
    branch_code  nvarchar(50) not null,
    branch_name  nvarchar(500) collate Latin1_General_CI_AS not null,
    is_deleted   nvarchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'temp_ms_branch_ui01')
create unique index temp_ms_branch_ui01 on temp.temp_ms_branch(branch_code)
    where
    is_deleted = 'N';


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'temp'
                 AND t.name = 'temp_ms_customer_level')
create table temp.temp_ms_customer_level
(
    cust_level_id   int identity constraint ms_customer_pk primary key,
    cust_level_code varchar(1) not null,
    is_deleted      nvarchar(1)   not null,
    created_date    datetime     not null,
    created_by      varchar(50),
    updated_date    datetime,
    updated_by      varchar(50)
) if not exists(select *
              from sys.indexes
              where name = 'temp_ms_customer_level_ui01')
create unique index temp_ms_customer_level_ui01 on temp.temp_ms_customer_level(cust_level_code)
    where
    is_deleted = 'N';
