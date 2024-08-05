console.log("SCRIPT LOADED");

let currentTheme = getTheme();
//INTIAILY CHANGE THEME
changeTheme(currentTheme)

// todo
function changeTheme() {
   //set to web page
   document.querySelector('html').classList.add(currentTheme);
   //set the listener to change theme button

   const changeThemeButton = document.querySelector('#theme_change_button')
     changeThemeButton.addEventListener("click",(event)=>{
        const oldTheme = currentTheme;
        console.log("change theme buttom clicked");
   
        if(currentTheme === "dark"){
            //theme ko light krna
          currentTheme="light";
        }else{
            //theme ko dark 
            currentTheme="dark";
        }

        //local storage update kro
        setTheme(currentTheme);
             //remove the current theme
             document.querySelector('html').classList.remove(oldTheme);
        //set the currnet theme
        document.querySelector('html').classList.add(currentTheme);

     });

}

//SET THEME TO LOCAL STORAGE

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}
//GET THEME FROM LOCAL STORAGE

function getTheme() {
  let theme = localStorage.getItem("theme");
  if (theme) return theme;
  else return "light";
}
