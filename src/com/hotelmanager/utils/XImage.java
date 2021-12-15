/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelmanager.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author longd
 */
public class XImage {
    public static Image getAppIcon(){
        URL url = XImage.class.getResource("/com/hotelmanager/icons/fpt.png");
        return new ImageIcon(url).getImage();
    }
    
    public static boolean save(File src){
        File dst = new File("src\\com\\hotelmanager\\icons\\logos", src.getName());
        if (!dst.getParentFile().exists()) { //nếu file không tồn tại
            dst.getParentFile().mkdirs();    //tạo file
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static ImageIcon read(String fileName){
        File path = new File("src\\com\\hotelmanager\\icons\\logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
