package com.taotao.rest.service.Impl;

import com.taotao.api.TbItemDescService;
import com.taotao.common.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.TbItemDesc;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hmt
 * @date 2019/8/8 21:44
 */
@Service(version = "1.0.0")
public class TbItemDescServiceImpl implements TbItemDescService {

    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Override
    public TaotaoResult getTbItemDesc(long id) {
        TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(id);
        return TaotaoResult.ok(tbItemDesc);
    }
}
