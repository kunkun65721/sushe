package com.sushe.susheguanli.service;

import java.util.List;
import com.sushe.susheguanli.domain.MyStudent;

/**
 * 学生信息Service接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface IMyStudentService 
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
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的学生信息主键集合
     * @return 结果
     */
    public int deleteMyStudentByStudentIds(Long[] studentIds);

    /**
     * 删除学生信息信息
     * 
     * @param studentId 学生信息主键
     * @return 结果
     */
    public int deleteMyStudentByStudentId(Long studentId);
}
