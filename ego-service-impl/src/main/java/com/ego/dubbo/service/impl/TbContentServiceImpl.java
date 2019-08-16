package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbContentService;
import com.ego.mapper.TbContentMapper;
import com.ego.pojo.TbContent;
import com.ego.pojo.TbContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbContentServiceImpl implements TbContentService {
	@Resource
	private TbContentMapper tbContentMapper;

	/**
	 * 分页查询商品内容通过内容类目id(CategoryId)
	 */
	@Override
	public EasyUIDataGrid selByCategoryId(Long categoryId, int page, int rows) {
		PageHelper.startPage(page, rows);
		TbContentExample example = new TbContentExample();
		//如果category的值等于0则查询全部
		if (categoryId != 0) {
			example.createCriteria().andCategoryIdEqualTo(categoryId);
		}
		List<TbContent> tb = tbContentMapper.selectByExampleWithBLOBs(example);
		PageInfo<TbContent> info=new PageInfo<TbContent>(tb);
		EasyUIDataGrid grid=new EasyUIDataGrid();
		grid.setRows(info.getList());
		grid.setTotal(info.getTotal());
		return grid;
	}
	/**
	 * 新增商品类目内容
	 */
	@Override
	public int insTbContent(TbContent tbContent) {
		// TODO Auto-generated method stub
		return tbContentMapper.insertSelective(tbContent);
	}
	/**
	 * 修改商品类目内容
	 */
	@Override
	public int updTbContent(TbContent tbContent) {
		// TODO Auto-generated method stub
		return tbContentMapper.updateByPrimaryKeySelective(tbContent);
	}
	/**
	 * 删除商品类目内容
	 */
	@Override
	public int delTbContentById(Long ids) {
		// TODO Auto-generated method stub
		return tbContentMapper.deleteByPrimaryKey(ids);
	}
    /**
     * 分页或排序查询商城内容
     * count为0则通过categoryid查询全部，不为0则进行分页
     * sort为true则降序排列
     * category为内容类目id
     */
	@Override
	public List<TbContent> selContent(int count,boolean sort,long category) {
		TbContentExample example=new TbContentExample();
		example.createCriteria().andCategoryIdEqualTo(category);
		if(sort){
			example.setOrderByClause("updated desc");
		}
		if(count!=0){
			PageHelper.startPage(1,count);
		}
		List<TbContent> list=tbContentMapper.selectByExampleWithBLOBs(example);
		PageInfo<TbContent> info=new PageInfo<>(list);
		System.out.println(info.getList());
		return info.getList();
	}
}
