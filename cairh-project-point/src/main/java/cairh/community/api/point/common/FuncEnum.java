package cairh.community.api.point.common;

import java.util.Date;

/**
 * 功能号枚举类
 * Created by duanxq on 2016/11/10.
 */
public enum FuncEnum {

    CRH_CM1001("CRH-CM1001","查询用户基本信息"),
    CRH_CM1002("CRH-CM1002","查询用户动态信息"),
    CRH_CM1003("CRH-CM1003","提交个人资料修改申请"),
    CRH_CM1004("CRH-CM1004","消息提醒设置"),
    CRH_CM1005("CRH-CM1005","查询赞我的和我赞的列表信息"),
    CRH_CM1007("CRH-CM1007","我的观点列表"),
    CRH_CM1008("CRH-CM1008","查询我的评论的列表信息"),
    CRH_CM1009("CRH-CM1009","获取个股或资讯观点列表"),
    CRH_CM1010("CRH-CM1010","个股或资讯观点列表评论情况"),
    CRH_CM1011("CRH-CM1011","对咨询提交个人观点"),
    CRH_CM1012("CRH-CM1012","对观点或评论发表评论"),
    CRH_CM1013("CRH-CM1013","对观点或评论点赞"),
    CRH_CM1014("CRH-CM1014","对观点或评论举报"),
    CRH_CM1015("CRH-CM1015","忽略我发出的观点"),
    CRH_CM1016("CRH-CM1016","忽略我收到的赞或评论"),
    CRH_CM1017("CRH-CM1017","忽略我发出的赞或评论"),
    CRH_CM1018("CRH-CM1018","更新未读的赞或未读的评论的数量"),
    CRH_CM1019("CRH-CM1019","获取资讯信息"),
    CRH_CM1020("CRH-CM1020","根据accountId获取用户信息(第三方)"),
    CRH_CM1021("CRH-CM1021","查询个人主页的观点和评论"),
    CRH_CM1022("CRH-CM1022","根据accountId获取用户信息(本地)"),
    CRH_CM1023("CRH-CM1023","查询交易客户信息"),
    CRH_CM1024("CRH-CM1024","绑定资金账号的用户查询列表 返回资金账号、绑定日期、注册日期 "),
    CRH_CM1025("CRH-CM1025","绑定交易账号并返回   金仕达接口获取用户基本资料信息 "),
    CRH_CM1026("CRH-CM1026","确认绑定交易账号"),
    CRH_CM1027("CRH-CM1027","是否绑定交易账号"),

    CRH_CM1030("CRH-CM1030","分页查询我的观点信息"),
    CRH_CM1031("CRH-CM1031","分页查询我的评论"),
    CRH_CM1032("CRH-CM1032","分页查询我的赞"),
    CRH_CM1033("CRH-CM1033","从审核任务中获取用户信息"),

    CRH_CM1040("CRH-CM1040","更新资讯信息"),
    
    //海通接口
    CRH_CM2001("modify_user_info","修改昵称、头像、个性签名"),
    CRH_CM2003("CRH-CM2003","版本信息检查"),
    //猜涨跌中台接口
    CRH_CM_IN2200("CRH-CM-IN2200","通过TermNos查询GuessTerm list"),
    CRH_CM_IN2201("CRH-CM-IN2201","通过TermNo查询GuessTerm"),
    CRH_CM_IN2202("CRH-CM-IN2202","通过积分代码查询BasePointDefine用户积分定义表"),
    CRH_CM_IN2203("CRH-CM-IN2203","通过UserId查询UserPoint"),
    CRH_CM_IN2204("CRH-CM-IN2204","通过userId和termNo查询GuessStake"),
    CRH_CM_IN2205("CRH-CM-IN2205","保存GuessStake"),
    CRH_CM_IN2206("CRH-CM-IN2206","更新GuessTerm"),
    CRH_CM_IN2207("CRH-CM-IN2207","更新UserPoint"),
    CRH_CM_IN2208("CRH-CM-IN2208","保存UserPointLog"),
    CRH_CM_IN2209("CRH-CM-IN2209","根据userId,startStakeTime, endStakeTime,查询StakeCount"),
    CRH_CM_IN2210("CRH-CM-IN2210","通过(userId, pageNo, pageSize)查询GuessStakeList"),
    CRH_CM_IN2211("CRH-CM-IN2211","查询当前登录用户的押注记录总数量 "),
    CRH_CM_IN2212("CRH-CM-IN2212","根据userId获取我的财富榜信息,成功率,总收益,连胜次数 "),
    CRH_CM_IN2213("CRH-CM-IN2213","获取财富榜列表信息,成功率,总收益,连胜次数 "),
    CRH_CM_IN2214("CRH-CM-IN2214","获取猜涨跌历史记录"),
    CRH_CM_IN2215("CRH-CM-IN2215","获取上次竞猜结果（参加记录最近的一条）"),
    CRH_CM_IN2216("CRH-CM-IN2216","获取K线（分钟级）"),
    CRH_CM_IN2217("CRH-CM-IN2217", "获取K线（5分钟级 交易时间外）"),
    CRH_CM_IN2218("CRH-CM-IN2218", "当日用户游戏压涨压跌统计"),

    //牛人汇接口
    CRH_CM_IN2100("CRH-CM-IN2100","积分查询"),
    CRH_CM_IN2101("CRH-CM-IN2101","积分修改"),
    CRH_CM_IN2102("CRH-CM-IN2102","积分流水查询"),
    CRH_CM_IN2103("CRH-CM-IN2103","签到"),
    CRH_CM_IN2104("CRH-CM-IN2104","主页产品列表"),
    CRH_CM_IN2105("CRH-CM-IN2105","产品详情"),
    CRH_CM_IN2106("CRH-CM-IN2106","购买产品"),
    CRH_CM_IN2107("CRH-CM-IN2107","判断是否签到接口"),
    CRH_CM_IN2108("CRH-CM-IN2108","签到记录分页列表"),
    CRH_CM_IN2109("CRH-CM-IN2109","查询连续签到天数及相应积分"),
    
    CRH_CM_IN2110("CRH-CM-IN2110","获取随机股票行情"),
    CRH_CM_IN2111("CRH-CM-IN2111","买入操作"),
    CRH_CM_IN2112("CRH-CM-IN2112","持仓或者卖出操作"),
    CRH_CM_IN2113("CRH-CM-IN2113","游戏结束操作"),
    CRH_CM_IN2114("CRH-CM-IN2114","排行榜"),
    CRH_CM_IN2115("CRH-CM-IN2115","游戏记录列表"),
    CRH_CM_IN2116("CRH-CM-IN2116","获取用户收货地址列表"),
    CRH_CM_IN2117("CRH-CM-IN2117","增加或修改地址"),
    CRH_CM_IN2118("CRH-CM-IN2118","删除地址"),
    
    CRH_CM_IN2250("CRH-CM-IN2250","转盘游戏"),
    CRH_CM_IN2251("CRH-CM-IN2251","我抽到的奖品"),
    CRH_CM_IN2252("CRH-CM-IN2252","实时更新奖品获得"),
    CRH_CM_IN2253("CRH-CM-IN2253","标记我的奖品（充值卡）为已用未用   1:未用 2：已用"),
    
    CRH_CM_IN8000("CRH-CM-IN8000","同步e起猜涨跌"),
    
    CRH_CM9001("CRH-CM9001","客户端社区入口信息"),
    CRH_CM9002("CRH-CM9002","社区模块入口信息及当前登录用户信息"),
    CRH_CM9003("CRH-CM9003","从账户中心同步用户信息")
    
            ;

    /** 功能号 */
    private String funcNo;
    /** 功能描述 */
    private String funcDesc;

    FuncEnum(String funcNo, String funcDesc) {
        this.funcNo = funcNo;
        this.funcDesc = funcDesc;
    }

    public String getFuncNo() {
        return funcNo;
    }

    public String getFuncDesc() {
        return funcDesc;
    }
}
