package com.sushe.susheguanli.service.impl;

import java.util.List;
import com.sushe.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sushe.susheguanli.mapper.MyAccommodationMapper;
import com.sushe.susheguanli.domain.MyAccommodation;
import com.sushe.susheguanli.service.IMyAccommodationService;

/**
 * 住宿记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@Service
public class MyAccommodationServiceImpl implements IMyAccommodationService 
{
    @Autowired
    private MyAccommodationMapper myAccommodationMapper;

    /**
     * 查询住宿记录
     * 
     * @param accommodationId 住宿记录主键
     * @return 住宿记录
     */
    @Override
    public MyAccommodation selectMyAccommodationByAccommodationId(Long accommodationId)
    {
        return myAccommodationMapper.selectMyAccommodationByAccommodationId(accommodationId);
    }

    /**
     * 查询住宿记录列表
     * 
     * @param myAccommodation 住宿记录
     * @return 住宿记录
     */
    @Override
    public List<MyAccommodation> selectMyAccommodationList(MyAccommodation myAccommodation)
    {
        return myAccommodationMapper.selectMyAccommodationList(myAccommodation);
    }

    /**
     * 新增住宿记录
     * 
     * @param myAccommodation 住宿记录
     * @return 结果
     */
    @Override
    public int insertMyAccommodation(MyAccommodation myAccommodation)
    {
        myAccommodation.setCreateTime(DateUtils.getNowDate());
        return myAccommodationMapper.insertMyAccommodation(myAccommodation);
    }

    /**
     * 修改住宿记录
     * 
     * @param myAccommodation 住宿记录
     * @return 结果
     */
    @Override
    public int updateMyAccommodation(MyAccommodation myAccommodation)
    {
        myAccommodation.setUpdateTime(DateUtils.getNowDate());
        return myAccommodationMapper.updateMyAccommodation(myAccommodation);
    }

    /**
     * 批量删除住宿记录
     * 
     * @param accommodationIds 需要删除的住宿记录主键
     * @return 结果
     */
    @Override
    public int deleteMyAccommodationByAccommodationIds(Long[] accommodationIds)
    {
        return myAccommodationMapper.deleteMyAccommodationByAccommodationIds(accommodationIds);
    }

    /**
     * 删除住宿记录信息
     * 
     * @param accommodationId 住宿记录主键
     * @return 结果
     */
    @Override
    public int deleteMyAccommodationByAccommodationId(Long accommodationId)
    {
        return myAccommodationMapper.deleteMyAccommodationByAccommodationId(accommodationId);
    }
}
