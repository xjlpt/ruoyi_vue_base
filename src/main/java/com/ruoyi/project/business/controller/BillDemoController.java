package com.ruoyi.project.business.controller;

import java.util.List;
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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.business.domain.BillDemo;
import com.ruoyi.project.business.service.IBillDemoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * billController
 * 
 * @author ruoyi
 * @date 2020-05-07
 */
@RestController
@RequestMapping("/business/bill")
public class BillDemoController extends BaseController
{
    @Autowired
    private IBillDemoService billDemoService;

    /**
     * 查询bill列表
     */
    @PreAuthorize("@ss.hasPermi('business:bill:list')")
    @GetMapping("/list")
    public TableDataInfo list(BillDemo billDemo)
    {
        startPage();
        List<BillDemo> list = billDemoService.selectBillDemoList(billDemo);
        return getDataTable(list);
    }

    /**
     * 导出bill列表
     */
    @PreAuthorize("@ss.hasPermi('business:bill:export')")
    @Log(title = "bill", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BillDemo billDemo)
    {
        List<BillDemo> list = billDemoService.selectBillDemoList(billDemo);
        ExcelUtil<BillDemo> util = new ExcelUtil<BillDemo>(BillDemo.class);
        return util.exportExcel(list, "bill");
    }

    /**
     * 获取bill详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:bill:query')")
    @GetMapping(value = "/{billId}")
    public AjaxResult getInfo(@PathVariable("billId") Long billId)
    {
        return AjaxResult.success(billDemoService.selectBillDemoById(billId));
    }

    /**
     * 新增bill
     */
    @PreAuthorize("@ss.hasPermi('business:bill:add')")
    @Log(title = "bill", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BillDemo billDemo)
    {
        return toAjax(billDemoService.insertBillDemo(billDemo));
    }

    /**
     * 修改bill
     */
    @PreAuthorize("@ss.hasPermi('business:bill:edit')")
    @Log(title = "bill", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BillDemo billDemo)
    {
        return toAjax(billDemoService.updateBillDemo(billDemo));
    }

    /**
     * 删除bill
     */
    @PreAuthorize("@ss.hasPermi('business:bill:remove')")
    @Log(title = "bill", businessType = BusinessType.DELETE)
	@DeleteMapping("/{billIds}")
    public AjaxResult remove(@PathVariable Long[] billIds)
    {
        return toAjax(billDemoService.deleteBillDemoByIds(billIds));
    }
}
