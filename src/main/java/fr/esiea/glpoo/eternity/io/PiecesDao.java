package fr.esiea.glpoo.eternity.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import fr.esiea.glpoo.eternity.domain.Face;
import fr.esiea.glpoo.eternity.domain.Piece;



public class PiecesDao {
	
	private final static String RESOURCES_PATH = "resources/";
    private final static String PIECES_FILE_NAME = "pieces-01.csv";
    private final static char SEPARATOR = ';';
    
    /* ---- Load The CSV File Pieces ----- */
    public List<Piece> findPieces() throws Exception
    {
    	File file = new File(RESOURCES_PATH + PIECES_FILE_NAME);
        FileReader fr;
        List<String[] > data = new ArrayList<String[] >();
        List<Piece> pieces= new ArrayList<Piece>();
        
        String[] nextLine = null;

		try {
			fr = new FileReader(file);
	        CSVReader csvReader = new CSVReader(fr, SEPARATOR);
	        
	        /* ----- Read ----- */
	        while ((nextLine = csvReader.readNext()) != null) {
	            int size = nextLine.length;

	            // Case void
	            if (size == 0) {
	                continue;
	            }
	            String debut = nextLine[0].trim();
	            if (debut.length() == 0 && size == 1) {
	                continue;
	            }

	            // Ignoring comments 
	            if (debut.startsWith("#")) {
	                continue;
	            }
	            data.add(nextLine);
	        }
	        
	        /*----- 2. Convert into Object ----- */
	        for(String[] oneData : data)
	        {	      
	        	Piece piece;
	        	
	        	Face quartierNord;
	        	Face quartierEst;
	        	Face quartierSud;
	        	Face quartierOuest;
	        	
	        	String idPieceStr = oneData[1];
	        	String idQuartierNordStr = oneData[2];
	        	String idQuartierEstStr = oneData[3];
	        	String idQuartierSudStr = oneData[4];
	        	String idQuartierOuestStr = oneData[5];
	        	
	        	int idPiece = Integer.parseInt(idPieceStr);
	        	int idQuartierNord = Integer.parseInt(idQuartierNordStr);
	        	int idQuartierEst = Integer.parseInt(idQuartierEstStr);
	        	int idQuartierSud = Integer.parseInt(idQuartierSudStr);
	        	int idQuartierOuest = Integer.parseInt(idQuartierOuestStr);
	        	
	        	/* ----- Get Faces Depend On Theyre ID ------ */
	        	quartierNord = getQuartier(idQuartierNord);
	        	quartierEst = getQuartier(idQuartierEst);
	        	quartierSud = getQuartier(idQuartierSud);
	        	quartierOuest = getQuartier(idQuartierOuest);
	        	
	        	
	        	
	        	
	        	
	        	/* ---- Create Piece and Add it To The List ----- */
	        	piece = new Piece(idPiece, quartierNord, quartierEst, quartierSud, quartierOuest);
	        	pieces.add(piece);
	        }
	        
	        /* ----- 3. List ----- */
	        return pieces;
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return pieces;
    }
    
    public Face getQuartier(int pIndice) throws Exception
    {
    	Face quartier = null;
    	QuartierDao quartierDao = new QuartierDao();
    	List<Face> quartiers = quartierDao.findQuartiers();
    	
    	boolean trouve = false;
    	int i = 0;
    	while(!trouve && i < quartiers.size())
    	{
    		if(quartiers.get(i).getId() == pIndice)
    		{
    			quartier = quartiers.get(i);
    			
    			trouve = true;
    		}
    		i++;
    	}
    	
    	return quartier;
    }
}
