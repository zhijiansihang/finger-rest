package com.zhijiansihang.finger.app.constant;

/**
 * Created by paul on 2018/1/22.
 */
public class UserConsts {
    public static enum UserRolesEnum{
        PLATFORM(1,"平台管理员"),
        INSTITUTION(2,"第三方机构"),
        INVESTOR(3,"用户投资人"),
        FINANCE(4,"理财师");

        public Integer getRole() {
            return role;
        }

        public void setRole(Integer role) {
            this.role = role;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        private Integer role;
        private String desc;
        UserRolesEnum(Integer role, String desc) {
            this.role = role;
            this.desc = desc;
        }
    }
    public static String getUserRoles(int role){
        UserRolesEnum[] values = UserRolesEnum.values();
        for (UserRolesEnum userRolesEnum:values){
            if (userRolesEnum.getRole().intValue()==role){
                return userRolesEnum.name();
            }
        }
        return "";
    }

    public static final String USER_LOCK_RISK_INIT_PREFIX = "user_lock_risk_init_";
}
