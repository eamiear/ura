/**
 * @author eamiear
 * @date 2018/7/3015:17
 */

package com.ura.generator.controller;

import com.alibaba.fastjson.JSON;
import com.ura.common.utils.HttpContextUtils;
import com.ura.generator.service.SysGeneratorService;
import com.ura.common.utils.PageUtils;
import com.ura.common.utils.Query;
import com.ura.common.utils.R;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/generator")
public class SysGeneratorController {
//    Logger logger = Logger.getLogger(SysGeneratorController.class);
    Logger logger = LoggerFactory.getLogger(SysGeneratorController.class);
    @Autowired
    private SysGeneratorService sysGeneratorService;


    @RequestMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Map<String, String>> list = sysGeneratorService.getTableList(query);
        int total = sysGeneratorService.getTableTotal(query);
        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
        logger.info("表格列表：" + JSON.toJSONString(pageUtil));
        logger.info("项目package：" + this.getClass().getPackage().getName());
        return R.success().put("data", pageUtil);
    }

    @RequestMapping("/code")
    public void generateCode (HttpServletRequest request, HttpServletResponse response) throws IOException{
        String[] tableNames = new String[]{};
        String tables = request.getParameter("tables");
        logger.info("[参数] 表名：" + tables);
        tableNames = JSON.parseArray(tables).toArray(tableNames);
        byte[] data = sysGeneratorService.generateCode(tableNames);

        response.reset();
        response.setHeader("Content-Disposition", "attachment: filename=\"ura-code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
