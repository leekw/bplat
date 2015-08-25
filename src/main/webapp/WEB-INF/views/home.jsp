<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE HTML>


<html>
<head>
<link rel="stylesheet" href="resources/jui/dist/jui.min.css"/>
<link rel="stylesheet" href="resources/jui/dist/jennifer.theme.min.css"/>

<script src= "resources/jui/lib/jquery-1.8.0.min.js"></script>
<script src= "resources/jui/dist/jui.min.js"></script>

<script src= "resources/jui/js/base.js"></script>
<script src= "resources/jui/js/core.js"></script>

<script src="resources/jui/js/util/math.js"></script>
<script src="resources/jui/js/util/color.js"></script>
<script src="resources/jui/js/util/time.js"></script>

<script src="resources/jui/js/util/scale.js"></script>
<script src="resources/jui/js/util/svg.js"></script>

<script src="resources/jui/js/util/svg3d.js"></script>

<script src="resources/jui/js/util/svgbase.js"></script>


<script src="resources/jui/js/ui/button.js"></script>
<script src="resources/jui/js/ui/combo.js"></script>
<script src="resources/jui/js/ui/dropdown.js"></script>


<script src="resources/jui/js/uix/autocomplete.js"></script>
<script src="resources/jui/js/uix/tab.js"></script>

<script src= "resources/jui/js/test.js"></script>


	<title>Home</title>
</head>
<body class="jui">
	<table>
			<tr>
				<td width="170px">View</td>
				<td width="230px">Class</td>
				<td>Description</td>
			</tr>
			<tr>
				<td>
					<span class="label mini"><i class="icon-gear"></i> Label</span>
				</td>
				<td>
					label mini
				</td>
				<td>Default text box (Mini)</td>
			</tr>
			<tr>
				<td>
					<span class="label small"><i class="icon-gear"></i> Label</span>
				</td>
				<td>
					label small
				</td>
				<td>Default text box (Small)</td>
			</tr>
			<tr>
				<td>
					<span class="label info"><i class="icon-gear"></i> Label</span>
				</td>
				<td>
					label info
				</td>
				<td>Blue text box (Normal)</td>
			</tr>
			<tr>
				<td>
					<span class="label large danger"><i class="icon-gear"></i> Label</span>
				</td>
				<td>
					label large danger
				</td>
				<td>Red text box (Large)</td>
			</tr>
			<tr>
				<td>
					<span class="label mini success">Label</span>
				</td>
				<td>
					label mini success
				</td>
				<td>Green text box (Mini)</td>
			</tr>
		</table>
		
		
		<ul id="tab_1" class="tab top">
    <li>
        <a href="#home">Home</a>
    </li>
    <li><a href="#css">CSS</a></li>
    <li><a href="#script">Script</a></li>
</ul>

<div id="tab_contents_1" style="background: #dcdcdc;">
    <div id="home">home</div>
    <div id="css">css</div>
    <div id="script">script</div>
</div>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
