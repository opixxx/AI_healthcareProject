document.addEventListener("DOMContentLoaded", function() {
    const data = JSON.parse(sessionStorage.getItem('routineData'));
    displayRoutine(data);
});

function displayRoutine(data) {
    const routineWrapper = document.querySelector('.routine-wrapper');

    if (data && Array.isArray(data)) {
        data.forEach(item => {
            const exerciseElem = document.createElement('div');
            exerciseElem.className = 'exercise';

            const exerciseName = document.createElement('h4');
            exerciseName.innerText = item.exerciseName;
            exerciseElem.appendChild(exerciseName);

            const setsAndReps = document.createElement('p');
            setsAndReps.innerText = `Sets: ${item.sets}, Reps: ${item.reps}`;
            exerciseElem.appendChild(setsAndReps);

            routineWrapper.appendChild(exerciseElem);
        });
    } else {
        routineWrapper.innerText = "운동 루틴 데이터가 없습니다.";
    }
}