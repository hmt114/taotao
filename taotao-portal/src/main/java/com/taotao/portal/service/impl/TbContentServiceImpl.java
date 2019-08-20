package com.taotao.portal.service.impl;

import com.taotao.common.TaotaoResult;
import com.taotao.portal.service.TbContentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author hmt
 * @date 2019/8/2 9:31
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Reference(version = "1.0.0")
    private com.taotao.api.TbContentService tbContentService;

    @Override
    public String getContent() {
        //发送请求到rest服务，接收数据，轮播图
        TaotaoResult taotaoResult = tbContentService.getAllContent();
        if(taotaoResult.getStatus().equals(200)){
            return (String) taotaoResult.getData();
        }
        return "加载数据异常...";
    }
}
