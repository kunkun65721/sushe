package com.sushe.susheguanli.service;

import java.util.List;
import com.sushe.susheguanli.domain.MyStudentHabit;

/**
 * 学生习惯档案Service接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface IMyStudentHabitService 
{
    /**
     * 查询学生习惯档案
     * 
     * @param habitId 学生习惯档案主键
     * @return 学生习惯档案
     */
    public MyStudentHabit selectMyStudentHabitByHabitId(Long habitId);

    /**
     * 查询学生习惯档案列表
     * 
     * @param myStudentHabit 学生习惯档案
     * @return 学生习惯档案集合
     */
    public List<MyStudentHabit> selectMyStudentHabitList(MyStudentHabit myStudentHabit);

    /**
     * 新增学生习惯档案
     * 
     * @param myStudentHabit 学生习惯档案
     * @return 结果
     */
    public int insertMyStudentHabit(MyStudentHabit myStudentHabit);

    /**
     * 修改学生习惯档案
     * 
     * @param myStudentHabit 学生习惯档案
     * @return 结果
     */
    public int updateMyStudentHabit(MyStudentHabit myStudentHabit);

    /**
     * 批量删除学生习惯档案
     * 
     * @param habitIds 需要删除的学生习惯档案主键集合
     * @return 结果
     */
    public int deleteMyStudentHabitByHabitIds(Long[] habitIds);

    /**
     * 删除学生习惯档案信息
     * 
     * @param habitId 学生习惯档案主键
     * @return 结果
     */
    public int deleteMyStudentHabitByHabitId(Long habitId);
}
