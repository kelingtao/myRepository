package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbContentCategoryService;
import com.ego.mapper.TbContentCategoryMapper;
import com.ego.pojo.TbContentCategory;
import com.ego.pojo.TbContentCategoryExample;

public class TbContentCategoryServiceImpl implements TbContentCategoryService {
	@Resource
	private TbContentCategoryMapper tbContentCategoryMapper;

	/**
	 * 通过父id查找商品内容类目
	 */
	@Override
	public List<TbContentCategory> selCategoryByParentId(Long id) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(id).andStatusEqualTo(1);
		return tbContentCategoryMapper.selectByExample(example);
	}

	/**
	 * 插入商品内容类目
	 */
	@Override
	public int insCategory(TbContentCategory gory) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.insertSelective(gory);
	}

	/**
	 * 通过id查询商品内容类目
	 */
	@Override
	public TbContentCategory selCategoryById(Long id) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.selectByPrimaryKey(id);
	}
	/**
	 * 通过id修改商品内容类目
	 */
	@Override
	public int updateCategoryById(TbContentCategory gory) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.updateByPrimaryKeySelective(gory);
	}
	/**
	 * 通过id删除商品内容类目
	 */
	@Override
	public int delCategoryById(Long id) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.deleteByPrimaryKey(id);
	}

}
