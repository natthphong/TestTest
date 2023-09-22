DECLARE @ROLEADMIN_ID INT;
DECLARE @AMS_ID INT;
DECLARE @AD_USER_ID INT;
DECLARE @DBEAVER_USER_ID INT;
DECLARE @FILM_USER_ID INT;

SET @AMS_ID = (SELECT system_id
               from temp.temp_ms_system
               where system_code = 'AST_temp')

INSERT INTO temp.temp_ms_role (role_code, role_name, role_icon, system_id, is_deleted, created_date, created_by,
                             updated_date, updated_by)
VALUES ('AST_temp_admin', 'Authorization Management System', null, @AMS_ID, 'N', GETDATE(), 'admin', null, null)
SET @ROLEADMIN_ID = (select role_id from temp.temp_ms_role where role_code = 'AST_temp_admin')

INSERT INTO temp.temp_ms_role_object (object_id,
                                      role_id,
                                      system_id,
                                      is_deleted,
                                      created_date,
                                      created_by,
                                      updated_date,
                                      updated_by)
SELECT tmo.object_id,
       @ROLEADMIN_ID,
       @AMS_ID,
       'N',
       GETDATE(),
       'ADMIN',
       null,
       null
FROM temp.temp_ms_object tmo
WHERE tmo.system_id = @AMS_ID
  AND is_deleted = 'N';

SET @AD_USER_ID = (SELECT user_id from temp.temp_ms_user where user_code = 'User_AutoSaleTool@scbcorpdev.onmicrosoft.com');
SET @DBEAVER_USER_ID = (SELECT user_id from temp.temp_ms_user where user_code = 'JustinDbeaver@example.com');
SET @FILM_USER_ID = (SELECT user_id from temp.temp_ms_user where user_code = 'FlimTest@example.com');

INSERT INTO temp.temp_ms_user_role (role_id, user_id, system_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (@ROLEADMIN_ID, @AD_USER_ID, @AMS_ID, 'N', GETDATE(), 'ADMIN', null, null)
    INSERT INTO temp.temp_ms_user_role (role_id, user_id, system_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (@ROLEADMIN_ID, @FILM_USER_ID, @AMS_ID, 'N', GETDATE(), 'ADMIN', null, null)
INSERT INTO temp.temp_ms_user_role (role_id, user_id, system_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (@ROLEADMIN_ID, @DBEAVER_USER_ID, @AMS_ID, 'N', GETDATE(), 'ADMIN', null, null)
