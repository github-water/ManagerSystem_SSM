package com.water.ssm.domain;

/**
 * 旅客
 */
public class Traveller {

    /**
     * 旅客信息唯一标识
     */
    private String id;

    /**
     * 旅客姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话号码
     */
    private String phoneNum;

    /**
     * 证件类型标识
     */
    private Integer credentialsType;

    /**
     * 证件类型描述
     */
    private String credentialsTypeStr;

    /**
     * 证件号码
     */
    private String credentialsNum;

    /**
     * 旅客类型标识
     */
    private Integer travellerType;

    /**
     * 旅客类型描述
     */
    private String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if(credentialsType == 0){
            credentialsTypeStr = "身份证";
        }
        if(credentialsType == 1){
            credentialsTypeStr = "护照";
        }
        if(credentialsType == 2){
            credentialsTypeStr = "军官证";
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {

        if(travellerType!=null){
            if(travellerType == 0){
                travellerTypeStr = "成人";
            } else if(travellerType == 1){
                travellerTypeStr = "儿童";
            }
        }

        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                ", travellerTypeStr='" + travellerTypeStr + '\'' +
                '}';
    }
}
