# 修复宿舍楼状态字典SQL

## 问题分析
原SQL错误：1292 - Incorrect datetime value: 'admin' for column 'create_time' at row 1

原因：sys_dict_type 表的字段顺序与预期不符，'admin' 被当作了 datetime 类型值。

## 修复后的SQL

### 方案1：指定列名插入
```sql
-- 添加宿舍楼状态字典
DELETE FROM sys_dict_type WHERE dict_type = 'dormitory_building_status';
INSERT INTO sys_dict_type (dict_id, dict_type, dict_name, status, create_by, create_time) 
VALUES(100, 'dormitory_building_status', '宿舍楼状态字典', '0', 'admin', sysdate());

DELETE FROM sys_dict_data WHERE dict_type = 'dormitory_building_status';
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark) 
VALUES(100, 'dormitory_building_status', '正常', '0', '', '0', 'admin', sysdate(), '正常使用');
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark) 
VALUES(101, 'dormitory_building_status', '停用', '1', '', '0', 'admin', sysdate(), '已停用');
```

### 方案2：使用 CURRENT_TIMESTAMP 代替 sysdate()
如果上述方案仍有问题，可尝试：
```sql
DELETE FROM sys_dict_type WHERE dict_type = 'dormitory_building_status';
INSERT INTO sys_dict_type (dict_id, dict_type, dict_name, status, create_by, create_time) 
VALUES(100, 'dormitory_building_status', '宿舍楼状态字典', '0', 'admin', CURRENT_TIMESTAMP);

DELETE FROM sys_dict_data WHERE dict_type = 'dormitory_building_status';
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark) 
VALUES(100, 'dormitory_building_status', '正常', '0', '', '0', 'admin', CURRENT_TIMESTAMP, '正常使用');
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark) 
VALUES(101, 'dormitory_building_status', '停用', '1', '', '0', 'admin', CURRENT_TIMESTAMP, '已停用');
```

## 涉及文件
- `d:\Trae CN\实验项目\SuShe\sql\dict_building_status.sql`