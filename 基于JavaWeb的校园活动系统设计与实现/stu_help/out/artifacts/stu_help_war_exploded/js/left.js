$(document).ready(function(){
    
    $(".task").find("li").eq(0).click(function(){
     if($(this).siblings().css("display").length==4){
         $(".task").find("li").eq(0).show().siblings().show().css("background","rgb(40,43,53)"); 
     }else{
         $(".task").find("li").eq(0).show().siblings().hide();
     }
    })

    $(".me").find("li").eq(0).click(function(){
     if($(this).siblings().css("display").length==4){
         $(".me").find("li").eq(0).show().siblings().show().css("background","rgb(40,43,53)"); 
     }else{
         $(".me").find("li").eq(0).show().siblings().hide();
     }
    })

    $(".sell").find("li").eq(0).click(function(){
        if($(this).siblings().css("display").length==4){
            $(".sell").find("li").eq(0).show().siblings().show().css("background","rgb(40,43,53)"); 
        }else{
            $(".sell").find("li").eq(0).show().siblings().hide();
        }
       })

 })