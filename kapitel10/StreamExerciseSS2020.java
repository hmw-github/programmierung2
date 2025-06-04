package programmierung2.kapitel10;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Übung in Anlehnung zu Prüfung SS 2020, Aufgabe 1b)
 * Java-Programm mit und ohne Streams und Lambdas:
 * Verarbeite eine gegebene Liste von Dateinamen folgendermaßen:
 * - eliminiere ungültige Namen. Ein Dateiname ist gültig, wenn er
 * 		entweder keinen Punkt hat und nicht leer ist oder
 * 		er einen Punkt enthält und beide Teile (links und rechts) 
 * 		nicht leer sind
 * - gib den Namen so aus: file=<file>, ext=<ext>
 */
public class StreamExerciseSS2020 {
    public static void main(String[] args) {
        String[] filenames = { 
            "file.mp3", ".mp3", "b.c", "a.", "abc", "42.txt" };
        // hier die Lösung mit Streams/Lambdas...
        Predicate<String> validFilename = filename -> {
        	boolean gueltig = true;
        	String file = filename, ext = "";
        	
        	int punktPosition = filename.indexOf(".");
        	if (filename.length() == 0) {
        		gueltig = false;
        	} else if (punktPosition >= 0) {
        		file = filename.substring(0, punktPosition);
        		ext = filename.substring(punktPosition + 1);
        		
        		gueltig = file.length() > 0 && ext.length() > 0;
        	}
        	
        	return gueltig;
        };
        
        Consumer<String> printFilename = filename -> {
        	int punktPosition = filename.indexOf(".");
        	if (punktPosition == -1) {
            	System.out.printf("file=%s, ext=\n", filename);        		        		
        	} else {
        		String file = filename.substring(0, punktPosition);
        		String ext = filename.substring(punktPosition + 1);
            	System.out.printf("file=%s, ext=%s\n", file, ext);        		
        	}
        };
        
        Arrays.stream(filenames)
        .filter(validFilename)
        .forEach(printFilename);

        // hier die Lösung ohne Streams/Lambdas...
        for (String filename : filenames) {
        	boolean gueltig = true;
        	String file = filename, ext = "";
        	
        	int punktPosition = filename.indexOf(".");
        	if (filename.length() == 0) {
        		gueltig = false;
        	} else if (punktPosition >= 0) {
        		file = filename.substring(0, punktPosition);
        		ext = filename.substring(punktPosition + 1);
        		
        		gueltig = file.length() > 0 && ext.length() > 0;
        	}
        	
        	if (gueltig) {
        		// Ausgabe
        		System.out.printf("file=%s, ext=%s\n", file, ext);
        	}
        }
    }
}