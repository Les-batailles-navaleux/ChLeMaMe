package batailleNavale;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BatailleNavale {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;

	public BatailleNavale() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Bataille Navale");
		f.getContentPane().setBackground(new Color(240, 255, 255));
	      f.setSize(400, 550);
	      f.setLocation(300,200);
	      JTextArea textArea = new JTextArea(10, 40);
	      
	      JPanel panel = new JPanel();
	      panel.setBackground(new Color(240, 255, 255));
	      
	      JTextPane textPane = new JTextPane();
	      panel.add(textPane);
	      
	      JTextArea txtrNomDuJoueur = new JTextArea();
	      txtrNomDuJoueur.setBackground(new Color(240, 255, 255));
	      txtrNomDuJoueur.setFont(new Font("Tahoma", Font.PLAIN, 13));
	      txtrNomDuJoueur.setText("Taille de la grille :");
	      panel.add(txtrNomDuJoueur);
	      
	      textField = new JTextField();
	      textField.setBackground(new Color(224, 255, 255));
	      panel.add(textField);
	      textField.setColumns(10);
	      
	      JPanel panel_1 = new JPanel();
	      panel_1.setBackground(new Color(240, 255, 255));
	      panel_1.setBorder(new LineBorder(new Color(176, 224, 230)));
	      panel_1.setForeground(new Color(72, 209, 204));
	      
	      JPanel panel_2 = new JPanel();
	      panel_2.setBackground(new Color(240, 255, 255));
	      
	      JTextPane textPane_3 = new JTextPane();
	      panel_2.add(textPane_3);
	      
	      JTextPane textPane_4 = new JTextPane();
	      textPane_4.setText("Nom du joueur");
	      textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
	      textPane_4.setBackground(new Color(240, 255, 255));
	      panel_2.add(textPane_4);
	      
	      JTextPane textPane_5 = new JTextPane();
	      panel_2.add(textPane_5);
	      
	      JPanel panel_3 = new JPanel();
	      panel_3.setBackground(new Color(240, 255, 255));
	      
	      JRadioButton rdbtnNewRadioButton = new JRadioButton("Joueur graphique");
	      panel_3.add(rdbtnNewRadioButton);
	      
	      JTextPane textPane_6 = new JTextPane();
	      panel_3.add(textPane_6);
	      
	      JTextPane textPane_8 = new JTextPane();
	      panel_3.add(textPane_8);
	      
	      JPanel panel_4 = new JPanel();
	      panel_4.setBackground(new Color(240, 255, 255));
	      
	      JRadioButton radioButton = new JRadioButton("Joueur texte");
	      panel_4.add(radioButton);
	      
	      JTextPane textPane_7 = new JTextPane();
	      panel_4.add(textPane_7);
	      
	      JTextPane textPane_9 = new JTextPane();
	      panel_4.add(textPane_9);
	      
	      JPanel panel_5 = new JPanel();
	      panel_5.setBackground(new Color(240, 255, 255));
	      
	      JRadioButton radioButton_1 = new JRadioButton("Joueur auto");
	      panel_5.add(radioButton_1);
	      
	      JTextPane textPane_10 = new JTextPane();
	      panel_5.add(textPane_10);
	      
	      JTextPane textPane_11 = new JTextPane();
	      panel_5.add(textPane_11);
	      
	      JPanel panel_6 = new JPanel();
	      panel_6.setBorder(new LineBorder(new Color(176, 224, 230)));
	      panel_6.setBackground(new Color(240, 255, 255));
	      
	      JTextPane textPane_12 = new JTextPane();
	      panel_6.add(textPane_12);
	      
	      JTextPane textPane_13 = new JTextPane();
	      textPane_13.setText("Joueur 2");
	      textPane_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      textPane_13.setBackground(new Color(240, 255, 255));
	      panel_6.add(textPane_13);
	      
	      JTextPane textPane_14 = new JTextPane();
	      panel_6.add(textPane_14);
	      
	      JPanel panel_7 = new JPanel();
	      panel_7.setBackground(new Color(240, 255, 255));
	      
	      JTextPane textPane_15 = new JTextPane();
	      panel_7.add(textPane_15);
	      
	      JTextPane textPane_16 = new JTextPane();
	      textPane_16.setText("Nom du joueur");
	      textPane_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
	      textPane_16.setBackground(new Color(240, 255, 255));
	      panel_7.add(textPane_16);
	      
	      JTextPane textPane_17 = new JTextPane();
	      panel_7.add(textPane_17);
	      
	      textField_2 = new JTextField();
	      textField_2.setBackground(new Color(224, 255, 255));
	      textField_2.setColumns(10);
	      panel_7.add(textField_2);
	      
	      JPanel panel_8 = new JPanel();
	      panel_8.setBackground(new Color(240, 255, 255));
	      
	      JRadioButton radioButton_2 = new JRadioButton("Joueur graphique");
	      panel_8.add(radioButton_2);
	      
	      JTextPane textPane_18 = new JTextPane();
	      panel_8.add(textPane_18);
	      
	      JTextPane textPane_19 = new JTextPane();
	      panel_8.add(textPane_19);
	      
	      JPanel panel_9 = new JPanel();
	      panel_9.setBackground(new Color(240, 255, 255));
	      
	      JRadioButton radioButton_3 = new JRadioButton("Joueur texte");
	      panel_9.add(radioButton_3);
	      
	      JTextPane textPane_20 = new JTextPane();
	      panel_9.add(textPane_20);
	      
	      JTextPane textPane_21 = new JTextPane();
	      panel_9.add(textPane_21);
	      
	      JPanel panel_10 = new JPanel();
	      panel_10.setBackground(new Color(240, 255, 255));
	      
	      JRadioButton radioButton_4 = new JRadioButton("Joueur auto");
	      panel_10.add(radioButton_4);
	      
	      JTextPane textPane_22 = new JTextPane();
	      panel_10.add(textPane_22);
	      
	      JTextPane textPane_23 = new JTextPane();
	      panel_10.add(textPane_23);
	      
	      JButton btnLancerLaPartie = new JButton("Lancer la partie");
	      btnLancerLaPartie.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
//	      		FenetreJoueur.getFrames();
	      	}
	      });
	      btnLancerLaPartie.setBackground(new Color(224, 255, 255));
	      btnLancerLaPartie.setFont(new Font("Tahoma", Font.PLAIN, 13));
	      
	      JSeparator separator = new JSeparator();
	      
	      JSeparator separator_1 = new JSeparator();
	      GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	      groupLayout.setHorizontalGroup(
	      	groupLayout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addContainerGap()
	      					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addContainerGap()
	      					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addContainerGap()
	      					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addContainerGap()
	      					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addGap(135)
	      					.addComponent(btnLancerLaPartie)))
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGap(32)
	      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGap(163)
	      			.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGap(33)
	      			.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGap(261)
	      			.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
	      );
	      groupLayout.setVerticalGroup(
	      	groupLayout.createParallelGroup(Alignment.TRAILING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
	      					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addPreferredGap(ComponentPlacement.RELATED)
	      					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      					.addPreferredGap(ComponentPlacement.RELATED)
	      					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
	      					.addPreferredGap(ComponentPlacement.RELATED)
	      					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
	      					.addPreferredGap(ComponentPlacement.RELATED)
	      					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
	      					.addPreferredGap(ComponentPlacement.RELATED)
	      					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
	      					.addPreferredGap(ComponentPlacement.RELATED)
	      					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
	      					.addPreferredGap(ComponentPlacement.UNRELATED)
	      					.addComponent(btnLancerLaPartie)
	      					.addGap(89))))
	      );
	      
	      textField_1 = new JTextField();
	      textField_1.setBackground(new Color(224, 255, 255));
	      panel_2.add(textField_1);
	      textField_1.setColumns(10);
	      
	      JTextPane textPane_2 = new JTextPane();
	      panel_1.add(textPane_2);
	      
	      JTextPane txtpnJoueur = new JTextPane();
	      txtpnJoueur.setBackground(new Color(240, 255, 255));
	      txtpnJoueur.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      txtpnJoueur.setText("Joueur 1");
	      panel_1.add(txtpnJoueur);
	      
	      JTextPane textPane_1 = new JTextPane();
	      panel_1.add(textPane_1);
	      f.getContentPane().setLayout(groupLayout);
	      f.setVisible(true);

	}
}
