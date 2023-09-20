document.getElementById('fetch-data').addEventListener('click', function() {

    // 선택된 값들을 가져옵니다.
    const exercisePartSelect = document.getElementById('exercise-part');
    const levelSelect = document.getElementById('performance-level');

    console.log("fetch-data 버튼이 클릭되었습니다.");
    console.log(document.getElementById('exercise-part'));  // 요소 자체를 출력하여 null인지 확인
    console.log(document.getElementById('performance-level'));  // 요소 자체를 출력하여 null인지 확인

    const exercisePartInput = exercisePartSelect.value;
    const levelInput = levelSelect.value;

    console.log(exercisePartInput.value);  // 선택된 값 출력
    console.log(levelInput.value);

    // 값들이 유효한지 확인합니다.
    if (!exercisePartInput || !levelInput) {
        console.error('Invalid input values');
        return;
    }

    // 매핑된 값들을 서버로 전송합니다.
    fetchDataFromServer(exercisePartInput, levelInput);
});

function fetchDataFromServer(exercisePart, level) {
    const apiUrl = `/recommands?part=${exercisePart}&level=${level}`;

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // 서버 응답을 받았다면, sessionStorage에 저장합니다.
            sessionStorage.setItem('routineData', JSON.stringify(data));
            window.location.href = '/routineList';  // routineList.html로 리다이렉트 합니다.
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}
