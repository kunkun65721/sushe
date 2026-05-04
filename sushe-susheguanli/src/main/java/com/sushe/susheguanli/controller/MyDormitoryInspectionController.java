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
import com.sushe.susheguanli.domain.MyDormitoryInspection;
import com.sushe.susheguanli.service.IMyDormitoryInspectionService;
import com.sushe.common.utils.poi.ExcelUtil;
import com.sushe.common.core.page.TableDataInfo;

/**
 * 卫生检查记录Controller
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@RestController
@RequestMapping("/susheguanli/inspection")
public class MyDormitoryInspectionController extends BaseController
{
    @Autowired
    private IMyDormitoryInspectionService myDormitoryInspectionService;

    /**
     * 查询卫生检查记录列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:inspection:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyDormitoryInspection myDormitoryInspection)
    {
        startPage();
        List<MyDormitoryInspection> list = myDormitoryInspectionService.selectMyDormitoryInspectionList(myDormitoryInspection);
        return getDataTable(list);
    }

    /**
     * 导出卫生检查记录列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:inspection:export')")
    @Log(title = "卫生检查记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyDormitoryInspection myDormitoryInspection)
    {
        List<MyDormitoryInspection> list = myDormitoryInspectionService.selectMyDormitoryInspectionList(myDormitoryInspection);
        ExcelUtil<MyDormitoryInspection> util = new ExcelUtil<MyDormitoryInspection>(MyDormitoryInspection.class);
        util.exportExcel(response, list, "卫生检查记录数据");
    }

    /**
     * 获取卫生检查记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:inspection:query')")
    @GetMapping(value = "/{inspectionId}")
    public AjaxResult getInfo(@PathVariable("inspectionId") Long inspectionId)
    {
        return success(myDormitoryInspectionService.selectMyDormitoryInspectionByInspectionId(inspectionId));
    }

    /**
     * 新增卫生检查记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:inspection:add')")
    @Log(title = "卫生检查记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyDormitoryInspection myDormitoryInspection)
    {
        return toAjax(myDormitoryInspectionService.insertMyDormitoryInspection(myDormitoryInspection));
    }

    /**
     * 修改卫生检查记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:inspection:edit')")
    @Log(title = "卫生检查记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyDormitoryInspection myDormitoryInspection)
    {
        return toAjax(myDormitoryInspectionService.updateMyDormitoryInspection(myDormitoryInspection));
    }

    /**
     * 删除卫生检查记录
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:inspection:remove')")
    @Log(title = "卫生检查记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inspectionIds}")
    public AjaxResult remove(@PathVariable Long[] inspectionIds)
    {
        return toAjax(myDormitoryInspectionService.deleteMyDormitoryInspectionByInspectionIds(inspectionIds));
    }
}
