$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "/api/users",
    success: function (users) {
      $.each(users, function (index, user) {
        $("#user-table tbody").append(
          "<tr><td>" + user.id + "</td><td>" + user.name + "</td><td>" + user.email +
          "</td><td><button type='button' class='update-button' data-id='" + user.id + "'>Update</button></td>" +
          "<td><button type='button' class='delete-button' data-id='" + user.id + "'>Delete</button></td></tr>"
        );
      });
    }
  });

  // Create user
  $("#add-button").click(function () {
	  var name = $("#name-input").val();
	  var email = $("#email-input").val();
	  var user = { name: name, email: email };
	  
	  $.ajax({
	    type: "POST",
	    url: "/api/users",
	    contentType: "application/json",
	    data: JSON.stringify(user),
	    success: function (createdUser) {
	      $("#user-table tbody").append(
	        "<tr><td>" + createdUser.id + "</td><td>" + createdUser.name + "</td><td>" + createdUser.email +
	        "</td><td><button type='button' class='update-button' data-id='" + createdUser.id + "'>Update</button></td>" +
	        "<td><button type='button' class='delete-button' data-id='" + createdUser.id + "'>Delete</button></td></tr>"
	      );
	      $("#name-input").val("");
	      $("#email-input").val("");
	    }
	  });
	});
  
  // Update user
  // Fill the form with the updated user
  $("#user-table tbody").on("click", ".update-button", function () {
    var currentRow = $(this).closest("tr");
    var name = currentRow.find("td:eq(1)").text();
    var email = currentRow.find("td:eq(2)").text();
    var id = $(this).attr("data-id");

    $("#name-input").val(name);
    $("#email-input").val(email);
    $("#add-button").hide();
    $("#update-button").show();
    $("#cancel-button").show();
    $("#update-button").attr("data-id", id);
  });

  // Update the user with the updated file
  $("#update-button").click(function () {
    var name = $("#name-input").val();
    var email = $("#email-input").val();
    var id = $("#update-button").attr("data-id");

    $.ajax({
	  type: "PUT",
	  url: "/api/users/" + id,
	  data: JSON.stringify({id: id, name: name, email: email}),
	  contentType: "application/json",
	  success: function (user) {
	    // Find the table row corresponding to the user
	      var row = $("#user-table tbody tr[data-id='" + id + "']");
	      
	      // Update the data in the row
	      row.find("td:eq(1)").text(user.name);
	      row.find("td:eq(2)").text(user.email);
	
	      // Clear the input fields and hide the update/cancel buttons
	      $("#name-input").val("");
	      $("#email-input").val("");
	      $("#update-button").hide();
	      $("#cancel-button").hide();
	      $("#add-button").show();
	  }
	});
  });
  
  // Cancel Updating the user
  $("#cancel-button").click(function () {
    $("#name-input").val("");
    $("#email-input").val("");
    $("#update-button").hide();
    $("#cancel-button").hide();
    $("#add-button").show();
  });

  // Delete user
  $("#user-table tbody").on("click", ".delete-button", function () {
    var currentRow = $(this).closest("tr");
    var id = $(this).attr("data-id");

    $.ajax({
      type: "DELETE",
      url: "/api/users/" + id,
      success: function () {
        currentRow.remove();
      }
    });
  });
});