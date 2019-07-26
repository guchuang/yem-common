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

		public static final String PERMISSION_GET_PATH = "/permission/query";

		public static final String PERMISSION_LIST_PATH = "/permission/list";

		public static final String PERMISSION_ADD_PATH = "/permission/add";

		public static final String PERMISSION_EDIT_PATH = "/permission/modify";


		public static final String ROLE_GET_PATH = "/role/query";

		public static final String ROLE_LIST_PATH = "/role/list";

		public static final String ROLE_ADD_PATH = "/role/add";

		public static final String ROLE_EDIT_PATH = "/role/modify";


		public static final String USER_GET_PATH = "/user/query";

		public static final String USER_LIST_PATH = "/user/list";

		public static final String USER_ADD_PATH = "/user/add";

		public static final String USER_EDIT_PATH = "/user/modify";


		public static final String SERVER_GET_PATH = "/server/query";

		public static final String SERVER_LIST_PATH = "/server/list";

		public static final String SERVER_ADD_PATH = "/server/add";

		public static final String SERVER_EDIT_PATH = "/server/modify";


		public static final String SHOP_GET_PATH = "/shop/query";

		public static final String SHOP_LIST_PATH = "/shop/list";

		public static final String SHOP_ADD_PATH = "/shop/add";

		public static final String SHOP_EDIT_PATH = "/shop/modify";


		public static final String SUBSCRIBE_GET_PATH = "/suscribe/query";

		public static final String SUBSCRIBE_LIST_PATH = "/suscribe/list";

		public static final String SUBSCRIBE_ADD_PATH = "/suscribe/add";

		public static final String SUBSCRIBE_EDIT_PATH = "/suscribe/modify";
		
	}
}
