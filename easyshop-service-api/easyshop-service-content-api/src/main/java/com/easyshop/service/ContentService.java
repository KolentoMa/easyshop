package com.easyshop.service;


import com.easyshop.commons.DataResults;
import com.easyshop.commons.PageUtils;
import com.easyshop.entity.Content;
import com.easyshop.vo.ContentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kolento
 * @since 2022-07-07
 */

@RestController
@RequestMapping("content")
@Api(value = "Swagger接口测试Content")
@ApiResponses({
        @ApiResponse(code = 400, message = "请求参数没填好"),
        @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对"),
        @ApiResponse(code = 500, message = "请求的服务器异常")
})
public interface ContentService  {

    @PostMapping("page")
    @ApiOperation(value="分页获取用户信息")
    DataResults<PageUtils<Content>> page(@RequestBody ContentVo contentVo);

    @GetMapping("list")
    @ApiOperation(value="获取所有广告信息")
    DataResults<List<Content>> list();

    @GetMapping("{id}")
    @ApiOperation(value="根据ID获取广告信息",notes = "根据ID获取广告信息")
    DataResults<Content> getById(@PathVariable("id") Integer id);

    @PutMapping("update")
    @ApiOperation(value="更新广告信息",notes = "更新广告信息")
    DataResults update(@RequestBody Content content);

    @DeleteMapping("{id}")
    @ApiOperation(value="根据ID删除广告信息",notes = "根据ID删除广告信息")
    DataResults delete(@PathVariable("id") Integer id);

    @PostMapping("add")
    @ApiOperation(value="添加广告信息",notes = "添加广告信息")
    DataResults add(@RequestBody Content content);

    @DeleteMapping("deleteAll")
    @ApiOperation(value="批量删除广告信息",notes = "批量删除广告信息")
    DataResults deleteAll(@RequestParam("ids") String ids);

    @GetMapping ("findOneById/{id}")
    @ApiOperation(value="根据ID获取广告信息",notes = "根据ID获取广告信息")
    DataResults findOneById(@PathVariable(name = "id") Integer id);
}
