package cairh.community.api.game.kxian.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {


	public static Connection getConnection() throws SQLException, ClassNotFoundException{

			Class.forName(ConfigProperties.get("jdbc.mysql.driver", "com.mysql.jdbc.Driver"));
			Connection conn = DriverManager.getConnection(
					ConfigProperties.get("jdbc.mysql.url"),
					ConfigProperties.get("jdbc.mysql.username"), ConfigProperties.get("jdbc.mysql.password"));

		return conn;
	}
       
	    /**
		 * 查大于指定id的研报
		 * @param reportId	
		 * @return
		 */
	/*
		public static List<StockReport> queryStockReport(long reportId)throws Exception {
			List<StockReport> stockReportList = new ArrayList<StockReport>();
			Connection connect = null;
			try {
				connect = getConnection();
			} catch (Exception e) {
				if(connect != null){
					try {
						connect.close();
					} catch (SQLException exc) {
						exc.printStackTrace();
					}
				}
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} 
			long beginTime = 0;
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			try {
				beginTime = sdf.parse("2011-01-01").getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = connect.createStatement();
				String sql = "SELECT * from cairh_stock_research_report_data " +
				" where  id > " + reportId + 
				" and publdate > " + beginTime +
				//					" and stock_code = '600571' " + 
				" order by id ";
				rs = stmt.executeQuery(sql);
				StockReport report = null; 
				while(rs.next()) {
					report = new StockReport();
					report.setId(rs.getLong("id"));
					report.setReportId(rs.getLong("report_id"));
					report.setStockCode(rs.getString("stock_code"));
					report.setTitle(rs.getString("title"));
					report.setOrgName(rs.getString("org_name"));
					report.setUrl(rs.getString("url"));
					report.setPubTime(rs.getLong("publdate"));

					stockReportList.add(report);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(stmt != null){
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(connect != null){
					try {
						connect.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("report size: " + stockReportList.size());
			return stockReportList;
		}
	*/

	}
