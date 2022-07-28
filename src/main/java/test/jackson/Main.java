package test.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String msg = "{" +
				"  \"code\": 0," +
				"  \"msg\": \"成功\"," +
				"  \"data\": {" +
				"    \"total\": 37," +
				"    \"pageNum\": 1," +
				"    \"pageSize\": 10," +
				"    \"rows\": [" +
				"      {" +
				"        \"id\": 92," +
				"        \"version\": 9," +
				"        \"createTime\": \"2020-09-04 16:30:00\"," +
				"        \"updateTime\": \"2019-12-09 00:04:16\"," +
				"        \"valid\": false," +
				"        \"operId\": 0," +
				"        \"operName\": \"system\"," +
				"        \"outTradeNo\": \"939e81dad5c1419bb8d46d719cfadd64\"," +
				"        \"requestCode\": \"Success\"," +
				"        \"rechargeStatus\": \"未到账\"," +
				"        \"payStatus\": \"未到账\"," +
				"        \"userType\": \"借款人\"," +
				"        \"userNo\": 100013112393," +
				"        \"userName\": \"auto_章幻眺\"," +
				"        \"accountNo\": \"BA00000334012\"," +
				"        \"appid\": \"wxa995e1ea94c6e562\"," +
				"        \"mchId\": \"1500782841\"," +
				"        \"deviceInfo\": \"WEB\"," +
				"        \"nonceStr\": \"87d8968631914ab59e97c14380ebec86\"," +
				"        \"sign\": \"01615976E3A937A7A40731A630E0044F\"," +
				"        \"signType\": null," +
				"        \"body\": \"华博金服\"," +
				"        \"detail\": \"还款\"," +
				"        \"attach\": null," +
				"        \"ccyCode\": null," +
				"        \"totalFee\": 76.88," +
				"        \"spbillIp\": null," +
				"        \"timeStart\": \"20200904163000\"," +
				"        \"timeExpire\": \"20200904163200\"," +
				"        \"goodsTag\": null," +
				"        \"notifyUrl\": \"http://wxhbjf.hbfintech.com/api/wx-pay-notify\"," +
				"        \"prepayId\": \"wx2020090416303791311979282502226291\"," +
				"        \"tradeType\": \"JSAPI\"," +
				"        \"productId\": \"200082540891\"," +
				"        \"limitPay\": null," +
				"        \"openid\": null," +
				"        \"sceneInfo\": null," +
				"        \"productType\": \"7\"," +
				"        \"repayRecordType\": 0," +
				"        \"telephone\": \"13857842865\"," +
				"        \"idNum\": \"320412200409133799\"," +
				"        \"remark\": \"单期还款额：76.88\"," +
				"        \"period\": 2," +
				"        \"operType\": \"系统\"," +
				"        \"serialNo\": \"385216774409249\"" +
				"      }" +
				"    ]" +
				"  }" +
				"}";

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			GenericsResponseBodyBean<PageBean<WeixinRepayOrderDto>> o = objectMapper.readValue(msg, new TypeReference<GenericsResponseBodyBean<PageBean<WeixinRepayOrderDto>>>() {

			});
			System.out.println(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
