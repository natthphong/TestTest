if not exists (SELECT *
               FROM sys.tables t
                        JOIN sys.schemas s ON (t.schema_id = s.schema_id)
               WHERE s.name = 'iam'
                 AND t.name = 'iam_ms_branch')
create table iam.iam_ms_branch
(
    branch_id int identity constraint ms_branch_pk primary key,
    branch_name varchar(50) not null,
    is_deleted varchar(1) not null,
    created_date datetime not null,
    created_by varchar(50),
    updated_date datetime,
    updated_by varchar(50)
)