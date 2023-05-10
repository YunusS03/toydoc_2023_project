// Dit is een stuk JavaScript-code dat speelgoedafbeeldingen op willekeurige posities op het scherm plaatst.

// Het aantal speelgoedobjecten dat we willen maken.
var numToys = 7;

// Een array met de URL's van speelgoedafbeeldingen.
var toyImages = [
    'https://i.giphy.com/media/QC36ZL2YIS0xDrbZNH/giphy.webp',
    'https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExNzE1MGU5MTQzZjM3MmJmNTExNGM3NGY2OGNlMmJmZjQ0ZmRmYmIzNSZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PXM/S3KuIFRZyqZmMdMYvj/giphy.gif',
    'https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExMjUzNTliYjQyMjU0NGQzMDkzMTAwOGY2MTM2MDA0NzQ4ZjMyMWQ0MiZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PXM/7MQdKAUc596IZax95u/giphy.gif',
    'https://i.giphy.com/media/7hxZb96mhaIdAC4DIZ/200w.webp',
    'https://i.giphy.com/media/XCWazD36PSArlaGYrq/giphy.webp',
    'https://media2.giphy.com/media/Rkcl718Tx3Kbmd0Wva/200w.webp?cid=ecf05e474sdebqrl7fvxlpemn7dcq94740r3hb9l78yqri5l&ep=v1_stickers_search&rid=200w.webp&ct=s'
];

// De minimale en maximale afstand tussen de speelgoedobjecten.
var minDistance = 300;
var maxDistance = 500;

// Een lus om de speelgoedobjecten te maken en te plaatsen.
for (var i = 0; i < numToys; i++) {
// Maak een nieuw <span> element voor het speelgoed.
    var toy = document.createElement('span');
    toy.classList.add('toy'); // Voeg de CSS-klasse 'toy' toe aan het speelgoed.


// Kies een willekeurige afbeelding voor het speelgoed.
    var randomIndex = Math.floor(Math.random() * toyImages.length);
    toy.style.backgroundImage = 'url(' + toyImages[randomIndex] + ')';

// Kies willekeurige x- en y-coördinaten voor de positie van het speelgoed.
    var x = getRandomPosition(0, window.innerWidth);
    var y = getRandomPosition(0, window.innerHeight);

// Controleer of de huidige positie te dicht bij een ander speelgoedobject ligt.
// Als dat het geval is, kies dan opnieuw willekeurige coördinaten.
    var toys = document.querySelectorAll('.toy');
    for (var j = 0; j < toys.length; j++) {
        var otherToy = toys[j];
        var distance = getDistance(x, y, parseInt(otherToy.style.left), parseInt(otherToy.style.top));
        if (distance < minDistance) {
            x = getRandomPosition(0, window.innerWidth);
            y = getRandomPosition(0, window.innerHeight);
            j = -1; // Begin de lus opnieuw om de nieuwe positie opnieuw te controleren.
        }
    }

// Plaats het speelgoed op de gekozen positie.
    toy.style.left = x + 'px';
    toy.style.top = y + 'px';

// Voeg het speelgoed <span> element toe aan het <body> element van de pagina.
    document.body.appendChild(toy);

}


// Functie om een willekeurige positie te genereren binnen een opgegeven bereik.
function getRandomPosition(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Functie om de afstand tussen twee punten in een tweedimensionale ruimte te berekenen.
function getDistance(x1, y1, x2, y2) {
    var xDistance = x1 - x2;
    var yDistance = y1 - y2;
    return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
}