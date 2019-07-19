
package com.yem.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 逻辑、功能相关描述:验证对象空值，字符串零长，集合无元素
 * date: 2019年7月5日 上午10:30:17 <br/>
 *
 * @author <a href="mailto:hbszguchuang@163.com">guchuang</a>
 * @version 
 * @since JDK 1.8
 */
public class BizValidate {

	private static BizData check;

	public BizValidate() {
		super();
	}

	// 解析的入口
	public static String valid(Object object) throws Exception {
		String resultString = "";
		if (object == null)
			return "无法校验空对象";
		// 获取object的类型
		Class<? extends Object> clazz = object.getClass();
		// 获取该类型声明的成员
		Field[] fields = clazz.getDeclaredFields();

		// 遍历属性
		for (Field field : fields) {
			// 对于private私有化的成员变量，通过setAccessible来修改器访问权限
			field.setAccessible(true);
			// 如果存在atLeastOneNotNullFlag，则不在本函数做该字段的校验
			check = field.getAnnotation(BizData.class);

			if (check == null) {
				continue;
			}
			// 如果多选一且存在优先级的情况下，只校验最优先的字段
			/*if (StringUtils.isEmpty(check.atLeastOneNotNullFlag()) && check.priority() > 0) {
				continue;
			}*/
			resultString = resultString.concat(validate(field, object));
			// 重新设置会私有权限
			field.setAccessible(false);
		}

		if (!"".equals(resultString))
			return resultString;

//		resultString = checkPermission(clazz, object);

//		resultString = resultString.concat(validateAtLeastOneNotNull(fields, object));
		return resultString;
	}

	/*
	 * 用于验证多个参数至少有一个不能为空。
	 */
	/*private static String validateAtLeastOneNotNull(Field[] fields, Object object) throws Exception {
		final int EXIT_ALL_NULL = 0;
		final int EXIT_ONE_NOT_NULL = 1;
		final String GAP = "; ";
		final String DESCRIPTION_GAP = ",";
		// 用于存放atLeastOneNotNullFlag对应的状态值
		Map<String, Integer> stateMap = new HashMap<String, Integer>(4);
		// 用于存放atLeastOneNotNullFlag对应的字段集合。
		Map<String, String> descriptionMap = new HashMap<String, String>(4);
		// 用于存放atLeastOneNotNullFlag对应的field集合。
		Map<String, Map<Integer, Field>> fieldMap = new HashMap<String, Map<Integer, Field>>();
		String resultString = " ";

		for (Field field : fields) {
			Object value;
			// 对于private私有化的成员变量，通过setAccessible来修改器访问权限
			field.setAccessible(true);
			BizData BizData = field.getAnnotation(BizData.class);
			// 当BizData不存在的时候继续查看下一个field
			if (BizData == null)
				continue;
			value = field.get(object);
			String flag = BizData.atLeastOneNotNullFlag();
			String description = BizData.description().equals("") ? field.getName()
					: BizData.description().concat(field.getName());

			if (!StringUtils.isBlank(flag)) {
				
				 * //在没有得到EXIT_ONE_NOT_NULL之前，对该field进行校验 if(stateMap.get(flag) == null ||
				 * stateMap.get(flag) != EXIT_ONE_NOT_NULL) { if(isEmpty(value)) {
				 * resultString = resultString.concat(validate(field,object)); } }
				 
				// 如果stateMap存在该flag：
				// 1.该flag对应状态值为EXIT_ONE_NOT_NULL，则不做修改。
				// 2。该flag对应状态值为EXIT_ALL_NULL，则根据value是否为空来判断其状态值。
				if (stateMap.containsKey(flag)) {
					if (stateMap.get(flag) == EXIT_ALL_NULL) {
						stateMap.put(flag, isEmpty(value) ? EXIT_ONE_NOT_NULL : EXIT_ALL_NULL);
					}
					descriptionMap.put(flag, descriptionMap.get(flag) + DESCRIPTION_GAP + description);
				} else {// 如果stateMap不存在该flag，则把该flag添加进stateMap
					stateMap.put(flag, isEmpty(value) ? EXIT_ONE_NOT_NULL : EXIT_ALL_NULL);
					descriptionMap.put(flag, description);
				}
				// 存放flag对应的Field。
				if (BizData.priority() > 0) {
					Map<Integer, Field> map = null;
					if (fieldMap.containsKey(flag)) {
						map = fieldMap.get(flag);
					} else {
						map = new HashMap<Integer, Field>();
					}
					map.put(BizData.priority(), field);
					fieldMap.put(flag, map);
				}
			}
			// 重新设置会私有权限
			field.setAccessible(false);
		}
		// 遍历stateMap，查看是否仍有状态值为EXIT_ALL_NULL的。
		for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
			if (entry.getValue() == EXIT_ALL_NULL) {
				resultString = resultString.concat(descriptionMap.get(entry.getKey()) + "至少一个不能为空").concat(GAP);
			} else {
				// 校验优先级最高字段。
				if (fieldMap.containsKey(entry.getKey())) {
					Map<Integer, Field> map = fieldMap.get(entry.getKey());
					Integer[] priorities = map.keySet().toArray(new Integer[] {});
					Arrays.sort(priorities);
					for (Integer priority : priorities) {
						if (priority > 0) {
							Field field = map.get(priority);
							field.setAccessible(true);
							Object value = field.get(object);
							if (isEmpty(value)) {
								resultString = resultString.concat(validate(field, object));
								field.setAccessible(false);
								break;
							}
							field.setAccessible(false);
						}
					}
				}
			}
		}
		return resultString;
	}*/

	/*
	 * 该判断主要针对字符串，对于int类型都有默认值0，暂不加入
	 */
	private static boolean isEmpty(Object value) {
		return value != null && !StringUtils.isEmpty(value.toString());
	}

	public static String validate(Field field, Object object) throws Exception {
		String resultString = "";
		String description;
		Object value;

		// 获取对象的成员的注解信息
		check = field.getAnnotation(BizData.class);
		value = field.get(object);

		if (check == null) {
			return resultString;
		}

		// 校验filed为List
		if (check.supportList() && value != null && value instanceof List) {
			List<Object> list = (List<Object>) value;
			if (!list.isEmpty()) {
				BizData tempCheck = check; // 暂存check
				for (Object ob : list) {
					String listResult = valid(ob);
					if (StringUtils.isEmpty(listResult)) {
						return resultString.concat(listResult);
					}
				}
				check = tempCheck; // 还原check
			}
		}

		description = check.description().equals("") ? field.getName() : check.description().concat(field.getName());

		/************* 基础注解解析工作开始 ******************/
		if (check.isNotNull() && (value == null || StringUtils.isEmpty(value.toString()))) {
			return resultString.concat(description + "不能为空;");
		}

		if (null != value && StringUtils.isEmpty(value.toString()) && value.toString().length() > check.maxLength()
				&& check.maxLength() != 0) {
			return resultString.concat(description + "长度不能超过" + check.maxLength() + ";");

		}

		if (null != value && StringUtils.isEmpty(value.toString()) && value.toString().length() < check.minLength()
				&& check.minLength() != 0) {
			return resultString.concat(description + "长度不能小于" + check.minLength() + ";");
		}

		if (null != value && StringUtils.isEmpty(value.toString()) && check.fixLength() != 0
				&& check.fixLength() != value.toString().length()) {
			return resultString.concat(description + "长度必须为" + check.fixLength() + ";");
		}

		if (null != value && StringUtils.isEmpty(value.toString()) && !check.regexExpression().equals("")
				&& !value.toString().matches(check.regexExpression())) {
			return resultString.concat(description + "格式不正确;");
		}

		/************* 基础注解解析工作结束 ******************/
		return resultString;
	}
/*
	public static String checkPermission(Class<?> clazz, Object target) throws Exception {
		checkPermission = (CheckUserPermission) clazz.getAnnotation(CheckUserPermission.class);
		if (checkPermission == null)
			return "";

		log.info(checkPermission.description());

		String[] params = checkPermission.params();
		int[] userType = checkPermission.userType();
		String belongTo = checkPermission.belongTo();

		for (int i = 0; i < params.length; ++i) {
			String param = params[i];
			String methodName = "get".concat(upperFirstLetter(param));
			Method method = clazz.getMethod(methodName);
			String uncheckedUser = (String) method.invoke(target);
			if (StringUtils.isBlank(uncheckedUser)) {
				continue;
			}

			switch (userType[i]) {
			case 0:
				// 校验操作是否属于某个商户
				if (StringUtils.isEmpty(belongTo)) {
					String uncheckedMct = (String) clazz.getMethod("get".concat(upperFirstLetter(belongTo)))
							.invoke(target);
					if (self.permissionService.getMctByCode(uncheckedMct) == null) {
						return "该商户不存在";
					}
					if (StringUtils.isEmpty(belongTo)
							&& !self.permissionService.isMctUserBelongTo(uncheckedUser, uncheckedMct))
						return "操作员不属于这个商户";
				}
				// 校验操作员权限
				return self.permissionService.checkPermission(uncheckedUser, checkPermission.operType()) ? "" : "权限不足";
			case 1:
				return self.permissionService.checkSysPermission(uncheckedUser, checkPermission.operType()) ? ""
						: "权限不足";
			default:
				return "权限不足";
			}
		}
		return "";
	}

	private static String upperFirstLetter(String str) {
		return str.substring(0, 1).toUpperCase().concat(str.substring(1));
	}*/
}
