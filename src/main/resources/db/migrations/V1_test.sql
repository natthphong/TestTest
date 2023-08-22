IF NOT EXISTS (SELECT *
               FROM sys.schemas
               WHERE name = 'iam')
BEGIN
    EXEC('CREATE SCHEMA iam');
END