/**
 * @author eamiear
 * @date 2018/12/3 15:33
 */

package com.ura.ai.bean;

public class DishDetectResp extends BaiduBaseDetectResp{
    /**
     * 卡路里，每100g的卡路里含量
     */
    private String calorie;
    /**
     * 是否包含卡路里
     */
    private String hasCalorie;
    /**
     * 菜名
     */
    private String name;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

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

}
