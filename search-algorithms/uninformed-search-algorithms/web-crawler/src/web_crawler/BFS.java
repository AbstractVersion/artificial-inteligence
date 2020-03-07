/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_crawler;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;


public class BFS {
	
	private String firstURL;
	private int maximumURLNo;
	private String urlPatterns;
	private Repository rep = null;
	
	public BFS(String firstURL, int maximumURLNo, String urlPatterns) {
		this.firstURL = firstURL;
		this.maximumURLNo = maximumURLNo;
		this.urlPatterns = urlPatterns;
		this.rep = new Repository();
	}

    public Set<String> bfs() throws IOException{
    	rep.addURLtoQueue(firstURL);
    	
        while(!rep.isQueueEmpty()){ 
            String currentURL = rep.removeURLfromQueue();
            
         
            
            URL url = null;
            BufferedReader br = null;
            
            boolean correctURLFound = false;
            while(!correctURLFound){ 
                try{
                    url = new URL(currentURL);
                    br = new BufferedReader(new InputStreamReader(url.openStream()));
                    correctURLFound = true;
                }catch(MalformedURLException e){
                    System.out.println("Error in URL: "+ currentURL);
                    currentURL = rep.removeURLfromQueue();
                    correctURLFound = false;
                }catch(IOException e){
                    System.out.println("Error in URL: " + currentURL);
                    currentURL = rep.removeURLfromQueue();
                    correctURLFound = false;
                }
            }         
            
            StringBuilder sb = new StringBuilder();
            
            while((currentURL = br.readLine())!=null){
                sb.append(currentURL);
            }
            
            currentURL = sb.toString();
            Pattern pattern = Pattern.compile(this.urlPatterns);
            Matcher matcher = pattern.matcher(currentURL);
            
            while(matcher.find()){
                String urlString = matcher.group(); 
                
                if(!rep.setHasURL(urlString)){
                	rep.addURLtoSet(urlString);    
                    System.out.println("URL crawled just now: " + urlString);
                    rep.addURLtoQueue(urlString);     
                    if(rep.urlNo()>this.maximumURLNo) {
                    	return this.rep.getUrlVisited();
                    }
                    
                }
            } 
        }
        
        return this.rep.getUrlVisited();
    }   
}