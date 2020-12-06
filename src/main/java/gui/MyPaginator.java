package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class MyPaginator extends JPanel {
	
	
	JButton first;
	JButton back;
	JButton next;
	JButton page;
	JButton last;
	
	public MyPaginator() {
		setMaximumSize(new Dimension(240, 32));
		setPreferredSize(new Dimension(240, 32));
		setMinimumSize(new Dimension(240, 32));
		setFocusable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {25, 25, 25, 25};
		gridBagLayout.rowHeights = new int[]{23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		first = new JButton("<<");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		add(first, gbc_button);
		
		back = new JButton("<");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		add(back, gbc_btnNewButton);
		
		page = new JButton("1");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 0;
		add(page, gbc_button_1);
		
		next = new JButton(">");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 0;
		add(next, gbc_button_2);
		
		last = new JButton(">>");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 0;
		add(last, gbc_button_3);
	}

	public JButton getFirst() {
		return first;
	}

	public JButton getBack() {
		return back;
	}

	public JButton getNext() {
		return next;
	}

	public JButton getPage() {
		return page;
	}

	public JButton getLast() {
		return last;
	}
	
	
	public void setPage(Integer number) {
		this.page.setText(number.toString());
	}
	

}
