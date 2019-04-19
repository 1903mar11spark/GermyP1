/**
 * 
 */
function Login()
{	//http://localhost:8089/project_one/HomeServlet
	let authentication = {email : document.getElementById("email").value, pass : document.getElementById("pwd").value}
	let data = JSON.stringify(authentication);
	let homurl = 'http://localhost:8089/project_one/home';
	fetch(homeurl, {
	    method: 'POST',
	    headers: { "Accept": "application/json",'Content-Type': 'application/json'},
	    body: JSON.stringify({
	        email: document.getElementById("email").value,
	        password: document.getElementById("pwd").value
	    })
	}).then( (response) => {
		return response.json();
	})
	
	.then(data =>  { 
	    if(data.response){
	    	console.log(data);
	        redirect: window.location.replace(EmployeeView()) 
	    } else{
	        alert("Invalid Email or Password");
	    }
	}) 
	.catch((error) => {
		alert('oh no :(');
	    console.log(error);
	})
	//EmployeeView();
}

function Register(){
	document.getElementById("testing").innerHTML = `
	<div>

	<form class="needs-validation" novalidate id = "addPost">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationCustom01" ><font color = "white">First name</font></label>
      <input type="text" class="form-control" id="name1" placeholder="First name" value="Germy" required>
      <div class="valid-feedback">
         <font color = "green">Looks good! </font>
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationCustom02"><font color = "white">Last name</font></label>
      <input type="text" class="form-control" id="name2" placeholder="Last name" value="Louis" required>
      <div class="valid-feedback">
        <font color = "green">Looks good! </font>
      </div>
    </div>
	
	<div class="form-group">
    <label for="exampleInputEmail1"><font color = "white">Email address</font></label>
    <input type="email" class="form-control" id="mail" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1"><font color = "white">Password</font></label>
    <input type="password" class="form-control" id="word" placeholder="Password">
  </div>
	 
		<div class="custom-file">
		<input type="file" class="custom-file-input" id="customFile">
		<label class="custom-file-label" for="customFile">Choose Profile Picture</label>
		</div>
		<button type="submit" class="btn btn-primary method = "POST">Submit</button>
	</form>
	
		
		
		
		
		</div>
		
	`
		document.getElementById('addPost').addEventListener('submit', newUser)
		function newUser(e){
		e.preventDefault();
		let first = document.getElementById("name1").value;
		let last = document.getElementById("name2").value;
		let email = document.getElementById("mail").value;
		let pass = document.getElementById("word").value;
	    fetch("http://localhost:8089/project_one/NewUserServlet", {method: "POST", headers:{"Accept":"application/json"},
	    	body: JSON.stringify({first:name1,last:name2,email:mail,pass:word})})
	    //define behavior when response returns
	    .then((response)=> {
	        //return unwrapped promise obj for the next chained op
	        return response.json();
	        //console.log(response.json());
	    })
	    //utilize unwrapped promise as js obj
	    .then((data) => {
	        console.log(data);
	    }).catch((error) => {
			alert('Error: New User Fetch :(');
		    console.log(error);
		})
	}
}


function EmployeeView(){
	
	
	document.getElementById("testing").innerHTML = 
		`<div class="container">
		<h1><font color = "white">Employee Home Page </font> </h1>
		</div>
	
			<div class="card text-center">
			<div class="card-header">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		  <li class="nav-item">
		    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true"> Home </a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"> Request Reimbursements </a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="messages-tab" data-toggle="tab" href="#messages" role="tab" aria-controls="messages" aria-selected="false"> View Reimbursements </a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab" aria-controls="settings" aria-selected="false"> Update Info </a>
		  </li>
		</ul>

<!-- Tab panes -->
<div class="tab-content">
  <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab" style = "height : 500px;">Home</div>
  
  <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab" style = "height : 500px;">
  <button type="button" value = "Back" class="btn btn-dark" onclick="goBack()"> Go Back </button>
		
		
		<h1>Upload Receipts</h1>
  <center>
        <form method="post" action="uploadFile" enctype="multipart/form-data">
            Select file to upload:
            <input type="file" name="uploadFile" id = "img" onchange="previewFile()" />
            <br/><br/>
            <input type="submit" value="Upload" />
            <br><br>
            <img src="" height="200" id = "pre" alt="Image preview...">
        </form>
    </center>
  
  
  
  </div>
  
  <div class="tab-pane" id="messages" role="tabpanel" aria-labelledby="messages-tab" style = "height : 500px;">
  
  </div>
  
  <div class="tab-pane" id="settings" role="tabpanel" aria-labelledby="settings-tab" style = "height : 500px;">
			
  </div>
  
</div>
  </div>
  
		`
	
}


function ManagerView(){
	
	
	document.getElementById("testing").innerHTML = 
		`<div class="container">
		<h1><font color = "white">Employee Home Page </font> </h1>
		</div>
	
			<div class="card text-center">
			<div class="card-header">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		  <li class="nav-item">
		    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true"> Home </a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"> Request Reimbursements </a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="messages-tab" data-toggle="tab" href="#messages" role="tab" aria-controls="messages" aria-selected="false"> View Reimbursements </a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab" aria-controls="settings" aria-selected="false"> Update Info </a>
		  </li>
		</ul>

<!-- Tab panes -->
<div class="tab-content">
  <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab" style = "height : 500px;">Home</div>
  
  <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab" style = "height : 500px;">
  <button type="button" value = "Back" class="btn btn-dark" onclick="goBack()"> Go Back </button>
		
		
		<h1>Upload Receipts</h1>
  <center>
        <form method="post" action="uploadFile" enctype="multipart/form-data">
            Select file to upload:
            <input type="file" name="uploadFile" id = "img" onchange="previewFile()" />
            <br/><br/>
            <input type="submit" value="Upload" />
            <br><br>
            <img src="" height="200" id = "pre" alt="Image preview...">
        </form>
    </center>
  
  
  
  </div>
  
  <div class="tab-pane" id="messages" role="tabpanel" aria-labelledby="messages-tab" style = "height : 500px;">
  
  </div>
  
  <div class="tab-pane" id="settings" role="tabpanel" aria-labelledby="settings-tab" style = "height : 500px;">
			
  </div>
  
</div>
  </div>
  
		`
	
}

let newpic = "";
function previewFile(){
    var preview = document.querySelector('img'); //selects the query named img
    var file    = document.querySelector('input[type=file]').files[0]; //sames as here
    var reader  = new FileReader();

    reader.onloadend = function () {
        preview.src = reader.result;
        
    }

    if (file) {
        reader.readAsDataURL(file); //reads the data as a URL
        function getBase64(file) {
        	reader.onload = function () {
        		newpic = reader.result;
        	     console.log(reader.result);
        	   };
        	   reader.onerror = function (error) {
        	     console.log('Error: ', error);
        	   };
        }
    } else {
        preview.src = "";
    }newpic = getBase64(file);
    console.log(newpic);
    
}

function goBack() {
	  window.history.back();
	}

function getUser(){
	fetch('http://localhost:8089/project_one/HomeServlet')
	  .then(function(response) {
	    return response.json();
	  })
	  .then(function(myJson) {
	    console.log(JSON.stringify(myJson));
	  });
}
(function() {
	  'use strict';
	  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        form.classList.add('was-validated');
	      }, false);
	    });
	  }, false);
	})();
