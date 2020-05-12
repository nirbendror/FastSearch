package com.hit.view;

import com.hit.Client.Messages.Request;
import com.hit.Client.Messages.eActions;
import com.hit.Client.Messages.eAlgoType;
import com.hit.dm.searchItem;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Enumeration;
import java.util.Observable;


public class MainViewActionListener extends Observable implements ActionListener, ListSelectionListener {

	private MainView view;


	public MainViewActionListener(MainView mainView) {
		this.view = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "clear":
				view.clear();
				break;

			case "search": {
				view.getSearchList().clearSelection();
				eAlgoType algoType = eAlgoType.Naive;
				if (isValidSearch())
				{
					 switch(getSelectedButtonText(view.getG1())){
						 case "KMP":
						 	algoType = eAlgoType.KMP;
						 	break;
						 case "Rabin Karp":
							 algoType = eAlgoType.RabinKarp;
							 break;
						 case "Naive":
							 algoType = eAlgoType.Naive;
							 break;
					 };
					System.out.println(algoType);
					Request request = new Request(eActions.Search,null,view.getSearchField().getText(),algoType);
					Update(request);
				};
				break;
			}
			case "Delete":
				break;

			case "DeleteAll":
				view.GetHistoryTree().DeleteAll();
				break;
		}
	}
	private String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}
	private boolean isValidSearch() {
		boolean valid = true;

		if (view.getSearchField().getText().equals("")) {
			JOptionPane.showMessageDialog(view, "Invalid search. Please try again.");
			valid = false;
		}

		if (!(view.getKmp().isSelected() || view.getNaive().isSelected() || view.getRabinKarp().isSelected())) {
			JOptionPane.showMessageDialog(view, "Select a search algorithm");
			valid = false;
		}
		return valid;
	}
	public void valueChanged(ListSelectionEvent e) {

		if (e.getValueIsAdjusting())
			System.out.println("Value Changed");

		String url = ((searchItem) view.getSearchList().getSelectedValue()).getLink();

		//Assume browser is supported on Desktop API
		try {
			Desktop.getDesktop().browse(new URI(url));

		} catch (Exception exp) {
			System.out.println();
		}
	}
	private void Update(Request request)
	{
		setChanged();
		notifyObservers(request);
	}

}
