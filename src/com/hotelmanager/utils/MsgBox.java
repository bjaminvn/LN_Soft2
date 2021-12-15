/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author longd
 */
public class MsgBox {
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message
                ,"Hệ thống quản lí khách sạn",JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confilm(Component parent, String message){
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lí khách sạn", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    public static void prompt(Component parent, String message){
        JOptionPane.showInputDialog(parent, message,
                "Hệ thống quản lí khách sạn", JOptionPane.INFORMATION_MESSAGE);
    }
}
