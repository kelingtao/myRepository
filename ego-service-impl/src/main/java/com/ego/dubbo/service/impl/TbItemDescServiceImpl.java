package com.ego.dubbo.service.impl;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbItemDescService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.pojo.TbItemDesc;

public class TbItemDescServiceImpl implements TbItemDescService{
	@Resource
	private TbItemDescMapper tbItemDescMapper; 
	/**
	 * 通过商品id查询商品描述
	 */
	@Override
	public TbItemDesc selDescById(Long id) {
		// TODO Auto-generated method stub
		return tbItemDescMapper.selectByPrimaryKey(id);
	}

}
