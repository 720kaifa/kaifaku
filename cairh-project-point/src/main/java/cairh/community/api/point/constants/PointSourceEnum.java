package cairh.community.api.point.constants;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wanghh<br>
 * 开发时间: 2015年11月23日<br>
 */
public enum PointSourceEnum {
	
	POINT_1("B-01-001","会员注册"),
	POINT_2("B-01-002","首次签到"),
	POINT_3("B-01-003","连续签到第1-5天"),
	POINT_4("B-01-004","连续签到第6-15天"),
	POINT_5("B-01-005","连续签到第16-30天"),
	POINT_6("B-01-006","连续签到31天以上"),
	POINT_7("B-02-001","历史积分"),
	POINT_8("B-02-002"	,"首次参与游戏奖励"),
	POINT_9("B-02-003"	,"参与奖励"),
	POINT_10("A-01-001"	,"彩虹金币历史积分"),
	POINT_11("A-01-002"	,"交易贡献"),
	POINT_12("C-01-001"	,"首次开户成功"),
	POINT_13("C-02-001"	,"首次入金10万以下"),
	POINT_14("C-02-002"	,"首次入金10万-100万"),
	POINT_15("C-02-003"	,"首次入金100万-1000万"),
	POINT_16("C-02-004"	,"首次入金1000万及以上"),
	POINT_17("C-03-001"	,"首次交易"),
	POINT_18("C-03-002"	,"交易金额首次达1万"),
	POINT_19("C-03-003"	,"交易金额首次达100万"),
	POINT_20("C-03-004"	,"交易金额首次达1000万"),
	POINT_21("C-03-005"	,"交易金额首次达1亿"),
	POINT_22("C-05-001"	,"首次绑定手机号"),
	POINT_23("C-05-002"	,"首次绑定资金账号"),
	POINT_24("N-01-001"	,"调账管理"),
	POINT_25("N-01-002"	,"商品兑换"	),
	POINT_26("N-01-003"	,"大转盘扣50"	),
	POINT_27("B-02-005"	,"猜涨跌得分"	),
	POINT_28("N-01-004" ,"猜涨跌沉淀返还积分"	),
	POINT_29("N-01-005"	,"大转盘得分"	),
	POINT_30("B-02-006"	,"猜涨跌押注"	),
	POINT_31("B-02-007"	,"猜涨跌每日奖励积分消耗"	),
	POINT_32("x-99-999"	,"发货失败，返回积分"	),
;
   /* POINT_SOURCE_SIGN0("B-01-002-001","用户首次签到"),
    POINT_SOURCE_SIGN1("B-01-002-002","用户连续签到2-5天"),
    POINT_SOURCE_SIGN2("B-01-002-003","用户连续签到6-15天"),
    POINT_SOURCE_SIGN3("B-01-002-004","用户连续签到16-30天"),
    POINT_SOURCE_SIGN4("B-01-002-005","用户连续签到31天以上"),
    PRODUCT_TYPE_NOT_PHYSICAL("B-09-001","充值卡兑换"),
    CODE_PRODUCT_BUY("B-10-001","积分兑换实物"),
    POINT_SOURCE_LOTTERY("B-08-001","积分抽奖"),
    
    POINT_SOURCE_KL("0013","口令活动"),
    POINT_SOURCE_TGPL("0014","投顾评论"),
  
    POINT_SOURCE_POINT_EXCHANGEL("1002","积分兑换"),
    POINT_SOURCE_BET("0016","押注高手"),
    POINT_SOURCE_BET_INCHARGE("0007","押中高手"),
    POINT_SOURCE_REGISTER("0001","注册"),
    POINT_SOURCE_OPEN("0006","开户"),
    POINT_SOURCE_JHCK("0035","建行存管"),
    POINT_SOURCE_GUESS("B-02-004","猜涨跌押注"),
    POINT_SOURCE_GUESS_GET("B-02-005","猜涨跌得分"),
    POINT_SOURCE_GUESS_SUCCESS("0009","猜涨跌成功"),
    POINT_SOURCE_MASKED_GUESS("0070","蒙面竞猜"),
    POINT_SOURCE_MASKED_GUESS_SUCCESS("0071","蒙面竞猜成功"),
    POINT_SOURCE_LUCK("0019","小积分行大运"),

    ;*/

    private String sourceCode;

    private String sourceName;

    PointSourceEnum(String sourceCode, String sourceName) {
        this.setSourceCode(sourceCode);
        this.sourceName = sourceName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

}
