package cairh.community.api.game.kxian.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BigdataExcelExport {

	
	public static void createSheetTemplate(XSSFWorkbook wb,String fileName, String sheetName) {
		// 第一步.创建一个临时的 excel 文件，配置单元格属性，数值格式。
		FileOutputStream os = null;
		try {
			wb.createSheet(sheetName);
			os = new FileOutputStream(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				wb.write(os);
				if(os!=null){
					os.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//createStyles(wb);		
	}

	public static void createSheetTemplate(XSSFWorkbook wb,String fileName, String[] sheetNames) {
		// 第一步.创建一个临时的 excel 文件，配置单元格属性，数值格式。
		FileOutputStream os = null;
		try {
			for (int i = 0; i < sheetNames.length; i++) {
				wb.createSheet(sheetNames[i]);
			}
			os = new FileOutputStream(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				wb.write(os);
				if(os!=null){
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//createStyles(wb);
	}
		
	public static void generate(Writer out, List<Map<Integer,Object>> codeList,String[]  titleArr, int pageSize)throws Exception {
		
		SpreadsheetWriter sw = new SpreadsheetWriter(out);
		sw.beginSheet();
		// insert header row
		sw.insertRow(0);
		for(int j = 0; j< titleArr.length; j++){
			sw.createCell(j, titleArr[j]);
		}
		sw.endRow();
		
		Map<Integer,Object>  map=null;
		String x="";
		// write data rows
		for (int rownum = 0; rownum < codeList.size(); rownum++) {
			sw.insertRow(rownum+1);
			for(int k =0; k<titleArr.length;k++ ){
				
				map = codeList.get(rownum);
				
				x =  String.valueOf(map.get(k)) ;
				if("null".equalsIgnoreCase(x) || StringUtil.isEmpty(x))  x ="";
				sw.createCell(k,x);
			}
			sw.endRow();
		}
		sw.endSheet();
	}
	
	
   public static void generate(Writer out, List<String[]> codeList,String[]  titleArr)throws Exception {
		
		SpreadsheetWriter sw = new SpreadsheetWriter(out);
		sw.beginSheet();
		// insert header row
		sw.insertRow(0);
		for(int j = 0; j< titleArr.length; j++){
			sw.createCell(j, titleArr[j]);
		}
		sw.endRow();
		
		String[]  strArr;
		String x="";
		// write data rows
		for (int rownum = 0; rownum < codeList.size(); rownum++) {
			sw.insertRow(rownum+1);
			for(int k =0; k<titleArr.length;k++ ){
				
				strArr = codeList.get(rownum);
				
				x = strArr[k];
				if("null".equalsIgnoreCase(x) ||StringUtil.isEmpty(x))  x ="";
				sw.createCell(k,x);
			}
			sw.endRow();
		}
		sw.endSheet();
	}
   
   
	/**
	 * 创建样式表
	 */
	public static Map<String, XSSFCellStyle> createStyles(XSSFWorkbook wb) {
		Map<String, XSSFCellStyle> styles = new HashMap<String, XSSFCellStyle>();
		XSSFDataFormat fmt = wb.createDataFormat();

		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		style1.setDataFormat(fmt.getFormat("0.0%"));
		styles.put("percent", style1);

		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style2.setDataFormat(fmt.getFormat("0.0X"));
		styles.put("coeff", style2);

		XSSFCellStyle style3 = wb.createCellStyle();
		style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		style3.setDataFormat(fmt.getFormat("$#,##0.00"));
		styles.put("currency", style3);

		XSSFCellStyle style4 = wb.createCellStyle();
		style4.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		style4.setDataFormat(fmt.getFormat("mmm dd"));
		styles.put("date", style4);

		XSSFCellStyle style5 = wb.createCellStyle();
		XSSFFont headerFont = wb.createFont();
		headerFont.setBold(true);
		style5.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style5.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style5.setFont(headerFont);
		styles.put("header", style5);

		return styles;
	}

	//新增一个sheet
	public static void appendSheet(File tmpfile, String entry,
			ZipOutputStream zos) throws IOException {
		zos.putNextEntry(new ZipEntry(entry));
		InputStream is = null;
		try {
			is = new FileInputStream(tmpfile);
			copyStream(is, zos);
		} catch (Exception e) {
			
		} finally {
			if( is != null){
				is.close();
			}
		}

	}

	
	/**
	 * 
	 * @param zipfile
	 *            the template file
	 * @param tmpfile
	 *            the XML file with the sheet data
	 * @param entry
	 *            the name of the sheet entry to substitute, e.g.
	 *            xl/worksheets/sheet1.xml
	 * @param out
	 *            the stream to write the result to
	 */
	public static void substitute(File zipfile, ZipOutputStream zos)
			throws IOException {
		ZipFile zip = null;
		try {
			zip = new ZipFile(zipfile);
			Enumeration<ZipEntry> en = (Enumeration<ZipEntry>) zip.entries();
			while (en.hasMoreElements()) {
				ZipEntry ze = en.nextElement();
				
				if (ze.getName().indexOf("worksheets/sheet") >= 0)  continue;
				
				zos.putNextEntry(new ZipEntry(ze.getName()));
				InputStream is = zip.getInputStream(ze);
				copyStream(is, zos);
				is.close();
			}
		} finally {
			if(zip != null){
				zip.close();
			}
			if( zos != null){
				zos.close();
			}
		}
	}

	private static void copyStream(InputStream in, OutputStream out)
			throws IOException {
		byte[] chunk = new byte[1024];
		int count;
		while ((count = in.read(chunk)) >= 0) {
			out.write(chunk, 0, count);
		}
	}

	/**
	 * Writes spreadsheet data in a Writer. (YK: in future it may evolve in a
	 * full-featured API for streaming data in Excel)
	 */
	public static class SpreadsheetWriter {
		private final Writer _out;
		private int _rownum;

		public SpreadsheetWriter(Writer out) {
			_out = out;
		}

		public void beginSheet() throws IOException {
			_out.write("<?xml version=\"1.0\" encoding=\""
					+ "UTF-8"
					+ "\"?>"
					+ "<worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">");

			_out.write("<sheetData>\n");
		}

		public void endSheet() throws IOException {
			_out.write("</sheetData>");

			_out.write("</worksheet>");
			_out.flush();
		}

		/**
		 * Insert a new row
		 * 
		 * @param rownum
		 *            0-based row number
		 */
		public void insertRow(int rownum) throws IOException {
			_out.write("<row r=\"" + (rownum + 1) + "\">\n");
			this._rownum = rownum;
		}

		/**
		 * Insert row end marker
		 */
		public void endRow() throws IOException {
			_out.write("</row>\n");
		}

		public void createCell(int columnIndex, String value, int styleIndex)
				throws IOException {
			String ref = new CellReference(_rownum, columnIndex)
					.formatAsString();
			_out.write("<c r=\"" + ref + "\" t=\"inlineStr\"");
			if (styleIndex != -1)
				_out.write(" s=\"" + styleIndex + "\"");
			_out.write(">");
			_out.write("<is><t>" + value + "</t></is>");
			_out.write("</c>");
		}

		public void createCell(int columnIndex, String value)
				throws IOException {
			createCell(columnIndex, value, -1);
		}

		public void createCell(int columnIndex, double value, int styleIndex)
				throws IOException {
			String ref = new CellReference(_rownum, columnIndex)
					.formatAsString();
			_out.write("<c r=\"" + ref + "\" t=\"n\"");
			if (styleIndex != -1)
				_out.write(" s=\"" + styleIndex + "\"");
			_out.write(">");
			_out.write("<v>" + value + "</v>");
			_out.write("</c>");
		}

		public void createCell(int columnIndex, double value)
				throws IOException {
			createCell(columnIndex, value, -1);
		}

		public void createCell(int columnIndex, Calendar value, int styleIndex)
				throws IOException {
			createCell(columnIndex, DateUtil.getExcelDate(value, false),
					styleIndex);
		}
		
		
	}

	public static String[] getExcelSheet(int totalPage){
		//根据页数生成对应的sheet
		 String[] sheetNames =  new  String[totalPage];
		 for(int i= 0 ; i<sheetNames.length;i++){
			 sheetNames[i] = "sheet"+i;
		 }
		 return sheetNames;
	}
	
	
}
