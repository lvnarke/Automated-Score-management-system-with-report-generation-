package sample;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sample.Do_OCR.*;

public class Error implements Initializable {
    public Label label1;
    public TextArea text_q1, text_q2, text_q3, text_t1, text_t2, text_t3, text_assgn, text_lab, text_ss, text_usn, text_ccode;
    public void initialize(URL location, ResourceBundle resources)  {
        label1.setText(e1+e2+e3+e4);
        text_q1.setText(""+quiz_1);
        text_q2.setText(""+quiz_2);
        text_q3.setText(""+quiz_3);
        text_t1.setText(""+test_1);
        text_t2.setText(""+test_2);
        text_t3.setText(""+test_3);
        text_assgn.setText(""+assignment);
        text_ccode.setText(""+ccode);
        text_ss.setText(""+selfstudy);
        text_lab.setText(""+lab);
        text_usn.setText(""+usn);


    }


    public void submit(ActionEvent event) throws Exception{
        Insert insert = new Insert();
        while ((b1 == false) || (b2 == false) || (b3 == false) || (b4 == false) || (b5 == false) || (b6 == false) || (b7 == false)) {


                usn = text_usn.getText();
                Pattern pat= Pattern.compile(reg1);
                Matcher mat = pat.matcher(usn);
                b1 = mat.matches();

                ccode = text_ccode.getText();
                Pattern pat1= Pattern.compile(reg2);
                Matcher mat1 = pat1.matcher(ccode);
                b2 = mat1.matches();

                quiz_1 = Float.parseFloat("" + text_q1.getText());
                quiz_2 = Float.parseFloat("" + text_q2.getText());
                quiz_3 = Float.parseFloat("" + text_q3.getText());
                b3 = true;
                if(quiz_1 >10 && quiz_2 >10 && quiz_3 >10)
                    b3=false;


                test_1 = Float.parseFloat("" + text_t1.getText());
                test_2 = Float.parseFloat("" + text_t2.getText());
                test_3 = Float.parseFloat("" + text_t3.getText());
                System.out.println("Test Marks: "+test_1+" "+test_2+" "+test_3);
                b4 = true;


                lab = Float.parseFloat("" + text_lab.getText());
                b5 = true;
                if(lab >50)
                    b5=false;


                selfstudy = Float.parseFloat("" + text_ss.getText());
                b6 = true;
                if (selfstudy > 20)
                    b6 = false;


                assignment = Float.parseFloat("" + text_assgn.getText());
                b7 = true;
                if (assignment > 10)
                    b7 = false;
            }
        if(b1 && b2 && b3 && b4 && b5 && b6 && b7) {
            insert.insertintoquiz(usn, ccode, quiz_1, quiz_2, quiz_3);
            insert.insertintotest(usn, ccode, test_1, test_2, test_3);
            insert.insertintoassgn(ccode, usn, assignment, lab, selfstudy);
            System.out.println("Inserted");

            stage2.close();
        }

        }

    }

