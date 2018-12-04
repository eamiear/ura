/**
 * @author eamiear
 * @date 2018/12/3 14:22
 */

package com.ura.ai.pojo.baidu.bean;

import java.util.List;

public class GeneralDetect extends BaseDetect {
    private String color_result;
    private List<ImageResultBean> result;
    private ImageLocationBean location_result;

    public String getColor_result() {
        return color_result;
    }

    public void setColor_result(String color_result) {
        this.color_result = color_result;
    }

    public List<ImageResultBean> getResult() {
        return result;
    }

    public void setResult(List<ImageResultBean> result) {
        this.result = result;
    }

    public ImageLocationBean getLocation_result() {
        return location_result;
    }

    public void setLocation_result(ImageLocationBean location_result) {
        this.location_result = location_result;
    }

}
