async function registerUser() {
    const username = document.getElementById('reg-username').value;
    const password = document.getElementById('reg-password').value;
    const confirmPassword = document.getElementById('confirm-password').value;
    const gender = document.getElementById('gender').value;
    const koreanName = document.getElementById('korean-name').value;

    if (password !== confirmPassword) {
        alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
        return;
    }

    try {
        const response = await fetch('/api/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: username,
                password: password,
                gender: gender,
                koreanName: koreanName
            })
        });

        const data = await response.json();

        if (data.success) {
            alert('회원가입 성공!');
            window.location.href = '/login';
        } else {
            alert('회원가입 실패: ' + data.message);
        }
    } catch (error) {
        console.error('Error:', error);
        alert('회원가입 중 에러가 발생했습니다.');
    }
}
