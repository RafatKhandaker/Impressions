package com.blackjack.Model;

import lombok.Data;

@Data
public class RegisterForm {

    String txtFName;
    String txtLName; 
    int zipcode;
    String txtSummaryField;
    String radSex;
    String[] multiCheckInterests;
    String txtJoinThoughts;
    
    
    public void settxtFname(String txtFName) { 
		this.txtFName = txtFName; 
	}
    
    public void settxtLname(String txtLName) { 
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
