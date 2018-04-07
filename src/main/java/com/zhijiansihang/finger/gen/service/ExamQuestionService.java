package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ExamQuestionRequest;
import com.zhijiansihang.finger.gen.entity.ExamQuestionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 考试问题
 * 
 */
@Component("genexamQuestionService")
public class ExamQuestionService implements MessageService<ExamQuestionRequest, Response<ExamQuestionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ExamQuestionService.class);
	private static final String SERVICE_DESC = "考试问题";

	@Override
	public void execute(ExamQuestionRequest request, Response<ExamQuestionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setResult("");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
