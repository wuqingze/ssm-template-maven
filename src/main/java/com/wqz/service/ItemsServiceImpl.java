package com.wqz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqz.mapper.ItemsMapper;
import com.wqz.pojo.Items;
import com.wqz.pojo.ItemsExample;


@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;

	public List<Items> list() throws Exception {
		//如果不需要任何查询条件,直接将example对象new出来即可
		ItemsExample example = new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	public Items findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	public void updateItems(Items items) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	
	
}
