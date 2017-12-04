package cairh.community.api.game.kxian.service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.exceptions.JedisException;
import cairh.community.api.game.kxian.util.ConfigProperties;
import cairh.community.api.game.kxian.util.CookieUtil;
import cairh.community.api.game.kxian.util.RedisClientUtil;

import com.jhlabs.image.RippleFilter;

@SuppressWarnings("restriction")
public class ValidateCodeService extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7895892514840536828L;
	//图片的宽度 
	private final static int IMAGEWIDTH = 20;
	//图片的高度 
	private final static int IMAGEHEIGHT = 35;

	//字体大小
	private final static int FONTSIZE = 22;

	//字符串长度 
	private final static int CODE_LENGTH = 5;

	//随机字符范围 
	private final static char[] CHAR_RANGE = { 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'J', 'K', 'L' , 'N', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V' , 'X', 'Y', '2', '3', '4', '5',
			'6', '7', '8', '9' };
	//字体
	private static Font font;
	//{3,10,3,20,10,1} {5,5,5,8,10,1}
	private final static int[] FILTER_ARGS_1 ={3,4,3,20,10,1};
	private final static int[] FILTER_ARGS_2 ={5,4,5,8,10,1};
	private static RippleFilter rippleFilter = new RippleFilter();
	private static RippleFilter rippleFilter1 = new RippleFilter();
	static{
		java.io.BufferedInputStream fb = null;
		java.io.FileInputStream fi = null;
		try {
			rippleFilter.setWaveType(FILTER_ARGS_1[0]);
			rippleFilter.setXAmplitude(FILTER_ARGS_1[1]);
			rippleFilter.setYAmplitude(FILTER_ARGS_1[2]);
			rippleFilter.setXWavelength(FILTER_ARGS_1[3]);
			rippleFilter.setYWavelength(FILTER_ARGS_1[4]);
			rippleFilter.setEdgeAction(FILTER_ARGS_1[5]);
			rippleFilter1.setWaveType(FILTER_ARGS_2[0]);
			rippleFilter1.setXAmplitude(FILTER_ARGS_2[1]);
			rippleFilter1.setYAmplitude(FILTER_ARGS_2[2]);
			rippleFilter1.setXWavelength(FILTER_ARGS_2[3]);
			rippleFilter1.setYWavelength(FILTER_ARGS_2[4]);
			rippleFilter1.setEdgeAction(FILTER_ARGS_2[5]);
			String holidayPath = ValidateCodeService.class.getClassLoader().getResource("font/swisse_0.ttf").getPath();
			File file = new File(holidayPath);
			fi = new java.io.FileInputStream(file);
			fb = new java.io.BufferedInputStream(fi);
	        Font nf = Font.createFont(Font.TRUETYPE_FONT, fb);
	        nf = nf.deriveFont(Font.PLAIN, FONTSIZE);
	        font = nf;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fb!=null){
					fb.close();
				}
				if(fi!=null){
					fi.close();
				}
			} catch (IOException e2) {

			}
		}
	}

	
	private static SecureRandom random = new SecureRandom();;

	/** 
	 * 生成随机字符串 
	 * @return 随机字符串  
	 */
	private static String getRandString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < CODE_LENGTH; i++)
			sb.append(CHAR_RANGE[random.nextInt(CHAR_RANGE.length)]);
		return sb.toString();
	}

	/**
	 * 生成随即颜色
	 * @param type 1：返回字体颜色 2:返回噪点颜色
	 * @return
	 */
	private static Color getRandomColor(int type) {
		Color color = null;
		if(type == 1){
			SecureRandom random = new SecureRandom();
			int i = random.nextInt(4);
//			单个文字颜色（随机4种）
//			黑：000000
//			褐：d6a971
//			蓝：66c3d6
//			灰：aaaaaa
			Color [] colors = {new Color(0,0,0),new Color(0xd6,0xa9,0x71),new Color(0x66,0xc3,0xd6),new Color(0xaa,0xaa,0xaa)};
			color = colors[i];
		}else if(type == 2){
			SecureRandom random = new SecureRandom();
			int i = random.nextInt(3);
//			噪点颜色：3
//			3c3c3c
//			ff8e49
//			6dd781
			Color [] colors = {new Color(0x3c,0x3c,0x3c),new Color(0xff,0x8e,0x49),new Color(0x6d,0xd7,0x81)};
			color = colors[i];
		}else{
			color = new Color(255,255,255);
		}
		return color;
	}
	

	//得到波纹扭曲处理器
	private static RippleFilter getRippleFilter(){
		//波纹扭曲{3 10 3 20 10 1} {1 2 2 10 10 1}{2 2 2 10 10 1}{5 5 5 10 10 1}
		SecureRandom random = new SecureRandom();
		int i = random.nextInt(2);
		if(i==0)
			return rippleFilter;
		else
			return rippleFilter1;
	}
	
	/** 
	 * 生成指定字符串的图像数据 
	 * @param verifyCode 即将被打印的随机字符串 
	 * @return 生成的图像数据 
	 * */
	private static BufferedImage getImage(String verifyCode) {

		//生成画布
		BufferedImage image = new BufferedImage(IMAGEWIDTH * CODE_LENGTH,
				IMAGEHEIGHT, BufferedImage.TYPE_INT_RGB);

		//获取图形上下文 （生成画笔）
		Graphics graphics = image.getGraphics();

		//设置背景色（） 
		graphics.setColor(new Color(255,255,255));
		//填充矩形区域 ，作为背景
		graphics.fillRect(0, 0, IMAGEWIDTH * CODE_LENGTH, IMAGEHEIGHT);
		//画出边框 
		graphics.drawRect(0, 0, IMAGEWIDTH*CODE_LENGTH,IMAGEHEIGHT);
		//画字符串 
		graphics.setColor(new Color(50,50,50));
		for (int i = 0; i < CODE_LENGTH; i++) {
			String temp = verifyCode.substring(i, i + 1);
			graphics.setFont(font);
			graphics.setColor(getRandomColor(1));
			graphics.drawString(temp, 18 * i + 6, 28);
		}
		//波纹扭曲{3 10 3 20 10 1} {1 2 2 10 10 1}{2 2 2 10 10 1}{5 5 5 10 10 1}
		RippleFilter rippleFilter = getRippleFilter();
		BufferedImage b = rippleFilter.filter(image, null);
		graphics.drawImage(b, 0, 0, null);
		//产生80个干扰点
		graphics.setColor(new Color(100, 100, 100));
		for (int i = 0; i < 80; i++) {
			graphics.setColor(getRandomColor(2));
			int x = random.nextInt(IMAGEWIDTH*CODE_LENGTH);
			int y = random.nextInt(IMAGEHEIGHT);
			graphics.drawOval(x, y, 1, 1);
		}
		//设置边框
		graphics.setColor(new Color(0xCF,0xCE,0xCA));
		((Graphics2D)graphics).setStroke(new BasicStroke(1.0f));
		graphics.drawRect(0, 0, IMAGEWIDTH*CODE_LENGTH-1,IMAGEHEIGHT-1);
		graphics.dispose();

		return image;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	// 生成数字和字母的验证码
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String str = getRandString();
		BufferedImage bufferedImage = getImage(str);
		
//		request.getSession().setAttribute("validateCode", str);
	//	JedisIO j = null;
		try {
			//redis加入验证码，5分钟过期
			//j = JedisPool2.getInstance("info").getJedis("fixedJedis");
			String codeKey = CookieUtil.getCookie(request, "CRHSESSIONID");
			if(null == codeKey || "".equals(codeKey)) {
				codeKey = UUID.randomUUID().toString();
				Cookie cookie = new Cookie("CRHSESSIONID", codeKey);
				cookie.setPath(ConfigProperties.get("cookiePath"));
				//cookie.setDomain(ConfigProperties.get("domain"));
				response.addCookie(cookie);
			}
			codeKey += "validateCode";
			RedisClientUtil.set(codeKey, str);
			RedisClientUtil.expire(codeKey, 300);
			//if(j !=null)j.close();
		}catch(JedisException e){
			//if(j !=null)j.trueClose();
		}catch(ClassCastException e){
			//if(j !=null)j.trueClose();
		} 
		catch (Exception e) {
			e.printStackTrace();
			Cookie cookie = new Cookie("validate_code", CookieUtil.encryptionCookie(URLEncoder.encode(str,"UTF-8")));
			cookie.setPath("/");
			//cookie.setDomain(ConfigProperties.get("domain"));
			response.addCookie(cookie);
		}
		 
        ImageIO.write(bufferedImage, "JPG", response.getOutputStream());
	}
	
}
