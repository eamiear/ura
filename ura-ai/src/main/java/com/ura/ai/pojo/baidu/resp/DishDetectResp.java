/**
 * @author eamiear
 * @date 2018/12/3 15:33
 */

package com.ura.ai.pojo.baidu.resp;

public class DishDetectResp {
    /**
     * 卡路里，每100g的卡路里含量
     */
    private String calorie;
    /**
     * 是否包含卡路里
     */
    private String hasCalorie;

    private String name;
    private String probability;
    private String baikeUrl;
    private String baikeImageUrl;
    private String baikeDescription;

    public String getCalorie() {
        return calorie;
    }
    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }
    public String getHasCalorie() {
        return hasCalorie;
    }
    public void setHasCalorie(String hasCalorie) {
        this.hasCalorie = hasCalorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getBaikeUrl() {
        return baikeUrl;
    }

    public void setBaikeUrl(String baikeUrl) {
        this.baikeUrl = baikeUrl;
    }

    public String getBaikeImageUrl() {
        return baikeImageUrl;
    }

    public void setBaikeImageUrl(String baikeImageUrl) {
        this.baikeImageUrl = baikeImageUrl;
    }

    public String getBaikeDescription() {
        return baikeDescription;
    }

    public void setBaikeDescription(String baikeDescription) {
        this.baikeDescription = baikeDescription;
    }
}
