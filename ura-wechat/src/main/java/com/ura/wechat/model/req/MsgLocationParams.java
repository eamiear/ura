/**
 * @author eamiear
 * @date 2018/9/25 10:15
 */

package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractMsgParams;

/**
 * 地理位置信息
 */
public class MsgLocationParams extends AbstractMsgParams {

    private double Location_X;      // 维度
    private double Location_Y;      // 经度
    private int Scale;              // 地图缩放大小
    private String Label;           // 地图位置信息

    @Override
    public String SetMsgType() {
        return "location";
    }

    public double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(double location_X) {
        Location_X = location_X;
    }

    public double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(double location_Y) {
        Location_Y = location_Y;
    }

    public int getScale() {
        return Scale;
    }

    public void setScale(int scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
