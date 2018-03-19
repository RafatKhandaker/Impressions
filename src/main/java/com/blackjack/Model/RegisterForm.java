package com.blackjack.Model;

import lombok.Data;

@Data
public class RegisterForm {

    String textField;
 
    String textareaField;
 
    String datetimeField;
 
    String colorField;
 
    boolean singleCheckboxField;
 
    String[] multiCheckboxSelectedValues;
 
    String radioButtonSelectedValue;
    
    String dropdownSelectedValue;

}
