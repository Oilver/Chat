package Project;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import dao.userDao;
import model.userMessage;

public class Manager extends javax.swing.JFrame {
  
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	public static javax.swing.JTable jTable1;

    public Manager() throws SQLException {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 255, 255));

        jLabel1.setFont(new java.awt.Font("����", 0, 24)); // NOI18N
        jLabel1.setText("   ����Ա");

        jTable1.setFont(new java.awt.Font("����", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "��  ��", "��  ��", "��  ��", "��  ��", "��  ��", "��  ��", "��  ַ", "email", "����״̬"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(244, 255, 255));
        jButton1.setText("�����ѯ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("����", 0, 24)); // NOI18N
        jLabel1.setText("����Ա");

        jButton2.setBackground(new java.awt.Color(244, 255, 255));
        jButton2.setText("�鿴�����б�");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton2ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jButton3.setBackground(new java.awt.Color(244, 255, 255));
        jButton3.setText("ɾ���û�");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton3ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jButton4.setBackground(new java.awt.Color(244, 255, 255));
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
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(17, 17, 17))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //��ʾ����
        userDao dao = new userDao();
        List<userMessage> userList = dao.query();
        TableModel model = jTable1.getModel();
        for(int i = 0;i<userList.size();i++)
        {
        	model.setValueAt(userList.get(i).getAccnumber(), i, 0);  
        	model.setValueAt(userList.get(i).getPassword(), i, 1);
        	model.setValueAt(userList.get(i).getName(), i, 2);
        	if(userList.get(i).getSex()==1) model.setValueAt("��", i, 3);
        	else model.setValueAt("Ů", i, 3);
        	model.setValueAt(userList.get(i).getAge()+"", i, 4);
        	model.setValueAt(userList.get(i).getBiraddress(), i, 5);
        	model.setValueAt(userList.get(i).getAddress(), i, 6);
        	model.setValueAt(userList.get(i).getEmail(), i, 7);
        	model.setValueAt(userList.get(i).getOnlineflag(), i, 8);
        }
        this.setTitle("����Ա");
        this.setLocation(200, 70);
        this.setVisible(true);  
        this.setResizable(false);
        pack();
       Thread thread = new Thread(new updateView());
       thread.start();
    }                        
    //ɾ���û�
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {      
    	if(jTable1.getValueAt(jTable1.getSelectedRow(), 0)==null)
    	{
    		JOptionPane.showMessageDialog(null, "Error����ѡ����Ҫɾ�����û���", "WARNING", JOptionPane.WARNING_MESSAGE);       	      	
        	return;
    	}
        int accnumber = (int) (jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        userDao dao = new userDao();
        int result = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���û�  "+ dao.getDeleteName(accnumber)+ " ?", "ȷ��ɾ��", 0);
        //ɾ��
        if(result==0){
        	dao.deleteUser(accnumber);
        	JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "WARNING", JOptionPane.WARNING_MESSAGE);       	      	
        	return;
        }
        return;
    }                                        
    //�鿴�����¼
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                         
    	if(jTable1.getValueAt(jTable1.getSelectedRow(), 0)==null)
    	{
    		JOptionPane.showMessageDialog(null, "Error��δѡ���û���", "WARNING", JOptionPane.WARNING_MESSAGE);       	      	
        	return;
    	}
    	//�鿴�����¼
    	int accnumber = (int) (jTable1.getValueAt(jTable1.getSelectedRow(), 0));
    	userDao dao = new userDao();
    	List<userMessage> userList = dao.query();
    	userMessage user = null;
    	for(int i = 0;i<userList.size();i++)
    	{
    		if(accnumber==userList.get(i).getAccnumber())
    		{
    			user = userList.get(i);
    			break;
    		}
    	}
    	new Chatlog(user);
    }                                        
    //�����ѯ
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new CheckByManager();
    }  
    //�鿴�����б�
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                         
        new PassIndex();
    }
}
	class updateView implements Runnable{

		private int flagnumber = 0;
		public void run() {
			while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			//���϶�̬����
			userDao dao = new userDao();
	        List<userMessage> userList;
			try {
				userList = dao.query();
		        TableModel model = Manager.jTable1.getModel();
		        for(int i = 0;i<flagnumber;i++)
		        {
		        	model.setValueAt("", i, 0);model.setValueAt("", i, 1);model.setValueAt("", i, 2);
		        	model.setValueAt("", i, 3);model.setValueAt("", i, 4);model.setValueAt("", i, 5);
		        	model.setValueAt("", i, 6);model.setValueAt("", i, 7);model.setValueAt("", i, 8);
		        }
		        for(int i = 0;i<userList.size();i++)
		        {
		        	model.setValueAt(userList.get(i).getAccnumber(), i, 0);  
		        	model.setValueAt(userList.get(i).getPassword(), i, 1);
		        	model.setValueAt(userList.get(i).getName(), i, 2);
		        	if(userList.get(i).getSex()==1) model.setValueAt("��", i, 3);
		        	else model.setValueAt("Ů", i, 3);
		        	model.setValueAt(userList.get(i).getAge()+"", i, 4);
		        	model.setValueAt(userList.get(i).getBiraddress(), i, 5);
		        	model.setValueAt(userList.get(i).getAddress(), i, 6);
		        	model.setValueAt(userList.get(i).getEmail(), i, 7);
		        	model.setValueAt(userList.get(i).getOnlineflag(), i, 8);
		        }
		        flagnumber = userList.size();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}		
	}
