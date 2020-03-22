$( document ).ready(function(){
    loadCharacters = function() {
        $.getJSON( "/characters", function( resp ) {
            // Log each key in the response data
            displayCharacters(resp);
        });
    }

    addCharacterCard = function({picture, firstName, lastName, age}) {
        let card = `
        <div class="col">
            <div class="card">
            <img src="${picture}" class="card-img-top" alt="${firstName} ${lastName}">
              <div class="card-body">
                <h5 class="card-title">${firstName} ${lastName}</h5>
                <p class="card-text">${age} years old</p>
                <a href="#" class="btn btn-primary">View Quotes</a>
              </div>
          </div>
        </div>`

        $("#cardContainer").append(card);
    }


    displayCharacters = function(charactersJson) {
        $("#cardContainer").empty();

        $.each( charactersJson, function( key, value ) {
            addCharacterCard(value);
        });
    }

    loadCharacters();


});