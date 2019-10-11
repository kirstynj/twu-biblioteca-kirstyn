package com.twu.biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BibliotecaInterface extends JFrame{
    private JButton QUITButton;
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
    private JTextArea movielist;
    private JButton loginbtn;
    private JPanel libraryFunctions;
    private JTextArea booksCheckedOut;
    private JButton viewInfo;
    private JTextArea userInfo;


    public BibliotecaInterface() {

        BookList.BookList();
        MovieList.MovieList();
        listOfBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBookList(booklist, BookList.getBookList());
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
                //check if input text is acceptable.
                if(bookInput.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a book to check out");
                }
                else if (CheckOut.containsBook(bookInput, BookList.getBookList())){
                    CheckOut.checkOutBook(bookInput, BookList.getBookList());
                    updateBookList(booklist, BookList.getBookList());
                    updateBookList(booksCheckedOut, CheckOut.getCheckedOut());
                    JOptionPane.showMessageDialog(null, "Thank you! Enjoy the book");
                    checkOutBook.setText("");
                } else{
                    JOptionPane.showMessageDialog(null, "Please select a valid option");
                }
            }
        });
        returnBB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //return book
                String returnInput = returnBook.getText();
                if(returnInput.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a book to check out");
                }
                else if(CheckOut.containsBook(returnInput, CheckOut.getCheckedOut())){
                    ReturnBook.ReturnBook(returnInput, CheckOut.getCheckedOut());
                    updateBookList(booklist, BookList.getBookList());
                    updateBookList(booksCheckedOut, CheckOut.getCheckedOut());
                    JOptionPane.showMessageDialog(null, "Thank you for returning the book");
                    returnBook.setText("");
                } else{
                    JOptionPane.showMessageDialog(null, "Please select a valid option");
                }

            }
        });
        QUITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        listOfMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMovieList(movielist);
            }
        });
        checkOutMB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //when button is clicked get the input and check the book out.
                String movieInput = checkOutMovie.getText();
                //check if input text is acceptable.
                if(movieInput.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a movie to check out");
                }
                else if (CheckOut.containsMovie(movieInput, MovieList.getMovieList())){
                    CheckOut.checkOutMovie(movieInput, MovieList.getMovieList());
                    updateMovieList(movielist);
                    JOptionPane.showMessageDialog(null, "Thank you! Enjoy the movie");
                    checkOutMovie.setText("");
                } else{
                    JOptionPane.showMessageDialog(null, "Please select a valid option");
                }
            }
        });

        libraryFunctions.setVisible(false);
        userInfo.setVisible(false);
        UserList.UserList();
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code from https://tech.chitgoks.com/2012/12/05/how-to-create-a-login-password-dialog-using-only-joptionpane/
                //shortcut to making login using JOptionPane
                JLabel label_login = new JLabel("Username:");
                JTextField login = new JTextField();

                JLabel label_password = new JLabel("Password:");
                JPasswordField password = new JPasswordField();

                Object[] array = { label_login,  login, label_password, password };

                int res = JOptionPane.showConfirmDialog(null, array, "Login",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);

                if (res == JOptionPane.OK_OPTION) {
                    //check if credentials are correct.
                    if (Login.Login(login.getText().trim(), new String(password.getPassword()), UserList.getUsers())){
                        System.out.println("username: " + login.getText().trim());
                        System.out.println("password: " + new String(password.getPassword()));

                        //when login the jpanel is shown else its hidden
                        libraryFunctions.setVisible(true);
                        userInfo.setVisible(true);
                        loginbtn.setVisible(false);

                        User currentUser = UserList.findUser(login.getText().trim());
                        userInfo.append("Name:" + currentUser.getName()+ " email:" + currentUser.getEmail() + "Phone Number: "+ currentUser.getNumber().toString());
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Incorrect credentials");
                    }
                }

            }
        });

        updateBookList(booksCheckedOut, CheckOut.getCheckedOut());
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

    public static void updateBookList(JTextArea list, ArrayList<Book> booklist){
        list.setText("");

        int i = 0;
        while (i< booklist.size()){
            list.append(booklist.get(i).toString());
            i++;
        }
    }
    public static void updateMovieList(JTextArea list){
        list.setText("");

        int i = 0;
        while (i< MovieList.getMovieList().size()){
            list.append(MovieList.getMovieList().get(i).toString());
            i++;
        }
    }
}
