$( document ).ready(function(){
    loadCharacters = function() {
        $.getJSON( "/characters", function( resp ) {
            // Log each key in the response data
            displayCharacters(resp);
        });
    }

    viewCharacterQuotes = function(character, quotes) {
        $('#quotesModalCenterTitle').text(`${character.firstName} ${character.lastName} Quotes`)
        // add quotes to modal
        $('#quotesModalBody').empty();
        // TODO if nothing in response, display empty modal. On the modal show text that no messages found
        quotes.forEach(function(quote, key, map) {
            $("<p/>", {
                id: `${quote._id}`,
                character: `${quote.character}`,
                text: `${quote.quote}`
            }).appendTo("#quotesModalBody");
        });
        $('#quotesModal').modal('show');
    }

    getQuotes = function(character) {
        $.getJSON(`/quotes/${character._id}`, function(resp) {
                viewCharacterQuotes(character, resp);
        }).fail(function(message) {
                // TODO show a warning
                console.log( `failed ${message}` );
        })
    }

    addCharacterCard = function(character) {
        let card =
        `<div class="col" id="${character._id}">
            <div class="card">
            <img src="${character.picture}" class="card-img-top" alt="${character.firstName} ${character.lastName}">
              <div class="card-body">
                <h5 class="card-title">${character.firstName} ${character.lastName}</h5>
                <p class="card-text">${character.age} years old</p>
                <a class="btn btn-primary">View Quotes</a>
              </div>
          </div>
        </div>`

        $("#cardContainer").append(card);
        $(`#${character._id} .btn-primary`).click(() => getQuotes(character));
    }


    displayCharacters = function(charactersJson) {
        $("#cardContainer").empty();

        $.each( charactersJson, function( key, value ) {
            addCharacterCard(value);
        });
    }

    loadCharacters();


});