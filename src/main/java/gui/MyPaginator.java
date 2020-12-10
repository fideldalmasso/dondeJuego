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

	Integer datasize;
	Integer rowsperpage;
	Integer totalpages;
	Integer actualpage;

	public Integer getTotalpages() {
		return totalpages;
	}

	JButton first;
	JButton back;
	JButton next;
	JButton page;
	JButton last;

	private void update() {

		if(actualpage==1) {
			first.setEnabled(false);
			back.setEnabled(false);
		}
		else {
			first.setEnabled(true);
			back.setEnabled(true);
		}
		if(actualpage>=totalpages || datasize==0) {
			next.setEnabled(false);
			last.setEnabled(false);
		}
		else {
			next.setEnabled(true);
			last.setEnabled(true);
		}
	}


	public MyPaginator(Integer rowsperpage) {
		this.actualpage=1;
		this.rowsperpage = rowsperpage;
		

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
		page.setFocusable(false);
		page.setFocusPainted(false);
		page.setPreferredSize(new Dimension(50,31));
		page.setMinimumSize(new Dimension(50,31));

		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 0;
		add(page, gbc_button_1);
		Gui.imprimir(page.getPreferredSize().toString());

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

		first.setEnabled(false);
		back.setEnabled(false);
		next.setEnabled(false);
		last.setEnabled(false);

		first.addActionListener(e->{
			this.setPage(1);
		});
		back.addActionListener(e->{
			this.setPage(actualpage-1);
		});
		next.addActionListener(e->{
			this.setPage(actualpage+1);
		});
		last.addActionListener(e->{
			this.setPage(totalpages);
		});


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

	private void setPage(Integer i) {
		if(i<=0 || i>totalpages)
			Gui.imprimir("el numero del paginador es invalido i= "+i+" total pages= "+totalpages);

		this.actualpage=i;
		this.page.setText(i.toString());
		this.update();
	}

	public void setDataSize(Integer size) {
		this.datasize=size;
		this.totalpages= (int) Math.ceil((double) datasize/ rowsperpage);
		if(size==0) totalpages=1; 
		this.setPage(1);
//		this.update();
	}

}
