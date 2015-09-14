<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page buffer="10kb"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="cn" xmlns="http://www.w3.org/1999/xhtml">
 <%  
 	String context =request.getContextPath(); 
 	String loginErrInfo = (String)request.getSession().getAttribute("loginErrInfo");
 	if (loginErrInfo == null || loginErrInfo.length() == 0)
 		loginErrInfo = "";
 %>  
<HEAD>
<TITLE>零元汇合伙人管理系统</TITLE>
<meta charset="utf-8" />
<meta http-equiv=Content-Type content="text/html; charset=utf-8"/>
<meta content="MSHTML 6.00.2800.1400" name=GENERATOR/>
    <link rel="stylesheet" href="<%=context %>/login/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=context %>/login/css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="<%=context %>/login/css/style.css" />
    <link rel="stylesheet" href="<%=context %>/login/css/theme.css" />

    <link rel="stylesheet" type="text/css" href="<%=context %>/js/lightbox/themes/default/jquery.lightbox.css" />
    <!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="js/lightbox/themes/default/jquery.lightbox.ie6.css" />
<![endif]-->
    <script type="text/javascript" src="<%=context %>/login/js/bootstrap-carousel.js"></script>
    <script type="text/javascript" src="<%=context %>/login/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=context %>/login/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="<%=context %>/login/js/lightbox/jquery.lightbox.min.js"></script>

    <style>
        .black_overlay{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;  -moz-opacity: 0.8;
            opacity:.80;  filter: alpha(opacity=80);
        }
    </style>
</HEAD>
<body>
    <!--top_menu-->
    <div class="row-fluid top_menu">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <span class="like2"><a>立即注册</a></span>
                    <span class="like2"><a href="javascript:void(0)" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">账号登录</a></span>
                </div>

<<<<<<< HEAD
=======
        <div class="loginBox">
            <div class="loginBoxCenter">
                <p><label for="username">系统登陆：</label></p>
                <p><input type="text" id="username" name="username" class="loginInput" autofocus="autofocus" required="required" autocomplete="off" placeholder="请输入用户名" value="" /></p>
                <p><input type="password" id="password" name="password" class="loginInput" required="required" placeholder="请输入密码" value="" /></p>
                <div style="text-align:center;"><font color=red><%=loginErrInfo %></font></div>
            </div>
            
            <div class="loginBoxButtons">
                <a href="<%=context%>/userLoginlist.do?method=registerUser">用户注册</a>
                <button type="submit" class="loginBtn" data-toggle="button">登录</button>
>>>>>>> branch 'master' of https://github.com/kunfang/FreeMall.git
            </div>
        </div>
    </div>
    <!-- 登录框开始 -->
    <div class="row-fluid" style="z-index: 1002;overflow: auto;display: none;position: absolute;top: 20%" id="light">
        <div class="dialog">
            <div class="block">
                <p class="block-heading">系统登录</p>
                <div class="block-body">
                    <form method="post" action="userLoginlist.do" name="forms" onsubmit="return login()">
                    	<input type="hidden" name="method" value="getAssessSysMenubyList"/>
                        <label>用户名</label>
                        <input type="text" id="username" name="username" class="span12" autofocus="autofocus" required="required" autocomplete="off" placeholder="请输入用户名" value="" />
                        <label>密码</label>
                        <input type="password" id="password" name="password" class="span12" required="required" placeholder="请输入密码" value="" />
                        <!-- <a href="ranking.html" class="btn btn-primary pull-right">登录</a> -->
                        <button type="submit" class="loginBtn" data-toggle="button">登录</button>
                        <label class="remember-me"><input type="checkbox">记住密码</label>
                        <div class="clearfix"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="fade" class="black_overlay">
    </div>
    <!-- 登录框结束 -->
<!--slider_images-->
    <div class="row-fluid images_head" id="home">
        <div class="container">
            <div class="span12 images_slide">
                <div id="myCarousel" class="carousel slide">
 
              <!-- Carousel items -->
                    <div class="carousel-inner">
                        <div class="active item">
                            <img src="img/lingyh.png" alt=""/>
                        </div>
                        <div class="item">
                            <img src="img/img2.png" alt=""/>
                        </div>
                        <div class="item">
                            <img src="img/img3.png" alt=""/>
                        </div>
                    </div>
  <!-- Carousel nav -->
   <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
</div>

            </div>
        </div>
    </div>
    <!--contant_one_page-->
    <div class="flag" id="about"></div>
    <div class="fulli_page_about">
        <div class="row-fluid bg_about">

            <div class="container about_block">
                <div class="span12 tittle_page">
                    <h1 class="tittle">关于我们</h1>
                </div>
                <div class="row">
                    <div class="span12 love_badge">
                        <img src="img/love.png" alt=""/>
                    </div>

                    <div class="span12">
                        <div class="photo_about">
                            <img width="150px" height="150px" src="img/lyhlogo.png" alt="" />
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;零元汇是一个全民快乐的平台。零元汇颠覆所有的互联网商业模式，只送不卖，而且天天送，永远送。零元汇上的所有企业天天送礼给立免网会员，
                        汽车家电、食品酒水、服装化妆品……统统白给白送。开零元汇，全民快乐免费时代！<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;对于零元汇来说，舍得是一种爱心，舍得是一种付出，舍得是一种责任，舍得是一种感悟，舍得是一种智慧，舍得是一种高度，舍得更是一种境界。
                        零元汇倡导舍得文化，以用户快乐为使命，把高价值的品牌商品给用户，让用户得到巨大的惊喜与无限的欢乐。<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;零元汇以用户快乐为本的同时，还倡导温馨的家庭式工作氛围。不论级别高低，人人平等，言论自由，员工间的关系如同亲密的朋友和家人。
                        零元汇的全体员工努力把工作、生活中的每一份快乐通过零元汇传递给用户，因为用户快乐幸福是立免同仁奋斗的至高目标
                 <blockquote>
                     <p>零元汇的所有企业天天送礼给立免网会员，从早8:00-晚24:00，全天16小时不间断， 让天上掉馅饼成为现实。
                         <br>零元汇由企业每天定量出，先到先得。会员每天参与活动，赚取零元汇金币在积分商城兑换心仪的商品。</p>
                 </blockquote>
                        关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!关注零元汇，开启免费之旅!


                    </div>
                </div>
                <div class="bg_bottom"></div>
            </div>
        </div>
    </div>


    <!--contant_two_page-->
    <div class="flag" id="photos"></div>
    <div class="fulli_page">
        <div class="container page_bg">
            <div class="row">
                <div class="span12 tittle_page">
                    <h1 class="tittle">热门商品</h1>
                </div>
                <div class="span12 love_badge">
                    <img src="img/love.png"  alt=""/>
                </div>
                <div class="span12">
                    <div class="row">
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>
                        <!--Photo-->
                        <div class="span3 gallery">
                            <div class="gallery_contant">
                                <a href="img/image10.png" class="lightbox">
                                    <img src="img/item/item1.png" alt="" /></a>

                                <a href="#">
                                    <h4>百年蔷薇刀具五件套</h4>
                                </a>
                                百年时尚蔷薇刀具五件套菜刀，韩国厨房套刀不锈钢厨房刀具套装，
                                韩国时尚工艺，持久锋利，配套专用刀架。蔷薇绽放，惊艳厨房


                                <div class="like_gallery"><span class="like"><a href="#">11</a></span></div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
            <div class="bg_bottom"></div>
        </div>
    </div>




    <!--contant_two_page-->
    <div class="flag" id="Our_news"></div>
    <div class="fulli_page">
        <div class="container page_bg">
            <div class="row">
                <div class="span12 tittle_page">
                    <h1 class="tittle">公告</h1>
                </div>
                <div class="span12 love_badge">
                    <img src="img/love.png" alt=""/>
                </div>
                <div class="span12">
                    <div class="row">
                        <!--left news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                            加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                        <!--right news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                                加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                        <!--left news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                                加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                        <!--right news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                                加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                        <!--left news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                                加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                        <!--right news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                                加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                        <!--left news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                                加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                        <!--right news-->
                        <div class="span6 news_block">
                            <div class="data_news">2015-09-01</div>
                            <div class="post">为确保抗日战争既世界反法西斯战争70周年重大活动，公安部、邮政局和有关部门决定。联合下发通知
                                加强寄递物品管理，管制刀具无法发货。百年蔷薇五件套活动暂停。恢复后汇尽快通知大家...</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bg_bottom"></div>
        </div>

    </div>

   
    <!--contant_two_page-->
    <div class="flag" id="Our_story"></div>
    <div class="fulli_page">
        <div class="container page_bg">
            <div class="row">
                <div class="span12 tittle_page">
                    <h1 class="tittle">给我们留言</h1>
                </div>
                <div class="span12 love_badge">
                    <img src="img/love.png" alt=""/>
                </div>
                       <div style="width: 60%;margin-left: auto;margin-right: auto">
                                <input type="text" class="form-control" placeholder="您的姓名">
                                <input type="text" class="form-control" placeholder="您的电话">
                                <input type="text" style="height: 100px" class="form-control" placeholder="您的留言">
                                <button style="text-align: center" type="button" class="btn btn-primary">提交您的留言</button>
                       </div>
            </div>
            <div class="bg_bottom"></div>
        </div>
    </div>

    
       

   


    <div class="container">
        <div class="row">

            <div class="span12 love_badge copy">
                <a href="#home">
                    <img src="img/copiright.png"  alt=""/></a>
            </div>
            <div align="center">关于零元汇｜联系我们</div>
			<div align="center">copy right&copy;版权归零元汇所有</div>
        </div>
    </div>
    <script type="text/javascript" src="login/js/jquery.form.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $('.lightbox').lightbox();
        });
</script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('a[href^="#"]').bind('click.smoothscroll', function (e) {
                e.preventDefault();

                var target = this.hash,
                $target = $(target);

                $('html, body').stop().animate({
                    'scrollTop': $target.offset().top
                }, 900, 'swing', function () {
                    window.location.hash = target;
                });
            });

        });
</script>
    <!--Scripr for menu responsive work-->

    <script>
        $("nav select").change(function () {
            window.location = $(this).find("option:selected").val();
        });
</script>
</body>
<script type="text/javascript" >
	
		function getFocus(){
			document.getElementById("username").focus();
		 }
		function login(){
		    var name = document.getElementById("username").value.replace(/(^\s*)|(\s*$)/g, "");
			if(name == ""){
		     	alert("请输入用户名称!");
		     	document.getElementById("username").focus();
		     	return false;
			}
			
		    var password = document.getElementById("password").value.replace(/(^\s*)|(\s*$)/g, "");
			if(password == ""){
		     	alert("请输入用户密码!");
		     	document.getElementById("password").focus();
		     	return false;
		     	
			}
		    /*var inputValidateCode = document.forms[0].validateCode.value.replace(/(^\s*)|(\s*$)/g, "");
			if(inputValidateCode == ""){
		     	alert("请输入验证码!");
			  	document.getElementsByName("validateCode")[0].focus();
		     	return false;
			}*/
		}
		
		function refresh1(obj){
				nowTime = new Date();
		    	obj.src="<%=context%>/getpicservlet?validSession=1&r="+nowTime;
		    }
</script>

</html>
