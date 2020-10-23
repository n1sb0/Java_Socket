import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUI {

	public static JFrame Frame;
	public static JTextArea textArea;
	static Runnable GuiRunnable;
	public static JButton ConnettiButton;
	public static JButton DisConnettiButton;
	public static JTextField textField;
	public static JButton InviaButton;
	
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
		Frame = new JFrame("TCP Client");
		Frame.setPreferredSize(new Dimension(500, 250));				
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
		textArea = new JTextArea("Scrivi una frase e il server la trasfrma in maiuscolo. \n");
		GUI.textArea.append("----- \n");
		
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setRows(3);
		textArea.setColumns(10);
		
		
		ConnettiButton = new JButton("Connetti");
		DisConnettiButton = new JButton("DisConnetti");
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		InviaButton = new JButton("Invia");		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField, Alignment.LEADING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						//.addComponent(ConnettiButton)
						//.addComponent(DisConnettiButton)
						.addComponent(InviaButton))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19))
							//.addComponent(ConnettiButton)
							//.addComponent(DisConnettiButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(InviaButton))
					.addGap(16))
		);
		panel.setLayout(gl_panel);		
		
		Frame.getContentPane().setLayout(groupLayout);
		Frame.pack();
		GUI.Frame.setVisible(true);	
	}
}
