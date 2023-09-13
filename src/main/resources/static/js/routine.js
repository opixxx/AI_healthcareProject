const exerciseCountMapping = {
    '3': 'THREE',
    '4': 'FOUR',
    '5': 'FIVE'
};

const levelMapping = {
    'beginner': 'BEGINNER',
    'intermediate': 'INTERMEDIATE'
};

document.getElementById('fetch-data').addEventListener('click', function() {
    const exerciseCountInput = document.getElementById('exercise-count');
    const levelSelect = document.getElementById('performance-level');

    // Get the selected values
    const exerciseCount = exerciseCountMapping[exerciseCountInput.value];
    const level = levelMapping[levelSelect.value];

    // Check if the values are valid
    if (!exerciseCount || !level) {
        console.error('Invalid input values');
        return;
    }

    // Send the mapped values to the server
    fetchDataFromServer(exerciseCount, level);
});

function fetchDataFromServer(exerciseCount, level) {
    const apiUrl = `/recommand?dayCount=${exerciseCount}&level=${level}`;

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            // Server response received, save to sessionStorage
            sessionStorage.setItem('routineData', JSON.stringify(data));
            window.location.href = '/routineList';  // redirect to routineList.html
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });

}

// function displayRoutine(routineData) {
//     const routineContainer = document.querySelector('.day-section');
//     routineContainer.innerHTML = '';  // Clear existing data
//
//     const exerciseCountInput = document.getElementById('exercise-count');
//     const maxDisplayDay = parseInt(exerciseCountInput.value);
//
//     for (let i = 1; i <= maxDisplayDay; i++) {
//         const dayRoutineContainer = document.createElement('div');
//         dayRoutineContainer.className = `day${i}-routine`;
//         dayRoutineContainer.innerHTML = `<h3>DAY${i}</h3>`;
//         routineContainer.appendChild(dayRoutineContainer);
//
//         // Filter routines for the current day
//         const routinesForDay = routineData.filter(routine => routine.day === i);
//
//         routinesForDay.forEach(routine => {
//             const exerciseCard = document.createElement('div');
//             exerciseCard.className = 'exercise-card';
//
//             const exerciseName = document.createElement('h4');
//             exerciseName.textContent = routine.exerciseName;
//             exerciseCard.appendChild(exerciseName);
//
//             const setsAndReps = document.createElement('p');
//             setsAndReps.textContent = `${routine.sets}세트 ${routine.reps}회`;
//             exerciseCard.appendChild(setsAndReps);
//
//             dayRoutineContainer.appendChild(exerciseCard);
//         });
//     }
// }