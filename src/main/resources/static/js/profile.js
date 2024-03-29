const xhr = new httpRequest();

xhr.get("http://localhost:8080/happy/user/1", 
function(error, user){
    
    if(error){
        console.log(error)
    }
    else{

        user = JSON.parse(user);
        
        const username = document.getElementById("username").innerText = `${user.username}`; 

        let ddd = new Date(`${user.registrationDate}`);
        let registrationDate = getBeautifulDate(ddd);
        const doc = document.getElementById("doc").innerHTML           = `<span class="pull-left"><strong>Joined</strong></span> ${registrationDate}`;
        
        const fullname = document.getElementById("fullname").innerHTML = `<span class="pull-left"><strong>Full name</strong></span> ${user.firstName} ${user.lastName}`;

        const email = document.getElementById("email").innerHTML       = `<span class="pull-left"><strong>Email</strong></span> ${user.email}`;

        if(user.dateOfBirth !=null){
        	const age = document.getElementById("age").innerHTML       = `<span class="pull-left"><strong>Age</strong></span> ${getAge(user.dateOfBirth)}`;
        }
        else{
        	document.getElementById("age").innerHTML                   = `<span class="pull-left"><strong>Age</strong></span> -`;
        }
        
        document.getElementById("new_picture").setAttribute("action", `saveUserPhoto/${user.userId}`);
        
        const img = document.querySelector("#img-profile");
        
        img.setAttribute("src", `image/${user.userId}`);
        
        document.getElementById("deleteProfile").addEventListener("click", function(){
            
            xhr.delete(`http://localhost:8080/happy/deleteUser/${user.userId}`, 
            		function (error, user) {
            	  if(error){
            	    console.log(error);
            	  }
            	  else{
            	    location.reload();
            	    console.log(user);
            	  }
            	  
        	});
            
        
        });
        
        	
        	httpHome.get(`http://localhost:8080/happy/avgCurrentProfile/${user.userId}`, (error, avgRatingCurrentYear) => {
        		
        		if(error){
        			console.log(error);
        		}
        		else{
        			
        			let today = new Date();
        			
        			avgRatingCurrentYear = Math.round( avgRatingCurrentYear * 100) / 100;
        			
        			document.getElementById("avgCurr").innerHTML = `<span class="pull-left"><strong id="currYear">
        														    General ${today.getFullYear()}</strong></span> 
        														    ${ avgRatingCurrentYear}%`;
        		}
        		
        	});

        
    }
});



let d = new Date();


let lastLogin = getBeautifulDate(d);

const lastLog = document.getElementById("lastLogin").innerHTML = '<span class="pull-left"><strong>Last seen</strong></span> '+ lastLogin;

document.getElementById("imageProfile").addEventListener("click", function(){
	
	const divImageProfile = document.getElementById("divImageProfile");
	
	const imageForm = document.getElementById("new_picture");
	
	imageForm.style.display = "block";
	
});




