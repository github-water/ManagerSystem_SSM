package com.water.ssm.domain;

import com.water.ssm.util.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Orders {
    /**
     * 订单唯一id无意义
     */
    private String id;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 下单时间字符串
     */
    private String orderTimeStr;

    /**
     * 出行人数
     */
    private int peopleCount;

    /**
     * 订单描述
     */
    private String orderDesc;

    /**
     *支付方式标识
     */
    private Integer payType;

    /**
     *支付方式描述
     */
    private String payTypeStr;

    /**
     * 订单状态标识
     */
    private int orderStatus;

    /**
     * 订单状态
     */
    private String orderStatusStr;


    /**
     * 商品
     */
    private Product product;

    /**
     * 旅客信息
     */
    private List<Traveller> travellers;

    /**
     * 会员信息
     */
    private Member member;

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(this.orderTime != null) {
            orderTimeStr = DateUtils.dateToString(orderTime, "yyyy-MM-dd HH:mm:ss");
        }

        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if(payType == 0){
            payTypeStr = "支付宝";
        }
        if(payType == 1){
            payTypeStr = "微信";
        }
        if(payType == 2){
            payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if(this.orderStatus == 0){
            orderStatusStr = "未支付";
        }
        if(this.orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
