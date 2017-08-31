package javase.javaCommon.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Test jExcel API
 * @author shiwx
 * @since 2011-12-17
 */
public class TestExcel {
	
	/**
	 * 读取Excel
	 */
	public static void readExcel(String file) throws Exception {
		Workbook workbook = Workbook.getWorkbook(new File(file));	
		//Sheet：
		Sheet sheet = workbook.getSheet(0);
		//Cell：单元格	
		/**		单元格坐标		
		 * 		00	10	20	30	40
		 * 		01	11	21	31	41	
		 * 		02	12	22	32	42
		 * 		03	13	23	33	43
		 * 		04	14	24	34	44
		 */
		Cell cell = sheet.getCell(1,22);
		System.out.println(cell.getContents());
	}
	
	
	/**
	 * 写入Excel
	 */
	public static void writeExcel(String file) throws Exception{
		//创建工作薄 
		WritableWorkbook book = Workbook.createWorkbook(new File(file));
		//创建工作表
		WritableSheet sheet = book.createSheet("TestSheet1", 0);
		//创建字体
		WritableFont normal = new WritableFont(WritableFont.ARIAL, 10);						//普通字体
		WritableFont bold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);	//粗体
		
		/***************设置字体**************/
		//字体用于标题
		WritableCellFormat wcf_title = new WritableCellFormat(bold);
		wcf_title.setBorder(Border.NONE, BorderLineStyle.THIN);		//线条
		wcf_title.setVerticalAlignment(VerticalAlignment.CENTRE);	//垂直对齐
		wcf_title.setAlignment(Alignment.CENTRE);					//水平对齐
		wcf_title.setWrap(true);									//是否换行
		
		//字体用于正文
		WritableCellFormat wcf_content = new WritableCellFormat(normal);
		wcf_content.setBorder(Border.NONE, BorderLineStyle.THIN);
		wcf_content.setVerticalAlignment(VerticalAlignment.CENTRE);
		wcf_content.setAlignment(Alignment.RIGHT);
		wcf_content.setWrap(false);
		
		/***********设置单元格***********/
		//设置行高
		sheet.setRowView(0, 600, false);
		//合并单元格	column1, row1, column2, row2
		sheet.mergeCells(0, 0, 5, 0);
		//添加内容	column, row
		sheet.addCell(new Label(0, 0, "这里是标题", wcf_title));
		sheet.addCell(new Label(0, 1, "标题1", wcf_title));	
		sheet.addCell(new Label(1, 1, "标题1", wcf_title));
		sheet.addCell(new Label(2, 1, "标题1", wcf_title));
		for(int i=1; i<10; i++){
			for(int j=0; j<3; j++){
				sheet.addCell(new Label(j, i, i + " - " + j, wcf_content));
			}
			
		}
		
		//将缓存内容写入文件
		book.write();
		//关闭文件
		book.close();
	}
	
	
	public static void main(String[] args) throws Exception {
//		readExcel("src/javaCommon/excel/test1.xls");
		writeExcel("src/javaCommon/excel/test2.xls");
	}
	
}
