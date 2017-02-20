package image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * 使用java画图
 * 图片
 * 验证码,可以防止暴力破解与恶意注册
 */
public class Demo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Image,ImageIO,BufferedImage,Icon,ImageIcon
		 */
		//得到图片缓冲区
		BufferedImage bi=new BufferedImage(70,35,BufferedImage.TYPE_INT_RGB);
		
		//得到它的绘制环境(这张图片的笔)
		Graphics2D g2=(Graphics2D) bi.getGraphics();
		
		//填充一个矩形,左上角坐标,(0,0)
		g2.setColor(Color.white);//设置绘制环境颜色为白色
		g2.fillRect(0, 0, 70, 35);//
		
		g2.setFont(new Font("宋体",Font.BOLD,5));//设置字体
		g2.setColor(Color.BLACK);//设置颜色
		
		g2.drawString("HelloWord", 3, 3);//向图片上写字符串
		
		//保存图片
		ImageIO.write(bi, "JPEG", new FileOutputStream("C://a.jpg"));
	}
}


