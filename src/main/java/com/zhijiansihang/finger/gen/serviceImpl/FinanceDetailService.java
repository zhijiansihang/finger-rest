package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.*;
import com.zhijiansihang.finger.app.dao.mysql.model.*;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.FinanceDetailRequest;
import com.zhijiansihang.finger.gen.entity.FinanceDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 理财师详情
 *
 */
@Component("financeDetailService")
public class FinanceDetailService implements MessageService<FinanceDetailRequest, Response<FinanceDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(FinanceDetailService.class);
	private static final String SERVICE_DESC = "理财师详情";

	@Autowired
	UserFinanceDetailDAO userFinanceDetailDAO;
	@Autowired
	UserFriendCountDAO userFriendCountDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	UserInstitutionDetailDAO userInstitutionDetailDAO;
	@Autowired
	SharingProperties sharingProperties;
	@Autowired
	UserCollectionDAO userCollectionDAO;

	@Autowired
	LoanFinanceDAO loanFinanceDAO;

	@Autowired
	UserFriendDAO userFriendDAO;

	@Autowired
	UserServiceRecordDAO userServiceRecordDAO;

	@Autowired
	LoanInvestorFinanceDAO loanInvestorFinanceDAO;
	@Override
	public void execute(FinanceDetailRequest request, Response<FinanceDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		String financeUserid = request.getFinanceUserid();

		Long loginUserid = UserTools.getLoginUser().getId();

		UserFinanceDetailDO userFinanceDetailDO = userFinanceDetailDAO.selectByPrimaryKey(Long.parseLong(financeUserid));
		response.getBody().setAdoptCount(userFinanceDetailDO.getAdoptCount().toString());
		response.getBody().setEducationLevel(CheckTools.nullToEmptyString(userFinanceDetailDO.getEducationLevel()));

		UserFriendCountDO userFriendCountDO = userFriendCountDAO.selectByPrimaryKey(Long.parseLong(financeUserid));
		response.getBody().setFriendCount(userFriendCountDO.getFriendCounts().toString());

		UserDO financeUserDO = userDAO.selectByPrimaryKey(Long.parseLong(financeUserid));
		UserInstitutionDetailDO userfinanceInstitutionDetailDO = userInstitutionDetailDAO.selectByPrimaryKey(financeUserDO.getInstitutionUserId());
		response.getBody().setInstitutionName(userfinanceInstitutionDetailDO.getName());
		response.getBody().setIsPerson(userfinanceInstitutionDetailDO.getIsPersonal().toString());

		{
			UserCollectionDO userCollectionDO = new UserCollectionDO();
			userCollectionDO.setUserId(loginUserid);
			userCollectionDO.setContentId(Long.parseLong(financeUserid));
			userCollectionDO.setContentType((byte)1);
			int i = userCollectionDAO.existContentidtypeAndUserid(userCollectionDO);
			if (i>0){
				response.getBody().setIsCollection("1");
			}else {
				response.getBody().setIsCollection("0");
			}
		}
		{
			UserFriendDOExample example = new UserFriendDOExample();
			UserFriendDOExample.Criteria criteria = example.createCriteria();
			criteria.andMyUserIdEqualTo(loginUserid).andFriendUserIdEqualTo(Long.parseLong(financeUserid) );
			List<UserFriendDO> userFriendDOS = userFriendDAO.selectByExample(example);
			if (userFriendDOS != null && userFriendDOS.size() >0){
				response.getBody().setIsFriend("1");
			}else {
				response.getBody().setIsFriend("0");
			}
		}
		{
			int count = loanFinanceDAO.countLoanByFinanceUser(Long.parseLong(financeUserid));
			response.getBody().setLoanCount(count +"");
		}
		if (financeUserDO.getLogo() == null || financeUserDO.getLogo().trim().length() == 0){
			response.getBody().setLogo("");
		}else {
			response.getBody().setLogo(sharingProperties.getStaticServerLink()+financeUserDO.getLogo());
		}
		response.getBody().setPersonalProfile(CheckTools.nullToEmptyString(userFinanceDetailDO.getPersonalProfile()));
		response.getBody().setPosition(CheckTools.nullToEmptyString(userFinanceDetailDO.getPosition()));
		response.getBody().setRealName(CheckTools.nullToEmptyString(financeUserDO.getNickName()));
		response.getBody().setSchoolName(CheckTools.nullToEmptyString(userFinanceDetailDO.getSchoolName()));
		{
			int count = loanFinanceDAO.countSellingLoanByFinanceUser(Long.parseLong(financeUserid));
			response.getBody().setSellingloanCount(count + "");
		}

		response.getBody().setServiceConcept(CheckTools.nullToEmptyString(userFinanceDetailDO.getServiceConcept()));
		response.getBody().setServiceDirection(CheckTools.nullToEmptyString(userFinanceDetailDO.getServiceDirection()));

		{
			int i = userServiceRecordDAO.countByUserid(Long.parseLong(financeUserid));
			response.getBody().setServicePersonCount(i + "");
		}
		response.getBody().setUserId(financeUserid);
		{
			int i = loanInvestorFinanceDAO.countByFinanceUserid(Long.parseLong(financeUserid));
			response.getBody().setUserOrderCount(i+"");
		}
		response.getBody().setWorkAge(userFinanceDetailDO.getWorkAge() ==null ?"1":userFinanceDetailDO.getWorkAge().toString());
		response.getBody().setWorkingExperience(CheckTools.nullToEmptyString(userFinanceDetailDO.getWorkingExperience()));
	}
}
