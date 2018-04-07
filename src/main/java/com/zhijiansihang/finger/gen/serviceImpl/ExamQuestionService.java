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

		response.getBody().setResult("{\"examid\":30000,\"questions\":[{\"order\":1,\"id\":30001,\"title\":\"年龄\",\"anwsers\":[{\"id\":1,\"questionId\":30001,\"content\":\"19-30岁\",\"score\":4},{\"id\":2,\"questionId\":30001,\"content\":\"31-50岁\",\"score\":3},{\"id\":3,\"questionId\":30001,\"content\":\"51-65岁\",\"score\":2},{\"id\":4,\"questionId\":30001,\"content\":\"高于65岁\",\"score\":1}]},{\"order\":2,\"id\":30002,\"title\":\"身体健康状况\",\"anwsers\":[{\"id\":1,\"questionId\":30002,\"content\":\"非常好\",\"score\":4},{\"id\":2,\"questionId\":30002,\"content\":\"好\",\"score\":3},{\"id\":3,\"questionId\":30002,\"content\":\"一般\",\"score\":2},{\"id\":4,\"questionId\":30002,\"content\":\"差\",\"score\":1}]},{\"order\":3,\"id\":30003,\"title\":\"家庭年收入\",\"anwsers\":[{\"id\":1,\"questionId\":30003,\"content\":\"10万以下\",\"score\":1},{\"id\":2,\"questionId\":30003,\"content\":\"10万元至30万元\",\"score\":2},{\"id\":3,\"questionId\":30003,\"content\":\"30万元至50万元\",\"score\":3},{\"id\":4,\"questionId\":30003,\"content\":\"100万元以上\",\"score\":4}]},{\"order\":4,\"id\":30004,\"title\":\"家庭年收入中，可用于金融投资（储蓄存款除外）的比例\",\"anwsers\":[{\"id\":1,\"questionId\":30004,\"content\":\"小于10%\",\"score\":1},{\"id\":2,\"questionId\":30004,\"content\":\"10%~25%\",\"score\":2},{\"id\":3,\"questionId\":30004,\"content\":\"25%~50%\",\"score\":3},{\"id\":4,\"questionId\":30004,\"content\":\"大于50%\",\"score\":4}]},{\"order\":5,\"id\":30005,\"title\":\"有没有投资经验\",\"anwsers\":[{\"id\":1,\"questionId\":30005,\"content\":\"几乎没有\",\"score\":1},{\"id\":2,\"questionId\":30005,\"content\":\"少于2年\",\"score\":2},{\"id\":3,\"questionId\":30005,\"content\":\"大于2年，少于5年\",\"score\":3},{\"id\":4,\"questionId\":30005,\"content\":\"大于5年\",\"score\":4}]},{\"order\":6,\"id\":30006,\"title\":\"以下哪种最符合您的投资态度\",\"anwsers\":[{\"id\":1,\"questionId\":30006,\"content\":\"厌恶风险，不希望本金损失，希望获得稳定回报\",\"score\":1},{\"id\":2,\"questionId\":30006,\"content\":\"保守投资，不希望本金损失，愿意承担一定幅度的收益波动\",\"score\":2},{\"id\":3,\"questionId\":30006,\"content\":\"寻求资金的较高收益和成长性，愿意为此承担可能发生的有限本金损失风险\",\"score\":3},{\"id\":4,\"questionId\":30006,\"content\":\"希望赚取高回报，愿意为此承担可能发生的较大本金损失风险\",\"score\":4}]},{\"order\":7,\"id\":30007,\"title\":\"您的投资出现何种程度的波动时，您会呈现明显的焦虑\",\"anwsers\":[{\"id\":1,\"questionId\":30007,\"content\":\"本金无损，但收益未达预期\",\"score\":1},{\"id\":2,\"questionId\":30007,\"content\":\"本金10%以内的损失\",\"score\":2},{\"id\":3,\"questionId\":30007,\"content\":\"本金10%—50%的损失\",\"score\":3},{\"id\":4,\"questionId\":30007,\"content\":\"本金50%以上损失\",\"score\":4}]},{\"order\":8,\"id\":30008,\"title\":\"您的计划投资期限是多久\",\"anwsers\":[{\"id\":1,\"questionId\":30008,\"content\":\"1年以下\",\"score\":1},{\"id\":2,\"questionId\":30008,\"content\":\"1年至3年\",\"score\":2},{\"id\":3,\"questionId\":30008,\"content\":\"3年至5年\",\"score\":3},{\"id\":4,\"questionId\":30008,\"content\":\"5年以上\",\"score\":4}]},{\"order\":9,\"id\":30009,\"title\":\"您的收益及风险匹配偏好\",\"anwsers\":[{\"id\":1,\"questionId\":30009,\"content\":\"不能承担任何本金及利息的损失\",\"score\":1},{\"id\":2,\"questionId\":30009,\"content\":\"只选择保本产品\",\"score\":2},{\"id\":3,\"questionId\":30009,\"content\":\"可接受低风险、低收益产品\",\"score\":3},{\"id\":4,\"questionId\":30009,\"content\":\"会配置高风险、高收益产品\",\"score\":4}]},{\"order\":10,\"id\":30010,\"title\":\"您的投资目的是\",\"anwsers\":[{\"id\":1,\"questionId\":30010,\"content\":\"抗通胀的保值手段\",\"score\":1},{\"id\":2,\"questionId\":30010,\"content\":\"长期持有实现财富增值\",\"score\":2},{\"id\":3,\"questionId\":30010,\"content\":\"短期内实现财富快速增值\",\"score\":3},{\"id\":4,\"questionId\":30010,\"content\":\"分散投资风险\",\"score\":4}]}]}");
	}
}
