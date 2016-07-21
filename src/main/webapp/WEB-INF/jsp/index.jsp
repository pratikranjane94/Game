<html>
<script>
function changeWord() {
	document.getElementById('download').value='${link}'
}
</script>
<body>

		<form action="upload" method="get">
			<input type=text name="packageName" id="download" onclick="changeWord();"> 
			Enter Package Name 
			<input type="submit" value="Upload" id="upload" />
	</form>
</body>
</html>
