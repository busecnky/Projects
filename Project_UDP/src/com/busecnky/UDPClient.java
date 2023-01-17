package com.busecnky;
import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.BorderFactory;

public class UDPClient implements Runnable {
	
	public final static int SERVERPORT = 5000; 
	static DatagramSocket udpClientSocket = null;  
	static InetAddress serverIPAddress;   
    String name;  
    String nme;
    
    
    public void setName(String nm) {  
	    this.name = nm;
	} 
	
    public String getName() { 
	    return name;	
	} 
    
    static {
    try {       
        serverIPAddress = InetAddress.getByName("localhost");
            }catch (IOException er) {
   					System.out.println(er);
   		              }   
    }
    
    static {
    try {
        udpClientSocket = new DatagramSocket();
    }catch (IOException er) {
				System.out.println(er);
	             } 
    }
    
    
    String text = "Welcome.... \nPlease choose Log On from the file menu above and enter \n your username for chat.\n";
    JFrame frame = new JFrame("              Chat");
    JPanel panel1 = new JPanel(new BorderLayout()); 
    JPanel panel2 = new JPanel();  
    JMenuBar menuBar = new JMenuBar();
    JTextField msgField = new JTextField(30); 
    JTextArea messageArea = new JTextArea(text,20,25);
    JLabel lblNewLabel = new JLabel("");
  
    public JMenu createFileMenu() {  
		JMenu menu = new JMenu("File");
		menu.add(createLogOnItem()); 
		menu.add(createFileExitItem()); 
		return menu;
		} 
	
	public JMenuItem createLogOnItem() {
		JMenuItem item = new JMenuItem("Log On");
		class MenuItemListener implements ActionListener {
			public void actionPerformed (ActionEvent event) {
	
			    nme = JOptionPane.showInputDialog(null,"Please enter your name:","Log On",JOptionPane.INFORMATION_MESSAGE);
				setName(nme);
				lblNewLabel.setText(nme);
    
      byte[] sendData = new byte[1024]; 

      String clientRequest = "START"+name;
      
      sendData = clientRequest.getBytes();
      
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, SERVERPORT);
      
      try {
		
              udpClientSocket.send(sendPacket);
           } catch (IOException er) {
					System.out.println(er);
		              } 
			}
		} 
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener); 
		return item;
	}
	
	public JMenuItem createFileExitItem() {    
	    JMenuItem item = new JMenuItem("Exit");
	    class MenuItemListener implements ActionListener {
			public void actionPerformed (ActionEvent event) {
			    System.exit(0);    
			} 
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
	    return item;
	}	
  
	UDPClient() {
      
		frame.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
      
		msgField.setEditable(true);
		messageArea.setEditable(false);
		frame.setSize(500,700);
        panel1.setBounds(0, 21, 500, 573);
        
        panel1.add(messageArea);
        panel1.add(new JScrollPane(messageArea),"Center");
        panel2.setBounds(0, 594, 500, 56);
        panel2.add(new JLabel("Message:"));
        panel2.add(msgField);   
      
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 15));
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));  
		frame.getContentPane().setLayout(null);
        
		frame.getContentPane().add(panel1);
		frame.getContentPane().add(panel2);
		lblNewLabel.setBounds(210, 6, 61, 16);
		
		
		frame.getContentPane().add(lblNewLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		 msgField.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			byte[] data = new byte[1024];
			String info = time + "\n" + getName() + ": " + msgField.getText(); // specifies format to be sent
			messageArea.setText(messageArea.getText() + msgField.getText() + "\n");
			data = info.getBytes();
			DatagramPacket output = new DatagramPacket(data, data.length,serverIPAddress,SERVERPORT);
			try {
			udpClientSocket.send(output);
				} catch(IOException er) {
				 System.out.println(er);
			 } 
			data = new byte[1024]; 
		    msgField.setText(""); 
		}
	    });    
	
	} 
	
	public void run() {   
	
	    byte[] info = new byte[1024];
	    String s = "";
	    while(true)
	    {
			DatagramPacket dp = new DatagramPacket(info, info.length);
			try {
				 udpClientSocket.receive(dp);
		         s = new String (dp.getData());
			     messageArea.append(s + "\n"); 
				} catch(IOException er) {
				 System.out.println(er);
			 } 	 
		}
	}
     
    
	
	public static void main(String [] args) {	
	

        Thread t = new Thread(new UDPClient());
		t.start(); 

    }
	
} 
