const performanceSelect = document.getElementById('performance-level');
const performanceDesc = document.getElementById('performance-description');

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