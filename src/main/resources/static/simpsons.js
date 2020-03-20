$( document ).ready(function(){
    loadCharacters = function() {
        $.getJSON( "/characters", function( resp ) {
            // Log each key in the response data
            displayCharacters(resp);
        });
    }

    addCharacterCard = function(characterData) {
        let card = `<div class="card">
            <img src="` + characterData.picture + `" class="card-img-top" alt="` + characterData.firstName + " " + characterData.lastName + `">
              <div class="card-body">
                <h5 class="card-title">` + characterData.firstName + " " + characterData.lastName + `</h5>
                <p class="card-text">` + characterData.age + " years old" + `</p>
                <a href="#" class="btn btn-primary">View Quotes</a>
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