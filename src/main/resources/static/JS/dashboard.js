

    const profile = document.getElementById("profile");
    const settings = document.querySelector("#settings");
    const reservations = document.querySelector("#reservations");

    function showProfile(){
    profile.classList.replace("d-none","d-block");
    settings.classList.replace("d-block","d-none");
    reservations.classList.replace("d-block","d-none");

}



    function showSettings(){
    profile.classList.replace("d-block","d-none");
    settings.classList.replace("d-none","d-block");
    reservations.classList.replace("d-block","d-none");

}

    function showReservations(){
    profile.classList.replace("d-block","d-none");
    settings.classList.replace("d-block","d-none");
    reservations.classList.replace("d-none","d-block");


}



    var loadFile = function (event) {
    var image = document.getElementById("output");
    image.src = URL.createObjectURL(event.target.files[0]);
};
