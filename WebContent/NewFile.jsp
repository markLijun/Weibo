
<html>
<head>
<title>HH</title>
<head>
<script type="text/javascript">

function addDiv()
{
var newDiv = document.createElement("div");
newDiv.setAttribute("id","newDiv");
var bodyTags = document.getElementByTagName("body");
var thisBody = bodyTags[0];
thisBody.appendChild(newDiv);
var textNode = document.createTextNode("Im your new div");
newDiv.appendChild(textNode);
}

</script>
</head>
<body>
<a href = "#"onClick="addDiv();return false;">Add</a>
</body>
</html>