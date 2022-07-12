package com.easyshop.controller;

import com.easyshop.commons.DataResults;
import com.easyshop.commons.ResultCode;
import com.easyshop.entity.ContentCategory;
import com.easyshop.service.ContentCategoryServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("content_category")
public class ContentCategoryController {

    @Autowired
    ContentCategoryServiceApi contentCategoryServiceApi;

    @GetMapping("list")
    public DataResults list(){
        DataResults<List<ContentCategory>> list = contentCategoryServiceApi.list();
        System.out.println(list.getData());
        return list;
    }
}
