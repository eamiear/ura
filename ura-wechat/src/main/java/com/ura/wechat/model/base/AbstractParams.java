/**
 * @author eamiear
 * @date 2018/9/20 11:34
 */

package com.ura.wechat.model.base;

import java.io.Serializable;
import java.util.Map;

public abstract class AbstractParams implements Serializable{
    public abstract Map<String, String> getParams() throws Exception;
}
