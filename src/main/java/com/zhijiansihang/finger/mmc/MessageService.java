package com.zhijiansihang.finger.mmc;

public interface MessageService<REQUEST, RESPONSE> {

	public void execute(REQUEST request, RESPONSE response);

}
