/**
 * 
 */
function Login()
{
	let authentication = {email : document.getElementById("email").value, pass : document.getElementById("pwd").value}

	EmployeeView();
}


function EmployeeView(){
	
	
	document.getElementById("testing").innerHTML = 
		`<div class="container">

		<h1><font color = "white">Employee Home Page </font> </h1>
		
		</div>
	
			<div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-tabs card-header-tabs">
      <li class="nav-item">
        <a class="nav-link show active" href="#">Employee Information</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Submit Reimbursements</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="#">View Reimbursements</a>
      </li>
    </ul>
  </div>
  <div class="card-body" style="height: 500px;">
    <h5 class="card-title">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
  </div>
  
		`
	
}