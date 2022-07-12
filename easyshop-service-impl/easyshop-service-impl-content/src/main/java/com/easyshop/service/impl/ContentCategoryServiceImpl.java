package com.easyshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easyshop.commons.DataResults;
import com.easyshop.commons.ResultCode;
import com.easyshop.entity.ContentCategory;
import com.easyshop.mapper.ContentCategoryMapper;
import com.easyshop.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author Kolento
 * @since 2022-07-07
 */
@Service
public class ContentCategoryServiceImpl  implements ContentCategoryService {

    @Autowired
    ContentCategoryMapper categoryMapper;

    @Override
    public DataResults<List<ContentCategory>> list() {
        return DataResults.success(ResultCode.SUCCESS,categoryMapper.selectList(new QueryWrapper<ContentCategory>().eq("del",0)));
    }

    @Override
    public DataResults<ContentCategory> getById(Integer id) {
        ContentCategory contentCategory = categoryMapper.selectById(id);
        return DataResults.success(ResultCode.SUCCESS,contentCategory);
    }

    @Override
    public DataResults update(ContentCategory contentCategory) {
        categoryMapper.updateById(contentCategory);
        return DataResults.success(ResultCode.SUCCESS);
    }

    @Override
    public DataResults delete(Integer id) {
        ContentCategory category = categoryMapper.selectById(id);
        category.setDel(1);
        categoryMapper.updateById(category);
        return DataResults.success(ResultCode.SUCCESS);
    }

    @Override
    public DataResults add(ContentCategory contentCategory) {
        categoryMapper.insert(contentCategory);
        return DataResults.success(ResultCode.SUCCESS);
    }

}
