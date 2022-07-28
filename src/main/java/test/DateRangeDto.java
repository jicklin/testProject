package test;

import java.io.Serializable;

/**
 *
 * @author 18048422
 */
public class DateRangeDto implements Serializable {
	/**
	 * 模板输入框左侧内容
	 */
	private String leftStr;

	/**
	 * 输入框右侧内容
	 */
	private String rightStr;

	/**
	 * 输入框中间内容
	 */
	private String connectStr;

	/**
	 * 输入值最小
	 */
	private Integer min;

	/**
	 * 输入值最大值
	 */
	private Integer max;

	/**
	 * 报文模板
	 */
	private String sqlTemp;

	public String getLeftStr() {
		return leftStr;
	}

	public void setLeftStr(String leftStr) {
		this.leftStr = leftStr;
	}

	public String getRightStr() {
		return rightStr;
	}

	public void setRightStr(String rightStr) {
		this.rightStr = rightStr;
	}

	public String getConnectStr() {
		return connectStr;
	}

	public void setConnectStr(String connectStr) {
		this.connectStr = connectStr;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public String getSqlTemp() {
		return sqlTemp;
	}

	public void setSqlTemp(String sqlTemp) {
		this.sqlTemp = sqlTemp;
	}

	@Override
	public String toString() {
		return "DateRangeDto{" +
				"leftStr='" + leftStr + '\'' +
				", rightStr='" + rightStr + '\'' +
				", connectStr='" + connectStr + '\'' +
				", min=" + min +
				", max=" + max +
				", sqlTemp='" + sqlTemp + '\'' +
				'}';
	}
}
