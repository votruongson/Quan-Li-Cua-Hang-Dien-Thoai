/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.model.Category;
import com.poly.model.Product;
import com.poly.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thanh Hau
 */
public class ProductDao extends ConnectDao {

    public ProductDao() {

    }

    public ArrayList<Product> fillAll() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM PRODUCT");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setPrice(rs.getInt("price"));
                pro.setNote(rs.getString("note"));
                pro.setImage(rs.getString("image"));
                pro.setCategory_id(rs.getInt("category_id"));
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getCategoryByID(int id) {
        String name = "";
        try {
            Statement st = con.createStatement();
            String sql = "select name from Categories where id=" + id;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }

    public ArrayList<Category> fillAllCategories() {
        ArrayList<Category> list = new ArrayList<Category>();
        try {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM Categories");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category pro = new Category();
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setNote(rs.getString("note"));
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public boolean insertPro(Product pro) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into PRODUCT VALUES(?,?,?,?,?)");
            ps.setString(1, pro.getName());
            ps.setInt(2, pro.getPrice());
            ps.setString(3, pro.getNote());
            ps.setString(4, pro.getImage());
            ps.setInt(5, pro.getCategory_id());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public boolean deletePro(int id) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUCT WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public Product findById(int id) {
        Product pro = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_pro = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                String note = rs.getString(4);
                String image = rs.getString(5);
                int Category_id = rs.getInt(6);
                pro = new Product(id_pro, name, price, note, image, Category_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;

    }

    public boolean updatePro(Product pro) {
        boolean result = false;
        try {
            String sql = "UPDATE PRODUCT SET name=?,price=?,note=?,image=?,category_id=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pro.getName());
            ps.setInt(2, pro.getPrice());
            ps.setString(3, pro.getNote());
            ps.setString(4, pro.getImage());
            ps.setInt(5, pro.getCategory_id());
             ps.setInt(6, pro.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("lỗi" + e.toString());
        }
        return result;

    }
}
