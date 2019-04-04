window.onload = function() {
	console.log("loading in...");
	loadLandingView();
}

function loadLandingView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			console.log('response received');
			if (xhr.status == 200) {
				$('#view').html(xhr.responseText);
				// $('#goToForgot').on('click', loadForgotView);
				$('#goToEmployee').on('click', loadEmployeeView);
				$('#goToFM').on('click', loadFMView);
				$("#login").on('click', function() {
					var username = $("#username").val();
					var password = $("#password").val();

					if (username == "") {
						alert("Username is required");
						return;
					}
					if (password == "") {
						alert("Password is required");
						return;
					}
					// console.log(username + "user");
					// console.log(password + "pass");
					// var user = JSON.parse(xhr.responseText);
					// console.log(xhr.getAllResponseHeaders());
					// if (user == null) {
					// // not logged in -- tell user about invalid credentials
					// $('#message').html('Sorry! Invalid credentials!');
					// } else {
					// // logged in . do things
					// console.log(user);
					// loadHomeView(user);
					// }
					loginAndRedirect(username, password);

				});
			}

		}
	}
	xhr.open("GET", "landing.view");
	xhr.send();
}

function loginAndRedirect(uname, pw) {
	$.ajax({
		url : "LoginServlet",
		method : 'post',
		data : {
			username : uname,
			password : pw
		},
		success : function(data) {
			// var user = xhr.responseText;
			// console.log(data);
			// console.log(xhr.getAllResponseHeaders());
			alert("redirect to fm/employee");
			// window.location.href = "";
			// console.log(data);
			// console.log("NAME " + data.username);
			loadHomeView(data);
			// loadHomeView(data);
		},
		error : function(data) {
			// var user = xhr.responseText;
			// console.log(user);
			// console.log(xhr.getAllResponseHeaders());
			alert("redirect to index");
			// loadHomeView();
			// window.location.href = "";
		}
	});
}

function loadHomeView(user) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.responseText) {
			$('#view').html(xhr.responseText);
			$('#name').html(user.firstName);
			$('#role').html(user.role);
			$('#roleR').on('click', function() {
				// console.log("click");
				// console.log(user);
				if (user.role == "Employee") {
					// console.log("employee");
					loadEmployeeView(user);

				} else {
					// console.log("fm");
					loadFMView(user);
				}
			});

		}
	}
	xhr.open("GET", "homepage.view");
	xhr.setRequestHeader("Content-type", "application/json")
	xhr.send();
	// console.log(xhr.getAllResponseHeaders());
}

function loadEmployeeView(user) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.responseText) {
			$('#view').html(xhr.responseText);
			// console.log(user);
			$('#name').html(user.firstName);
			$('#staticEmail').html(user.userId);
			$('#username').html(user.username);
			// console.log(user.username);
			$("#viewall").on('click', function() {
				var uname = user.username;
				// console.log(user);
				View(uname);
				// console.log(uname);
			});
			$("#add").on('click', function() {
				console.log(user);
				var uname = user.username;
				var amount = $("#amount").val();
				var desc = $("#desc").val();
				var type = $('#inlineFormCustomSelectPref').val();

				if (desc == "") {
					alert("description is required");
					return;
				}
				if (amount == "") {
					alert("amount is required");
					return;
				}
				if (inlineFormCustomSelectPref == "") {
					alert('label type is required');
					return;
				}
				Add(uname, amount, desc, type);

			});
		}
	}
	xhr.open("GET", "Employee.view");
	xhr.setRequestHeader("Content-type", "application/json")
	xhr.send();
	console.log(xhr.getAllResponseHeaders());
}

function Add(uname, am, de, ty) {
	$.ajax({
		url : "EmployeeAdd",
		method : 'post',
		data : {
			username : uname,
			amount : am,
			desc : de,
			TypeID : ty
		},
		success : function(ad) {
			console.log(ad);
			alert("Added to database. Please login again.")
			loadLandingView();

		},
		error : function(ad) {
			console.log(ad);
		}
	});
}

function View(uname) {
	$.ajax({
		url : "Employee",
		method : 'post',
		data : {
			username : uname
		},
		success : function(reimb) {
			console.log(reimb);
			var reimbdata = reimb;
			$('#table_id').DataTable({
				data : reimb,
				columns : [ {
					data : 'amount'
				}, {
					data : 'author'
				}, {
					data : 'desc'
				}, {
					data : 'id'
				}, {
					data : 'recipt'
				}, {
					data : 'resolved'
				}, {
					data : 'resolver'
				}, {
					data : 'status'
				}, {
					data : 'statusId'
				}, {
					data : 'submitted'
				}, {
					data : 'type'
				}, {
					data : 'typeId'
				} ]
			});
		}
	});
}

function loadFMView(user) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.responseText) {
			$('#view').html(xhr.responseText);
			$('#name').html(user.firstName);
			$('#staticEmail').html(user.userId);
			$('#username').html(user.username);
			$("#viewall").on('click', function() {
				Viewa();
			});
			$('#Approve').on('click', function() {
				var id = $("#uid").val();
				var uname = user.username;
				$.ajax({
					url : "FMApprove",
					method : 'post',
					data : {
						username : uname,
						uid : id
					},
					success : function(app) {
						console.log(app);
						alert("Approved to database. Please login again.")
						loadLandingView();

					},
					error : function(app) {
						console.log(app);
					}
				});
			});
			$('#Deny').on('click', function() {
				var id = $('#uid').val();
				var uname = user.username;
				$.ajax({
					url : "FMDeny",
					method : 'post',
					data : {
						username : uname,
						uid : id
					},
					success : function(app) {
						console.log(app);
						alert("Denied to database. Please login again.")
						loadLandingView();

					},
					error : function(app) {
						console.log(app);
					}
				});
			});
		}
	}
	xhr.open("GET", "FM.view");
	xhr.setRequestHeader("Content-type", "application/json")
	xhr.send();
	console.log(xhr.getAllResponseHeaders());
}

function Viewa() {
	$.ajax({
		url : "FM",
		method : 'post',
		data : {},
		success : function(reimb) {
			console.log(reimb);
			var reimbdata = reimb;
			$('#table_id').DataTable({
				data : reimb,
				columns : [ {
					data : 'amount'
				}, {
					data : 'author'
				}, {
					data : 'desc'
				}, {
					data : 'id'
				}, {
					data : 'recipt'
				}, {
					data : 'resolved'
				}, {
					data : 'resolver'
				}, {
					data : 'status'
				}, {
					data : 'statusId'
				}, {
					data : 'submitted'
				}, {
					data : 'type'
				}, {
					data : 'typeId'
				} ]
			});
		}
	});
}
