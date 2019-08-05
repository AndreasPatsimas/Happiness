
const liNotes       = document.querySelector("#notes"),
      aNotes        = liNotes.firstChild,
      divNotesInfo  = document.querySelector("#notesInfo");

 aNotes.addEventListener("click", function(){
     
    changeTab(liNotes, liHome, liSettings, divNotesInfo, divHomeInfo, divSettingsInfo);

    document.getElementById("myActivitiesTabs").style.display = "none";
 });
    