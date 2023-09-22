DECLARE @temp_ID INT;
DECLARE @ROOT_ID INT;
DECLARE @SYSOBJ_ID INT;
DECLARE @USEROBJ_ID INT;
DECLARE @CONSYS_ID INT;
DECLARE @MNSYSOBJ_ID INT;
DECLARE @MNSYSROLE_ID INT;
DECLARE @MNSYSROLEOBJ_ID INT;
DECLARE @SYSROLEUSER_ID INT;
SET @temp_ID = (SELECT system_id FROM temp.temp_ms_system where system_code = 'AST_temp');
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp', N'Authorization Management System', @temp_ID, null, N'N', N'2023-08-24 02:01:20.217', N'ADMIN', null, null);
SET @ROOT_ID = (SELECT object_id from temp.temp_ms_object where object_code = 'temp');
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_MN_SYSTEM', N'Menu System', @temp_ID, @ROOT_ID, N'N', N'2023-08-24 02:01:29.943', N'ADMIN', null, null);
SET @SYSOBJ_ID = (SELECT object_id from temp.temp_ms_object where object_code = 'temp_MN_SYSTEM');
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_VW_SYSTEM', N'View System', @temp_ID, @SYSOBJ_ID, N'N', N'2023-08-24 02:01:29.983', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_CREATE_SYSTEM', N'Create System', @temp_ID, @SYSOBJ_ID, N'N', N'2023-08-24 02:01:30.023', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES ( N'temp_BT_CONFIG_SYSTEM', N'Config System', @temp_ID, @SYSOBJ_ID, N'N', N'2023-08-24 02:01:30.060', N'ADMIN', null, null);
SET @CONSYS_ID = (SELECT object_id from temp.temp_ms_object where object_code = 'temp_BT_CONFIG_SYSTEM');
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_DELETE_SYSTEM', N'Delete System', @temp_ID, @SYSOBJ_ID, N'N', N'2023-08-24 02:01:30.100', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_MN_SYSTEM_OBJECT', N'Menu Object with in System', @temp_ID, @CONSYS_ID, N'N', N'2023-08-24 02:01:34.193', N'ADMIN', null, null);
SET @MNSYSOBJ_ID = (SELECT object_id from temp.temp_ms_object where object_code = 'temp_MN_SYSTEM_OBJECT')
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_VW_OBJECT', N'View Object with in System', @temp_ID, @MNSYSOBJ_ID, N'N', N'2023-08-24 02:01:34.237', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_CREATE_OBJECT', N'Create Object with in System', @temp_ID, @MNSYSOBJ_ID, N'N', N'2023-08-24 02:01:34.273', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_EDIT_OBJECT', N'Edit Object with in System', @temp_ID, @MNSYSOBJ_ID, N'N', N'2023-08-24 02:01:34.313', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_DELETE_OBJECT', N'Delete Object with in System', @temp_ID, @MNSYSOBJ_ID, N'N', N'2023-08-24 02:01:34.350', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_MN_SYSTEM_ROLE', N'Menu Role with in System', @temp_ID, @CONSYS_ID, N'N', N'2023-08-24 02:01:42.673', N'ADMIN', null, null);
SET @MNSYSROLE_ID = (SELECT object_id from temp.temp_ms_object where object_code = 'temp_MN_SYSTEM_ROLE')
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_VW_ROLE', N'View Role with in System', @temp_ID, @MNSYSROLE_ID, N'N', N'2023-08-24 02:01:42.713', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_CREATE_ROLE', N'Create Role with in System', @temp_ID, @MNSYSROLE_ID, N'N', N'2023-08-24 02:01:52.620', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_EDIT_ROLE', N'Edit Role with in System', @temp_ID, @MNSYSROLE_ID, N'N', N'2023-08-24 02:01:55.497', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_DELETE_ROLE', N'Delete Role with in System', @temp_ID, @MNSYSROLE_ID, N'N', N'2023-08-24 02:01:57.577', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_MN_SYSTEM_ROLE_OBJECT', N'Menu Relationship between Role and Object with in System', @temp_ID, @MNSYSROLE_ID, N'N', N'2023-08-24 02:02:02.527', N'ADMIN', null, null);
SET @MNSYSROLEOBJ_ID = (SELECT object_id from temp.temp_ms_object where object_code = 'temp_MN_SYSTEM_ROLE_OBJECT')
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_VW_SYSTEM_ROLE_OBJECT', N'View Relationship between Role and Object with in System', @temp_ID, @MNSYSROLEOBJ_ID, N'N', N'2023-08-24 02:02:02.567', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_MANAGE_SYSTEM_ROLE_OBJECT', N'Manage Relationship between Role and Object with in System', @temp_ID, @MNSYSROLEOBJ_ID, N'N', N'2023-08-24 02:02:02.607', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_MN_SYSTEM_ROLE_USER', N'Menu Relationship between Role and User with in System', @temp_ID, @MNSYSROLE_ID, N'N', N'2023-08-24 02:02:08.393', N'ADMIN', null, null);
SET @SYSROLEUSER_ID = (SELECT object_id from temp.temp_ms_object where object_code = 'temp_MN_SYSTEM_ROLE_USER')
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_VW_SYSTEM_ROLE_USER', N'View Relationship between Role and User with in System', @temp_ID, @SYSROLEUSER_ID, N'N', N'2023-08-24 02:02:08.430', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_CREATE_SYSTEM_ROLE_USER', N'Create Relationship between Role and User with in System', @temp_ID, @SYSROLEUSER_ID, N'N', N'2023-08-24 02:02:08.470', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_DELETE_SYSTEM_ROLE_USER', N'Delete Relationship between Role and User with in System', @temp_ID, @SYSROLEUSER_ID, N'N', N'2023-08-24 02:02:08.510', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_MN_SYSTEM_USER', N'Menu for view user with in System', @temp_ID, @CONSYS_ID, N'N', N'2023-08-24 02:02:15.337', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_MN_USER', N'Menu for manage user profile', @temp_ID, @ROOT_ID, N'N', N'2023-08-24 02:02:15.383', N'ADMIN', null, null);
SET @USEROBJ_ID = (SELECT object_id FROM temp.temp_ms_object WHERE object_code = 'temp_MN_USER')
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_CREATE_USER', N'Create user profile', @temp_ID, @USEROBJ_ID, N'N', N'2023-08-24 02:02:15.423', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_EDIT_USER', N'Edit user profile', @temp_ID, @USEROBJ_ID, N'N', N'2023-08-24 02:02:15.460', N'ADMIN', null, null);
INSERT INTO ast.temp.temp_ms_object (object_code, object_name, system_id, parent_id, is_deleted, created_date, created_by, updated_date, updated_by) VALUES (N'temp_BT_CHANGE_USER_STATUS', N'Change user status', @temp_ID, @USEROBJ_ID, N'N', N'2023-08-24 02:02:15.500', N'ADMIN', null, null);


