/**
 * @author eamiear
 * @date 2018/12/4 17:11
 */

package com.ura.ai.pojo.baidu.bean;

import java.util.List;

public class OCRReceiptBean {
    private Integer words_result_num;
    private List<WordsResult> words_result;

    public Integer getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(Integer words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResult> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResult> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResult{
        private String words;
        private Location location;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

    public static class Location{
        private Integer left;
        private Integer top;
        private Integer width;
        private Integer height;

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
    }
}
