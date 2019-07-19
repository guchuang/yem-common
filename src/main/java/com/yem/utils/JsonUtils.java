package com.yem.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.yem.exception.BaseException;
import com.yem.exception.SystemException;

import lombok.extern.slf4j.Slf4j;

/**
 * json处理
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2019年7月17日 上午10:35:38 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */
@Slf4j
public class JsonUtils {
	public static void sendJsonMessage(HttpServletResponse response, Object map) throws BaseException {
		PrintWriter printWriter = null;

		response.setContentType("application/json; charset=utf-8");
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			log.error("流处理异常");
			throw new SystemException("流处理异常");
		}
		printWriter.write(JSONObject.toJSONString(map));
		printWriter.close();
		
		try {
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
