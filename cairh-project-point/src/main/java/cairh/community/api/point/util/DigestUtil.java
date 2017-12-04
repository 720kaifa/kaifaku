package cairh.community.api.point.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


public class DigestUtil {
  
	 public static  final String  DIGEST_SPLIT="|";
	 private static  MessageDigest getDigest(String algorithm){
		 try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	 }
	 private static MessageDigest getMd5Digest() {  
         return getDigest("MD5");  
     }  
	 
	 private static MessageDigest getShaDigest(){
		 return getDigest("SHA");  
	 }
	 
	 private static MessageDigest getSha256Digest() {  
         return getDigest("SHA-256");  
     }  
	 private static MessageDigest getSha384Digest() {  
         return getDigest("SHA-384");  
     }  
	 
	 private static MessageDigest getSha512Digest() {  
         return getDigest("SHA-512");  
     }  
	  
     /** 
      * 使用MD5消息摘要算法计算消息摘要 
      *  
      * @param data 做消息摘要的数据 
      */  
     public static String MD5(byte[] data) {  
    	 byte[] digestData= getMd5Digest().digest(data);  
    	 return Hex.encodeHexString(digestData);  
     }  
   
   
   
     /** 
      * 使用SHA-1消息摘要算法计算消息摘要 
      *  
      * @param data  做消息摘要的数据 
      */  
     public static String SHA(byte[] data) {  
    	 byte[] digestData=  getShaDigest().digest(data);  
    	 return Hex.encodeHexString(digestData);
     }  
   
     /** 
      * 使用SHA-256消息摘要算法计算消息摘要 
      *  
      * @param data 做消息摘要的数据 
      */  
     public static String SHA256(byte[] data) {  
    	 byte[] digestData= getSha256Digest().digest(data);  
    	 return Hex.encodeHexString(digestData);
     }  
   

     /** 
      * 使用SHA-384消息摘要算法计算消息摘要 
      *  
      * @param data 做消息摘要的数据 
      */  
     public static String SHA384(byte[] data) {  
    	 byte[] digestData=  getSha384Digest().digest(data);  
    	 return Hex.encodeHexString(digestData);  
     }  
   
   
     /** 
      * 使用SHA-512消息摘要算法计算消息摘要 
      *  
      * @param data 
      *            做消息摘要的数据 
      * @return SHA-512消息摘要（长度为64的字节数组） 
      */  
     public static String SHA512(byte[] data) {  
    	 byte[] digestData=  getSha512Digest().digest(data);  
    	 return Hex.encodeHexString(digestData);  
     } 
     
     
     public static String getCombineDigest(String  agreementDigest,String dateStr,String userName,String IDNumber) {
    	String digestStr="";
 		byte[] b=null;
 		try {
 			b= (agreementDigest+DIGEST_SPLIT+ dateStr +DIGEST_SPLIT+userName+DIGEST_SPLIT+ IDNumber).getBytes("UTF-8");
 			digestStr = DigestUtil.SHA256(b);
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
 		return digestStr;
 	 
     }
     
     public static String getAgreementDigest(String  plainTxt) {
     	String digestStr="";
  		byte[] b=null;
  		try {
  			b = plainTxt.getBytes("UTF-8");
  			digestStr=DigestUtil.SHA256(b);
  		} catch (UnsupportedEncodingException e) {
  			e.printStackTrace();
  		}
  		return digestStr;
      } 
     
   
}
