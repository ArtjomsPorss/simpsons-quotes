$( document ).ready(function(){
    var currentCharacter;

    loadCharacters = function() {
        $.getJSON( "/characters", function( resp ) {
            // Log each key in the response data
            displayCharacters(resp);
        });
    }

    addNewQuoteRow = function(character) {
        let newQuoteRow =
            `<div class="row" character="${character._id}" id="newQuote">
                <div class="col-lg-10 col-md-10 col-sm-6 font-italic">
                    <textarea class="col-lg-10" col-md-10 col-sm-8></textarea>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-4">
                    <button class="btn btn-success" onclick="saveQuote()">Save</button>
                </div>
            <div>`;
        return newQuoteRow;
    }

    viewCharacterQuotes = function(character, quotes) {
        $('#quotesModalCenterTitle').text(`${character.firstName} ${character.lastName} Quotes`)
        // add quotes to modal
        $('#modalQuoteContainer').empty();
        // TODO if nothing in response, display empty modal. On the modal show text that no messages found
        quotes.forEach(function(quote, key, map) {
            let quoteRow =
                `<div class="row" id="${quote._id}" character="${quote.character}">
                    <div class="col-lg-10 col-md-8 col-sm-6 font-italic" name="quote">
                        ${quote.quote}
                    </div>
                    <div class="col-lg-2 col-md-4 col-sm-6">
                        <div class="btn-group" role="group">
                            <button class="btn btn-outline-warning btn-sm">Edit</button>
                            <button class="btn btn-outline-danger btn-sm">Delete</button>
                        </div>
                    </div>
                </div>
                <hr/>`;
            $("#modalQuoteContainer").append(quoteRow);
        });
        let newQuoteRow = addNewQuoteRow(character);
        $("#modalQuoteContainer").append(newQuoteRow);

        $('#quotesModal').modal('show');
    }

    getQuotes = function(character) {
        currentCharacter = character;
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

    saveQuote = function() {
        let newQuote = $('#newQuote textarea').val();
        let characterId = $('#newQuote').attr("character");

        data = {};
        data._id = null;
        data.quote = newQuote;
        data.character = characterId;

        $.ajax({
            type: 'POST',
            url: '/saveQuote',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(data)
        }).done(function(result){
            getQuotes(currentCharacter);
        });

        // $.post('/saveQuote', data).done(function(result){
        //     getQuotes(currentCharacter);
        // });
    }
});
