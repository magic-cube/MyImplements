package socket;
import java.io.*;
/**
 * 工具类
 * 关闭流的方法
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
