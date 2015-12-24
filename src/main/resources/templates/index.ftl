<!doctype html>
<html lang='en-GB'>
<head>
    <meta charset='utf-8'>
    <title>Ractive test</title>
</head>

<body>
<h1>Ractive test</h1>

<!--
     1. This is the element we'll render our Ractive to.
-->
<div id='container'>
</div>

<!--
     2. You can load a template in many ways. For convenience, we'll include it in
     a script tag so that we don't need to mess around with AJAX or multiline strings.
     Note that we've set the type attribute to 'text/ractive' - though it can be
     just about anything except 'text/javascript'
-->
<script id='template' type='text/ractive'>
    <h2>Country profile</h2>

   <input type="text" name="name" value="{{country.climate.rainfall}}">

    <p>{{country.name}} is a {{country.climate.temperature}} country with {{country.climate.rainfall}} rainfall and a population of {{country.population}}.</p>

    <p>The capital city is {{country.capital.name}} (<a href='https://maps.google.co.uk/maps/place/{{country.capital.name}}/@{{country.capital.lat}},{{country.capital.lon}},12z' target='_blank'>see map</a>).</p>
</script>

<!--
     3. You can always get the most recent stable version from the URL below.
     If you want the newest features (unstable!), use the 'edge' version instead:

         http://cdn.ractivejs.org/edge/ractive.min.js

     If you need IE8 support, change 'ractive' to 'ractive-legacy'.
-->
<script src='http://cdn.ractivejs.org/latest/ractive.min.js'></script>

<!--
     4. We've got an element in the DOM, we've created a template, and we've
     loaded the library - now it's time to build our Hello World app.
-->
<script>
    var ractive = new Ractive({
        // The `el` option can be a node, an ID, or a CSS selector.
        el: '#container',

        // We could pass in a string, but for the sake of convenience
        // we're passing the ID of the <script> tag above.
        template: '#template',

        // Here, we're passing in some initial data
        data: {
            country: {
                name: 'The UK',
                climate: { temperature: 'cold', rainfall: 'excessive' },
                population: 63230000,
                capital: { name: 'London', lat: 51.5171, lon: -0.1062 }
            }
        }
    });

</script>
</body>
</html>