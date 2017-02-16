package swing;

import java.awt.Frame;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyJFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("Hello Swing");
		JLabel jl = new JLabel("A Label");
		/*
		Frame f = new Frame();
		f.setSize(200,200);
		f.setVisible(true);
		*/
		jf.add(jl);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 100);
		jf.setVisible(true);
		TimeUnit.SECONDS.sleep(1);
		jl.setText("This is different!");
	}

}
