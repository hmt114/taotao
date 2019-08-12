package com.taotao.portal.web;

import com.taotao.portal.service.TbItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Action;

/**
 * @author hmt
 * @date 2019/8/8 20:18
 */
@Controller
public class TbItemDescController {

    @Autowired
    private TbItemDescService tbItemDescService;

    @RequestMapping("/item/desc/{id}")
    @ResponseBody
    public String getTbItemDesc(@PathVariable("id") long id){
        String html = tbItemDescService.getTbItemDesc(id);
        return html;
    }
}
