package com.sushe.susheguanli.mapper;

import java.util.List;
import com.sushe.susheguanli.domain.MyDormitoryInspection;

/**
 * 卫生检查记录Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface MyDormitoryInspectionMapper 
{
    /**
     * 查询卫生检查记录
     * 
     * @param inspectionId 卫生检查记录主键
     * @return 卫生检查记录
     */
    public MyDormitoryInspection selectMyDormitoryInspectionByInspectionId(Long inspectionId);

    /**
     * 查询卫生检查记录列表
     * 
     * @param myDormitoryInspection 卫生检查记录
     * @return 卫生检查记录集合
     */
    public List<MyDormitoryInspection> selectMyDormitoryInspectionList(MyDormitoryInspection myDormitoryInspection);

    /**
     * 新增卫生检查记录
     * 
     * @param myDormitoryInspection 卫生检查记录
     * @return 结果
     */
    public int insertMyDormitoryInspection(MyDormitoryInspection myDormitoryInspection);

    /**
     * 修改卫生检查记录
     * 
     * @param myDormitoryInspection 卫生检查记录
     * @return 结果
     */
    public int updateMyDormitoryInspection(MyDormitoryInspection myDormitoryInspection);

    /**
     * 删除卫生检查记录
     * 
     * @param inspectionId 卫生检查记录主键
     * @return 结果
     */
    public int deleteMyDormitoryInspectionByInspectionId(Long inspectionId);

    /**
     * 批量删除卫生检查记录
     * 
     * @param inspectionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyDormitoryInspectionByInspectionIds(Long[] inspectionIds);
}
