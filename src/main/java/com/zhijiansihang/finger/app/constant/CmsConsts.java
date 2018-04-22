package com.zhijiansihang.finger.app.constant;


import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;

/**
 * @author paul
 * @description
 * @date 2018/1/3
 */
public class CmsConsts {

    public static final String ACCESS_PREFIX_0 = "/cms/pic";
    public static final String ACCESS_PREFIX_1 = "cms/pic";

    public static CmsEnum getCmsEnum(int typeCode){
        CmsEnum[] values = CmsEnum.values();
        for (CmsEnum cmsEnum:values){
            if (cmsEnum.getTypeCode().intValue()==typeCode){
                return cmsEnum;
            }
        }
        return null;
    }
    public static enum CmsEnum {
        banner(100, "banner"), notice(200, "公告"), information(300, "资讯"), avatar(400, "头像"), loan(500, "标文件");

        CmsEnum(Integer typeCode, String typeName) {
            this.typeCode = typeCode;
            this.typeName = typeName;
        }

        /**
         * 类型编码
         */
        private Integer typeCode;
        /**
         * 类型名称
         */
        private String typeName;


        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        /**
         * 获取存储位置
         *
         * @return
         */
        public String getStorageLocationPrefix() {
            SharingProperties sharingProperties = ApplicationContextHelper.getBean(SharingProperties.class);
            String fileSystemRoot = sharingProperties.getFileSystemRoot();
            if (fileSystemRoot.endsWith("/")) {
                fileSystemRoot = fileSystemRoot + ACCESS_PREFIX_1;
            } else {
                fileSystemRoot = fileSystemRoot + ACCESS_PREFIX_0;
            }
            return fileSystemRoot +"/"+ this.name().toLowerCase()+"/";
        }

        public String getAccessLocationPrefix(){
            SharingProperties sharingProperties = ApplicationContextHelper.getBean(SharingProperties.class);
            String serverLink = sharingProperties.getStaticServerLink();
            if (serverLink.endsWith("/")) {
                serverLink = serverLink + ACCESS_PREFIX_1;
            } else {
                serverLink = serverLink + ACCESS_PREFIX_0;
            }
            return serverLink +"/"+ this.name().toLowerCase()+"/";
        }
    }

    public static enum RiskAssessmentEnum{
        LEVEL_1(12, 18,1,"保守型"),
        LEVEL_2(19, 25,2,"稳健型"),
        LEVEL_3(26, 35,3,"成熟型"),
        LEVEL_4(36, 43,4,"进取型"),
        LEVEL_5(44, 49, 5,"激进型");

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

        public int getMinScore() {
            return minScore;
        }

        public void setMinScore(int minScore) {
            this.minScore = minScore;
        }

        public int getMaxScore() {
            return maxScore;
        }

        public void setMaxScore(int maxScore) {
            this.maxScore = maxScore;
        }

        private int minScore;
        private int maxScore;
        private Integer role;
        private String desc;
        RiskAssessmentEnum(int minScore, int maxScore,Integer role, String desc) {
            this.minScore = minScore;
            this.maxScore = maxScore;
            this.role = role;
            this.desc = desc;
        }
    }
    public static String getRiskAssessment(int level){
        RiskAssessmentEnum[] values = RiskAssessmentEnum.values();
        for (RiskAssessmentEnum riskAssessmentEnum:values){
            if (riskAssessmentEnum.getRole().intValue()==level){
                return riskAssessmentEnum.getDesc();
            }
        }
        return "";
    }

    public static RiskAssessmentEnum getRiskAssessmentByScore(int score){
        RiskAssessmentEnum[] values = RiskAssessmentEnum.values();
        for (RiskAssessmentEnum riskAssessmentEnum:values){
            if (riskAssessmentEnum.getMinScore() <= score && score <= riskAssessmentEnum.getMaxScore()   ){
                return riskAssessmentEnum;
            }
        }
        return null;
    }
}
