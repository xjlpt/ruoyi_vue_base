package com.ruoyi.project.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.BillDemoMapper;
import com.ruoyi.project.business.domain.BillDemo;
import com.ruoyi.project.business.service.IBillDemoService;

/**
 * billService业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-07
 */
@Service
public class BillDemoServiceImpl implements IBillDemoService 
{
    @Autowired
    private BillDemoMapper billDemoMapper;

    /**
     * 查询bill
     * 
     * @param billId billID
     * @return bill
     */
    @Override
    public BillDemo selectBillDemoById(Long billId)
    {
        return billDemoMapper.selectBillDemoById(billId);
    }

    /**
     * 查询bill列表
     * 
     * @param billDemo bill
     * @return bill
     */
    @Override
    public List<BillDemo> selectBillDemoList(BillDemo billDemo)
    {
        return billDemoMapper.selectBillDemoList(billDemo);
    }

    /**
     * 新增bill
     * 
     * @param billDemo bill
     * @return 结果
     */
    @Override
    public int insertBillDemo(BillDemo billDemo)
    {
        billDemo.setCreateTime(DateUtils.getNowDate());
        return billDemoMapper.insertBillDemo(billDemo);
    }

    /**
     * 修改bill
     * 
     * @param billDemo bill
     * @return 结果
     */
    @Override
    public int updateBillDemo(BillDemo billDemo)
    {
        return billDemoMapper.updateBillDemo(billDemo);
    }

    /**
     * 批量删除bill
     * 
     * @param billIds 需要删除的billID
     * @return 结果
     */
    @Override
    public int deleteBillDemoByIds(Long[] billIds)
    {
        return billDemoMapper.deleteBillDemoByIds(billIds);
    }

    /**
     * 删除bill信息
     * 
     * @param billId billID
     * @return 结果
     */
    @Override
    public int deleteBillDemoById(Long billId)
    {
        return billDemoMapper.deleteBillDemoById(billId);
    }
}
