package com.hit.view;

import com.hit.dm.searchItem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SearchItemCellRenderer extends JPanel implements ListCellRenderer<searchItem> {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    private Border border;
    private Border regborder;
    private JPanel panelText = new JPanel(new GridLayout(3, 0));
    private JLabel Jtag = new JLabel();
    private JLabel Jdescription = new JLabel();


    public SearchItemCellRenderer() {
        setOpaque(true);
        setLayout(new BorderLayout(5, 5));
        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        regborder = BorderFactory.createLineBorder(Color.BLACK, 4);
        setBorder(regborder);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends searchItem> list,
                                                  searchItem value, int index, boolean isSelected, boolean cellHasFocus) {

        panelText.add(Jtag);
        panelText.add(Jdescription);
        add(panelText, BorderLayout.CENTER);

        Jtag.setText(value.getTag());
        Jdescription.setText(value.getDescription());
        if (isSelected)

        {
            setBackground(Color.BLUE);
            setForeground(Color.BLUE);
        }
        else
        {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setFont(list.getFont());

        setEnabled(list.isEnabled());

        if (isSelected && cellHasFocus)
            setBorder(border);
        else
            setBorder(null);

        return this;
    }
}