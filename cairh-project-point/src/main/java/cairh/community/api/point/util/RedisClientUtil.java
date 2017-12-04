package cairh.community.api.point.util;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.ZParams;
import redis.clients.jedis.ZParams.Aggregate;
import redis.clients.util.Pool;

import java.io.File;
import java.util.*;

/**
 * 功能说明: redis工具类<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author kongdy<br>
 * 开发时间: 2015年8月4日<br>
 */
public class RedisClientUtil {

	protected static Logger logger = LoggerFactory.getLogger(RedisClientUtil.class);

	private static Pool<Jedis> jedisPool;
	
	/**
	 * 获取jedis-sentinel连接实例，取ifs.properties配置项“redis.sentinel.address”
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Pool<Jedis> getJedisPool() {
		if (jedisPool != null) {
			return jedisPool;
		}
		Map<String, Object> configMap = parseConfigXml();
		Set<String> sentinels = (Set<String>) configMap.get("servers");
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数, 默认8个
		config.setMaxTotal(Integer.parseInt((String)configMap.get("maxConn")));
		// 最大空闲连接数, 默认8个
		config.setMaxIdle(Integer.parseInt((String)configMap.get("maxIdle")));
		// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常,
		// 小于零:阻塞不确定的时间, 默认-1
		config.setMaxWaitMillis(Long.parseLong((String)configMap.get("maxBusyTime")));
		int timeout = Integer.parseInt((String)configMap.get("timeout"));
		// 密码
		String password = (String)configMap.get("password");

		try {
			jedisPool = new JedisSentinelPool((String)configMap.get("name"), sentinels, config, timeout, password);
			logger.info(String.format("连接redis-sentinel服务器[%s]", sentinels));
		} catch (Exception e) {
			logger.error("连接redis服务器发生错误", e);
		}
		return jedisPool;
	}

	/**
	 * 解析redis配置
	 * @return
	 */
	private static Map<String, Object> parseConfigXml() {
		Map<String, Object> map = new HashMap<String, Object>();
		SAXReader reader = new SAXReader();
		reader.setEncoding("utf-8");
		String filePath;
		try {
			filePath = EnvironmentUtils.getWebClassPath() + File.separator + "jedis.xml";
			//filePath = "D:/workspace3/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/cairh-htsec-community-middle/WEB-INF/classes/jedis.xml";
			//filePath = "D:/jedis.xml";
			Document doc = reader.read(filePath);
			Element group = doc.getRootElement().element("serverGroup");
			for (Object obj : group.attributes()) {
				if (obj instanceof Attribute) {
					Attribute attr = (Attribute)obj;
					map.put(attr.getName(), attr.getValue());
				}
			}
			Set<String> servers = new HashSet<String>();
			for (Object obj : group.elements("server")) {
				if (obj instanceof Element) {
					Element ele = (Element)obj;
					servers.add(ele.attributeValue("ip") + ":" + ele.attributeValue("port"));
				}
			}
			map.put("servers", servers);
			if (servers.isEmpty()) {
				logger.error("redis缓存服务器未配置，请正确配置");
				System.exit(0);
			}
		} catch (Exception e) {
			logger.error("redis缓存服务器未配置，请正确配置", e);
			System.exit(0);
		}
		return map;
	}

	/**
	 * 关闭连接池
	 */
	public static void close() {
		if (jedisPool != null) {
			jedisPool.close();
			jedisPool.destroy();
		}
	}

	/**
	 * 写入/覆盖。如果key已经在redis上存在，那么会被覆盖。
	 * @param key
	 *        键
	 * @param value
	 *        值。 注意不能超过1G
	 * @return
	 */
	public static boolean set(String key, String value) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();

		try {
			if (value != null) {
				jedis.set(key, value);
			}
		} finally {
			pool.returnResource(jedis);
		}
		return true;
	}

	/**
	 * 写入/覆盖。如果key已经在redis上存在，那么会被覆盖。
	 * @param key
	 * @param value
	 * @param seconds
	 *        存活时间（秒）
	 * @return
	 */
	public static boolean set(String key, String value, int seconds) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();

		try {
			if (value != null) {
				jedis.setex(key, seconds, value);
			}
		} finally {
			pool.returnResource(jedis);
		}
		return true;
	}
	
	/**
	 * 对value参数做toString处理，{@link #set(String, String, int)}
	 * @see #set(String, String, int)
	 * @author meijie
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	public static boolean set(String key, Object value, int seconds) {
		if (value != null) {
			return set(key, value.toString(), seconds);
		} else {
			return set(key, value, seconds);
		}
	}

	/**
	 * 不存在key 则写入。即：set if Not eXists
	 * <p>
	 * 如果redis上已经有key，什么都不错; 如果redis上没有key，则写入;
	 * </p>
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean setnx(String key, String value) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();

		try {
			if (value != null) {
				jedis.setnx(key, value);
			}
		} finally {
			pool.returnResource(jedis);
		}
		return true;
	}

	/**
	 * 不存在key 则写入。即：set if Not eXists
	 * <p>
	 * 如果redis上已经有key，什么都不错; 如果redis上没有key，则写入;
	 * </p>
	 * @param key
	 * @param value
	 * @param seconds
	 *        存活时间（秒）
	 * @return
	 */
	public static boolean setnx(String key, String value, int seconds) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();

		try {
			if (value != null) {
				// NX:只在键不存在时，才对键进行设置操作; XX:只在键已经存在时，才对键进行设置操作
				// EX:设置键的过期时间为 second秒; PX:设置键的过期时间为 millisecond 毫秒
				jedis.set(key, value, "NX", "EX", seconds);
			}
		} finally {
			pool.returnResource(jedis);
		}
		return true;
	}

	/**
	 * 更新。key存在时，才更新覆盖。
	 * <p>
	 * 如果redis上没有key，什么都不错; 如果redis上有key，则更新;
	 * </p>
	 * @param key
	 * @param value
	 * @param seconds
	 *        存活时间（秒）
	 * @return
	 */
	public static boolean setxx(String key, String value, int seconds) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();

		try {
			if (value != null) {
				// NX:只在键不存在时，才对键进行设置操作; XX:只在键已经存在时，才对键进行设置操作
				// EX:设置键的过期时间为 second秒; PX:设置键的过期时间为 millisecond 毫秒
				jedis.set(key, value, "XX", "EX", seconds);
			}
		} finally {
			pool.returnResource(jedis);
		}
		return true;
	}

	/**
	 * 删除
	 * @param key
	 * @return
	 */
	public static boolean del(String key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.del(key);
			return true;
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * 读取
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.get(key);
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * 根据type将id增加到set集合
	 * @param type
	 * @param score
	 * @param id
	 *        开发人员: @author huadi<br>
	 *        开发时间: 2015年10月14日<br>
	 */
	public static void addToRedisSetById(String type, Double score, String id) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据type将id增加到set集合出错:无法获取redis连接");
			return;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.zadd(type, score, id);
		} finally {
			pool.returnResource(jedis);
		}

	}

	/**
	 * 根据type将id从set集合中删除
	 * @param type
	 * @param id
	 *        开发人员: @author huadi<br>
	 *        开发时间: 2015年10月14日<br>
	 */
	public static void removeFromRedisSetById(String type, String id) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据type将id从set集合中删除出错:无法获取redis连接");
			return;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.zrem(type, id);
			if (StringUtils.equals(type, "onlineEmp")) {
				logger.info("从[" + type + "]集合中删除坐席[emp_id =" + id + "]成功!");
			} else {
				logger.info("从[" + type + "]集合中删除用户[user_id =" + id + "]成功!");
			}
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * 根据类型获取所属的id集合
	 * @param type
	 * @return set<id>
	 *         开发人员: @author huadi<br>
	 *         开发时间: 2015年10月14日<br>
	 */
	public static Set<String> getSortedSet(String type) {
		Set<String> userSet = null;
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据类型获取所属的id集合出错:无法获取redis连接");
			return userSet;
		}
		Jedis jedis = pool.getResource();
		try {
			userSet = jedis.zrange(type, 0L, -1L);
		} finally {
			pool.returnResource(jedis);
		}
		return userSet;
	}

	/**
	 * 自增
	 * @param key
	 * @param integer
	 */
	public static void incrBy(String key,Integer integer) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据类型获取所属的id集合出错:无法获取redis连接");
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.incrBy(key, integer);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public static void setex(String key,Integer seconds,String value) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据类型获取所属的id集合出错:无法获取redis连接");
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.setex(key, seconds, value);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 根据类型获取Set总数
	 * @param type
	 * @return
	 *         开发人员: @author huadi<br>
	 *         开发时间: 2015年10月14日<br>
	 */
	public static int getSetCount(String type) {
		int count = 0;
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据类型获取Set总数出错:无法获取redis连接");
			return count;
		}
		Jedis jedis = pool.getResource();
		try {
			count = jedis.zcard(type).intValue();
		} finally {
			pool.returnResource(jedis);
		}
		return count;
	}

	/**
	 * 根据Id从set中查询score(权重)
	 * @param type
	 * @param id
	 * @return
	 *         开发人员: @author huadi<br>
	 *         开发时间: 2015年10月14日<br>
	 */
	public static Double getScoreById(String type, String id) {
		Double score = null;
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据Id从set中查询score(权重)出错:无法获取redis连接");
			return score;
		}
		Jedis jedis = pool.getResource();
		try {
			score = jedis.zscore(type, id);
		} finally {
			pool.returnResource(jedis);
		}
		return score;
	}

	/**
	 * 根据样式查找
	 * @param pattern
	 * @return
	 *         开发人员: @author huadi<br>
	 *         开发时间: 2015年10月14日<br>
	 */
	public static List<String> getByPattern(String pattern) {
		List<String> list = null;
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据样式查找出错:无法获取redis连接");
			return list;
		}
		Jedis jedis = pool.getResource();
		try {
			list = jedis.configGet(pattern);
		} finally {
			pool.returnResource(jedis);
		}
		return list;
	}

	/**
	 * 在set集合中根据最小权重和最大权重得出中间的数目
	 * @param type
	 * @param min
	 *        最小权重
	 * @param max
	 *        最大权重
	 * @return
	 *         开发人员: @author huadi<br>
	 *         开发时间: 2015年10月14日<br>
	 */
	public static int getSetCountByScore(String type, double min, double max) {
		Long count = 0L;
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("统计排队位置出错:无法获取redis连接");
			return 0;
		}
		Jedis jedis = pool.getResource();
		try {
			count = jedis.zcount(type, min, max);
		} finally {
			pool.returnResource(jedis);
		}
		return count.intValue();
	}


	/**
	 * 将members放入到key集合中
	 * @param key
	 * @param members
     */
	public static void sadd(String key, String...members) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据type将id增加到set集合出错:无法获取redis连接");
			return;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.sadd(key, members);
		} finally {
			pool.returnResource(jedis);
		}

	}
	/**
	 * 从key集合中随机取出并删除一个元素
	 * @param key
     */
	public static String spop(String key) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据type将id增加到set集合出错:无法获取redis连接");
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.spop(key);
		} finally {
			pool.returnResource(jedis);
		}

	}

	/**
	 * 将members从key集合中删除
	 * @param key
	 * @param members
     */
	public static void srem(String key, String... members) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据type将id从set集合中删除出错:无法获取redis连接");
			return;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.srem(key, members);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	
	public static Long srem2(String key, String... members) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据type将id从set集合中删除出错:无法获取redis连接");
			return -1l;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.srem(key, members);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	
	/**
	 * 将members从key集合中删除
	 * @param key
     */
	public static Set<String> smembers(String key) {
		Pool<Jedis> pool = RedisClientUtil.getJedisPool();
		if (pool == null) {
			logger.info("根据type将id从set集合中删除出错:无法获取redis连接");
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.smembers(key);
		} finally {
			pool.returnResource(jedis);
		}
	}


	/**
	 * 模糊查找key
	 * @param key
	 *        查询条件[eg: config.cache.* ]
	 * @return
	 */
	public static Set<String> keys(String key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.keys(key);
		} finally {
			pool.returnResource(jedis);
		}
	}

	
	/**
	 * 写入
	 * @param key
	 * @param curkey
	 * @param Value
	 * @param seconds
	 * @return
	 */
	public static boolean hset(String key,String curkey,String Value,int seconds) {
		boolean result = false;
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return result;
		}
		Jedis jedis = pool.getResource();
		try{
			jedis.hset(key,curkey, Value);
			jedis.expire(key, seconds);
			result = true;
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = false;
		}
		finally {
			pool.returnResource(jedis);
		}
		return result;
	}
	
	/**
	 * 获取
	 * @param key
	 * @param field
	 * @return
	 */
	public static String hget(String key,String field) {
		String result = null;
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try{
			result = jedis.hget(key,field);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = null;
		}
		finally {
			pool.returnResource(jedis);
		}
		if(result != null){
			return result;
		}
		else{
			return "";
		}
	}
	
	
	/**
	 * 删除
	 * @param key
	 * @param field
	 * @return
	 */
	public static boolean hdel(String key,String field) {
		boolean result = false;
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try{
			jedis.hdel(key, field);
			result = true;
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = false;
		}
		finally {
			pool.returnResource(jedis);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// set("config.cache.clients", null);
		// del("config.cache.clients");
		/*for (int t = 0; t < 20; t++) {
			new Thread() {

				public void run() {
					for (int i = 0; i < 1000; i++) {
						System.out.println(get("config.cache.clients"));
						try {
							System.out.println(set(null, "12345"));
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}
			}.start();
		}*/
		// System.out.println(get("config.cache.db"));
		// System.out.println(get("config.cache.CAConfigCache"));
		// close();
/*		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("4", "4");
		
		setMap("wangzhen", map1);*/
		
		//zUnionstore("test11", new ZParams().aggregate(Aggregate.MIN), "test2", "test3");
		 
	}
	
	/**
	 * 读取redis，根据format参数返回Date
	 * @author meijie
	 * @param key 键
	 * @param format 日期格式化字符串
	 * @return 返回null，如果解析失败
	 */
	public static Date getDate(String key, String format) {
		String value = get(key);
		return DateUtil.parse(value, format);
	}
	
	/**
	 * 读取redis，解析数字并返回
	 * @author meijie
	 * @param key
	 * @param defaultValue
	 * @return 返回defaultValue，如果解析失败
	 */
	public static int getInt(String key, int defaultValue) {
		String value = get(key);
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static Long rpush(String key, String ... values) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.rpush(key, values);
		} finally {
			pool.returnResource(jedis);
		}
	}
	public static Long lpush(String key, String ... values) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.lpush(key, values);
		} finally {
			pool.returnResource(jedis);
		}
	}
	public static List<String> blpop(String ... key) {
		return blpop(0, key);
	}

	/**
	 * 当列表为空时，连接将被阻塞，直到等待超时或发现可弹出元素为止
	 * 超时参数设为0表示阻塞时间可以无限期延长
	 * @author HuJianfeng
	 * @param timeout
	 * @param key
	 * @return
	 */
	public static List<String> blpop(int timeout, String ... key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.blpop(timeout, key);
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * 获取并仅保留范围内的数据
	 * @author luyj
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> lrangeAndLtrim(String key,int start,int end) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			//获取
			List<String> list=jedis.lrange(key,start,end);
			//删除范围外的
			jedis.ltrim(key,start,end);
			return list;
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * 自增
	 * @param key
	 * @return
	 */
	public static boolean incr(String key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			if (key != null) jedis.incr(key);
		} finally {
			pool.returnResource(jedis);
		}
		return true;
	}

	/**
	 * 自减
	 * @param key
	 * @return
	 */
	public static boolean decr(String key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			if (key != null) jedis.decr(key);
		} finally {
			pool.returnResource(jedis);
		}
		return true;
	}
	
	/**
	 * 设置超时时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	public static boolean expire(String key, int seconds) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		long res = 0;
		try{
			if (seconds > 0) {
				res = jedis.expire(key,seconds);
			}
		}finally {
			pool.returnResource(jedis);
		}
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean set(byte[] key, byte[] value, int seconds) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.setex(key, seconds, value);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			pool.returnResource(jedis);
		}
	}

	public static byte[] get(byte[] key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return new byte[0];
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			return new byte[0];
		} finally {
			pool.returnResource(jedis);
		}
	}

	public static long llen(String key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return 0;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.llen(key);
		} finally {
			pool.returnResource(jedis);
		}
	}

	public static boolean del(byte[] key) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.del(key);
			return true;
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param map
	 * @return
	 */
	public static boolean setMap(String key,Map<String, String> map) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.hmset(key, map);
			return true;
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 删除hash指定的map
	 * @param key
	 * @param fields
	 * @return
	 */
	public static boolean delMap(String key, String... fields) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.hdel(key, fields);
			return true;
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * @param key
	 * @param fields
	 * @return
	 */
	public static List<String> getMap(String key,String... fields) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.hmget(key, fields);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	
	/**
	 * @param key
	 * @param strings
	 * @return
	 */
	public static boolean setList(String key,String... strings) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.lpush(key, strings);
			return true;
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	
	/**
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> getList(String key,long start, long end) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.lrange(key, start, end);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 有序集和增加
	 * @param key
	 * @param strings
	 * @return
	 */
	public static boolean zaddList(String key,final double score, final String member) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return false;
		}
		Jedis jedis = pool.getResource();
		try {
			jedis.zadd(key, score, member);
			return true;
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 有序集和删除其中元素
	 * @param key
	 * @param members
	 * @return
	 */
	public static Long zrangeDel(String key,final String... members) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.zrem(key, members);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	
	/**
	 * 有序集和获得
	 * @param key
	 * @param strings
	 * @return
	 */
	public static Set<String> zrangeList(String key,long start, long end) {
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.zrange(key, start, end);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 批量模糊删除缓存
	 * @param str
	 * @return
	 */
	public static String delList(String str) {
		Pool<Jedis> pool = getJedisPool();
		Jedis jedis = pool.getResource();
		
		try {
		Set<String> set = jedis.keys(str +"*");  
	    Iterator<String> it = set.iterator();  
	    while(it.hasNext()){  
	        String keyStr = it.next();  
	        System.out.println(keyStr);  
	        jedis.del(keyStr);  
	    }}finally {
			pool.returnResource(jedis);
		}
		return str;
	}
	
	/**
	 * 是否存在key 存在true
	 * @param key
	 * @return
	 */
	public static boolean exists(String key) {
		Pool<Jedis> pool = getJedisPool();
		Jedis jedis = pool.getResource();
		try {
			return jedis.exists(key);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * SortedSet倒序排列
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Set<String> zRevrange(String key, long start, long end){
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.zrevrange(key, start, end);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * SortedSet中的一个元素在倒序时的位置（从0开始）
	 * @param key
	 * @param member
	 * @return
	 */
	public static Long zRevrank(String key, String member){
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			return jedis.zrevrank(key, member);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 多个集合取交集
	 * @param newkey
	 * @param params
	 * @param sets
	 * @return
	 */
	public static Long zInterstore(String newkey, ZParams params, String... sets){
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			
			return jedis.zinterstore(newkey, params, sets);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 多个集合取并集
	 * @param newkey
	 * @param params
	 * @param sets
	 * @return
	 */
	public static Long zUnionstore(String newkey, ZParams params, String... sets){
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			
			return jedis.zunionstore(newkey, params, sets);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	/**
	 * 有序集合元素删除
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Long zRemrangeByRank(String key, Long start, Long end){
		Pool<Jedis> pool = getJedisPool();
		if (pool == null) {
			return null;
		}
		Jedis jedis = pool.getResource();
		try {
			
			return jedis.zremrangeByRank(key, start, end);
		} finally {
			pool.returnResource(jedis);
		}
	}
}
