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
 * ʹ��java��ͼ
 * ͼƬ
 * ��֤��,���Է�ֹ�����ƽ������ע��
 */
public class Demo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Image,ImageIO,BufferedImage,Icon,ImageIcon
		 */
		//�õ�ͼƬ������
		BufferedImage bi=new BufferedImage(70,35,BufferedImage.TYPE_INT_RGB);
		
		//�õ����Ļ��ƻ���(����ͼƬ�ı�)
		Graphics2D g2=(Graphics2D) bi.getGraphics();
		
		//���һ������,���Ͻ�����,(0,0)
		g2.setColor(Color.white);//���û��ƻ�����ɫΪ��ɫ
		g2.fillRect(0, 0, 70, 35);//
		
		g2.setFont(new Font("����",Font.BOLD,5));//��������
		g2.setColor(Color.BLACK);//������ɫ
		
		g2.drawString("HelloWord", 3, 3);//��ͼƬ��д�ַ���
		
		//����ͼƬ
		ImageIO.write(bi, "JPEG", new FileOutputStream("C://a.jpg"));
	}
}


