IF NOT EXISTS (SELECT *
               FROM sys.schemas
               WHERE name = 'application')
BEGIN
    EXEC('CREATE SCHEMA application');
END


IF NOT EXISTS (SELECT *
               FROM sys.schemas
               WHERE name = 'temp')
BEGIN
    EXEC('CREATE SCHEMA temp');
END



if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_title')
create table application.ms_title --
(
    id           int identity
        constraint ms_title_pk
        primary key,
    code_th      varchar(10) not null,
    desc_th      varchar(255),
    code_en      varchar(10),
    desc_en      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)

if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_document')
create table application.ms_document --
(
    id           int identity
        constraint ms_document_pk
        primary key,
    code         varchar(10) not null,
    desc_th      varchar(255),
    desc_en      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_occupation')
create table application.ms_occupation --
(
    id           int identity
        constraint ms_occupation_pk
        primary key,
    code         varchar(10) not null,
    desc_th      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_address_province')
create table application.ms_address_province --
(
    id           int identity
        constraint ms_address_province_pk
        primary key,
    code         varchar(10) not null,
    desc_th      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_address_amphur')
create table application.ms_address_amphur --
(
    id               int identity
        constraint ms_address_amphur_pk
        primary key,
    code             varchar(10) not null,
    desc_th          varchar(255),
    province_code    varchar(10) not null,
    province_desc_th varchar(255),
    is_deleted       varchar(1)  not null,
    created_date     datetime    not null,
    created_by       varchar(50),
    updated_date     datetime,
    updated_by       varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_address_district')
create table application.ms_address_district --
(
    id               int identity
        constraint ms_address_district_pk
        primary key,
    code             varchar(10) not null,
    desc_th          varchar(255),
    province_code    varchar(10) not null,
    province_desc_th varchar(255),
    amphur_code      varchar(10) not null,
    amphur_desc_th   varchar(255),
    postcode         varchar(5),
    is_deleted       varchar(1)  not null,
    created_date     datetime    not null,
    created_by       varchar(50),
    updated_date     datetime,
    updated_by       varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_product_type')
create table application.ms_product_type --
(
    id           int identity
        constraint ms_product_type_pk
        primary key,
    code         varchar(10) not null,
    desc_th      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_product_sub_type')
create table application.ms_product_sub_type --
(
    id           int identity
        constraint ms_product_sub_type_pk
        primary key,
    code         varchar(10) not null,
    desc_th      varchar(255),
    product_code varchar(10) not null,
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_vehicle_type')
create table application.ms_vehicle_type --
(
    id           int identity
        constraint ms_vehicle_type_pk
        primary key,
    code         varchar(10) not null,
    desc_th      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_brand')
create table application.ms_brand --
(
    id           int identity
        constraint ms_brand_pk
        primary key,
    code         varchar(10) not null,
    desc_en      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_model')
create table application.ms_model --
(
    id           int identity
        constraint ms_model_pk
        primary key,
    code         varchar(10) not null,
    description  varchar(255),
    brand_code   varchar(10) not null,
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)



if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_car_plate_province')
create table application.ms_car_plate_province --
(
    id           int identity
        constraint ms_car_plate_province_pk
        primary key,
    code         varchar(10) not null,
    desc_th      varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_engine_type')
create table application.ms_engine_type --
(
    id           int identity
        constraint ms_engine_type_pk
        primary key,
    code         varchar(10) not null,
    description  varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_color')
create table application.ms_color --
(
    id           int identity
        constraint ms_color_pk
        primary key,
    code         varchar(10) not null,
    description  varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_insurance_type')
create table application.ms_insurance_type --
(
    id           int identity
        constraint ms_insurance_type_pk
        primary key,
    code         varchar(10) not null,
    description  varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_insurance_company')
create table application.ms_insurance_company --
(
    id           int identity
        constraint ms_insurance_company_pk
        primary key,
    code         varchar(10) not null,
    description  varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_vehicle_source_insurance')
create table application.ms_vehicle_source_insurance --
(
    id           int identity
        constraint ms_vehicle_source_insurance_pk
        primary key,
    code         varchar(10) not null,
    description  varchar(255),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)


if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'application'
                 AND t.name = 'ms_isic')
create table application.ms_isic
(
    id           int identity
        constraint ms_isic_pk
        primary key,
    isic         varchar(10) not null,
    "desc"       varchar(255),
    group_isic   int,
    incomefactor int,
    sdis_level   int,
    dms          varchar(1),
    is_deleted   varchar(1)  not null,
    created_date datetime    not null,
    created_by   varchar(50),
    updated_date datetime,
    updated_by   varchar(50)
)
