package edu.ap.ExamenPrep.view;

import edu.ap.ExamenPrep.persistence.BookCategory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class UI implements InitializingBean {

    JFrame jFrame;
    JPanel jPanelMain, jPanelLeft, jPanelRight;
    JTextField TFTitle, TFAuthor;
    JLabel LTitle, LAuthor,LCategory;
    JComboBox<BookCategory> DCategory;
    JButton BAddBook, BDeleteBook;

    @Autowired
    EventHandler eventHandler;

    public void setupUI(){

        jFrame = new JFrame("EightBall");
        jFrame.setLayout(new FlowLayout());

        jPanelMain = new JPanel();

        jPanelMain.setLayout(new GridLayout(3, 3));

        LTitle = new JLabel("Title");
        TFTitle = new JTextField(30);
        LAuthor = new JLabel("Author");
        TFAuthor = new JTextField(30);
        LCategory = new JLabel("Category");
        DCategory = new JComboBox(BookCategory.values());
        BAddBook = new JButton("Add Book");
        BDeleteBook = new JButton("Delete Book");

        jPanelMain.add(LTitle);
        jPanelMain.add(TFTitle);
        jPanelMain.add(BAddBook);
        jPanelMain.add(LAuthor);
        jPanelMain.add(TFAuthor);
        jPanelMain.add(BDeleteBook);
        jPanelMain.add(LCategory);
        jPanelMain.add(DCategory);

        jFrame.add(jPanelMain);
        jFrame.setSize(300, 300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.setProperty("java.awt.headless", "false");
    }
}
