
package Bethelhem_Tarekegn_1010616;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FileProperty implements Serializable {
    String createdBy;
    Date createdDate;
    String passWord;
    boolean editable;
    Date editedOn;

   
     private List<String> ModifiedBy = new ArrayList<String>();
    private List<Date> modifiedOn= new ArrayList<Date>();

    public FileProperty(String createdBy, Date createdDate, String passWord, boolean editable) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.passWord = passWord;
        this.editable = editable;
    }
    public FileProperty( String editedBy,Date editedDate) {
              
        this.modifiedOn.add(editedDate);
        this.ModifiedBy.add(editedBy);
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Date getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(Date editedOn) {
        this.editedOn = editedOn;
    }
     public List<String> getModifiedBy() {
        return ModifiedBy;
    }

    public List<Date> getModifiedOn() {
        return modifiedOn;
    }

    public void addToList(String str){
        ModifiedBy.add(str);
    }
    public void addToListDate(Date str){
        modifiedOn.add(str);
    }

    
}