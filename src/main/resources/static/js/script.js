document.addEventListener('DOMContentLoaded', function () {
    const slider = document.querySelector('.slider');
    const slides = document.querySelectorAll('.slide');
    const slideWidth = slides[0].clientWidth;
    let currentIndex = 0;

    function nextSlide() {
        currentIndex = (currentIndex + 1) % slides.length;
        updateSlider();
    }

    function prevSlide() {
        currentIndex = (currentIndex - 1 + slides.length) % slides.length;
        updateSlider();
    }

    function updateSlider() {
        const translateValue = -currentIndex * slideWidth;
        slider.style.transform = `translateX(${translateValue}px)`;
    }

    setInterval(nextSlide, 5000); // Change slide every 3 seconds
});


 document.addEventListener('DOMContentLoaded', function () {
    const menuIcon = document.getElementById('menu-icon');
    let menuOpen = true;

    function toggleMenu() {
        if (menuOpen) {
            menuIcon.src = "/img/button_menu_close.png"; // 이미지를 닫힌 상태로 변경
        } else {
            menuIcon.src = "/img/button_menu.png"; // 이미지를 열린 상태로 변경
        }
        menuOpen = !menuOpen;
    }

    document.getElementById('hamburger-button').addEventListener('click', toggleMenu);
});

document.addEventListener('DOMContentLoaded', function () {
    const menuIcon = document.getElementById('menu-icon');
    const sidebar = document.getElementById('sidebar');

    menuIcon.addEventListener('click', function () {
        sidebar.classList.toggle('show');
    });
});







// contact 페이지 이메일 입력
document.addEventListener('DOMContentLoaded', function() {
	var domainDropdown = document.getElementById('domainDropdown');
	var domainInput = document.getElementById('domain');
	var directInputOption = document.getElementById('directInputOption');

	domainDropdown.addEventListener('change', function() {
		var selectedOption = domainDropdown.options[domainDropdown.selectedIndex];

		if (selectedOption.value === 'directInput') {
			domainInput.setAttribute('required', 'required');
			domainInput.removeAttribute('readonly'); // domainInput도 수정 가능하도록 변경
			domainInput.value = "";
		} else {
			domainInput.setAttribute('required', 'required');
			domainInput.setAttribute('readonly', 'readonly'); // 선택된 경우에도 domainInput은 readonly로 설정
			domainInput.value = selectedOption.value;
		}
	});
});
