package cairh.community.api.point.common;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * <p>
 * Title: 常量列表类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: hundsun
 * </p>
 * 
 * @author 駱嘉偉
 * @version 1.0
 */

public class ConstantList {

	public static List<HashMap<String, String>> bankVerifyList;// 验证银行列表

	static {
		//初始化验证银行列表
		setBankVerifyList();
	}

	public static List<HashMap<String, String>> getBankVerifyList() {
		return bankVerifyList;
	}

	public static void setBankVerifyList() {

		List<HashMap<String, String>> bankVerifyList = new ArrayList<HashMap<String, String>>();

		try {

			SAXReader reader = new SAXReader();
			String xmlPath = Thread.currentThread().getContextClassLoader()
					.getResource("/").getPath()
					+ "bankVerify.xml";

			Document document = reader.read(new File(xmlPath));
			Element root = document.getRootElement();
			Iterator<Element> bankList = root.elementIterator("bank");

			while (bankList.hasNext()) {

				HashMap<String, String> map = new HashMap<String, String>();

				Element bankInfo = bankList.next();

				// 银行编号
				String bankNo = bankInfo.attributeValue("bankNo", "");
				// 银行名称
				String bankName = bankInfo.attributeValue("bankName", "");
				// 认证网银端银行ID
				String verifyBankId = bankInfo.attributeValue("verifyBankId",
						"");
				// 绑定方式 【1：网银页面；2：银联页面；3：电话验密；0：暂不支持】
				String bindingStyle = bankInfo.attributeValue("bindingStyle",
						"");
				// 银行图片
				String icon = bankInfo.attributeValue("icon", "");
				// 银行类型
				String bankType = bankInfo.attributeValue("bankType", "");
				// 电话服务
				String phone = bankInfo.attributeValue("phone", "");
				// 开通无卡支付业务地址
				String openUrl = bankInfo.attributeValue("openUrl", "");
				// 控件下载 地址
				String downLoadUrl = bankInfo.attributeValue("downLoadUrl", "");

				map.put("bankNo", bankNo);
				map.put("bankName", bankName);
				map.put("verifyBankId", verifyBankId);
				map.put("bindingStyle", bindingStyle);
				map.put("icon", icon);
				map.put("bankType", bankType);
				map.put("phone", phone);
				map.put("openUrl", openUrl);
				map.put("downLoadUrl", downLoadUrl);

				bankVerifyList.add(map);
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConstantList.bankVerifyList = bankVerifyList;
	}
}
