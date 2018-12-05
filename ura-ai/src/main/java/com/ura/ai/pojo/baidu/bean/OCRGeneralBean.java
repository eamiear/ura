/**
 * @author eamiear
 * @date 2018/12/4 15:23
 */

package com.ura.ai.pojo.baidu.bean;

import com.ura.ai.pojo.baidu.resp.OCRGeneralResp;

import java.util.List;

public class OCRGeneralBean {
    /**
     * 图像方向，当detect_direction=true时存在。
     *  -1:未定义，
     *  - 0:正向，
     *  - 1: 逆时针90度，
     *  - 2:逆时针180度，
     *  - 3:逆时针270度
     */
    private Integer direction;
    /**
     * 识别结果数，表示words_result的元素个数
     */
    private Integer words_result_num;
    /**
     * 识别结果数组
     */
    private List<WordsResult> words_result;

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

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
