$("#document").ready(function(){
    $(".CheckChange").on("change", function(){
        if ($(this).val() == $(this).parent().find('input:hidden:first').val())
            $(this).next("img").show();
        else
            $(this).next("img").hide();
    });
});