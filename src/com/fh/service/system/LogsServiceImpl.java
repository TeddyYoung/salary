package com.fh.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.LogsDao;
import com.fh.entity.system.Logs;
import com.fh.entity.system.LogsQuery;

/**
 * 菜单权限操作日志实现类
 * @author MacBook
 *
 */
@Service
public class LogsServiceImpl implements LogsService {
	
	@Autowired
	private LogsDao logsDao;
	
	/**
	 * 增加一条权限操作日志记录
	 */
	@Override
	public void insertLog(Logs logs) {
		
		logsDao.insertSelective(logs);
		
	}
	
	/**
	 * 查询所有的日志记录(不分页)
	 */
	@Override
	public List<Logs> findAllLogs() {
		
		LogsQuery logsQuery = new LogsQuery();
		logsQuery.createCriteria();
		return logsDao.selectByExample(logsQuery);
		
	}

}
