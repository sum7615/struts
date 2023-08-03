const form = document.querySelector('form');
const nameInput = document.getElementById('name');
const uNameInput = document.getElementById('user_name');
const emailInput = document.getElementById('email');
const passInput = document.getElementById('password');
const rePassInput = document.getElementById('re_pass');
const contactInput = document.getElementById('mobile_no');
const submitButton = document.getElementById('signup');
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
	if (nameInput === null || uNameInput === null || emailInput === null || passInput === null || rePassInput === null || contactInput === null) {
		showError(hiddenSpan, 'All fields are required');
		isValid = false;
	} else {
		const name = nameInput.value.trim();
		const uName = uNameInput.value.trim();
		const email = emailInput.value.trim();
		const pass = passInput.value;
		const rePass = rePassInput.value;
		const contact = contactInput.value.trim();
		if (name === '' || uName === '' || email === '' || pass === '' || rePass === '' || contact === '') {
			showError(hiddenSpan, 'All fields are required');
			isValid = false;
		} else {
			if (!/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(pass)) {
				showError(passInput, 'Password must be at least 8 characters.');
				isValid = false;
			}

			if (pass !== rePass) {
				showError(rePassInput, 'Passwords do not match');
				isValid = false;
			}

			if (!/^\d{10}$/.test(contact)) {
				showError(contactInput, 'Must be a 10-digit numeric value');
				isValid = false;
			}
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
