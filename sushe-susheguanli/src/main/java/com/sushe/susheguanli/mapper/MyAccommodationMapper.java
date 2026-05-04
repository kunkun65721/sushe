package com.sushe.susheguanli.mapper;

import java.util.List;
import com.sushe.susheguanli.domain.MyAccommodation;

/**
 * 住宿记录Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface MyAccommodationMapper 
{
    /**
     * 查询住宿记录
     * 
     * @param accommodationId 住宿记录主键
     * @return 住宿记录
     */
    public MyAccommodation selectMyAccommodationByAccommodationId(Long accommodationId);

    /**
     * 查询住宿记录列表
     * 
     * @param myAccommodation 住宿记录
     * @return 住宿记录集合
     */
    public List<MyAccommodation> selectMyAccommodationList(MyAccommodation myAccommodation);

    /**
     * 新增住宿记录
     * 
     * @param myAccommodation 住宿记录
     * @return 结果
     */
    public int insertMyAccommodation(MyAccommodation myAccommodation);

    /**
     * 修改住宿记录
     * 
     * @param myAccommodation 住宿记录
     * @return 结果
     */
    public int updateMyAccommodation(MyAccommodation myAccommodation);

    /**
     * 删除住宿记录
     * 
     * @param accommodationId 住宿记录主键
     * @return 结果
     */
    public int deleteMyAccommodationByAccommodationId(Long accommodationId);

    /**
     * 批量删除住宿记录
     * 
     * @param accommodationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyAccommodationByAccommodationIds(Long[] accommodationIds);
}
