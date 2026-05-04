package com.sushe.susheguanli.service.impl;

import java.util.List;
import com.sushe.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sushe.susheguanli.mapper.MyStudentMapper;
import com.sushe.susheguanli.domain.MyStudent;
import com.sushe.susheguanli.service.IMyStudentService;

/**
 * 学生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@Service
public class MyStudentServiceImpl implements IMyStudentService 
{
    @Autowired
    private MyStudentMapper myStudentMapper;

    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息主键
     * @return 学生信息
     */
    @Override
    public MyStudent selectMyStudentByStudentId(Long studentId)
    {
        return myStudentMapper.selectMyStudentByStudentId(studentId);
    }

    /**
     * 查询学生信息列表
     * 
     * @param myStudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<MyStudent> selectMyStudentList(MyStudent myStudent)
    {
        return myStudentMapper.selectMyStudentList(myStudent);
    }

    /**
     * 新增学生信息
     * 
     * @param myStudent 学生信息
     * @return 结果
     */
    @Override
    public int insertMyStudent(MyStudent myStudent)
    {
        myStudent.setCreateTime(DateUtils.getNowDate());
        return myStudentMapper.insertMyStudent(myStudent);
    }

    /**
     * 修改学生信息
     * 
     * @param myStudent 学生信息
     * @return 结果
     */
    @Override
    public int updateMyStudent(MyStudent myStudent)
    {
        myStudent.setUpdateTime(DateUtils.getNowDate());
        return myStudentMapper.updateMyStudent(myStudent);
    }

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteMyStudentByStudentIds(Long[] studentIds)
    {
        return myStudentMapper.deleteMyStudentByStudentIds(studentIds);
    }

    /**
     * 删除学生信息信息
     * 
     * @param studentId 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteMyStudentByStudentId(Long studentId)
    {
        return myStudentMapper.deleteMyStudentByStudentId(studentId);
    }
}
