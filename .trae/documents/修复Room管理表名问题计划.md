# 修复 Room 管理的表名问题

## 问题分析
Room 相关的 Mapper XML 和 Domain 类中表名仍使用 `sys_dormitory_room`，需要改为 `my_dormitory_room`

## 修复步骤

### 1. 修改 SysDormitoryRoomMapper.xml
文件：`sushe-susheguanli/src/main/resources/mapper/susheguanli/SysDormitoryRoomMapper.xml`
将 `sys_dormitory_room` 改为 `my_dormitory_room`

### 2. 修改 SysDormitoryRoom.java
文件：`sushe-susheguanli/src/main/java/com/sushe/susheguanli/domain/SysDormitoryRoom.java`
更新注释中的表名

### 3. 其他检查
检查是否还有其他表（student, accommodation, inspection, repair）需要修改

## 涉及文件
- `d:\Trae CN\实验项目\SuShe\sushe-susheguanli\src\main\resources\mapper\susheguanli\SysDormitoryRoomMapper.xml`
- `d:\Trae CN\实验项目\SuShe\sushe-susheguanli\src\main\java\com\sushe\susheguanli\domain\SysDormitoryRoom.java`