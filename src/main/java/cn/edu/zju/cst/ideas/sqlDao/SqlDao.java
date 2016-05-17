package cn.edu.zju.cst.ideas.sqlDao;

public class SqlDao {
	private void loadDriver(){
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		    	
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
	}
	
	
	
	
}
