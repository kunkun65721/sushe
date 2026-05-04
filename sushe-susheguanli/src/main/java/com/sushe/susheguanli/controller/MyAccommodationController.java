package com.sushe.susheguanli.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sushe.common.annotation.Log;
import com.sushe.common.core.controller.BaseController;
import com.sushe.common.core.domain.AjaxResult;
import com.sushe.common.enums.BusinessType;
import com.sushe.susheguanli.domain.MyAccommodation;
import com.sushe.susheguanli.service.IMyAccommodationService;
import com.sushe.common.utils.poi.ExcelUtil;
import com.sushe.common.core.page.TableDataInfo;

/**
 * 住宿记录Controller
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@RestController
@RequestMapping("/susheguanli/accommodation")
public class MyAccommodationController extends BaseController
{
    @Autowired
    private IMyAccommodationService myAccommodationService;

    /**
     * 查询住宿记录列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:accommodation:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyAccommodation myAccommodation)
    {
        startPage();
        List<MyAccommodation> list = myAccommodationService.selectMyAccommodationList(myAccommodation);
        return getDataTable(list);
    }

    /**
     * 导出住宿记录列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:accommodation:export')")
    @Log(title = "住宿记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyAccommodation myAccommodation)
    {
        List<MyAccommodation> list = myAccommodationService.selectMyAccommodationList(myAccommodation);
        ExcelUtil<MyAccommodation> util = new ExcelUtil<MyAccommodation>(MyAccommodation.class);
        util.exportExcel(response, list, "住宿记录数据");
    }

    /**
     * 获取住宿记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:accommodation:query')")
    @GetMapping(value = "/{accommodationId}")
    public AjaxResult getInfo(@PathVariable("accommodationId") Long accommodationId)
    {
        return success(myAccommodationService.selectMyAccommodationByAccommodationId(accommodationId));
    }

    /**
     * 新增住宿记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:accommodation:add')")
    @Log(title = "住宿记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyAccommodation myAccommodation)
    {
        return toAjax(myAccommodationService.insertMyAccommodation(myAccommodation));
    }

    /**
     * 修改住宿记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:accommodation:edit')")
    @Log(title = "住宿记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyAccommodation myAccommodation)
    {
        return toAjax(myAccommodationService.updateMyAccommodation(myAccommodation));
    }

    /**
     * 删除住宿记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:accommodation:remove')")
    @Log(title = "住宿记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{accommodationIds}")
    public AjaxResult remove(@PathVariable Long[] accommodationIds)
    {
        return toAjax(myAccommodationService.deleteMyAccommodationByAccommodationIds(accommodationIds));
    }
}
