
// how to get all items of localStorage
//function allStorage() {
//
//    var values = [],
//        keys = Object.keys(localStorage),
//        i = keys.length;
//
//    while ( i-- ) {
//        values.push( localStorage.getItem(keys[i]) );
//    }
//
//    return values;
//}
//
//var myItems = allStorage();


const httpTasks = new httpRequest();

function getUserTasks(){

	httpTasks.get("http://localhost:8080/happy/tasks/1", function(error, tasks){
		
		if(error){
	        console.log(error);
	    }
	    else{
	    	
	    	tasks = JSON.parse(tasks);
	    	
	    	tasks.forEach(function(task){
	    		
	    	    let ul = document.querySelector("ul.collection");
	
	    	    let li = document.createElement("li");
	    	    li.setAttribute("id", task.taskId);
	    	    li.setAttribute("class","collection-item");
	    	    li.textContent = task.taskName;
	
	    	    let link = document.createElement("a");
	    	    link.setAttribute("href","#");
	    	    link.setAttribute("class","delete-item secondary-content");
	    	    
	    	    li.appendChild(link);
	    	    
	    	    let img = document.createElement("i");
	    	    img.setAttribute("class","fa fa-remove");
	    	    link.appendChild(img);
	    	    
	    	    ul.appendChild(li);
	    	});
	    }
	});
	
}

getUserTasks();