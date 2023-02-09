$(document).ready(function() {
  $("#getData").click(function() {
    $.ajax({
      type: "GET",
      url: "https://swapi-api.hbtn.io/api/films/?format=json",
      dataType: "json",
      success: function(data) {
        // handle success
	console.log(data);
        $('UL#list_movies').append(...data.results.map(movie => `<li>${movie.title}</li>`));
      },
      error: function(error) {
        // handle error
	console.log(error);
      }
    });
  });
});