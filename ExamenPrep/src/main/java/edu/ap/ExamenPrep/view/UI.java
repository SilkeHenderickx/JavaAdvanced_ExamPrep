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
        BAddBook.addActionListener(eventHandler::whenAddButtonClicked);
        BDeleteBook = new JButton("Delete Book by Title");
        BDeleteBook.addActionListener(eventHandler::whenDeleteButtonClicked);

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

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }

    public void setjPanelMain(JPanel jPanelMain) {
        this.jPanelMain = jPanelMain;
    }

    public JPanel getjPanelLeft() {
        return jPanelLeft;
    }

    public void setjPanelLeft(JPanel jPanelLeft) {
        this.jPanelLeft = jPanelLeft;
    }

    public JPanel getjPanelRight() {
        return jPanelRight;
    }

    public void setjPanelRight(JPanel jPanelRight) {
        this.jPanelRight = jPanelRight;
    }

    public JTextField getTFTitle() {
        return TFTitle;
    }

    public void setTFTitle(JTextField TFTitle) {
        this.TFTitle = TFTitle;
    }

    public JTextField getTFAuthor() {
        return TFAuthor;
    }

    public void setTFAuthor(JTextField TFAuthor) {
        this.TFAuthor = TFAuthor;
    }

    public JLabel getLTitle() {
        return LTitle;
    }

    public void setLTitle(JLabel LTitle) {
        this.LTitle = LTitle;
    }

    public JLabel getLAuthor() {
        return LAuthor;
    }

    public void setLAuthor(JLabel LAuthor) {
        this.LAuthor = LAuthor;
    }

    public JLabel getLCategory() {
        return LCategory;
    }

    public void setLCategory(JLabel LCategory) {
        this.LCategory = LCategory;
    }

    public JComboBox<BookCategory> getDCategory() {
        return DCategory;
    }

    public void setDCategory(JComboBox<BookCategory> DCategory) {
        this.DCategory = DCategory;
    }

    public JButton getBAddBook() {
        return BAddBook;
    }

    public void setBAddBook(JButton BAddBook) {
        this.BAddBook = BAddBook;
    }

    public JButton getBDeleteBook() {
        return BDeleteBook;
    }

    public void setBDeleteBook(JButton BDeleteBook) {
        this.BDeleteBook = BDeleteBook;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.setProperty("java.awt.headless", "false");
    }
}
