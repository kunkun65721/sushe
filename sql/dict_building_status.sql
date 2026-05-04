-- 添加宿舍楼状态字典
DELETE FROM sys_dict_type WHERE dict_type = 'dormitory_building_status';
INSERT INTO sys_dict_type (dict_id, dict_type, dict_name, status, create_by, create_time)
VALUES(16, 'dormitory_building_status', '宿舍楼状态字典', '0', 'admin', sysdate());

DELETE FROM sys_dict_data WHERE dict_type = 'dormitory_building_status';
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(115, 'dormitory_building_status', '正常', '0', '', '0', 'admin', sysdate(), '正常使用');
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, status, create_by, create_time, remark)
VALUES(116, 'dormitory_building_status', '停用', '1', '', '0', 'admin', sysdate(), '已停用');