package com.ruoyi.project.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * bill对象 bill_demo
 * 
 * @author ruoyi
 * @date 2020-05-07
 */
public class BillDemo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 账单编号 */
    private Long billId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 账单名称 */
    @Excel(name = "账单名称")
    private String billName;

    /** 消费日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "消费日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productTime;

    /** 花费金额 */
    @Excel(name = "花费金额")
    private Double spendMoney;

    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setBillName(String billName) 
    {
        this.billName = billName;
    }

    public String getBillName() 
    {
        return billName;
    }
    public void setProductTime(Date productTime) 
    {
        this.productTime = productTime;
    }

    public Date getProductTime() 
    {
        return productTime;
    }
    public void setSpendMoney(Double spendMoney) 
    {
        this.spendMoney = spendMoney;
    }

    public Double getSpendMoney() 
    {
        return spendMoney;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("billId", getBillId())
            .append("userName", getUserName())
            .append("billName", getBillName())
            .append("createTime", getCreateTime())
            .append("productTime", getProductTime())
            .append("spendMoney", getSpendMoney())
            .toString();
    }
}
