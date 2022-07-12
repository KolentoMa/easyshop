package com.easyshop.service;

import com.easyshop.commons.DataResults;
import com.easyshop.entity.ContentCategory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 内容分类 服务类
 * </p>
 *
 * @author Kolento
 * @since 2022-07-07
 */

@ResponseBody
@Service
@RequestMapping("content-category")
public interface ContentCategoryService  {

    @GetMapping("list")
    DataResults<List<ContentCategory>> list();

    @GetMapping("{id}")
    DataResults<ContentCategory> getById(@PathVariable("id") Integer id);

    @PutMapping("update")
    DataResults update(@RequestBody ContentCategory contentCategory);

    @DeleteMapping("{id}")
    DataResults delete(@PathVariable("id") Integer id);

    @PostMapping("add")
    DataResults add(@RequestBody ContentCategory contentCategory);


}
