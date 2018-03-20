package com.blackjack.Contracts;

public interface IForm {
	
    public void settxtFName(String txtFName); 
    public void settxtLName(String txtLName); 
    public void setzipcode(int zipcode);
    public void settxtSummaryField(String txtSummaryField);    
    public void setradSex(String radSex);
    public void setmultiCheckInterests(String[] multiCheckInterests);
    public void settxtJoinThoughts(String txtJoinThoughts);
   
      
    public String gettxtFName();
    public String gettxtLName();
    public int getzipcode();
    public String gettxtSummaryField();
    public String getradSex();
    public String[] getmultiCheckInterests();
    public String gettxtJoinThoughts();
}
