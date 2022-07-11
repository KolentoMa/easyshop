package com.easyshop.vo;

import com.easyshop.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@NoArgsConstructor

@EqualsAndHashCode(callSuper = false)

public class ContentVo extends Content {

    private Long pageIndex = 1L; //当前页码 默认值为1

    private Long limit = 5L; //每页的页数 默认为5

    private String startTime;

    private String endTime;

}
