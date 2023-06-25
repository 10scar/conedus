package com.conedus.backend.sede_funtions;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conedus.backend.estructuras.*;
import com.conedus.backend.models.Establecimiento;
import com.conedus.backend.models.Icfes;
import com.conedus.backend.models.Sede;

public class FiltradorTabla {

    //crea una tabla hash vacia por defecto al creaar el objeto filtro
    private HashTable<String,Sede> hash_colegios = new HashTable<>(); 
    @Autowired
     JdbcTemplate jdbcTemplate;

    public FiltradorTabla(){
        HashTable<String,Sede> hash_colegios = new HashTable<>();
    }

    public ArbolAVL<Sede> get_data() {
        String sql = "SELECT * FROM ouvxvkkq_conedus_pruebas.sedes limit 100";
        String valorColumna1 = null;

        Sede nueva_sede;
        
        String municipioID;
        String codigoDane;
        String nombre;
        String zona;
        String direccion;
        String telefono;
        String email;
        String sector;
        String estado;
        String[] niveles;
        String modelos;
        String[] grados;
        ArrayCircular<Double> coordenadas;
        float promedio_icfes=0;

        // Ejecutar la consulta
        Establecimiento default_establecimiento = new Establecimiento(valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, valorColumna1, null, 0, valorColumna1, null);
        List<Map<String, Object>> resultados = jdbcTemplate.queryForList(sql);

        //crear arbol avl con los resultados
        ArbolAVL<Sede> arbol_sedes = new ArbolAVL<>();
        int pro_count = 0;
        // Procesar los resultados
        for (Map<String, Object> fila : resultados) {
            pro_count++;
            //traer datos
            int sede_id = (Integer) fila.get("sede_id");
            ArrayCircular<Icfes> icfes = new ArrayCircular<>(2);
            get_icfes(icfes, sede_id);
        
            municipioID= Integer.toString((int) fila.get("municipio_id"));
            codigoDane= (String) fila.get("sede_dane");
            nombre= (String) fila.get("sede_nombre");
            zona= (String) fila.get("sede_zona");
            direccion= (String) fila.get("sede_direccion");
            telefono= (String) fila.get("sede_telefono");
            email= (String) fila.get("sede_email");
            sector= (String) fila.get("sede_sector");
            estado= (String) fila.get("sede_estado");
            niveles =new String[0];
            modelos= (String) fila.get("sede_modelos");;
            grados=new String[0];;
            coordenadas= new ArrayCircular<>(2);
    
            //String sql_pro = "SELECT sum(icfes_global)/count(*) as pro FROM ouvxvkkq_conedus_pruebas.icfes where sedes_id=1 group by sedes_id";
            //List<Map<String, Object>> resultados_pro = jdbcTemplate.queryForList(sql_pro);
            //promedio_icfes=  (float) BigDecimal(resultados_pro.get(0).get("pro"));
            nueva_sede = new Sede(default_establecimiento, municipioID, codigoDane, nombre, zona, direccion, telefono, email, sector, estado, niveles, modelos, grados, coordenadas);    
            nueva_sede.setIcfes(icfes);
            arbol_sedes.insertAVL(nueva_sede);
            // Hacer algo con los valores
        }
        return arbol_sedes;
    }


        public void get_icfes(ArrayCircular<Icfes> array,Integer sedes_id){
        String sql = "SELECT * FROM ouvxvkkq_conedus_pruebas.icfes where sedes_id ="+sedes_id;
        List<Map<String, Object>> resultados = jdbcTemplate.queryForList(sql);
        Icfes nuevo_icfes;
        int año;
        int global;
        int matematicas;
        int lectura;
        int sociales;
        int ciencias;
        int ingles;
     
        for (Map<String, Object> fila : resultados) {
            año = Integer.parseInt((String) fila.get("icfes_year"));
            global= (Integer) fila.get("icfes_global");
            matematicas= (Integer) fila.get("icfes_matematicas");
            lectura= (Integer) fila.get("icfes_lectura");
            sociales= (Integer) fila.get("icfes_sociales");
            ciencias= (Integer) fila.get("icfes_ciencias");
            ingles= (Integer) fila.get("icfes_ingles");
            nuevo_icfes = new Icfes(año, global, matematicas, lectura, sociales, ciencias, ingles);
            array.pushBack(nuevo_icfes);
        }
    }
    
}
