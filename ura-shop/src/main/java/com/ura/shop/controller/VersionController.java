package com.ura.shop.controller;

import com.ura.common.utils.JSONResult;
import com.ura.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {

  @RequestMapping("/info")
  public R info () {
    return R.success().put("data", JSONResult.build().put("version", "1.0"));
  }
}
