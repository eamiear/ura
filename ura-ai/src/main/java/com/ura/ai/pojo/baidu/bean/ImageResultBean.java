/**
 * @author eamiear
 * @date 2018/12/4 10:51
 */

package com.ura.ai.pojo.baidu.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class ImageResultBean {
    private String probability;
    private boolean has_calorie;
    private String calorie;
    private String name;
    private String score;
    private String year;
    @JSONField(name = "type")
    private String logoType;
    private String root;
    private String keyword;
    private ImageLocationBean location;
    private ImageBaikeInfo baike_info;

    public boolean isHas_calorie() {
        return has_calorie;
    }

    public void setHas_calorie(boolean has_calorie) {
        this.has_calorie = has_calorie;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLogoType() {
        return logoType;
    }

    public void setLogoType(String logoType) {
        this.logoType = logoType;
    }

    public ImageLocationBean getLocation() {
        return location;
    }

    public void setLocation(ImageLocationBean location) {
        this.location = location;
    }

    public ImageBaikeInfo getBaike_info() {
        return baike_info;
    }

    public void setBaike_info(ImageBaikeInfo baike_info) {
        this.baike_info = baike_info;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
