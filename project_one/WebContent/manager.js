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
		}
		
		let employee;
		function newUser(){
				console.log("new user")
				
				let register ={
				 first : document.getElementById("first").value,
				 last : document.getElementById("last").value,
				 email : document.getElementById("email").value,
				 pass : document.getElementById("pass").value,
				 mID : document.getElementById("managerID").value
				}
				
				let newusers = JSON.stringify(register);
				let xhr = new XMLHttpRequest();
				xhr.open("POST", "http://localhost:8089/project_one/NewUserServlet",true);
				xhr.onload = () => {//console.log(xhr.responseText)			
				}
				xhr.onerror = function() {
				    console.log('Error');
				}
				console.log(newusers);
				xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
				xhr.overrideMimeType('application/xml');
				xhr.send(JSON.stringify(newusers))
		}
		
		
		
function EmployeeInfo(){
	var data;
	var info;
	let xhr = new XMLHttpRequest();	    
    
	 xhr.open("POST", "http://localhost:8089/project_one/UsersServlet");
	    xhr.onload = () => {

	    	data = JSON.parse(xhr.responseText);
	       
	        let place = document.getElementById("shane");
            let usersName = document.createElement("li");
            let email = document.createElement("li");
            let employ = document.createElement("li");
            let man = document.createElement("li");
            
            usersName.innerHTML =  data.first + " " + data.last;
            email.innerHTML = "Email: " + data.email;
            employ.innerHTML = "Employee ID: " + data.employee;
            man.innerHTML = "Manager ID: " + data.Manager;
            place.appendChild(usersName);
            place.appendChild(email);
            place.appendChild(employ);
            place.appendChild(man);
	    };

	     xhr.onerror = function() {
	         console.log('Error');
	     }
	     xhr.send(data);
}


function Requests(){
	fetch("http://localhost:8089/project_one/ReimbursementsServlet").then(function(response) {
		
		
		
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			window.location = "http://localhost:8089/project_one/ReimbursementsServlet";
		} else {
			console.log(data);
		   for (let i = 0 ; i < data.length; i ++) {
			   
			var table =  document.getElementById("rlist");
			let row = table.insertRow(0);
			let requestId = row.insertCell(0);
			let employeeId = row.insertCell(1);
			let email =  row.insertCell(2);
			let amount = row.insertCell(3);
			let cat =  row.insertCell(4);
			let stat = row.insertCell(5);
			let button = row.insertCell(6);
	
			requestId.setAttribute('scope', 'row');
			requestId.innerHTML = data[i].rID;
			
			employeeId.setAttribute('scope', 'row');
			employeeId.innerHTML = data[i].eID;
			
			email.setAttribute('scope', 'row');
			email.innerHTML = data[i].email;

			amount.setAttribute('scope', 'row');
			amount.innerHTML = "$" + data[i].amount;
			
			cat.setAttribute('scope', 'row');
			cat.innerHTML = data[i].category;

			stat.setAttribute('scope', 'row');
			stat.innerHTML = data[i].status;
			
			button.setAttribute('scope', 'row');
			button.innerHTML = `<button type="button" class="btn btn-success" onclick=Approve(${data[i].rID})>Approve</button>
							  	<button type="button" class="btn btn-danger"  onclick=Deny(${data[i].rID})>Deny</button>`;

			console.log(data[i].description);
		}
	}
	});
}


function AllEmployees(){
	
	fetch("http://localhost:8089/project_one/UsersServlet").then(function(response) {
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			window.location = "http://localhost:8089/project_one/UsersServlet";
		} else {
			console.log(data);
		   for (let i = 0 ; i < data.length; i ++) {
			   
			var table =  document.getElementById("el");
			let row = table.insertRow(0);
			let eID = row.insertCell(0);
			let first = row.insertCell(1);
			let last =  row.insertCell(2);
			let email = row.insertCell(3);
			;
	
			eID.setAttribute('scope', 'row');
			eID.innerHTML = data[i].id;
			
			first.setAttribute('scope', 'row');
			first.innerHTML = data[i].firstname;
			
			last.setAttribute('scope', 'row');
			last.innerHTML = data[i].lastname;

			email.setAttribute('scope', 'row');
			email.innerHTML =  data[i].email;
			
			
			

			console.log(data[i].description);
		}
	}
	});
}
function Approve(approve){
	let content = {approvereq: approve};
	fetch("http://localhost:8089/project_one/ApproveDenyServlet", {
		  method: 'post',
		  headers: {
		    'Content-Type': 'application/json'
		  },
		  body: JSON.stringify(content)
		}).then(function(response) {
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			window.location = "http://localhost:8089/project_one/ManagerProfile";
		} else {
			console.log(data);
		   
	}
	});
}

function Deny(deny){
	let content = {denyreq: deny};
	fetch("http://localhost:8089/project_one/ApproveDenyServlet", {
		  method: 'post',
		  headers: {
		    'Content-Type': 'application/json'
		  },
		  body: JSON.stringify(content)
		}).then(function(response) {
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			window.location = "http://localhost:8089/project_one/ManagerProfile";
		} else {
			console.log(data);
		   
	}
	});
}	

function getImage(){
	
}	
		
		
		
let newpic = "";
function previewFile(){
	    var preview = document.querySelector('img'); //selects the query named img
	    var file    = document.querySelector("input[type=file]").files[0]; //sames as here
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
	    }
	    console.log(newpic);
	    
}
		
		
	
			
