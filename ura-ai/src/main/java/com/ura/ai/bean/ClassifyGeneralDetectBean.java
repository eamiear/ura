/**
 * @author eamiear
 * @date 2018/12/3 14:22
 */

package com.ura.ai.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ClassifyGeneralDetectBean extends BaiduBaseDetectBean {
    private String color_result;
    private List<Result> result;
    private Location location_result;

    public String getColor_result() {
        return color_result;
    }

    public void setColor_result(String color_result) {
        this.color_result = color_result;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Location getLocation_result() {
        return location_result;
    }

    public void setLocation_result(Location location_result) {
        this.location_result = location_result;
    }

    public static class Result {
        private String probability;
        private boolean has_calorie;
        private String calorie;
        private String name;
        private String score;
        private String year;
        @JSONField(name = "type")
        private String logoType;
        private Location location;
        private BaiKeInfo baike_info;

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

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public BaiKeInfo getBaike_info() {
            return baike_info;
        }

        public void setBaike_info(BaiKeInfo baike_info) {
            this.baike_info = baike_info;
        }
    }

    public static class Location{
        private Integer width;
        private Integer height;
        private Integer top;
        private Integer left;

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

        public Integer getTop() {
            return top;
        }

        public void setTop(Integer top) {
            this.top = top;
        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }
    }

    public static class BaiKeInfo{
        private String baike_url;
        private String image_url;
        private String description;

        public String getBaike_url() {
            return baike_url;
        }

        public void setBaike_url(String baike_url) {
            this.baike_url = baike_url;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
