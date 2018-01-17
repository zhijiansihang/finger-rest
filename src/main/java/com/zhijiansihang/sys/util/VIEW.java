package com.zhijiansihang.sys.util;

import com.zhijiansihang.sys.controller.SysLogController;

public abstract class VIEW {

	/**
	 * @see com.zhijiansihang.sys.controller.UserController#index(org.springframework.ui.Model)
	 */
	public static final String ADMIN_USER = "admin/user-index";

	/**
	 * @see com.zhijiansihang.sys.controller.UserController#userProfile(org.springframework.ui.Model)
	 */
	public static final String ADMIN_USER_PROFILE = "admin/user-profile";

	/**
	 * @see com.zhijiansihang.sys.controller.RoleController#index(org.springframework.ui.Model)
	 */
	public static final String ADMIN_ROLE = "admin/role-index";

	/**
	 * @see com.zhijiansihang.sys.controller.RoleController#permissions(Long,
	 *      org.springframework.ui.Model)
	 */
	public static final String ADMIN_ROLE_PERMISSIONS = "admin/role-permissions";

	/**
	 * @see com.zhijiansihang.sys.controller.RoleController#target(Long,
	 *      org.springframework.ui.Model)
	 */
	public static final String ADMIN_ROLE_TARGET = "admin/role-target";

	/**
	 * @see com.zhijiansihang.sys.controller.MenuController#index(org.springframework.ui.Model)
	 */
	public static final String ADMIN_MENU = "admin/menu-index";

	/**
	 * @see com.zhijiansihang.sys.controller.OrganController#index(org.springframework.ui.Model)
	 */
	public static final String ADMIN_ORGAN = "admin/organ-index";

	/**
	 * @see SysLogController#index(org.springframework.ui.Model)
	 */
	public static final String SYSLOG_INDEX = "admin/syslog";

	/**
	 * @see com.zhijiansihang.sys.controller.WordBookController#index(org.springframework.ui.Model)
	 */
	public static final String ADMIN_WORDBOOK = "admin/wordbook-index";

	/**
	 * @see com.zhijiansihang.sys.controller.WordBookController#items(Long,
	 *      org.springframework.ui.Model)
	 */
	public static final String ADMIN_WORDBOOK_ITEMS = "admin/wordbook-items";

	/**
	 * @see com.zhijiansihang.sys.controller.WordBookController#getWordBookMapJsp()
	 */
	public static final String ADMIN_WORDBOOK_MAP = "admin/wordbookMap";

	/**
	 * @see com.zhijiansihang.sys.controller.BankController#queryBankList(org.springframework.ui.Model)
	 */
	public static final String BANK_LIST = "credit/bank";
	
	/**
     * @see com.zhijiansihang.sys.controller.IndustryController#list(com.zhijiansihang.sys.entity.Industry, org.springframework.ui.Model)
     */
    public static final String INDUSTRY_LIST = "admin/industry-list";
    
    public static final String ADMIN_CLIENT = "client/client-index";
}
