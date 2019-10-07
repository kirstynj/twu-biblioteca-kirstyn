package com.twu.biblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BibliotecaInterface extends JFrame{
    private JButton QUITButton;
    private JTable bookTable;
    private JTable table2;
    private JButton listOfBooksButton;
    private JButton listOfMoviesButton;
    private JTextField checkOutBook;
    private JTextField returnBook;
    private JTextField checkOutMovie;
    private JTextArea welcomeMessage;
    private JPanel main;
    private JTextArea booklist;
    private JButton checkOutBB;
    private JButton checkOutMB;
    private JButton returnBB;


    public BibliotecaInterface() {

        BookList.BookList();
        listOfBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBookList(booklist);
//                String[] columnNames = {"Title", "Author", "Year Published"};
//                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
//                bookTable = new JTable(tableModel);
//
//                ArrayList<Book> booklist = BookList.getBookList();
//                for (int i=0; i<booklist.size(); i++){
//                    String title = booklist.get(i).getTitle();
//                    String author = booklist.get(i).getAuthor();
//                    String year = booklist.get(i).getYear();
//
//                    Object[] data = {title, author, year};
//
//                    bookTable.addRow(data);
//                }
            }
        });
        welcomeMessage.setText(WelcomeMessage.getWelcomeMessage());

        checkOutBB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //when button is clicked get the input and check the book out.
                String bookInput = checkOutBook.getText();
                checkOut.checkOut(bookInput, BookList.getBookList());
                //need error handling for wrong input and stuff
                updateBookList(booklist);
                JOptionPane.showMessageDialog(null, "Thank you! Enjoy the book");
                checkOutBook.setText("");
            }
        });
        returnBB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //return book
                String returnInput = returnBook.getText();
                ReturnBook.ReturnBook(returnInput, checkOut.getCheckedOut());
                updateBookList(booklist);
                JOptionPane.showMessageDialog(null, "Thank you for returning the book");
                returnBook.setText("");
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Biblioteca");
        frame.setContentPane(new BibliotecaInterface().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }

    public static void updateBookList(JTextArea list){
        list.setText("");

        int i = 0;
        while (i< BookList.getBookList().size()){
            list.append(BookList.getBookList().get(i).toString());
            i++;
        }
    }
}
