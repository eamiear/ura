/**
 * @author eamiear
 * @date 2018/12/4 16:43
 */

package com.ura.ai.pojo.baidu.bean;

public class OCRPlateLicenseBean {
    private WordsResult words_result;

    public WordsResult getWords_result() {
        return words_result;
    }

    public void setWords_result(WordsResult words_result) {
        this.words_result = words_result;
    }

    public static class WordsResult{
        private String color;
        private String number;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
