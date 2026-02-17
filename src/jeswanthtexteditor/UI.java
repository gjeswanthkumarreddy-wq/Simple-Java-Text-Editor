package jeswanthtexteditor;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class UI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextArea textArea;
    private JMenuItem clearFile, quickFind;

    public UI() {
        setTitle("Untitled | Jeswanth Text Editor");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuEdit = new JMenu("Edit");
        JMenu menuSearch = new JMenu("Search");

        menuBar.add(menuEdit);
        menuBar.add(menuSearch);

        clearFile = new JMenuItem("Clear");
        clearFile.addActionListener(this);
        menuEdit.add(clearFile);

        menuEdit.add(new JMenuItem(new DefaultEditorKit.CutAction()));
        menuEdit.add(new JMenuItem(new DefaultEditorKit.CopyAction()));
        menuEdit.add(new JMenuItem(new DefaultEditorKit.PasteAction()));

        quickFind = new JMenuItem("Find");
        quickFind.addActionListener(this);
        menuSearch.add(quickFind);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        new DropTarget(textArea, new DropTargetAdapter() {
            public void drop(DropTargetDropEvent e) {
                try {
                    e.acceptDrop(DnDConstants.ACTION_COPY);
                    File file = (File) e.getTransferable()
                            .getTransferData(DataFlavor.javaFileListFlavor);
                    textArea.setText(
                            new String(new FileInputStream(file).readAllBytes())
                    );
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearFile) {
            textArea.setText("");
        } else if (e.getSource() == quickFind) {
            new Find(textArea);
        }
    }
}
