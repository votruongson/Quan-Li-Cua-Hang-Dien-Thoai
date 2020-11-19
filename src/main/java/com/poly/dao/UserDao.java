/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thanh Hau
 */
public class UserDao extends ConnectDao {

    public UserDao() {
    }

    public User CheckLogin(String username, String password) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM USERNAME where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getInt("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<User> fillAll() {
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM USERNAME");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("Password"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getInt("role"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM USERNAME WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_user = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullname = rs.getString(4);
                String email = rs.getString(5);
                String phone = rs.getString(6);
                int role = rs.getInt(7);
                user = new User(id_user, username, password, fullname, email, phone, role);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }

    public boolean updateUser(User user) {
        boolean result = false;
        try {
            String sql="UPDATE USERNAME SET username=?,password=?,fullname=?,email=?,phone=?,role=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getRole());
            ps.setInt(7, user.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("lỗi..........."+e.toString());
        }
        return result;

    }

    public boolean deleteUser(int id) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM USERNAME WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public boolean insertUser(User user) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into USERNAME VALUES(?,?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getRole());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
