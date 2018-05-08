/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.dto;

import java.sql.Timestamp;

/**
 *
 * @author smit
 */
public class MaterialGUIDto {
    private int id;
    private String title;
    private String textBody;
    private String alias;
    private int categoryId;
    private int userCreaterId;
    private int hits;
    private boolean isPublic;
    private int lockerUserId;
    private Timestamp realTimePublic;
    private Timestamp timePublic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserCreaterId() {
        return userCreaterId;
    }

    public void setUserCreaterId(int userCreaterId) {
        this.userCreaterId = userCreaterId;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public int getLockerUserId() {
        return lockerUserId;
    }

    public void setLockerUserId(int lockerUserId) {
        this.lockerUserId = lockerUserId;
    }

    public Timestamp getRealTimePublic() {
        return realTimePublic;
    }

    public void setRealTimePublic(Timestamp realTimePublic) {
        this.realTimePublic = realTimePublic;
    }

    public Timestamp getTimePublic() {
        return timePublic;
    }

    public void setTimePublic(Timestamp timePublic) {
        this.timePublic = timePublic;
    }
    
    public MaterialGUIDto() {
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }  
}