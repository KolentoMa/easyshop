package com.easyshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 
 * </p>
 *
 * @author Kolento
 * @since 2022-07-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_content")
@ApiModel("广告实例类")
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("广告主键")
    private Long id;

    /**
     * 内容类目ID
     */
    @ApiModelProperty("内容类目ID")
    private Long categoryId;

    @TableField(exist = false)
    private String categoryName;

    /**
     * 内容标题
     */
    @ApiModelProperty("广告内容标题")
    private String title;

    /**
     * 链接
     */
    @ApiModelProperty("广告链接")
    private String url;

    /**
     * 图片绝对路径
     */
    @ApiModelProperty("广告图片绝对路径")
    private String pic;

    /**
     * 状态
     */
    @ApiModelProperty("广告状态")
    private String status;

    /**
     * 排序
     */
    @ApiModelProperty("广告排序")
    private Integer sortOrder;

    @ApiModelProperty("广告是否删除")
    private Integer del;


}
