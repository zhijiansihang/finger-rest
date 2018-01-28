package com.zhijiansihang.finger;

import java.sql.Timestamp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.common.RetCode;
import com.zhijiansihang.finger.gen.entity.*;
import com.zhijiansihang.finger.mmc.MobileMessage;
import com.zhijiansihang.gateway.util.JwtTokenUtil;
import com.zhijiansihang.gateway.util.UserSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;





/**
 *  单元测试
 * 
 * @author 代码生成器v1.0
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
  
	private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private MockMvc mockMvc;

	private String sessionId;

	@Autowired
	protected WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}	
	
	@Test
	public void addSolution() throws Exception {


		AddSolutionRequest request = new AddSolutionRequest();
	    request.setId("1");
	    request.setType("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[addSolution] Y增加收藏接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/addSolution");

		LOG.info("[addSolution] Y增加收藏接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void consultingRecord() throws Exception {


		ConsultingRecordRequest request = new ConsultingRecordRequest();
	    request.setConsultingUserid("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[consultingRecord] Y点咨询记录接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/consultingRecord");

		LOG.info("[consultingRecord] Y点咨询记录接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void createMyDemand() throws Exception {


		CreateMyDemandRequest request = new CreateMyDemandRequest();
	    request.setAdditionalRemarks("哈哈");
	    request.setEarningType("1");
	    request.setExpectedDeadline("1");
	    request.setMoneySituation("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[createMyDemand] Y发布我的需求接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/createMyDemand");

		LOG.info("[createMyDemand] Y发布我的需求接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void createMySolution() throws Exception {


		CreateMySolutionRequest request = new CreateMySolutionRequest();
	    request.setEarningType("1");
	    request.setExpectedDeadline("1");
	    request.setMoneySituation("1");
	    request.setRiskAssessmentLevel("1");
	    request.setSolution("哈哈");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[createMySolution] Y发布我的方案接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/createMySolution");

		LOG.info("[createMySolution] Y发布我的方案接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void demandDetail() throws Exception {


		DemandDetailRequest request = new DemandDetailRequest();
	    request.setDemandId("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[demandDetail] 需求详情接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/demandDetail");

		LOG.info("[demandDetail] 需求详情接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void financeDetail() throws Exception {


		FinanceDetailRequest request = new FinanceDetailRequest();
	    request.setFinanceUserid("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[financeDetail] 理财师详情接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/financeDetail");

		LOG.info("[financeDetail] 理财师详情接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void financeLoanInvestor() throws Exception {


		FinanceLoanInvestorRequest request = new FinanceLoanInvestorRequest();
	    request.setCurrentPage("1");
	    request.setIsDeal("0");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[financeLoanInvestor] 理财师查看属于预约自己的记录接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/financeLoanInvestor");

		LOG.info("[financeLoanInvestor] 理财师查看属于预约自己的记录接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void financeLoanRecommend() throws Exception {


		FinanceLoanRecommendRequest request = new FinanceLoanRecommendRequest();
	    request.setCurrentPage("1");
	    request.setFinanceUserid("1");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[financeLoanRecommend] 理财师标推荐接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/financeLoanRecommend");

		LOG.info("[financeLoanRecommend] 理财师标推荐接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void financeOperateLoanInvestor() throws Exception {


		FinanceOperateLoanInvestorRequest request = new FinanceOperateLoanInvestorRequest();
	    request.setId("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[financeOperateLoanInvestor] Y理财师操作预约记录接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/financeOperateLoanInvestor");

		LOG.info("[financeOperateLoanInvestor] Y理财师操作预约记录接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void getCms() throws Exception {


		GetCmsRequest request = new GetCmsRequest();
	    request.setCurrentPage("1");
	    request.setPageSize("10");
	    request.setTypeCode("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[getCms] Y获取banner咨询公告接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/getCms");

		LOG.info("[getCms] Y获取banner咨询公告接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void getNameAuthAndRiskResult() throws Exception {


		GetNameAuthAndRiskResultRequest request = new GetNameAuthAndRiskResultRequest();
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[getNameAuthAndRiskResult] Y是否实名认证和评测接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/getNameAuthAndRiskResult");

		LOG.info("[getNameAuthAndRiskResult] Y是否实名认证和评测接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void getSms() throws Exception {


		GetSmsRequest request = new GetSmsRequest();
	    request.setKaptchaCode("11111");
	    request.setKaptchaToken("111");
	    request.setMobile("110");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[getSms] Y获取短信验证码接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/getSms");

		LOG.info("[getSms] Y获取短信验证码接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void getUser() throws Exception {


		GetUserRequest request = new GetUserRequest();
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[getUser] Y获取用户接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/getUser");

		LOG.info("[getUser] Y获取用户接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void isFriend() throws Exception {


		IsFriendRequest request = new IsFriendRequest();
	    request.setFriendUserid("1223");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[isFriend] Y是否是好友关系接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/isFriend");

		LOG.info("[isFriend] Y是否是好友关系接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void loanInvestorDetail() throws Exception {


		LoanInvestorDetailRequest request = new LoanInvestorDetailRequest();
	    request.setId("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[loanInvestorDetail] 预约详情接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/loanInvestorDetail");

		LOG.info("[loanInvestorDetail] 预约详情接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void loginOrRegister() throws Exception {


		LoginOrRegisterRequest request = new LoginOrRegisterRequest();
	    request.setMobile("110");
	    request.setSmsCode("11111");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[loginOrRegister] Y注册或者登陆接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/loginOrRegister");

		LOG.info("[loginOrRegister] Y注册或者登陆接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void makeFriend() throws Exception {


		MakeFriendRequest request = new MakeFriendRequest();
	    request.setFriendUserid("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[makeFriend] Y交朋友接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/makeFriend");

		LOG.info("[makeFriend] Y交朋友接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void myCollectionLoan() throws Exception {


		MyCollectionLoanRequest request = new MyCollectionLoanRequest();
	    request.setCurrentPage("1");
	    request.setPageSize("10");
	    request.setProductType("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[myCollectionLoan] 我的收藏标的接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/myCollectionLoan");

		LOG.info("[myCollectionLoan] 我的收藏标的接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void myCollectionPerson() throws Exception {


		MyCollectionPersonRequest request = new MyCollectionPersonRequest();
	    request.setCurrentPage("1");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[myCollectionPerson] Y我的收藏-店铺接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/myCollectionPerson");

		LOG.info("[myCollectionPerson] Y我的收藏-店铺接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void myDemand() throws Exception {


		MyDemandRequest request = new MyDemandRequest();
	    request.setCurrentPage("1");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[myDemand] Y我的需求接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/myDemand");

		LOG.info("[myDemand] Y我的需求接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void myFinanceDetail() throws Exception {


		MyFinanceDetailRequest request = new MyFinanceDetailRequest();
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[myFinanceDetail] Y我的资料接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/myFinanceDetail");

		LOG.info("[myFinanceDetail] Y我的资料接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void myFriends() throws Exception {


		MyFriendsRequest request = new MyFriendsRequest();
	    request.setCurrentPage("1");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[myFriends] Y我的好友接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/myFriends");

		LOG.info("[myFriends] Y我的好友接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void myLoanInvestor() throws Exception {


		MyLoanInvestorRequest request = new MyLoanInvestorRequest();
	    request.setCurrentPage("1");
	    request.setIsDeal("0");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[myLoanInvestor] 我的预约接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/myLoanInvestor");

		LOG.info("[myLoanInvestor] 我的预约接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void mySolution() throws Exception {


		MySolutionRequest request = new MySolutionRequest();
	    request.setCurrentPage("1");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[mySolution] Y我的方案接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/mySolution");

		LOG.info("[mySolution] Y我的方案接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void operateMyDemand() throws Exception {


		OperateMyDemandRequest request = new OperateMyDemandRequest();
	    request.setId("1");
	    request.setType("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[operateMyDemand] Y删除关闭我的需求接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/operateMyDemand");

		LOG.info("[operateMyDemand] Y删除关闭我的需求接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void operateMyDemandsolution() throws Exception {


		OperateMyDemandsolutionRequest request = new OperateMyDemandsolutionRequest();
	    request.setId("1");
	    request.setType("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[operateMyDemandsolution] Y需求采纳已读方案接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/operateMyDemandsolution");

		LOG.info("[operateMyDemandsolution] Y需求采纳已读方案接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void operateMySolution() throws Exception {


		OperateMySolutionRequest request = new OperateMySolutionRequest();
	    request.setId("1");
	    request.setType("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[operateMySolution] Y删除关闭我的方案接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/operateMySolution");

		LOG.info("[operateMySolution] Y删除关闭我的方案接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void operateMySolutiondemand() throws Exception {


		OperateMySolutiondemandRequest request = new OperateMySolutiondemandRequest();
	    request.setId("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[operateMySolutiondemand] Y方案已读需求接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/operateMySolutiondemand");

		LOG.info("[operateMySolutiondemand] Y方案已读需求接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void realNameAuth() throws Exception {


		RealNameAuthRequest request = new RealNameAuthRequest();
	    request.setIdCard("142429199904282828");
	    request.setRealName("paul");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[realNameAuth] Y实名认证接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/realNameAuth");

		LOG.info("[realNameAuth] Y实名认证接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void registerJg() throws Exception {


		RegisterJgRequest request = new RegisterJgRequest();
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[registerJg] Y注册极光接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/registerJg");

		LOG.info("[registerJg] Y注册极光接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void selectFinance() throws Exception {


		SelectFinanceRequest request = new SelectFinanceRequest();
	    request.setCurrentPage("1");
	    request.setOrder("1");
	    request.setPageSize("10");
	    request.setType("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[selectFinance] 发现投顾接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/selectFinance");

		LOG.info("[selectFinance] 发现投顾接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void servicePersonRecord() throws Exception {


		ServicePersonRecordRequest request = new ServicePersonRecordRequest();
	    request.setCurrentPage("1");
	    request.setFinanceUserid("1");
	    request.setPageSize("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[servicePersonRecord] Y理财师服务点咨询和预约客户接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/servicePersonRecord");

		LOG.info("[servicePersonRecord] Y理财师服务点咨询和预约客户接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void singleDemandSolutionList() throws Exception {


		SingleDemandSolutionListRequest request = new SingleDemandSolutionListRequest();
	    request.setCurrentPage("1");
	    request.setDemandId("10");
	    request.setType("0");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[singleDemandSolutionList] 需求所匹配的方案列表接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/singleDemandSolutionList");

		LOG.info("[singleDemandSolutionList] 需求所匹配的方案列表接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void singleSolutionDemandList() throws Exception {


		SingleSolutionDemandListRequest request = new SingleSolutionDemandListRequest();
	    request.setCurrentPage("1");
	    request.setSolutionId("10");
	    request.setType("0");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[singleSolutionDemandList] 方案所匹配的需求列表接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/singleSolutionDemandList");

		LOG.info("[singleSolutionDemandList] 方案所匹配的需求列表接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void solutionDetail() throws Exception {


		SolutionDetailRequest request = new SolutionDetailRequest();
	    request.setSolutionId("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[solutionDetail] 方案详情接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/solutionDetail");

		LOG.info("[solutionDetail] 方案详情接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void updateFinanceDetail() throws Exception {


		UpdateFinanceDetailRequest request = new UpdateFinanceDetailRequest();
	    request.setEducationLevel("10");
	    request.setPersonalProfile("11");
	    request.setPosition("10");
	    request.setSchoolName("1");
	    request.setServiceConcept("1");
	    request.setServiceDirection("1");
	    request.setWorkAge("1");
	    request.setWorkingExperience("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[updateFinanceDetail] Y更新我的资料接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/updateFinanceDetail");

		LOG.info("[updateFinanceDetail] Y更新我的资料接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void updateMyDemand() throws Exception {


		UpdateMyDemandRequest request = new UpdateMyDemandRequest();
	    request.setAdditionalRemarks("哈哈");
	    request.setId("1");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[updateMyDemand] Y更新我的需求接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/updateMyDemand");

		LOG.info("[updateMyDemand] Y更新我的需求接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void updateMyNikeName() throws Exception {


		UpdateMyNikeNameRequest request = new UpdateMyNikeNameRequest();
	    request.setNikeName("10");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[updateMyNikeName] Y更新我的昵称接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/updateMyNikeName");

		LOG.info("[updateMyNikeName] Y更新我的昵称接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}

	
	@Test
	public void updateMySolution() throws Exception {


		UpdateMySolutionRequest request = new UpdateMySolutionRequest();
	    request.setId("1");
	    request.setSolution("哈哈");
		request.setChannelId("");
		request.setDeviceId("aa-bb-cc");
		request.setPlatformType("5");
		request.setVersionCode("101");
		request.setMsgtimestamp(new Timestamp(System.currentTimeMillis()).toString());
		request.setSessionId("");

		LOG.info("[updateMySolution] Y更新我的方案接口请求数据:{}", request);
		String content = JSONObject.toJSONString(request);

		Response<MobileMessage> response = post(MobileMessage.class, content, "/app/updateMySolution");

		LOG.info("[updateMySolution] Y更新我的方案接口响应数据:{}:", response);

		if (response.getHeader().getCode().equals(RetCode.SUCCESS.getCode())){
			if ("test".equals(response.getBody().getMode())) {
				LOG.error("[appVersionUpdate] 检查版本更新接口未实现", "检查版本更新");
				return;
			}
		} else {
			Assert.fail();
		}
	}


	@Test
	public void generateJwt(){

		// 返回jwt token
		UserSession session = new UserSession();
		session.setId(1L);
		session.setRoleNames(Lists.newArrayList("ADMIN"));
		session.setMobile("130151781002");
		session.setLoginName("admin");
		session.setDisabled(false);

		sessionId = jwtTokenUtil.generate(session);
		LOG.info(sessionId);
	}


	private <T extends MobileMessage> Response<T> post(Class<T> responseType, String content, String urlTemplate) throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(urlTemplate).content(content).contentType(MediaType.APPLICATION_JSON)).andReturn();

		Response<T>  response = JSONObject.parseObject(result.getResponse().getContentAsString(), new TypeReference<Response<T>>(){});

		return response;
	}



}