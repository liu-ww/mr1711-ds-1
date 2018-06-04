package com.mr.service;

import com.mr.model.TbItem;

import java.util.Map;

/**
 * Created by ${LGQ} on 2018/5/23.
 */
public interface ItemService {
    /**
     * 通过id查询数据
     * @param id
     * @return
     */
    TbItem getItemBy(Long id);

    /**
     * 查询List
     * @param page
     * @param rows
     * @return
     */
    Map<String,Object> getList(Integer page,Integer rows);
}
