<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>

<body>

	<button type="button" class="btn btn-primary" id="liveToastBtn">Show
		live toast</button>

	<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
		<div id="liveToast" class="toast hide" role="alert"
			aria-live="assertive" aria-atomic="true">
			<div class="toast-header">
					class="me-auto">Bootstrap</strong> <small>11 mins ago</small>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
			<div class="toast-body">Hello, world! This is a toast message.
			</div>
		</div>
	</div>
<script>
    document.getElementById("liveToastBtn").addEventListener("click", function() {
        var toast = new bootstrap.Toast(document.getElementById("liveToast"));
        toast.show();
    });
</script>
</body>

</html>