/**
 * 
 */
package com.zxl.exl导出;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author 胥方雁
 * @data 2018年4月24日 上午11:03:32
 */
public class ExportBeanExcel2<T> {
	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出<br/>
	 * 
	 * title 表格标题名 headersName 表格属性列名数组 headersId<br/>
	 * 表格属性列名对应的字段---你需要导出的字段名（为了更灵活控制你想要导出的字段） dtoList<br/>
	 * 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象 out<br/>
	 * 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中<br/>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HSSFWorkbook exportExcel(String title, List<String> headersName, List<String> headersId, List<T> dtoList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(title);
		// 判断是否有值
		if (null == headersName || headersName.size() == 0) {
			return wb;
		}
		// 计算该报表的列数
		int number = headersName.size() - 1;
		// 创建单元格样式
		HSSFCellStyle cellStyleTitle = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定当单元格内容显示不下时自动换行
		cellStyleTitle.setWrapText(true);
		// ------------------------------------------------------------------
		HSSFCellStyle cellStyle = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定当单元格内容显示不下时自动换行
		cellStyle.setWrapText(true);
		// ------------------------------------------------------------------
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 200);
		cellStyleTitle.setFont(font);
		// 定义第一行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell1 = null;
		// 新增 设置适应宽度 不设置自动列宽
		int[] width = new int[headersName.size()];
		//Arrays.fill(width, -1);
		for (int i = 0; i < headersName.size(); i++) {
			// 自动列宽
			// y=255.86x+184.27
			// sheet.autoSizeColumn(i,true); + 184
			width[i] = headersName.get(i).length();
			sheet.setColumnWidth(i, (256 * width[i]) * 2);
			cell1 = row.createCell(i);
			cell1.setCellStyle(cellStyleTitle);
			cell1.setCellValue(headersName.get(i));
		}

		for (int i = 0; i < dtoList.size(); i++) {
			row = sheet.createRow(i + 1);
			T l = (T) dtoList.get(i);
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = l.getClass().getDeclaredFields();// 获得JavaBean全部属性
			// 工具列名遍历
			for (int j = 0; j < headersId.size(); j++) {
				for (short k = 0; k < fields.length; k++) {// 遍历属性，比对
					Field field = fields[k];
					String fieldName = field.getName();// 属性名
					if (fieldName.equals(headersId.get(j))) {// 比对JavaBean的属性名，一致就写入，不一致就丢弃
						/*
						 * String getMethodName = null; if(fieldName.length() ==
						 * 1){ //当长度为1时,fieldName不进行截取 getMethodName = "get" +
						 * fieldName.toUpperCase(); }else { getMethodName =
						 * "get" + fieldName.substring(0, 1).toUpperCase() +
						 * fieldName.substring(1);// 拿到属性的get方法 }
						 */
						//Class tCls = l.getClass();// 拿到JavaBean对象
						try {
							// Method getMethod = tCls.getMethod(getMethodName,
							// new Class[] {});// 通过JavaBean对象拿到该属性的get方法，从而进行操控
							// Object val = getMethod.invoke(l, new Object[]
							// {});// 操控该对象属性的get方法，从而拿到属性值
							field.setAccessible(true);
							Object val = field.get(l);// 直接通过对象属性来拿到属性值
							String textVal = null;
							if (val != null) {
								if (field.getType() == Date.class) {
									textVal = sdf.format(val);
								} else {
									textVal = String.valueOf(val);// 转化成String
								}
								int maxlength = textVal.length();
								if (maxlength> width[j] && (256 * maxlength* 2)<25600) {
									width[j] = maxlength;
									sheet.setColumnWidth(j, 256 * maxlength * 2);
								}
							} else {
								textVal = null;
							}
							row.createCell(j).setCellValue(textVal);// 写进excel对象
							break;
						} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return wb;
	}
}
