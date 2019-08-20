package com.taotao.portal.service.impl;

import com.taotao.common.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.TbItemExt;
import com.taotao.portal.service.TbItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author hmt
 * @date 2019/8/7 21:29
 */
@Service
public class TbItemServiceImpl implements TbItemService {

    @Reference(version = "1.0.0")
    private com.taotao.api.TbItemService tbItemService;

    @Override
    public TbItemExt getTbItemInfo(long id) {
        TaotaoResult taotaoResult = tbItemService.getItemDetails(id);
        if (taotaoResult.getStatus().equals(200)){
            TbItem tbItem = (TbItem) taotaoResult.getData();
            return parseTbItem2Ext(tbItem,new TbItemExt());
        }
        return null;
    }

    public TbItemExt parseTbItem2Ext(TbItem src,TbItemExt dst){
        dst.setId(src.getId());
        dst.setCreated(src.getCreated());
        dst.setUpdated(src.getUpdated());
        dst.setStatus(src.getStatus());
        dst.setBarcode(src.getBarcode());
        dst.setCid(src.getCid());
        dst.setImage(src.getImage());
        dst.setNum(src.getNum());
        dst.setPrice(src.getPrice());
        dst.setSellPoint(src.getSellPoint());
        dst.setTitle(src.getTitle());
        return dst;
    }
}
