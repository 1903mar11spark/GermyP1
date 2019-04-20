/**
 * 
 */
function Login(){
	 console.log("login");	
	 let loginData = {
				email: document.getElementById("email").value,
				password: document.getElementById("pwd").value
			}
	 	
	   
	   
	   let authentication = JSON.stringify(loginData);
	 	console.log(loginData)
	   let xhr = new XMLHttpRequest();
	   EmployeeView();
	   xhr.onload =()=>{
		   
		   console.log("in xhr")
		   console.log(xhr.responseText + "Login ajax")
		   let info = JSON.parse(xhr.responseText);
		   console.log(info + " data" )
		   console.log("onload id is " + info );
		   
//		   if(info.position === "Employee"){
//			   
//			   EmployeeHomePage(info);
//		   }else if(info.position ==="Manager"){
//			ManagerHomePage(info);   
//		   }
			   
		   }
	   
	   xhr.onError = ()=>{
		   console.log('Error')
	   }
	   xhr.open("POST","http://localhost:8089/com.servlets/home");
	   console.log(xhr.responseText + "Login ajax")
	   console.log(authentication);
	   xhr.send(authentication);

		}
		


function Register(){
	console.log("register function");
	document.getElementById("testing").innerHTML = `
	<div>

	<form class="needs-validation" novalidate id = "addPost" action = "NewUserServlet" method = "POST">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationCustom01" ><font color = "white">First name</font></label>
      
      <input type="text" class="form-control" id="first" placeholder="First name" value="Germy" required name = "first">
      <div class="valid-feedback">
         <font color = "green">Looks good! </font>
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationCustom02"><font color = "white">Last name</font></label>
      
      <input type="text" class="form-control" id="last" placeholder="Last name" value="Louis" required name = "last">
      <div class="valid-feedback">
        <font color = "green">Looks good! </font>
      </div>
    </div>
	
	<div class="form-group">
    <label for="exampleInputEmail1"><font color = "white">Email address</font></label>
    
    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email" name = "email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1"><font color = "white">Password</font></label>
    
    <input type="password" class="form-control" id="pass" placeholder="Password" name = "pass">
  </div>
	 
		<div class="custom-file">
		<input type="file" class="custom-file-input" id="customFile">
		<label class="custom-file-label" for="customFile">Choose Profile Picture</label>
		</div>
		<button type="submit" class="btn btn-primary"  onClick = newUser()>Submit</button>
	</form>
	
		
		
		
		
		</div>
		
	`
		
}
	//	document.getElementById('sub').addEventListener('submit', newUser)
		function newUser(){
		console.log("new user")
		//e.preventDefault();
		let first = document.getElementById("first").value;
		let last = document.getElementById("last").value;
		let email = document.getElementById("email").value;
		let pass = document.getElementById("pass").value;
		console.log(pass);
		let user = JSON.stringify({"first":first,"last":last,"email":email,"pass":pass});
		console.log(user);
		let xhr = new XMLHttpRequest();
		xhr.open("POST", "http://localhost:8089/project_one/NewUserServlet");
		xhr.onload = () => {//console.log(JSON.parse(xhr.responseText).name)
	        console.log(xhr.responseText + "newUser function");
		};
		xhr.onerror = function() {
		    console.log('Error');
		}
		xhr.send(user);
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
