package com.fh.dao.system;

import com.fh.entity.system.Menu;
import com.fh.entity.system.MenuQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MenuDao {
    int countByExample(MenuQuery example);

    int deleteByExample(MenuQuery example);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuQuery example);

    Menu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    /**查询  权限 子菜单
     * @param record
     * @param example
     * @return
     */
    List<Menu> querySubMenuByStorePart(@Param("pid") String pid, @Param("storePart") String storePart);
    
    /**
     * 根据角色获取角色的一级菜单
     * @param storePart
     * @return
     */
    public List<Menu> queryMenuByStorePart(@Param("storePart") String storePart);
}