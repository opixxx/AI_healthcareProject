function createCalendar(year, month) {
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    const firstDayOfWeek = new Date(year, month, 1).getDay();

    const calendarContainer = document.getElementById('calendar');
    calendarContainer.innerHTML = '';

    const table = document.createElement('table');
    table.classList.add('calendar-table');

    const headerRow = document.createElement('tr');
    const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
    daysOfWeek.forEach(day => {
        const th = document.createElement('th');
        th.textContent = day;
        headerRow.appendChild(th);
    });

    table.appendChild(headerRow);

    let date = 1;
    for (let i = 0; i < 6; i++) {
        const row = document.createElement('tr');
        for (let j = 0; j < 7; j++) {
            if (i === 0 && j < firstDayOfWeek) {
                const td = document.createElement('td');
                row.appendChild(td);
            } else if (date > daysInMonth) {
                break;
            } else {
                const td = document.createElement('td');
                td.textContent = date;
                row.appendChild(td);
                date++;
            }
        }
        table.appendChild(row);
    }

    calendarContainer.appendChild(table);
}

// 현재 년도와 월을 가져와서 달력을 생성합니다.
const now = new Date();
const currentYear = now.getFullYear();
const currentMonth = now.getMonth();

createCalendar(currentYear, currentMonth);
