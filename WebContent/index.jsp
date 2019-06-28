<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Add Lead UTL</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<div class="row">
			<p class="h2 mx-auto">Add Lead UTL</p>
		</div>
		<div class="row ${msg_class}" id="msg_div">
			<div class="alert alert-success mx-auto" role="alert">${msg}</div>
		</div>
		<div class="row ${err_msg_class}" id="err_msg_div">
			<div class="alert alert-danger mx-auto" role="alert">
				${err_msg}</div>
		</div>
		<form action="add_lead_utm" method="post" id="add_lead_utm_form">
			<div class="form-group row">
				<label for="fullName" class="col-sm-2 col-form-label">Full
					Name</label>
				<div class="col-sm-10">
					<input type="text" required="required" class="form-control"
						name="fullName" id="fullName" placeholder="Full Name">
				</div>
			</div>
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" required="required"
						name="email" id="email" placeholder="email">
				</div>
			</div>
			<div class="form-group row">
				<label for="phoneNo" class="col-sm-2 col-form-label">Phone
					No</label>
				<div class="col-sm-3">
					<select required="required" id="phoneType_N" name="phoneType_N"
						class="form-control">
						<option selected></option>
						<option value="mobile">Mobile</option>
						<option value="home">Home</option>
						<option value="work">Work</option>
					</select>
				</div>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="phoneNo"
						required="required" id="phoneNo" placeholder="0123456789">
				</div>
			</div>
			<div class="form-group row">
				<label for="utmMedium" class="col-sm-2 col-form-label">Utm
					Medium</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="utmMedium"
						id="utmMedium">
				</div>
			</div>
			<div class="form-group row">
				<label for="utmTerm" class="col-sm-2 col-form-label">Utm
					Term</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="utmTerm" id="utmTerm">
				</div>
			</div>
			<div class="form-group row">
				<label for="utmContent" class="col-sm-2 col-form-label">Utm
					Content</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="utmContent"
						id="utmContent">
				</div>
			</div>
			<div class="form-group row">
				<label for="utmUrl" class="col-sm-2 col-form-label">Utm Url</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="utmUrl" id="utmUrl">
				</div>
			</div>
			<div class="form-group row">
				<label for="notes" class="col-sm-2 col-form-label">Notes</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="notes" id="notes"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label"></label>
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
					<button type="reset" class="btn btn-secondary">Reset</button>
				</div>
			</div>
		</form>
	</div>
	</div>
</body>
</html>