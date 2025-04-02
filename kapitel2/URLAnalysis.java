package programmierung2.kapitel2;

import java.util.Scanner;

class URL {
    private String protocol;
    private String user;
    private String password;
    private String host;
    private String port;
    private String path;

    public URL(String urlString) {
        parseURL(urlString);
    }

    /**
     * Zerlegt den übergebenen String in die URL-Bestandteile
     * Falls ein Fehler erkannt wird, wird "Fehler" auf die Konsole ausgegeben.
     */
    private void parseURL(String urlString) {
    	if (urlString.indexOf("https") == 0) {
    		urlString = urlString.substring(5);
    		protocol = "https";
    	} else if (urlString.indexOf("http") == 0) {
    		urlString = urlString.substring(4);
    		protocol = "http";
    	} else {
    		System.out.println("Protokoll nicht gefunden!");
    		return;
    	}
        
    }

	@Override
	public String toString() {
		return "URL [protocol=" + protocol + ", user=" + user + ", password=" + password + ", host=" + host + ", port="
				+ port + ", path=" + path + "]";
	}
}

public class URLAnalysis {
    public static String readString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String s = scanner.nextLine();
        scanner.close();
        return s;
    }
    public static void main(String[] args) {
        String s = readString("URL: ");
        URL url = new URL(s);         
        System.out.println(url);
    }
}