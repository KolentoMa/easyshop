package com.easyshop.controller;

import com.easyshop.commons.DataResults;
import com.easyshop.commons.PageUtils;
import com.easyshop.entity.Content;
import com.easyshop.service.ContentServiceApi;
import com.easyshop.vo.ContentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class CommonController {

    @Autowired
    ContentServiceApi contentServiceApi;

    @RequestMapping("/content/topage")
    public String content(ContentVo contentVo,Model model){

        DataResults<PageUtils<Content>> data = contentServiceApi.page(contentVo);
        log.info("拿到的rusult是==>"+data.getData());
        model.addAttribute("pageutils",data.getData());
        model.addAttribute("contentVo",contentVo);
        return "tbContent";

    }
}
