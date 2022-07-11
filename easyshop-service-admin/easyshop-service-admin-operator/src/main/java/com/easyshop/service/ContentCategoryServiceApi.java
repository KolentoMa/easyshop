package com.easyshop.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("service-content")
public interface ContentCategoryServiceApi extends ContentCategoryService{

}
