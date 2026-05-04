-- 修复菜单SQL（处理已存在的情况）

-- 1. 如果宿舍管理不存在则添加
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
SELECT 2000, '宿舍管理', 0, 4, 'sushe', NULL, 1, 0, 'M', '0', '0', '', 'house', 'admin', sysdate()
WHERE NOT EXISTS (SELECT 1 FROM sys_menu WHERE menu_id = 2000);

-- 2. 修改宿舍房间的parent_id为2000
UPDATE sys_menu SET parent_id = 2000 WHERE menu_id = 2007;

-- 3. 分配权限给超级管理员（忽略已存在的）
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2000);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2001);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2002);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2003);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2004);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2005);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2006);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2007);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2008);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2009);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2010);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2011);
INSERT IGNORE INTO sys_role_menu (role_id, menu_id) VALUES(1, 2012);