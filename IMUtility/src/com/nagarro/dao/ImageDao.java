package com.nagarro.dao;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;

import com.nagarro.model.Image;
import com.nagarro.model.User;

public class ImageDao {
	public static void setCredintials(File file , String uname) {
		String name = file.getName();
		String fileUrl = "upload\\" + name;
        long size = file.length() / ( 1024 );
        String type = FilenameUtils.getExtension(fileUrl);
        Image image = new Image();
        image.setFileName(name);
        image.setFileUrl(fileUrl);
        image.setSize(size);
        image.setFileType(type);
        Session se = HibernateUtil.getSession();
        se.beginTransaction();
        User login = se.get(User.class, uname);
        image.setLogin(login);
        login.getImage().add(image);
        se.save(image);
        se.save(login);
        se.getTransaction().commit();
        
	}

}
