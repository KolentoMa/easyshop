package com.easyshop.controller;

import com.easyshop.commons.DataResults;
import com.easyshop.commons.ResultCode;
import com.easyshop.entity.Content;
import com.easyshop.service.ContentServiceApi;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

@RequestMapping("content")
@RestController
@Slf4j
public class ContentController {

    @Autowired
    ContentServiceApi contentServiceApi;

    /**
     * 根据Id删除广告
     * @param id
     * @return
     */
    @DeleteMapping("deleteById/{id}")
    public DataResults delete(@PathVariable("id") Integer id){
        return contentServiceApi.delete(id);
    }

    /**
     * 根据广告修改广告内容
     * @param content
     * @return
     */
    @PutMapping("updateData")
    public DataResults update(Content content){
        return contentServiceApi.update(content);
    }

    @PostMapping("save")
    public DataResults add(Content content){
        content.setDel(0);
        return contentServiceApi.add(content);
    }

    @DeleteMapping("deleteBatch")
    public DataResults deleteAllContent(@RequestParam("ids") String ids){
        System.out.println(ids);
        DataResults results = contentServiceApi.deleteAll(ids);
        return results;
    }

    @GetMapping("findOne/{id}")
    public DataResults findOne(@PathVariable("id") Integer id){
        log.info("回显的id为======>"+id);
        DataResults<Content> results = contentServiceApi.findOneById(id);
        System.out.println(results);
        return results;
    }
}
