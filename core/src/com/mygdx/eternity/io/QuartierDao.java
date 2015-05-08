package com.mygdx.eternity.io;

import java.util.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;






import com.mygdx.eternity.puzzchar.Edge;
import com.mygdx.eternity.puzzchar.Face;
import com.mygdx.eternity.puzzchar.FaceType;
import com.mygdx.eternity.puzzchar.Pattern;
import com.opencsv.CSVReader;


public class QuartierDao {
	
	private final static String RESOURCES_PATH = "assets/csv/";
    private final static String ELEVES_FILE_NAME = "faces-01.csv";
    private final static char SEPARATOR = ';';
    private final static FrenchColorAdapter colorAdapter = new FrenchColorAdapter();
        
    /* ---- Cette méthode charge le fichier faces-01.csv ----- */
    public List<Face> findQuartiers() throws Exception
    {
    
    	File file = new File(RESOURCES_PATH + ELEVES_FILE_NAME);
        FileReader fr;
        List<String[] > data = new ArrayList<String[] >();
        List<Face> quartiers = new ArrayList<Face>();
        
        String[] nextLine = null;

		try {
			fr = new FileReader(file);
	        CSVReader csvReader = new CSVReader(fr, SEPARATOR);
	        
	        /* ----- 1. Lecture des données ----- */
	        while ((nextLine = csvReader.readNext()) != null) {
	            int size = nextLine.length;

	            // ligne vide
	            if (size == 0) {
	                continue;
	            }
	            String debut = nextLine[0].trim();
	            if (debut.length() == 0 && size == 1) {
	                continue;
	            }

	            // ligne de commentaire
	            if (debut.startsWith("#")) {
	                continue;
	            }
	            data.add(nextLine);
	        }
	        
	        /*----- 2. Transformation des données en objet ----- */
	        for(String[] oneData : data)
	        {
	        	Face quartier = null;
	      
	        	String typeStr = oneData[0];
	        	String idQuartierStr = oneData[1];
	        	String couleurFondStr = oneData[2];
	        	
	        	FaceType type = FaceType.getByCode(typeStr);
	        	Color couleurFond = colorAdapter.getAsObject(couleurFondStr);
	        	 
	        	int idQuartier = Integer.parseInt(idQuartierStr);
	        	
	        	if(oneData.length > 2)
	        	{
	        		String symboleStr = oneData[3];
	        		Pattern symbole = Pattern.getByCode(symboleStr);
		        	String couleurFormeStr = oneData[4];
		        	Color couleurForme = colorAdapter.getAsObject(couleurFormeStr);
		        	
		        	
		        	quartier = new Face(idQuartier, type , couleurFond, symbole , couleurForme);
	        	}
	        	
	        	else
	        	{
	        		
	        		quartier = new Edge(idQuartier);
	        		
	        	}
	        	
	        	quartiers.add(quartier);
	        }
	        
	        /* ----- 3. Retour de le liste ----- */
	        return quartiers;
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return quartiers;
    }
    
    
    
    
}
