package dev.schmarrn.tintify.data;

public class TintifyLangFormatter {
	public static String capitalizedWords(String str){
		String words[]=str.split("_");
		String capitalizedWords="";
		for(String w:words){
			String first=w.substring(0,1);
			String afterfirst=w.substring(1);
			capitalizedWords+=first.toUpperCase()+afterfirst+" ";
		}
		return capitalizedWords.trim();
	}
}
