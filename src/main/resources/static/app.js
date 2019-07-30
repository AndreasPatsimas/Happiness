document.querySelector("#button1").addEventListener("click",function(){
    const xhr = new XMLHttpRequest();

    xhr.open("GET","customer.json",true);

    xhr.onload = function(){
        if(this.status === 200){

                const customer = JSON.parse(this.responseText);

                const output = `
                <ul>
                    <li>ID: ${customer.id}</li>
                    <li>NAME: ${customer.name}</li>
                    <li>COMPANY: ${customer.company}</li>
                    <li>PHONE: ${customer.phone}</li>
                </ul>`;

                document.getElementById("customer").innerHTML = output;
        }
    };

    xhr.send();
});

document.querySelector("#button2").addEventListener("click",function(){
  const xhr = new XMLHttpRequest();

  xhr.open("GET","customers.json",true);

  xhr.onload = function(){
    if(this.status === 200){
      const customers = JSON.parse(this.responseText);
      
      let output = ``;

      customers.forEach(function(customer){
         output += `
                <ul>
                    <li>ID: ${customer.id}</li>
                    <li>NAME: ${customer.name}</li>
                    <li>COMPANY: ${customer.company}</li>
                    <li>PHONE: ${customer.phone}</li>
                </ul>`;

                document.getElementById("customers").innerHTML = output;
      });
    }
  };

  xhr.send();
});

document.getElementById("button3").addEventListener("click", function(){

  const xhr = new XMLHttpRequest();

  xhr.open("GET", "http://localhost:8080/happy/users", true);

  let output = ``;  
  
  xhr.onload = function(){
    if(this.status === 200){

      const users = JSON.parse(this.responseText);

      users.forEach(function(user){
    	  
    	  output += `
              <ul>
                  <li>ID: ${user.userId}</li>
                  <li>USERNAME: ${user.username}</li>
                  <li>PASSWORD: ${user.password}</li>
                  <li>EMAIL: ${user.email}</li>
              </ul>`;

              document.getElementById("users").innerHTML = output;
      });

    }

  };

  xhr.send();

});

