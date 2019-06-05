<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentellela Alela! | </title>

    <link href="<%=basePath%>/statics/css/cssreset.css" rel="stylesheet"/>
    <!-- Bootstrap -->
    <link href="<%=basePath%>/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%=basePath%>/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="<%=basePath%>/statics/css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="<%=basePath%>/statics/css/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="<%=basePath%>/statics/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="<%=basePath%>/statics/css/jqvmap.min.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="<%=basePath%>/statics/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
          <%----------%>
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.jsp" class="site_title"><i class="fa fa-paw"></i> <span>APP BMS</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
                <img src="<%=basePath%>/statics/images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>John Doe</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> APP账户管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="index.jsp">Dashboard</a></li>
                      <li><a href="index2.html">Dashboard2</a></li>
                      <li><a href="index3.html">Dashboard3</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> APP应用管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form.html">APP维护</a></li>
                      <%--<li><a href="form_advanced.html">Advanced Components</a></li>--%>
                    </ul>
                  </li>

                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="<%=basePath%>/statics/images/img.jpg" alt="">John Doe
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">







          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel tile fixed_height_250">
                <div class="x_title">
                  <h2>App信息管理维护</h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <%--软件名称--%>
                  <div class="form-group" >
                    <label class="control-label col-md-1 col-sm-1 col-xs-2">软件名称</label>
                    <div class="col-md-2 col-sm-2 col-xs-4">
                      <input type="text" class="form-control" placeholder="" style="margin: 0">
                    </div>
                  </div>
                    <%--APP状态--%>
                    <div class="form-group">
                      <label class="control-label col-md-1 col-sm-1 col-xs-2">APP状态</label>
                      <div class="col-md-2 col-sm-2 col-xs-4">
                        <select class="form-control">
                          <option>Choose option</option>
                          <option>Option one</option>
                          <option>Option two</option>
                          <option>Option three</option>
                          <option>Option four</option>
                        </select>
                      </div>
                    </div>
                    <%--所属平台--%>
                    <div class="form-group">
                      <label class="control-label col-md-1 col-sm-1 col-xs-2">所属平台</label>
                      <div class="col-md-2 col-sm-2 col-xs-4">
                        <select class="form-control">
                          <option>Choose option</option>
                          <option>Option one</option>
                          <option>Option two</option>
                          <option>Option three</option>
                          <option>Option four</option>
                        </select>
                      </div>
                    </div>
                </div>
                  <div class="x_content">
                      <%--一级界面--%>
                          <div class="form-group">
                              <label class="control-label col-md-1 col-sm-1 col-xs-2">一级界面</label>
                              <div class="col-md-2 col-sm-2 col-xs-3">
                                  <select class="form-control">
                                      <option>Choose option</option>
                                      <option>Option one</option>
                                      <option>Option two</option>
                                      <option>Option three</option>
                                      <option>Option four</option>
                                  </select>
                              </div>
                          </div>
                      <%--二级界面--%>
                      <div class="form-group">
                          <label class="control-label col-md-1 col-sm-1 col-xs-2">二级界面</label>
                          <div class="col-md-2 col-sm-2 col-xs-3">
                              <select class="form-control">
                                  <option>Choose option</option>
                                  <option>Option one</option>
                                  <option>Option two</option>
                                  <option>Option three</option>
                                  <option>Option four</option>
                              </select>
                          </div>
                      </div>
                      <%--三级界面--%>
                      <div class="form-group">
                          <label class="control-label col-md-1 col-sm-1 col-xs-2">三级界面</label>
                          <div class="col-md-2 col-sm-2 col-xs-3">
                              <select class="form-control">
                                  <option>Choose option</option>
                                  <option>Option one</option>
                                  <option>Option two</option>
                                  <option>Option three</option>
                                  <option>Option four</option>
                              </select>
                          </div>
                      </div>
                  </div>
              </div>
            </div>



          </div>

        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            007 版权所有
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="<%=basePath%>/statics/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="<%=basePath%>/statics/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="<%=basePath%>/statics/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="<%=basePath%>/statics/js/nprogress.js"></script>



    <!-- bootstrap-daterangepicker -->
    <script src="<%=basePath%>/statics/js/moment/moment.min.js"></script>
    <script src="<%=basePath%>/statics/js/datepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="<%=basePath%>/statics/js/custom.min.js"></script>


    <!-- bootstrap-daterangepicker -->
    <script>
      $(document).ready(function() {

        var cb = function(start, end, label) {
          console.log(start.toISOString(), end.toISOString(), label);
          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        };

        var optionSet1 = {
          startDate: moment().subtract(29, 'days'),
          endDate: moment(),
          minDate: '01/01/2012',
          maxDate: '12/31/2015',
          dateLimit: {
            days: 60
          },
          showDropdowns: true,
          showWeekNumbers: true,
          timePicker: false,
          timePickerIncrement: 1,
          timePicker12Hour: true,
          ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          opens: 'left',
          buttonClasses: ['btn btn-default'],
          applyClass: 'btn-small btn-primary',
          cancelClass: 'btn-small',
          format: 'MM/DD/YYYY',
          separator: ' to ',
          locale: {
            applyLabel: 'Submit',
            cancelLabel: 'Clear',
            fromLabel: 'From',
            toLabel: 'To',
            customRangeLabel: 'Custom',
            daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
            monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
            firstDay: 1
          }
        };
        $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
        $('#reportrange').daterangepicker(optionSet1, cb);
        $('#reportrange').on('show.daterangepicker', function() {
          console.log("show event fired");
        });
        $('#reportrange').on('hide.daterangepicker', function() {
          console.log("hide event fired");
        });
        $('#reportrange').on('apply.daterangepicker', function(ev, picker) {
          console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
        });
        $('#reportrange').on('cancel.daterangepicker', function(ev, picker) {
          console.log("cancel event fired");
        });
        $('#options1').click(function() {
          $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
        });
        $('#options2').click(function() {
          $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
        });
        $('#destroy').click(function() {
          $('#reportrange').data('daterangepicker').remove();
        });
      });
    </script>
    <!-- /bootstrap-daterangepicker -->


  </body>
</html>
