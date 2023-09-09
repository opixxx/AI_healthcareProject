const performanceSelect = document.getElementById('performance-level');
const performanceDesc = document.getElementById('performance-description');
const daySection = document.querySelector('.day-section');

performanceSelect.addEventListener('change', function() {
    switch(performanceSelect.value) {
        case 'beginner':
            performanceDesc.textContent = "헬린이: 운동 초보자를 위한 레벨";
            break;
        case 'intermediate':
            performanceDesc.textContent = "헬스장 민페남: 중간 레벨의 운동자";
            break;
        case 'expert':
            performanceDesc.textContent = "헬스의 정석: 전문가 레벨";
            break;
        default:
            performanceDesc.textContent = "";
    }
});

// 처음 페이지 로드 시 기본 설명 설정
performanceDesc.textContent = "헬린이: 운동 초보자를 위한 레벨";

// 초기 화면에서는 DAY를 표시하지 않기 위해 daySection의 내용을 비웁니다.
daySection.innerHTML = '';

document.getElementById('fetch-data').addEventListener('click', function() {
    const exerciseCount = document.getElementById('exercise-count').value;
    
    // 기존에 생성된 DAY 칸을 모두 제거합니다.
    daySection.innerHTML = '';

    // 최대 5일까지만 생성합니다.
    const count = Math.min(exerciseCount, 5);

    for (let i = 1; i <= count; i++) {
        const dayBox = document.createElement('a');
        dayBox.href = `day${i}.html`;
        dayBox.innerHTML = `<div class="day-box">DAY${i}</div>`;
        daySection.appendChild(dayBox);
    }
});
