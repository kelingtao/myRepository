package com.ego.dubbo.service.impl;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbItemParamItemService;
import com.ego.mapper.TbItemParamItemMapper;
import com.ego.pojo.TbItemParamItem;
import com.ego.pojo.TbItemParamItemExample;

public class TbItemParamItemServiceImpl implements TbItemParamItemService {
	@Resource
	private TbItemParamItemMapper tbItemParamItemMapper;

	/**
	 * 新增商品规格参数
	 */
	@Override
	public int insParamItem(TbItemParamItem tbItemParamItem) {
		// TODO Auto-generated method stub
		return tbItemParamItemMapper.insertSelective(tbItemParamItem);
	}

	/**
	 * 查询商品规格参数
	 */
	@Override
	public TbItemParamItem selByItemId(long itemId) {
		// TODO Auto-generated method stub
		TbItemParamItemExample example=new TbItemParamItemExample();
		example.createCriteria().andItemIdEqualTo(itemId);
		return tbItemParamItemMapper.selectByExampleWithBLOBs(example).get(0);
	}

}
