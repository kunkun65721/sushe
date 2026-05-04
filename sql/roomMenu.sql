-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('宿舍房间', '3', '1', 'room', 'susheguanli/room/index', 1, 0, 'C', '0', '0', 'susheguanli:room:list', '#', 'admin', sysdate(), '', null, '宿舍房间菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('宿舍房间查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:room:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('宿舍房间新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:room:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('宿舍房间修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:room:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('宿舍房间删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:room:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('宿舍房间导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:room:export',       '#', 'admin', sysdate(), '', null, '');