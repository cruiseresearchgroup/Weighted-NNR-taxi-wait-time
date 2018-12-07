import java.sql.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class KnnQuery{
	
		static StringBuilder sb;
		static PrintWriter pw;
	
	
	

	public static void query(int k) throws FileNotFoundException{
		
		
		Connection conn = null;
		Statement stm = null;
		Statement stm1 = null;
		Statement stm2 = null;
		ResultSet res = null;
		
		int testRowId = 0;
		int trainRowId = 0;
		double testClass = 0;
		double trainClass = 0;
		double trainRowDistance = 0;
		
		
		sb = new StringBuilder();
		pw = new PrintWriter(new File("predictedTestClass.csv"));
		
		try {
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/knndb", "root", "");
		   stm = conn.createStatement();
		   stm1 = conn.createStatement();
		   stm2 = conn.createStatement();
		   String query = "select DISTINCT testRowId from distance";
		   res = stm.executeQuery(query);
			
		 
			
			while(res.next()){
				
				int kk=k;
			
				testRowId = res.getInt("testRowId");
				sb.append(testRowId);
				sb.append(",");
				String query2 = "select DISTINCT testClass from distance where testRowId="+testRowId;  
				ResultSet res2 = stm2.executeQuery(query2);   
				
				double testClass2= 0.0;
				while(res2.next()){  
					testClass2=res2.getDouble("testClass");  
					sb.append(testClass2);
					
				}
				
				for(int x=1; x<=kk;x++){
					
				
				
				String query1="select testRowId, testClass, sum(trainClass)/"+x+" as predictedClass from (select * from distance where testRowId="+testRowId+" order by trainRowDistance asc limit "+x+") as tab";
					
				ResultSet res1 = stm1.executeQuery(query1);
				
				
					
			
					while(res1.next()){
						sb.append(",");		
					
					int testRowId1 = res1.getInt("testRowId");
					double testClass1 = res1.getDouble("testClass");
					double predictedClass = res1.getDouble("predictedClass");
					
							sb.append(predictedClass);
						
							double subtraction = Math.abs(testClass2-predictedClass);
							sb.append(",");
							sb.append(subtraction);
						
					}
				
					
					
				
				
				}
				
				sb.append("\n");	
			}
			
			// Write to a CSV file
			pw.write(sb.toString());
			pw.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		
		System.out.println("Done !!! See the file \" predictedTestClass.csv \" as output.");
		
		
		
	}
	
}