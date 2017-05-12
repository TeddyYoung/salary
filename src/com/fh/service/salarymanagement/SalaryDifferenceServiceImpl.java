package com.fh.service.salarymanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
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
import com.fh.dao.biz.SalaryDifferenceDao;
import com.fh.dao.biz.StaffDao;
import com.fh.entity.SalaryDifferenceOffice;
import com.fh.entity.biz.SalaryDifference;
import com.fh.entity.biz.SalaryDifferenceQuery;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffQuery;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.entity.system.UserStorePart;
import com.fh.service.system.OrganiseCOService;
import com.fh.service.system.StoreEmployeeService;
import com.fh.service.system.UserStorePartService;
import com.fh.util.StringUtil;

/**
 * 薪资差异处理Service实现类
 * 
 * @author zhang_yu
 *
 */
@Service
public class SalaryDifferenceServiceImpl implements SalaryDifferenceService {

	@Autowired
	private SalaryDifferenceDao salaryDifferenceDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private UserStorePartService userStorePartService;
	@Autowired
	private StoreEmployeeService storeEmployeeService;
	@Autowired
	private Activiti activiti;
	@Autowired
	private OrganiseCOService organiseCOService;

	/**
	 * 根据员工姓名和年月份查询薪资差异处理记录(支持分页查询)
	 */
	public Page findSalaryDifferencesByPage(Page page, String staffName,
			String yearMonth, String subOrganiseIdStr) {

		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = salaryDifferenceDao
				.findSalaryDifferenceCountByCriteriaQuery(staffName, yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<SalaryDifference> records = salaryDifferenceDao
				.findSalaryDifferencesByPageCriteriaQuery(staffName, yearMonth,
						subOrganiseIdStr, page.getPageSize(),
						page.getStartIndex());

		page.setRecords(records);
		return page;

	}

	/**
	 * 查询上个月的薪资差异记录
	 */
	public List<SalaryDifference> findSalaryDifferenceByYearMonth(
			String yearMonth) {

		return salaryDifferenceDao.findSalaryDifferenceByYearMonth(yearMonth);

	}

	@Override
	public boolean existsFlow(String stationCode) {
		int count = salaryDifferenceDao
				.findSalaryDifferenceCountByApprovalStatus(stationCode);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 提交薪资差异申请, 启动流程 这是油站会计干的事, 别的人别瞎掺和
	 */
	public boolean saveOrUpdateSalaryDifference(
			List<SalaryDifference> salaryDifferenceCheckedList,
			HttpServletRequest request, String stationCode) {

		// 判断数据库中是否有正在执行的流程
		// 如果有, 不予提交申请
		// int sdcount =
		// salaryDifferenceDao.findSalaryDifferenceCountByApprovalStatus();
		// if (0 == sdcount) {
		boolean returnValue = false;
		String nextUserName = null;

		// 获取当前登陆者信息
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession()
				.getAttribute(SysConstant.CURRENT_USER_INFO);
		UserStorePart userStorePart = userStorePartService
				.findUserStorePartByUserId(storeEmployee.getUserid());
		if ("S_003".equals(userStorePart.getStorePart())) { // 确定申请的人是油站会计, 开始干活
			// 将新增的薪资差异申请记录入库
			List<Staff> staffList = new ArrayList<Staff>();
			for (SalaryDifference salaryDifference : salaryDifferenceCheckedList) {
				if (null != salaryDifference.getId()
						&& !"".equals(salaryDifference.getId())) {
					salaryDifference.setSysUpdateTime(new Date());
					salaryDifferenceDao
							.updateByPrimaryKeySelective(salaryDifference);
				} else {
					int count = salaryDifferenceDao
							.findSalaryDifferenceCountByCriteriaQuery(null,
									null);
					String salaryDifferenceCode = null;
					if (count < 9) {
						salaryDifferenceCode = "SD_000"
								+ String.valueOf((count + 1));
					} else if (count >= 9 && count <= 98) {
						salaryDifferenceCode = "SD_00"
								+ String.valueOf((count + 1));
					} else if (count >= 99 && count <= 998) {
						salaryDifferenceCode = "SD_0"
								+ String.valueOf((count + 1));
					} else if (count >= 999) {
						salaryDifferenceCode = "SD_"
								+ String.valueOf((count + 1));
					}
					salaryDifference
							.setSalaryDifferenceCode(salaryDifferenceCode);
					salaryDifference.setApprovalStatus("1");
					salaryDifference.setSysCreateTime(new Date());
					salaryDifference.setStationCode(stationCode);
					salaryDifferenceDao.insertSelective(salaryDifference);
				}

				// 将勾选的员工查出来
				String staffCode = salaryDifference.getStaffCode();
				StaffQuery staffQuery = new StaffQuery();
				staffQuery.createCriteria().andStaffCodeEqualTo(staffCode);
				staffList.add(staffDao.selectByExample(staffQuery).get(0));
			}

			Map<String, Object> variablesnew = new HashMap<String, Object>();
			variablesnew.put("inputUser", storeEmployee.getUsername());

			SalaryDifferenceOffice salaryDifferenceOffice = new SalaryDifferenceOffice();
			String key = salaryDifferenceOffice.getClass().getSimpleName();
			// 获取objId
			List<String> staffCodeList = new ArrayList<String>();
			for (Staff staff : staffList) {
				staffCodeList.add(staff.getStaffCode());
			}
			StringUtil strUtil = new StringUtil();
			String staffCodes = strUtil.strListToString(staffCodeList);
			String objId = key + "." + staffCodes + ":5:" + stationCode;
			variablesnew.put("objId", objId);
			ProcessInstance processInstance = activiti.runtime(key, objId,
					variablesnew);
			Task task = activiti.getTask(null, storeEmployee.getUsername(),
					processInstance.getProcessInstanceId());
			// 完成自己任务，并给定下一个执行者
			Map<String, Object> variables = new HashMap<String, Object>();
			ProcessDefinitionEntity processDefinitionEntity = activiti
					.getProcessDefinitionEntity(task.getProcessDefinitionId());
			ActivityImpl activityImpl = processDefinitionEntity
					.findActivity(processInstance.getActivityId());
			List<PvmTransition> outTransitions = activityImpl
					.getOutgoingTransitions();
			for (PvmTransition tr : outTransitions) {
				PvmActivity destination = tr.getDestination();
				// 获取线路的终点节点
				ActivityImpl ac = (ActivityImpl) destination;
				UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) ac
						.getActivityBehavior();
				TaskDefinition taskDefinition = activityBehavior
						.getTaskDefinition();
				Set<Expression> candidateGroupIdExpressions = taskDefinition
						.getCandidateGroupIdExpressions();
				for (Expression expression : candidateGroupIdExpressions) {
					String departmentCode = null;
					String[] groupRole = expression.toString().split(":");
					// 角色编号
					String groupRoleCode = groupRole[0];
					// 角色类型 0 油站 1 区域 2 总部
					String groupRoleType = groupRole[1];
					// if ("0".equals(groupRoleType)) {
					departmentCode = storeEmployee.getOrganiseId();
					// }
					if ("1".equals(groupRoleType)) {
						// DepPart depPart =
						// depPartService.queryDeptPartByRoleId(groupRoleCode);
						// groupRoleCode=depPart.getpStorePart();
						// departmentCode = storeEmployee.getOrganiseId();
						OrganiseCO organiseCO = this.organiseCOService
								.findOrganiseCOByorganiseId(departmentCode);
						departmentCode = organiseCO.getpOrganiseId();
					}
					List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
							.queryStoreEmployeeVOBypStorePart(groupRoleCode,
									departmentCode);
					if (null != storeEmployeeVO && storeEmployeeVO.size() > 0) {
						nextUserName = storeEmployeeVO.get(0).getUsername();
					}
				}
			}
			variables.put("checkUser", nextUserName);
			// 更新 历史记录
			activiti.updateActHiActinst(task, "提交");
			activiti.complete(task.getId(), variables);
			returnValue = true;
		}
		return returnValue;
		// }else{ //页面给予提示, 还有正在审批中的流程, 不可发起新的申请
		// boolean returnValue = false;
		// return returnValue;
		// }

	}

	/**
	 * 根据员工编号查询相应的薪资差异信息
	 */
	public SalaryDifference findSalaryDifferenceByStaffCode(String staffCode) {

		if (null != staffCode && !"".equals(staffCode)) {
			SalaryDifferenceQuery salaryDifferenceQuery = new SalaryDifferenceQuery();
			salaryDifferenceQuery.createCriteria().andStaffCodeEqualTo(
					staffCode);
			return salaryDifferenceDao.selectByExample(salaryDifferenceQuery)
					.get(0);
		} else {
			throw new RuntimeException(
					"The staffCode is null or '', we can't select anything by this staffCode!");
		}

	}

	/**
	 * 根据油站编号查询该油站下所有的员工(包含员工所属的油站名称)
	 */
	public List<SalaryDifference> findStaffListWithStationNameByStationCode(
			String subOrganiseIdStr, String yearMonth) {

		List<SalaryDifference> salaryDifferenceList = new ArrayList<SalaryDifference>();
		String[] organiseIds = subOrganiseIdStr.split(",");
		for (String organiseId : organiseIds) {
			List<SalaryDifference> salaryDifferences = salaryDifferenceDao
					.findStaffListWithStationNameByStationCode(organiseId,
							yearMonth);
			for (SalaryDifference salaryDifference : salaryDifferences) {
				salaryDifferenceList.add(salaryDifference);
			}
		}
		return salaryDifferenceList;
	}

	/**
	 * 根据员工编号查询出对应的薪资差异记录(包含员工所属的油站名称)
	 */
	public SalaryDifference findSalaryDifferenceWithStationNameByStaffCode(
			String staffCode) {

		if (null != staffCode && !"".equals(staffCode)) {
			return salaryDifferenceDao
					.findSalaryDifferenceWithStationNameByStaffCode(staffCode);
		} else {
			return null;
		}

	}

	@Override
	public List<SalaryDifference> findByStaffCodes(String stationCode,
			String yearMonth, String[] staffCodes) {
		return salaryDifferenceDao.findByStaffCodes(stationCode, yearMonth,
				staffCodes);
	}

}
