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
