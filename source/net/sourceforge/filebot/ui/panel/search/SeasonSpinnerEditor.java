
package net.sourceforge.filebot.ui.panel.search;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class SeasonSpinnerEditor extends JPanel implements ChangeListener {
	
	private final JLabel text = new JLabel();
	
	
	public SeasonSpinnerEditor(JSpinner spinner) {
		super(new BorderLayout());
		spinner.addChangeListener(this);
		setValueFromSpinner(spinner);
		
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setBackground(Color.WHITE);
		text.setOpaque(true);
		text.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
		text.setPreferredSize(new Dimension(60, 16));
		
		add(text, BorderLayout.CENTER);
	}
	

	public void stateChanged(ChangeEvent e) {
		setValueFromSpinner((JSpinner) e.getSource());
	}
	

	private void setValueFromSpinner(JSpinner spinner) {
		int season = ((SeasonSpinnerModel) spinner.getModel()).getSeason();
		
		if (season == SeasonSpinnerModel.ALL_SEASONS)
			text.setText("All Seasons");
		else
			text.setText("Season " + season);
	}
}
