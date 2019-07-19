package com.yem.exception;

import com.yem.constant.Constants;

/**
 * 系统异常
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2019年7月17日 上午11:01:16 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */
public class SystemException extends BaseException{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 3598012473049395992L;


	public SystemException(String message) {
		super(Constants.RESP_ERR_CODE, message);
	}

}
