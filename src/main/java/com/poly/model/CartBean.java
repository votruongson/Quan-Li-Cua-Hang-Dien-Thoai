/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.model;

import com.poly.dao.ProductDTO;
import java.util.HashMap;

/**
 *
 * @author Thanh Hau
 */
public class CartBean extends HashMap{
     public void addSanPham(ProductDTO sp){
        String key  = sp.getSanpham().getName();
        if(this.containsKey(key)){
            int oldQuantity =((ProductDTO)this.get(key)).getQuantity();
            ((ProductDTO)this.get(key)).setQuantity(oldQuantity+1);
        }else{
            this.put(sp.getSanpham().getName(),sp);
        }
    }
    public boolean removeSanPham(String name){
        if(this.containsKey(name)){
            this.remove(name);
            return  true;
        }
        return false;
        
    }
    public CartBean(){
        super();
    }
}
