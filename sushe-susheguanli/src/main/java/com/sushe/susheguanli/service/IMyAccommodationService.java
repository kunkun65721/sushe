package com.sushe.susheguanli.service;

import java.util.List;
import com.sushe.susheguanli.domain.MyAccommodation;

/**
 * 住宿记录Service接口
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
public interface IMyAccommodationService 
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
     * 批量删除住宿记录
     * 
     * @param accommodationIds 需要删除的住宿记录主键集合
     * @return 结果
     */
    public int deleteMyAccommodationByAccommodationIds(Long[] accommodationIds);

    /**
     * 删除住宿记录信息
     * 
     * @param accommodationId 住宿记录主键
     * @return 结果
     */
    public int deleteMyAccommodationByAccommodationId(Long accommodationId);
}
