package jeswanthtexteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Find extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private int startIndex = 0;
    private int select_start = -1;

    JLabel lab1, lab2;
    JTextField textF, textR;
    JButton findBtn, findNext, replace, replaceAll, cancel;

    private JTextArea txt;

    public Find(JTextArea text) {
        this.txt = text;

        lab1 = new JLabel("Find:");
        lab2 = new JLabel("Replace:");
        textF = new JTextField(30);
        textR = new JTextField(30);

        findBtn = new JButton("Find");
        findNext = new JButton("Find Next");
        replace = new JButton("Replace");
        replaceAll = new JButton("Replace All");
        cancel = new JButton("Cancel");

        setLayout(null);

        lab1.setBounds(10, 10, 80, 20);
        add(lab1);
        textF.setBounds(90, 10, 120, 20);
        add(textF);

        lab2.setBounds(10, 40, 80, 20);
        add(lab2);
        textR.setBounds(90, 40, 120, 20);
        add(textR);

        findBtn.setBounds(225, 6, 115, 20);
        findNext.setBounds(225, 28, 115, 20);
        replace.setBounds(225, 50, 115, 20);
        replaceAll.setBounds(225, 72, 115, 20);
        cancel.setBounds(225, 94, 115, 20);

        add(findBtn);
        add(findNext);
        add(replace);
        add(replaceAll);
        add(cancel);

        findBtn.addActionListener(this);
        findNext.addActionListener(this);
        replace.addActionListener(this);
        replaceAll.addActionListener(this);
        cancel.addActionListener(this);

        setSize(360, 160);
        setLocationRelativeTo(txt);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // ---------------- FIND ----------------
    public void find() {
        String text = txt.getText().toLowerCase();
        String find = textF.getText().toLowerCase();

        select_start = text.indexOf(find, startIndex);

        if (select_start == -1) {
            startIndex = 0;
            JOptionPane.showMessageDialog(this,
                    "Could not find \"" + textF.getText() + "\"");
            return;
        }

        int select_end = select_start + find.length();
        txt.select(select_start, select_end);
        startIndex = select_end;
    }

    // ---------------- FIND NEXT ----------------
    public void findNext() {
        if (textF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter text to find");
            return;
        }
        find();
    }

    // ---------------- REPLACE ----------------
    public void replace() {
        if (txt.getSelectedText() != null) {
            txt.replaceSelection(textR.getText());
        } else {
            find();
        }
    }

    // ---------------- REPLACE ALL ----------------
    public void replaceAll() {
        if (!textF.getText().isEmpty()) {
            txt.setText(
                txt.getText().replaceAll("(?i)" + textF.getText(),
                textR.getText())
            );
        }
    }

    // ---------------- ACTION EVENTS ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == findBtn) {
            startIndex = 0;
            find();
        }
        else if (e.getSource() == findNext) {
            findNext();
        }
        else if (e.getSource() == replace) {
            replace();
        }
        else if (e.getSource() == replaceAll) {
            replaceAll();
        }
        else if (e.getSource() == cancel) {
            dispose();
        }
    }
}
