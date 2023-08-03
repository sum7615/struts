const form = document.querySelector('form');
const uNameInput = document.getElementById('user_name');
const passInput = document.getElementById('password');
const submitButton = document.getElementById('signin');
const hiddenSpan = document.getElementById('hidden');
form.addEventListener('submit', function(event) {
	event.preventDefault();
	if (validateForm()) {
		form.submit();
	}
});

function validateForm() {
	clearErrors();
	let isValid = true;
	if (uNameInput === null || passInput === null) {
		showError(hiddenSpan,"All field required");
		isValid=false;
	} else {
		const uName = uNameInput.value.trim();
		const pass = passInput.value;
		if (uName === '' || pass === '') {
			showError(hiddenSpan,'All fields are required');
			isValid = false;
		}
	}

	return isValid;
}

function showError(inputElement, message) {
	const errorSpan = document.createElement('span');
	errorSpan.className = 'alert-danger';
	errorSpan.textContent = message;
	inputElement.parentElement.appendChild(errorSpan);
}

function clearErrors() {
	const errorDivs = form.querySelectorAll('.alert-danger');
	errorDivs.forEach((errorDiv) => {
		errorDiv.remove();
	});
}
