
package com.yem.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求字段注解
 * date: 2019年7月5日 上午10:30:17 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */

@Target({ElementType.FIELD}) //注解应用类型

@Retention(RetentionPolicy.RUNTIME)
public @interface BizData{
	//是否可以为空
    boolean isNotNull() default true;
     
    //最大长度
    int maxLength() default 0;
     
    //最小长度
    int minLength() default 0;
    
    //固定长度
	int fixLength() default 0;
     
    //自定义正则验证
    String regexExpression() default "";
     
    //参数或者字段描述, 这样能够显示友好的异常信息
    String description() default "";
    
    // 当该字段为List时且需要对List的每个节点进行校验，可以注明该注解为true即可。
    boolean supportList() default false;
}
