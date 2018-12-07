import java.sql.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Knn{
	static int k=1; 
	
	public static void main(String args[]) throws FileNotFoundException{
		
		
		
		//Get Test data
		
		double testRow[] = new double[16]; //  here 16 is used as an example which indicates the number of columns in the database 	
		// Read test.csv from mysql db
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		Statement stm1 = null;
		ResultSet res1 = null;
		Statement stm2 = null;
		ResultSet res2 = null;
		int numOfRow = 0;
		double train[][] = null;
		
		int testRowId = 0;
		int trainRowId = 0;
		
		
		
		
		
		double weight[] = {3.1,10.44,15.73,6.94,7.34,7.06,7.09,9.23,9.5,7.91,0,7.12,7.08,0.7,0.76};   // These weights are calculated by normalizing the conditional mutual information 
		
		
		
		try {
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/knndb", "root", "");
		   stm = conn.createStatement();
		   
			
			// Delete All rows from Table:distance---------------------
			String query4 = "delete from distance";
			stm = conn.createStatement();
			stm.executeUpdate(query4);
			//---------------------------------------------------------
			
			
			
			
			
			
			String query2 = "select count(*) as n from train";
			res2 = stm.executeQuery(query2);
			
			while(res2.next()){
				numOfRow = res2.getInt("n");
			}
			System.out.println("Number of Rows: "+numOfRow);
			System.out.println("-------------------------------------------");
			
			//Reading Train Data
			train = new double[numOfRow][16]; // Col Num = 6 (except Row ID) and Row Num = 8   ************************************************
			
			
			
			
		// Read test.csv from mysql db	
		String query = "Select rowid,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,class from test";
			res = stm.executeQuery(query);
			while(res.next()){
				testRowId = res.getInt("rowid");  
				testRow[0] = res.getDouble("a1");
				testRow[1] = res.getDouble("a2");
				testRow[2] = res.getDouble("a3");
				testRow[3] = res.getDouble("a4");
				testRow[4] = res.getDouble("a5");
				testRow[5] = res.getDouble("a6");
				testRow[6] = res.getDouble("a7");
				testRow[7] = res.getDouble("a8");
				testRow[8] = res.getDouble("a9");
				testRow[9] = res.getDouble("a10");
				testRow[10] = res.getDouble("a11");
				testRow[11] = res.getDouble("a12");
				testRow[12] = res.getDouble("a13");
				testRow[13] = res.getDouble("a14");
				testRow[14] = res.getDouble("a15");
				testRow[15] = res.getDouble("class");
				double testClass = testRow[15];  
				
				
				
			
			
			
			
			
			String query1 = "Select rowid,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,class from train";  //***********************
			stm1 = conn.createStatement();
			res1 = stm1.executeQuery(query1);
			int counter = 0;
			//System.out.println("Reading Train Data Row: ");
			while(res1.next()){
				train[counter][0] = res1.getDouble("a1");   //***********************
				train[counter][1] = res1.getDouble("a2");
				train[counter][2] = res1.getDouble("a3");
				train[counter][3] = res1.getDouble("a4");
				train[counter][4] = res1.getDouble("a5");
				train[counter][5] = res1.getDouble("a6");
				train[counter][6] = res1.getDouble("a7");
				train[counter][7] = res1.getDouble("a8");
				train[counter][8] = res1.getDouble("a9");
				train[counter][9] = res1.getDouble("a10");
				train[counter][10] = res1.getDouble("a11");
				train[counter][11] = res1.getDouble("a12");
				train[counter][12] = res1.getDouble("a13");
				train[counter][13] = res1.getDouble("a14");
				train[counter][14] = res1.getDouble("a15");
				train[counter][15] = res1.getDouble("class");  //***********************
				
				trainRowId = res1.getInt("rowid");
				
			
				
				
				//calculateDistance(numOfRow, testRow, train);
				double distRow =0.0;
				double distance=0.0;
				for(int j=0; j<15; j++){    //**************************************************************************************** 
					distRow += ((testRow[j]-train[counter][j])*(testRow[j]-train[counter][j]))*weight[j];
					
				}
				//System.out.println("Distance of "+i+"th row of Train data:"+ Math.sqrt(distRow));
				distance= Math.sqrt(distRow);
				
				String query3 = "Insert into distance (testRowId,testClass,trainRowId,trainClass,trainRowDistance) values ("+testRowId+","+testClass+","+trainRowId+","+train[counter][15]+","+distance+")";  //********************************
				//*****************************
				stm2 = conn.createStatement();
				stm2.executeUpdate(query3);
				
				counter++;
				//distRow =0;
				//distance =0;
			}
				
				
			
			
			
			
		}// Test Row While block
			
		}
		catch(Exception ex) {
		   	ex.printStackTrace();
		}
		
		
		// Execute Query with a k value.
		
		KnnQuery.query(50);  // As an example k=50
		
		
	}
	

	
	
	
	
}