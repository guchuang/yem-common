package com.yem.constant;

import java.io.Serializable;

/**
 * 公共请求返回码
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2019年7月5日 上午10:34:06 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */
public class Constants implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 8309039587824475319L;

	public static final String RESP_SUC_CODE = "0000";

	public static final String RESP_ERR_CODE = "9999";
	
	public static final String RESP_BIZ_ERR_CODE = "2000";
	
	public static final String RESP_PARAM_ERR_CODE = "1000";

	public static final String RESP_SUC_MSG = "成功";

	public static final String RESP_ERR_MSG = "系统错误";
	
	public static final String RESP_BIZ_ERR_MSG = "业务错误";
	
	public static final String RESP_PARAM_ERR_MSG = "参数错误";
	
	public static final String CHECK_TRUE = "1";
	
	public class MemberMsg extends Constants {

		/**
		 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.8
		 */
		private static final long serialVersionUID = -7119128842325657795L;
		
		public static final String MEMBER_ADD_ERROR = "新增会员失败";
		
		public static final String MEMBER_MODIFY_ERROR = "修改会员失败";
	}
	
	public class UserMsg extends Constants {

		/**
		 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.8
		 */
		private static final long serialVersionUID = -7119128842325657795L;
		
		public static final String USER_ADD_ERROR = "新增用户失败";
		
		public static final String USER_MODIFY_ERROR = "修改用户失败";
	}
	
	public class RoleMsg extends Constants {

		/**
		 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.8
		 */
		private static final long serialVersionUID = -7119128842325657795L;
		
		public static final String ROLE_ADD_ERROR = "新增角色失败";
		
		public static final String ROLE_MODIFY_ERROR = "修改角色失败";
	}
	
	public class PermissionMsg extends Constants {

		/**
		 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.8
		 */
		private static final long serialVersionUID = -7119128842325657795L;
		
		public static final String PERMISSION_ADD_ERROR = "新增权限失败";
		
		public static final String PERMISSION_MODIFY_ERROR = "修改权限失败";
	}
	
	public class ServerMsg extends Constants {

		/**
		 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.8
		 */
		private static final long serialVersionUID = -7119128842325657795L;
		
		public static final String SERVER_ADD_ERROR = "新增服务失败";
		
		public static final String SERVER_MODIFY_ERROR = "修改服务失败";
	}
	
	public class ShopMsg extends Constants {

		/**
		 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.8
		 */
		private static final long serialVersionUID = -7119128842325657795L;
		
		public static final String SHOP_ADD_ERROR = "新增门店失败";
		
		public static final String SHOP_MODIFY_ERROR = "修改门店失败";
	}
	
	public class SubscribeMsg extends Constants {

		/**
		 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.8
		 */
		private static final long serialVersionUID = -7119128842325657795L;
		
		public static final String SUBSCRIBE_ADD_ERROR = "新增预约失败";
		
		public static final String SUBSCRIBE_MODIFY_ERROR = "修改预约失败";
	}
}
