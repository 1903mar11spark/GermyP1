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
		
function updateEmployee(){
	let info = {
			 first : document.getElementById("first").value,
			 last : document.getElementById("last").value,
			 email : document.getElementById("email").value,
			 pass : document.getElementById("pass").value
			 
			}
			
			let update = JSON.stringify(info);
			let xhr = new XMLHttpRequest();
			xhr.open("POST", "http://localhost:8089/project_one/UpdateEmployeeServlet",true);
			xhr.onload = () => {//console.log(xhr.responseText)
		        //console.log(first);
				
			}
			xhr.onerror = function() {
			    console.log('Error');
			}
			console.log(update);
			xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
			//xhr.overrideMimeType('application/xml');
			xhr.send(update)
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
