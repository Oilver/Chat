package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import DBU.DBUtil;
import model.userMessage;
import model.userMessage;
import model.userMessage;

public class userDao {

	//Ա��ע��(��û��ͨ�����)
	public void addUser(userMessage user){
		Connection conn = DBUtil.getConnection();
		String sql = "" + 
					 "insert into userMessage (accnumber,password,name,biraddress,address,email,sex,age,sign,onlineflag,chatlog,ispass) values (" + 
					 "?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = (PreparedStatement)conn.prepareStatement(sql);
			ptmt.setInt(1, user.getAccnumber());
			ptmt.setString(2, user.getPassword());
			ptmt.setString(3, user.getName());
			ptmt.setString(4, user.getBiraddress());
			ptmt.setString(5, user.getAddress());
			ptmt.setString(6, user.getEmail());
			ptmt.setInt(7, user.getSex());
			ptmt.setInt(8, user.getAge());
			ptmt.setString(9, user.getSign());
			ptmt.setString(10, user.getOnlineflag());
			ptmt.setString(11, user.getChatlog());
			ptmt.setString(12, user.getIsPass());
			ptmt.execute();

		} catch (SQLException e) {
			System.out.println("���ʧ�ܣ�");
			e.printStackTrace();
		}		
	}
	//ͨ�����
	public void userPass(int accnumber) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					 " update userMessage "+
					 " set ispass = ? where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, "Yes");
		ptmt.setInt(2, accnumber);
		ptmt.execute();
	}
	//����Աɾ���û������ڣ�
	public void deleteUser(int accnumber) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "delete from userMessage where accnumber = ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, accnumber);
		ptmt.execute();
	}
	//Ա���޸�
	public void updateUser(userMessage user) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					 " update userMessage "+
					 " set name = ?,biraddress = ?,address = ?,email = ?,sex = ?,age = ?,sign = ? where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, user.getName());
		ptmt.setString(2, user.getBiraddress());
		ptmt.setString(3, user.getAddress());
		ptmt.setString(4, user.getEmail());
		ptmt.setInt(5, user.getSex());
		ptmt.setInt(6, user.getAge());
		ptmt.setString(7, user.getSign());
		ptmt.setInt(8, user.getAccnumber());
		ptmt.execute();
	}
	
	//�޸�����
	public void updatePassword(userMessage user) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					 " update userMessage "+
					 " set password = ? where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, user.getPassword());
		ptmt.setInt(2,user.getAccnumber());
		ptmt.execute();
	}
	//�޸�����״̬
	public void updateOnlineflag(Integer accnumber) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					 " update userMessage "+
					 " set onlineflag = ? where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, "��");
		ptmt.setInt(2,accnumber);
		ptmt.execute();
	}
	//�޸�����״̬
	public void updateNotOnlineflag(Integer accnumber) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					 " update userMessage "+
					 " set onlineflag = ? where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, "��");
		ptmt.setInt(2,accnumber);
		ptmt.execute();
	}
	//�޸������¼
	public void updateChatlog(userMessage user,String newChatlog) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					 " update userMessage "+
					 " set Chatlog = ? where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		//�ȷ��������¼׷�Ӻ����޸�
		String oldChatlog = getChatlog(user);
		newChatlog = oldChatlog + newChatlog;
		ptmt.setString(1, newChatlog);
		ptmt.setInt(2,user.getAccnumber());
		ptmt.execute();
	}
	//���������¼
	public String getChatlog(userMessage user) throws SQLException{
		
		Connection conn = DBUtil.getConnection();
		String sql = "select chatlog from userMessage where accnumber = ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1,user.getAccnumber());
		ResultSet rs = ptmt.executeQuery();
		String chatlog = "";
		while(rs.next()){
			chatlog = rs.getString("chatlog");
		}
		return chatlog;
	}
	
	//���ظ�����Ϣ
	public userMessage getUser(Integer accnumebr) throws SQLException{
		userMessage user = null; 
		Connection conn = DBUtil.getConnection();
		String sql =  " select * from userMessage where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, accnumebr);

		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			user = new userMessage();
			user.setAccnumber(rs.getInt("accnumber"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setBiraddress(rs.getString("biraddress"));
			user.setAddress(rs.getString("address"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getInt("sex"));
			user.setAge(rs.getInt("age"));
			user.setSign(rs.getString("sign"));
			user.setChatlog(rs.getString("chatlog"));
		}
		return user;
	}
	//����Ҫɾ���û�������
	public String getDeleteName(Integer accnumebr) throws SQLException{
		userMessage user = null; 
		Connection conn = DBUtil.getConnection();
		String sql =  " select name from userMessage where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, accnumebr);

		ResultSet rs = ptmt.executeQuery();
		String name = "";
		while(rs.next()){
		name = rs.getString("name");
		}
		return name;
	}
	//�鿴�Լ�������
	public userMessage getGerenMessage(Integer accnumebr) throws SQLException{
		userMessage user = null; 
		Connection conn = DBUtil.getConnection();
		String sql =  " select * from userMessage where accnumber = ? ";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, accnumebr);

		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			user = new userMessage();
			user.setAccnumber(rs.getInt("accnumber"));
			user.setName(rs.getString("name"));
			user.setBiraddress(rs.getString("biraddress"));
			user.setAddress(rs.getString("address"));
			user.setEmail(rs.getString("email"));
			user.setSex(rs.getInt("sex"));
			user.setAge(rs.getInt("age"));
			user.setSign(rs.getString("sign"));
			user.setPassword(rs.getString("password"));
			
		}
		return user;
	}
	//����ͨ����˵������û�������
	public List<userMessage> query() throws SQLException{
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userMessage ");
		
		List<userMessage> userList = new ArrayList<>();
		userMessage s = null;
		while(rs.next()){
			if(rs.getString("ispass").equals("No"))
				continue;
			s = new userMessage();
			s.setAccnumber(rs.getInt("accnumber"));	
			s.setAddress(rs.getString("address"));
			s.setAge(rs.getInt("age"));
			s.setBiraddress(rs.getString("biraddress"));
			s.setChatlog(rs.getString("chatlog"));
			s.setEmail(rs.getString("email"));
			s.setName(rs.getString("name"));
			s.setPassword(rs.getString("password"));
			s.setSex(rs.getInt("sex"));
			s.setSign(rs.getString("sign"));
			s.setOnlineflag(rs.getString("onlineflag"));
			s.setIsPass(rs.getString("ispass"));
			userList.add(s);
		}
		return userList;
	}
	
	//����Ա�������ѯ
	public List<userMessage> query(List<Map<String, Object>> params) throws SQLException{
		List<userMessage> Users = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from userMessage where 1=1");	//С����
		
		//����
		if(params.size()>0 && !params.isEmpty()){
			for(int i = 0;i<params.size();i++){
				Map<String, Object> map = params.get(i);
				sb.append(" and " + map.get("name") +" "+ map.get("rela")+" "+ map.get("value"));
				}
		}	
		else return null;
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sb.toString());	
		ResultSet rs = ptmt.executeQuery();		
		userMessage s = null;
		while(rs.next()){
			if(rs.getString("ispass").equals("No"))
				continue;
			s = new userMessage();
			s.setAccnumber(rs.getInt("accnumber"));	
			s.setAddress(rs.getString("address"));
			s.setAge(rs.getInt("age"));
			s.setBiraddress("biraddress");
			s.setChatlog(rs.getString("chatlog"));
			s.setEmail(rs.getString("email"));
			s.setName(rs.getString("name"));
			s.setPassword(rs.getString("password"));
			s.setSex(rs.getInt("sex"));
			s.setOnlineflag(rs.getString("onlineflag"));
			s.setIsPass(rs.getString("ispass"));
			Users.add(s);
		}
		return Users;
	}
	//���ز�ͨ��������
	public List<userMessage> getNotPass() throws SQLException{
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userMessage where ispass = 'No'");
		
		List<userMessage> userList = new ArrayList<>();
		userMessage s = null;
		while(rs.next()){
			s = new userMessage();
			s.setAccnumber(rs.getInt("accnumber"));	
			s.setAddress(rs.getString("address"));
			s.setAge(rs.getInt("age"));
			s.setBiraddress("biraddress");
			s.setEmail(rs.getString("email"));
			s.setName(rs.getString("name"));
			s.setSex(rs.getInt("sex"));
			userList.add(s);
		}
		return userList;
	}
}
