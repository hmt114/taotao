package com.taotao.portal.service.impl;

import com.taotao.common.HttpUtil;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.TbItemDesc;
import com.taotao.portal.service.TbItemDescService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author hmt
 * @date 2019/8/8 20:51
 */
@Service
public class TbItemDescServiceImpl implements TbItemDescService {

    @Reference(version = "1.0.0")
    private com.taotao.api.TbItemDescService tbItemDescService;
    @Override
    public String getTbItemDesc(long id) {
        TaotaoResult taotaoResult = tbItemDescService.getTbItemDesc(id);
        if(taotaoResult.getStatus().equals(200)){
            TbItemDesc tbItemDesc = (TbItemDesc) taotaoResult.getData();
            return tbItemDesc.getItemDesc();
        }else {
            return "<span>暂无描述/span>";
        }

    }
}
