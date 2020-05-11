package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.BillDemo;

/**
 * billService接口
 * 
 * @author ruoyi
 * @date 2020-05-07
 */
public interface IBillDemoService 
{
    /**
     * 查询bill
     * 
     * @param billId billID
     * @return bill
     */
    public BillDemo selectBillDemoById(Long billId);

    /**
     * 查询bill列表
     * 
     * @param billDemo bill
     * @return bill集合
     */
    public List<BillDemo> selectBillDemoList(BillDemo billDemo);

    /**
     * 新增bill
     * 
     * @param billDemo bill
     * @return 结果
     */
    public int insertBillDemo(BillDemo billDemo);

    /**
     * 修改bill
     * 
     * @param billDemo bill
     * @return 结果
     */
    public int updateBillDemo(BillDemo billDemo);

    /**
     * 批量删除bill
     * 
     * @param billIds 需要删除的billID
     * @return 结果
     */
    public int deleteBillDemoByIds(Long[] billIds);

    /**
     * 删除bill信息
     * 
     * @param billId billID
     * @return 结果
     */
    public int deleteBillDemoById(Long billId);
}
