<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Thẻ ghi nhớ </title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="styleSheet" href="../Style/FlipCard.css">
    <script src="https://kit.fontawesome.com/b220baa0bb.js" crossorigin="anonymous"></script>
</head>

<body style="background-color: #f6f7fb;">
<%@include file="Share/HeaderForLogged.jsp"%>
    <div class="container">
        <div class="row pt-5">
            <div class="col-lg-9 col-md-12 pt-5">
                <!-- Title -->
                <div class="row pb-3">
                    <div class="col-10">
                        <h3>READING</h3> <br>
                    </div>
                    <div class="col-2 ">
                        <div class="p-2 bg-white text-center shadow-sm bg-body rounded" role="button"> 
                        <i class="fa-solid fa-arrow-up-from-bracket" style="color: #d97726;"></i>
                        <span class="fs-5 ps-2"> Share</span>
                    </div>
                    </div>
                </div>
                <!-- End title -->

                <!-- Start button option -->
                <div class="row">
                    <div class="col">
                        <div class="d-flex justify-content-between ">
                            <div class="shadow-sm  bg-body rounded">
                                <a href="google.com">
                                    <li class="col d-flex ">
                                        <h5 style="color: #bd7828;">
                                            <div class="bg-white p-3 rounded"> <span class="pe-3"><i
                                                        class="fa-solid fa-brain fa-beat-fade"
                                                        ></i>
                                                </span>Thẻ ghi nhớ</div>
                                        </h5>
                                    </li>
                                </a>
                            </div>
                            <div class="shadow-sm  bg-body rounded">
                                <a href="google.com">
                                    <li class="col d-flex ">
                                        <h5 style="color: #bd7828;">
                                            <div class="bg-white p-3 rounded"><span class="pe-3">
                                                <i class="fa-solid fa-swatchbook fa-beat"></i></span> Học</div>
                                        </h5>

                                    </li>
                                </a>
                            </div>
                            <div class="shadow-sm  bg-body rounded">
                                <a href="google.com">
                                    <li class="col d-flex ">
                                        <h5 style="color: #bd7828;">
                                            <div class="bg-white p-3 rounded"><span class="pe-3"><i
                                                        class="fa-regular fa-circle-check fa-beat"></i></span> Trắc nghiệm</div>
                                        </h5>
                                    </li>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End button option -->

                <!-- Start flip card -->
                <div class="row">
                    <div class="col">
                    <div class="row">
                        <div class="flip-card col-12 border-0 ">
                            <div class="flip-card-inner shadow bg-body rounded" id="card">
                                <div class="flip-card-front rounded">
                                    <h2>Phuoc</h2>
                                </div>
                                <div class="flip-card-back shadow rounded">
                                    <h2>Phuoc</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Start footer card -->
                    <div class="row d-flex justify-content-between pt-4 pb-4">
                        <div class="col-3  d-flex ps-5">
                            <div class="pe-4" role="button"><i class="fa-solid fa-play pe-auto" style="font-size: 30px; color: #586380;"></i></div>
                            <div role="button"><i class="fa-solid fa-shuffle" style="font-size: 30px; color: #586380;"></i></div>
                        </div> 
                        <div class="col-3  d-flex align-items-center">
                            <span role="button"><i class="fa-solid fa-arrow-left" style="font-size: 40px; color: #586380;"></i></span>
                            <span class="text-center fs-4 ps-3 pe-3" >100/100</span>
                            <span role="button"><i class="fa-solid fa-arrow-right" style="font-size: 40px; color: #586380;"></i></span>
                        </div>
                        <div class="col-3  d-flex">
                            <span><i class="fa-solid fa-gear pe-4 ps-5" style="font-size: 30px; color: #586380;" role="button"></i></span>
                            <span><i class="fa-solid fa-expand" style="font-size: 30px; color: #586380;" role="button"></i></span>
                        </div>

                    </div>
                    <!-- End footer card -->
                </div>
                </div>
                <!-- End flip card -->

                <!-- Start info author -->
                <div class="row border-top">
                    <div class="col-12 d-flex justify-content-between mt-2 p-3">
                        <div class="d-flex align-items-center">
                            <img class="rounded-circle me-4" width="60px" src="https://www.analyticsdistrict.com.sg/img/containers/assets/images/profile-images/leezhihuiavatar.png/f17ff8108bc89ae059911e06de23a745.png">
                            <div class="d-flex flex-column ">
                                <span>Tạo bởi</span>
                                <span class="fs-5"> <b>Your Name</b></span>
                            </div>
                        </div>
                        <div class="d-flex">
                            <span role="button"><i class="fa-solid fa-pen pe-4" style="font-size: 30px; color: #586380;"></i></span>
                            <span role="button"><i class="fa-solid fa-ellipsis" style="font-size: 30px;color: #586380;"></i></span>
                        </div>

                    </div>
                </div>
                <!-- End info author -->
                <!-- Start collection detail -->
                <div class="row">
                    <div class="col">
                        <!-- info colletion -->
                        <div class="row ">
                            <div class="col d-flex justify-content-between ">
                                <div>
                                    <h2>Thuật ngữ trong phần này (XX)</h2>
                                </div>
                                <div class="dropdown">
                                    <button class="btn btn-secondary dropdown-toggle" type="button"
                                        id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                        Thông số của bạn
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                        <li><a class="dropdown-item" href="#">Thứ tự gốc</a></li>
                                        <li><a class="dropdown-item" href="#">Bảng chữ cái</a></li>
                                        <li><a class="dropdown-item" href="#">Quá trình học</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- info option -->
                        <div class="row">
                            <div class="col">
                                <div class="pt-4"> <h2 style="color: #fd993a;">Đang học (XX)</h2></div>
                                <div><h5>Bạn đã bắt đầu học những thuật ngữ này. Tiếp tục phát huy nhé! </h5></div>

                            </div>
                        </div>
                        <!-- list card  -->
                        <div class="row">
                            <div class="col">
                            <% for (int i=0;i<10;i++){ %>
                                <div class="card mt-3 rounded shadow-sm ">
                                    <div class="card-body">
                                        <div class="row ">
                                            <div class="col-4"> front</div>
                                            <div class="col-4">Bakc</div>
                                            <div class="col-4   text-end">
                                                <span role="button"><i class="fa-solid fa-star pe-4" style="font-size: 25px; color: #586380;"></i></span>
                                                <span role="button"><i class="fa-solid fa-pen" style="font-size: 25px; color: #586380;"></i></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%} %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        var fr = document.getElementById("card");
        fr.addEventListener('click', function () {
            fr.classList.toggle('flip')
        })
    </script>
    <div class="border-top mt-5 pt-5">
    <%@include file="Share/FooterSimple.jsp"%>
    </div>
</body>

</html>