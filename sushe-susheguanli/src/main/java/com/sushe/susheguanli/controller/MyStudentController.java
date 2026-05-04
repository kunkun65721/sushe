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
import com.sushe.susheguanli.domain.MyStudent;
import com.sushe.susheguanli.service.IMyStudentService;
import com.sushe.common.utils.poi.ExcelUtil;
import com.sushe.common.core.page.TableDataInfo;

/**
 * 学生信息Controller
 * 
 * @author ruoyi
 * @date 2026-05-04
 */
@RestController
@RequestMapping("/susheguanli/student")
public class MyStudentController extends BaseController
{
    @Autowired
    private IMyStudentService myStudentService;

    /**
     * 查询学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyStudent myStudent)
    {
        startPage();
        List<MyStudent> list = myStudentService.selectMyStudentList(myStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:student:export')")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyStudent myStudent)
    {
        List<MyStudent> list = myStudentService.selectMyStudentList(myStudent);
        ExcelUtil<MyStudent> util = new ExcelUtil<MyStudent>(MyStudent.class);
        util.exportExcel(response, list, "学生信息数据");
    }

    /**
     * 获取学生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:student:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(myStudentService.selectMyStudentByStudentId(studentId));
    }

    /**
     * 新增学生信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:student:add')")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyStudent myStudent)
    {
        return toAjax(myStudentService.insertMyStudent(myStudent));
    }

    /**
     * 修改学生信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:student:edit')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyStudent myStudent)
    {
        return toAjax(myStudentService.updateMyStudent(myStudent));
    }

    /**
     * 删除学生信息
     */
    @PreAuthorize("@ss.hasPermi('susheguanli:student:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(myStudentService.deleteMyStudentByStudentIds(studentIds));
    }
}
