import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI {

	public static JFrame Frame;
	public static JTextArea textField;	
	static Runnable GuiRunnable;

	public GUI() {
		GuiRunnable = new Runnable() {
			public void run() {	
					build_frame();	
			}
		};
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void build_frame() {
		Frame = new JFrame("TCP Server");
		Frame.setPreferredSize(new Dimension(700, 250));				
		Frame.setBounds(new Rectangle(200, 200, 200, 200));
		Frame.getContentPane().setBounds(new Rectangle(0, 0, 100, 100));
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		Frame.setResizable(false);				

		JPanel panel = new JPanel();
		panel.setLayout(null);

		GroupLayout groupLayout = new GroupLayout(Frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);						
		JScrollPane scrollPane = new JScrollPane();
		textField = new JTextArea();
		scrollPane.setViewportView(textField);
		textField.setRows(3);
		textField.setColumns(10);
		textField.setEditable(false);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		Frame.getContentPane().setLayout(groupLayout);
		Frame.pack();
		GUI.Frame.setVisible(true);		
	}
}

