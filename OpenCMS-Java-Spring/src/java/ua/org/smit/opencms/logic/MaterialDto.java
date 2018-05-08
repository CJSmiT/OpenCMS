/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.logic;

import java.sql.Timestamp;

/**
 *
 * @author smit
 */
public class MaterialDto {
    private int id;
    private String title;
    private String body;
    private String alias;
    private int categoryId;
    private int userCreaterId;
    private int hits;
    private boolean publicMaterial;
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

    public boolean isPublicMaterial() {
        return publicMaterial;
    }

    public void setIsPublicMaterial(boolean isPublic) {
        this.publicMaterial = isPublic;
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
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setTextBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MaterialDto{" + "id=" + id + ", title=" + title + ", body=" + body + ", alias=" + alias + ", categoryId=" + categoryId + ", userCreaterId=" + userCreaterId + ", hits=" + hits + ", isPublic=" + publicMaterial + ", lockerUserId=" + lockerUserId + ", realTimePublic=" + realTimePublic + ", timePublic=" + timePublic + '}';
    }
    
    
}
