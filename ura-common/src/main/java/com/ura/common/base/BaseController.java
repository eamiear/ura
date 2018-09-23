/**
 * @author eamiear
 * @date 2018/8/9 16:34
 */

package com.ura.common.base;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {
  @Autowired
  private HttpServletRequest request;

  @Autowired
  private HttpServletResponse response;

  public HttpServletRequest getRequest() {
    return request;
  }

  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }

  public HttpServletResponse getResponse() {
    return response;
  }

  public void setResponse(HttpServletResponse response) {
    this.response = response;
  }
}
