package com.portfolio.crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	public static String getText(String content) {  
	    Pattern SCRIPTS = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>",Pattern.DOTALL);  
	    Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>",Pattern.DOTALL);  
	    Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");  
	    //Pattern TAGS = Pattern.compile("(<!--[^>](.*?)-->)|<(\\/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(\\/)?>");  
	    //Pattern TAGS = Pattern.compile("<(\\/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(\\/)?>");
	    //Pattern TAGS1 = Pattern.compile("<!--[^>](.*?)-->");
	    Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");  
	    //Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]+[가-힣]*\\s*>");  
	    Pattern ENTITY_REFS = Pattern.compile("&[^;]+;");  
	    Pattern WHITESPACE = Pattern.compile("\\s\\s+");  
	      
	    Matcher m;  
	      
	    m = SCRIPTS.matcher(content);  
	    content = m.replaceAll("");  
	    m = STYLE.matcher(content);  
	    content = m.replaceAll("");  
	    m = TAGS.matcher(content);  
	    content = m.replaceAll("");  
	    /*m = TAGS1.matcher(content);  
	    content = m.replaceAll("");*/  
	    m = ENTITY_REFS.matcher(content);  
	    content = m.replaceAll("");  
	    m = WHITESPACE.matcher(content);
	    content = m.replaceAll(" ");         
	      
	    return content;  
	}  
}
