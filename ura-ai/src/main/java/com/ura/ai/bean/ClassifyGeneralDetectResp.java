/**
 * @author eamiear
 * @date 2018/12/3 14:35
 */

package com.ura.ai.bean;

public class ClassifyGeneralDetectResp extends BaiduBaseDetectResp{
    private String score;
    private String year;
    private String colorResult;

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

    public String getColorResult() {
        return colorResult;
    }

    public void setColorResult(String colorResult) {
        this.colorResult = colorResult;
    }
}
