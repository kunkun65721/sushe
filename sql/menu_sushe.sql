-- 宿舍管理菜单SQL
-- 执行此SQL前请确保菜单ID不与现有菜单冲突

-- 添加宿舍管理一级菜单
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2000, '宿舍管理', 0, 4, 'sushe', NULL, 1, 0, 'M', '0', '0', '', 'house', 'admin', sysdate());

-- 添加宿舍楼管理子菜单
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2001, '宿舍楼管理', 2000, 1, 'building', 'susheguanli/building/index', 1, 0, 'C', '0', '0', 'susheguanli:building:list', 'tree', 'admin', sysdate());

-- 添加房间管理子菜单
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2002, '房间管理', 2000, 2, 'room', 'susheguanli/room/index', 1, 0, 'C', '0', '0', 'susheguanli:room:list', 'tree', 'admin', sysdate());

-- 添加宿舍楼按钮权限
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2003, '宿舍楼新增', 2001, 1, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:add', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2004, '宿舍楼修改', 2001, 2, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:edit', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2005, '宿舍楼删除', 2001, 3, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:remove', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2006, '宿舍楼导出', 2001, 4, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:export', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2007, '宿舍楼查询', 2001, 5, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:query', '#', 'admin', sysdate());

-- 添加房间按钮权限
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2008, '房间新增', 2002, 1, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:add', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2009, '房间修改', 2002, 2, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:edit', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2010, '房间删除', 2002, 3, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:remove', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2011, '房间导出', 2002, 4, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:export', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time)
VALUES(2012, '房间查询', 2002, 5, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:query', '#', 'admin', sysdate());

-- 分配给超级管理员角色 (假设 role_id = 1)
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2000);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2001);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2002);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2003);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2004);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2005);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2006);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2007);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2008);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2009);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2010);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2011);
INSERT INTO sys_role_menu (role_id, menu_id) VALUES(1, 2012);