/**
 * @author eamiear
 * @date 2018/9/14 14:09
 */

package com.ura.art.bean;

import org.springframework.beans.factory.annotation.Value;

public class SignatureReq {
    @Value(value = "周杰伦")
    private String text;
    @Value(value = "901")
    private String style;
    @Value(value = "#ffffff")
    private String background;
    @Value(value = "#ffffff")
    private String decorator;
    @Value(value = "#000000")
    private String color;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getDecorator() {
        return decorator;
    }

    public void setDecorator(String decorator) {
        this.decorator = decorator;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
