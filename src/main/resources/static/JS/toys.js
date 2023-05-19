var numToys = 5;


var toyImages = [
    'https://i.giphy.com/media/QC36ZL2YIS0xDrbZNH/giphy.webp',
    'https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExNzE1MGU5MTQzZjM3MmJmNTExNGM3NGY2OGNlMmJmZjQ0ZmRmYmIzNSZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PXM/S3KuIFRZyqZmMdMYvj/giphy.gif',
    'https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExMjUzNTliYjQyMjU0NGQzMDkzMTAwOGY2MTM2MDA0NzQ4ZjMyMWQ0MiZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PXM/7MQdKAUc596IZax95u/giphy.gif',
    'https://i.giphy.com/media/7hxZb96mhaIdAC4DIZ/200w.webp',
    'https://i.giphy.com/media/XCWazD36PSArlaGYrq/giphy.webp',
    'https://media2.giphy.com/media/Rkcl718Tx3Kbmd0Wva/200w.webp?cid=ecf05e474sdebqrl7fvxlpemn7dcq94740r3hb9l78yqri5l&ep=v1_stickers_search&rid=200w.webp&ct=s'
];
var minDistance = 300;
var maxDistance = 500;
var fragment = document.createDocumentFragment(); // Create a document fragment

for (var i = 0; i < numToys; i++) {
    var toy = document.createElement('span');
    toy.classList.add('toy');
    var randomIndex = Math.floor(Math.random() * toyImages.length);
    toy.style.backgroundImage = 'url(' + toyImages[randomIndex] + ')';
    var x = getRandomPosition(0, window.innerWidth);
    var y = getRandomPosition(0, window.innerHeight);
    var toys = fragment.querySelectorAll('.toy'); // Query the fragment instead of the document
    for (var j = 0; j < toys.length; j++) {
        var otherToy = toys[j];
        var distance = getDistance(x, y, parseInt(otherToy.style.left), parseInt(otherToy.style.top));
        if (distance < minDistance) {
            x = getRandomPosition(0, window.innerWidth);
            y = getRandomPosition(0, window.innerHeight);
            j = -1;
        }
    }
    toy.style.left = x + 'px';
    toy.style.top = y + 'px';
    fragment.appendChild(toy); // Append toy to the fragment
}

document.body.appendChild(fragment); // Append the fragment to the body once

function getRandomPosition(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function getDistance(x1, y1, x2, y2) {
    var xDistance = x1 - x2;
    var yDistance = y1 - y2;
    return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
}