package com.easyshop.controller;

import com.easyshop.commons.DataResults;
import com.easyshop.commons.ResultCode;
import com.easyshop.config.QiNiuYunConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("file")
public class FileUploadController {

    @Autowired
    QiNiuYunConfig qiNiuYunConfig;

    @PostMapping("upload")
    public DataResults upload(@RequestParam("file")  MultipartFile file) throws IOException {

        String filename = file.getOriginalFilename();
        String backName = filename.substring(filename.lastIndexOf("."), filename.length());
        InputStream inputStream = file.getInputStream();
        //为文件重命名：uuid+filename
        filename = UUID.randomUUID().toString()+ backName;
        String link = qiNiuYunConfig.uploadImgToQiNiu(inputStream, filename);
        return DataResults.success(ResultCode.SUCCESS,link);
    }
}
