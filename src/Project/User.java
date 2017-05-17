package Project;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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

import Server.User2;
import dao.userDao;
import model.userMessage;

public class User implements Runnable {

	private String ip = "";
	private int port = 0;
	private String flagString;
	private OutputStream os;
	private BufferedWriter bw;
	private InputStream input;
	private BufferedReader in;
	private InputStreamReader reader;
	private Socket socket = null;
	private Thread thread = null;
	private boolean sendOK = false;
	private boolean reconnect = false;
	private String username;
	private int localPort = 0;
	private boolean isadd = false;
	private boolean interruptWithServer = false;
	private userMessage userMessage = null;
	public User(userMessage userMessage) {
		ip = "localhost";
		port = 8888;
		this.userMessage = userMessage;
		username = this.userMessage.getName();
		localPort = this.userMessage.getAccnumber();
	}

	public void run() { // �ֶ���¼��������һ���������ӣ����ƣ�
		try {
			Thread.sleep(2000);

			InetAddress inetAddress = InetAddress.getByName(ip);
			socket = new Socket(inetAddress, port);
			CFrame.sendPoint = false; // ��������

			if (socket.isConnected() && !socket.isClosed()) {
				Thread.sleep(1000);
				flagString = "***********************�ɹ����ӷ�����***********************";
				CFrame.jTextArea2.append(flagString + "\r\n");
				CFrame.jTextArea2.selectAll();
				CFrame.isOnline = true; //������				
				userDao dao = new userDao();
				try {
					dao.updateOnlineflag(this.userMessage.getAccnumber());
				} catch (SQLException e) {
				}
				CFrame.UDPExit = false; //�ж�UDP�Ƿ����
				setInterruptWithServer(false); //�ж��Ƿ�������Ͽ�����
				os = socket.getOutputStream();
				bw = new BufferedWriter(new OutputStreamWriter(os));
				bw.write(username + "," + localPort + "\n");
				bw.flush(); // �����û��� �ͱ��ؼ����Ķ˿�

				input = socket.getInputStream();
				in = new BufferedReader(new InputStreamReader(input));
				// ���շ�������Ϣ���߳�
				Thread thread = new Thread(new Read(this));
				thread.start();
				Thread thread2 = new Thread(new ReadClient(localPort,this.userMessage));
				thread2.start();

			} else {
				flagString = "����ʧ��...";
			}
		} catch (UnknownHostException e) {
			flagString = "����ʧ��...";

		} catch (IOException e) {
			// flagString = "����ʧ��...";
			CFrame.sendPoint = false; // ��������
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			CFrame.jTextArea2.append("Error�����ӳ�ʱ......\r\n");
			CFrame.jTextArea2.selectAll();
			System.out.println("���ӳ�ʱ");
			CFrame.flag = true; // flag���������ܷ���¼��ť

		} catch (InterruptedException e) {

		}
	}

	public void write(String send) throws SQLException {
		try {
			if (socket.isConnected() && !socket.isClosed()) { // �ж��Ƿ����ӳɹ����Ƿ��ͳɹ�
				bw.write(send);
				bw.flush();
				setsendOK(true);
				System.out.println("���ͳɹ�");

			}
		} catch (IOException e) {
			System.out.println("����ʧ��");
			CFrame.jTextArea2.append("�Ѿ���ͻ��˶Ͽ����ӣ�����ʧ��...\r\n");
			CFrame.jTextArea2.selectAll();
		}
	}

	public void read() throws IOException, InterruptedException {
		try {

			for (String string = in.readLine(); string != null; string = in.readLine()) {
				if (string.equals("qwertyuiop[]")) {
					System.out.println("ˢ�º���");
					String ClientUsername = in.readLine();// ��ȡ���ߵĺ��ѵ�����
					if (!ClientUsername.equals(username)) {
						CFrame.jTextArea2.append("���ĺ��� " + ClientUsername + " �����ߣ�\r\n");
					}
					ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
					try {
						Object obj = oi.readObject();
						Vector<User2> vt = (Vector<User2>) obj;
						Object obj2 = oi.readObject();
						Vector vt1 = (Vector) obj2;
						int RepeatIndex = vt1.indexOf(username);
						vt.remove(RepeatIndex);
						vt1.remove(RepeatIndex);
						CFrame.vt = vt;
						CFrame.vt1 = vt1;
						setIsadd(true);

					} catch (ClassNotFoundException e) {
					}
				} else if (string.equals("qwertyuiop[]clientexit")) {
					System.out.println("ˢ�º���");
					String ClientUsername = in.readLine();
					if (!ClientUsername.equals(username)) {
						CFrame.jTextArea2.append("���ĺ��� " + ClientUsername + " �����ߣ�\r\n");
					} 
					
					ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
					try {
						Object obj = oi.readObject();
						Vector<User2> vt = (Vector<User2>) obj;
						Object obj2 = oi.readObject();
						Vector vt1 = (Vector) obj2;
						int RepeatIndex = vt1.indexOf(username);
						try {
							vt.remove(RepeatIndex);
							vt1.remove(RepeatIndex);
						} catch (Exception e) {
						}					
						CFrame.vt = vt;
						CFrame.vt1 = vt1;
						setIsadd(true);

					} catch (ClassNotFoundException e) {
					}
				} else {
					CFrame.jTextArea2.append(string + "\r\n"); // �յ���Ϣ
					CFrame.jTextArea2.selectAll();// ע�⣡
				}
			}
		} catch (IOException e) {
			if(!CFrame.ClientExit){
				CFrame.jTextArea2.append("��ʾ��1�������������жϡ�����Ӱ�������ͨ��\r\n"); 
				CFrame.jTextArea2.append("��ʾ��2�����������ʧȥ���ӣ�ʧȥ����������ʾ����\r\n"); 
				CFrame.jTextArea2.append("��ʾ��3�������µ�¼�������Ϸ���������ˢ�º����б�\r\n");
				CFrame.jTextArea2.selectAll();
				setInterruptWithServer(true);
				socket.close();
			}
		}		
	}

	
	public userMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(userMessage userMessage) {
		this.userMessage = userMessage;
	}

	public int getLocalPort() {
		return localPort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getflagString() {
		return flagString;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean getsendOK() {
		return sendOK;
	}

	public void setsendOK(boolean sendOK) {
		this.sendOK = sendOK;
	}

	public String getFlagString() {
		return flagString;
	}

	public void setFlagString(String flagString) {
		this.flagString = flagString;
	}

	public boolean getIsadd() {
		return isadd;
	}

	public void setIsadd(boolean isadd) {
		this.isadd = isadd;
	}

	public boolean isInterruptWithServer() {
		return interruptWithServer;
	}

	public void setInterruptWithServer(boolean interruptWithServer) {
		this.interruptWithServer = interruptWithServer;
	}
	

}

class Read implements Runnable {
	private User client;

	public Read(User client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			client.read();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����1");
		} catch (InterruptedException e) {
			System.out.println("����2");
		}
	}
}

class ReadClient implements Runnable {   //UDPͨ��

	public static DatagramSocket socket = null;
	private int localport = 0;
	private userMessage userMessage = null;
	public  ReadClient(int localport,userMessage userMessage) {
		this.localport = localport;
		this.userMessage = userMessage;
	}
	@Override
	public void run() {

		try {
			socket = new DatagramSocket(localport); // ��������˿�
		} catch (SocketException e1) {
			System.out.println("����11");
		}

		while (true) {
			if (!socket.isClosed()) {
				byte[] buf = new byte[2048];
				DatagramPacket packet = new DatagramPacket(buf, 0, buf.length);
				try {
					socket.receive(packet);
					String info = new String(buf, 0, packet.getLength());
					int temp = info.indexOf('��');
					String temp2 = info.substring(0, temp-1); //temp2���û���
					System.out.println(temp2);
					int temp3 = CFrame.vt1.indexOf(temp2);
					
					Thread notifyThread = new Thread(new notify(temp3));
					notifyThread.start();
					CFrame.jTextArea2.append("��ʾ�� "+ temp2 + "��������һ����Ϣ����\r\n");
					CFrame.vt.get(temp3).setstring(info + "\r\n");
					CFrame.jTextArea2.selectAll();
					userDao dao = new userDao();
					try {
						//�����¼
						dao.updateChatlog(this.userMessage, info + "\r\n");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {

				}
			}
			else {
				System.out.println("socket�ѹرգ����ҹر��˶˿�");
				break;
			}
		}
	}
}

class notify implements Runnable{
	private int index;

	public notify(int index){
		this.index = index;
	}
	@Override
	public void run() {
		CFrame.jList1.setSelectedIndex(index);
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.clearSelection();
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.setSelectedIndex(index);
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.clearSelection();
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}		
		CFrame.jList1.setSelectedIndex(index);
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.clearSelection();
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.setSelectedIndex(index);
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.clearSelection();
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.setSelectedIndex(index);
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		CFrame.jList1.clearSelection();
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
		}
		if(CFrame.index==0){
			CFrame.jList1.clearSelection();
		}
		else{
			CFrame.jList1.setSelectedIndex(CFrame.index);
		}
	}	
}