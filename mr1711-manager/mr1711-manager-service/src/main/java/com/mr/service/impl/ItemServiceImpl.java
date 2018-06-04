package com.mr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mr.mapper.TbItemMapper;
import com.mr.model.TbItem;
import com.mr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${LGQ} on 2018/5/23.
 */
@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

    //service层调用dao层--自动注入dao
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemBy(Long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    // 查询全部商品
    @Override
    public Map<String, Object> getList(Integer page, Integer rows) {
        // 当前页和每页条数
        PageHelper.startPage(page,rows);
        // 查询全部
        List<TbItem> tbItems = itemMapper.selectByExample(null);
        // 放进页面信息中
        PageInfo info = new PageInfo(tbItems);
        Map<String,Object> map = new HashMap<String,Object>();
        //
        map.put("rows",info.getList());
        map.put("total",info.getTotal());
        return map;
    }

}