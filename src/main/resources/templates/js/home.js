function createCalendar(month, year) {
    const calendar = document.getElementById('calendar');
    const days = ['일', '월', '화', '수', '목', '금', '토'];
    const daysInMonth = new Date(year, month, 0).getDate();

    let content = `<table class="calendar-table">`;
    content += `<thead><tr>`;
    for (let day of days) {
        content += `<th>${day}</th>`;
    }
    content += `</tr></thead><tbody><tr>`;

    for (let i = 1; i <= daysInMonth; i++) {
        const dayOfWeek = new Date(year, month - 1, i).getDay();
        if (i === 1) {
            for (let j = 0; j < dayOfWeek; j++) {
                content += `<td></td>`;
            }
        }
        content += `<td><a href="#" onclick="fetchDataForDate(${i})">${i}</a></td>`;
        if (dayOfWeek === 6 && i !== daysInMonth) {
            content += `</tr><tr>`;
        }
    }
    content += `</tr></tbody></table>`;
    calendar.innerHTML = content;
}

// 현재 날짜를 기준으로 달력 생성
const currentDate = new Date();

// 현재 날짜의 월과 연도를 사용하여 달력 생성
createCalendar(currentDate.getMonth() + 1, currentDate.getFullYear());

async function fetchDataForDate(day) {
    try {
        const response = await fetch(`/api/data/${day}`);
        const data = await response.json();
        if (data.success) {
            // data 정보를 이용하여 원하는 곳에 표시
        } else {
            alert('데이터를 가져오는 데 실패했습니다.');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('아직 못했어 임마.');
    }
}