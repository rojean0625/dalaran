<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<html>
<head>
<title>RojeanCapital</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="captial,rojean,A" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="${domain}/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${domain}/css/style.css" rel='stylesheet' type='text/css' />
<link href='${domain}/fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<link href='${domain}/fonts.googleapis.com/css?family=Cabin:400,700,500,600' rel='stylesheet' type='text/css'>
<link href='${domain}/fonts.googleapis.com/css?family=Pacifico|Prata' rel='stylesheet' type='text/css'>
<link href="${domain}/css/animate.min.css" rel="stylesheet">

<script type="text/javascript" src="${domain}/js/bootstrap.js"></script>
<script src="${domain}/js/jquery-1.11.1.min.js"></script>
<script src="${domain}/js/main.js"></script>
<script src="${domain}/js/wow.min.js"></script>
<script>
 new WOW().init();
</script>
<!-- //animation-effect -->
</head>
<body>
	<!--start-header-->
	<div class="top-bar w3agile-1" id="home">
				<div class="container">
					<div class="row">
						<div class="col-md-8 top-left wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
							<span class="phone">
								<i class="glyphicon glyphicon-phone"></i>
								<em>Tel.13810625541</em>
							</span>
							<span class="email">
								<i class="glyphicon glyphicon-send"></i>
								<em><a href="https://mail.com">chao.luo</a></em>
							</span>
							<span class="location">
										<i class="glyphicon glyphicon-map-marker"></i>
										   <em>BeiJing China</em>
							</span>
						</div>
						<div class="col-md-4 head-right wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".3s">
						   <ul class="top-icons">
									<li><a class="fb" href="#"></a></li>
									<li><a class="twitt" href="#"></a></li>
									<li><a class="goog" href="#"></a></li>
									<li><a class="drib" href="#"></a></li>
							   </ul>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
    </div>

<!-- //header -->
<!-- banner -->
	<div class="banner agileinfo-1">
		<div class="container">
			<div class="header"><!--header-->
				<nav class="navbar navbar-default">
					<div class="navbar-header wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<h1><a href="index.html">Rojean.Capital</a></h1>
					</div>
					<!--navbar-header-->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1 wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="index.html" class="active">主页</a></li>
							<li><a href="about.html">关于</a></li>
							<li><a href="services.html">服务</a></li>
							<li><a href="codes.html">产品</a></li>
							<li><a href="gallery.html">渠道</a></li>
							<li><a href="contact.html">线上内容</a></li>
						</ul>
						<div class="clearfix"> </div>
					</div>
				</nav>
			<div class="cd-main-header">
				<ul class="cd-header-buttons">
					<li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
				</ul> <!-- cd-header-buttons -->
			</div>
			<div id="cd-search" class="cd-search">
				<form action="#" method="post">
					<input name="Search" type="search" placeholder="Search...">
				</form>
			</div>
		</div>

		<div class="banner-info">
			<h2>为行业内提供专业的大数据支撑</h2>
			<p> when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
		</div>
		</div>
	</div>
<!-- //banner -->
<!-- agile -->
<div class="agile">
		<div class="container">
			<div class="col-md-6 agile-left wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
			<h3>Our Mission</h3>
			<div class="grid_3 grid_5">
				<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
							<a href="#expeditions" id="expeditions-tab" role="tab" data-toggle="tab" aria-controls="expeditions" aria-expanded="true">
							${pageInfo[0].titleInfo}
							</a>
						</li>
						<li role="presentation">
							<a href="#tours" role="tab" id="tours-tab" data-toggle="tab" aria-controls="tours">
							${pageInfo[1].titleInfo}
							</a>
						</li>
						<li role="presentation">
							<a href="#tree" role="tab" id="tree-tab" data-toggle="tab" aria-controls="tree">
							${pageInfo[2].titleInfo}
							</a>
						</li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="expeditions" aria-labelledby="expeditions-tab">
						<div class="tab-info">
								<p>${pageInfo[0].contentInfo}</p>
						</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tours" aria-labelledby="tours-tab">
							<div class="tab-info">
								<p>${pageInfo[1].contentInfo}</p>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="tree" aria-labelledby="tree-tab">
							<div class="tab-info">
								<p>${pageInfo[2].contentInfo}</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			</div>
			<div class="col-md-6 agile-right wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<ul>
					<li>
						<div class="list-img">
							<img src="${domain}/images/1.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
					<li>
						<div class="list-img">
							<img src="${domain}/images/2.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
					<li>
						<div class="list-img">
							<img src="${domain}/images/3.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
					<li>
						<div class="list-img">
							<img src="${domain}/images/4.jpg" class="img-responsive" alt=" ">
							<div class="textbox"></div>
						</div>
					</li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
<!-- //agile -->
<!-- count -->
<div class="count w3-1">
		<div class="container">
			<div class="col-md-4 agile_count_grid wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
				<div class="agile_count_grid_left">
					<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
				</div>
				<div class="agile_count_grid_right">
					<p class="counter">327</p>
				</div>
				<div class="clearfix"> </div>
				<h3>Our Design</h3>
				<ul class="award">
					<li><a href="#">Sed ut perspiciatis unde omnis iste </a></li>
					<li><a href="#">veritatis quasi architecto beatae vitae</a></li>
					<li><a href="#">Nemo enim ipsam voluptatem quia voluptas</a></li>
					<li><a href="#">Neque porro quisquam est, qui dolorem</a></li>
					<li><a href="#">Ut enim ad minima veniam, quis nostrum</a></li>
					<li><a href="#">Duis aute irure dolor reprehenderit velit</a></li>
				</ul>
			</div>
			<div class="col-md-4 agile_count_grid wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
				<div class="agile_count_grid_left">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				</div>
				<div class="agile_count_grid_right">
					<p class="counter">542</p>
				</div>
				<div class="clearfix"> </div>
				<h3>Target Audience</h3>
				<ul class="award">
					<li><a href="#">Sed ut perspiciatis unde omnis iste </a></li>
					<li><a href="#">veritatis quasi architecto beatae vitae</a></li>
					<li><a href="#">Nemo enim ipsam voluptatem quia voluptas</a></li>
					<li><a href="#">Neque porro quisquam est, qui dolorem</a></li>
					<li><a href="#">Ut enim ad minima veniam, quis nostrum</a></li>
					<li><a href="#">Duis aute irure dolor reprehenderit velit</a></li>
				</ul>
			</div>
			<div class="col-md-4 agile_count_grid wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<div class="agile_count_grid_left">
					<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
				</div>
				<div class="agile_count_grid_right">
					<p class="counter">414</p>
				</div>
				<div class="clearfix"> </div>
				<h3>Notable Awards</h3>
					<ul class="award">
						<li><a href="#">Sed ut perspiciatis unde omnis iste </a></li>
						<li><a href="#">veritatis quasi architecto beatae vitae</a></li>
						<li><a href="#">Nemo enim ipsam voluptatem quia voluptas</a></li>
						<li><a href="#">Neque porro quisquam est, qui dolorem</a></li>
						<li><a href="#">Ut enim ad minima veniam, quis nostrum</a></li>
						<li><a href="#">Duis aute irure dolor reprehenderit velit</a></li>
					</ul>
			</div>

			<div class="clearfix"> </div>
				<!-- Starts-Number-Scroller-Animation-JavaScript -->
					<script src="js/waypoints.min.js"></script>
					<script src="js/counterup.min.js"></script>
					<script>
						jQuery(document).ready(function( $ ) {
							$('.counter').counterUp({
								delay: 20,
								time: 1000
							});
						});
					</script>
				<!-- //Starts-Number-Scroller-Animation-JavaScript -->
		</div>
	</div>
<!-- //count -->
<!-- wthree -->
	<div class="wthree wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
		<div class="container">

			<!-- Slider3 -->
			<div class="slider3">
			<div class="ba-im">
				<ul class="rslides" id="slider3">
					<li>
						<div class="ba-1">
							<p>Exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
							<img src="${domain}/images/t1.jpg" class="img-responsive" alt="Hitech Info">

						</div>

					</li>
					<li>
						<div class="ba-1">
						<p>Exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
							<img src="${domain}/images/t2.jpg" class="img-responsive" alt="Hitech Info">


						</div>

					</li>
					<li>
						<div class="ba-1">
						<p>Exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
							<img src="${domain}/images/t3.jpg" class="img-responsive" alt="Hitech Info">

						</div>

					</li>
					<li>
						<div class="ba-1">
						<p>Exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
							<img src="${domain}/images/t4.jpg" class="img-responsive" alt="Hitech Info">

						</div>

					</li>

				</ul>
				</div>
			</div>
			<!-- //Slider3 -->

			<!-- Slider-JavaScript -->
			<script src="js/responsiveslides.min.js"></script>
			<script>
				$(function () {
					$("#slider1, #slider2, #slider3").responsiveSlides({
						auto: true,
						nav: true,
						speed: 1500,
						namespace: "callbacks",
						pager: true,
					});
				});
			</script>
		<!-- //Slider-JavaScript -->

		</div>
	</div>
<!-- newsletter -->
	<div class="newsletter wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
		<div class="container">
		<h3>News Letter</h3>
			<form action="#" method="post">
				<input type="text" name="Name/åå­" value="Name/åå­" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
				<input type="email" name="Phone/èç»æ¹å¼" value="Phone/èç»æ¹å¼" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
				<input type="submit" value="èç³»æä»¬">
			</form>
		</div>
	</div>
<!-- /newsletter -->
<div class="feature">
	<div class="container">
		<h3 class="tit">æªæ¥æ¿æ¯</h3>
		<div class="feature-grids">
			<div class="col-md-3 feature-grid text-center wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-pencil"> </a>
					<h4>Placeat Facere</h4>
					<p> Nemo enim ipsam voluptatem
						quia voluptas sit aspernatur aut
						odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-3 feature-grid text-center wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-user"> </a>
					<h4>Quia Voluptas</h4>
					<p> Nemo enim ipsam voluptatem
						quia voluptas sit aspernatur aut
						odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-3 feature-grid text-center wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-star"> </a>
					<h4>Sit Spernatur</h4>
					<p> Nemo enim ipsam voluptatem
						quia voluptas sit aspernatur aut
						odit aut fugi.</p>
				</div>
			</div>
			<div class="col-md-3 feature-grid text-center wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
				<div class="feature-grid-two">
					<a href="#" class="hi-icon hi-icon-archive glyphicon glyphicon-map-marker"> </a>
					<h4>Autodit Fugi</h4>
					<p> Nemo enim ipsam voluptatem
						quia voluptas sit aspernatur aut
						odit aut fugi.</p>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- /w3ls -->
	<div class="w3ls">
	<div class="container">
	<div class="col-md-4 w3ls-right wow fadeInLeft animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
			<h3>Contact Us</h3>
				<p class="para">Corrupti quos dolores et quas molestias excepturi .</p>
			<ul class="con-icons">
				<li><span class="glyphicon glyphicon-phone" aria-hidden="true"></span>+123 456 7890</li>
				<li><a href="mailto:info@example.com"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>info@example.com</a></li>
				<li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>London, Jasmin Road</li>

			</ul>


		</div>
		<div class="col-md-4 w3ls-left wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
			<h3>Information</h3>

			<p class="para">At vero eos et accusamus et iusto odio dignissimos
			ducimus qui blanditiis praesentium voluptatum deleniti at
			que corrupti quos dolores et quas molestias excepturi sint
			occaecati cupiditate non provident, similique sunt.</p>

		</div>
		<div class="col-md-4 w3ls-right wow fadeInRight animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInRight;">
			<h3>Follow Us</h3>

			<p class="para">voluptatum deleniti at
			que corrupti quos dolores et quas molestias excepturi sint
			occaecati cupiditate non provident, similique sunt.</p>
			<ul class="fb_icons">
				<li class="hvr-rectangle-out"><a class="fb" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="twit" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="goog" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="pin" href="#"></a></li>
				<li class="hvr-rectangle-out"><a class="drib" href="#"></a></li>
			</ul>
		</div>

		<div class="clearfix"></div>
		<p class="copy-right wow fadeInUp animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">© 2017 Rojean. All rights reserved | Design by <a href="#">chao.luo</a></p>

	</div>
</div>
</body>
</html>