		const liHome       = document.querySelector("#home"),
		      aHome        = liHome .firstChild,
		      divHomeInfo  = document.querySelector("#homeInfo"),
		      general      = document.querySelector("#general"),
		      january      = document.querySelector("#January"),
		      february     = document.querySelector("#February"),
		      march        = document.querySelector("#March"),  
		      april        = document.querySelector("#April"),  
		      may          = document.querySelector("#May"),
		      june         = document.querySelector("#June"),
		      july         = document.querySelector("#July"),
		      august       = document.querySelector("#August"),
		      september    = document.querySelector("#September"),
		      october      = document.querySelector("#October"),
		      november     = document.querySelector("#November"),
		      december     = document.querySelector("#December");
		
		      
		aHome.addEventListener("click", function(){
		
			changeTab(liHome, liTasks, liSettings, divHomeInfo, divTasksInfo, divSettingsInfo);
		    
		    document.getElementById("myActivitiesTabs").style.display = "block";
		});

const httpHome = new httpRequest();

httpHome.get("http://localhost:8080/happy/user/1", function(error, user){
	
	if(error){
		console.log(error);
	}
	else{
		
		user = JSON.parse(user);
		
		function init(...tabs){
		
		    tabs.forEach(function(tabActivated){
		        if(tabActivated != null){
		            tabActivated.addEventListener("click",function(){
		                
		                tab = getActiveTab();
		                
		                changeMonthsTab(tabActivated,tab);
		            
		            });
		        }
		    });
		}
		
		init(general, january, february, march, april, may, june, july, august, september, october, november, december);
		
		
		var tab;
		
		function getActiveTab(){
		    
		    var tabListItems = document.getElementById('myActivitiesTabs').childNodes;
		    
		    tabListItems.forEach(function(tabListItem){
		        
		        if(tabListItem.nodeName == "LI" && tabListItem.className == "active"){
		           
		           tab = tabListItem; 
		                  
		        }
		    });
		    
		    return tab;
		}
		
		
		function changeMonthsTab(activeElement, inactiveElement) {

			  if(activeElement != null){
			                
			        activeElement.setAttribute("class","active");

			        if(inactiveElement != undefined){
			          inactiveElement.removeAttribute("class");
			        }
			        
			        fillhomeTable(activeElement);
			  }  
			}

			function fillhomeTable(activeElement){
			const homeTable = document.getElementById("items");

			      httpHome.get(`http://localhost:8080/happy/currentProfile/${user.userId}`, (error, currentYearProfiles) => {

			        if(error){
			          console.log(error);
			        }
			        else{

			          currentYearProfiles = JSON.parse(currentYearProfiles);

			          var content = "";

			          for(let i = 0; i < currentYearProfiles.length; i++){
			            if(activeElement.id === "general"){

			              document.getElementById("addActivity").innerHTML = "#";
     
			              httpHome.get(`http://localhost:8080/happy/specificUserActivities/${user.userId}`, (error, activities) => {
			            	 
			            	  if(error){
			            		  console.log(error);
			            	  }
			            	  else{
			            		  
			            		  activities = JSON.parse(activities);
			            		  
			            		  for(let j = 0; j < activities.length; j++){
			            			  
			            			  let date = new Date(activities[j].added);
			            			  
			            			  content += `<tr>
					                                  <td>${j+1}</td>
					                                  <td>${activities[j].activityName}</td>
					                                  <td>${activities[j].happiness.description}</td>
					                                  <td>${activities[j].avgRating}%</td>
					                                  <td>${getBeautifulDate(date)}</td>
				                                  </tr>`;
			            			  
			            		  }
			            		  
			            		  homeTable.innerHTML = content;
			            
			            	  }
			              });
			              
			            }
			            else{

			              const addActivity = document.getElementById("addActivity");

			              // addActivity.id =
							// `addAct/Rel${currentYearProfiles[i].month}`

			              addActivity.innerHTML = `<a><i class="fa fa-plus-square" style="font-size:24px; color:black"></i></a>`;
			                           
			              if(currentYearProfiles[i].month === `${activeElement.id.toUpperCase()}`){
			                
			                addActivity.firstChild.setAttribute("id", `addAct/Rel/${currentYearProfiles[i].month}`);
			                // console.log(addActivity.firstChild);
			                addActivity.addEventListener("click", () => {
			                  console.log(`${currentYearProfiles[i].month}`);
			                });
			                
			                let date = new Date(currentYearProfiles[i].activity.added);			                
			                
			                content +=  `<tr>
			                              <td><a href="#" id="${currentYearProfiles[i].profileId}" ><i class="fa fa-remove" style = 'color: orange'></i></a></td>
			                              <td>${currentYearProfiles[i].activity.activityName}</td>
			                              <td>${currentYearProfiles[i].happiness.description}</td>
			                              <td>${currentYearProfiles[i].rating}%</td>
			                              <td>${getBeautifulDate(date)}</td>
			                           </tr>`;
			                
			              }
			            }
			          }
			    
			          homeTable.innerHTML = content;
			          console.log(document.getElementById("items"));
			        }
			      })


			}
			
			
		httpHome.get(`http://localhost:8080/happy/avgPreviousProfile/${user.userId}`, 
				function(error,avgRatingPreviousYear){
					if(error){
						console.log(error);
					}
					else{
						
						let today = new Date();
						
						avgRatingPreviousYear = Math.round(avgRatingPreviousYear * 100) / 100;
						
						document.getElementById("avgPrev").innerHTML = `<a href = "#" style = "color:grey" id = "analysisPreviousYear"><span class="pull-left"><strong id="prevYear">
																	    General ${today.getFullYear()-1}</strong></span> 
																	    ${avgRatingPreviousYear}% </a>`;
											
					}
					
					httpHome.get(`http://localhost:8080/happy/previousProfile/${user.userId}`, (error,previousYearProfiles) => {
						
						if(error){
							console.log(error);
						}
						else{
							previousYearProfiles = JSON.parse(previousYearProfiles);
							
							const modal = document.getElementById("tablePrevYearModal");
			                
				            document.getElementById("analysisPreviousYear").addEventListener("click", () =>{
				                
				              modal.style.display = "block";
				                
				            });
				              
				            document.getElementById("closePrevModal").addEventListener("click", () => {modal.style.display = "none"});
				                
				            window.addEventListener("click", (e) => {
				              if(e.target == modal){
				                modal.style.display = "none";
				              }
				            });

				            let content = ``;

				            let date;

				            for (let i = 0; i < previousYearProfiles.length; i++){
				              
				              date = new Date(previousYearProfiles[i].activity.added);

				              date = getBeautifulDate(date);
				              content +=      `<tr>
				                                      <td>${i + 1}</td>
				                                      <td>${previousYearProfiles[i].activity.activityName}</td>
				                                      <td>${previousYearProfiles[i].happiness.description}</td>
				                                      <td>${previousYearProfiles[i].rating}%</td>
				                                      <td>${date}</td>
				                              </tr>`;
				            }
				 
				            document.getElementById("prevProfiles").innerHTML = content;
						}
						
					});
					
		});
					
		
	}
});





    