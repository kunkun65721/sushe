package com.sushe.susheguanli.mapper;

import java.util.List;
import com.sushe.susheguanli.domain.MyRepair;

/**
 * 报修记录Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface MyRepairMapper 
{
    /**
     * 查询报修记录
     * 
     * @param repairId 报修记录主键
     * @return 报修记录
     */
    public MyRepair selectMyRepairByRepairId(Long repairId);

    /**
     * 查询报修记录列表
     * 
     * @param myRepair 报修记录
     * @return 报修记录集合
     */
    public List<MyRepair> selectMyRepairList(MyRepair myRepair);

    /**
     * 新增报修记录
     * 
     * @param myRepair 报修记录
     * @return 结果
     */
    public int insertMyRepair(MyRepair myRepair);

    /**
     * 修改报修记录
     * 
     * @param myRepair 报修记录
     * @return 结果
     */
    public int updateMyRepair(MyRepair myRepair);

    /**
     * 删除报修记录
     * 
     * @param repairId 报修记录主键
     * @return 结果
     */
    public int deleteMyRepairByRepairId(Long repairId);

    /**
     * 批量删除报修记录
     * 
     * @param repairIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyRepairByRepairIds(Long[] repairIds);
}
