<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
	
  String employee_id = (String)session.getAttribute("employee_id");
  if (employee_id.equals("")) response.sendRedirect("http://localhost:8080/SD/pages/signin.html");
  String employee_type = (String)session.getAttribute("employee_type");
  String employee_name = (String)session.getAttribute("employee_name");
  
  ServletContext sc = getServletContext();
  if (employee_type.equals("3")) sc.getRequestDispatcher("/pages/index.jsp").forward(request, response);

%>

<!DOCTYPE html>
<html lang="en">
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/daisyui@1.14.0/dist/full.css"
      rel="stylesheet"
      type="text/css"
    />
    <title>従業員登録</title>
  </head>
  <body>
    <form action="/SD/servlet/employee_regist" method="POST">
      <div class="flex flex-col w-full h-screen scroll-none">
        <header class="w-full bg-blue-400 py-4 border-b border-gray-200">
          <h1 class="text-2xl pl-8 font-bold text-white">カラオケシステム</h1>
        </header>

        <div class="flex flex-1 w-full bg-gray-100">
          <nav class="w-1/6 min-w-max border-r border-gray-200">
            <div class="flex flex-col gap-2 p-4">
              <a
                href="/SD/pages/index.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                ホーム
              </a>
              <a
                href="/SD/pages/shift_join.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                出勤登録
              </a>
              <a
                href="/SD/pages/shift_leaving.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                退勤登録
              </a>
              <a
                href="/SD/pages/shift_list.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                シフト一覧
              </a>
              <a
                href="/SD/pages/shift_regist.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                シフト登録
              </a>
              <a
                href="/SD/pages/employee_list.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                従業員一覧
              </a>

              <% if (employee_type.equals("1") || employee_type.equals("2")) { %>
                <a
                  href="/SD/pages/employee_regist.jsp"
                  class="py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full"
                >
                  従業員登録
                </a>
              <% } %>

              <hr class="text-gray-300">
              
              <a
                href="/SD/pages/signout.jsp"
                class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
              >
                サインアウト
              </a>
            </div>
          </nav>

          <main class="flex flex-1 flex-col items-center pb-40 overflow-scroll">
            <div class="flex flex-col gap-2 w-2/3 max-w-lg">
              <h1
                class="
                  pt-8
                  text-center text-2xl
                  md:text-3xl
                  font-medium
                  text-gray-800
                "
              >
                従業員登録
              </h1>

              <label for="employee_name" class="pl-1 text-gray-600"
                >従業員氏名</label
              >
              <input
                id="employee_name"
                type="text"
                name="EMPLOYEE_NAME"
                value=""
                class="input input-info input-bordered w-full"
              />

              <label for="employee_name_sub" class="pl-1 text-gray-600"
                >従業員氏名（カナ）</label
              >
              <input
                id="employee_name_sub"
                type="text"
                name="EMPLOYEE_NAME_SUB"
                value=""
                class="input input-info input-bordered w-full"
              />

              <label for="birthday_year" class="pl-1 text-gray-600"
                >生年月日</label
              >
              <div class="flex items-center">
                <input
                  id="birthday_year"
                  type="number"
                  name="BIRTHDAY_YEAR"
                  value=""
                  class="input input-info input-bordered w-full"
                />
                <label for="birthday_year" class="px-2 text-gray-600">年</label>

                <input
                  id="birthday_month"
                  type="number"
                  name="BIRTHDAY_MONTH"
                  value=""
                  class="input input-info input-bordered w-full"
                />
                <label for="birthday_month" class="px-2 text-gray-600"
                  >月</label
                >

                <input
                  id="birthday_day"
                  type="number"
                  name="BIRTHDAY_DAY"
                  value=""
                  class="input input-info input-bordered w-full"
                />
                <label for="birthday_day" class="px-2 text-gray-600">日</label>
              </div>

              <label for="employee_gender" class="pl-1 text-gray-600"
                >性別</label
              >
              <select
                id="employee_gender"
                name="EMPLOYEE_GENDER"
                class="select select-info select-bordered w-full"
              >
                <option selected disabled>性別を選択してください</option>
                <option value="1">男</option>
                <option value="2">女</option>
                <option value="3">その他</option>
              </select>

              <label for="employee_zipcode" class="pl-1 text-gray-600"
                >郵便番号</label
              >
              <input
                id="employee_zipcode"
                type="number"
                name="EMPLOYEE_ZIPCODE"
                value=""
                class="input input-info input-bordered w-full"
              />

              <label for="employee_address" class="pl-1 text-gray-600"
                >住所</label
              >
              <input
                id="employee_address"
                type="text"
                name="EMPLOYEE_ADDRESS"
                value=""
                class="input input-info input-bordered w-full"
              />

              <label for="employee_phone" class="pl-1 text-gray-600"
                >電話番号</label
              >
              <input
                id="employee_phone"
                type="text"
                name="EMPLOYEE_PHONE"
                value=""
                class="input input-info input-bordered w-full"
              />

              <label for="employee_email" class="pl-1 text-gray-600"
                >メールアドレス</label
              >
              <input
                id="employee_email"
                type="email"
                name="EMPLOYEE_EMAIL"
                value=""
                class="input input-info input-bordered w-full"
              />

              <label for="employee_password" class="pl-1 text-gray-600"
                >パスワード</label
              >
              <input
                id="employee_password"
                type="password"
                name="EMPLOYEE_PASSWORD"
                value=""
                class="input input-info input-bordered w-full"
              />

              <label for="employee_type" class="pl-1 text-gray-600"
                >従業員タイプ</label
              >
              <select
                id="employee_type"
                name="EMPLOYEE_TYPE"
                class="select select-info select-bordered w-full"
              >
                <option selected disabled>
                  従業員タイプを選択してください
                </option>
                <option value="1">店長</option>
                <option value="2">正社員</option>
                <option value="3">アルバイト</option>
              </select>

              <label for="birthday_year" class="pl-1 text-gray-600"
                >入社年月日</label
              >
              <div class="flex items-center">
                <input
                  id="company_join_yaer"
                  type="number"
                  name="COMPANY_JOIN_YEAR"
                  value=""
                  class="input input-info input-bordered w-full"
                />
                <label for="company_join_yaer" class="px-2 text-gray-600"
                  >年</label
                >

                <input
                  id="company_join_month"
                  type="number"
                  name="COMPANY_JOIN_MONTH"
                  value=""
                  class="input input-info input-bordered w-full"
                />
                <label for="company_join_month" class="px-2 text-gray-600"
                  >月</label
                >

                <input
                  id="company_join_day"
                  type="number"
                  name="COMPANY_JOIN_DAY"
                  value=""
                  class="input input-info input-bordered w-full"
                />
                <label for="company_join_day" class="px-2 text-gray-600"
                  >日</label
                >
              </div>

              <button
                class="
                  w-full
                  mx-auto
                  text-white
                  bg-blue-500
                  border-0
                  py-3
                  px-8
                  mt-4
                  focus:outline-none
                  hover:bg-blue-600
                  text-lg
                  rounded-full
                "
              >
                登録
              </button>
            </div>
          </main>
        </div>
      </div>
    </form>
  </body>
</html>

<style>
  .scroll-none {
    overflow-y: scroll;
    -ms-overflow-style: none; /* IE, Edge 対応 */
    scrollbar-width: none; /* Firefox 対応 */
  }
  .scroll-none::-webkit-scrollbar {
    /* Chrome, Safari 対応 */
    display: none;
  }

  input[type="number"]::-webkit-outer-spin-button,
  input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
  }
  input[type="number"] {
    -moz-appearance: textfield;
  }
</style>
