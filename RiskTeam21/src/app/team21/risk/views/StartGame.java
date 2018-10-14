package app.team.risk.views;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGame {
	private static JFrame main_frame;
	private static JPanel plain_panel;
	
		public static void main(String [] args){
			
			createStartScreen();
			
		}
		
		public static void createStartScreen(){
			
			main_frame = new JFrame("Risk");
			JButton play_button,map_button,rules_button,quit_button;
			
			play_button = new JButton("Play");
			play_button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					PlayPath pp = new PlayPath();
					pp.playButton();
					
				}
			});
			
			map_button= new JButton("Map");
			map_button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					MapPath mp = new MapPath();
					mp.mapButton();
					
				}
			});
			
			rules_button = new JButton("Rules");
			rules_button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Desktop.getDesktop().open(new java.io.File("Rules.pdf"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			
			JPanel start_panel= new JPanel();
			start_panel.setLayout(new BorderLayout());
			start_panel.setLayout(new GridLayout());
			
			start_panel.add(play_button,BorderLayout.CENTER);
			start_panel.add(map_button,BorderLayout.CENTER);
			start_panel.add(rules_button,BorderLayout.CENTER);
			
			main_frame.getContentPane().setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			main_frame.add(start_panel,gbc);
			main_frame.setVisible(true);
			main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			main_frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			
			
			
		}
		public  JPanel getPanel(){
			
			plain_panel = new JPanel();
			return plain_panel;
			
		}
		public  Frame getFrame(){
			main_frame.getContentPane().removeAll();
			main_frame.repaint();
			return main_frame;
			
		}
}