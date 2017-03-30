package com.fh.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.OrganiseCODao;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.OrganiseCOQuery;
import com.fh.entity.system.StoreEmployee;

/**
 * 机构信息Service实现类
 * @author lijn
 *
 */
@Service
public class OrganiseCOServiceImpl implements OrganiseCOService {

	@Autowired
	private OrganiseCODao organiseCODao;
	/**
	 * 根据父机构Id 查询所有的下属部门（多层）
	 */
	public List<OrganiseCO> findListOrganiseCOByPOrganiseId(String POrganiseId) {
		List<OrganiseCO> organiseCOList=findOrganiseCOListByPOrganiseId(POrganiseId);
		if(organiseCOList!=null && organiseCOList.size()>0){
			for (OrganiseCO organiseCO : organiseCOList) {
				List<OrganiseCO> subOrganiseCOList=findListOrganiseCOByPOrganiseId(organiseCO.getOrganiseId());
				if(subOrganiseCOList!=null && subOrganiseCOList.size()>0){
					organiseCO.setSubOrganiseCO(subOrganiseCOList);
				}else{
					continue;
				}
			}
		}
		return organiseCOList;
	}
	/**
	 * 根据父机构Id 查询机构下属部门（一层）
	 */
	public List<OrganiseCO> findOrganiseCOListByPOrganiseId(String POrganiseId) {
		OrganiseCOQuery organiseCOQuery = new OrganiseCOQuery();
		organiseCOQuery.createCriteria().andPOrganiseIdEqualTo(POrganiseId);
		organiseCOQuery.setOrderByClause("sort");
		List<OrganiseCO> organiseCOList = organiseCODao.selectByExample(organiseCOQuery);
		if(organiseCOList!=null && organiseCOList.size()>0){
			return organiseCOList;
		}else{
			return null;
		}
	}
	/**
	 * 根据机构Id 查询机构部门
	 */
	public OrganiseCO findOrganiseCOByorganiseId(String organiseId) {
		OrganiseCOQuery organiseCOQuery = new OrganiseCOQuery();
		organiseCOQuery.createCriteria().andOrganiseIdEqualTo(organiseId);
		List<OrganiseCO> organiseCOList = organiseCODao.selectByExample(organiseCOQuery);
		if(organiseCOList!=null && organiseCOList.size()>0){
			return organiseCOList.get(0);
		}else{
			return null;
		}
	}
	
	public List<OrganiseCO> findOrganiseCOListByUserID(StoreEmployee storeEmployee) {
		List<OrganiseCO> organiseCOList = organiseCODao.findOrganiseCOListByUserID(storeEmployee.getUserid());

		return organiseCOList;
	}

	
}
