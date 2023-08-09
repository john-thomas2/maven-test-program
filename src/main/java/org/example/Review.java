package org.example;

public class Review {
    private int Year;
    private String Indagg;
    private String Indcode;
    private String Indname;
    private String units;
    private String varcode;
    private String varname;
    private String varval;
    private String val;
    private String indcd;

    public void setYear(int year) {
        Year = year;
    }

    public void setIndagg(String indagg) {
        Indagg = indagg;
    }

    public void setIndcode(String indcode) {
        Indcode = indcode;
    }

    public void setIndname(String indname) {
        Indname = indname;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setVarcode(String varcode) {
        this.varcode = varcode;
    }

    public void setVarname(String varname) {
        this.varname = varname;
    }

    public void setVarval(String varval) {
        this.varval = varval;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setIndcd(String indcd) {
        this.indcd = indcd;
    }

    public int getYear() {
        return Year;
    }

    public String getIndagg() {
        return Indagg;
    }

    public String getIndcode() {
        return Indcode;
    }

    public String getIndname() {
        return Indname;
    }

    public String getUnits() {
        return units;
    }

    public String getVarcode() {
        return varcode;
    }

    public String getVarname() {
        return varname;
    }

    public String getVarval() {
        return varval;
    }

    public String getVal() {
        return val;
    }

    public String getIndcd() {
        return indcd;
    }
}
