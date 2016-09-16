
var mymap = L.map('mapid').setView([51.505, -0.09], 13);

L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {minZoom:11}).addTo(mymap);

L.marker([51.5, -0.09]).addTo(mymap)
    .bindPopup("<b>Hello world!</b><br />I am a popup.").openPopup();

var mycircle = L.circle([51.508, -0.11], 500, {
    color: 'red',
    fillColor: '#f03',
    fillOpacity: 0.5
});
mycircle.bindPopup("I'm a circle.");
mymap.addLayer(mycircle);

L.polygon([
    [51.509, -0.08],
    [51.503, -0.06],
    [51.51, -0.047]
]).addTo(mymap).bindPopup("I am a polygon.");

var popup = L.popup();

function callAndroid(e) {
    Hue.showToast("Position: " + e.latlng.toString())
}

mymap.on('click', callAndroid);

