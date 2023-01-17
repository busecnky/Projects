package com.busecnky.service;

import java.util.Locale;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.busecnky.entity.Contact;
import com.busecnky.repository.ContactsDao;

public class ContactsService {

private ContactsDao contactsDao;
	
	public ContactsService() {
		contactsDao = new ContactsDao();
	}
	
	public void save(Contact con) {
		contactsDao.save(con);
		
//		if(StringUtils.isNumeric(con.getPhone1())){
//			if(StringUtils.isNumeric(con.getPhone2()) || (con.getPhone2().isEmpty())) {
//				contactsDao.save(con);
//			}
//			
//		}else {
//			JOptionPane.showMessageDialog(null, "You should enter number for phone areas.");
//		}
		
		

		
	}

	public void delete(long id) {
		contactsDao.delete(id);
		
	}

	public Contact update(long id, String phone1, String phone2, String adres1, String adres2) {
		Contact contacts = contactsDao.findById(id);
		contacts.setPhone1(phone1);
		contacts.setPhone2(phone2);
		contacts.setAddress1(adres1);
		contacts.setAddress2(adres2);
		
		contactsDao.update(id, contacts);
		return contacts;
		
//		if(StringUtils.isNumeric(contacts.getPhone1())){
//			if(StringUtils.isNumeric(contacts.getPhone2()) || (contacts.getPhone2().isEmpty())) {
//				contactsDao.update(id, contacts);
//				return contacts;
//			}
//			
//		}else {
//			JOptionPane.showMessageDialog(null, "You should enter number for phone areas.");
//		}
//		
//		return null;
		
	

		
	}

}
