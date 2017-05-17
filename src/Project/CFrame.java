package Project;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

import Server.Server;
import Server.User2;
import dao.userDao;
import model.userMessage;

public class CFrame extends javax.swing.JFrame implements Runnable{

	public CFrame(User client) {
		this.client = client;
		
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jScrollPane3 = new javax.swing.JScrollPane();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jList1 = new javax.swing.JList<>();
		jList1.setFixedCellHeight(31);
	
		jRadioButton1 = new javax.swing.JRadioButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(2);
		jScrollPane1.setViewportView(jTextArea1);
		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jScrollPane2.setViewportView(jTextArea2);
		jTextArea2.setEditable(false);
		jTextArea1.setLineWrap(true);
		jTextArea1.setWrapStyleWord(true);
		jTextArea2.setLineWrap(true);
		jTextArea2.setWrapStyleWord(true);
	
		jButton2.setText("��������");
		
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton2ActionPerformed(evt);
				} catch (InterruptedException e) {

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jButton3.setText("����");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					try {
						jButton3ActionPerformed(evt);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});	
	
	    jRadioButton1.setText("Ⱥ��(t)");
	    jScrollPane3.setViewportView(jList1);
	    jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});
        jLabel1.setFont(new java.awt.Font("����", 0, 24)); // NOI18N
        jLabel1.setText(client.getUserMessage().getName());

        jButton4.setText("�鿴�����¼");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					jButton4ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
			MouseListener Danxuan = new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1) {
						if (!Morechooes) { // ����״̬
							jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							if (jList1.isSelectionEmpty()) {
								System.out.println("û�пͻ���");
								return;
							} else {
								index = jList1.locationToIndex(e.getPoint());
								jTextArea2.setText(vt.get(index).getstring());
								flag = true;
								System.out.println(vt.get(index).toString() + " ��ѡ��");
								// index��ѡ��Ŀͻ��ı�־
							}
						}
					}
				}
			};
			jList1.addMouseListener(Danxuan);
	        
			MouseListener Duoxuan = new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1) {
						if (Morechooes) { // Ⱥ��״̬
					
							jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
							if (jList1.isSelectionEmpty()) {
								jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
								System.out.println("û�пͻ���");
								return;
							}
							int index = jList1.locationToIndex(e.getPoint());
							jTextArea2.setText(vt.get(index).getstring());
						}
					}
				}
			};
			jList1.addMouseListener(Duoxuan);
			

			jButton1.setText("����");
			jButton1.addActionListener((new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					try {
						if(!isOnline){
							JOptionPane.showMessageDialog(null, "Error�����ȵ�¼", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
						else if (jList1.isSelectionEmpty()) {
							JOptionPane.showMessageDialog(null, "Error��û��ѡ��Ҫ���͵Ŀͻ�", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						} else if (!Morechooes)
							Danfa(index, jTextArea1.getText());
						else
							Qunfa();
					} catch (IOException e) {

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}));
			jButton1.setMnemonic(java.awt.event.KeyEvent.VK_ENTER);	
			this.setLocation(300, 100);
	        pack();
	}
	
	public void Qunfa() throws IOException, SQLException{
		String send = jTextArea1.getText();
		String sendbyMe = "\t\t  �ң� "+send+"\r\n";
		jTextArea2.append(sendbyMe);
		jTextArea2.selectAll();
		int[] indexs = jList1.getSelectedIndices();
		for(int i = 0;i<indexs.length;i++){
			vt.get(indexs[i]).setstring(sendbyMe);
			InetAddress address = InetAddress.getByName("localhost");
			int port = vt.get(indexs[i]).getUserport();
			String send2 = client.getUsername() + " �� " + send;
			byte[] bufsend = send2.getBytes();
			DatagramPacket packet = new DatagramPacket(bufsend, 0, bufsend.length,address,port);
			DatagramSocket socket = new DatagramSocket(); //��̬�˿ڽ�����Ϊ�˷����ݱ�
			socket.send(packet);
			socket.close();
			jTextArea1.setText("");
			String chatlog = "\t\t  "+client.getUsername()+"��"+vt.get(indexs[i]).toString()+"˵��" +send+"\r\n";
			userDao dao = new userDao();
			dao.updateChatlog(client.getUserMessage(), chatlog);
		}

	}
	
	public void Danfa(int i, String send) throws IOException, SQLException { //UDPͨ��
		String chatlog = "\t\t  "+client.getUsername()+"��"+vt.get(i).toString()+"˵��" +send+"\r\n";
		userDao dao = new userDao();
		dao.updateChatlog(client.getUserMessage(), chatlog);
		System.out.println(chatlog);
		String sendbyMe = "\t\t  �ң� "+send+"\r\n";
		vt.get(i).setstring(sendbyMe); 
		jTextArea2.append(sendbyMe);
		jTextArea2.selectAll();
		InetAddress address = InetAddress.getByName("localhost");
		int port = vt.get(i).getUserport(); // ѡ�е��û���Ӧsocket�������
		send = client.getUsername() + " ��" + send;
		byte[] bufsend = send.getBytes();
		DatagramPacket packet = new DatagramPacket(bufsend, 0, bufsend.length,address,port);
		DatagramSocket socket = new DatagramSocket(); //��̬�˿ڽ�����Ϊ�˷����ݱ�
		socket.send(packet);
		socket.close();
		jTextArea1.setText("");
	}
	
	//�������ϰ�ť
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, SQLException {
		if(!isOnline)
		{
			JOptionPane.showMessageDialog(null, "Error����δ��¼�ɹ���", "WARNING", JOptionPane.WARNING_MESSAGE);     	
        	return;
		}
		userDao dao = new userDao();		
		new CheckMyself(dao.getGerenMessage(client.getUserMessage().getAccnumber()));
	}
	
	//���Ұ�ť
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {		
		if(!isOnline)
		{
			JOptionPane.showMessageDialog(null, "Error����δ��¼�ɹ���", "WARNING", JOptionPane.WARNING_MESSAGE);     	
        	return;
		}
		new CheckOthers();
	}

	//�Ƿ�Ⱥ����ť
	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jRadioButton1.isSelected()) {
			Morechooes = true;
			jTextArea2.append("�����ҪȺ���Ŀͻ�ѡ��...\r\n");
		} else
			Morechooes = false;
	} 
	//�鿴�����¼
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException  {		
		if (jList1.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Error��û��ѡ��Ҫ�鿴���û�", "WARNING", JOptionPane.WARNING_MESSAGE);
			return;
		} 
		userDao dao = new userDao();
		userMessage user1 = dao.getUser(client.getUserMessage().getAccnumber());
		userMessage user2 = dao.getUser(vt.get(index).getUserport());
		new CheckChatlog(user1,user2);
	}
	public void run() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		CFrame clientFrame = new CFrame(client);
		clientFrame.setTitle("��ҵͨѶ���");
		clientFrame.setResizable(false);
		clientFrame.setVisible(true);
		login();//��¼
		
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // �����̵߳�˯�߼���cpu�ĸ������������������ʱ��cpuռ30%
			if (client.getIsadd()) {			
				jList1.setListData(vt1);
				client.setIsadd(false);
			}
		}
	}
	public void login(){
		jTextArea2.append("��������...���Ժ�...\r\n");
		flag = false;
		ClientExit = false;
		sendPoint = true;
		Thread connecting = new Thread(client);  //���ӵ��߳�
		connecting.start();
		Thread sendPoint = new SendPoint();		//�첽��ʾ*****���߳�
		sendPoint.start();
		
	}
	
	public static boolean UDPExit = false;
	public static boolean isOnline = false;
	public static boolean ClientExit = false;
	public static boolean flag = true;
	public static boolean sendPoint = true;
	private String flagString;
	private User client = null;
	public static Vector<User2> vt = new Vector<>();
	public static Vector vt1 = new Vector();
	// Variables declaration - do not modify
	public static javax.swing.JList<String> jList1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextArea jTextArea1;
	public static javax.swing.JTextArea jTextArea2;
	private javax.swing.JRadioButton jRadioButton1;
	private boolean Morechooes = false;
	public static int index = 0;
	public static boolean flag2 = false;   //
	public static int count = 0;

}

class SendPoint extends Thread{   //�첽_��¼��ʾ��
	public void run(){
		while(CFrame.sendPoint)//��������ɾ�ֹͣ���
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			CFrame.jTextArea2.append("��");
			CFrame.jTextArea2.selectAll();
		}	
		CFrame.jTextArea2.append("\r\n");
	}
}

