-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报修记录', '2000', '1', 'repair', 'susheguanli/repair/index', 1, 0, 'C', '0', '0', 'susheguanli:repair:list', '#', 'admin', sysdate(), '', null, '报修记录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报修记录查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:repair:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报修记录新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:repair:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报修记录修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:repair:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报修记录删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:repair:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报修记录导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:repair:export',       '#', 'admin', sysdate(), '', null, '');