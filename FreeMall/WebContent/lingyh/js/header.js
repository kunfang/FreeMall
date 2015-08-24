/**
 * Created by ww on 15/8/9.
 */
window.onload = function(){
    var oTop = document.getElementById("to_top");
    var screenw = document.documentElement.clientWidth || document.body.clientWidth;
    var screenh = document.documentElement.clientHeight || document.body.clientHeight;
    oTop.style.left = screenw - oTop.offsetWidth +"px";
    oTop.style.top = screenh - oTop.offsetHeight + "px";
    window.onscroll = function(){
        var scrolltop = document.documentElement.scrollTop || document.body.scrollTop;
        oTop.style.top = screenh - oTop.offsetHeight + scrolltop +"px";
    }
    oTop.onclick = function(){
        document.documentElement.scrollTop = document.body.scrollTop =0;
    }
}

