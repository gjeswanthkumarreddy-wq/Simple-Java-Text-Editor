package jeswanthtexteditor;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class About {

    private final JFrame frame;
    private final JPanel panel;
    private final JLabel text;

    public About(UI ui) {
        frame = new JFrame();
        panel = new JPanel(new FlowLayout());
        text = new JLabel();

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(text);

        frame.add(panel);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(ui);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public void me() {
        frame.setTitle("About Me - " + SimpleJavaTextEditor.NAME);

        text.setText(
            "<html><body>" +
            "<p>" +
            "Author: Pierre-Henry Soria<br/>" +
            "Email: " + SimpleJavaTextEditor.AUTHOR_EMAIL + "<br/><br/>" +
            "Modified By: Achintha Gunasekara<br/>" +
            "Email: " + SimpleJavaTextEditor.EDITOR_EMAIL +
            "</p>" +
            "</body></html>"
        );
    }

    public void software() {
        frame.setTitle("About Software - " + SimpleJavaTextEditor.NAME);

        text.setText(
            "<html><body>" +
            "<p>" +
            "Name: " + SimpleJavaTextEditor.NAME + "<br/>" +
            "Version: " + SimpleJavaTextEditor.VERSION +
            "</p>" +
            "</body></html>"
        );
    }
}
