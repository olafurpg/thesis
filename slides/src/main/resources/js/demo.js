var sliderValue = document.getElementById("slider-value");
var code = document.getElementById("demo");
var slider = document.getElementById("demo-slider");
slider.addEventListener("change", function (sliderEvent) {
    //console.log(e.target.value);
    //console.log(code.innerText);
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(response) {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status == 200) {
                console.log(response);
                code.innerText = response.target.responseText;
                sliderValue.innerText = sliderEvent.target.value
                hljs.highlightBlock(code);
            } else {
                console.log(sliderEvent);
                console.log(httpRequest)
            }
        }
    };
    httpRequest.open("GET", "http://localhost:9000?" +
            "width=" + sliderEvent.target.value +
        "&code=" + btoa(code.innerText));
    httpRequest.send();
});

