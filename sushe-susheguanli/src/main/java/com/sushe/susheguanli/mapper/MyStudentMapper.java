package com.sushe.susheguanli.mapper;

import java.util.List;
import com.sushe.susheguanli.domain.MyStudent;

/**
 * 学生信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface MyStudentMapper 
{
    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息主键
     * @return 学生信息
     */
    public MyStudent selectMyStudentByStudentId(Long studentId);

    /**
     * 查询学生信息列表
     * 
     * @param myStudent 学生信息
     * @return 学生信息集合
     */
    public List<MyStudent> selectMyStudentList(MyStudent myStudent);

    /**
     * 新增学生信息
     * 
     * @param myStudent 学生信息
     * @return 结果
     */
    public int insertMyStudent(MyStudent myStudent);

    /**
     * 修改学生信息
     * 
     * @param myStudent 学生信息
     * @return 结果
     */
    public int updateMyStudent(MyStudent myStudent);

    /**
     * 删除学生信息
     * 
     * @param studentId 学生信息主键
     * @return 结果
     */
    public int deleteMyStudentByStudentId(Long studentId);

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyStudentByStudentIds(Long[] studentIds);
}
