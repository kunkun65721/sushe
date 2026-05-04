# Room管理没显示的修复计划

## 问题分析
Room管理在页面上没有显示，可能原因：
1. 菜单没有添加到数据库（sys_menu表）
2. 权限标识没有注册（sys_menu或sys_post表）
3. 前端菜单没有配置

## 修复步骤

### 步骤 1：在 sys_menu 表中添加宿舍管理菜单
需要添加顶级菜单"宿舍管理"和子菜单"宿舍楼管理"、"房间管理"

### 步骤 2：SQL语句
```sql
-- 添加宿舍管理一级菜单 (假设 menu_id = 2000)
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2000, '宿舍管理', 0, 4, 'sushe', NULL, 1, 0, 'M', '0', '0', '', 'house', 'admin', sysdate());

-- 添加宿舍楼管理子菜单 (假设 menu_id = 2001)
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2001, '宿舍楼管理', 2000, 1, 'building', 'susheguanli/building/index', 1, 0, 'C', '0', '0', 'susheguanli:building:list', 'tree', 'admin', sysdate());

-- 添加房间管理子菜单 (假设 menu_id = 2002)
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2002, '房间管理', 2000, 2, 'room', 'susheguanli/room/index', 1, 0, 'C', '0', '0', 'susheguanli:room:list', 'tree', 'admin', sysdate());

-- 添加按钮权限
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2003, '宿舍楼新增', 2001, 1, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:add', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2004, '宿舍楼修改', 2001, 2, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:edit', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2005, '宿舍楼删除', 2001, 3, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:remove', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2006, '宿舍楼导出', 2001, 4, '', '', 1, 0, 'F', '0', '0', 'susheguanli:building:export', '#', 'admin', sysdate());

INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2007, '房间新增', 2002, 1, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:add', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2008, '房间修改', 2002, 2, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:edit', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2009, '房间删除', 2002, 3, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:remove', '#', 'admin', sysdate());
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time) 
VALUES(2010, '房间导出', 2002, 4, '', '', 1, 0, 'F', '0', '0', 'susheguanli:room:export', '#', 'admin', sysdate());
```

### 步骤 3：分配角色权限
将新菜单分配给超级管理员角色（menu_id = 1）

## 涉及文件
- `d:\Trae CN\实验项目\SuShe\sql\menu_sushe.sql`（需创建）