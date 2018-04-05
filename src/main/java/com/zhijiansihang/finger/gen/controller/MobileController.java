package com.zhijiansihang.finger.gen.controller;

import com.zhijiansihang.common.*;
import com.zhijiansihang.finger.gen.entity.*;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.finger.mmc.MobileMessage;
import com.zhijiansihang.finger.mmc.MobileService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/app")
@Controller("MobileController")
public class MobileController {

	private static final Logger LOG = LoggerFactory.getLogger(MobileController.class);

	@Value("${redis.expire.timestamp.nonce:3}")
	public String redisExpireTimestampNonce;

	@Autowired
	private MobileService mobileService;

	@Autowired
	private RedisTemplate redisTemplate;

	private ObjectMapper objectMapper = new ObjectMapper();

	
	@Qualifier("addSolutionService")
	@Autowired(required = false)
	MessageService<AddSolutionRequest, Response<AddSolutionResponse>> addSolutionService;
	@Qualifier("genaddSolutionService")
	@Autowired(required = false)
	MessageService<AddSolutionRequest, Response<AddSolutionResponse>> genAddSolutionService;

	@Qualifier("consultingRecordService")
	@Autowired(required = false)
	MessageService<ConsultingRecordRequest, Response<ConsultingRecordResponse>> consultingRecordService;
	@Qualifier("genconsultingRecordService")
	@Autowired(required = false)
	MessageService<ConsultingRecordRequest, Response<ConsultingRecordResponse>> genConsultingRecordService;

	@Qualifier("createMyDemandService")
	@Autowired(required = false)
	MessageService<CreateMyDemandRequest, Response<CreateMyDemandResponse>> createMyDemandService;
	@Qualifier("gencreateMyDemandService")
	@Autowired(required = false)
	MessageService<CreateMyDemandRequest, Response<CreateMyDemandResponse>> genCreateMyDemandService;

	@Qualifier("createMySolutionService")
	@Autowired(required = false)
	MessageService<CreateMySolutionRequest, Response<CreateMySolutionResponse>> createMySolutionService;
	@Qualifier("gencreateMySolutionService")
	@Autowired(required = false)
	MessageService<CreateMySolutionRequest, Response<CreateMySolutionResponse>> genCreateMySolutionService;

	@Qualifier("demandDetailService")
	@Autowired(required = false)
	MessageService<DemandDetailRequest, Response<DemandDetailResponse>> demandDetailService;
	@Qualifier("gendemandDetailService")
	@Autowired(required = false)
	MessageService<DemandDetailRequest, Response<DemandDetailResponse>> genDemandDetailService;

	@Qualifier("financeDetailService")
	@Autowired(required = false)
	MessageService<FinanceDetailRequest, Response<FinanceDetailResponse>> financeDetailService;
	@Qualifier("genfinanceDetailService")
	@Autowired(required = false)
	MessageService<FinanceDetailRequest, Response<FinanceDetailResponse>> genFinanceDetailService;

	@Qualifier("financeLoanInvestorService")
	@Autowired(required = false)
	MessageService<FinanceLoanInvestorRequest, Response<FinanceLoanInvestorResponse>> financeLoanInvestorService;
	@Qualifier("genfinanceLoanInvestorService")
	@Autowired(required = false)
	MessageService<FinanceLoanInvestorRequest, Response<FinanceLoanInvestorResponse>> genFinanceLoanInvestorService;

	@Qualifier("financeLoanRecommendService")
	@Autowired(required = false)
	MessageService<FinanceLoanRecommendRequest, Response<FinanceLoanRecommendResponse>> financeLoanRecommendService;
	@Qualifier("genfinanceLoanRecommendService")
	@Autowired(required = false)
	MessageService<FinanceLoanRecommendRequest, Response<FinanceLoanRecommendResponse>> genFinanceLoanRecommendService;

	@Qualifier("financeOperateLoanInvestorService")
	@Autowired(required = false)
	MessageService<FinanceOperateLoanInvestorRequest, Response<FinanceOperateLoanInvestorResponse>> financeOperateLoanInvestorService;
	@Qualifier("genfinanceOperateLoanInvestorService")
	@Autowired(required = false)
	MessageService<FinanceOperateLoanInvestorRequest, Response<FinanceOperateLoanInvestorResponse>> genFinanceOperateLoanInvestorService;

	@Qualifier("getCmsService")
	@Autowired(required = false)
	MessageService<GetCmsRequest, Response<GetCmsResponse>> getCmsService;
	@Qualifier("gengetCmsService")
	@Autowired(required = false)
	MessageService<GetCmsRequest, Response<GetCmsResponse>> genGetCmsService;

	@Qualifier("getLoanDetailService")
	@Autowired(required = false)
	MessageService<GetLoanDetailRequest, Response<GetLoanDetailResponse>> getLoanDetailService;
	@Qualifier("gengetLoanDetailService")
	@Autowired(required = false)
	MessageService<GetLoanDetailRequest, Response<GetLoanDetailResponse>> genGetLoanDetailService;

	@Qualifier("getLoanFinanceService")
	@Autowired(required = false)
	MessageService<GetLoanFinanceRequest, Response<GetLoanFinanceResponse>> getLoanFinanceService;
	@Qualifier("gengetLoanFinanceService")
	@Autowired(required = false)
	MessageService<GetLoanFinanceRequest, Response<GetLoanFinanceResponse>> genGetLoanFinanceService;

	@Qualifier("getMySolutionTop10Service")
	@Autowired(required = false)
	MessageService<GetMySolutionTop10Request, Response<GetMySolutionTop10Response>> getMySolutionTop10Service;
	@Qualifier("gengetMySolutionTop10Service")
	@Autowired(required = false)
	MessageService<GetMySolutionTop10Request, Response<GetMySolutionTop10Response>> genGetMySolutionTop10Service;

	@Qualifier("getNameAuthAndRiskResultService")
	@Autowired(required = false)
	MessageService<GetNameAuthAndRiskResultRequest, Response<GetNameAuthAndRiskResultResponse>> getNameAuthAndRiskResultService;
	@Qualifier("gengetNameAuthAndRiskResultService")
	@Autowired(required = false)
	MessageService<GetNameAuthAndRiskResultRequest, Response<GetNameAuthAndRiskResultResponse>> genGetNameAuthAndRiskResultService;

	@Qualifier("getPrivateLoanService")
	@Autowired(required = false)
	MessageService<GetPrivateLoanRequest, Response<GetPrivateLoanResponse>> getPrivateLoanService;
	@Qualifier("gengetPrivateLoanService")
	@Autowired(required = false)
	MessageService<GetPrivateLoanRequest, Response<GetPrivateLoanResponse>> genGetPrivateLoanService;

	@Qualifier("getPublicLoanService")
	@Autowired(required = false)
	MessageService<GetPublicLoanRequest, Response<GetPublicLoanResponse>> getPublicLoanService;
	@Qualifier("gengetPublicLoanService")
	@Autowired(required = false)
	MessageService<GetPublicLoanRequest, Response<GetPublicLoanResponse>> genGetPublicLoanService;

	@Qualifier("getSmsService")
	@Autowired(required = false)
	MessageService<GetSmsRequest, Response<GetSmsResponse>> getSmsService;
	@Qualifier("gengetSmsService")
	@Autowired(required = false)
	MessageService<GetSmsRequest, Response<GetSmsResponse>> genGetSmsService;

	@Qualifier("getSolutionTop10Service")
	@Autowired(required = false)
	MessageService<GetSolutionTop10Request, Response<GetSolutionTop10Response>> getSolutionTop10Service;
	@Qualifier("gengetSolutionTop10Service")
	@Autowired(required = false)
	MessageService<GetSolutionTop10Request, Response<GetSolutionTop10Response>> genGetSolutionTop10Service;

	@Qualifier("getUserService")
	@Autowired(required = false)
	MessageService<GetUserRequest, Response<GetUserResponse>> getUserService;
	@Qualifier("gengetUserService")
	@Autowired(required = false)
	MessageService<GetUserRequest, Response<GetUserResponse>> genGetUserService;

	@Qualifier("investService")
	@Autowired(required = false)
	MessageService<InvestRequest, Response<InvestResponse>> investService;
	@Qualifier("geninvestService")
	@Autowired(required = false)
	MessageService<InvestRequest, Response<InvestResponse>> genInvestService;

	@Qualifier("isCollectedService")
	@Autowired(required = false)
	MessageService<IsCollectedRequest, Response<IsCollectedResponse>> isCollectedService;
	@Qualifier("genisCollectedService")
	@Autowired(required = false)
	MessageService<IsCollectedRequest, Response<IsCollectedResponse>> genIsCollectedService;

	@Qualifier("isFriendService")
	@Autowired(required = false)
	MessageService<IsFriendRequest, Response<IsFriendResponse>> isFriendService;
	@Qualifier("genisFriendService")
	@Autowired(required = false)
	MessageService<IsFriendRequest, Response<IsFriendResponse>> genIsFriendService;

	@Qualifier("isHasMatchDemandSolutionService")
	@Autowired(required = false)
	MessageService<IsHasMatchDemandSolutionRequest, Response<IsHasMatchDemandSolutionResponse>> isHasMatchDemandSolutionService;
	@Qualifier("genisHasMatchDemandSolutionService")
	@Autowired(required = false)
	MessageService<IsHasMatchDemandSolutionRequest, Response<IsHasMatchDemandSolutionResponse>> genIsHasMatchDemandSolutionService;

	@Qualifier("loanInvestorDetailService")
	@Autowired(required = false)
	MessageService<LoanInvestorDetailRequest, Response<LoanInvestorDetailResponse>> loanInvestorDetailService;
	@Qualifier("genloanInvestorDetailService")
	@Autowired(required = false)
	MessageService<LoanInvestorDetailRequest, Response<LoanInvestorDetailResponse>> genLoanInvestorDetailService;

	@Qualifier("loginOrRegisterService")
	@Autowired(required = false)
	MessageService<LoginOrRegisterRequest, Response<LoginOrRegisterResponse>> loginOrRegisterService;
	@Qualifier("genloginOrRegisterService")
	@Autowired(required = false)
	MessageService<LoginOrRegisterRequest, Response<LoginOrRegisterResponse>> genLoginOrRegisterService;

	@Qualifier("makeFriendService")
	@Autowired(required = false)
	MessageService<MakeFriendRequest, Response<MakeFriendResponse>> makeFriendService;
	@Qualifier("genmakeFriendService")
	@Autowired(required = false)
	MessageService<MakeFriendRequest, Response<MakeFriendResponse>> genMakeFriendService;

	@Qualifier("myCollectionLoanService")
	@Autowired(required = false)
	MessageService<MyCollectionLoanRequest, Response<MyCollectionLoanResponse>> myCollectionLoanService;
	@Qualifier("genmyCollectionLoanService")
	@Autowired(required = false)
	MessageService<MyCollectionLoanRequest, Response<MyCollectionLoanResponse>> genMyCollectionLoanService;

	@Qualifier("myCollectionPersonService")
	@Autowired(required = false)
	MessageService<MyCollectionPersonRequest, Response<MyCollectionPersonResponse>> myCollectionPersonService;
	@Qualifier("genmyCollectionPersonService")
	@Autowired(required = false)
	MessageService<MyCollectionPersonRequest, Response<MyCollectionPersonResponse>> genMyCollectionPersonService;

	@Qualifier("myDemandService")
	@Autowired(required = false)
	MessageService<MyDemandRequest, Response<MyDemandResponse>> myDemandService;
	@Qualifier("genmyDemandService")
	@Autowired(required = false)
	MessageService<MyDemandRequest, Response<MyDemandResponse>> genMyDemandService;

	@Qualifier("myFinanceDetailService")
	@Autowired(required = false)
	MessageService<MyFinanceDetailRequest, Response<MyFinanceDetailResponse>> myFinanceDetailService;
	@Qualifier("genmyFinanceDetailService")
	@Autowired(required = false)
	MessageService<MyFinanceDetailRequest, Response<MyFinanceDetailResponse>> genMyFinanceDetailService;

	@Qualifier("myFriendsService")
	@Autowired(required = false)
	MessageService<MyFriendsRequest, Response<MyFriendsResponse>> myFriendsService;
	@Qualifier("genmyFriendsService")
	@Autowired(required = false)
	MessageService<MyFriendsRequest, Response<MyFriendsResponse>> genMyFriendsService;

	@Qualifier("myLoanInvestorService")
	@Autowired(required = false)
	MessageService<MyLoanInvestorRequest, Response<MyLoanInvestorResponse>> myLoanInvestorService;
	@Qualifier("genmyLoanInvestorService")
	@Autowired(required = false)
	MessageService<MyLoanInvestorRequest, Response<MyLoanInvestorResponse>> genMyLoanInvestorService;

	@Qualifier("mySolutionService")
	@Autowired(required = false)
	MessageService<MySolutionRequest, Response<MySolutionResponse>> mySolutionService;
	@Qualifier("genmySolutionService")
	@Autowired(required = false)
	MessageService<MySolutionRequest, Response<MySolutionResponse>> genMySolutionService;

	@Qualifier("operateMyDemandService")
	@Autowired(required = false)
	MessageService<OperateMyDemandRequest, Response<OperateMyDemandResponse>> operateMyDemandService;
	@Qualifier("genoperateMyDemandService")
	@Autowired(required = false)
	MessageService<OperateMyDemandRequest, Response<OperateMyDemandResponse>> genOperateMyDemandService;

	@Qualifier("operateMyDemandsolutionService")
	@Autowired(required = false)
	MessageService<OperateMyDemandsolutionRequest, Response<OperateMyDemandsolutionResponse>> operateMyDemandsolutionService;
	@Qualifier("genoperateMyDemandsolutionService")
	@Autowired(required = false)
	MessageService<OperateMyDemandsolutionRequest, Response<OperateMyDemandsolutionResponse>> genOperateMyDemandsolutionService;

	@Qualifier("operateMySolutionService")
	@Autowired(required = false)
	MessageService<OperateMySolutionRequest, Response<OperateMySolutionResponse>> operateMySolutionService;
	@Qualifier("genoperateMySolutionService")
	@Autowired(required = false)
	MessageService<OperateMySolutionRequest, Response<OperateMySolutionResponse>> genOperateMySolutionService;

	@Qualifier("operateMySolutiondemandService")
	@Autowired(required = false)
	MessageService<OperateMySolutiondemandRequest, Response<OperateMySolutiondemandResponse>> operateMySolutiondemandService;
	@Qualifier("genoperateMySolutiondemandService")
	@Autowired(required = false)
	MessageService<OperateMySolutiondemandRequest, Response<OperateMySolutiondemandResponse>> genOperateMySolutiondemandService;

	@Qualifier("realNameAuthService")
	@Autowired(required = false)
	MessageService<RealNameAuthRequest, Response<RealNameAuthResponse>> realNameAuthService;
	@Qualifier("genrealNameAuthService")
	@Autowired(required = false)
	MessageService<RealNameAuthRequest, Response<RealNameAuthResponse>> genRealNameAuthService;

	@Qualifier("registerJgService")
	@Autowired(required = false)
	MessageService<RegisterJgRequest, Response<RegisterJgResponse>> registerJgService;
	@Qualifier("genregisterJgService")
	@Autowired(required = false)
	MessageService<RegisterJgRequest, Response<RegisterJgResponse>> genRegisterJgService;

	@Qualifier("riskAssessmentResultGetService")
	@Autowired(required = false)
	MessageService<RiskAssessmentResultGetRequest, Response<RiskAssessmentResultGetResponse>> riskAssessmentResultGetService;
	@Qualifier("genriskAssessmentResultGetService")
	@Autowired(required = false)
	MessageService<RiskAssessmentResultGetRequest, Response<RiskAssessmentResultGetResponse>> genRiskAssessmentResultGetService;

	@Qualifier("riskAssessmentResultPostService")
	@Autowired(required = false)
	MessageService<RiskAssessmentResultPostRequest, Response<RiskAssessmentResultPostResponse>> riskAssessmentResultPostService;
	@Qualifier("genriskAssessmentResultPostService")
	@Autowired(required = false)
	MessageService<RiskAssessmentResultPostRequest, Response<RiskAssessmentResultPostResponse>> genRiskAssessmentResultPostService;

	@Qualifier("selectFinanceService")
	@Autowired(required = false)
	MessageService<SelectFinanceRequest, Response<SelectFinanceResponse>> selectFinanceService;
	@Qualifier("genselectFinanceService")
	@Autowired(required = false)
	MessageService<SelectFinanceRequest, Response<SelectFinanceResponse>> genSelectFinanceService;

	@Qualifier("servicePersonRecordService")
	@Autowired(required = false)
	MessageService<ServicePersonRecordRequest, Response<ServicePersonRecordResponse>> servicePersonRecordService;
	@Qualifier("genservicePersonRecordService")
	@Autowired(required = false)
	MessageService<ServicePersonRecordRequest, Response<ServicePersonRecordResponse>> genServicePersonRecordService;

	@Qualifier("singleDemandSolutionListService")
	@Autowired(required = false)
	MessageService<SingleDemandSolutionListRequest, Response<SingleDemandSolutionListResponse>> singleDemandSolutionListService;
	@Qualifier("gensingleDemandSolutionListService")
	@Autowired(required = false)
	MessageService<SingleDemandSolutionListRequest, Response<SingleDemandSolutionListResponse>> genSingleDemandSolutionListService;

	@Qualifier("singleSolutionDemandListService")
	@Autowired(required = false)
	MessageService<SingleSolutionDemandListRequest, Response<SingleSolutionDemandListResponse>> singleSolutionDemandListService;
	@Qualifier("gensingleSolutionDemandListService")
	@Autowired(required = false)
	MessageService<SingleSolutionDemandListRequest, Response<SingleSolutionDemandListResponse>> genSingleSolutionDemandListService;

	@Qualifier("solutionDetailService")
	@Autowired(required = false)
	MessageService<SolutionDetailRequest, Response<SolutionDetailResponse>> solutionDetailService;
	@Qualifier("gensolutionDetailService")
	@Autowired(required = false)
	MessageService<SolutionDetailRequest, Response<SolutionDetailResponse>> genSolutionDetailService;

	@Qualifier("updateFinanceDetailService")
	@Autowired(required = false)
	MessageService<UpdateFinanceDetailRequest, Response<UpdateFinanceDetailResponse>> updateFinanceDetailService;
	@Qualifier("genupdateFinanceDetailService")
	@Autowired(required = false)
	MessageService<UpdateFinanceDetailRequest, Response<UpdateFinanceDetailResponse>> genUpdateFinanceDetailService;

	@Qualifier("updateMyDemandService")
	@Autowired(required = false)
	MessageService<UpdateMyDemandRequest, Response<UpdateMyDemandResponse>> updateMyDemandService;
	@Qualifier("genupdateMyDemandService")
	@Autowired(required = false)
	MessageService<UpdateMyDemandRequest, Response<UpdateMyDemandResponse>> genUpdateMyDemandService;

	@Qualifier("updateMyNikeNameService")
	@Autowired(required = false)
	MessageService<UpdateMyNikeNameRequest, Response<UpdateMyNikeNameResponse>> updateMyNikeNameService;
	@Qualifier("genupdateMyNikeNameService")
	@Autowired(required = false)
	MessageService<UpdateMyNikeNameRequest, Response<UpdateMyNikeNameResponse>> genUpdateMyNikeNameService;

	@Qualifier("updateMySolutionService")
	@Autowired(required = false)
	MessageService<UpdateMySolutionRequest, Response<UpdateMySolutionResponse>> updateMySolutionService;
	@Qualifier("genupdateMySolutionService")
	@Autowired(required = false)
	MessageService<UpdateMySolutionRequest, Response<UpdateMySolutionResponse>> genUpdateMySolutionService;




	@RequestMapping(value = "/addSolution", method = RequestMethod.POST)
	@ResponseBody
	public Response<AddSolutionResponse> addSolution(@RequestBody AddSolutionRequest request) {

		logRequest("addSolution", request);

  		Response<AddSolutionResponse> response = new Response<>();

		request = (AddSolutionRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getAddSolutionResponse(request);
		
		logResponse("addSolution", response);

		return response;
	}

	@RequestMapping(value = "/consultingRecord", method = RequestMethod.POST)
	@ResponseBody
	public Response<ConsultingRecordResponse> consultingRecord(@RequestBody ConsultingRecordRequest request) {

		logRequest("consultingRecord", request);

  		Response<ConsultingRecordResponse> response = new Response<>();

		request = (ConsultingRecordRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getConsultingRecordResponse(request);
		
		logResponse("consultingRecord", response);

		return response;
	}

	@RequestMapping(value = "/createMyDemand", method = RequestMethod.POST)
	@ResponseBody
	public Response<CreateMyDemandResponse> createMyDemand(@RequestBody CreateMyDemandRequest request) {

		logRequest("createMyDemand", request);

  		Response<CreateMyDemandResponse> response = new Response<>();

		request = (CreateMyDemandRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getCreateMyDemandResponse(request);
		
		logResponse("createMyDemand", response);

		return response;
	}

	@RequestMapping(value = "/createMySolution", method = RequestMethod.POST)
	@ResponseBody
	public Response<CreateMySolutionResponse> createMySolution(@RequestBody CreateMySolutionRequest request) {

		logRequest("createMySolution", request);

  		Response<CreateMySolutionResponse> response = new Response<>();

		request = (CreateMySolutionRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getCreateMySolutionResponse(request);
		
		logResponse("createMySolution", response);

		return response;
	}

	@RequestMapping(value = "/demandDetail", method = RequestMethod.POST)
	@ResponseBody
	public Response<DemandDetailResponse> demandDetail(@RequestBody DemandDetailRequest request) {

		logRequest("demandDetail", request);

  		Response<DemandDetailResponse> response = new Response<>();

		request = (DemandDetailRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getDemandDetailResponse(request);
		
		logResponse("demandDetail", response);

		return response;
	}

	@RequestMapping(value = "/financeDetail", method = RequestMethod.POST)
	@ResponseBody
	public Response<FinanceDetailResponse> financeDetail(@RequestBody FinanceDetailRequest request) {

		logRequest("financeDetail", request);

  		Response<FinanceDetailResponse> response = new Response<>();

		request = (FinanceDetailRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getFinanceDetailResponse(request);
		
		logResponse("financeDetail", response);

		return response;
	}

	@RequestMapping(value = "/financeLoanInvestor", method = RequestMethod.POST)
	@ResponseBody
	public Response<FinanceLoanInvestorResponse> financeLoanInvestor(@RequestBody FinanceLoanInvestorRequest request) {

		logRequest("financeLoanInvestor", request);

  		Response<FinanceLoanInvestorResponse> response = new Response<>();

		request = (FinanceLoanInvestorRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getFinanceLoanInvestorResponse(request);
		
		logResponse("financeLoanInvestor", response);

		return response;
	}

	@RequestMapping(value = "/financeLoanRecommend", method = RequestMethod.POST)
	@ResponseBody
	public Response<FinanceLoanRecommendResponse> financeLoanRecommend(@RequestBody FinanceLoanRecommendRequest request) {

		logRequest("financeLoanRecommend", request);

  		Response<FinanceLoanRecommendResponse> response = new Response<>();

		request = (FinanceLoanRecommendRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getFinanceLoanRecommendResponse(request);
		
		logResponse("financeLoanRecommend", response);

		return response;
	}

	@RequestMapping(value = "/financeOperateLoanInvestor", method = RequestMethod.POST)
	@ResponseBody
	public Response<FinanceOperateLoanInvestorResponse> financeOperateLoanInvestor(@RequestBody FinanceOperateLoanInvestorRequest request) {

		logRequest("financeOperateLoanInvestor", request);

  		Response<FinanceOperateLoanInvestorResponse> response = new Response<>();

		request = (FinanceOperateLoanInvestorRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getFinanceOperateLoanInvestorResponse(request);
		
		logResponse("financeOperateLoanInvestor", response);

		return response;
	}

	@RequestMapping(value = "/getCms", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetCmsResponse> getCms(@RequestBody GetCmsRequest request) {

		logRequest("getCms", request);

  		Response<GetCmsResponse> response = new Response<>();

		request = (GetCmsRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetCmsResponse(request);
		
		logResponse("getCms", response);

		return response;
	}

	@RequestMapping(value = "/getLoanDetail", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetLoanDetailResponse> getLoanDetail(@RequestBody GetLoanDetailRequest request) {

		logRequest("getLoanDetail", request);

  		Response<GetLoanDetailResponse> response = new Response<>();

		request = (GetLoanDetailRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetLoanDetailResponse(request);
		
		logResponse("getLoanDetail", response);

		return response;
	}

	@RequestMapping(value = "/getLoanFinance", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetLoanFinanceResponse> getLoanFinance(@RequestBody GetLoanFinanceRequest request) {

		logRequest("getLoanFinance", request);

  		Response<GetLoanFinanceResponse> response = new Response<>();

		request = (GetLoanFinanceRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetLoanFinanceResponse(request);
		
		logResponse("getLoanFinance", response);

		return response;
	}

	@RequestMapping(value = "/getMySolutionTop10", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetMySolutionTop10Response> getMySolutionTop10(@RequestBody GetMySolutionTop10Request request) {

		logRequest("getMySolutionTop10", request);

  		Response<GetMySolutionTop10Response> response = new Response<>();

		request = (GetMySolutionTop10Request) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetMySolutionTop10Response(request);
		
		logResponse("getMySolutionTop10", response);

		return response;
	}

	@RequestMapping(value = "/getNameAuthAndRiskResult", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetNameAuthAndRiskResultResponse> getNameAuthAndRiskResult(@RequestBody GetNameAuthAndRiskResultRequest request) {

		logRequest("getNameAuthAndRiskResult", request);

  		Response<GetNameAuthAndRiskResultResponse> response = new Response<>();

		request = (GetNameAuthAndRiskResultRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetNameAuthAndRiskResultResponse(request);
		
		logResponse("getNameAuthAndRiskResult", response);

		return response;
	}

	@RequestMapping(value = "/getPrivateLoan", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetPrivateLoanResponse> getPrivateLoan(@RequestBody GetPrivateLoanRequest request) {

		logRequest("getPrivateLoan", request);

  		Response<GetPrivateLoanResponse> response = new Response<>();

		request = (GetPrivateLoanRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetPrivateLoanResponse(request);
		
		logResponse("getPrivateLoan", response);

		return response;
	}

	@RequestMapping(value = "/getPublicLoan", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetPublicLoanResponse> getPublicLoan(@RequestBody GetPublicLoanRequest request) {

		logRequest("getPublicLoan", request);

  		Response<GetPublicLoanResponse> response = new Response<>();

		request = (GetPublicLoanRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetPublicLoanResponse(request);
		
		logResponse("getPublicLoan", response);

		return response;
	}

	@RequestMapping(value = "/getSms", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetSmsResponse> getSms(@RequestBody GetSmsRequest request) {

		logRequest("getSms", request);

  		Response<GetSmsResponse> response = new Response<>();

		request = (GetSmsRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetSmsResponse(request);
		
		logResponse("getSms", response);

		return response;
	}

	@RequestMapping(value = "/getSolutionTop10", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetSolutionTop10Response> getSolutionTop10(@RequestBody GetSolutionTop10Request request) {

		logRequest("getSolutionTop10", request);

  		Response<GetSolutionTop10Response> response = new Response<>();

		request = (GetSolutionTop10Request) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetSolutionTop10Response(request);
		
		logResponse("getSolutionTop10", response);

		return response;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	@ResponseBody
	public Response<GetUserResponse> getUser(@RequestBody GetUserRequest request) {

		logRequest("getUser", request);

  		Response<GetUserResponse> response = new Response<>();

		request = (GetUserRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getGetUserResponse(request);
		
		logResponse("getUser", response);

		return response;
	}

	@RequestMapping(value = "/invest", method = RequestMethod.POST)
	@ResponseBody
	public Response<InvestResponse> invest(@RequestBody InvestRequest request) {

		logRequest("invest", request);

  		Response<InvestResponse> response = new Response<>();

		request = (InvestRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getInvestResponse(request);
		
		logResponse("invest", response);

		return response;
	}

	@RequestMapping(value = "/isCollected", method = RequestMethod.POST)
	@ResponseBody
	public Response<IsCollectedResponse> isCollected(@RequestBody IsCollectedRequest request) {

		logRequest("isCollected", request);

  		Response<IsCollectedResponse> response = new Response<>();

		request = (IsCollectedRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getIsCollectedResponse(request);
		
		logResponse("isCollected", response);

		return response;
	}

	@RequestMapping(value = "/isFriend", method = RequestMethod.POST)
	@ResponseBody
	public Response<IsFriendResponse> isFriend(@RequestBody IsFriendRequest request) {

		logRequest("isFriend", request);

  		Response<IsFriendResponse> response = new Response<>();

		request = (IsFriendRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getIsFriendResponse(request);
		
		logResponse("isFriend", response);

		return response;
	}

	@RequestMapping(value = "/isHasMatchDemandSolution", method = RequestMethod.POST)
	@ResponseBody
	public Response<IsHasMatchDemandSolutionResponse> isHasMatchDemandSolution(@RequestBody IsHasMatchDemandSolutionRequest request) {

		logRequest("isHasMatchDemandSolution", request);

  		Response<IsHasMatchDemandSolutionResponse> response = new Response<>();

		request = (IsHasMatchDemandSolutionRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getIsHasMatchDemandSolutionResponse(request);
		
		logResponse("isHasMatchDemandSolution", response);

		return response;
	}

	@RequestMapping(value = "/loanInvestorDetail", method = RequestMethod.POST)
	@ResponseBody
	public Response<LoanInvestorDetailResponse> loanInvestorDetail(@RequestBody LoanInvestorDetailRequest request) {

		logRequest("loanInvestorDetail", request);

  		Response<LoanInvestorDetailResponse> response = new Response<>();

		request = (LoanInvestorDetailRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getLoanInvestorDetailResponse(request);
		
		logResponse("loanInvestorDetail", response);

		return response;
	}

	@RequestMapping(value = "/loginOrRegister", method = RequestMethod.POST)
	@ResponseBody
	public Response<LoginOrRegisterResponse> loginOrRegister(@RequestBody LoginOrRegisterRequest request) {

		logRequest("loginOrRegister", request);

  		Response<LoginOrRegisterResponse> response = new Response<>();

		request = (LoginOrRegisterRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getLoginOrRegisterResponse(request);
		
		logResponse("loginOrRegister", response);

		return response;
	}

	@RequestMapping(value = "/makeFriend", method = RequestMethod.POST)
	@ResponseBody
	public Response<MakeFriendResponse> makeFriend(@RequestBody MakeFriendRequest request) {

		logRequest("makeFriend", request);

  		Response<MakeFriendResponse> response = new Response<>();

		request = (MakeFriendRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMakeFriendResponse(request);
		
		logResponse("makeFriend", response);

		return response;
	}

	@RequestMapping(value = "/myCollectionLoan", method = RequestMethod.POST)
	@ResponseBody
	public Response<MyCollectionLoanResponse> myCollectionLoan(@RequestBody MyCollectionLoanRequest request) {

		logRequest("myCollectionLoan", request);

  		Response<MyCollectionLoanResponse> response = new Response<>();

		request = (MyCollectionLoanRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMyCollectionLoanResponse(request);
		
		logResponse("myCollectionLoan", response);

		return response;
	}

	@RequestMapping(value = "/myCollectionPerson", method = RequestMethod.POST)
	@ResponseBody
	public Response<MyCollectionPersonResponse> myCollectionPerson(@RequestBody MyCollectionPersonRequest request) {

		logRequest("myCollectionPerson", request);

  		Response<MyCollectionPersonResponse> response = new Response<>();

		request = (MyCollectionPersonRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMyCollectionPersonResponse(request);
		
		logResponse("myCollectionPerson", response);

		return response;
	}

	@RequestMapping(value = "/myDemand", method = RequestMethod.POST)
	@ResponseBody
	public Response<MyDemandResponse> myDemand(@RequestBody MyDemandRequest request) {

		logRequest("myDemand", request);

  		Response<MyDemandResponse> response = new Response<>();

		request = (MyDemandRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMyDemandResponse(request);
		
		logResponse("myDemand", response);

		return response;
	}

	@RequestMapping(value = "/myFinanceDetail", method = RequestMethod.POST)
	@ResponseBody
	public Response<MyFinanceDetailResponse> myFinanceDetail(@RequestBody MyFinanceDetailRequest request) {

		logRequest("myFinanceDetail", request);

  		Response<MyFinanceDetailResponse> response = new Response<>();

		request = (MyFinanceDetailRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMyFinanceDetailResponse(request);
		
		logResponse("myFinanceDetail", response);

		return response;
	}

	@RequestMapping(value = "/myFriends", method = RequestMethod.POST)
	@ResponseBody
	public Response<MyFriendsResponse> myFriends(@RequestBody MyFriendsRequest request) {

		logRequest("myFriends", request);

  		Response<MyFriendsResponse> response = new Response<>();

		request = (MyFriendsRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMyFriendsResponse(request);
		
		logResponse("myFriends", response);

		return response;
	}

	@RequestMapping(value = "/myLoanInvestor", method = RequestMethod.POST)
	@ResponseBody
	public Response<MyLoanInvestorResponse> myLoanInvestor(@RequestBody MyLoanInvestorRequest request) {

		logRequest("myLoanInvestor", request);

  		Response<MyLoanInvestorResponse> response = new Response<>();

		request = (MyLoanInvestorRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMyLoanInvestorResponse(request);
		
		logResponse("myLoanInvestor", response);

		return response;
	}

	@RequestMapping(value = "/mySolution", method = RequestMethod.POST)
	@ResponseBody
	public Response<MySolutionResponse> mySolution(@RequestBody MySolutionRequest request) {

		logRequest("mySolution", request);

  		Response<MySolutionResponse> response = new Response<>();

		request = (MySolutionRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getMySolutionResponse(request);
		
		logResponse("mySolution", response);

		return response;
	}

	@RequestMapping(value = "/operateMyDemand", method = RequestMethod.POST)
	@ResponseBody
	public Response<OperateMyDemandResponse> operateMyDemand(@RequestBody OperateMyDemandRequest request) {

		logRequest("operateMyDemand", request);

  		Response<OperateMyDemandResponse> response = new Response<>();

		request = (OperateMyDemandRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getOperateMyDemandResponse(request);
		
		logResponse("operateMyDemand", response);

		return response;
	}

	@RequestMapping(value = "/operateMyDemandsolution", method = RequestMethod.POST)
	@ResponseBody
	public Response<OperateMyDemandsolutionResponse> operateMyDemandsolution(@RequestBody OperateMyDemandsolutionRequest request) {

		logRequest("operateMyDemandsolution", request);

  		Response<OperateMyDemandsolutionResponse> response = new Response<>();

		request = (OperateMyDemandsolutionRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getOperateMyDemandsolutionResponse(request);
		
		logResponse("operateMyDemandsolution", response);

		return response;
	}

	@RequestMapping(value = "/operateMySolution", method = RequestMethod.POST)
	@ResponseBody
	public Response<OperateMySolutionResponse> operateMySolution(@RequestBody OperateMySolutionRequest request) {

		logRequest("operateMySolution", request);

  		Response<OperateMySolutionResponse> response = new Response<>();

		request = (OperateMySolutionRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getOperateMySolutionResponse(request);
		
		logResponse("operateMySolution", response);

		return response;
	}

	@RequestMapping(value = "/operateMySolutiondemand", method = RequestMethod.POST)
	@ResponseBody
	public Response<OperateMySolutiondemandResponse> operateMySolutiondemand(@RequestBody OperateMySolutiondemandRequest request) {

		logRequest("operateMySolutiondemand", request);

  		Response<OperateMySolutiondemandResponse> response = new Response<>();

		request = (OperateMySolutiondemandRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getOperateMySolutiondemandResponse(request);
		
		logResponse("operateMySolutiondemand", response);

		return response;
	}

	@RequestMapping(value = "/realNameAuth", method = RequestMethod.POST)
	@ResponseBody
	public Response<RealNameAuthResponse> realNameAuth(@RequestBody RealNameAuthRequest request) {

		logRequest("realNameAuth", request);

  		Response<RealNameAuthResponse> response = new Response<>();

		request = (RealNameAuthRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getRealNameAuthResponse(request);
		
		logResponse("realNameAuth", response);

		return response;
	}

	@RequestMapping(value = "/registerJg", method = RequestMethod.POST)
	@ResponseBody
	public Response<RegisterJgResponse> registerJg(@RequestBody RegisterJgRequest request) {

		logRequest("registerJg", request);

  		Response<RegisterJgResponse> response = new Response<>();

		request = (RegisterJgRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getRegisterJgResponse(request);
		
		logResponse("registerJg", response);

		return response;
	}

	@RequestMapping(value = "/riskAssessmentResultGet", method = RequestMethod.POST)
	@ResponseBody
	public Response<RiskAssessmentResultGetResponse> riskAssessmentResultGet(@RequestBody RiskAssessmentResultGetRequest request) {

		logRequest("riskAssessmentResultGet", request);

  		Response<RiskAssessmentResultGetResponse> response = new Response<>();

		request = (RiskAssessmentResultGetRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getRiskAssessmentResultGetResponse(request);
		
		logResponse("riskAssessmentResultGet", response);

		return response;
	}

	@RequestMapping(value = "/riskAssessmentResultPost", method = RequestMethod.POST)
	@ResponseBody
	public Response<RiskAssessmentResultPostResponse> riskAssessmentResultPost(@RequestBody RiskAssessmentResultPostRequest request) {

		logRequest("riskAssessmentResultPost", request);

  		Response<RiskAssessmentResultPostResponse> response = new Response<>();

		request = (RiskAssessmentResultPostRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getRiskAssessmentResultPostResponse(request);
		
		logResponse("riskAssessmentResultPost", response);

		return response;
	}

	@RequestMapping(value = "/selectFinance", method = RequestMethod.POST)
	@ResponseBody
	public Response<SelectFinanceResponse> selectFinance(@RequestBody SelectFinanceRequest request) {

		logRequest("selectFinance", request);

  		Response<SelectFinanceResponse> response = new Response<>();

		request = (SelectFinanceRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getSelectFinanceResponse(request);
		
		logResponse("selectFinance", response);

		return response;
	}

	@RequestMapping(value = "/servicePersonRecord", method = RequestMethod.POST)
	@ResponseBody
	public Response<ServicePersonRecordResponse> servicePersonRecord(@RequestBody ServicePersonRecordRequest request) {

		logRequest("servicePersonRecord", request);

  		Response<ServicePersonRecordResponse> response = new Response<>();

		request = (ServicePersonRecordRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getServicePersonRecordResponse(request);
		
		logResponse("servicePersonRecord", response);

		return response;
	}

	@RequestMapping(value = "/singleDemandSolutionList", method = RequestMethod.POST)
	@ResponseBody
	public Response<SingleDemandSolutionListResponse> singleDemandSolutionList(@RequestBody SingleDemandSolutionListRequest request) {

		logRequest("singleDemandSolutionList", request);

  		Response<SingleDemandSolutionListResponse> response = new Response<>();

		request = (SingleDemandSolutionListRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getSingleDemandSolutionListResponse(request);
		
		logResponse("singleDemandSolutionList", response);

		return response;
	}

	@RequestMapping(value = "/singleSolutionDemandList", method = RequestMethod.POST)
	@ResponseBody
	public Response<SingleSolutionDemandListResponse> singleSolutionDemandList(@RequestBody SingleSolutionDemandListRequest request) {

		logRequest("singleSolutionDemandList", request);

  		Response<SingleSolutionDemandListResponse> response = new Response<>();

		request = (SingleSolutionDemandListRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getSingleSolutionDemandListResponse(request);
		
		logResponse("singleSolutionDemandList", response);

		return response;
	}

	@RequestMapping(value = "/solutionDetail", method = RequestMethod.POST)
	@ResponseBody
	public Response<SolutionDetailResponse> solutionDetail(@RequestBody SolutionDetailRequest request) {

		logRequest("solutionDetail", request);

  		Response<SolutionDetailResponse> response = new Response<>();

		request = (SolutionDetailRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getSolutionDetailResponse(request);
		
		logResponse("solutionDetail", response);

		return response;
	}

	@RequestMapping(value = "/updateFinanceDetail", method = RequestMethod.POST)
	@ResponseBody
	public Response<UpdateFinanceDetailResponse> updateFinanceDetail(@RequestBody UpdateFinanceDetailRequest request) {

		logRequest("updateFinanceDetail", request);

  		Response<UpdateFinanceDetailResponse> response = new Response<>();

		request = (UpdateFinanceDetailRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getUpdateFinanceDetailResponse(request);
		
		logResponse("updateFinanceDetail", response);

		return response;
	}

	@RequestMapping(value = "/updateMyDemand", method = RequestMethod.POST)
	@ResponseBody
	public Response<UpdateMyDemandResponse> updateMyDemand(@RequestBody UpdateMyDemandRequest request) {

		logRequest("updateMyDemand", request);

  		Response<UpdateMyDemandResponse> response = new Response<>();

		request = (UpdateMyDemandRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getUpdateMyDemandResponse(request);
		
		logResponse("updateMyDemand", response);

		return response;
	}

	@RequestMapping(value = "/updateMyNikeName", method = RequestMethod.POST)
	@ResponseBody
	public Response<UpdateMyNikeNameResponse> updateMyNikeName(@RequestBody UpdateMyNikeNameRequest request) {

		logRequest("updateMyNikeName", request);

  		Response<UpdateMyNikeNameResponse> response = new Response<>();

		request = (UpdateMyNikeNameRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getUpdateMyNikeNameResponse(request);
		
		logResponse("updateMyNikeName", response);

		return response;
	}

	@RequestMapping(value = "/updateMySolution", method = RequestMethod.POST)
	@ResponseBody
	public Response<UpdateMySolutionResponse> updateMySolution(@RequestBody UpdateMySolutionRequest request) {

		logRequest("updateMySolution", request);

  		Response<UpdateMySolutionResponse> response = new Response<>();

		request = (UpdateMySolutionRequest) this.validate(request, response);
		if(null == request){
			return response;
		}

		response = getUpdateMySolutionResponse(request);
		
		logResponse("updateMySolution", response);

		return response;
	}


	private Response<AddSolutionResponse> getAddSolutionResponse(AddSolutionRequest request) {

		MessageService<AddSolutionRequest, Response<AddSolutionResponse>> service = addSolutionService;
		if (service == null) {
			service = genAddSolutionService;
		}

		return mobileService.service(request, service, AddSolutionRequest.class, AddSolutionResponse.class);
	}

	private Response<ConsultingRecordResponse> getConsultingRecordResponse(ConsultingRecordRequest request) {

		MessageService<ConsultingRecordRequest, Response<ConsultingRecordResponse>> service = consultingRecordService;
		if (service == null) {
			service = genConsultingRecordService;
		}

		return mobileService.service(request, service, ConsultingRecordRequest.class, ConsultingRecordResponse.class);
	}

	private Response<CreateMyDemandResponse> getCreateMyDemandResponse(CreateMyDemandRequest request) {

		MessageService<CreateMyDemandRequest, Response<CreateMyDemandResponse>> service = createMyDemandService;
		if (service == null) {
			service = genCreateMyDemandService;
		}

		return mobileService.service(request, service, CreateMyDemandRequest.class, CreateMyDemandResponse.class);
	}

	private Response<CreateMySolutionResponse> getCreateMySolutionResponse(CreateMySolutionRequest request) {

		MessageService<CreateMySolutionRequest, Response<CreateMySolutionResponse>> service = createMySolutionService;
		if (service == null) {
			service = genCreateMySolutionService;
		}

		return mobileService.service(request, service, CreateMySolutionRequest.class, CreateMySolutionResponse.class);
	}

	private Response<DemandDetailResponse> getDemandDetailResponse(DemandDetailRequest request) {

		MessageService<DemandDetailRequest, Response<DemandDetailResponse>> service = demandDetailService;
		if (service == null) {
			service = genDemandDetailService;
		}

		return mobileService.service(request, service, DemandDetailRequest.class, DemandDetailResponse.class);
	}

	private Response<FinanceDetailResponse> getFinanceDetailResponse(FinanceDetailRequest request) {

		MessageService<FinanceDetailRequest, Response<FinanceDetailResponse>> service = financeDetailService;
		if (service == null) {
			service = genFinanceDetailService;
		}

		return mobileService.service(request, service, FinanceDetailRequest.class, FinanceDetailResponse.class);
	}

	private Response<FinanceLoanInvestorResponse> getFinanceLoanInvestorResponse(FinanceLoanInvestorRequest request) {

		MessageService<FinanceLoanInvestorRequest, Response<FinanceLoanInvestorResponse>> service = financeLoanInvestorService;
		if (service == null) {
			service = genFinanceLoanInvestorService;
		}

		return mobileService.service(request, service, FinanceLoanInvestorRequest.class, FinanceLoanInvestorResponse.class);
	}

	private Response<FinanceLoanRecommendResponse> getFinanceLoanRecommendResponse(FinanceLoanRecommendRequest request) {

		MessageService<FinanceLoanRecommendRequest, Response<FinanceLoanRecommendResponse>> service = financeLoanRecommendService;
		if (service == null) {
			service = genFinanceLoanRecommendService;
		}

		return mobileService.service(request, service, FinanceLoanRecommendRequest.class, FinanceLoanRecommendResponse.class);
	}

	private Response<FinanceOperateLoanInvestorResponse> getFinanceOperateLoanInvestorResponse(FinanceOperateLoanInvestorRequest request) {

		MessageService<FinanceOperateLoanInvestorRequest, Response<FinanceOperateLoanInvestorResponse>> service = financeOperateLoanInvestorService;
		if (service == null) {
			service = genFinanceOperateLoanInvestorService;
		}

		return mobileService.service(request, service, FinanceOperateLoanInvestorRequest.class, FinanceOperateLoanInvestorResponse.class);
	}

	private Response<GetCmsResponse> getGetCmsResponse(GetCmsRequest request) {

		MessageService<GetCmsRequest, Response<GetCmsResponse>> service = getCmsService;
		if (service == null) {
			service = genGetCmsService;
		}

		return mobileService.service(request, service, GetCmsRequest.class, GetCmsResponse.class);
	}

	private Response<GetLoanDetailResponse> getGetLoanDetailResponse(GetLoanDetailRequest request) {

		MessageService<GetLoanDetailRequest, Response<GetLoanDetailResponse>> service = getLoanDetailService;
		if (service == null) {
			service = genGetLoanDetailService;
		}

		return mobileService.service(request, service, GetLoanDetailRequest.class, GetLoanDetailResponse.class);
	}

	private Response<GetLoanFinanceResponse> getGetLoanFinanceResponse(GetLoanFinanceRequest request) {

		MessageService<GetLoanFinanceRequest, Response<GetLoanFinanceResponse>> service = getLoanFinanceService;
		if (service == null) {
			service = genGetLoanFinanceService;
		}

		return mobileService.service(request, service, GetLoanFinanceRequest.class, GetLoanFinanceResponse.class);
	}

	private Response<GetMySolutionTop10Response> getGetMySolutionTop10Response(GetMySolutionTop10Request request) {

		MessageService<GetMySolutionTop10Request, Response<GetMySolutionTop10Response>> service = getMySolutionTop10Service;
		if (service == null) {
			service = genGetMySolutionTop10Service;
		}

		return mobileService.service(request, service, GetMySolutionTop10Request.class, GetMySolutionTop10Response.class);
	}

	private Response<GetNameAuthAndRiskResultResponse> getGetNameAuthAndRiskResultResponse(GetNameAuthAndRiskResultRequest request) {

		MessageService<GetNameAuthAndRiskResultRequest, Response<GetNameAuthAndRiskResultResponse>> service = getNameAuthAndRiskResultService;
		if (service == null) {
			service = genGetNameAuthAndRiskResultService;
		}

		return mobileService.service(request, service, GetNameAuthAndRiskResultRequest.class, GetNameAuthAndRiskResultResponse.class);
	}

	private Response<GetPrivateLoanResponse> getGetPrivateLoanResponse(GetPrivateLoanRequest request) {

		MessageService<GetPrivateLoanRequest, Response<GetPrivateLoanResponse>> service = getPrivateLoanService;
		if (service == null) {
			service = genGetPrivateLoanService;
		}

		return mobileService.service(request, service, GetPrivateLoanRequest.class, GetPrivateLoanResponse.class);
	}

	private Response<GetPublicLoanResponse> getGetPublicLoanResponse(GetPublicLoanRequest request) {

		MessageService<GetPublicLoanRequest, Response<GetPublicLoanResponse>> service = getPublicLoanService;
		if (service == null) {
			service = genGetPublicLoanService;
		}

		return mobileService.service(request, service, GetPublicLoanRequest.class, GetPublicLoanResponse.class);
	}

	private Response<GetSmsResponse> getGetSmsResponse(GetSmsRequest request) {

		MessageService<GetSmsRequest, Response<GetSmsResponse>> service = getSmsService;
		if (service == null) {
			service = genGetSmsService;
		}

		return mobileService.service(request, service, GetSmsRequest.class, GetSmsResponse.class);
	}

	private Response<GetSolutionTop10Response> getGetSolutionTop10Response(GetSolutionTop10Request request) {

		MessageService<GetSolutionTop10Request, Response<GetSolutionTop10Response>> service = getSolutionTop10Service;
		if (service == null) {
			service = genGetSolutionTop10Service;
		}

		return mobileService.service(request, service, GetSolutionTop10Request.class, GetSolutionTop10Response.class);
	}

	private Response<GetUserResponse> getGetUserResponse(GetUserRequest request) {

		MessageService<GetUserRequest, Response<GetUserResponse>> service = getUserService;
		if (service == null) {
			service = genGetUserService;
		}

		return mobileService.service(request, service, GetUserRequest.class, GetUserResponse.class);
	}

	private Response<InvestResponse> getInvestResponse(InvestRequest request) {

		MessageService<InvestRequest, Response<InvestResponse>> service = investService;
		if (service == null) {
			service = genInvestService;
		}

		return mobileService.service(request, service, InvestRequest.class, InvestResponse.class);
	}

	private Response<IsCollectedResponse> getIsCollectedResponse(IsCollectedRequest request) {

		MessageService<IsCollectedRequest, Response<IsCollectedResponse>> service = isCollectedService;
		if (service == null) {
			service = genIsCollectedService;
		}

		return mobileService.service(request, service, IsCollectedRequest.class, IsCollectedResponse.class);
	}

	private Response<IsFriendResponse> getIsFriendResponse(IsFriendRequest request) {

		MessageService<IsFriendRequest, Response<IsFriendResponse>> service = isFriendService;
		if (service == null) {
			service = genIsFriendService;
		}

		return mobileService.service(request, service, IsFriendRequest.class, IsFriendResponse.class);
	}

	private Response<IsHasMatchDemandSolutionResponse> getIsHasMatchDemandSolutionResponse(IsHasMatchDemandSolutionRequest request) {

		MessageService<IsHasMatchDemandSolutionRequest, Response<IsHasMatchDemandSolutionResponse>> service = isHasMatchDemandSolutionService;
		if (service == null) {
			service = genIsHasMatchDemandSolutionService;
		}

		return mobileService.service(request, service, IsHasMatchDemandSolutionRequest.class, IsHasMatchDemandSolutionResponse.class);
	}

	private Response<LoanInvestorDetailResponse> getLoanInvestorDetailResponse(LoanInvestorDetailRequest request) {

		MessageService<LoanInvestorDetailRequest, Response<LoanInvestorDetailResponse>> service = loanInvestorDetailService;
		if (service == null) {
			service = genLoanInvestorDetailService;
		}

		return mobileService.service(request, service, LoanInvestorDetailRequest.class, LoanInvestorDetailResponse.class);
	}

	private Response<LoginOrRegisterResponse> getLoginOrRegisterResponse(LoginOrRegisterRequest request) {

		MessageService<LoginOrRegisterRequest, Response<LoginOrRegisterResponse>> service = loginOrRegisterService;
		if (service == null) {
			service = genLoginOrRegisterService;
		}

		return mobileService.service(request, service, LoginOrRegisterRequest.class, LoginOrRegisterResponse.class);
	}

	private Response<MakeFriendResponse> getMakeFriendResponse(MakeFriendRequest request) {

		MessageService<MakeFriendRequest, Response<MakeFriendResponse>> service = makeFriendService;
		if (service == null) {
			service = genMakeFriendService;
		}

		return mobileService.service(request, service, MakeFriendRequest.class, MakeFriendResponse.class);
	}

	private Response<MyCollectionLoanResponse> getMyCollectionLoanResponse(MyCollectionLoanRequest request) {

		MessageService<MyCollectionLoanRequest, Response<MyCollectionLoanResponse>> service = myCollectionLoanService;
		if (service == null) {
			service = genMyCollectionLoanService;
		}

		return mobileService.service(request, service, MyCollectionLoanRequest.class, MyCollectionLoanResponse.class);
	}

	private Response<MyCollectionPersonResponse> getMyCollectionPersonResponse(MyCollectionPersonRequest request) {

		MessageService<MyCollectionPersonRequest, Response<MyCollectionPersonResponse>> service = myCollectionPersonService;
		if (service == null) {
			service = genMyCollectionPersonService;
		}

		return mobileService.service(request, service, MyCollectionPersonRequest.class, MyCollectionPersonResponse.class);
	}

	private Response<MyDemandResponse> getMyDemandResponse(MyDemandRequest request) {

		MessageService<MyDemandRequest, Response<MyDemandResponse>> service = myDemandService;
		if (service == null) {
			service = genMyDemandService;
		}

		return mobileService.service(request, service, MyDemandRequest.class, MyDemandResponse.class);
	}

	private Response<MyFinanceDetailResponse> getMyFinanceDetailResponse(MyFinanceDetailRequest request) {

		MessageService<MyFinanceDetailRequest, Response<MyFinanceDetailResponse>> service = myFinanceDetailService;
		if (service == null) {
			service = genMyFinanceDetailService;
		}

		return mobileService.service(request, service, MyFinanceDetailRequest.class, MyFinanceDetailResponse.class);
	}

	private Response<MyFriendsResponse> getMyFriendsResponse(MyFriendsRequest request) {

		MessageService<MyFriendsRequest, Response<MyFriendsResponse>> service = myFriendsService;
		if (service == null) {
			service = genMyFriendsService;
		}

		return mobileService.service(request, service, MyFriendsRequest.class, MyFriendsResponse.class);
	}

	private Response<MyLoanInvestorResponse> getMyLoanInvestorResponse(MyLoanInvestorRequest request) {

		MessageService<MyLoanInvestorRequest, Response<MyLoanInvestorResponse>> service = myLoanInvestorService;
		if (service == null) {
			service = genMyLoanInvestorService;
		}

		return mobileService.service(request, service, MyLoanInvestorRequest.class, MyLoanInvestorResponse.class);
	}

	private Response<MySolutionResponse> getMySolutionResponse(MySolutionRequest request) {

		MessageService<MySolutionRequest, Response<MySolutionResponse>> service = mySolutionService;
		if (service == null) {
			service = genMySolutionService;
		}

		return mobileService.service(request, service, MySolutionRequest.class, MySolutionResponse.class);
	}

	private Response<OperateMyDemandResponse> getOperateMyDemandResponse(OperateMyDemandRequest request) {

		MessageService<OperateMyDemandRequest, Response<OperateMyDemandResponse>> service = operateMyDemandService;
		if (service == null) {
			service = genOperateMyDemandService;
		}

		return mobileService.service(request, service, OperateMyDemandRequest.class, OperateMyDemandResponse.class);
	}

	private Response<OperateMyDemandsolutionResponse> getOperateMyDemandsolutionResponse(OperateMyDemandsolutionRequest request) {

		MessageService<OperateMyDemandsolutionRequest, Response<OperateMyDemandsolutionResponse>> service = operateMyDemandsolutionService;
		if (service == null) {
			service = genOperateMyDemandsolutionService;
		}

		return mobileService.service(request, service, OperateMyDemandsolutionRequest.class, OperateMyDemandsolutionResponse.class);
	}

	private Response<OperateMySolutionResponse> getOperateMySolutionResponse(OperateMySolutionRequest request) {

		MessageService<OperateMySolutionRequest, Response<OperateMySolutionResponse>> service = operateMySolutionService;
		if (service == null) {
			service = genOperateMySolutionService;
		}

		return mobileService.service(request, service, OperateMySolutionRequest.class, OperateMySolutionResponse.class);
	}

	private Response<OperateMySolutiondemandResponse> getOperateMySolutiondemandResponse(OperateMySolutiondemandRequest request) {

		MessageService<OperateMySolutiondemandRequest, Response<OperateMySolutiondemandResponse>> service = operateMySolutiondemandService;
		if (service == null) {
			service = genOperateMySolutiondemandService;
		}

		return mobileService.service(request, service, OperateMySolutiondemandRequest.class, OperateMySolutiondemandResponse.class);
	}

	private Response<RealNameAuthResponse> getRealNameAuthResponse(RealNameAuthRequest request) {

		MessageService<RealNameAuthRequest, Response<RealNameAuthResponse>> service = realNameAuthService;
		if (service == null) {
			service = genRealNameAuthService;
		}

		return mobileService.service(request, service, RealNameAuthRequest.class, RealNameAuthResponse.class);
	}

	private Response<RegisterJgResponse> getRegisterJgResponse(RegisterJgRequest request) {

		MessageService<RegisterJgRequest, Response<RegisterJgResponse>> service = registerJgService;
		if (service == null) {
			service = genRegisterJgService;
		}

		return mobileService.service(request, service, RegisterJgRequest.class, RegisterJgResponse.class);
	}

	private Response<RiskAssessmentResultGetResponse> getRiskAssessmentResultGetResponse(RiskAssessmentResultGetRequest request) {

		MessageService<RiskAssessmentResultGetRequest, Response<RiskAssessmentResultGetResponse>> service = riskAssessmentResultGetService;
		if (service == null) {
			service = genRiskAssessmentResultGetService;
		}

		return mobileService.service(request, service, RiskAssessmentResultGetRequest.class, RiskAssessmentResultGetResponse.class);
	}

	private Response<RiskAssessmentResultPostResponse> getRiskAssessmentResultPostResponse(RiskAssessmentResultPostRequest request) {

		MessageService<RiskAssessmentResultPostRequest, Response<RiskAssessmentResultPostResponse>> service = riskAssessmentResultPostService;
		if (service == null) {
			service = genRiskAssessmentResultPostService;
		}

		return mobileService.service(request, service, RiskAssessmentResultPostRequest.class, RiskAssessmentResultPostResponse.class);
	}

	private Response<SelectFinanceResponse> getSelectFinanceResponse(SelectFinanceRequest request) {

		MessageService<SelectFinanceRequest, Response<SelectFinanceResponse>> service = selectFinanceService;
		if (service == null) {
			service = genSelectFinanceService;
		}

		return mobileService.service(request, service, SelectFinanceRequest.class, SelectFinanceResponse.class);
	}

	private Response<ServicePersonRecordResponse> getServicePersonRecordResponse(ServicePersonRecordRequest request) {

		MessageService<ServicePersonRecordRequest, Response<ServicePersonRecordResponse>> service = servicePersonRecordService;
		if (service == null) {
			service = genServicePersonRecordService;
		}

		return mobileService.service(request, service, ServicePersonRecordRequest.class, ServicePersonRecordResponse.class);
	}

	private Response<SingleDemandSolutionListResponse> getSingleDemandSolutionListResponse(SingleDemandSolutionListRequest request) {

		MessageService<SingleDemandSolutionListRequest, Response<SingleDemandSolutionListResponse>> service = singleDemandSolutionListService;
		if (service == null) {
			service = genSingleDemandSolutionListService;
		}

		return mobileService.service(request, service, SingleDemandSolutionListRequest.class, SingleDemandSolutionListResponse.class);
	}

	private Response<SingleSolutionDemandListResponse> getSingleSolutionDemandListResponse(SingleSolutionDemandListRequest request) {

		MessageService<SingleSolutionDemandListRequest, Response<SingleSolutionDemandListResponse>> service = singleSolutionDemandListService;
		if (service == null) {
			service = genSingleSolutionDemandListService;
		}

		return mobileService.service(request, service, SingleSolutionDemandListRequest.class, SingleSolutionDemandListResponse.class);
	}

	private Response<SolutionDetailResponse> getSolutionDetailResponse(SolutionDetailRequest request) {

		MessageService<SolutionDetailRequest, Response<SolutionDetailResponse>> service = solutionDetailService;
		if (service == null) {
			service = genSolutionDetailService;
		}

		return mobileService.service(request, service, SolutionDetailRequest.class, SolutionDetailResponse.class);
	}

	private Response<UpdateFinanceDetailResponse> getUpdateFinanceDetailResponse(UpdateFinanceDetailRequest request) {

		MessageService<UpdateFinanceDetailRequest, Response<UpdateFinanceDetailResponse>> service = updateFinanceDetailService;
		if (service == null) {
			service = genUpdateFinanceDetailService;
		}

		return mobileService.service(request, service, UpdateFinanceDetailRequest.class, UpdateFinanceDetailResponse.class);
	}

	private Response<UpdateMyDemandResponse> getUpdateMyDemandResponse(UpdateMyDemandRequest request) {

		MessageService<UpdateMyDemandRequest, Response<UpdateMyDemandResponse>> service = updateMyDemandService;
		if (service == null) {
			service = genUpdateMyDemandService;
		}

		return mobileService.service(request, service, UpdateMyDemandRequest.class, UpdateMyDemandResponse.class);
	}

	private Response<UpdateMyNikeNameResponse> getUpdateMyNikeNameResponse(UpdateMyNikeNameRequest request) {

		MessageService<UpdateMyNikeNameRequest, Response<UpdateMyNikeNameResponse>> service = updateMyNikeNameService;
		if (service == null) {
			service = genUpdateMyNikeNameService;
		}

		return mobileService.service(request, service, UpdateMyNikeNameRequest.class, UpdateMyNikeNameResponse.class);
	}

	private Response<UpdateMySolutionResponse> getUpdateMySolutionResponse(UpdateMySolutionRequest request) {

		MessageService<UpdateMySolutionRequest, Response<UpdateMySolutionResponse>> service = updateMySolutionService;
		if (service == null) {
			service = genUpdateMySolutionService;
		}

		return mobileService.service(request, service, UpdateMySolutionRequest.class, UpdateMySolutionResponse.class);
	}

	/**
	* 请求数据校验
	*
	* @param request
	* @param response
	* @return
	*/
	private MobileMessage validate(MobileMessage request, Response response) {

		//版本校验
		if(StringUtils.isEmpty(request.getVersionCode())
		|| StringUtils.isEmpty(request.getMsgtimestamp())
		|| StringUtils.isEmpty(request.getPlatformType())
		|| StringUtils.isEmpty(request.getDeviceId())){
			response.getHeader().setCode(RetCode.VALIDATEERROR.getCode());
			response.getHeader().setMessage("参数错误，请更新客户端！");
			return null;
		}

		try {
			Integer.parseInt(request.getVersionCode()); // 版本号格式异常
		} catch (Exception e){
			response.getHeader().setCode(RetCode.VALIDATEERROR.getMessage());
			response.getHeader().setMessage("参数错误，请更新客户端！");
			return null;
		}

		//验重
		String rediskey = request.getDeviceId() + request.getMsgtimestamp() + request.getMsgnonce();

		if(redisTemplate.opsForValue().increment(rediskey, 1) > 1){
			response.getHeader().setCode(RetCode.VALIDATEERROR.getCode());
			response.getHeader().setCode("无效请求");
			return null;
		}
		redisTemplate.expire(rediskey,Long.parseLong(redisExpireTimestampNonce),TimeUnit.MINUTES);
		return request;
	}

	/**
	* 请求日志
	*
	* @param service
	* @param request
	*/
	private void logRequest(String service, MobileMessage request) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(System.lineSeparator());
			sb.append("Request[").append(service).append("] begin").append(System.lineSeparator());
			sb.append(objectMapper.writeValueAsString(request)).append(System.lineSeparator());
			sb.append("Request[").append(service).append("] end");
			LOG.info(sb.toString());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	* 响应日志
	*
	* @param service
	* @param response
	*/
	private void logResponse(String service, Response response) {
		try {

			String responseJson = objectMapper.writeValueAsString(response);
			if(responseJson.length() > 1000){
				responseJson = responseJson.substring(0, 1000);
				responseJson += "......";
			}

			StringBuffer sb = new StringBuffer();
			sb.append(System.lineSeparator());
			sb.append("Response[").append(service).append("] begin").append(System.lineSeparator());
			sb.append(responseJson).append(System.lineSeparator());
			sb.append("Response[").append(service).append("] end");

			LOG.info(sb.toString());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
