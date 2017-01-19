<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Free Wedding Day Website Template | Home :: w3layouts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/css/style.css"
          rel="stylesheet"
          type="text/css"
          media="all"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery.openCarousel.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/slider.css"
          type="text/css"
          media="screen"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery.nivo.slider.js"></script>
    <script type="text/javascript">
        $(window).load(function () {
            $('#slider').nivoSlider();
        });
    </script>
</head>
<body>

<div class="header">
    <div class="header_wrapper">
        <div class="wrap">
            <%--<div class="header_top">--%>
                <%--<div class="logo">--%>
                    <%--<a href="index.jsp">--%>
                        <%--<img src="images/logo.png" alt=""/>--%>
                    <%--</a>--%>
                <%--</div>--%>
                <%--<div class="clear"></div>--%>
            <%--</div>--%>
            <div class="menu">
                <ul>
                    <li><a href="index.jsp">婚礼主页</a></li>
                    <li><a href="gallery.html">自拍抽奖</a></li>
                    <li><a href="blog.html">照片一览</a></li>
                    <li><a href="services.html">祝福语一览</a></li>
                    <div class="clear"></div>
                </ul>
                <span class="left-ribbon"> </span>
                <span class="right-ribbon"> </span>
            </div>
        </div>
    </div>
    <div class="header_bottom">
        <div class="wrap">
            <div class="slider">
                <div class="slider-wrapper theme-default">
                    <div id="slider" class="nivoSlider">
                        <img
                                src="${pageContext.request.contextPath}/images/1.JPG"
                             data-thumb="images/1.jpg" alt=""/>
                        <img
                                src="${pageContext.request.contextPath}/images/2.JPG"
                             data-thumb="images/2.jpg" alt=""/>
                        <img
                                src="${pageContext.request.contextPath}/images/3.JPG"
                             data-thumb="images/slider-3.jpg" alt=""/>
                        <img
                                src="${pageContext.request.contextPath}/images/4.JPG"
                             data-thumb="images/slider-4.jpg" alt=""/>
                        <img
                                src="${pageContext.request.contextPath}/images/5.JPG"
                                data-thumb="images/slider-4.jpg" alt=""/>
                        <img
                                src="${pageContext.request.contextPath}/images/6.JPG"
                                data-thumb="images/slider-4.jpg" alt=""/>
                        <img
                                src="${pageContext.request.contextPath}/images/7.JPG"
                                data-thumb="images/slider-4.jpg" alt=""/>
                        <img
                                src="${pageContext.request.contextPath}/images/8.JPG"
                                data-thumb="images/slider-4.jpg" alt=""/>
                    </div>
                </div>
            </div>
            <!--- End Slider --->
        </div>
    </div>
</div>
</body>
</html>

