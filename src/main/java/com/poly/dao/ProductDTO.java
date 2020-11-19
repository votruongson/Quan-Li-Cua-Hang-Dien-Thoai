/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.model.Product;
import java.io.Serializable;

/**
 *
 * @author Thanh Hau
 */
public class ProductDTO implements Serializable {
    private Product sanpham;
    private int quantity;
    public ProductDTO() {

    }

    public ProductDTO(Product sp) {
        this.sanpham = sp;
        this.quantity = 1;
    }

    public Product getSanpham() {
        return sanpham;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSanpham(Product sanpham) {
        this.sanpham = sanpham;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

