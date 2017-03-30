package com.fh.service.system;

import java.util.List;

import com.fh.entity.system.Logs;

/**
 * 菜单权限操作日志记录
 * @author MacBook
 *
 */
public interface LogsService {
	
	/**
	 * 增加一条权限操作日志记录
	 * @param logs 日志对象
	 */
	public void insertLog(Logs logs);
	
	/**
	 * 分页查询日志记录列表
	 */
	
	/**
	 * 查询所有的日志记录(不分页)
	 * @return 日志记录对象集合
	 */
	public List<Logs> findAllLogs();
	
}
