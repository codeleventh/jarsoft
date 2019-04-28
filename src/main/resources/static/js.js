var api = "/api/";

function ub() {
  fetch(api + 'banner', {
    method: "GET"
  }).then(function (response) {
    alert(response.headers.get('Content-Type')); // application/json; charset=utf-8
    alert(response.status); // 200
    return response.json();
  }).then(function (banners) {
    document.getElementById("banners").innerHTML = '';
    banners.forEach(function (b) {
      document.getElementById("banners").innerHTML += '<span>' + b.name
          + '</span>';
    });
  }).catch(alert);
}