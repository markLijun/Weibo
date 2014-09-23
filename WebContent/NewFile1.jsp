<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function getTranslations(the_word){
	var languages =new Array("T1","T2","T3");
	for (var loop = 0;loop<languages.length;loop++){
		getTranslationFromFile(languages[loop],the_word);
	}
}
function getTranslationFromFile(the_file,the_word){
	var request = null;
	var xml_response = null;
	if(window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	}else if(window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (request) {
		request.open("GET",the_file + ".xml");
		request.onreadystatechange=function () {
			if(request.readyState == 4) {
				xml_response = request.responseXML;
				document.getElementById(the_file).innerHTML =findTranslation(xml_response,the_word);
			}
			else{
				document.getElementById(the_file).innerHTML ="Serching……";
			}
		};
		request.send(null);
	}else {
		alert("Sorry!");
	}
	
}
function findTranslation(xml_doc,the_word){
	
	var translation_word = "unknown";
	var find_word ="";
	var english_words = xml_doc.getElementsByTagName("english");
	for (var loop = 0;loop<english_words.length;loop++) {
		the_english_element = english_words[loop];
		find_word = the_english_element.firstChild.nodeValue;
		if(the_word == find_word){
			translation_word = the_english_element.nextSibling.firstChild.nodeValue;
		}
	}
	return translation_word;
	
}
</script>
</head>
<body>
<form onSubmit = "getTranslations(document.getElementById('theText').value);return false;">
<input type="text" id="theText">
<input type="button"onClick="getTranslations(document.getElementById('theText').value);return false;"value="Translate!">
</form>
<b>T1:</b><span id = "T1"></span><br>
<b>T2:</b><span id = "T2"></span><br>
<b>T3:</b><span id = "T3"></span><br>
</body>
</html>
