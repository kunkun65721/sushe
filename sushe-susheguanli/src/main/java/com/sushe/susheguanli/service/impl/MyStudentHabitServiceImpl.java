package com.sushe.susheguanli.service.impl;

import java.util.List;
import com.sushe.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sushe.susheguanli.mapper.MyStudentHabitMapper;
import com.sushe.susheguanli.domain.MyStudentHabit;
import com.sushe.susheguanli.service.IMyStudentHabitService;

/**
 * 学生习惯档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@Service
public class MyStudentHabitServiceImpl implements IMyStudentHabitService 
{
    @Autowired
    private MyStudentHabitMapper myStudentHabitMapper;

    /**
     * 查询学生习惯档案
     * 
     * @param habitId 学生习惯档案主键
     * @return 学生习惯档案
     */
    @Override
    public MyStudentHabit selectMyStudentHabitByHabitId(Long habitId)
    {
        return myStudentHabitMapper.selectMyStudentHabitByHabitId(habitId);
    }

    /**
     * 查询学生习惯档案列表
     * 
     * @param myStudentHabit 学生习惯档案
     * @return 学生习惯档案
     */
    @Override
    public List<MyStudentHabit> selectMyStudentHabitList(MyStudentHabit myStudentHabit)
    {
        return myStudentHabitMapper.selectMyStudentHabitList(myStudentHabit);
    }

    /**
     * 新增学生习惯档案
     * 
     * @param myStudentHabit 学生习惯档案
     * @return 结果
     */
    @Override
    public int insertMyStudentHabit(MyStudentHabit myStudentHabit)
    {
        myStudentHabit.setCreateTime(DateUtils.getNowDate());
        return myStudentHabitMapper.insertMyStudentHabit(myStudentHabit);
    }

    /**
     * 修改学生习惯档案
     * 
     * @param myStudentHabit 学生习惯档案
     * @return 结果
     */
    @Override
    public int updateMyStudentHabit(MyStudentHabit myStudentHabit)
    {
        myStudentHabit.setUpdateTime(DateUtils.getNowDate());
        return myStudentHabitMapper.updateMyStudentHabit(myStudentHabit);
    }

    /**
     * 批量删除学生习惯档案
     * 
     * @param habitIds 需要删除的学生习惯档案主键
     * @return 结果
     */
    @Override
    public int deleteMyStudentHabitByHabitIds(Long[] habitIds)
    {
        return myStudentHabitMapper.deleteMyStudentHabitByHabitIds(habitIds);
    }

    /**
     * 删除学生习惯档案信息
     * 
     * @param habitId 学生习惯档案主键
     * @return 结果
     */
    @Override
    public int deleteMyStudentHabitByHabitId(Long habitId)
    {
        return myStudentHabitMapper.deleteMyStudentHabitByHabitId(habitId);
    }
}
