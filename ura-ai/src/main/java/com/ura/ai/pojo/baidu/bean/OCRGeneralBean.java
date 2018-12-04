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
    private List<OCRGeneralResp.WordsResult> words_result;

    public class WordsResult{

    }
}
