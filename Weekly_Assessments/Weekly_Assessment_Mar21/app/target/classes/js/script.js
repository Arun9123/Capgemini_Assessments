// --- SIGNUP LOGIC ---
async function handleSignup() {
    clearErrors();
    
    const data = {
        username: document.getElementById('username').value,
        fullName: document.getElementById('fullName').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
        confirmPassword: document.getElementById('confirmPassword').value
    };

    // 1. Mandatory Field Check (Client-side)
    let hasEmpty = false;
    for (let key in data) {
        if (!data[key]) {
            document.getElementById(`${key}Error`).innerText = "Field is mandatory";
            hasEmpty = true;
        }
    }
    if (hasEmpty) return;

    // 5. Password Match Check
    if (data.password !== data.confirmPassword) {
        document.getElementById('confirmError').innerText = "Passwords don't match.";
        return;
    }

    try {
        const response = await fetch('/api/users/register', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });

        if (response.status === 409) { // Conflict: Email
            alert(await response.text());
            window.location.href = "login.html";
        } else if (response.status === 400) { // Bad Request: Username
            document.getElementById('usernameError').innerText = await response.text();
        } else if (response.status === 406) { // Not Acceptable: Password Rules
            document.getElementById('passwordError').innerText = await response.text();
        } else if (response.ok) {
            window.location.href = "dashboard.html";
        }
    } catch (err) {
        console.error("Connection failed", err);
    }
}

// --- LOGIN LOGIC ---
async function handleLogin() {
    clearErrors();
    const loginType = document.querySelector('input[name="loginType"]:checked').value;
    const identifier = document.getElementById('identifier').value;
    const password = document.getElementById('loginPassword').value;

    if (!identifier) {
        document.getElementById('identifierError').innerText = "Field is mandatory";
        return;
    }
    if (!password) {
        document.getElementById('passwordError').innerText = "Field is mandatory";
        return;
    }

    try {
        const response = await fetch(`/api/users/login?identifier=${identifier}&password=${password}&type=${loginType}`);

        if (response.status === 401) {
            const errorMsg = await response.text();
            if (errorMsg.toLowerCase().includes("user")) {
                document.getElementById('identifierError').innerText = errorMsg;
            } else {
                document.getElementById('passwordError').innerText = errorMsg;
            }
        } else if (response.ok) {
            window.location.href = "dashboard.html";
        }
    } catch (err) {
        console.error("Login failed", err);
    }
}

function clearErrors() {
    document.querySelectorAll('.error-msg').forEach(el => el.innerText = "");
}