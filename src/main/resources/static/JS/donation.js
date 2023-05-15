
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
    .forEach(function (form) {
    form.addEventListener('submit', function (event) {
    if (!form.checkValidity()) {
    event.preventDefault()
    event.stopPropagation()
}

    form.classList.add('was-validated')
}, false)
})
})()

    function requiredFunction(){
    let x = document.getElementById("other-amount").value;
    let z = document.getElementById("100").value;
    let y = document.getElementById("100");
    if((x == "")){
    y.setAttribute('required','');
    document.getElementById("amount-feedback").innerHTML = 'Please choose a amount or enter your own amount';
}else{
    y.removeAttribute('required','');
}
}
