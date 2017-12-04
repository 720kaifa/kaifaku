package cairh.community.api.point.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



public class TCPEchoClient {
	public static String PSZ_ADDR_IP = ConfigProperties.get("encrypt.addr.ip", "127.0.0.1");
	public static int PSZ_ADDR_PORT = ConfigProperties.get("encrypt.addr.port", 6010) ;

    public static Socket initialContext() throws UnknownHostException, IOException{
    	Socket socket = new Socket(PSZ_ADDR_IP,PSZ_ADDR_PORT);
    	//outputStream = socket.getOutputStream(); 
    	//inputStream = socket.getInputStream(); 
    	return socket;
    }
	
    public static void releaseSessionContext(Socket socket){
		try {
			if (socket != null){
				OutputStream outputStream = socket.getOutputStream(); 
				InputStream inputStream = socket.getInputStream();
				if(outputStream != null){
        			outputStream.close();
        		}
        		if(inputStream != null){
        			inputStream.close();
            	}
				socket.close();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
	 public static String getDateFromSocketClient(Socket socket,String getString){
		 OutputStream outputStream = null;
		 InputStream inputStream = null;
		 BufferedReader bufferedReader = null;
		 try {   
        	//initialContext();
			outputStream = socket.getOutputStream(); 
            //System.out.println("请求报文:[" + getString.replaceAll("\n", ", ") + "]");  
            outputStream.write(getString.getBytes("GBK"));  
            outputStream.flush();  
  
            inputStream = socket.getInputStream(); 
            bufferedReader = new BufferedReader(new InputStreamReader( inputStream,"GBK")); 
            String readData = "",returnData = "";
            if ((readData = bufferedReader.readLine()) != null){  
            	returnData += readData;
            } 
           // System.out.println("响应报文:["+returnData+"]");
            return returnData;
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) { 
            e.printStackTrace();  
        } finally {
        	//releaseSessionContext();
        }
        return "";
	 }
	 
	 /**
	  * 请求密码加密
	  * @param pwd
	  * @param key
	  * @return
	  */
	 public static String encryptPWD(String pwd,String key) {
		 String encrypt = null;
		 Socket socket = null;
			try {
				socket = initialContext();
				
				//		 	1|426A660D5B6E
				String res = TCPEchoClient.getDateFromSocketClient(socket,"HT_Encrypt\n" + pwd + "\n" + key);
				if(res != null){
					String[] values = res.split("\\|");
					if(values != null && values.length > 0 
							&& "1".equals(values[0])){
						encrypt =  values[1];
					}
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				releaseSessionContext(socket);
			}
			return encrypt;
		}

}
