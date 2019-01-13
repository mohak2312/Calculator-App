/*Autor: Mohak patel
*Date: 12-oct-2018
*
* Description:
* The calculator accept two decimal (non-negative, decimal point allowed) operand values from the user and perform
* one of 6 functions (Add, Subtract, Multiply, Divide, Percent, and Square Root). The first four operations take both operands.
* Percent and square root only take a single operand. TextView widget shows the result of the operation.
*/

//unique package for calculator app
package calculator_r0.edu.pdx.mohak.ece558.calculator;

//Built in packages
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Built in package to compute the square root operation
import static java.lang.Math.sqrt;

public class CalculatorActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    //Create the variable for inputs and output
    private EditText minput1;
    private EditText minput2;
    private TextView result;

    // OnCreate is called when the CalculatorActivity activity
    // is started.
    // super.xxx method whenever we override a method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // calls the super.onCreate() method and inflates
        // the layout with an ID of R.id.layout.activity_calculator_const
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // returns the EditText objects for each of the text boxes
        // minput1 is the operand 1 EditText object, minput2 is
        // the operand 2 EditText object, Result is the result of operation
        // (TextView).
        minput1 =  findViewById(R.id.editText1);
        minput2 =  findViewById(R.id.editText2);
        result =  findViewById(R.id.textView_result);

        // Handle the Calculate add Button
        // by getting the Calculate add button object
        // The onClick() method listens for a "button clicked"
        // event for the "Calculate add" button. When
        // the event occurs we check that the operand 1 and operand 2
        // values are valid and calculates addition= operand 1+ operand 2

        Button add = findViewById(R.id.button_op_plus);
        add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // check that the operand 1 and operand 2 values are valid.  If
                // not, pop up a warning to the user and clear all of the inputs
                if (!isValidInput(true, true)) {
                    Toast.makeText(CalculatorActivity.this,
                            "ERROR: Enter new operand value(s)",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                } else {
                    //Operand 1 and operand 2 value is correct ,
                    //Calculate the addition operation
                    double r = Double.parseDouble(minput1.getText().toString()) +
                            Double.parseDouble(minput2.getText().toString());
                    result.setText(String.format("%.04f", r));
                }
            }
        });


        // Handle the Calculate minus Button
        // by getting the Calculate minus button object
        // The onClick() method listens for a "button clicked"
        // event for the "Calculate subtraction" button. When
        // the event occurs we check that the operand 1 and operand 2
        // values are valid and calculates Subtraction= operand 1 - operand 2
        Button sub = findViewById(R.id.button_op_minus);
        sub.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // check that the operand 1 and operand 2 values are valid.  If
                // not, pop up a warning to the user and clear all of the inputs
                if (!isValidInput(true, true)) {
                    Toast.makeText(CalculatorActivity.this,
                            "ERROR: Enter new operand value(s)",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                } else {
                    //Operand 1 and operand 2 value is correct ,
                    //Calculate the subtraction operation
                    double r = Double.parseDouble(minput1.getText().toString()) -
                            Double.parseDouble(minput2.getText().toString());
                    result.setText(String.format("%.04f", r));
                }
            }
        });

        // Handle the Calculate multiplication Button
        // by getting the Calculate multiplication button object
        // The onClick() method listens for a "button clicked"
        // event for the "Calculate multiplication" button. When
        // the event occurs we check that the operand 1 and operand 2
        // values are valid and calculates multiplication= operand 1* operand 2

        Button mul = findViewById(R.id.button_op_mult);
        mul.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // check that the operand 1 and operand 2 values are valid.  If
                // not, pop up a warning to the user and clear all of the inputs
                if (!isValidInput(true, true)) {
                    Toast.makeText(CalculatorActivity.this,
                            "ERROR: Enter new operand value(s)",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                } else {
                    //Operand 1 and operand 2 value is correct ,
                    //Calculate the multiplication operation
                    double r = Double.parseDouble(minput1.getText().toString()) *
                            Double.parseDouble(minput2.getText().toString());
                    result.setText(String.format("%.04f", r));
                }
            }
        });

        // Handle the Calculate division Button
        // by getting the Calculate division button object
        // The onClick() method listens for a "button clicked"
        // event for the "Calculate division" button. When
        // the event occurs we check that the operand 1 and operand 2
        // values are valid and calculates addition= operand 1/ operand 2

        Button div = findViewById(R.id.button_op_div);
        div.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // check that the operand 1 and operand 2 values are valid.  If
                // not, pop up a warning to the user and clear all of the inputs
                if (!isValidInput(true, true)) {
                    Toast.makeText(CalculatorActivity.this,
                            "ERROR: Enter new operand value(s)",
                            Toast.LENGTH_SHORT).show();
                    clear_input();

                }
                //Operand 1 and operand 2 value is correct ,
                // Check operand 2 value is zero, if yes then
                //pop up a warning to the user and clear all of the inputs
                //if not then Calculate the division operation
                else if( Double.parseDouble(minput2.getText().toString()) == 0){
                    Toast.makeText(CalculatorActivity.this,
                            "ERROR: Enter new operand value(s)",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                }
                else {

                    double r = Double.parseDouble(minput1.getText().toString()) /
                            Double.parseDouble(minput2.getText().toString());
                    result.setText(String.format("%.04f", r));
                }
            }
        });

        // Handle the Calculate percentage Button
        // by getting the Calculate percentage button object
        // The onClick() method listens for a "button clicked"
        // event for the "Calculate percentage" button. When
        // the event occurs we check that the operand 1
        // value is valid and calculates percentage= operand 1/100

        Button percentage = findViewById(R.id.button_op_pct);
        percentage.setOnClickListener(new View.OnClickListener(){

            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                // check that the operand 1 value is valid.  If
                // not, pop up a warning to the user and clear all of the inputs
                if ((!isValidInput(true, false))&&(!isValidInput(true, true))) {

                    Toast.makeText(CalculatorActivity.this,
                            "ERROR: Enter new operand value(s)",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                } else {
                    //Operand 1 value is correct ,
                    //Calculate the percentage operation
                        double r = Double.parseDouble(minput1.getText().toString()) / 100;
                    result.setText(String.format("%.04f", r));
                }
            }
        });
        // Handle the Calculate square root Button
        // by getting the Calculate square root button object
        // The onClick() method listens for a "button clicked"
        // event for the "Calculate square root" button. When
        // the event occurs we check that the operand 1
        // value is valid and calculates square root= square root of operand 1

        Button square_root = findViewById(R.id.button_op_sqrt);
        square_root.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // check that the operand 1 value is valid.  If
                // not, pop up a warning to the user and clear all of the inputs
                if ((!isValidInput(true, false))&&(!isValidInput(true, true))) {
                    Toast.makeText(CalculatorActivity.this,
                            "ERROR: Enter new operand value(s)",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                } else {
                    //Operand 1 value is correct ,
                    //Calculate the square root operation

                    double r = sqrt(Double.parseDouble(minput1.getText().toString()));
                    result.setText(String.format("%.04f", r));
                }
            }
        });
    }

    // Override the Activity lifecycle callbacks for logging
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
    /**
     *
     * Checks if the required input strings are valid.  The caller passes in parameters
     * to specify which values to check.
     *
     * @param NeedI1		true if the calculation needs a valid Input 1 String
     * @param NeedI2		true if the calculation needs a valid Input 2 String
     *
     * @return			true if the required inputs are valid, false otherwise
     */
    private boolean isValidInput(boolean NeedI1, boolean NeedI2) {
        //local variable
        //get the both inputs
        String Input1String = minput1.getText().toString();
        String Input2String = minput2.getText().toString();

        String dot=".";

        // Check if  < 0 or if the string is empty
        // or string is '.' or
        // We use a float because the user can enter values
        // that aren't integers
        // check the 1st input value
        if (NeedI1)
            if (Input1String.length() == 0)
                return false;
            else if(Input1String.length()== 1)
            {
                if (Input1String.equals(dot))
                    return false;
            }
            else if (Double.parseDouble(Input1String) < 0.00)
                return false;


        // Check if  < 0 or if the string is empty
        // or string is '.'
        // We use a float because the user can enter values
        // that aren't integers
        // check for second input value
        if (NeedI2)
            if (Input2String.length() == 0)
                return false;
            else if(Input2String.length()== 1)
            {
                if (Input2String.equals(dot))
                    return false;
            }
            else if (Double.parseDouble(Input2String) < 0.00)
                return false;

        return true;

    }


    /**
     * Clears the input text edit boxes
     * set the cursor to editbox 1 for 1st input
     */
    private void clear_input() {
        minput1.setText("");
        minput2.setText("");
        result.setText("");
        minput1.requestFocus();

    }

}
