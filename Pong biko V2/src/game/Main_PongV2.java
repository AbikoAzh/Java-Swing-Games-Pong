package game;

import javax.swing.JFrame;

public class Main_PongV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		PTennis tennis= new PTennis();
		
		frame.setBounds(10,10,700,600);
		frame.setTitle("Pong V2");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(tennis);
		
		frame.addKeyListener(tennis);
	}

}
