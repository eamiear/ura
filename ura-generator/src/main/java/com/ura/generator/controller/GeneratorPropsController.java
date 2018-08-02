/**
 * @author eamiear
 * @date 2018/8/2 10:35
 */

package com.ura.generator.controller;

import com.ura.common.utils.PageUtils;
import com.ura.common.utils.R;
import com.ura.generator.entity.PropsEntity;
import com.ura.generator.service.GeneratorPropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/generator/props")
public class GeneratorPropsController {

    @Autowired
    GeneratorPropsService generatorPropsService;


    @RequestMapping("/list")
    public R queryPropsList(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils = generatorPropsService.queryPropsList(params);
        return R.success().put("data", pageUtils);
    }

    @RequestMapping("/record")
    public R queryPropRecord(@RequestParam Long id) {
        if (id == null) {
            return R.error("id 不能为空!");
        }
        PropsEntity propsEntity = generatorPropsService.queryPropRecord(id);
        return R.success().put("data", propsEntity);
    }

    @RequestMapping("/save")
    public R save(@RequestBody PropsEntity propsEntity){
        boolean isSave = generatorPropsService.save(propsEntity);
        R r = isSave ? R.success("添加成功") : R.error("添加失败");
        return r;
    }

    @RequestMapping("/update")
    public R update(@RequestBody PropsEntity propsEntity) {
        boolean isUpdate = generatorPropsService.update(propsEntity);
        R r = isUpdate ? R.success("更新成功") : R.error("更新失败");
        return r;
    }

    @RequestMapping("/delete")
    public R deleteById(@RequestParam Long id){
        if (id == null) {
            return R.error("id不能为空!");
        }
        boolean isDel = generatorPropsService.deleteById(id);
        R r = isDel ? R.success("删除成功") : R.error("删除失败");
        return r;
    }
}
