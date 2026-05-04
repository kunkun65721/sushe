-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卫生检查记录', '2000', '1', 'inspection', 'susheguanli/inspection/index', 1, 0, 'C', '0', '0', 'susheguanli:inspection:list', '#', 'admin', sysdate(), '', null, '卫生检查记录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卫生检查记录查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:inspection:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卫生检查记录新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:inspection:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卫生检查记录修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:inspection:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卫生检查记录删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:inspection:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卫生检查记录导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'susheguanli:inspection:export',       '#', 'admin', sysdate(), '', null, '');