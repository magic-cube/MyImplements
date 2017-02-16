package swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.*;

public class MyJFrame2 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("509Ò¡ºÅ×¨ÓÃÈí¼þ!  ~~~ 1.0°æ");
		Label jl = new Label("My Label",FlowLayout.CENTER);
		jf.setBounds(300,300,500, 500);
		jf.setBackground(Color.gray);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(jl);
		//TimeUnit.SECONDS.sleep(1);
		//l.setText("I can change!");
		//l.setAlignment(CENTER);
		
	}

}
