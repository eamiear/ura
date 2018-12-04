/**
 * @author eamiear
 * @date 2018/12/4 10:30
 */

package com.ura.ai.pojo.baidu.resp;

// 主体检测
public class ImageSubjectDetectResp {
    private Integer width;
    private Integer height;
    private Integer left;
    private Integer top;

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
