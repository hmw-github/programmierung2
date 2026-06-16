package kapitel10;

import java.util.stream.Stream;

/**
 * Verarbeite eine gegebene Liste von Dateinamen folgendermaßen:
 * eliminiere ungültige Namen. Ein Dateiname ist gültig, wenn er
 * - entweder keinen Punkt hat und nicht leer ist oder
 * - er einen Punkt enthält und beide Teile (links und rechts) nicht leer sind
 * gib den Namen so aus: file=<file>, ext=<ext>
 */
public class StreamUebungSS2020 {
    public static void main(String[] args) {
        String[] filenames = { 
            "file.mp3", ".mp3", "b.c", "a.", "abc", "42.txt" };
        // hier die Lösung mit Streams/Lambdas...
        Stream.of(filenames)
        .filter(s -> {
        	int dot = s.indexOf(".");
        	boolean valid;
        	
        	if (dot == -1 && s.length() > 0) {
        		valid = true;
        	} else {
        		// Punkt vorhanden oder Leerstring
        		if (s.length() == 0) {
        			valid = false;
        		} else {
        			String file = s.substring(0, dot);
        			String ext = s.substring(dot+1);
        			
        			valid = file.length() > 0 && ext.length() > 0;
        		}
        	}
        	return valid;
        })
        .forEach(s -> {
        	int dot = s.indexOf(".");
        	String file, ext;
        	
        	if (dot == -1) {
        		file = s;
        		ext = "";
        	} else {
    			file = s.substring(0, dot);
    			ext = s.substring(dot+1);
        	}
			System.out.printf("file=%s, ext=%s\n", file, ext);
        });

        // hier die Lösung ohne Streams/Lambdas...
        for (String s : filenames) {
        	int dot = s.indexOf(".");
        	boolean valid;
        	
        	if (dot == -1 && s.length() > 0) {
        		valid = true;
        	} else {
        		// Punkt vorhanden oder Leerstring
        		if (s.length() == 0) {
        			valid = false;
        		} else {
        			String file = s.substring(0, dot);
        			String ext = s.substring(dot+1);
        			
        			valid = file.length() > 0 && ext.length() > 0;
        		}
        	}
        	if (valid) {
            	int dot2 = s.indexOf(".");
            	String file, ext;
            	
            	if (dot2 == -1) {
            		file = s;
            		ext = "";
            	} else {
        			file = s.substring(0, dot);
        			ext = s.substring(dot+1);
            	}
    			System.out.printf("file=%s, ext=%s\n", file, ext);
        	}
        }
        
    }
}
