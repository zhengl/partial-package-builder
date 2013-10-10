<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="styles/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="styles/main.css" rel="stylesheet">
</head>
<body>
	<header class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Partial Package Builder</a>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<aside class="col-md-4">
				<select class="form-control">
					<option>ProjectA</option>
					<option>ProjectB</option>
				</select>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion" href="#collapseFiles">
									Files
								</a>
							</h4>
						</div>
						<div id="collapseFiles" class="panel-collapse collapse in">
							<div class="panel-body">
								A Tree View Here
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion" href="#collapseProperties">
									Properties
								</a>
							</h4>
						</div>
						<div id="collapseProperties" class="panel-collapse collapse">
							<div class="panel-body">
								A List Here
							</div>
						</div>
					</div>
				</div>
			</aside>
			<div class="col-md-8">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">Workspace</a></li>
					<li><a href="#">Packages</a></li>
				</ul>
			</div>
		</div>

	</div>
</body>
<script src="//code.jquery.com/jquery.js"></script>
<script src="scripts/bootstrap.min.js"></script>
</html>
