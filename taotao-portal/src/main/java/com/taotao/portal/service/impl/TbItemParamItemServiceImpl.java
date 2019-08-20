package com.taotao.portal.service.impl;

import com.taotao.common.HttpUtil;
import com.taotao.common.JsonUtils;
import com.taotao.common.TaotaoResult;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.portal.service.TbItemParamItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hmt
 * @date 2019/8/9 0:59
 */
@Service
public class TbItemParamItemServiceImpl implements TbItemParamItemService {

    @Reference(version = "1.0.0")
    private com.taotao.api.TbItemParamItemService tbItemParamItemService;
    @Override
    public String getTbItemParam(long id) {
        TaotaoResult taotaoResult = tbItemParamItemService.getTbItemParam(id);
        if(taotaoResult.getStatus().equals(200)){
            TbItemParamItem tbItemParamItem = (TbItemParamItem) taotaoResult.getData();
            String html = buildHtmlFromTbItemParamItem(tbItemParamItem);
            return html;
        }
        return "<span>暂无商品规格参数</span>";
    }

    private String buildHtmlFromTbItemParamItem(TbItemParamItem tbItemParamItem) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">");
        sb.append("    <tbody>");
        // 把数据库中存储的商品规格参数字符串转换成Java对象，方便下面组装html
        List<Map> paramDataItemList = JsonUtils.jsonToList(tbItemParamItem.getParamData(), Map.class);
        // 第一层循环是拼一个规格参数主体块的html
        for(Map itemParamMap : paramDataItemList) {
            String groupName = (String) itemParamMap.get("group");
            sb.append("        <tr>");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+groupName+"</th>");
            sb.append("        </tr>");
            List<Map> params = (List<Map>) itemParamMap.get("params");
            // 第二层循环是拼接一个规格参数主体下面每一项规格参数的html
            for (Map map2 : params) {
                sb.append("        <tr>");
                sb.append("            <td class=\"tdTitle\">"+map2.get("k")+"</td>");
                sb.append("            <td>"+map2.get("v")+"</td>");
                sb.append("        </tr>");
            }
        }
        sb.append("    </tbody>");
        sb.append("</table>");
        return sb.toString();
    }
}
