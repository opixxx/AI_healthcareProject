document.addEventListener("DOMContentLoaded", function() {
    const data = JSON.parse(sessionStorage.getItem('routineData'));
    displayRoutine(data);
});

function displayRoutine(data) {
    const routineWrapper = document.querySelector('.routine-wrapper');
    let currentDay = 1;

    data.forEach(routine => {
        if (routine.day !== currentDay) {
            currentDay = routine.day;
        }

        let dayContainer = routineWrapper.querySelector(`.routine-section[data-day="${currentDay}"]`);
        if (!dayContainer) {
            dayContainer = document.createElement('div');
            dayContainer.className = 'routine-section';
            dayContainer.setAttribute('data-day', currentDay);

            const routineContainer = document.createElement('div');
            routineContainer.className = 'routine-container';
            dayContainer.appendChild(routineContainer);

            const routineTitle = document.createElement('h1');
            routineTitle.className = 'routine-title';
            routineTitle.textContent = `Day ${currentDay} `;
            routineContainer.appendChild(routineTitle);

            routineWrapper.appendChild(dayContainer);
        }

        const exerciseCard = document.createElement('div');
        exerciseCard.className = 'exercise-card';

        const exerciseName = document.createElement('h2');
        exerciseName.innerHTML = `${routine.exerciseName} 
            <input type="number" min="1" value="${routine.sets}" class="set-input">세트 
            <input type="number" min="1" value="${routine.reps}" class="rep-input">회`;
        exerciseCard.appendChild(exerciseName);

        dayContainer.querySelector('.routine-container').appendChild(exerciseCard);
    });
}