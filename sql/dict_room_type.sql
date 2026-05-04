-- 添加房间类型字典
DELETE FROM sys_dict_type WHERE dict_type = 'dormitory_room_type';
INSERT INTO sys_dict_type (dict_id, dict_type, dict_name, status, create_by, create_time)
VALUES(17, 'dormitory_room_type', '房间类型字典', '0', 'admin', sysdate());

DELETE FROM sys_dict_data WHERE dict_type = 'dormitory_room_type';
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(117, 'dormitory_room_type', '2人间', '2人间', '', '0', 'admin', sysdate(), '2个床位');
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(118, 'dormitory_room_type', '4人间', '4人间', '', '0', 'admin', sysdate(), '4个床位');
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(119, 'dormitory_room_type', '6人间', '6人间', '', '0', 'admin', sysdate(), '6个床位');