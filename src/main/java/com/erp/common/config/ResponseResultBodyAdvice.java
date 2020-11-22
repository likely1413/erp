package com.erp.common.config;

import com.erp.common.exception.ResultException;
import com.erp.common.response.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Administrator
 * 统一全局响应 Json 格式
 */
@RestControllerAdvice(basePackages = {"com.wtzz.zhajzbpt.controller"})
public class ResponseResultBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        //返回true才会调用beforeBodyWrite()方法
        return true;
    }


    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果返回String类型不能直接包装（会报错），要进行些特别的处理
        if (data instanceof String) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在Result里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(Result.success(data));
            } catch (Exception e) {
                throw new ResultException("返回String类型出错");
            }
        }
        if (data instanceof Result) {
            return data;
        }
        // 将原本的数据包装在Result里
        return Result.success(data);
    }


}