console.log("SCRIPT LOADED");

let currentTheme = getTheme();
// Initially change theme
applyTheme(currentTheme);

function applyTheme(theme) {
  const htmlElement = document.querySelector('html');
  htmlElement.classList.add(theme);

  const changeThemeButton = document.querySelector('#theme_change_button');
  const themeText = changeThemeButton.querySelector("span");
  const themeIcon = changeThemeButton.querySelector("i");

  // Set initial text and icon
  themeText.textContent = theme === "light" ? "Dark" : "Light";
  themeIcon.className = theme === "light" ? "fa-regular fa-moon" : "fa-solid fa-moon";

  changeThemeButton.addEventListener("click", () => {
    console.log("Change theme button clicked");

    const newTheme = theme === "dark" ? "light" : "dark";
    htmlElement.classList.replace(theme, newTheme);

    // Update the theme in local storage
    setTheme(newTheme);

    // Update the button text and icon
    themeText.textContent = newTheme === "light" ? "Dark" : "Light";
    themeIcon.className = newTheme === "light" ? "fa-regular fa-moon" : "fa-solid fa-moon";

    theme = newTheme;
  });
}

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  return localStorage.getItem("theme") || "light";
}
