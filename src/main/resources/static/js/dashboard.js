document.addEventListener('DOMContentLoaded', function () {
    // Attach change event to file input
    var photoInput = document.getElementById('photoInput');
    photoInput.addEventListener('change', function () {
        displaySelectedPhoto();
    });
});

function changeProfilePhoto() {
    // Trigger click event on the hidden file input
    var photoInput = document.getElementById('photoInput');
    photoInput.click();
}

function displaySelectedPhoto() {
    var photoInput = document.getElementById('photoInput');
    var profileImage = document.getElementById('profileImage');

    // Display the selected image
    if (photoInput.files && photoInput.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            profileImage.src = e.target.result;
        };
        reader.readAsDataURL(photoInput.files[0]);
    }
}
