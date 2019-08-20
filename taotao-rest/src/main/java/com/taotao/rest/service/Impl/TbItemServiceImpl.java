package com.taotao.rest.service.Impl;

import com.taotao.api.TbItemService;
import com.taotao.common.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hmt
 * @date 2019/8/8 9:14
 */
@Service(version = "1.0.0")
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TaotaoResult getItemDetails(long id) {
        try {
            TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
            return TaotaoResult.ok(tbItem);
        } catch (Exception e) {
            return TaotaoResult.ok("失败");
        }
    }
}
