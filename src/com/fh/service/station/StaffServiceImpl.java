package com.fh.service.station;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.Expression;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fh.activiti.service.Activiti;
import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.dao.biz.DutyDao;
import com.fh.dao.biz.StaffDao;
import com.fh.dao.biz.StaffTransferDao;
import com.fh.entity.AccountantStaffLeaveOffice;
import com.fh.entity.GeneralStaffLeaveOffice;
import com.fh.entity.ManagerStaffLeaveOffice;
import com.fh.entity.biz.Duty;
import com.fh.entity.biz.DutyQuery;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffQuery;
import com.fh.entity.biz.StaffTransfer;
import com.fh.entity.biz.StaffVO;
import com.fh.entity.system.DepPart;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.service.system.DepPartService;
import com.fh.service.system.OrganiseCOService;
import com.fh.service.system.StoreEmployeeService;
import com.fh.util.UploadFile;

/**
 * StaffService 业务逻辑层实现类
 * 
 * @author lijn
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	@Autowired
	private DutyDao dutyDao;

	@Autowired
	private Activiti activiti;

	@Autowired
	private DepPartService depPartService;

	@Autowired
	private OrganiseCOService organiseCOService;

	@Autowired
	private StoreEmployeeService storeEmployeeService;

	@Autowired
	private StaffTransferDao staffTransferDao;

	/*
	 * @Autowired private TbWorkflowUserDUserDao tbWorkflowUserDUserDao;
	 */

	/*
	 * @Autowired private StaffTempDao staffTempDao;
	 */

	/**
	 * 查询 所有 员工基本信息
	 * 
	 * @return
	 */
	@Override
	public List<StaffVO> queryAll() {
		StoreEmployee currentUser = SysConstant.getCurrentUser();
		String subOrganiseIdStr = currentUser.getSubOrganiseIdStr();

		/*
		 * StaffQuery staffQuery = new StaffQuery(); String[] split =
		 * subOrganiseIdStr.split(","); List<String> subOrganiseIdList=new
		 * ArrayList<String>(); for (String string : split) {
		 * subOrganiseIdList.add(string); }
		 * staffQuery.createCriteria().andStationCodeIn
		 * (subOrganiseIdList).andStaffStatusEqualTo("1"); List<Staff> staffList
		 * = staffDao.selectByExample(staffQuery);
		 */
		List<StaffVO> staffVOStaffList = staffDao.queryAll(subOrganiseIdStr);
		if (staffVOStaffList != null && staffVOStaffList.size() > 0) {
			return staffVOStaffList;
		}
		return null;
	}

	/**
	 * 分页查询 员工基本信息
	 * 
	 * @return
	 */

	public Page findStaffsByPage(Page page, String staffName,
			String staffStatus, String subOrganiseIdStr, String dutyCode) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = staffDao.findCountByCriteriaQuery(staffName,
				staffStatus, subOrganiseIdStr, dutyCode);
		page.setTotalRecordsNum(totalRecordsNum);
		// if (staffStatus == null || "".equals(staffStatus)) {
		// staffStatus = "1";
		// }
		// 分页查询记录
		List<StaffVO> records = staffDao.findStaffsByPageCriteriaQuery(
				staffName, staffStatus, subOrganiseIdStr, dutyCode,
				page.getPageSize(), page.getStartIndex());
		List<StaffVO> staffVOList = new ArrayList<StaffVO>();
		// 获取当前登录 用户
		StoreEmployee storeEmployee = SysConstant.getCurrentUser();
		List<DepPart> deptPartList = depPartService
				.queryDeptPartByUserId(storeEmployee.getUserid());
		if (records != null && records.size() > 0) {
			for (StaffVO staffVO : records) {
				{
					int flag = 0;
					String key = null;
					String[] accountants = SysConstant.AVTIVITI_STAFF_DUTY_ACCOUNTANT
							.split(",");
					for (String accountant : accountants) {
						if (accountant.equals(staffVO.getDutyCode())) {
							AccountantStaffLeaveOffice accountantStaffLeaveOffice = new AccountantStaffLeaveOffice();
							key = accountantStaffLeaveOffice.getClass()
									.getSimpleName();
							flag = 1;
						}
					}
					String[] managers = SysConstant.AVTIVITI_STAFF_DUTY_MANAGER
							.split(",");
					for (String manager : managers) {
						if (manager.equals(staffVO.getDutyCode())) {
							ManagerStaffLeaveOffice managerStaffLeaveOffice = new ManagerStaffLeaveOffice();
							key = managerStaffLeaveOffice.getClass()
									.getSimpleName();
							flag = 2;
						}
					}
					if (staffVO.getStationCode() == null
							|| "".equals(staffVO.getStationCode())) {
						flag = 4;
					}

					if (flag == 0) {
						GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
						key = generalStaffLeaveOffice.getClass()
								.getSimpleName();
					}
					staffVO.setFlag(flag);
					ProcessDefinition processDefinition = activiti
							.getProcessDefinition(null, key);
					if (processDefinition != null) {
						String id = processDefinition.getId();
						ProcessDefinitionEntity def = activiti
								.getProcessDefinitionEntity(id);
						ActivityImpl activityImpl = def
								.findActivity("inputUser1");
						if (activityImpl != null && !"".equals(activityImpl)) {
							UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) activityImpl
									.getActivityBehavior();
							TaskDefinition taskDefinition = activityBehavior
									.getTaskDefinition();
							Set<Expression> candidateGroupIdExpressions = taskDefinition
									.getCandidateGroupIdExpressions();
							if (deptPartList != null && deptPartList.size() > 0) {

								for (DepPart deptPart : deptPartList) {
									for (Expression expression : candidateGroupIdExpressions) {
										String[] groupRole = expression
												.toString().split(":");
										// 角色编号
										String groupRoleCode = groupRole[0];
										if (groupRoleCode.equals(deptPart
												.getStorePart())) {
											staffVO.setIsAvailable(0);
										}
									}
								}
							}

						}

					}
					staffVOList.add(staffVO);
				}
			}
		}
		page.setRecords(staffVOList);
		return page;
	}

	/**
	 * 添加员工信息
	 * 
	 * @param station
	 */
	@Override
	public boolean saveOrUpdate(HttpServletRequest request, String type,
			MultipartFile uploadPic, Staff staff, String flag) {
		boolean result = true;

		if (uploadPic != null && !"".equals(uploadPic)) {
			String path = uploadStaffPhoto(request, type, uploadPic,
					staff.getStaffCode());
			if (path != null && !"".equals(path)) {
				if (!"0".equals(path)) {
					String[] splitPath = path.split("uploadFiles");
					String replacePath = splitPath[splitPath.length - 1]
							.replace("\\", "/");
					staff.setStaffPhoto(replacePath);
				}
			} else {
				result = false;
				return result;
			}
		}
		if (staff.getId() != null && !"".equals(staff.getId())) {
			staff.setSysUpdateTime(new Date());
			staffDao.updateByPrimaryKeySelective(staff);
		} else {
			if (staff.getStaffInDate() == null
					|| "".equals(staff.getStaffInDate())) {
				staff.setStaffInDate(new SimpleDateFormat("yyyy-mm-dd")
						.format(new Date()));
			}
			staff.setStaffStatus("1");
			staff.setSysCreateTime(new Date());
			staffDao.insertSelective(staff);
		}

		return result;
	}

	/*
	 * 入职流程
	 * 
	 * @Override public void saveOrUpdate(HttpServletRequest request, String
	 * type, StaffTemp staffTemp,String flag) { if (staffTemp != null &&
	 * !"".equals(staffTemp)) { if(staffTemp.getEntryDate()!=null &&
	 * !"".equals(staffTemp.getEntryDate())){ String
	 * entryDate=staffTemp.getEntryDate(); String year =
	 * entryDate.substring(0,entryDate.indexOf("-")); String
	 * month=entryDate.substring(5,7); String
	 * day=entryDate.substring(9,entryDate.length()); Integer valueOf =
	 * Integer.valueOf(year); String newyear=String.valueOf(valueOf+3);
	 * staffTemp
	 * .setAgreementDeadline(year+"年"+month+"月"+day+"日"+"-"+newyear+"年"+
	 * month+"月"+day+"日"); } Subject currentUser = SecurityUtils.getSubject();
	 * Session session = currentUser.getSession(); StoreEmployee storeEmployee =
	 * (StoreEmployee) session.getAttribute(SysConstant.CURRENT_USER_INFO);
	 * staffTemp.setStationCode(storeEmployee.getOrganiseId()); // 新增
	 * staffTemp.setSysCreateTime(new Date());
	 * staffTempDao.insertSelective(staffTemp); // 获取当前登录 用户 并 启动流程 Subject
	 * currentUser = SecurityUtils.getSubject(); Session session =
	 * currentUser.getSession(); StoreEmployee storeEmployee = (StoreEmployee)
	 * session .getAttribute(SysConstant.CURRENT_USER_INFO); Map<String, Object>
	 * variablesnew = new HashMap<String, Object>();
	 * variablesnew.put("inputUser", storeEmployee.getUsername());
	 * variablesnew.put("startUser", storeEmployee.getUsername()); String key =
	 * null; if ("0".equals(flag)) { GeneralStaffEntry generalStaffEntry = new
	 * GeneralStaffEntry(); key = generalStaffEntry.getClass().getSimpleName();
	 * String objId = key + "." + staffTemp.getStaffCode()+":1";
	 * variablesnew.put("objId", objId);
	 * runtimeService.startProcessInstanceByKey(key, objId, variablesnew); }
	 * 
	 * } }
	 */

	/**
	 * 保存离职申请信息
	 * 
	 * @param station
	 * @return true 启动流程成功 false 启动流程失败
	 */
	@Override
	public boolean staffLeaveOffice(HttpServletRequest request, String type,
			MultipartFile uploadPic, Staff staff, String sign, String flag) {
		boolean returnValue = false;
		String nextUserName = null;

		if (uploadPic != null && !"".equals(uploadPic)) {
			String path = staffOutUrl(request, type, uploadPic, sign,
					staff.getStaffCode());
			if (path != null && !"".equals(path)) {
				String[] splitPath = path.split("uploadFiles");
				String replacePath = splitPath[splitPath.length - 1].replace(
						"\\", "/");
				staff.setStaffOutUrl(replacePath);
			}
		}
		if (staff != null && !"".equals(staff)) {
			if (staff.getId() != null && !"".equals(staff.getId())) {
				if (staff.getStaffOutDate() == null
						|| "".equals(staff.getStaffOutDate())) {
					SimpleDateFormat df = new SimpleDateFormat(
							"yyyy-MM-dd HH:MM:ss");
					String date = df.format(new Date());
					staff.setStaffOutDate(date);
				}
				// 修改
				staff.setSysUpdateTime(new Date());
				// 获取当前登录 用户 并 启动流程
				StoreEmployee storeEmployee = SysConstant.getCurrentUser();
				Map<String, Object> variablesnew = new HashMap<String, Object>();
				variablesnew.put("inputUser", storeEmployee.getUsername());
				String key = null;
				// TbWorkflowUserDUser tbWorkflowUserDUser = new
				// TbWorkflowUserDUser();
				// TODO 暂时先去掉
				if ("0".equals(flag)) {
					GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
					key = generalStaffLeaveOffice.getClass().getSimpleName();
				}
				if ("1".equals(flag)) {
					AccountantStaffLeaveOffice accountantStaffLeaveOffice = new AccountantStaffLeaveOffice();
					key = accountantStaffLeaveOffice.getClass().getSimpleName();
				}
				if ("2".equals(flag)) {
					ManagerStaffLeaveOffice managerStaffLeaveOffice = new ManagerStaffLeaveOffice();
					key = managerStaffLeaveOffice.getClass().getSimpleName();
				}

				String objId = key + "." + staff.getId() + ":0";
				variablesnew.put("objId", objId);
				ProcessInstance processInstance = activiti.runtime(key, objId,
						variablesnew);
				if (processInstance != null) {
					staff.setStaffOutStatus("0");
					staffDao.updateByPrimaryKeySelective(staff);
					Task task = activiti.getTask(null,
							storeEmployee.getUsername(),
							processInstance.getProcessInstanceId());
					// 完成自己任务，并给定下一个执行者
					Map<String, Object> variables = new HashMap<String, Object>();
					ProcessDefinitionEntity processDefinitionEntity = activiti
							.getProcessDefinitionEntity(task
									.getProcessDefinitionId());
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
							String[] groupRole = expression.toString().split(
									":");
							// 角色编号
							String groupRoleCode = groupRole[0];
							// 角色类型 0 油站 1 区域 2 总部 (改为： 0-本级；1-上级)
							String groupRoleType = groupRole[1];
							departmentCode = staff.getStationCode();
							// if("0".equals(groupRoleType)){
							// departmentCode=staff.getStationCode();
							// }
							if ("1".equals(groupRoleType)) {
								// DepPart depPart =
								// depPartService.queryDeptPartByRoleId(groupRoleCode);
								// groupRoleCode=depPart.getpStorePart();
								OrganiseCO organiseCO = this.organiseCOService
										.findOrganiseCOByorganiseId(departmentCode);
								departmentCode = organiseCO.getpOrganiseId();
							}
							List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
									.queryStoreEmployeeVOBypStorePart(
											groupRoleCode, departmentCode);
							if (storeEmployeeVO != null
									&& storeEmployeeVO.size() > 0) {
								nextUserName = storeEmployeeVO.get(0)
										.getUsername();
							}
						}
					}
					variables.put("checkUser", nextUserName);
					// 更新 历史记录
					activiti.updateActHiActinst(task, "提交");
					activiti.complete(task.getId(), variables);
					returnValue = true;
				}
			}
		}
		return returnValue;
		/*
		 * String processDefinitionId =
		 * startProcessInstanceByKey.getProcessDefinitionId();
		 * tbWorkflowUserDUser .setProcessDefinitionId(processDefinitionId);
		 * tbWorkflowUserDUser.setUserid(storeEmployee.getUsername());
		 * tbWorkflowUserDUser .setUserPart(storeEmployee.getDepPartCode());
		 * tbWorkflowUserDUser .setUserDep(storeEmployee.getOrganiseId());
		 * tbWorkflowUserDUser .setdUserid(storeEmployee.getDepPartCode());
		 * tbWorkflowUserDUser.setBeginDate(new Date());
		 * tbWorkflowUserDUser.setFlowType("离职申请");
		 * tbWorkflowUserDUser.setDiff("0");
		 * tbWorkflowUserDUserDao.insertSelective(tbWorkflowUserDUser);
		 */
	}

	/**
	 * 根据id查询员工基本信息
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Staff queryStaffById(String id) {
		if (id != null && !"".equals(id)) {
			return staffDao.selectByPrimaryKey(Long.valueOf(id));
		} else {
			return null;
		}
	}

	/**
	 * 根据id删除员工基本信息
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public void deleteStaffById(String id) {
		staffDao.deleteByPrimaryKey((Long.valueOf(id)));
	}

	/**
	 * 根据id进行离职申请
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public String leaveOffice(String id) {
		if (id != null && !"".equals(id)) {
			Staff staff = staffDao.selectByPrimaryKey(Long.valueOf(id));
			if (staff != null && !"".equals(staff)) {
				if ("2".equals(staff.getStaffStatus())) {
					return "alreadyExisting";
				} else {
					return "success";
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 上传员工照片
	 * 
	 * @param model
	 * @return
	 */
	public String uploadStaffPhoto(HttpServletRequest request, String type,
			MultipartFile uploadPic, String staffCode) {
		// 判断上传的文件是否是空文件
		String originalFilename = uploadPic.getOriginalFilename();
		if ("" == originalFilename) {
			return "0";
		}

		// 判断上传的是否是png文件
		String substring = originalFilename.substring(originalFilename
				.lastIndexOf("."));
		if (!".png".equals(substring)) {
			if (!".jpg".equals(substring)) {
				return null;
			}
		}
		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil.uploadFile(request, uploadPic, type, null);
		return filePath;
	}

	/**
	 * 离职附件
	 * 
	 * @param model
	 * @return
	 */
	public String staffOutUrl(HttpServletRequest request, String type,
			MultipartFile uploadPic, String sign, String staffCode) {
		// 判断上传的文件是否是空文件
		String originalFilename = uploadPic.getOriginalFilename();
		if ("" == originalFilename) {
			return null;
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename
				.lastIndexOf("."));
		if (".exe".equals(substring)) {
			return null;
		}

		String fileName = null;
		if ("1".equals(sign)) {
			fileName = staffCode + "staffLeaveOffice" + substring;
		}
		if ("2".equals(sign)) {
			fileName = staffCode + "staffTransfer" + substring;
		}

		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil.uploadFile(request, uploadPic, type,
				fileName);
		return filePath;
	}

	/**
	 * 根据查出油站中所有员工(包含员工所拥有的职务)
	 */
	public List<Staff> findStaffsByStationCode(String stationCode) {

		StaffQuery staffQuery = new StaffQuery();
		staffQuery.createCriteria().andStationCodeEqualTo(stationCode);
		List<Staff> staffs = staffDao.selectByExample(staffQuery);

		for (Staff staff : staffs) {
			String dutyCode = staff.getDutyCode();
			DutyQuery dutyQuery = new DutyQuery();
			dutyQuery.createCriteria().andDutyCodeEqualTo(dutyCode);
			List<Duty> duty = dutyDao.selectByExample(dutyQuery);
			staff.setDuty(duty.get(0));
		}
		return staffs;

	}

	/**
	 * 根据id更新员工信息
	 */
	public void updateStaffById(Staff staff) {
		try {
			staffDao.updateByPrimaryKeySelective(staff);
		} catch (Exception e) {
			throw new IllegalArgumentException("员工找不到");
		}
	}

	/**
	 * 保存调动申请信息
	 * 
	 * @return true 启动流程成功 false 启动流程失败
	 */
	public boolean staffTransfer(HttpServletRequest request, String type,
			MultipartFile uploadPic, StaffTransfer staffTransfer, String sign,
			String flag, String staffId) {
		boolean returnValue = false;
		String nextUserName = null;
		if (staffTransfer != null && !"".equals(staffTransfer)) {
			staffTransfer.setTransferCode(UUID.randomUUID().toString()
					.replace("-", ""));
			if (uploadPic != null && !"".equals(uploadPic)) {
				String path = staffOutUrl(request, type, uploadPic, sign,
						staffTransfer.getStaffCode());
				if (path != null && !"".equals(path) && !"null".equals(path)) {
					String[] splitPath = path.split("uploadFiles");
					String replacePath = splitPath[splitPath.length - 1]
							.replace("\\", "/");
					staffTransfer.setStaffTransferUrl(replacePath);
				}
			}

			if (staffTransfer.getStaffTransferDate() == null
					|| "".equals(staffTransfer.getStaffTransferDate())) {
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:MM:ss");
				String date = df.format(new Date());
				staffTransfer.setStaffTransferDate(date);
			}
			// 修改
			staffTransfer.setSysUpdateTime(new Date());
			// 获取当前登录 用户 并 启动流程
			StoreEmployee storeEmployee = SysConstant.getCurrentUser();
			Map<String, Object> variablesnew = new HashMap<String, Object>();
			variablesnew.put("inputUser", storeEmployee.getUsername());
			String key = null;
			if ("0".equals(flag) || "1".equals(flag) || "2".equals(flag)) {
				key = staffTransfer.getClass().getSimpleName();
			}

			String objId = key + "." + staffTransfer.getTransferCode() + ":2";
			variablesnew.put("objId", objId);
			ProcessInstance processInstance = activiti.runtime(key, objId,
					variablesnew);
			if (processInstance != null) {
				Staff staff = new Staff();
				staff.setId(Long.valueOf(staffId));
				staff.setStaffOutStatus("1");
				staffDao.updateByPrimaryKeySelective(staff);

				// 新增调动新消息
				staffTransferDao.insertSelective(staffTransfer);

				Task task = activiti.getTask(null, storeEmployee.getUsername(),
						processInstance.getProcessInstanceId());
				// 完成自己任务，并给定下一个执行者
				Map<String, Object> variables = new HashMap<String, Object>();
				ProcessDefinitionEntity processDefinitionEntity = activiti
						.getProcessDefinitionEntity(task
								.getProcessDefinitionId());
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
						if ("0".equals(groupRoleType)) {
							departmentCode = staffTransfer
									.getBeforeStationCode();
						}
						if ("1".equals(groupRoleType)) {
							// DepPart depPart =
							// depPartService.queryDeptPartByRoleId(groupRoleCode);
							// groupRoleCode=depPart.getpStorePart();
							OrganiseCO organiseCO = this.organiseCOService
									.findOrganiseCOByorganiseId(departmentCode);
							departmentCode = organiseCO.getpOrganiseId();
						}
						List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
								.queryStoreEmployeeVOBypStorePart(
										groupRoleCode, departmentCode);
						if (storeEmployeeVO != null
								&& storeEmployeeVO.size() > 0) {
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
		}
		return returnValue;
	}

	/**
	 * 根据员工编号查询员工基本信息
	 * 
	 * @param id
	 * @return
	 */
	public Staff queryStaffByStaffCode(String staffCode, String stationCode) {
		StaffQuery staffQuery = new StaffQuery();
		staffQuery.createCriteria().andStaffCodeEqualTo(staffCode)
				.andStationCodeEqualTo(stationCode);
		List<Staff> staffList = staffDao.selectByExample(staffQuery);
		if (staffList != null && staffList.size() > 0) {
			return staffList.get(0);
		}
		return null;
	}

	public Staff queryStaffByIdcard(String stataionCode, String idcard) {
		StaffQuery staffQuery = new StaffQuery();
		staffQuery.createCriteria().andStaffIdcardEqualTo(idcard)
				.andStationCodeEqualTo(stataionCode);
		List<Staff> staffList = staffDao.selectByExample(staffQuery);
		if (staffList != null && staffList.size() > 0) {
			return staffList.get(0);
		}
		return null;
	}

	/**
	 * 根据油站编号查询出对应的油站所有的员工(不包含员工所有拥有的职务)
	 */
	public List<Staff> findStaffListByStationCode(String subOrganiseIdStr) {

		List<Staff> staffList = new ArrayList<Staff>();
		String[] organiseIds = subOrganiseIdStr.split(",");
		for (String organiseId : organiseIds) {
			StaffQuery staffQuery = new StaffQuery();
			staffQuery.createCriteria().andStationCodeEqualTo(organiseId);
			List<Staff> staffs = staffDao.selectByExample(staffQuery);
			for (Staff staff : staffs) {
				staffList.add(staff);
			}
		}
		return staffList;

	}

	/**
	 * 查询所有的员工信息(包含工作日)
	 */
	public List<Staff> findAllStaffWithWorkingDay() {

		return staffDao.findAllStaffWithWorkingDay();

	}

	public Staff getStaffByCondition(Staff staff) {
		List<Staff> staffList = staffDao.getStaffByCondition(staff);
		if (staffList != null && staffList.size() > 0) {
			return staffList.get(0);
		}
		return new Staff();
	}

}
