package com.yem.constant;

import java.io.Serializable;

/**
 * 接口API
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2019年7月5日 上午10:34:06 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */
public class ApiConstant implements Serializable {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = -1451703706405472925L;

	public static final String YEM = "/yem";

    public static final String YEM_USER = YEM + "/user";

    public static final String YEM_ROLE = YEM + "/role";

    public static final String YEM_MENU = YEM + "/menu";

    public static final String VIEW = "/view";
    
    public static final String API_HEADER_ACT = "act_code";
}
