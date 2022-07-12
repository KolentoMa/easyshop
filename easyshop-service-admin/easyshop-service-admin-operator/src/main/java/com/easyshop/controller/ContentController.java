package com.easyshop.controller;

import com.easyshop.commons.DataResults;
import com.easyshop.commons.ResultCode;
import com.easyshop.service.ContentServiceApi;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("content")
@RestController
@Slf4j
public class ContentController {

    @Autowired
    ContentServiceApi contentServiceApi;

    @DeleteMapping("delete/{id}")
    public DataResults delete(@PathVariable("id") Integer id){
        contentServiceApi.delete(id);
        return DataResults.success(ResultCode.SUCCESS);
    }



}
