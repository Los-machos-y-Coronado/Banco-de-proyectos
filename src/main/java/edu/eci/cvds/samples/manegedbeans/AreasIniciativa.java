/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;

import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.List;
import javax.activation.MimetypesFileTypeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.eci.cvds.samples.entities.Iniciativa;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Andres Gonzalez
 */

@ManagedBean (name = "AreasBean")
@SessionScoped
public class AreasIniciativa {
    
        private ServiciosBanco serviciosBanco;
        private List<Area> areas;
        private PieChartModel model;
        private StreamedContent excel;
        private StreamedContent pdf;
        

        public AreasIniciativa() {
            serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
            try{
                actualizar();
                model = new PieChartModel();
                for(Area a: areas){
                    model.set(a.getNombre(), a.getIniciativas().size());
                }
                model.setTitle("Iniciativas por área");
                model.setLegendPosition("w");
            }catch(ExcepcionServiciosBanco ex){
                
            }
            
        }
    public void actualizar() throws ExcepcionServiciosBanco{
        areas =serviciosBanco.iniciativasPorArea();
           
    }
    public  void excel(){
        try{
            Workbook workbook = new HSSFWorkbook();


            for(int i=0;i<areas.size();i++){
                Sheet sheet = workbook.createSheet(areas.get(i).getNombre());
                List<Iniciativa> iniciativas = areas.get(i).getIniciativas();
                Row row0 = sheet.createRow(0);
                Cell cell0 = row0.createCell(0);
                cell0.setCellValue("Iniciativas");
                Row row1 = sheet.createRow(1);
                Cell c = row1.createCell(0);
                c.setCellValue("id");
                Cell c0 = row1.createCell(1);
                c0.setCellValue("Fecha");
                Cell c1 = row1.createCell(2);
                c1.setCellValue("Descripción");
                Cell c2 = row1.createCell(3);
                c2.setCellValue("Estado");
                Cell c3 = row1.createCell(4);
                c3.setCellValue("Proponente");
                for(int j=0;j<iniciativas.size();j++){
                    Iniciativa ini= iniciativas.get(j);
                    Row r = sheet.createRow(j+2);
                    Cell co = r.createCell(0);
                    co.setCellValue(ini.getId());
                    Cell co0 = r.createCell(1);
                    co0.setCellValue(ini.getFecha());
                    Cell co1 = r.createCell(2);
                    co1.setCellValue(ini.getDescripcion());
                    Cell co2 = r.createCell(3);
                    co2.setCellValue(ini.getEstado());
                    Cell co3 = r.createCell(4);
                    co3.setCellValue(ini.getProponente().getNombre());
                    
                    
                }
                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);
                sheet.autoSizeColumn(2);
                sheet.autoSizeColumn(3);
                sheet.autoSizeColumn(4);
                
            }

            //lets write the excel data to file now
            FileOutputStream fos = new FileOutputStream("areas.xls");
            workbook.write(fos);
            fos.close();
            File fil = new File("areas.xls");
            excel = new DefaultStreamedContent(new FileInputStream(fil), new MimetypesFileTypeMap().getContentType(fil), "areas.xls");

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void pdf(){
        try{
            FileOutputStream fos = new FileOutputStream("areas.pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, fos);
            doc.open();
            doc.add(new Paragraph("Iniciativas por área"));
            for(Area a: areas){
                doc.add(new Paragraph("Area: "+a.getNombre()));
                
                PdfPTable table = new PdfPTable(5);

                PdfPCell c1 = new PdfPCell(new Phrase("id"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Fecha"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Descripcion"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Estado"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                c1 = new PdfPCell(new Phrase("Proponente"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                table.setHeaderRows(1);
                
                for(Iniciativa i: a.getIniciativas()){

                    table.addCell(Integer.toString(i.getId()));
                    table.addCell(i.getFecha().toString());
                    table.addCell(i.getDescripcion());
                    table.addCell(i.getEstado());
                    table.addCell(i.getProponente().getCorreo());
                    
                    
                }
                doc.add(table);
            }
            
            doc.close();
            fos.close();
            File fil = new File("areas.pdf");
            pdf = new DefaultStreamedContent(new FileInputStream(fil), new MimetypesFileTypeMap().getContentType(fil), "areas.pdf");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public PieChartModel getModel() {
        return model;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public StreamedContent getExcel() {
        return excel;
    }

    public void setExcel(StreamedContent excel) {
        this.excel = excel;
    }

    public StreamedContent getPdf() {
        return pdf;
    }

    public void setPdf(StreamedContent pdf) {
        this.pdf = pdf;
    }




}
