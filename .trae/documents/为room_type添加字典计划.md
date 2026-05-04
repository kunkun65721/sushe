# 为 room\_type 添加字典

## 需求分析

`my_dormitory_room` 表的 `room_type` 字段（房间类型，如'4人间'、'6人间'）需要添加对应的字典数据。

## 实施步骤

### 步骤 1：在 sys\_dict\_type 中添加字典类型

```sql
DELETE FROM sys_dict_type WHERE dict_type = 'dormitory_room_type';
INSERT INTO sys_dict_type (dict_id, dict_type, dict_name, status, create_by, create_time)
VALUES(17, 'dormitory_room_type', '房间类型字典', '0', 'admin', sysdate());
```

### 步骤 2：在 sys_dict_data 中添加字典数据
```sql
DELETE FROM sys_dict_data WHERE dict_type = 'dormitory_room_type';
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(117, 'dormitory_room_type', '2人间', '2人间', '', '0', 'admin', sysdate(), '2个床位');
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(118, 'dormitory_room_type', '4人间', '4人间', '', '0', 'admin', sysdate(), '4个床位');
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(119, 'dormitory_room_type', '6人间', '6人间', '', '0', 'admin', sysdate(), '6个床位');
```

## 涉及文件

* `d:\Trae CN\实验项目\SuShe\sql\dict_room_type.sql`（新建）

