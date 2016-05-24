$(".filter").click(function() {
  var thisFilter = $(this).attr("id");
  $(".item").addClass("hide");
  if (thisFilter === "reset") {
    $(".item").removeClass("hide");
  } else {
    $("." + thisFilter).removeClass("hide");
  }
  $(".filter").removeClass("selected");
  $(this).addClass("selected");
  return false;
});