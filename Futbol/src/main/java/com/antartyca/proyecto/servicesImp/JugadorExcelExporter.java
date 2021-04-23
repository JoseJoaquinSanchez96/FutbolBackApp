package com.antartyca.proyecto.servicesImp;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.antartyca.proyecto.model.JugadorModel;

public class JugadorExcelExporter {

	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<JugadorModel> listaJugadores;
    
    
    public JugadorExcelExporter(List<JugadorModel> listaJugadores) {
        this.listaJugadores = listaJugadores;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Jugadores");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "cod_jugador", style);      
        createCell(row, 1, "nombre", style);       
        createCell(row, 2, "puesto", style);
        createCell(row, 3, "goles", style);
        createCell(row, 4, "altura", style);
        createCell(row, 5, "activo", style);
         
    }
    
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Date) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (JugadorModel j : listaJugadores) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, j.getCod_jugador() , style);
            createCell(row, columnCount++, j.getNombre(), style);
            createCell(row, columnCount++, j.getPuesto(), style);
            createCell(row, columnCount++, j.getGoles(), style);
            createCell(row, columnCount++, j.getAltura(), style);
            createCell(row, columnCount++, j.isActivo(), style);                 
          
        }
    }
    
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
