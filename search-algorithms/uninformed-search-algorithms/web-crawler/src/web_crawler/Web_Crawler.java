/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_crawler;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Web_Crawler {
    
    public static void main(String[] args){
    	
    	String firstWebsite = "http://www.icsd.aegean.gr/icsd/";
    	String patterns = "http[s]*://(\\w+\\.)*(\\w+)";
    	
    	BFS myCrawler = new BFS(firstWebsite, 50, patterns);
    	 
        try{
        	Set<String> urlsCrawled = myCrawler.bfs();
        	
        	 System.out.println(urlsCrawled.size() + " web sites crawled!");
        	 System.out.println("Here is the list: ");
             for(String s : urlsCrawled){
                 System.out.println(s);
             
             }
        }catch(IOException e){
            System.out.println("IOException: " + e);
        }
    }

}