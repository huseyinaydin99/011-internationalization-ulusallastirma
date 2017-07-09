/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huseyinaydin;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author husey
 */
@ManagedBean(name = "language")
@RequestScoped
public class DillerBean implements Serializable{

    /**
     * Creates a new instance of DillerBean
     */
    private String yerelKod;
    private static Map<String,Object> ulkeler;
    
    static{
        ulkeler = new LinkedHashMap<String,Object>();
        ulkeler.put("English", Locale.ENGLISH);
        ulkeler.put("deutsch", Locale.GERMANY);
        ulkeler.put("中国", Locale.SIMPLIFIED_CHINESE);
        
    }

    public String getYerelKod() {
        return yerelKod;
    }

    public void setYerelKod(String yerelKod) {
        this.yerelKod = yerelKod;
    }

    public Map<String, Object> getUlkeler() {
        return ulkeler;
    }

    public void setUlkeler(Map<String, Object> ulkeler) {
        this.ulkeler = ulkeler;
    }
    
    //değer değişimi olay dinleyicisi
    public void ulkeninYerelKoduDegisti(ValueChangeEvent changeEvent){
        String yeniYerelKodDegeri = changeEvent.getNewValue().toString();
        for(Map.Entry<String,Object> entry : ulkeler.entrySet()){
            if(entry.getValue().toString().equals(yeniYerelKodDegeri)){
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
            }
        }
    }
}
