package cairh.community.api.game.kxian.util;

import java.math.BigDecimal;

/**
* 精度运算
*
*/
public class Arith { 
	private static final int DEFAULT_DIV_SCALE = 5;
	private static final int DEFAULT_ROUNDINGMODE = BigDecimal.ROUND_HALF_UP;
//	private static final MathContext mathContext = new MathContext(16, RoundingMode.HALF_UP);
	
	public static double div(double v1, double v2){
		return div(v1,v2,DEFAULT_DIV_SCALE);
	}
	
	public static double div(double v1 , double v2 ,int scale){
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.divide(b2,scale,DEFAULT_ROUNDINGMODE).doubleValue();
	}

	public static double round(double v){
      return round(v, DEFAULT_DIV_SCALE);
  }
	
	public static double round(double v,int scale){
      if(scale<0){
          throw new IllegalArgumentException(
              "The scale must be a positive integer or zero");
      }
      BigDecimal b = new BigDecimal(Double.toString(v));
      BigDecimal one = new BigDecimal("1");
      return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
  }
	
	public static BigDecimal round(BigDecimal bigDecimal){
		return bigDecimal.setScale(DEFAULT_DIV_SCALE, DEFAULT_ROUNDINGMODE);
	}
	
	public static BigDecimal add(BigDecimal addend, BigDecimal augend){
		return round(addend.add(augend));
	}
	
	public static BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend){
		return round(minuend.subtract(subtrahend));
	}
	
	public static BigDecimal multiply(BigDecimal multiplier, BigDecimal multiplicand){
		return round(multiplier.multiply(multiplicand));
	}
	
	public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor){
		return dividend.divide(divisor, DEFAULT_DIV_SCALE, DEFAULT_ROUNDINGMODE);
	}
}
