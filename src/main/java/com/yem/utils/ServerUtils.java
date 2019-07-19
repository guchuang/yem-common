package com.yem.utils;

/**
 * 服务地址
 * date: 2019年7月11日 下午4:43:00 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */
public class ServerUtils {
	public static final String YEM_BASE = "yem-base";
	
	public static final String YEM_SHOP = "yem-shop";
	
	public static final String YEM_MEMBER = "yem-member";
	
	public static final String YEM_SUBSCRIBE = "yem-subscribe";
	
	public static final String YEM_USER = "yem-user";
	
	public static final String YEM_SERVER = "yem-server";

	public class MemberServer {

		public static final String QUERY_PATH = "/member/query";
		
		public static final String LIST_PATH = "/member/list";
		
		public static final String ADD_PATH = "/member/add";
		
	}

	public class BaseServer {

		public static final String MCCODE_PATH = "/base/mcCode";
		
	}
}
