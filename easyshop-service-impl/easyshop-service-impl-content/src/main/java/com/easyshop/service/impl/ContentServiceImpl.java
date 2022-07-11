package com.easyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easyshop.commons.DataResults;
import com.easyshop.commons.PageUtils;
import com.easyshop.commons.ResultCode;
import com.easyshop.entity.Content;
import com.easyshop.entity.ContentCategory;
import com.easyshop.mapper.ContentCategoryMapper;
import com.easyshop.mapper.ContentMapper;
import com.easyshop.service.ContentService;
import com.easyshop.vo.ContentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kolento
 * @since 2022-07-07
 */
@Service
@Slf4j
public class ContentServiceImpl  implements ContentService {

    @Autowired
    ContentMapper contentMapper;

    @Autowired
    ContentCategoryMapper contentCategoryMapper;

    @Value("${server.port}")
    String port;

    @Override
    public DataResults<PageUtils<Content>> page(ContentVo contentVo) {

        log.info("port:"+port);
        //别忘记导入分页插件
         QueryWrapper qw = new QueryWrapper();
         qw.eq("del",0);
         qw.like(!StringUtils.isEmpty(contentVo.getTitle()),"title",contentVo.getTitle());
         IPage pages = contentMapper.selectPage(new Page<Content>(contentVo.getPageIndex(),contentVo.getLimit()),qw);
        List<Content> records = pages.getRecords();
        for (Content record : records) {
            Long categoryId = record.getCategoryId();
            ContentCategory contentCategory = contentCategoryMapper.selectById(categoryId);
            record.setCategoryName(contentCategory.getName());
        }
        PageUtils<Content> contentPageUtils = new PageUtils<Content>(contentVo.getPageIndex(), contentVo.getLimit(), pages.getTotal(),records);
         return DataResults.success(ResultCode.SUCCESS,contentPageUtils);
    }

    @Override
    public DataResults<List<Content>> list() {
        List<Content> contents = contentMapper.selectList(new QueryWrapper<Content>().eq("del", 0));
        return  DataResults.success(ResultCode.SUCCESS,contents);
    }

    @Override
    public DataResults<Content> getById(Integer id) {
        Content content = contentMapper.selectById(id);
        return DataResults.success(ResultCode.SUCCESS,content);
    }

    @Override
    public DataResults update(Content content) {
        contentMapper.updateById(content);
        return DataResults.success(ResultCode.SUCCESS);
    }

    @Override
    public DataResults delete(Integer id) {
        Content content = contentMapper.selectById(id);
        content.setDel(1);
        contentMapper.updateById(content);
        return DataResults.success(ResultCode.SUCCESS);
    }

    @Override
    public DataResults add(Content content) {
        contentMapper.insert(content);
        return DataResults.success(ResultCode.SUCCESS);
    }

}
