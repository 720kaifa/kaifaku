package cairh.community.api.game.kxian.util;

public class PassStrength {
	public static void main(String[] agrs){
		System.out.println(pass123456("654521"));
	}
	
	public static boolean pass(String s){
		if(pass111111(s) && pass111222(s) && pass112233(s) && pass121212(s)
				&&pass123123(s) && pass123456(s) && pass654321(s)){
			return true;
		}
		return false;
	}
	
	/***
	 * 111111 111112 211111
	 * @param s
	 * @return
	 */
	public static boolean pass111111(String s){
		if(s== null || "".equals(s.trim()) || s.trim().length() != 6){
			return false;
		}
		 int n = Integer.valueOf(s);
		 if(n%111111 == 0){
			 return false;
		 }else{
			 n = Integer.valueOf(s.substring(1, 6));
			 if(n%11111 == 0){
				 return false;
			 }
			 n = Integer.valueOf(s.substring(0, 5));
			 if(n%11111 == 0){
				 return false;
			 }
		 } 
		return true;
	}
	
	public static boolean pass111222(String s){
		if(s== null || "".equals(s.trim()) || s.trim().length() != 6){
			return false;
		}
		String s1 = s.substring(0, 3);
		String s2 = s.substring(3, 6);
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		if(n1%111 == 0 && n2%111 == 0){
			return false;
		}
		return true;
	}
	
	public static boolean pass112233(String s){
		if(s== null || "".equals(s.trim()) || s.trim().length() != 6){
			return false;
		}
		String s1 = s.substring(0, 2);
		String s2 = s.substring(2, 4);
		String s3 = s.substring(4, 6);
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		int n3 = Integer.valueOf(s3);
		if(n1%11==0 && n2%11==0 && n3%11==0){
			return false;
		}
		return true;
	}
	
	public static boolean pass121212(String s){
		if(s== null || "".equals(s.trim()) || s.trim().length() != 6){
			return false;
		}
		String s1 = s.substring(0, 2);
		s = s.replaceAll(s1, "");
		if("".equals(s)){
			return false;
		}
		return true;
	}
	
	public static boolean pass123123(String s){
		if(s== null || "".equals(s.trim()) || s.trim().length() != 6){
			return false;
		}
		String s1 = s.substring(0, 3);
		s = s.replaceAll(s1, "");
		if("".equals(s)){
			return false;
		}
		return true;
	}
	/***
	 * 
	 * @param s
	 * @return
	 */
	public static boolean pass123456(String s){
		if(s== null || "".equals(s.trim()) || s.trim().length() != 6){
			return false;
		}
		int n = Integer.valueOf(s);
		switch (n) {
		case 012345:
			return false;
		case 123456:
			return false;
		case 234567:
			return false;
		case 345678:
			return false;
		case 456789:
			return false;
		case 567890:
			return false;
		default:
			break;
		}
		return true;
	}
	
	public static boolean pass654321(String s){
		if(s== null || "".equals(s.trim()) || s.trim().length() != 6){
			return false;
		}
		int n = Integer.valueOf(s);
		switch (n) {
		case 98765:
			return false;
		case 987654:
			return false;
		case 876543:
			return false;
		case 765432:
			return false;
		case 654321:
			return false;
		case 543210:
			return false;
		default:
			break;
		}
		return true;
	}
	
}
