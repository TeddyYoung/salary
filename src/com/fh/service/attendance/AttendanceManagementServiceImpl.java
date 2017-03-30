package com.fh.service.attendance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.Expression;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.activiti.service.Activiti;
import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.dao.biz.AttendanceManagementDao;
import com.fh.entity.biz.AttendanceManagement;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.service.system.OrganiseCOService;
import com.fh.service.system.StoreEmployeeService;
import com.fh.util.ShortUUID;

/**
 * 考勤管理Service实现类
 * @author zhang_yu
 *
 */
@Service
public class AttendanceManagementServiceImpl implements AttendanceManagementService {
	
	@Autowired
	private Activiti activiti;
	@Autowired
	private AttendanceManagementDao attendanceManagementDao;
	@Autowired
	private StoreEmployeeService storeEmployeeService;
	@Autowired
	private OrganiseCOService organiseCOService;
	
	/**
	 * 根据月份查询考勤管理列表(默认查询上个月记录)
	 */
	public Page findAttendanceManagementByPage(Page page, String yearMonth, String stationCode) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = attendanceManagementDao.findAttendanceManagementCountByCriteriaQuery(yearMonth, stationCode);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = attendanceManagementDao
									  .findAttendanceManagementByPageCriteriaQuery(yearMonth, stationCode,
																				   page.getPageSize(),
																				   page.getStartIndex());

		page.setRecords(records);
		return page;
		
	}

	/**
	 * 查询上个月所有考勤管理的记录
	 */
	public List<AttendanceManagement> findAllAttendanceManagementByCriteriaQuery(String yearMonth, String stationCode) {
		
		List<AttendanceManagement> attendanceManagements = attendanceManagementDao.findAllAttendanceManagementByCriteriaQuery(yearMonth, stationCode);
		return attendanceManagements;
		
	}

	/**
	 * 添加或修改考勤管理信息
	 */
	public void saveOrUpdateAttendanceManagement(List<AttendanceManagement> attendanceManagementList) {
		
		for (AttendanceManagement attendanceManagement : attendanceManagementList) {
//			if ("N".equals(attendanceManagement.getIsStamanageForeman())){
//				attendanceManagement.setIsStamanageForeman(null);
//			}
//			if ("N".equals(attendanceManagement.getIsInternship())){
//				attendanceManagement.setIsInternship(null);
//			}
			if (null != attendanceManagement.getId() && !"".equals(attendanceManagement.getId())) {
				attendanceManagement.setSysUpdateTime(new Date());
				attendanceManagement.setStatus("0");// 状态为提交审批
				attendanceManagementDao.updateByPrimaryKeySelective(attendanceManagement);
			}else{
				attendanceManagement.setSysCreateTime(new Date());
				attendanceManagement.setStatus("0");// 状态为提交审批
				attendanceManagementDao.insertSelective(attendanceManagement);
			}
		}
		submitActiviti();// 提交工作流
	}

	/**
	 * 查询上个月的考勤记录
	 */
	public int findAllAttendanceManagementByYearMonth(String yearMonth) {
		return attendanceManagementDao.findAllAttendanceManagementByYearMonth(yearMonth);
	}

	/**
	 * 查询上个月所有考勤数据
	 */
	public List<AttendanceManagement> findAllAttendanceManagementsByYearMonth(String yearMonth, String districtCode) {
		return attendanceManagementDao.findAllAttendanceManagementsByYearMonth(yearMonth, districtCode);
	}

	/**
	 * 提交考勤信息到审批流
	 * @param station
	 * @return true 启动流程成功 false 启动流程失败
	 */
//	@Override
	public boolean submitActiviti() {
		boolean returnValue = false;
		String nextUserName = null;
		// 获取当前登录 用户 并 启动流程
		StoreEmployee storeEmployee = SysConstant.getCurrentUser();
		Map<String, Object> variablesnew = new HashMap<String, Object>();
		variablesnew.put("inputUser", storeEmployee.getUsername());
		String key = "AttendanceManageOffice";
		String objId = key + "." + ShortUUID.genId() + ":4";
		variablesnew.put("objId", objId);
		ProcessInstance processInstance = activiti.runtime(key, objId, variablesnew);	
		if (processInstance != null) {
			Task task = activiti.getTask(null, storeEmployee.getUsername(), processInstance.getProcessInstanceId());
			// 完成自己任务，并给定下一个执行者
			Map<String, Object> variables = new HashMap<String, Object>();
			ProcessDefinitionEntity processDefinitionEntity = activiti.getProcessDefinitionEntity(task.getProcessDefinitionId());
			ActivityImpl activityImpl = processDefinitionEntity.findActivity(processInstance.getActivityId());
			List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();

			for (PvmTransition tr : outTransitions) {
				PvmActivity destination = tr.getDestination();
				// 获取线路的终点节点
				ActivityImpl ac = (ActivityImpl) destination;
				UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) ac.getActivityBehavior();
				TaskDefinition taskDefinition = activityBehavior.getTaskDefinition();
				Set<Expression> candidateGroupIdExpressions = taskDefinition.getCandidateGroupIdExpressions();
				for (Expression expression : candidateGroupIdExpressions) {
					String departmentCode = null;
					String[] groupRole = expression.toString().split(":");
					// 角色编号
					String groupRoleCode = groupRole[0];
					// 角色类型 0 油站 1 区域 2 总部 (改为： 0-本级；1-上级)
					String groupRoleType = groupRole[1];
					departmentCode = storeEmployee.getOrganiseId();
//					if("0".equals(groupRoleType)){
//						departmentCode=staff.getStationCode();
//					}
					if("1".equals(groupRoleType)){
//						DepPart depPart = depPartService.queryDeptPartByRoleId(groupRoleCode);
//						groupRoleCode=depPart.getpStorePart();
						OrganiseCO organiseCO  = this.organiseCOService.findOrganiseCOByorganiseId(departmentCode);
						departmentCode = organiseCO.getpOrganiseId();
					}
					List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService.queryStoreEmployeeVOBypStorePart(groupRoleCode, departmentCode);
					if(storeEmployeeVO!=null && storeEmployeeVO.size()>0){
						nextUserName=storeEmployeeVO.get(0).getUsername();
					}
				}
			}
			variables.put("checkUser", nextUserName);
			//更新 历史记录
			activiti.updateActHiActinst(task,"提交");
			activiti.complete(task.getId(), variables);
			returnValue = true;
		}
		return returnValue;
	}
	
	public boolean checkAttendanceManage(String stationCode ,String yearMonth) {
		int count = this.attendanceManagementDao.countByYearMonth( stationCode, yearMonth);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
}
