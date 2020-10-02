import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.GridLayout;


public class Calculator {
    static JFrame frame = new JFrame();
    static JLabel label = new JLabel();
    static JLabel label2 = new JLabel();
    static JTextArea text = new JTextArea();
    static JButton B1 = new JButton("1");
    static JButton B2 = new JButton("2");
    static JButton B3 = new JButton("3");
    static JButton B4 = new JButton("4");
    static JButton B5 = new JButton("5");
    static JButton B6 = new JButton("6");
    static JButton B7 = new JButton("7");
    static JButton B8 = new JButton("8");
    static JButton B9 = new JButton("9");
    static JButton B0 = new JButton("0");
    static JButton Bplus = new JButton("+");
    static JButton Bminus = new JButton("-");
    static JButton Bmultiply = new JButton("*");
    static JButton Bdivide = new JButton("/");
    static JButton Bdot = new JButton(".");
    static JButton Benter = new JButton("Enter");
    static ArrayList<String> A = new ArrayList<>();
    static String input = "";
    static int i;
    public static void startup() {
        label2.setLayout(new GridLayout(2, 1));
        label2.add(text);
        text.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setLayout(new GridLayout(4, 4));
        label.add(B1);
        label.add(B2);
        label.add(B3);
        label.add(Bmultiply);
        label.add(B4);
        label.add(B5);
        label.add(B6);
        label.add(Bdivide);
        label.add(B7);
        label.add(B8);
        label.add(B9);
        label.add(Bminus);
        label.add(B0);
        label.add(Bdot);
        label.add(Benter);
        label.add(Bplus);
        label2.add(label);
        frame.setSize(500, 500);
        frame.add(label2);
        frame.setVisible(true);
    }
    public static void listeners() {
        B1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "1";
                text.append("1");
            }});
        B2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "2";
                text.append("2");
            }});
        B3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "3";
                text.append("3");
            }});
        B4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "4";
                text.append("4");
            }});
        B5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "5";
                text.append("5");
            }});
        B6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "6";
                text.append("6");
            }});
        B7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "7";
                text.append("7");
            }});
        B8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "8";
                text.append("8");
            }});
        B9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "9";
                text.append("9");
            }});
        B0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += "0";
                text.append("0");
            }});
        Bplus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += " + ";
                text.append("+");
            }});
        Bminus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += " - ";
                text.append("-");
            }});
        Bmultiply.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += " * ";
                text.append("*");
            }});
        Bdivide.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += " / ";
                text.append("/");
            }});
        Bdot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input += ".";
                text.append(".");
            }});
        Benter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calc();
            }});
    }
    public static void calc() {
        String[] array = (input.split(" "));
        for (i = 0; i < array.length; i++) {
            A.add(array[i]);
        }
        i = 0;
        while(i < A.size() - 1) {
            switch (A.get(i)) {
                case "/":
                A.set(i-1, String.valueOf(Double.valueOf(A.get(i-1)) / Double.valueOf(A.get(i+1))));
                A.remove(i);
                A.remove(i);
                break;
                case "*":
                A.set(i-1, String.valueOf(Double.valueOf(A.get(i-1)) * Double.valueOf(A.get(i+1))));
                A.remove(i);
                A.remove(i);
                break;
                default:
                i++;
                break;
            }
        }
        i = 0;
        while(i < A.size()) {
            switch (A.get(i)) {
                case "+":
                A.set(i-1, String.valueOf(Double.valueOf(A.get(i-1)) + Double.valueOf(A.get(i+1))));
                A.remove(i);
                A.remove(i);
                break;
                case "-":
                A.set(i-1, String.valueOf(Double.valueOf(A.get(i-1)) - Double.valueOf(A.get(i+1))));
                A.remove(i);
                A.remove(i);
                break;
                default:
                i++;
                break;
            }
        }
        text.setText(A.get(0) + "\n");
        input = "";
        A.remove(0);
        Arrays.fill(array, null);
    }
    public static void main(String[] args) {
        startup();
        listeners();
    }
}