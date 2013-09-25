<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="scripts/lib/jquery.js"></script>
<script type="text/javascript" src="scripts/lib/jquery.jstree.js"></script>
</head>
<body>
	<div id="demo">
	</div>
</body>
	<script type="text/javascript">
		$('#demo').jstree({
			"json_data" : {
				"data" : [
				          {
				        	  "data": "A noe",
				        	  "attr": {"id": "aaa"},
				        	  "children": ["bbb", "ccc"]
				          }
				         ]
			},
			"plugins": ["themes", "json_data", "checkbox"]
		});
	</script>
</html>
