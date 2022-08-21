import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculator implements ActionListener {
    JFrame frame = new JFrame();
    JTextField textfield;
    JTextField answer;
    JButton[] numberbuttons = new JButton[10];
    JButton[] functionbuttons=new JButton[9];
    JButton addbutton,subbutton,mulbutton,divbutton;
    JButton decbutton,equbutton,delbutton,clrbutton,negbutton;
    JPanel panel;

    Font myfont = new Font("SANS_SERIF", Font.BOLD, 30);
    double num1=0,num2=0,result=0;
    char operator;

    calculator(){
        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 35);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        answer = new JTextField();
        answer.setText("");
        answer.setBounds(250, 60, 100, 35);
        answer.setFont(myfont);
        answer.setEditable(false);

        addbutton=new JButton("+");
        subbutton=new JButton("-");
        mulbutton=new JButton("*");
        divbutton=new JButton("/");
        clrbutton=new JButton("clear");
        equbutton=new JButton("=");
        negbutton=new JButton("(-)");
        decbutton=new JButton(".");
        delbutton=new JButton("delete");

        functionbuttons[0]=addbutton;
        functionbuttons[1]=subbutton;
        functionbuttons[2]=mulbutton;
        functionbuttons[3]=divbutton;
        functionbuttons[4]=decbutton;
        functionbuttons[5]=equbutton;
        functionbuttons[6]=negbutton;
        functionbuttons[7]=clrbutton;
        functionbuttons[8]=delbutton;

        for (int i=0;i<9;i++){
            functionbuttons[i].addActionListener(this);
            functionbuttons[i].setFont(myfont);
            functionbuttons[i].setFocusable(false);
        }

        for (int i=0;i<10;i++){
            numberbuttons[i] = new JButton(String.valueOf(i));
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setFont(myfont);
            numberbuttons[i].setFocusable(false);
        }

        negbutton.setBounds(50, 430, 95, 50);
        delbutton.setBounds(150, 430, 95, 50);
        clrbutton.setBounds(250, 430, 95, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4,10,10));

        panel.add(numberbuttons[1]);
        panel.add(numberbuttons[2]);
        panel.add(numberbuttons[3]);
        panel.add(addbutton);
        panel.add(numberbuttons[4]);
        panel.add(numberbuttons[5]);
        panel.add(numberbuttons[6]);
        panel.add(subbutton);
        panel.add(numberbuttons[7]);
        panel.add(numberbuttons[8]);
        panel.add(numberbuttons[9]);
        panel.add(divbutton);
        panel.add(decbutton);
        panel.add(numberbuttons[0]);
        panel.add(equbutton);
        panel.add(mulbutton);

        frame.add(panel);
        frame.add(answer);
        frame.add(negbutton);
        frame.add(clrbutton);
        frame.add(delbutton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        calculator calculator=new calculator();

    }
    public int count=1;
    public boolean mustclear=false;
    public char oldoperator=' ';
    public Double operations(Double num1,Double num2,char operator){
        switch (operator) {
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num1-num2;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num1/num2;
                break;
        }
        return result;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<10;i++){
            if (e.getSource()==numberbuttons[i]){
                if (mustclear==false){
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                }
                else{
                    textfield.setText("");
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                    mustclear=false;
                }
            }
        }
        if (e.getSource()==decbutton){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource()==addbutton){
            operator='+';

            if (count==1){
                num1 = Double.parseDouble(textfield.getText());
                textfield.setText("");
                oldoperator=operator;
                count++;
            }
            else{
                num2 = Double.parseDouble(textfield.getText());
                textfield.setText("");
                result=operations(num1,num2,oldoperator);
                answer.setText(String.valueOf(result));
                oldoperator=operator;
                System.out.println(result);
                num1=result;
            }

        }
        if (e.getSource()==subbutton){
            operator='-';
            if (count==1){
                num1 = Double.parseDouble(textfield.getText());
                oldoperator=operator;
                textfield.setText("");
                count++;
            }
            else{
                num2 = Double.parseDouble(textfield.getText());
                textfield.setText("");
                result=operations(num1,num2,oldoperator);
                answer.setText(String.valueOf(result));
                oldoperator=operator;
                System.out.println(result);
                num1=result;
            }
        }
        if (e.getSource()==mulbutton){
            operator='*';
            if (count==1){
                num1 = Double.parseDouble(textfield.getText());
                oldoperator=operator;
                textfield.setText("");
                count++;
            }
            else{
                num2 = Double.parseDouble(textfield.getText());
                textfield.setText("");
                result=operations(num1,num2,oldoperator);
                answer.setText(String.valueOf(result));
                oldoperator=operator;
                System.out.println(result);
                num1=result;
            }
        }
        if (e.getSource()==divbutton){
            operator='/';
            if (count==1){
                num1 = Double.parseDouble(textfield.getText());
                oldoperator=operator;
                textfield.setText("");
                count++;
            }
            else{
                num2 = Double.parseDouble(textfield.getText());
                textfield.setText("");
                result=operations(num1,num2,oldoperator);
                answer.setText(String.valueOf(result));
                oldoperator=operator;
                System.out.println(result);
                num1=result;
            }
        }
        if (e.getSource()==equbutton){
            num2 = Double.parseDouble(textfield.getText());

            result=operations(num1,num2,operator);
            answer.setText(String.valueOf(result));
            textfield.setText(String.valueOf(result));
            mustclear=true;
            count=1;
            num1=result;
        }
        if (e.getSource() == clrbutton) {
            textfield.setText("");
            result=0;
            num1=0;
            num2=0;
            count=1;
        }
        if (e.getSource() == delbutton) {
            String string=textfield.getText();
            textfield.setText("");
            for (int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negbutton) {
            Double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));

        }
    }
}