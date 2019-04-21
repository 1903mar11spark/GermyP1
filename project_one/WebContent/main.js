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
	 	//console.log(logtainData)
	   let xhr = new XMLHttpRequest();
	   
	   xhr.onload =()=>{
		   
		   console.log(authentication)
		  
		   let info = JSON.parse(xhr.responseText);
		
		   
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
	   xhr.open("POST","http://localhost:8089/project_one/home");
	   console.log(xhr.responseText + "Login ajax")
	   console.log(authentication);
	   xhr.send(authentication);
		}
		


function Register(){
	console.log("register function");
	
	window.open("http://localhost:8089/project_one/NewUser.html","_self")

    //return false;
	
	
		
}
	//	document.getElementById('sub').addEventListener('submit', newUser)
		function newUser(){
		console.log("new user")
		//e.preventDefault();
		
		let register ={
		 first : document.getElementById("first").value,
		 last : document.getElementById("last").value,
		 email : document.getElementById("email").value,
		 pass : document.getElementById("pass").value,
		 mID : document.getElementById("managerID").value
		}
		
		let newusers = JSON.stringify(register);
		//console.log(newusers);
		let xhr = new XMLHttpRequest();
		xhr.open("POST", "http://localhost:8089/project_one/NewUserServlet",true);
		xhr.onload = () => {//console.log(xhr.responseText)
	        //console.log(first);
			
		}
		xhr.onerror = function() {
		    console.log('Error');
		}
		console.log(newusers);
		xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		xhr.overrideMimeType('application/xml');
		xhr.send(JSON.stringify(newusers))
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
