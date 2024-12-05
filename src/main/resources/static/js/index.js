// Função para ativar o tema escuro
function enableDarkTheme() {
    document.documentElement.classList.add("dark-theme-variables");
    localStorage.setItem("theme", "dark"); // Salva a preferência no localStorage
    updateThemeIcons("dark"); // Atualiza os ícones
}

// Função para desativar o tema escuro
function disableDarkTheme() {
    document.documentElement.classList.remove("dark-theme-variables");
    localStorage.setItem("theme", "light"); // Salva a preferência no localStorage
    updateThemeIcons("light"); // Atualiza os ícones
}

// Função para verificar e aplicar o tema armazenado
function checkStoredTheme() {
    const storedTheme = localStorage.getItem("theme"); // Obtém o tema armazenado
    if (storedTheme === "dark") {
        enableDarkTheme(); // Ativa o tema escuro
    } else {
        disableDarkTheme(); // Ativa o tema claro
    }
}

// Função para atualizar os ícones do tema
function updateThemeIcons(theme) {
    const lightIcon = document.querySelector(".theme-toggler span:first-child");
    const darkIcon = document.querySelector(".theme-toggler span:last-child");

    if (theme === "dark") {
        lightIcon.classList.remove("active");
        darkIcon.classList.add("active");
    } else {
        lightIcon.classList.add("active");
        darkIcon.classList.remove("active");
    }
}

// Chama a função de verificação de tema ao carregar a página
checkStoredTheme();

// Alterna o tema ao clicar na div
const themeToggler = document.querySelector(".theme-toggler");
themeToggler.addEventListener("click", () => {
    const currentTheme = localStorage.getItem("theme");
    if (currentTheme === "dark") {
        disableDarkTheme(); // Desativa o tema escuro
    } else {
        enableDarkTheme(); // Ativa o tema escuro
    }
});

const container = document.querySelector('.container');
const LoginLink = document.querySelector('.SignInLink'); // Adicionada o "." antes do seletor
const RegisterLink = document.querySelector('.SignUpLink'); // Adicionada o "." antes do seletor

RegisterLink.addEventListener('click', () => {
    container.classList.add('active');
});

LoginLink.addEventListener('click', () => {
    container.classList.remove('active');
});

// JS para o submenu
function toggleSubMenu() {
    const subMenu = document.getElementById("subMenu");
    subMenu.classList.toggle("show");
}

// Fecha o submenu ao clicar fora
window.addEventListener("click", function (e) {
    const subMenu = document.getElementById("subMenu");
    if (!e.target.closest(".profile") && !e.target.closest(".sub-menu-wrap")) {
        subMenu.classList.remove("show");
    }
});

// Código para alternar a visibilidade do submenu
document.querySelector('.profile').addEventListener('click', function() {
    const submenu = document.querySelector('.sub-menu-wrap');
    submenu.style.visibility = submenu.style.visibility === 'visible' ? 'hidden' : 'visible';
    submenu.style.opacity = submenu.style.opacity === '1' ? '0' : '1';
});