/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.content.dao;

import java.sql.Timestamp;
import ua.org.smit.opencms.content.AliasMaker;

/**
 *
 * @author smit
 */
public class MaterialEntityCMS {
    private int id;
    private String title;
    private String textBody;
    private String alias;
    private int categoryId;
    private int userCreaterId = 0;//
    private int hits = 0;
    private boolean isPublic = false;
    private int lockerUserId = 1;
    private Timestamp realTimePublic;
    private Timestamp timePublic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void makeAlias() {
        this.alias = AliasMaker.generatorAlies(title);
    }

    public void makeCurrentTimePublic() {
        this.timePublic = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "MaterialEntityCMS{" + "id=" + id + ", title=" + title + ", textBody=" + textBody + ", alias=" + alias + ", categoryId=" + categoryId + ", userCreaterId=" + userCreaterId + ", hits=" + hits + ", isPublic=" + isPublic + ", lockerUserId=" + lockerUserId + ", realTimePublic=" + realTimePublic + ", timePublic=" + timePublic + '}';
    }
    
    
    
    
}