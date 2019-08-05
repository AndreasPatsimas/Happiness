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

        const age = document.getElementById("age").innerHTML           = `<span class="pull-left"><strong>Age</strong></span> ${getAge(user.dateOfBirth)}`;
    }
});



let d = new Date();


let lastLogin = getBeautifulDate(d);

localStorage.setItem("lastLogin", lastLogin);
localStorage.setItem("imageLink", "andreas.jpg");

const img = document.querySelector("#img-profile");
img.setAttribute("src", localStorage.getItem("imageLink"));


const lastLog = document.getElementById("lastLogin").innerHTML = '<span class="pull-left"><strong>Last seen</strong></span> '+ localStorage.getItem("lastLogin");

document.getElementById("prevYear").textContent = `General ${d.getFullYear() - 1}`;
document.getElementById("thisYear").textContent = `General ${d.getFullYear()}`;



