/**
 * @author eamiear
 * @date 2018/12/4 14:55
 */

package com.ura.ai.pojo.baidu.resp;

import java.util.List;

public class OCRGeneralResp {
    private String direction;
    private Integer wordsResultNum;
    private List<WordsResult> wordsResult;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getWordsResultNum() {
        return wordsResultNum;
    }

    public void setWordsResultNum(Integer wordsResultNum) {
        this.wordsResultNum = wordsResultNum;
    }

    public List<WordsResult> getWordsResult() {
        return wordsResult;
    }

    public void setWordsResult(List<WordsResult> wordsResult) {
        this.wordsResult = wordsResult;
    }

    public class WordsResult{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
