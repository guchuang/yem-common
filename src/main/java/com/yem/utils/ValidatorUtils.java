package com.yem.utils;

import java.math.BigInteger;

/**
 * 校验器：利用正则表达式校验邮箱、手机号等  
 * @author hdq
 *
 */
public class ValidatorUtils {
	
	/**  
     * 正则表达式：验证用户名  
     */  
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{2,20}$";  
        
    /**  
     * 正则表达式：验证密码  
     */  
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";  
    
    /**  
     * 正则表达式：验证手机号  
     */  
    public static final String REGEX_MOBILE = "^1\\d{10}$";  
    
    /**  
	 * 正则表达式：验证固定电话
	 */
	public static final String REGEX_PHONE = "^0\\d{2,3}-[1-9]\\d{6,7}$";
      
    /**  
     * 正则表达式：验证邮箱  
     */  
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
    
    /**  
     * 正则表达式：验证汉字  
     */  
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";  
    
    /**  
     * 正则表达式：验证身份证  
     */  
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)(^\\d{17}X$)";  
    
    /**  
     * 正则表达式：验证URL  
     */  
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";  
    
    /**  
     * 正则表达式：验证IP地址  
     */  
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";  
    
    /**  
     * 正则表达式：验证图片参数  
     */  
    public static final String REGEX_IMG_URL = "^.*_[1-9]\\d*x[1-9]\\d*.jpg$";  
    
    /**  
     * 正则表达式：验证数字参数  
     */  
    public static final String REGEX_NUMBER = "^[0-9]*$";  
    
    /**  
     * 正则表达式：验证数字参数 ,正小数，最多两位小数
     */  
    public static final String REGEX_DECIMAL = "^([0]\\.\\d{1,2}|[1-9][0-9]*\\.\\d{1,2})$";
    
    /**  
     * 正则表达式：验证时间格式yyyy-MM-dd HH:mm:ss
     */  
    public static final String REGEX_TIME = "(((01[0-9]{2}|0[2-9][0-9]{2}|[1-9][0-9]{3})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|((01[0-9]{2}|0[2-9][0-9]{2}|[1-9][0-9]{3})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|((01[0-9]{2}|0[2-9][0-9]{2}|[1-9][0-9]{3})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((04|08|12|16|[2468][048]|[3579][26])00))-0?2-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d";
    
    /**  
     * pageSize 最大50
     */ 
    public static final int pageSize = 50;
    
    /**
	 * 默认分页条数
	 */
	public static final String PAGESIZE = "10";
	
	/**
	 * 默认分页条数 最大
	 */
	public static final String PAGESIZEMAX = "50";
	
	/**
	 * 默认查询页数
	 */
	public static final int PAGENO = 1;
	
	/**  
	 * 正则表达式：验证pageNo
	 */
	public static final String REGEX_PAGENO = "^[0-9]*[1-9][0-9]*$";
	
	/**
	 * 加密类型  RSA SHA256 3DES
	 */
	public static final String ENCRYT_PWD_TYPE = "(RSA)|(SHA256)|(3DES)";
    
    /**  
     * 正则表达式：验证手机验证码
     */ 
    public static final String REGEX_AUTHCODE = "^\\d{6}$";
    
    /**  
     * 正则表达式：验证pageSize 最大50
     */  
    public static final String REGEX_PAGESIZE = "^([1-4]?\\d|50)$";
    
	/**  
	 * 正则表达式：验证固定电话
	 */
//	public static final String REGEX_PHONE = "^0\\d{2,3}-[1-9]\\d{6,7}$";
    
	/**
	 * 正则表达式：验证经度
	 */
	public static final String REGEX_LONGITUDE = "^(((((\\d{1,2}|1[0-7]\\d{1}))[°](0*?[0-5]?\\d{1}['])?)|(180[°](0*?[']?+)??)))[EW]$";
	/**
	 * 正则表达式：验证纬度
	 */
	public static final String REGEX_LATITUDE = "^(0*?((([0-8]??\\d{1}))[°](0*?[0-5]?\\d{1}['])|(90[°]((0*+)[']?+)?+))?)[NS]$";

	/**
	 * 	出生日期
	 */
	public static final String REGEX_BIRTHDAY = "^(19|20)\\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$";
    
	/**
	 * 正则表达式：验证时间格式yyyyMMddHHmmss
	 */
	public static final String REGEX_DATE_YYYYMMDDHHMMSS = "^(\\d{4}((0[1-9]{1})|(1[0-2]{1}))([0-2]{1}\\d{1}|30|31)(20|21|22|23|[0-1]\\d)[0-5]\\d[0-5]\\d)$";
	
	/**  
     * 校验用户名  
     *   
     * @param username  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isUsername(String p) {  
        return p.matches(REGEX_USERNAME);  
    }  
    
      
    public static boolean isImgParameter(String p)  
    {  
        return p.matches(REGEX_IMG_URL);  
          
    }  
    /**  
     * 校验密码  
     *   
     * @param password  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isPassword(String p) {  
        return p.matches(REGEX_PASSWORD);  
    }  
    
    /**  
     * 校验手机号  
     *   
     * @param mobile  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isMobile(String p) {  
        return p.matches(REGEX_MOBILE);  
    }  
    
    /**  
     * 校验邮箱  
     *   
     * @param email  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isEmail(String p) {  
        return p.matches(REGEX_EMAIL);  
    }  
    
    /**  
     * 校验汉字  
     *   
     * @param chinese  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isChinese(String p) {  
        return p.matches(REGEX_CHINESE);  
    }  
    
    /**  
     * 校验身份证  
     *   
     * @param idCard  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isIDCard(String p) {  
        return p.matches(REGEX_ID_CARD);  
    }  
    
    /**  
     * 校验URL  
     *   
     * @param url  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isUrl(String p) {  
        return p.matches(REGEX_URL);  
    }    
	
    /**  
     * 校验数字和长度   0和正整数
     * @param String 字符串,int 长度
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isNumber(String p,int length) {  
        boolean flag = p.matches(REGEX_NUMBER);  
        
        boolean lengFlag = p.length()<=length;
        
        if(flag&&lengFlag){
        	return true;
        }else{
        	return false;
        }
    }  
    
    /**  
     * 校验数字和长度   正整数
     * @param String 字符串,int 长度
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isPositiveInteger(String p,int length) {  
        boolean flag = p.matches(REGEX_NUMBER);  
        if(!flag){
        	return false;
        }
        boolean lengFlag = p.length()<=length;
        
        BigInteger number = new BigInteger(p);
        
        BigInteger result = new BigInteger("0");
        
        boolean intFlag = number.compareTo(result)>0;
        
        if(lengFlag&&intFlag){
        	return true;
        }else{
        	return false;
        }
        
    }  
    
    /**  
     * 校验正小数，最多保留两位和长度
     * @param String 字符串,int 长度
     * @return 校验通过返回true，否则返回false  
     */  
    /*public static boolean isDecimal(String p,int length) {  
        boolean flag = p.matches(REGEX_DECIMAL);  
        
        String integer = StringUtils.substringBefore(p, ".");
        
        boolean lengFlag = integer.length()<=length;
        
        if(flag&&lengFlag){
        	return true;
        }else{
        	return false;
        }
    }  */
    
    /**  
     * 校验时间格式yyyy-MM-dd HH:mm:ss
     * @param time  
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isTime(String p) { 
    	return p.matches(REGEX_TIME);
    }  
    
    /*public static void main(String[] args) {
    	String s = "";
    	int b = 1;
		int a = StringUtils.isBlank(s)?b:Integer.parseInt(s);
		System.out.println(a);
		
	}*/
    
    /**  
     * 校验手机验证码
     * @param String 6位数字
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isAuthCode(String p) {  
        boolean flag = p.matches(REGEX_NUMBER);  
        
        boolean lengFlag = p.length()==6;
        
        if(flag&&lengFlag){
        	return true;
        }else{
        	return false;
        }
    }  
    
    /**  
     * 校验手机验证码
     * @param String 6位数字
     * @return 校验通过返回true，否则返回false  
     */  
    public static boolean isPageSize(String p) {  
        boolean flag = p.matches(REGEX_NUMBER);  
        
        boolean lengFlag = p.length()<=2;
        
        if(!flag){
        	return false;
        }
        
        int num = Integer.parseInt(p);
        
        if(lengFlag&&num<=pageSize){
        	return true;
        }else{
        	return false;
        }
        
    }

}
