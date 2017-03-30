package com.fh.dao.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fh.entity.system.DataDictionary;
import com.fh.entity.system.DataDictionaryQuery;

/**数据字典 dao
 * @author lijn
 *
 */
public interface DataDictionaryDao {
    /**
     * 根据条件查询出符合条件的总记录数
     * @return
     */
    int findCountByCriteriaQuery(@Param("codename") String codename);
    
    /**
     * 根据查询条件分页模糊查询记录列表
     * @param pageSize 每页显示的记录数
     * @param startIndex 每页起始记录的索引
     * @return
     */
    List<DataDictionary> findDataDictionarysByPageCriteriaQuery(@Param("codename") String codename,@Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
 
    int countByExample(DataDictionaryQuery example);

    int deleteByExample(DataDictionaryQuery example);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    List<DataDictionary> selectByExample(DataDictionaryQuery example);

    int updateByExampleSelective(@Param("record") DataDictionary record, @Param("example") DataDictionaryQuery example);

    int updateByExample(@Param("record") DataDictionary record, @Param("example") DataDictionaryQuery example);

}