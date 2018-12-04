/**
 * @author eamiear
 * @date 2018/12/4 10:14
 */

package com.ura.ai.pojo.baidu.resp;

public class ImageCarDetectResp {
    private String colorResult;
    private String name;
    private String score;
    private String year;
    private String baikeUrl;
    private String baikeImageUrl;
    private String baikeDescription;
    private Integer width;
    private Integer height;
    private Integer left;
    private Integer top;

    public String getColorResult() {
        return colorResult;
    }

    public void setColorResult(String colorResult) {
        this.colorResult = colorResult;
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

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}
