package com.blackjack.Model;

import com.blackjack.Contracts.IForm;

import lombok.Data;

@Data
public class RegisterForm implements IForm{

    String txtFName;
    String txtLName; 
    int zipcode;
    String txtSummaryField;
    String radSex;
    String[] multiCheckInterests;
    String txtJoinThoughts;
    
    
    public void settxtFName(String txtFName) { 
		this.txtFName = txtFName; 
	}
    
    public void settxtLName(String txtLName) { 
		this.txtLName = txtLName; 
    }
    
    public void setzipcode(int zipcode) {
    		this.zipcode = zipcode;
    }
    
    public void settxtSummaryField(String txtSummaryField) {
    		this.txtSummaryField = txtSummaryField;
    }
    
    public void setradSex(String radSex) {
    		this.radSex = radSex;
    }
    
    public void setmultiCheckInterests(String[] multiCheckInterests) {
    		this.multiCheckInterests = multiCheckInterests;
    }

    public void settxtJoinThoughts(String txtJoinThoughts) {
    		this.txtJoinThoughts = txtJoinThoughts;
    }
   
    
    
    public String gettxtFName() { 
		return this.txtFName; 
	}

    public String gettxtLName() { 
    		return this.txtLName; 
    }
    
    public int getzipcode() {
		return this.zipcode;
    }

    public String gettxtSummaryField() {
		return this.txtSummaryField;
    }

    public String getradSex() {
		return this.radSex;
    }

    public String[] getmultiCheckInterests() {
		return this.multiCheckInterests;
    }

    public String gettxtJoinThoughts() {
		return this.txtJoinThoughts;
    }

    
}
