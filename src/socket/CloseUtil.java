package socket;
import java.io.*;
/**
 * ������
 * �ر����ķ���
 * @author hc
 *
 */
public class CloseUtil {
	public static void close(Closeable... io){
		for(Closeable temp:io){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
		}
	}
}
