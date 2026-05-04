package com.sushe.susheguanli.service.impl;

import java.util.List;
import com.sushe.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sushe.susheguanli.mapper.MyRepairMapper;
import com.sushe.susheguanli.domain.MyRepair;
import com.sushe.susheguanli.service.IMyRepairService;

/**
 * 报修记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@Service
public class MyRepairServiceImpl implements IMyRepairService 
{
    @Autowired
    private MyRepairMapper myRepairMapper;

    /**
     * 查询报修记录
     * 
     * @param repairId 报修记录主键
     * @return 报修记录
     */
    @Override
    public MyRepair selectMyRepairByRepairId(Long repairId)
    {
        return myRepairMapper.selectMyRepairByRepairId(repairId);
    }

    /**
     * 查询报修记录列表
     * 
     * @param myRepair 报修记录
     * @return 报修记录
     */
    @Override
    public List<MyRepair> selectMyRepairList(MyRepair myRepair)
    {
        return myRepairMapper.selectMyRepairList(myRepair);
    }

    /**
     * 新增报修记录
     * 
     * @param myRepair 报修记录
     * @return 结果
     */
    @Override
    public int insertMyRepair(MyRepair myRepair)
    {
        myRepair.setCreateTime(DateUtils.getNowDate());
        return myRepairMapper.insertMyRepair(myRepair);
    }

    /**
     * 修改报修记录
     * 
     * @param myRepair 报修记录
     * @return 结果
     */
    @Override
    public int updateMyRepair(MyRepair myRepair)
    {
        myRepair.setUpdateTime(DateUtils.getNowDate());
        return myRepairMapper.updateMyRepair(myRepair);
    }

    /**
     * 批量删除报修记录
     * 
     * @param repairIds 需要删除的报修记录主键
     * @return 结果
     */
    @Override
    public int deleteMyRepairByRepairIds(Long[] repairIds)
    {
        return myRepairMapper.deleteMyRepairByRepairIds(repairIds);
    }

    /**
     * 删除报修记录信息
     * 
     * @param repairId 报修记录主键
     * @return 结果
     */
    @Override
    public int deleteMyRepairByRepairId(Long repairId)
    {
        return myRepairMapper.deleteMyRepairByRepairId(repairId);
    }
}
