package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ExamQuestionRequest;
import com.zhijiansihang.finger.gen.entity.ExamQuestionResponse;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 考试问题
 * 
 */
@Component("examQuestionService")
public class ExamQuestionService implements MessageService<ExamQuestionRequest, Response<ExamQuestionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ExamQuestionService.class);
	private static final String SERVICE_DESC = "考试问题";

	@Override
	public void execute(ExamQuestionRequest request, Response<ExamQuestionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		response.getBody().setResult("{\"examid\": 30000,\"questions\": [{\"order\": 1,\"id\": 30001,\"title\": \"您的年龄为\",\"anwsers\": [{\"id\": 1,\"questionId\": 30001,\"content\": \"18-30岁\",\"score\": 4}, {\"id\": 2,\"questionId\": 30001,\"content\": \"31-50岁\",\"score\": 3}, {\"id\": 3,\"questionId\": 30001,\"content\": \"51-65岁\",\"score\": 2}, {\"id\": 4,\"questionId\": 30001,\"content\": \"高于65岁\",\"score\": 1}]}, {\"order\": 2,\"id\": 30002,\"title\": \"您的职业为\",\"anwsers\": [{\"id\": 1,\"questionId\": 30002,\"content\": \"无固定职业\",\"score\": 1}, {\"id\": 2,\"questionId\": 30002,\"content\": \"专业技术人员\",\"score\": 2}, {\"id\": 3,\"questionId\": 30002,\"content\": \"一般企业事业单位员工\",\"score\": 3}, {\"id\": 4,\"questionId\": 30002,\"content\": \"金融行业一般从业人员\",\"score\": 4}]}, {\"order\": 3,\"id\": 30003,\"title\": \"您的学历为\",\"anwsers\": [{\"id\": 1,\"questionId\": 30003,\"content\": \"高中及以下\",\"score\": 1}, {\"id\": 2,\"questionId\": 30003,\"content\": \"中专或大专\",\"score\": 2}, {\"id\": 3,\"questionId\": 30003,\"content\": \"本科\",\"score\": 3}, {\"id\": 4,\"questionId\": 30003,\"content\": \"硕士及以上\",\"score\": 4}]}, {\"order\": 4,\"id\": 30004,\"title\": \"您的家庭可支配年收入为\",\"anwsers\": [{\"id\": 1,\"questionId\": 30004,\"content\": \"50万元以下\",\"score\": 1}, {\"id\": 2,\"questionId\": 30004,\"content\": \"50万元到100万元\",\"score\": 2}, {\"id\": 3,\"questionId\": 30004,\"content\": \"100万元到500万元\",\"score\": 3}, {\"id\": 4,\"questionId\": 30004,\"content\": \"500万元到1000万元\",\"score\": 4}, {\"id\": 5,\"questionId\": 30004,\"content\": \"1000万元以上\",\"score\": 5}]}, {\"order\": 5,\"id\": 30005,\"title\": \"在您每年的家庭可支配收入中，可用于投资的比例为\",\"anwsers\": [{\"id\": 1,\"questionId\": 30005,\"content\": \"小于10%\",\"score\": 1}, {\"id\": 2,\"questionId\": 30005,\"content\": \"10%到25%\",\"score\": 2}, {\"id\": 3,\"questionId\": 30005,\"content\": \"25%到50%\",\"score\": 3}, {\"id\": 4,\"questionId\": 30005,\"content\": \"大于50%\",\"score\": 4}]}, {\"order\": 6,\"id\": 30006,\"title\": \"您的投资知识可描述为\",\"anwsers\": [{\"id\": 1,\"questionId\": 30006,\"content\": \"有限，基本没有金融产品方面知识\",\"score\": 1}, {\"id\": 2,\"questionId\": 30006,\"content\": \"一般，对金融产品和风险有基本理解\",\"score\": 2}, {\"id\": 3,\"questionId\": 30006,\"content\": \"丰富，对金融产品和风险有深入理解\",\"score\": 3}]}, {\"order\": 7,\"id\": 30007,\"title\": \"您的投资经验可描述为\",\"anwsers\": [{\"id\": 1,\"questionId\": 30007,\"content\": \"除银行储蓄外，基本没有其他投资经验\",\"score\": 1}, {\"id\": 2,\"questionId\": 30007,\"content\": \"购买过债券保险等理财产品\",\"score\": 2}, {\"id\": 3,\"questionId\": 30007,\"content\": \"参与过股票基金等产品交易\",\"score\": 3}, {\"id\": 4,\"questionId\": 30007,\"content\": \"参与过权证、期货等产品的交易\",\"score\": 4}]}, {\"order\": 8,\"id\": 30008,\"title\": \"您有多少投资基金、股票、信托、私募或金融衍生产品等风险投资经验\",\"anwsers\": [{\"id\": 1,\"questionId\": 30008,\"content\": \"没有经验\",\"score\": 1}, {\"id\": 2,\"questionId\": 30008,\"content\": \"少于2年\",\"score\": 2}, {\"id\": 3,\"questionId\": 30008,\"content\": \"2年至5年\",\"score\": 3}, {\"id\": 4,\"questionId\": 30008,\"content\": \"5年至10年\",\"score\": 4}, {\"id\": 5,\"questionId\": 30008,\"content\": \"10年以上\",\"score\": 5}]}, {\"order\": 9,\"id\": 30009,\"title\": \"您计划的投资期限是\",\"anwsers\": [{\"id\": 1,\"questionId\": 30009,\"content\": \"1年以下\",\"score\": 1}, {\"id\": 2,\"questionId\": 30009,\"content\": \"1到3年\",\"score\": 2}, {\"id\": 3,\"questionId\": 30009,\"content\": \"3到5年\",\"score\": 3}, {\"id\": 4,\"questionId\": 30009,\"content\": \"5年以上\",\"score\": 4}]}, {\"order\": 10,\"id\": 30010,\"title\": \"您的投资目的是\",\"anwsers\": [{\"id\": 1,\"questionId\": 30010,\"content\": \"资产保值\",\"score\": 1}, {\"id\": 2,\"questionId\": 30010,\"content\": \"资产稳定增长\",\"score\": 2}, {\"id\": 3,\"questionId\": 30010,\"content\": \"资产迅速增长\",\"score\": 3}]}, {\"order\": 11,\"id\": 30011,\"title\": \"以下哪项最符合您的投资态度\",\"anwsers\": [{\"id\": 1,\"questionId\": 30011,\"content\": \"厌恶风险，不希望本金损失，希望获得稳定回报\",\"score\": 1}, {\"id\": 2,\"questionId\": 3011,\"content\": \"保守投资，不希望本金损失，愿意承担一定幅度的收益波动\",\"score\": 2}, {\"id\": 3,\"questionId\": 30011,\"content\": \"寻求资金的较高收益和成长性，愿意为此承担有限的本金损失\",\"score\": 3}, {\"id\": 4,\"questionId\": 30011,\"content\": \"希望赚取高回报，愿意为此承当较大的本金损失\",\"score\": 4}]}, {\"order\": 12,\"id\": 30012,\"title\": \"您能承当的最大投资损失是\",\"anwsers\": [{\"id\": 1,\"questionId\": 30012,\"content\": \"10%以内\",\"score\": 1}, {\"id\": 2,\"questionId\": 30012,\"content\": \"10%到30%\",\"score\": 2}, {\"id\": 3,\"questionId\": 30012,\"content\": \"30%到50%\",\"score\": 3}, {\"id\": 4,\"questionId\": 30012,\"content\": \"50%以上\",\"score\": 4}]}]}");
	}
}
