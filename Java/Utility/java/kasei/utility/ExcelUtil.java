package kasei.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelUtil {

    // 新建一个 excel 文件并横向填充数据
    public static Workbook fillDataHorizontal(List<List<String>> lists){
        Workbook workbook = new XSSFWorkbook(); // 在内存中创建一个工作簿
        Sheet sheet = workbook.createSheet("temporary");// 创建一张表
        for (Integer i=0; i<lists.size(); i++) {
            Row row = sheet.createRow(i);// 创建一行，行号从0开始
            for (Integer j=0; j<lists.get(i).size(); j++) {
                row.createCell(j).setCellValue(lists.get(i).get(j));
            }
        }
        return workbook;
    }

    // 新建一个 excel 文件并纵向填充数据
    public static Workbook fillDataVertical(List<List<String>> lists){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("temporary");

        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {

                Row row = sheet.getRow(j);
                if(row==null){ // 如果第一行不存在
                    row = sheet.createRow(j);
                }
                Cell cell = row.getCell(i);
                if(cell == null){ // 如果第一行第一个单元格不存在
                    cell = row.createCell(i);
                }
                cell.setCellValue(lists.get(i).get(j));
            }
        }
        return workbook;
    }
    
    
     /**
     * 创建excel文档，
     * [@param](http://my.oschina.net/u/2303379) list 数据
     * @param keys list中map的key数组集合
     * @param columnNames excel的列名
     * */
	@SuppressWarnings("deprecation")
    public static Workbook createWorkBook(List<Map<String, Object>> list, String []keys, String columnNames[], String sheetName) {
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(sheetName);
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth(i,(35 * 150));
        }

       int rowIndex=0;

        // 创建第一行
        Row row = sheet.createRow(rowIndex);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

//        Font f3=wb.createFont();
//        f3.setFontHeightInPoints((short) 10);
//        f3.setColor(IndexedColors.RED.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (int i = 1; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow(i+rowIndex+1);
            // 在row行上创建一个方格
            for(int j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }


    @SuppressWarnings("deprecation")
	public static Workbook createWorkBook(ExportBean exportBean) {
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(exportBean.getSheetName());
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<exportBean.getThNames().size();i++){
            sheet.setColumnWidth(i,(35 * 150));
        }
        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

//        Font f3=wb.createFont();
//        f3.setFontHeightInPoints((short) 10);
//        f3.setColor(IndexedColors.RED.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        int rowIndex=0;
/*
        if(exportBean.getContainHeadTdColspan()!=null){
            Row head = sheet.createRow(rowIndex);
            Integer headColspan=exportBean.getContainHeadTdColspan();
            if(headColspan!=null&&headColspan>0){
                Cell cell;
                for(int index=0;index<headColspan;index++){
                    cell = head.createCell(index);

                    if(index==0){
                        cell.setCellValue(exportBean.getContainHeadTdHtml());
                    }

                }
                sheet.addMergedRegion(new CellRangeAddress(0,0,0,headColspan-1));
            }
            rowIndex=rowIndex+1;
        }
        */
        // 创建第一行
        Row row = sheet.createRow(rowIndex);


        for(int i=0;i<exportBean.getThNames().size();i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(exportBean.getThNames().get(i));
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        if(exportBean.getDataLIst()!=null){
            List<String> trData;
            for (int i = 0; i < exportBean.getDataLIst().size(); i++) {
                // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
                // 创建一行，在页sheet上
                Row row1 = sheet.createRow(i+rowIndex+1);
                // 在row行上创建一个方格
                trData=exportBean.getDataLIst().get(i);
                for(int j=0;j<trData.size();j++){
                    Cell cell = row1.createCell(j);
                    cell.setCellValue(trData.get(j));
                    cell.setCellStyle(cs2);
                }
            }
        }

        return wb;
    }
}
