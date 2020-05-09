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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.eci.cvds.samples.entities.Estado;
import edu.eci.cvds.samples.entities.Iniciativa;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Andres Gonzalez
 */

@ManagedBean (name = "EstadosBean")
@SessionScoped
public class EstadosBean {
    
        private ServiciosBanco serviciosBanco;
        private PieChartModel model;
        private StreamedContent excel;
        private StreamedContent pdf;
        private Estado[] estados;
        private List<List<Iniciativa>> iniEstados; 

        public EstadosBean() {
            serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
            try{
                iniEstados = new ArrayList<List<Iniciativa>>();
                estados = Estado.values();
                model = new PieChartModel();
                for(Estado e: estados){
                    List<Iniciativa> iniciativas = serviciosBanco.consultarIniciativasPorEstado(e.getName());
                    if (!iniciativas.isEmpty()){
                    iniEstados.add(iniciativas);
                    }
                    model.set(e.getName(), iniciativas.size());
                }
                model.setTitle("Iniciativas por Estado");
                model.setLegendPosition("w");
                
            }catch(ExcepcionServiciosBanco ex){
                
            }
            
        }

    public  void excel(){
        try{
            Workbook workbook = new HSSFWorkbook();


            for(int i=0;i<iniEstados.size();i++){
                Sheet sheet = workbook.createSheet(iniEstados.get(i).get(0).getEstado());
                List<Iniciativa> iniciativas = iniEstados.get(i);
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
            FileOutputStream fos = new FileOutputStream("estados.xls");
            workbook.write(fos);
            fos.close();
            File fil = new File("estados.xls");
            excel = new DefaultStreamedContent(new FileInputStream(fil), new MimetypesFileTypeMap().getContentType(fil), "estados.xls");

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void pdf(){
        try{
            FileOutputStream fos = new FileOutputStream("estados.pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, fos);
            doc.open();
            doc.add(new Paragraph("Iniciativas por Estado"));
            for(List<Iniciativa> l: iniEstados){
                doc.add(new Paragraph("Estado: "+l.get(0).getEstado()));
                
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
                
                for(Iniciativa i: l){

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
            File fil = new File("estados.pdf");
            pdf = new DefaultStreamedContent(new FileInputStream(fil), new MimetypesFileTypeMap().getContentType(fil), "estados.pdf");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public PieChartModel getModel() {
        return model;
    }

    public List<List<Iniciativa>> getIniEstados() {
        return iniEstados;
    }

    public void setIniEstados(List<List<Iniciativa>> iniEstados) {
        this.iniEstados = iniEstados;
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
