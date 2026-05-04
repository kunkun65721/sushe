-- 学生生活习惯档案表
DROP TABLE IF EXISTS `my_student_habit`;
CREATE TABLE `my_student_habit` (
  `habit_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `student_id` BIGINT(20) NOT NULL COMMENT '学生ID',
  `sleep_habit` VARCHAR(50) DEFAULT NULL COMMENT '作息习惯',
  `sleep_time` VARCHAR(50) DEFAULT NULL COMMENT '睡觉时间',
  `wake_time` VARCHAR(50) DEFAULT NULL COMMENT '起床时间',
  `nap_habit` VARCHAR(50) DEFAULT NULL COMMENT '午休习惯',
  `bath_frequency` VARCHAR(50) DEFAULT NULL COMMENT '洗澡频率',
  `clean_importance` VARCHAR(50) DEFAULT NULL COMMENT '卫生重视程度',
  `tolerate_dirty` VARCHAR(50) DEFAULT NULL COMMENT '能否接受室友不打扫',
  `study_location` VARCHAR(50) DEFAULT NULL COMMENT '学习地点',
  `friend_visit` VARCHAR(50) DEFAULT NULL COMMENT '欢迎室友带朋友',
  `gaming_mic` VARCHAR(50) DEFAULT NULL COMMENT '是否接受室友开麦游戏',
  `snoring` VARCHAR(50) DEFAULT NULL COMMENT '是否打呼噜',
  `fill_status` CHAR(1) DEFAULT '0' COMMENT '填写状态',
  `fill_time` DATETIME DEFAULT NULL COMMENT '填写时间',
  `create_by` VARCHAR(64) DEFAULT '' COMMENT '创建者',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `update_by` VARCHAR(64) DEFAULT '' COMMENT '更新者',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`habit_id`),
  UNIQUE KEY `uk_student_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生习惯档案表';

-- 字典类型
DELETE FROM sys_dict_type WHERE dict_type IN (
  'dormitory_sleep_habit', 'dormitory_sleep_time', 'dormitory_wake_time',
  'dormitory_nap_habit', 'dormitory_bath_frequency', 'dormitory_clean_importance',
  'dormitory_tolerate_dirty', 'dormitory_study_location', 'dormitory_friend_visit',
  'dormitory_gaming_mic', 'dormitory_snoring', 'sys_fill_status'
);

INSERT INTO sys_dict_type (dict_id, dict_type, dict_name, status, create_by, create_time) VALUES
(30, 'dormitory_sleep_habit', '作息习惯', '0', 'admin', sysdate()),
(31, 'dormitory_sleep_time', '睡觉时间', '0', 'admin', sysdate()),
(32, 'dormitory_wake_time', '起床时间', '0', 'admin', sysdate()),
(33, 'dormitory_nap_habit', '午休习惯', '0', 'admin', sysdate()),
(34, 'dormitory_bath_frequency', '洗澡频率', '0', 'admin', sysdate()),
(35, 'dormitory_clean_importance', '卫生重视程度', '0', 'admin', sysdate()),
(36, 'dormitory_tolerate_dirty', '能否接受室友不打扫', '0', 'admin', sysdate()),
(37, 'dormitory_study_location', '学习地点', '0', 'admin', sysdate()),
(38, 'dormitory_friend_visit', '欢迎室友带朋友', '0', 'admin', sysdate()),
(39, 'dormitory_gaming_mic', '是否接受室友开麦游戏', '0', 'admin', sysdate()),
(40, 'dormitory_snoring', '是否打呼噜', '0', 'admin', sysdate()),
(41, 'sys_fill_status', '填写状态', '0', 'admin', sysdate());

-- 字典数据
DELETE FROM sys_dict_data WHERE dict_type IN (
  'dormitory_sleep_habit', 'dormitory_sleep_time', 'dormitory_wake_time',
  'dormitory_nap_habit', 'dormitory_bath_frequency', 'dormitory_clean_importance',
  'dormitory_tolerate_dirty', 'dormitory_study_location', 'dormitory_friend_visit',
  'dormitory_gaming_mic', 'dormitory_snoring', 'sys_fill_status'
);

-- 作息习惯
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(130, 'dormitory_sleep_habit', '早起型', '早起型', '', 'primary', '0', 'admin', sysdate(), ''),
(131, 'dormitory_sleep_habit', '正常型', '正常型', '', 'success', '0', 'admin', sysdate(), ''),
(132, 'dormitory_sleep_habit', '晚起型', '晚起型', '', 'warning', '0', 'admin', sysdate(), '');

-- 睡觉时间
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(133, 'dormitory_sleep_time', '21:00前', '21:00前', '', 'primary', '0', 'admin', sysdate(), ''),
(134, 'dormitory_sleep_time', '21:00-22:00', '21:00-22:00', '', 'primary', '0', 'admin', sysdate(), ''),
(135, 'dormitory_sleep_time', '22:00-23:00', '22:00-23:00', '', 'success', '0', 'admin', sysdate(), ''),
(136, 'dormitory_sleep_time', '23:00后', '23:00后', '', 'warning', '0', 'admin', sysdate(), '');

-- 起床时间
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(137, 'dormitory_wake_time', '06:00前', '06:00前', '', 'primary', '0', 'admin', sysdate(), ''),
(138, 'dormitory_wake_time', '06:00-07:00', '06:00-07:00', '', 'success', '0', 'admin', sysdate(), ''),
(139, 'dormitory_wake_time', '07:00-08:00', '07:00-08:00', '', 'success', '0', 'admin', sysdate(), ''),
(140, 'dormitory_wake_time', '08:00后', '08:00后', '', 'warning', '0', 'admin', sysdate(), '');

-- 午休习惯
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(141, 'dormitory_nap_habit', '每天午休', '每天午休', '', 'primary', '0', 'admin', sysdate(), ''),
(142, 'dormitory_nap_habit', '偶尔午休', '偶尔午休', '', 'success', '0', 'admin', sysdate(), ''),
(143, 'dormitory_nap_habit', '从不午休', '从不午休', '', 'warning', '0', 'admin', sysdate(), '');

-- 洗澡频率
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(144, 'dormitory_bath_frequency', '每天', '每天', '', 'primary', '0', 'admin', sysdate(), ''),
(145, 'dormitory_bath_frequency', '每两天', '每两天', '', 'success', '0', 'admin', sysdate(), ''),
(146, 'dormitory_bath_frequency', '每周', '每周', '', 'warning', '0', 'admin', sysdate(), ''),
(147, 'dormitory_bath_frequency', '看情况', '看情况', '', 'info', '0', 'admin', sysdate(), '');

-- 卫生重视程度
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(148, 'dormitory_clean_importance', '非常重要', '非常重要', '', 'danger', '0', 'admin', sysdate(), ''),
(149, 'dormitory_clean_importance', '重要', '重要', '', 'warning', '0', 'admin', sysdate(), ''),
(150, 'dormitory_clean_importance', '一般', '一般', '', 'info', '0', 'admin', sysdate(), '');

-- 能否接受室友不打扫
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(151, 'dormitory_tolerate_dirty', '完全接受', '完全接受', '', 'success', '0', 'admin', sysdate(), ''),
(152, 'dormitory_tolerate_dirty', '勉强接受', '勉强接受', '', 'warning', '0', 'admin', sysdate(), ''),
(153, 'dormitory_tolerate_dirty', '不能接受', '不能接受', '', 'danger', '0', 'admin', sysdate(), '');

-- 学习地点
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(154, 'dormitory_study_location', '宿舍', '宿舍', '', 'primary', '0', 'admin', sysdate(), ''),
(155, 'dormitory_study_location', '图书馆', '图书馆', '', 'success', '0', 'admin', sysdate(), ''),
(156, 'dormitory_study_location', '都可以', '都可以', '', 'info', '0', 'admin', sysdate(), '');

-- 欢迎室友带朋友
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(157, 'dormitory_friend_visit', '欢迎', '欢迎', '', 'success', '0', 'admin', sysdate(), ''),
(158, 'dormitory_friend_visit', '无所谓', '无所谓', '', 'info', '0', 'admin', sysdate(), ''),
(159, 'dormitory_friend_visit', '不喜欢', '不喜欢', '', 'warning', '0', 'admin', sysdate(), '');

-- 是否接受室友开麦游戏
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(160, 'dormitory_gaming_mic', '完全接受', '完全接受', '', 'success', '0', 'admin', sysdate(), ''),
(161, 'dormitory_gaming_mic', '无所谓', '无所谓', '', 'info', '0', 'admin', sysdate(), ''),
(162, 'dormitory_gaming_mic', '不能接受', '不能接受', '', 'danger', '0', 'admin', sysdate(), '');

-- 是否打呼噜
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(163, 'dormitory_snoring', '是', '是', '', 'warning', '0', 'admin', sysdate(), ''),
(164, 'dormitory_snoring', '否', '否', '', 'success', '0', 'admin', sysdate(), '');

-- 填写状态
INSERT INTO sys_dict_data (dict_code, dict_type, dict_label, dict_value, css_class, list_class, status, create_by, create_time, remark) VALUES
(165, 'sys_fill_status', '未填写', '0', '', 'info', '0', 'admin', sysdate(), ''),
(166, 'sys_fill_status', '已填写', '1', '', 'success', '0', 'admin', sysdate(), '');
