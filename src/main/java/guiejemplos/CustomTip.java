package guiejemplos;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import gui.PanelPersonalizado;


public class CustomTip implements Runnable {

	private Popup popup;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new CustomTip());
	}

	@Override
	public void run() {
		JPanel panel2 = new JPanel(new GridBagLayout());
		panel2.setBackground(Color.decode("#e99998"));


		LineBorder xd = new LineBorder(Color.WHITE, 5, true);
		//    	Border borde2 = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE);
		panel2.setBorder(xd);

		JPanel panel = new JPanel();
		//        panel.add(panel3);
		panel.setBackground(Color.ORANGE);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				popup.hide();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (popup != null) {
					popup.hide();
				}
				JLabel text = new JLabel("You've clicked at: " + e.getPoint());
				panel2.removeAll();
				PanelPersonalizado.colocar(0, 0, 1, 1, 0, 0, 0, 0, 0, GridBagConstraints.WEST, 10, panel2, new JLabel(PanelPersonalizado.emoji("icon/error4.png", 24, 24)));
				GridBagConstraints c = new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST,  GridBagConstraints.HORIZONTAL, new Insets(10,10,10,10),0,0);
				panel2.add(text, c);
				text.setForeground(Color.WHITE);
				popup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), panel2, e.getXOnScreen(), e.getYOnScreen());
				popup.show();
			}
		});
		JFrame frm = new JFrame("Test");
		frm.add(panel);
		frm.setSize(400, 300);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}

}