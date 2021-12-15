/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.utils;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dthl2
 */
public class validator {
    public static void validateCheckEmpty(JTextField field,StringBuilder sb,String errorMessage){
        if (field.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            field.requestFocus();//trỏ chuột về ô bị lỗi
        }
    }
    //check Empty cho mật khẩu
    public static void validateCheckEmpty(JPasswordField field,StringBuilder sb2,String errorMessage){
        String password = new String(field.getPassword());
        if (password.equals("")) {
            sb2.append(errorMessage).append("\n");
            field.requestFocus();//trỏ chuột về ô bị lỗi
        }
    }    
}
