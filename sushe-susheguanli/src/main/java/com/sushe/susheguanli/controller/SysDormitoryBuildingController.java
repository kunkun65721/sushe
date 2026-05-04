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
import com.sushe.susheguanli.domain.SysDormitoryBuilding;
import com.sushe.susheguanli.service.ISysDormitoryBuildingService;
import com.sushe.common.utils.poi.ExcelUtil;
import com.sushe.common.core.page.TableDataInfo;

/**
 * 宿舍楼管理Controller
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@RestController
@RequestMapping("/susheguanli/building")
public class SysDormitoryBuildingController extends BaseController
{
    @Autowired
    private ISysDormitoryBuildingService sysDormitoryBuildingService;

    /**
     * 查询宿舍楼管理列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:building:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDormitoryBuilding sysDormitoryBuilding)
    {
        startPage();
        List<SysDormitoryBuilding> list = sysDormitoryBuildingService.selectSysDormitoryBuildingList(sysDormitoryBuilding);
        return getDataTable(list);
    }

    /**
     * 导出宿舍楼管理列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:building:export')")
    @Log(title = "宿舍楼管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDormitoryBuilding sysDormitoryBuilding)
    {
        List<SysDormitoryBuilding> list = sysDormitoryBuildingService.selectSysDormitoryBuildingList(sysDormitoryBuilding);
        ExcelUtil<SysDormitoryBuilding> util = new ExcelUtil<SysDormitoryBuilding>(SysDormitoryBuilding.class);
        util.exportExcel(response, list, "宿舍楼管理数据");
    }

    /**
     * 获取宿舍楼管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:building:query')")
    @GetMapping(value = "/{buildingId}")
    public AjaxResult getInfo(@PathVariable("buildingId") Long buildingId)
    {
        return success(sysDormitoryBuildingService.selectSysDormitoryBuildingByBuildingId(buildingId));
    }

    /**
     * 新增宿舍楼管理
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:building:add')")
    @Log(title = "宿舍楼管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDormitoryBuilding sysDormitoryBuilding)
    {
        return toAjax(sysDormitoryBuildingService.insertSysDormitoryBuilding(sysDormitoryBuilding));
    }

    /**
     * 修改宿舍楼管理
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:building:edit')")
    @Log(title = "宿舍楼管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDormitoryBuilding sysDormitoryBuilding)
    {
        return toAjax(sysDormitoryBuildingService.updateSysDormitoryBuilding(sysDormitoryBuilding));
    }

    /**
     * 删除宿舍楼管理
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:building:remove')")
    @Log(title = "宿舍楼管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{buildingIds}")
    public AjaxResult remove(@PathVariable Long[] buildingIds)
    {
        return toAjax(sysDormitoryBuildingService.deleteSysDormitoryBuildingByBuildingIds(buildingIds));
    }
}
