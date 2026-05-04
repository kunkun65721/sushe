package com.sushe.susheguanli.service.impl;

import java.util.List;
import com.sushe.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sushe.susheguanli.mapper.MyDormitoryInspectionMapper;
import com.sushe.susheguanli.domain.MyDormitoryInspection;
import com.sushe.susheguanli.service.IMyDormitoryInspectionService;

/**
 * 卫生检查记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@Service
public class MyDormitoryInspectionServiceImpl implements IMyDormitoryInspectionService 
{
    @Autowired
    private MyDormitoryInspectionMapper myDormitoryInspectionMapper;

    /**
     * 查询卫生检查记录
     * 
     * @param inspectionId 卫生检查记录主键
     * @return 卫生检查记录
     */
    @Override
    public MyDormitoryInspection selectMyDormitoryInspectionByInspectionId(Long inspectionId)
    {
        return myDormitoryInspectionMapper.selectMyDormitoryInspectionByInspectionId(inspectionId);
    }

    /**
     * 查询卫生检查记录列表
     * 
     * @param myDormitoryInspection 卫生检查记录
     * @return 卫生检查记录
     */
    @Override
    public List<MyDormitoryInspection> selectMyDormitoryInspectionList(MyDormitoryInspection myDormitoryInspection)
    {
        return myDormitoryInspectionMapper.selectMyDormitoryInspectionList(myDormitoryInspection);
    }

    /**
     * 新增卫生检查记录
     * 
     * @param myDormitoryInspection 卫生检查记录
     * @return 结果
     */
    @Override
    public int insertMyDormitoryInspection(MyDormitoryInspection myDormitoryInspection)
    {
        myDormitoryInspection.setCreateTime(DateUtils.getNowDate());
        return myDormitoryInspectionMapper.insertMyDormitoryInspection(myDormitoryInspection);
    }

    /**
     * 修改卫生检查记录
     * 
     * @param myDormitoryInspection 卫生检查记录
     * @return 结果
     */
    @Override
    public int updateMyDormitoryInspection(MyDormitoryInspection myDormitoryInspection)
    {
        myDormitoryInspection.setUpdateTime(DateUtils.getNowDate());
        return myDormitoryInspectionMapper.updateMyDormitoryInspection(myDormitoryInspection);
    }

    /**
     * 批量删除卫生检查记录
     * 
     * @param inspectionIds 需要删除的卫生检查记录主键
     * @return 结果
     */
    @Override
    public int deleteMyDormitoryInspectionByInspectionIds(Long[] inspectionIds)
    {
        return myDormitoryInspectionMapper.deleteMyDormitoryInspectionByInspectionIds(inspectionIds);
    }

    /**
     * 删除卫生检查记录信息
     * 
     * @param inspectionId 卫生检查记录主键
     * @return 结果
     */
    @Override
    public int deleteMyDormitoryInspectionByInspectionId(Long inspectionId)
    {
        return myDormitoryInspectionMapper.deleteMyDormitoryInspectionByInspectionId(inspectionId);
    }
}
