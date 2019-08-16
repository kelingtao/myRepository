package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbItemCatService;
import com.ego.mapper.TbItemCatMapper;
import com.ego.pojo.TbItemCat;
import com.ego.pojo.TbItemCatExample;

public class TbItemCatServiceImpl implements TbItemCatService {
	@Resource
	private TbItemCatMapper tbItemCatMapper;

	/**
	 * 根据父id查找类目
	 */
	@Override
	public List<TbItemCat> show(Long pid) {
		// TODO Auto-generated method stub
		// 根据父id查询商品类目
		TbItemCatExample example = new TbItemCatExample();
		example.createCriteria().andParentIdEqualTo(pid).andStatusEqualTo(1);
		return tbItemCatMapper.selectByExample(example);
	}

	/**
	 * 根据id查询商品类目
	 */
	@Override
	public TbItemCat selCatById(Long id) {
		return tbItemCatMapper.selectByPrimaryKey(id);
	}

}
