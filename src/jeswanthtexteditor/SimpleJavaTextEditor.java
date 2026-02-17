package jeswanthtexteditor;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleJavaTextEditor {

    public static final String AUTHOR_EMAIL = "gkumarre@gitam.in";
    public static final String NAME = "Jeswanth Text Editor";
    public static final String EDITOR_EMAIL = "gjeswanthkumarreddy@gmail.com";
    public static final double VERSION = 1.0;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName()
            );
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new UI().setVisible(true);
    }
}
