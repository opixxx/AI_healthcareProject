
async function loginUser() {
    // 입력된 아이디와 비밀번호 값을 가져옵니다.
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    try {
        // 서버로 POST 요청을 보냅니다.
        const response = await fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: username,
                password: password
            })
        });

        const data = await response.json();

        if (data.success) {
            alert('로그인 성공!');
            // 로그인 성공 시, 원하는 페이지로 리다이렉트할 수 있습니다.
            // 예: window.location.href = '/dashboard';
        } else {
            alert('로그인 실패: ' + data.message);
        }
    } catch (error) {
        console.error('Error:', error);
        alert('로그인 중 에러가 발생했습니다.');
    }
}