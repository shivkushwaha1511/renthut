/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-05-13 14:45:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1620907350065L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1620917109979L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0,shrink-to-fit=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/common.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js\" integrity=\"sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <title>Renthut</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("    \t<div class=\"row\">\r\n");
      out.write("    \t\t<div class=\"col\" style=\"padding:0;\">  \r\n");
      out.write("\t\t\t    <div class=\"banner jumbotron jumbotron-fluid banner-img\">\r\n");
      out.write("\t\t\t    \t");
      out.write("    <div class=\"header\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col\" style=\"padding: 0;\">      \r\n");
      out.write("                    <div class=\"row fixed-top head-bg\">\r\n");
      out.write("                        <div class=\"col-4 pt-3 head-link\">\r\n");
      out.write("                                <a href=\"about.do\" class=\"text-white ml-5\">About Us</a>\r\n");
      out.write("                                <a href=\"contact.do\" class=\"text-white ml-3\">Contact Us</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-4 text-center py-2\">\r\n");
      out.write("                            <a href=\"/renthut\"><img src=\"static/images/logo.png\"></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-4 pt-3 head-link text-right\">\r\n");
      out.write("                            <a href=\"signin.do\" class=\"text-white mr-3\">Sign In</a>\r\n");
      out.write("                            <a href=\"signup.do\" class=\"text-white mr-3 pl-3 vl-head\">Sign Up</a>\r\n");
      out.write("                            <button class=\"btn head-btn text-white mr-4\">Add Listings</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>       \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>");
      out.write("\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("    <div class=\"footer text-white\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-3 my-5 ml-auto mr-auto \">\r\n");
      out.write("                            <div class=\"row pl-4\">\r\n");
      out.write("                                <h2 class=\"\">Contact Us</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row mt-3 pl-4\">\r\n");
      out.write("                                <i class=\"fa fa-map-marker\" style=\"font-size:30px;\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                <p class=\"ml-4\">Floor - 3,Behind Parijat Building,<br>damohnaka,jabalpur 482004</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row mt-1 pl-4\">\r\n");
      out.write("                                <i class=\"fa fa-phone\" style=\"font-size:30px;\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                <p class=\"ml-3\">+91-6958748596</p>\r\n");
      out.write("                            </div> \r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row mt-1 pl-4\">\r\n");
      out.write("                                <i class=\"fa fa-envelope\" style=\"font-size:30px;\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                <p class=\"ml-3\">contact@renthut.in</p>\r\n");
      out.write("                            </div>         \r\n");
      out.write("                        </div>\r\n");
      out.write("    \r\n");
      out.write("                        <div class=\"col-6 my-5 vl-foot\">\r\n");
      out.write("                            <div class=\"row ml-auto\">\r\n");
      out.write("                                <div class=\"ml-5 pl-5\">\r\n");
      out.write("                                    <h2 class=\"\">About Us</h2>\r\n");
      out.write("                                    <p class=\"mt-3\">RentHut is the platform that offers anyone, anywhere<br>access to search properties according to their needs<br> and a chance for Renters to rent their properties</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("    \r\n");
      out.write("                    <div class=\"row hl-foot mx-auto\">\r\n");
      out.write("                    </div>\r\n");
      out.write("    \r\n");
      out.write("                    <div class=\"row\" id=\"foot\">\r\n");
      out.write("                        <div class=\"col-7 mt-2\">\r\n");
      out.write("                            <p class=\"pl-4 font-weight-bold\"> &copy;2021 RentHut Inc. All rights reserved.</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-2 mt-1 ml-auto\">\r\n");
      out.write("                            <a href=\"\" class=\"text-white\"><i class=\"fa fa-facebook-official mr-1\" aria-hidden=\"true\" style=\"font-size:30px;\"></i></a>\r\n");
      out.write("                            <a href=\"\" class=\"text-white\"><i class=\"fa fa-twitter-square mr-1\" aria-hidden=\"true\" style=\"font-size:30px;\"></i></a>\r\n");
      out.write("                            <a href=\"\" class=\"text-white\"><i class=\"fa fa-instagram\" aria-hidden=\"true\" style=\"font-size:30px;\"></i></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
