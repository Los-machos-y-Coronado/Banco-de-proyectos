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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;
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
        
        public AreasIniciativa() {
            serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
            try{
                areas =serviciosBanco.iniciativasPorArea();
                model = new PieChartModel();
                for(Area a: areas){
                    model.set(a.getNombre(), a.getIniciativas().size());
                }
                model.setTitle("Iniciativas por área");
                model.setLegendPosition("w");
            }catch(ExcepcionServiciosBanco ex){
                
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
    
 
    
}
