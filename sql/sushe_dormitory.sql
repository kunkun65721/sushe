-- ----------------------------
-- 学生宿舍管理系统数据库表
-- ----------------------------

-- ----------------------------
-- 1、宿舍楼表
-- ----------------------------
drop table if exists my_dormitory_building;
create table my_dormitory_building (
  building_id       bigint(20)      not null auto_increment    comment '宿舍楼ID',
  building_name     varchar(50)     not null                   comment '宿舍楼名称',
  building_type     char(1)         default '0'                comment '楼栋类型（0男 1女）',
  floor_count       int(4)          default 0                  comment '楼层数',
  room_count        int(4)          default 0                  comment '房间数',
  building_status   char(1)         default '0'                comment '宿舍楼状态（0正常 1停用）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (building_id)
) engine=innodb auto_increment=100 comment = '宿舍楼表';

-- ----------------------------
-- 初始化-宿舍楼表数据
-- ----------------------------
insert into my_dormitory_building values(1, '1号男生宿舍楼', '0', 6, 60, '0', 'admin', sysdate(), '', null, '男生宿舍楼');
insert into my_dormitory_building values(2, '2号男生宿舍楼', '0', 6, 60, '0', 'admin', sysdate(), '', null, '男生宿舍楼');
insert into my_dormitory_building values(3, '1号女生宿舍楼', '1', 6, 60, '0', 'admin', sysdate(), '', null, '女生宿舍楼');
insert into my_dormitory_building values(4, '2号女生宿舍楼', '1', 5, 50, '0', 'admin', sysdate(), '', null, '女生宿舍楼');


-- ----------------------------
-- 2、宿舍房间表
-- ----------------------------
drop table if exists my_dormitory_room;
create table my_dormitory_room (
  room_id           bigint(20)      not null auto_increment    comment '房间ID',
  building_id       bigint(20)      not null                   comment '所属宿舍楼ID',
  room_number       varchar(20)     not null                   comment '房间号',
  floor_number      int(4)          default 1                  comment '所在楼层',
  bed_count         int(4)          default 4                  comment '床位总数',
  bed_occupied      int(4)          default 0                  comment '已占用床位',
  room_type         varchar(20)     default '4人间'            comment '房间类型',
  room_status       char(1)         default '0'                comment '房间状态（0空置 1满员 2维修）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (room_id),
  unique key uk_building_room (building_id, room_number)
) engine=innodb auto_increment=100 comment = '宿舍房间表';

-- ----------------------------
-- 初始化-宿舍房间表数据
-- ----------------------------
insert into my_dormitory_room values(1, 1, '101', 1, 4, 4, '4人间', '1', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(2, 1, '102', 1, 4, 3, '4人间', '0', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(3, 1, '103', 1, 4, 2, '4人间', '0', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(4, 1, '201', 2, 4, 4, '4人间', '1', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(5, 1, '202', 2, 4, 1, '4人间', '0', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(6, 3, '101', 1, 4, 3, '4人间', '0', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(7, 3, '102', 1, 4, 4, '4人间', '1', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(8, 3, '201', 2, 6, 5, '6人间', '0', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(9, 3, '202', 2, 6, 6, '6人间', '1', 'admin', sysdate(), '', null, '');
insert into my_dormitory_room values(10, 4, '101', 1, 4, 2, '4人间', '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 3、学生信息表
-- ----------------------------
drop table if exists my_student;
create table my_student (
  student_id        bigint(20)      not null auto_increment    comment '学生ID',
  student_number    varchar(20)     not null                   comment '学号',
  student_name      varchar(30)     not null                   comment '学生姓名',
  gender            char(1)         default '0'                 comment '性别（0男 1女）',
  phone             varchar(11)     default ''                  comment '联系电话',
  email             varchar(50)     default ''                  comment '电子邮箱',
  major             varchar(50)     default ''                  comment '专业',
  class_name        varchar(50)     default ''                  comment '班级',
  grade             varchar(20)     default ''                  comment '年级',
  id_card           varchar(18)     default ''                  comment '身份证号',
  student_status    char(1)         default '0'                 comment '学生状态（0正常 1休学 2毕业）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (student_id),
  unique key uk_student_number (student_number)
) engine=innodb auto_increment=100 comment = '学生信息表';

-- ----------------------------
-- 初始化-学生信息表数据
-- ----------------------------
insert into my_student values(1, '2024001', '张三', '0', '13800138001', 'zhangsan@qq.com', '计算机科学与技术', '计科2401班', '2024', '110101199001011234', '0', 'admin', sysdate(), '', null, '');
insert into my_student values(2, '2024002', '李四', '0', '13800138002', 'lisi@qq.com', '计算机科学与技术', '计科2401班', '2024', '110101199001021234', '0', 'admin', sysdate(), '', null, '');
insert into my_student values(3, '2024003', '王五', '0', '13800138003', 'wangwu@qq.com', '软件工程', '软工2402班', '2024', '110101199001031234', '0', 'admin', sysdate(), '', null, '');
insert into my_student values(4, '2024004', '赵六', '0', '13800138004', 'zhaoliu@qq.com', '软件工程', '软工2401班', '2024', '110101199001041234', '0', 'admin', sysdate(), '', null, '');
insert into my_student values(5, '2023056', '小红', '1', '13800138005', 'xiaohong@qq.com', '网络工程', '网工2301班', '2023', '110101199001051234', '0', 'admin', sysdate(), '', null, '');
insert into my_student values(6, '2023057', '小丽', '1', '13800138006', 'xiaoli@qq.com', '网络工程', '网工2301班', '2023', '110101199001061234', '0', 'admin', sysdate(), '', null, '');
insert into my_student values(7, '2023058', '小美', '1', '13800138007', 'xiaomei@qq.com', '信息安全', '信安2301班', '2023', '110101199001071234', '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 4、住宿记录表
-- ----------------------------
drop table if exists my_accommodation;
create table my_accommodation (
  accommodation_id  bigint(20)      not null auto_increment    comment '住宿ID',
  student_id        bigint(20)      not null                   comment '学生ID',
  room_id           bigint(20)      not null                   comment '房间ID',
  bed_number        int(4)          default 1                  comment '床位号',
  check_in_date     date            not null                   comment '入住日期',
  check_out_date    date            default null               comment '退宿日期',
  status            char(1)         default '0'                 comment '状态（0在住 1已退宿）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (accommodation_id)
) engine=innodb auto_increment=100 comment = '住宿记录表';

-- ----------------------------
-- 初始化-住宿记录表数据
-- ----------------------------
insert into my_accommodation values(1, 1, 1, 1, '2024-09-01', null, '0', 'admin', sysdate(), '', null, '');
insert into my_accommodation values(2, 2, 1, 2, '2024-09-01', null, '0', 'admin', sysdate(), '', null, '');
insert into my_accommodation values(3, 3, 1, 3, '2024-09-01', null, '0', 'admin', sysdate(), '', null, '');
insert into my_accommodation values(4, 4, 1, 4, '2024-09-01', null, '0', 'admin', sysdate(), '', null, '');
insert into my_accommodation values(5, 5, 6, 1, '2023-09-01', null, '0', 'admin', sysdate(), '', null, '');
insert into my_accommodation values(6, 6, 6, 2, '2023-09-01', null, '0', 'admin', sysdate(), '', null, '');
insert into my_accommodation values(7, 7, 6, 3, '2023-09-01', null, '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 5、卫生检查记录表
-- ----------------------------
drop table if exists my_dormitory_inspection;
create table my_dormitory_inspection (
  inspection_id     bigint(20)      not null auto_increment    comment '检查ID',
  room_id           bigint(20)      not null                   comment '房间ID',
  inspector         varchar(50)     not null                   comment '检查人',
  inspection_date   datetime        not null                   comment '检查日期',
  score             int(4)          default 100                comment '评分（0-100）',
  remark            varchar(500)    default null               comment '备注',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (inspection_id)
) engine=innodb auto_increment=100 comment = '卫生检查记录表';

-- ----------------------------
-- 初始化-卫生检查记录表数据
-- ----------------------------
insert into my_dormitory_inspection values(1, 1, '管理员', '2024-10-15 10:00:00', 95, '卫生良好', 'admin', sysdate(), '', null);
insert into my_dormitory_inspection values(2, 2, '管理员', '2024-10-15 10:30:00', 88, '地面需加强清洁', 'admin', sysdate(), '', null);
insert into my_dormitory_inspection values(3, 3, '管理员', '2024-10-15 11:00:00', 92, '整体整洁', 'admin', sysdate(), '', null);
insert into my_dormitory_inspection values(4, 6, '管理员', '2024-10-16 09:00:00', 98, '非常整洁', 'admin', sysdate(), '', null);
insert into my_dormitory_inspection values(5, 7, '管理员', '2024-10-16 09:30:00', 85, '物品摆放需整理', 'admin', sysdate(), '', null);


-- ----------------------------
-- 6、报修记录表
-- ----------------------------
drop table if exists my_repair;
create table my_repair (
  repair_id         bigint(20)      not null auto_increment    comment '报修ID',
  room_id           bigint(20)      not null                   comment '房间ID',
  student_id        bigint(20)      not null                   comment '报修学生ID',
  repair_type       varchar(50)     not null                   comment '报修类型',
  description       varchar(500)    not null                   comment '报修描述',
  images            varchar(1000)   default null               comment '报修图片',
  status            char(1)         default '0'                 comment '状态（0待处理 1处理中 2已完成）',
  handler           varchar(50)     default null               comment '处理人',
  handle_result     varchar(500)    default null               comment '处理结果',
  apply_date        datetime        not null                   comment '申请日期',
  handle_date       datetime        default null               comment '处理日期',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (repair_id)
) engine=innodb auto_increment=100 comment = '报修记录表';

-- ----------------------------
-- 初始化-报修记录表数据
-- ----------------------------
insert into my_repair values(1, 1, 1, '水暖维修', '水龙头漏水', null, '2', '维修员', '已更换水龙头', '2024-10-10 08:30:00', '2024-10-10 14:00:00', 'admin', sysdate(), '', null);
insert into my_repair values(2, 2, 2, '电路维修', '床头插座无电', null, '1', null, null, '2024-10-18 20:00:00', null, 'admin', sysdate(), '', null);
insert into my_repair values(3, 3, 3, '门窗维修', '门锁损坏', null, '0', null, null, '2024-10-20 22:00:00', null, 'admin', sysdate(), '', null);
insert into my_repair values(4, 6, 5, '家具维修', '床板断裂', null, '2', '维修员', '已更换新床板', '2024-10-15 19:00:00', '2024-10-16 10:00:00', 'admin', sysdate(), '', null);


-- ----------------------------
-- 7、字典类型表（补充宿舍相关字典）
-- ----------------------------
delete from sys_dict_type where dict_type in ('dormitory_building_type', 'dormitory_room_status', 'accommodation_status', 'repair_status', 'repair_type');
insert into sys_dict_type values(11, '宿舍楼类型', 'dormitory_building_type', '0', 'admin', sysdate(), '', null, '宿舍楼类型列表');
insert into sys_dict_type values(12, '房间状态', 'dormitory_room_status', '0', 'admin', sysdate(), '', null, '房间状态列表');
insert into sys_dict_type values(13, '住宿状态', 'accommodation_status', '0', 'admin', sysdate(), '', null, '住宿状态列表');
insert into sys_dict_type values(14, '报修状态', 'repair_status', '0', 'admin', sysdate(), '', null, '报修状态列表');
insert into sys_dict_type values(15, '报修类型', 'repair_type', '0', 'admin', sysdate(), '', null, '报修类型列表');


-- ----------------------------
-- 8、字典数据表（补充宿舍相关字典数据）
-- ----------------------------
delete from sys_dict_data where dict_type in ('dormitory_building_type', 'dormitory_room_status', 'accommodation_status', 'repair_status', 'repair_type');
insert into sys_dict_data values(100, 1, '男生宿舍', '0', 'dormitory_building_type', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '男生宿舍楼');
insert into sys_dict_data values(101, 2, '女生宿舍', '1', 'dormitory_building_type', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '女生宿舍楼');

insert into sys_dict_data values(102, 1, '空置', '0', 'dormitory_room_status', '', 'success', 'Y', '0', 'admin', sysdate(), '', null, '房间空置中');
insert into sys_dict_data values(103, 2, '满员', '1', 'dormitory_room_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '房间已满员');
insert into sys_dict_data values(104, 3, '维修', '2', 'dormitory_room_status', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '房间维修中');

insert into sys_dict_data values(105, 1, '在住', '0', 'accommodation_status', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '正在住宿');
insert into sys_dict_data values(106, 2, '已退宿', '1', 'accommodation_status', '', 'info', 'N', '0', 'admin', sysdate(), '', null, '已办理退宿');

insert into sys_dict_data values(107, 1, '待处理', '0', 'repair_status', '', 'danger', 'Y', '0', 'admin', sysdate(), '', null, '等待处理');
insert into sys_dict_data values(108, 2, '处理中', '1', 'repair_status', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '正在处理');
insert into sys_dict_data values(109, 3, '已完成', '2', 'repair_status', '', 'success', 'N', '0', 'admin', sysdate(), '', null, '维修完成');

insert into sys_dict_data values(110, 1, '水暖维修', '水暖维修', 'repair_type', '', '', 'Y', '0', 'admin', sysdate(), '', null, '水管、暖气维修');
insert into sys_dict_data values(111, 2, '电路维修', '电路维修', 'repair_type', '', '', 'N', '0', 'admin', sysdate(), '', null, '电路、灯具维修');
insert into sys_dict_data values(112, 3, '门窗维修', '门窗维修', 'repair_type', '', '', 'N', '0', 'admin', sysdate(), '', null, '门窗、锁具维修');
insert into sys_dict_data values(113, 4, '家具维修', '家具维修', 'repair_type', '', '', 'N', '0', 'admin', sysdate(), '', null, '床、柜子等家具维修');
insert into sys_dict_data values(114, 5, '其他维修', '其他维修', 'repair_type', '', '', 'N', '0', 'admin', sysdate(), '', null, '其他维修类型');
