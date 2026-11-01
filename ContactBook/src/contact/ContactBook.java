package contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class ContactBook {

	ArrayList<Contact> contacts =new ArrayList<>();
	
	public void addContact(Contact contact) {
		contacts.add(contact);
		System.out.println("Your coontact Added Successfully!");
	}
	
	public void searchContact(int contactId) {

		for(Contact c : contacts) {
            if(contactId == c.getContactId()) {
            	System.out.println("Contact found");
            	System.out.println(c);
            }
		}
	}
		
	public void deleteContact(int contactId) {

	    Iterator<Contact> itr = contacts.iterator();

	    while(itr.hasNext()) {

	        Contact c = itr.next();

	        if(contactId == c.getContactId()) {

	            itr.remove();

	            System.out.println("Your contact removed!");

	            return;
	        }
	    }

	    System.out.println("Contact not found!");
	} 
	  public void displayAllContacts() {
		  
		  if(contacts.isEmpty()) {
			  System.out.println("No contacts Available!");
			  return;
		  }
		 
		 for(Contact c : contacts) {
			 System.out.println(c);
		 }
	  } 
		 public void saveContacts() {
			    try {
			        FileWriter fw = new FileWriter("contacts.txt");
			        BufferedWriter bw = new BufferedWriter(fw);


			        for(Contact c : contacts) {
			            bw.write(c.getContactId() + "," + c.getName() + "," 
			                    + c.getMobile() + "," + c.getEmail());
			            bw.newLine();
			        }

			        bw.close();
			        System.out.println("Contacts saved successfully!");

			    } catch(IOException e) {
			        System.out.println(e.getMessage());
			    }
			}
		 public void loadContacts() {

			    try {
			        BufferedReader br = new BufferedReader(
			            new FileReader("contacts.txt")
			        );

			        String line;

			        while((line = br.readLine()) != null) {

			            String[] data = line.split(",", -1);

			            if(data.length != 4) {
			                continue;
			            }

			            int id = Integer.parseInt(data[0]);
			            String name = data[1];
			            String mobile = data[2];
			            String email = data[3];

			            Contact c = new Contact(id, name, mobile, email);
			            contacts.add(c);
			        }

			        br.close();

			    } catch(IOException | NumberFormatException e) {
			        System.out.println("Error loading contacts: " + e.getMessage());
			    }
			}

	}
	  

