package com.easyshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 内容分类
 * </p>
 *
 * @author Kolento
 * @since 2022-07-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_content_category")
@ApiModel("广告类别实例类")
public class ContentCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("类目主键")
    private Long id;

    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("类目是否删除")
    private Integer del;


}
